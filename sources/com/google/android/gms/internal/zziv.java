package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.appdatasearch.UsageInfo;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndexApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class zziv implements com.google.android.gms.appdatasearch.zzk, AppIndexApi {

    @Deprecated
    private static final class zza implements AppIndexApi.ActionResult {
        private zziv zzNS;
        private PendingResult<Status> zzNT;
        private Action zzNU;

        zza(zziv zzivVar, PendingResult<Status> pendingResult, Action action) {
            this.zzNS = zzivVar;
            this.zzNT = pendingResult;
            this.zzNU = action;
        }

        @Override // com.google.android.gms.appindexing.AppIndexApi.ActionResult
        public PendingResult<Status> end(GoogleApiClient googleApiClient) {
            return this.zzNS.zza(googleApiClient, zziu.zza(this.zzNU, System.currentTimeMillis(), googleApiClient.getContext().getPackageName(), 2));
        }

        @Override // com.google.android.gms.appindexing.AppIndexApi.ActionResult
        public PendingResult<Status> getPendingResult() {
            return this.zzNT;
        }
    }

    private static abstract class zzb<T extends Result> extends zza.AbstractC0035zza<T, zzit> {
        public zzb(GoogleApiClient googleApiClient) {
            super(com.google.android.gms.appdatasearch.zza.zzMO, googleApiClient);
        }

        protected abstract void zza(zziq zziqVar) throws RemoteException;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
        public final void zza(zzit zzitVar) throws RemoteException {
            zza(zzitVar.zzkO());
        }
    }

    private static abstract class zzc<T extends Result> extends zzb<Status> {
        zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.AbstractPendingResult
        /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public Status createFailedResult(Status status) {
            return status;
        }
    }

    private static final class zzd extends zzis<Status> {
        public zzd(zza.zzb<Status> zzbVar) {
            super(zzbVar);
        }

        @Override // com.google.android.gms.internal.zzis, com.google.android.gms.internal.zzir
        public void zza(Status status) {
            this.zzNO.zzm(status);
        }
    }

    public static Intent zza(String str, Uri uri) {
        zzb(str, uri);
        List<String> pathSegments = uri.getPathSegments();
        String str2 = pathSegments.get(0);
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(str2);
        if (pathSegments.size() > 1) {
            builder.authority(pathSegments.get(1));
            for (int i = 2; i < pathSegments.size(); i++) {
                builder.appendPath(pathSegments.get(i));
            }
        }
        builder.encodedQuery(uri.getEncodedQuery());
        builder.encodedFragment(uri.getEncodedFragment());
        return new Intent("android.intent.action.VIEW", builder.build());
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, Action action, int i) {
        return zza(googleApiClient, zziu.zza(action, System.currentTimeMillis(), googleApiClient.getContext().getPackageName(), i));
    }

    private static void zzb(String str, Uri uri) {
        if (!"android-app".equals(uri.getScheme())) {
            throw new IllegalArgumentException("AppIndex: The URI scheme must be 'android-app' and follow the format (android-app://<package_name>/<scheme>/[host_path]). Provided URI: " + uri);
        }
        String host = uri.getHost();
        if (str != null && !str.equals(host)) {
            throw new IllegalArgumentException("AppIndex: The URI host must match the package name and follow the format (android-app://<package_name>/<scheme>/[host_path]). Provided URI: " + uri);
        }
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.isEmpty() || pathSegments.get(0).isEmpty()) {
            throw new IllegalArgumentException("AppIndex: The app URI scheme must exist and follow the format android-app://<package_name>/<scheme>/[host_path]). Provided URI: " + uri);
        }
    }

    public static void zzi(List<AppIndexApi.AppIndexingLink> list) {
        if (list == null) {
            return;
        }
        Iterator<AppIndexApi.AppIndexingLink> it = list.iterator();
        while (it.hasNext()) {
            zzb(null, it.next().appIndexingUrl);
        }
    }

    @Override // com.google.android.gms.appindexing.AppIndexApi
    public AppIndexApi.ActionResult action(GoogleApiClient googleApiClient, Action action) {
        return new zza(this, zza(googleApiClient, action, 1), action);
    }

    @Override // com.google.android.gms.appindexing.AppIndexApi
    public PendingResult<Status> end(GoogleApiClient googleApiClient, Action action) {
        return zza(googleApiClient, action, 2);
    }

    @Override // com.google.android.gms.appindexing.AppIndexApi
    public PendingResult<Status> start(GoogleApiClient googleApiClient, Action action) {
        return zza(googleApiClient, action, 1);
    }

    @Override // com.google.android.gms.appindexing.AppIndexApi
    public PendingResult<Status> view(GoogleApiClient googleApiClient, Activity activity, Intent intent, String str, Uri uri, List<AppIndexApi.AppIndexingLink> list) {
        String packageName = googleApiClient.getContext().getPackageName();
        zzi(list);
        return zza(googleApiClient, new UsageInfo(packageName, intent, str, uri, null, list, 1));
    }

    @Override // com.google.android.gms.appindexing.AppIndexApi
    public PendingResult<Status> view(GoogleApiClient googleApiClient, Activity activity, Uri uri, String str, Uri uri2, List<AppIndexApi.AppIndexingLink> list) {
        String packageName = googleApiClient.getContext().getPackageName();
        zzb(packageName, uri);
        return view(googleApiClient, activity, zza(packageName, uri), str, uri2, list);
    }

    @Override // com.google.android.gms.appindexing.AppIndexApi
    public PendingResult<Status> viewEnd(GoogleApiClient googleApiClient, Activity activity, Intent intent) {
        return zza(googleApiClient, new UsageInfo.zza().zza(UsageInfo.zza(googleApiClient.getContext().getPackageName(), intent)).zzw(System.currentTimeMillis()).zzal(0).zzam(2).zzkN());
    }

    @Override // com.google.android.gms.appindexing.AppIndexApi
    public PendingResult<Status> viewEnd(GoogleApiClient googleApiClient, Activity activity, Uri uri) {
        return viewEnd(googleApiClient, activity, zza(googleApiClient.getContext().getPackageName(), uri));
    }

    public PendingResult<Status> zza(GoogleApiClient googleApiClient, final UsageInfo... usageInfoArr) {
        final String packageName = googleApiClient.getContext().getPackageName();
        return googleApiClient.zza((GoogleApiClient) new zzc<Status>(googleApiClient) { // from class: com.google.android.gms.internal.zziv.1
            @Override // com.google.android.gms.internal.zziv.zzb
            protected void zza(zziq zziqVar) throws RemoteException {
                zziqVar.zza(new zzd(this), packageName, usageInfoArr);
            }
        });
    }
}
