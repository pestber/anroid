package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.appdatasearch.GetRecentContextCall;
import com.google.android.gms.appdatasearch.UsageInfo;
import com.google.android.gms.internal.zzir;

/* loaded from: classes.dex */
public interface zziq extends IInterface {

    public static abstract class zza extends Binder implements zziq {

        /* renamed from: com.google.android.gms.internal.zziq$zza$zza, reason: collision with other inner class name */
        private static class C0105zza implements zziq {
            private IBinder zznF;

            C0105zza(IBinder iBinder) {
                this.zznF = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.zznF;
            }

            @Override // com.google.android.gms.internal.zziq
            public void zza(GetRecentContextCall.Request request, zzir zzirVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    if (request != null) {
                        obtain.writeInt(1);
                        request.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzirVar != null ? zzirVar.asBinder() : null);
                    this.zznF.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zziq
            public void zza(zzir zzirVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    obtain.writeStrongBinder(zzirVar != null ? zzirVar.asBinder() : null);
                    this.zznF.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zziq
            public void zza(zzir zzirVar, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    obtain.writeStrongBinder(zzirVar != null ? zzirVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.zznF.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zziq
            public void zza(zzir zzirVar, String str, UsageInfo[] usageInfoArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    obtain.writeStrongBinder(zzirVar != null ? zzirVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeTypedArray(usageInfoArr, 0);
                    this.zznF.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zziq
            public void zza(zzir zzirVar, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    obtain.writeStrongBinder(zzirVar != null ? zzirVar.asBinder() : null);
                    obtain.writeInt(z ? 1 : 0);
                    this.zznF.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zziq
            public void zzb(zzir zzirVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    obtain.writeStrongBinder(zzirVar != null ? zzirVar.asBinder() : null);
                    this.zznF.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zziq zzad(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zziq)) ? new C0105zza(iBinder) : (zziq) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    zza(zzir.zza.zzae(parcel.readStrongBinder()), parcel.readString(), (UsageInfo[]) parcel.createTypedArray(UsageInfo.CREATOR));
                    break;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    zza(zzir.zza.zzae(parcel.readStrongBinder()));
                    break;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    zzb(zzir.zza.zzae(parcel.readStrongBinder()));
                    break;
                case 4:
                    parcel.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    zza(zzir.zza.zzae(parcel.readStrongBinder()), parcel.readInt() != 0);
                    break;
                case 5:
                    parcel.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    zza(parcel.readInt() != 0 ? GetRecentContextCall.Request.CREATOR.createFromParcel(parcel) : null, zzir.zza.zzae(parcel.readStrongBinder()));
                    break;
                case 6:
                    parcel.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    zza(zzir.zza.zzae(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
                    break;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void zza(GetRecentContextCall.Request request, zzir zzirVar) throws RemoteException;

    void zza(zzir zzirVar) throws RemoteException;

    void zza(zzir zzirVar, String str, String str2) throws RemoteException;

    void zza(zzir zzirVar, String str, UsageInfo[] usageInfoArr) throws RemoteException;

    void zza(zzir zzirVar, boolean z) throws RemoteException;

    void zzb(zzir zzirVar) throws RemoteException;
}
