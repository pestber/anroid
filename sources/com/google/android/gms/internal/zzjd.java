package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.FitnessStatusCodes;
import com.google.android.gms.internal.zzjc;

/* loaded from: classes.dex */
public interface zzjd extends IInterface {

    public static abstract class zza extends Binder implements zzjd {

        /* renamed from: com.google.android.gms.internal.zzjd$zza$zza, reason: collision with other inner class name */
        private static class C0110zza implements zzjd {
            private IBinder zznF;

            C0110zza(IBinder iBinder) {
                this.zznF = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.zznF;
            }

            @Override // com.google.android.gms.internal.zzjd
            public void zza(zzjc zzjcVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    obtain.writeStrongBinder(zzjcVar != null ? zzjcVar.asBinder() : null);
                    this.zznF.transact(FitnessStatusCodes.UNKNOWN_AUTH_ERROR, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzjd
            public void zza(zzjc zzjcVar, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    obtain.writeStrongBinder(zzjcVar != null ? zzjcVar.asBinder() : null);
                    obtain.writeInt(i);
                    this.zznF.transact(FitnessStatusCodes.APP_MISMATCH, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzjd
            public void zza(zzjc zzjcVar, int i, String str, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    obtain.writeStrongBinder(zzjcVar != null ? zzjcVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeByteArray(bArr);
                    this.zznF.transact(FitnessStatusCodes.MISSING_BLE_PERMISSION, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzjd
            public void zza(zzjc zzjcVar, int i, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    obtain.writeStrongBinder(zzjcVar != null ? zzjcVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeByteArray(bArr);
                    this.zznF.transact(FitnessStatusCodes.DATA_TYPE_NOT_FOUND, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzjd
            public void zzb(zzjc zzjcVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    obtain.writeStrongBinder(zzjcVar != null ? zzjcVar.asBinder() : null);
                    this.zznF.transact(FitnessStatusCodes.TRANSIENT_ERROR, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzjd
            public void zzb(zzjc zzjcVar, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    obtain.writeStrongBinder(zzjcVar != null ? zzjcVar.asBinder() : null);
                    obtain.writeInt(i);
                    this.zznF.transact(FitnessStatusCodes.UNSUPPORTED_PLATFORM, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzjd
            public void zzc(zzjc zzjcVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    obtain.writeStrongBinder(zzjcVar != null ? zzjcVar.asBinder() : null);
                    this.zznF.transact(FitnessStatusCodes.EQUIVALENT_SESSION_ENDED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzjd
            public int zzkV() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    this.zznF.transact(FitnessStatusCodes.CONFLICTING_DATA_TYPE, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzjd
            public int zzkW() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    this.zznF.transact(FitnessStatusCodes.INCONSISTENT_DATA_TYPE, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzjd zzal(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.appstate.internal.IAppStateService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzjd)) ? new C0110zza(iBinder) : (zzjd) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case FitnessStatusCodes.CONFLICTING_DATA_TYPE /* 5001 */:
                    parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    int zzkV = zzkV();
                    parcel2.writeNoException();
                    parcel2.writeInt(zzkV);
                    return true;
                case FitnessStatusCodes.INCONSISTENT_DATA_TYPE /* 5002 */:
                    parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    int zzkW = zzkW();
                    parcel2.writeNoException();
                    parcel2.writeInt(zzkW);
                    return true;
                case FitnessStatusCodes.DATA_TYPE_NOT_FOUND /* 5003 */:
                    parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    zza(zzjc.zza.zzak(parcel.readStrongBinder()), parcel.readInt(), parcel.createByteArray());
                    parcel2.writeNoException();
                    return true;
                case FitnessStatusCodes.APP_MISMATCH /* 5004 */:
                    parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    zza(zzjc.zza.zzak(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case FitnessStatusCodes.UNKNOWN_AUTH_ERROR /* 5005 */:
                    parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    zza(zzjc.zza.zzak(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case FitnessStatusCodes.MISSING_BLE_PERMISSION /* 5006 */:
                    parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    zza(zzjc.zza.zzak(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.createByteArray());
                    parcel2.writeNoException();
                    return true;
                case FitnessStatusCodes.UNSUPPORTED_PLATFORM /* 5007 */:
                    parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    zzb(zzjc.zza.zzak(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case FitnessStatusCodes.TRANSIENT_ERROR /* 5008 */:
                    parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    zzb(zzjc.zza.zzak(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case FitnessStatusCodes.EQUIVALENT_SESSION_ENDED /* 5009 */:
                    parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    zzc(zzjc.zza.zzak(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.appstate.internal.IAppStateService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(zzjc zzjcVar) throws RemoteException;

    void zza(zzjc zzjcVar, int i) throws RemoteException;

    void zza(zzjc zzjcVar, int i, String str, byte[] bArr) throws RemoteException;

    void zza(zzjc zzjcVar, int i, byte[] bArr) throws RemoteException;

    void zzb(zzjc zzjcVar) throws RemoteException;

    void zzb(zzjc zzjcVar, int i) throws RemoteException;

    void zzc(zzjc zzjcVar) throws RemoteException;

    int zzkV() throws RemoteException;

    int zzkW() throws RemoteException;
}
