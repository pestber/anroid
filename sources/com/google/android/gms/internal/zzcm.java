package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;

/* loaded from: classes.dex */
public interface zzcm extends IInterface {

    public static abstract class zza extends Binder implements zzcm {

        /* renamed from: com.google.android.gms.internal.zzcm$zza$zza, reason: collision with other inner class name */
        private static class C0078zza implements zzcm {
            private IBinder zznF;

            C0078zza(IBinder iBinder) {
                this.zznF = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.zznF;
            }

            @Override // com.google.android.gms.internal.zzcm
            public com.google.android.gms.dynamic.zzd zzS(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
                    obtain.writeString(str);
                    this.zznF.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return zzd.zza.zzbg(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzcm
            public void zza(String str, com.google.android.gms.dynamic.zzd zzdVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(zzdVar != null ? zzdVar.asBinder() : null);
                    this.zznF.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzcm
            public void zzb(com.google.android.gms.dynamic.zzd zzdVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
                    obtain.writeStrongBinder(zzdVar != null ? zzdVar.asBinder() : null);
                    this.zznF.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
        }

        public static zzcm zzu(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzcm)) ? new C0078zza(iBinder) : (zzcm) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
                    zza(parcel.readString(), zzd.zza.zzbg(parcel.readStrongBinder()));
                    break;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
                    com.google.android.gms.dynamic.zzd zzS = zzS(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(zzS != null ? zzS.asBinder() : null);
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
                    zzb(zzd.zza.zzbg(parcel.readStrongBinder()));
                    break;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel2.writeNoException();
            return true;
        }
    }

    com.google.android.gms.dynamic.zzd zzS(String str) throws RemoteException;

    void zza(String str, com.google.android.gms.dynamic.zzd zzdVar) throws RemoteException;

    void zzb(com.google.android.gms.dynamic.zzd zzdVar) throws RemoteException;
}
