package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzu;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public class zzm extends Fragment implements DialogInterface.OnCancelListener {
    private boolean mStarted;
    private boolean zzXV;
    private ConnectionResult zzXX;
    private int zzXW = -1;
    private final Handler zzXY = new Handler(Looper.getMainLooper());
    private final SparseArray<zza> zzXZ = new SparseArray<>();

    private class zza implements GoogleApiClient.OnConnectionFailedListener {
        public final int zzYa;
        public final GoogleApiClient zzYb;
        public final GoogleApiClient.OnConnectionFailedListener zzYc;

        public zza(int i, GoogleApiClient googleApiClient, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            this.zzYa = i;
            this.zzYb = googleApiClient;
            this.zzYc = onConnectionFailedListener;
            googleApiClient.registerConnectionFailedListener(this);
        }

        public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.append((CharSequence) str).append("GoogleApiClient #").print(this.zzYa);
            printWriter.println(":");
            this.zzYb.dump(str + "  ", fileDescriptor, printWriter, strArr);
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
        public void onConnectionFailed(ConnectionResult connectionResult) {
            zzm.this.zzXY.post(zzm.this.new zzb(this.zzYa, connectionResult));
        }

        public void zzmW() {
            this.zzYb.unregisterConnectionFailedListener(this);
            this.zzYb.disconnect();
        }
    }

    private class zzb implements Runnable {
        private final int zzYe;
        private final ConnectionResult zzYf;

        public zzb(int i, ConnectionResult connectionResult) {
            this.zzYe = i;
            this.zzYf = connectionResult;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!zzm.this.mStarted || zzm.this.zzXV) {
                return;
            }
            zzm.this.zzXV = true;
            zzm.this.zzXW = this.zzYe;
            zzm.this.zzXX = this.zzYf;
            if (this.zzYf.hasResolution()) {
                try {
                    this.zzYf.startResolutionForResult(zzm.this.getActivity(), ((zzm.this.getActivity().getSupportFragmentManager().getFragments().indexOf(zzm.this) + 1) << 16) + 1);
                    return;
                } catch (IntentSender.SendIntentException e) {
                    zzm.this.zzmV();
                    return;
                }
            }
            if (GooglePlayServicesUtil.isUserRecoverableError(this.zzYf.getErrorCode())) {
                GooglePlayServicesUtil.showErrorDialogFragment(this.zzYf.getErrorCode(), zzm.this.getActivity(), zzm.this, 2, zzm.this);
            } else {
                zzm.this.zza(this.zzYe, this.zzYf);
            }
        }
    }

    public static zzm zza(FragmentActivity fragmentActivity) {
        zzu.zzbY("Must be called from main thread of process");
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        try {
            zzm zzmVar = (zzm) supportFragmentManager.findFragmentByTag("GmsSupportLifecycleFragment");
            if (zzmVar != null && !zzmVar.isRemoving()) {
                return zzmVar;
            }
            zzm zzmVar2 = new zzm();
            supportFragmentManager.beginTransaction().add(zzmVar2, "GmsSupportLifecycleFragment").commit();
            supportFragmentManager.executePendingTransactions();
            return zzmVar2;
        } catch (ClassCastException e) {
            throw new IllegalStateException("Fragment with tag GmsSupportLifecycleFragment is not a SupportLifecycleFragment", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zza(int i, ConnectionResult connectionResult) {
        Log.w("GmsSupportLifecycleFragment", "Unresolved error while connecting client. Stopping auto-manage.");
        zza zzaVar = this.zzXZ.get(i);
        if (zzaVar != null) {
            zzbb(i);
            GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener = zzaVar.zzYc;
            if (onConnectionFailedListener != null) {
                onConnectionFailedListener.onConnectionFailed(connectionResult);
            }
        }
        zzmV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzmV() {
        this.zzXV = false;
        this.zzXW = -1;
        this.zzXX = null;
        for (int i = 0; i < this.zzXZ.size(); i++) {
            this.zzXZ.valueAt(i).zzYb.connect();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (int i = 0; i < this.zzXZ.size(); i++) {
            this.zzXZ.valueAt(i).dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x000c, code lost:
    
        if (com.google.android.gms.common.GooglePlayServicesUtil.isGooglePlayServicesAvailable(getActivity()) == 0) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0012, code lost:
    
        zzmV();
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0010, code lost:
    
        if (r4 == (-1)) goto L9;
     */
    @Override // android.support.v4.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onActivityResult(int r3, int r4, android.content.Intent r5) {
        /*
            r2 = this;
            switch(r3) {
                case 1: goto Lf;
                case 2: goto L4;
                default: goto L3;
            }
        L3:
            goto L16
        L4:
            android.support.v4.app.FragmentActivity r0 = r2.getActivity()
            int r0 = com.google.android.gms.common.GooglePlayServicesUtil.isGooglePlayServicesAvailable(r0)
            if (r0 != 0) goto L16
            goto L12
        Lf:
            r0 = -1
            if (r4 != r0) goto L16
        L12:
            r2.zzmV()
            goto L1d
        L16:
            int r0 = r2.zzXW
            com.google.android.gms.common.ConnectionResult r1 = r2.zzXX
            r2.zza(r0, r1)
        L1d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.zzm.onActivityResult(int, int, android.content.Intent):void");
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        zza(this.zzXW, new ConnectionResult(13, null));
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.zzXV = bundle.getBoolean("resolving_error", false);
            this.zzXW = bundle.getInt("failed_client_id", -1);
            if (this.zzXW >= 0) {
                this.zzXX = new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution"));
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("resolving_error", this.zzXV);
        if (this.zzXW >= 0) {
            bundle.putInt("failed_client_id", this.zzXW);
            bundle.putInt("failed_status", this.zzXX.getErrorCode());
            bundle.putParcelable("failed_resolution", this.zzXX.getResolution());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.mStarted = true;
        if (this.zzXV) {
            return;
        }
        for (int i = 0; i < this.zzXZ.size(); i++) {
            this.zzXZ.valueAt(i).zzYb.connect();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.mStarted = false;
        for (int i = 0; i < this.zzXZ.size(); i++) {
            this.zzXZ.valueAt(i).zzYb.disconnect();
        }
    }

    public void zza(int i, GoogleApiClient googleApiClient, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        zzu.zzb(googleApiClient, "GoogleApiClient instance cannot be null");
        zzu.zza(this.zzXZ.indexOfKey(i) < 0, "Already managing a GoogleApiClient with id " + i);
        this.zzXZ.put(i, new zza(i, googleApiClient, onConnectionFailedListener));
        if (!this.mStarted || this.zzXV) {
            return;
        }
        googleApiClient.connect();
    }

    public void zzbb(int i) {
        zza zzaVar = this.zzXZ.get(i);
        this.zzXZ.remove(i);
        if (zzaVar != null) {
            zzaVar.zzmW();
        }
    }
}
