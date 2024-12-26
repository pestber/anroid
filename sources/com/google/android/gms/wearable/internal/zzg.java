package com.google.android.gms.wearable.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.CapabilityApi;
import com.google.android.gms.wearable.CapabilityInfo;
import com.google.android.gms.wearable.Node;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class zzg implements CapabilityApi {

    private static final class zza extends com.google.android.gms.wearable.internal.zzf<Status> {
        private CapabilityApi.CapabilityListener zzaTC;
        private String zzaTD;

        private zza(GoogleApiClient googleApiClient, CapabilityApi.CapabilityListener capabilityListener, String str) {
            super(googleApiClient);
            this.zzaTC = capabilityListener;
            this.zzaTD = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
        public void zza(zzbk zzbkVar) throws RemoteException {
            zzbkVar.zza(this, this.zzaTC, this.zzaTD);
            this.zzaTC = null;
            this.zzaTD = null;
        }

        @Override // com.google.android.gms.common.api.AbstractPendingResult
        /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public Status createFailedResult(Status status) {
            this.zzaTC = null;
            this.zzaTD = null;
            return status;
        }
    }

    public static class zzb implements CapabilityApi.AddLocalCapabilityResult, CapabilityApi.RemoveLocalCapabilityResult {
        private final Status zzOt;

        public zzb(Status status) {
            this.zzOt = status;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzOt;
        }
    }

    public static class zzc implements CapabilityInfo {
        private final String mName;
        private final Set<Node> zzaTE;

        public zzc(CapabilityInfo capabilityInfo) {
            this(capabilityInfo.getName(), capabilityInfo.getNodes());
        }

        public zzc(String str, Set<Node> set) {
            this.mName = str;
            this.zzaTE = set;
        }

        @Override // com.google.android.gms.wearable.CapabilityInfo
        public String getName() {
            return this.mName;
        }

        @Override // com.google.android.gms.wearable.CapabilityInfo
        public Set<Node> getNodes() {
            return this.zzaTE;
        }
    }

    public static class zzd implements CapabilityApi.GetAllCapabilitiesResult {
        private final Status zzOt;
        private final Map<String, CapabilityInfo> zzaTF;

        public zzd(Status status, Map<String, CapabilityInfo> map) {
            this.zzOt = status;
            this.zzaTF = map;
        }

        @Override // com.google.android.gms.wearable.CapabilityApi.GetAllCapabilitiesResult
        public Map<String, CapabilityInfo> getAllCapabilities() {
            return this.zzaTF;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzOt;
        }
    }

    public static class zze implements CapabilityApi.GetCapabilityResult {
        private final Status zzOt;
        private final CapabilityInfo zzaTG;

        public zze(Status status, CapabilityInfo capabilityInfo) {
            this.zzOt = status;
            this.zzaTG = capabilityInfo;
        }

        @Override // com.google.android.gms.wearable.CapabilityApi.GetCapabilityResult
        public CapabilityInfo getCapability() {
            return this.zzaTG;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzOt;
        }
    }

    private static final class zzf extends com.google.android.gms.wearable.internal.zzf<Status> {
        private CapabilityApi.CapabilityListener zzaTC;
        private String zzaTD;

        private zzf(GoogleApiClient googleApiClient, CapabilityApi.CapabilityListener capabilityListener, String str) {
            super(googleApiClient);
            this.zzaTC = capabilityListener;
            this.zzaTD = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
        public void zza(zzbk zzbkVar) throws RemoteException {
            zzbkVar.zzb(this, this.zzaTC, this.zzaTD);
            this.zzaTC = null;
            this.zzaTD = null;
        }

        @Override // com.google.android.gms.common.api.AbstractPendingResult
        /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public Status createFailedResult(Status status) {
            this.zzaTC = null;
            this.zzaTD = null;
            return status;
        }
    }

    @Override // com.google.android.gms.wearable.CapabilityApi
    public PendingResult<Status> addCapabilityListener(GoogleApiClient googleApiClient, CapabilityApi.CapabilityListener capabilityListener, String str) {
        return googleApiClient.zza((GoogleApiClient) new zza(googleApiClient, capabilityListener, str));
    }

    @Override // com.google.android.gms.wearable.CapabilityApi
    public PendingResult<CapabilityApi.AddLocalCapabilityResult> addLocalCapability(GoogleApiClient googleApiClient, final String str) {
        return googleApiClient.zza((GoogleApiClient) new com.google.android.gms.wearable.internal.zzf<CapabilityApi.AddLocalCapabilityResult>(googleApiClient) { // from class: com.google.android.gms.wearable.internal.zzg.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zzbk zzbkVar) throws RemoteException {
                zzbkVar.zzr(this, str);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.AbstractPendingResult
            /* renamed from: zzaY, reason: merged with bridge method [inline-methods] */
            public CapabilityApi.AddLocalCapabilityResult createFailedResult(Status status) {
                return new zzb(status);
            }
        });
    }

    @Override // com.google.android.gms.wearable.CapabilityApi
    public PendingResult<CapabilityApi.GetAllCapabilitiesResult> getAllCapabilities(GoogleApiClient googleApiClient, final int i) {
        return googleApiClient.zza((GoogleApiClient) new com.google.android.gms.wearable.internal.zzf<CapabilityApi.GetAllCapabilitiesResult>(googleApiClient) { // from class: com.google.android.gms.wearable.internal.zzg.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zzbk zzbkVar) throws RemoteException {
                zzbkVar.zzd(this, i);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.AbstractPendingResult
            /* renamed from: zzaX, reason: merged with bridge method [inline-methods] */
            public CapabilityApi.GetAllCapabilitiesResult createFailedResult(Status status) {
                return new zzd(status, null);
            }
        });
    }

    @Override // com.google.android.gms.wearable.CapabilityApi
    public PendingResult<CapabilityApi.GetCapabilityResult> getCapability(GoogleApiClient googleApiClient, final String str, final int i) {
        return googleApiClient.zza((GoogleApiClient) new com.google.android.gms.wearable.internal.zzf<CapabilityApi.GetCapabilityResult>(googleApiClient) { // from class: com.google.android.gms.wearable.internal.zzg.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zzbk zzbkVar) throws RemoteException {
                zzbkVar.zzg(this, str, i);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.AbstractPendingResult
            /* renamed from: zzaW, reason: merged with bridge method [inline-methods] */
            public CapabilityApi.GetCapabilityResult createFailedResult(Status status) {
                return new zze(status, null);
            }
        });
    }

    @Override // com.google.android.gms.wearable.CapabilityApi
    public PendingResult<Status> removeCapabilityListener(GoogleApiClient googleApiClient, CapabilityApi.CapabilityListener capabilityListener, String str) {
        return googleApiClient.zza((GoogleApiClient) new zzf(googleApiClient, capabilityListener, str));
    }

    @Override // com.google.android.gms.wearable.CapabilityApi
    public PendingResult<CapabilityApi.RemoveLocalCapabilityResult> removeLocalCapability(GoogleApiClient googleApiClient, final String str) {
        return googleApiClient.zza((GoogleApiClient) new com.google.android.gms.wearable.internal.zzf<CapabilityApi.RemoveLocalCapabilityResult>(googleApiClient) { // from class: com.google.android.gms.wearable.internal.zzg.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zzbk zzbkVar) throws RemoteException {
                zzbkVar.zzs(this, str);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.AbstractPendingResult
            /* renamed from: zzaZ, reason: merged with bridge method [inline-methods] */
            public CapabilityApi.RemoveLocalCapabilityResult createFailedResult(Status status) {
                return new zzb(status);
            }
        });
    }
}
