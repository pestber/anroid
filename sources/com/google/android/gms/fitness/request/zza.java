package com.google.android.gms.fitness.request;

import android.os.RemoteException;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.request.zzn;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class zza extends zzn.zza {
    private final BleScanCallback zzalI;

    /* renamed from: com.google.android.gms.fitness.request.zza$zza, reason: collision with other inner class name */
    public static class C0067zza {
        private static final C0067zza zzalJ = new C0067zza();
        private final Map<BleScanCallback, zza> zzalK = new HashMap();

        private C0067zza() {
        }

        public static C0067zza zzqS() {
            return zzalJ;
        }

        public zza zza(BleScanCallback bleScanCallback) {
            zza zzaVar;
            synchronized (this.zzalK) {
                zzaVar = this.zzalK.get(bleScanCallback);
                if (zzaVar == null) {
                    zzaVar = new zza(bleScanCallback);
                    this.zzalK.put(bleScanCallback, zzaVar);
                }
            }
            return zzaVar;
        }

        public zza zzb(BleScanCallback bleScanCallback) {
            synchronized (this.zzalK) {
                zza zzaVar = this.zzalK.get(bleScanCallback);
                if (zzaVar != null) {
                    return zzaVar;
                }
                return new zza(bleScanCallback);
            }
        }
    }

    private zza(BleScanCallback bleScanCallback) {
        this.zzalI = (BleScanCallback) com.google.android.gms.common.internal.zzu.zzu(bleScanCallback);
    }

    @Override // com.google.android.gms.fitness.request.zzn
    public void onDeviceFound(BleDevice bleDevice) throws RemoteException {
        this.zzalI.onDeviceFound(bleDevice);
    }

    @Override // com.google.android.gms.fitness.request.zzn
    public void onScanStopped() throws RemoteException {
        this.zzalI.onScanStopped();
    }
}
