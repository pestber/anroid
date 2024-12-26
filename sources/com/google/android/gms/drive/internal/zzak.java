package com.google.android.gms.drive.internal;

import android.content.IntentSender;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.drive.RealtimeDocumentSyncRequest;
import com.google.android.gms.drive.internal.zzal;
import com.google.android.gms.drive.internal.zzam;

/* loaded from: classes.dex */
public interface zzak extends IInterface {

    public static abstract class zza extends Binder implements zzak {

        /* renamed from: com.google.android.gms.drive.internal.zzak$zza$zza, reason: collision with other inner class name */
        private static class C0046zza implements zzak {
            private IBinder zznF;

            C0046zza(IBinder iBinder) {
                this.zznF = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.zznF;
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public IntentSender zza(CreateFileIntentSenderRequest createFileIntentSenderRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (createFileIntentSenderRequest != null) {
                        obtain.writeInt(1);
                        createFileIntentSenderRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznF.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (IntentSender) IntentSender.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public IntentSender zza(OpenFileIntentSenderRequest openFileIntentSenderRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (openFileIntentSenderRequest != null) {
                        obtain.writeInt(1);
                        openFileIntentSenderRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznF.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (IntentSender) IntentSender.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public DriveServiceResponse zza(OpenContentsRequest openContentsRequest, zzal zzalVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (openContentsRequest != null) {
                        obtain.writeInt(1);
                        openContentsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzalVar != null ? zzalVar.asBinder() : null);
                    this.zznF.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? DriveServiceResponse.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zza(RealtimeDocumentSyncRequest realtimeDocumentSyncRequest, zzal zzalVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (realtimeDocumentSyncRequest != null) {
                        obtain.writeInt(1);
                        realtimeDocumentSyncRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzalVar != null ? zzalVar.asBinder() : null);
                    this.zznF.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zza(AddEventListenerRequest addEventListenerRequest, zzam zzamVar, String str, zzal zzalVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (addEventListenerRequest != null) {
                        obtain.writeInt(1);
                        addEventListenerRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzamVar != null ? zzamVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeStrongBinder(zzalVar != null ? zzalVar.asBinder() : null);
                    this.zznF.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zza(AddPermissionRequest addPermissionRequest, zzal zzalVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (addPermissionRequest != null) {
                        obtain.writeInt(1);
                        addPermissionRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzalVar != null ? zzalVar.asBinder() : null);
                    this.zznF.transact(48, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zza(AuthorizeAccessRequest authorizeAccessRequest, zzal zzalVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (authorizeAccessRequest != null) {
                        obtain.writeInt(1);
                        authorizeAccessRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzalVar != null ? zzalVar.asBinder() : null);
                    this.zznF.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zza(CancelPendingActionsRequest cancelPendingActionsRequest, zzal zzalVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (cancelPendingActionsRequest != null) {
                        obtain.writeInt(1);
                        cancelPendingActionsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzalVar != null ? zzalVar.asBinder() : null);
                    this.zznF.transact(37, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zza(CheckResourceIdsExistRequest checkResourceIdsExistRequest, zzal zzalVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (checkResourceIdsExistRequest != null) {
                        obtain.writeInt(1);
                        checkResourceIdsExistRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzalVar != null ? zzalVar.asBinder() : null);
                    this.zznF.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zza(CloseContentsAndUpdateMetadataRequest closeContentsAndUpdateMetadataRequest, zzal zzalVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (closeContentsAndUpdateMetadataRequest != null) {
                        obtain.writeInt(1);
                        closeContentsAndUpdateMetadataRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzalVar != null ? zzalVar.asBinder() : null);
                    this.zznF.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zza(CloseContentsRequest closeContentsRequest, zzal zzalVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (closeContentsRequest != null) {
                        obtain.writeInt(1);
                        closeContentsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzalVar != null ? zzalVar.asBinder() : null);
                    this.zznF.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zza(CreateContentsRequest createContentsRequest, zzal zzalVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (createContentsRequest != null) {
                        obtain.writeInt(1);
                        createContentsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzalVar != null ? zzalVar.asBinder() : null);
                    this.zznF.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zza(CreateFileRequest createFileRequest, zzal zzalVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (createFileRequest != null) {
                        obtain.writeInt(1);
                        createFileRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzalVar != null ? zzalVar.asBinder() : null);
                    this.zznF.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zza(CreateFolderRequest createFolderRequest, zzal zzalVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (createFolderRequest != null) {
                        obtain.writeInt(1);
                        createFolderRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzalVar != null ? zzalVar.asBinder() : null);
                    this.zznF.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zza(DeleteResourceRequest deleteResourceRequest, zzal zzalVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (deleteResourceRequest != null) {
                        obtain.writeInt(1);
                        deleteResourceRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzalVar != null ? zzalVar.asBinder() : null);
                    this.zznF.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zza(DisconnectRequest disconnectRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (disconnectRequest != null) {
                        obtain.writeInt(1);
                        disconnectRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznF.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zza(FetchThumbnailRequest fetchThumbnailRequest, zzal zzalVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (fetchThumbnailRequest != null) {
                        obtain.writeInt(1);
                        fetchThumbnailRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzalVar != null ? zzalVar.asBinder() : null);
                    this.zznF.transact(42, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zza(GetChangesRequest getChangesRequest, zzal zzalVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (getChangesRequest != null) {
                        obtain.writeInt(1);
                        getChangesRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzalVar != null ? zzalVar.asBinder() : null);
                    this.zznF.transact(44, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zza(GetDriveIdFromUniqueIdentifierRequest getDriveIdFromUniqueIdentifierRequest, zzal zzalVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (getDriveIdFromUniqueIdentifierRequest != null) {
                        obtain.writeInt(1);
                        getDriveIdFromUniqueIdentifierRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzalVar != null ? zzalVar.asBinder() : null);
                    this.zznF.transact(29, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zza(GetMetadataRequest getMetadataRequest, zzal zzalVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (getMetadataRequest != null) {
                        obtain.writeInt(1);
                        getMetadataRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzalVar != null ? zzalVar.asBinder() : null);
                    this.zznF.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zza(GetPermissionsRequest getPermissionsRequest, zzal zzalVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (getPermissionsRequest != null) {
                        obtain.writeInt(1);
                        getPermissionsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzalVar != null ? zzalVar.asBinder() : null);
                    this.zznF.transact(47, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zza(ListParentsRequest listParentsRequest, zzal zzalVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (listParentsRequest != null) {
                        obtain.writeInt(1);
                        listParentsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzalVar != null ? zzalVar.asBinder() : null);
                    this.zznF.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zza(LoadRealtimeRequest loadRealtimeRequest, zzal zzalVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (loadRealtimeRequest != null) {
                        obtain.writeInt(1);
                        loadRealtimeRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzalVar != null ? zzalVar.asBinder() : null);
                    this.zznF.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zza(QueryRequest queryRequest, zzal zzalVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (queryRequest != null) {
                        obtain.writeInt(1);
                        queryRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzalVar != null ? zzalVar.asBinder() : null);
                    this.zznF.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zza(QueryRequest queryRequest, zzam zzamVar, zzal zzalVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (queryRequest != null) {
                        obtain.writeInt(1);
                        queryRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzamVar != null ? zzamVar.asBinder() : null);
                    obtain.writeStrongBinder(zzalVar != null ? zzalVar.asBinder() : null);
                    this.zznF.transact(51, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zza(RemoveEventListenerRequest removeEventListenerRequest, zzam zzamVar, String str, zzal zzalVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (removeEventListenerRequest != null) {
                        obtain.writeInt(1);
                        removeEventListenerRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzamVar != null ? zzamVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeStrongBinder(zzalVar != null ? zzalVar.asBinder() : null);
                    this.zznF.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zza(RemovePermissionRequest removePermissionRequest, zzal zzalVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (removePermissionRequest != null) {
                        obtain.writeInt(1);
                        removePermissionRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzalVar != null ? zzalVar.asBinder() : null);
                    this.zznF.transact(50, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zza(SetDrivePreferencesRequest setDrivePreferencesRequest, zzal zzalVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (setDrivePreferencesRequest != null) {
                        obtain.writeInt(1);
                        setDrivePreferencesRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzalVar != null ? zzalVar.asBinder() : null);
                    this.zznF.transact(33, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zza(SetFileUploadPreferencesRequest setFileUploadPreferencesRequest, zzal zzalVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (setFileUploadPreferencesRequest != null) {
                        obtain.writeInt(1);
                        setFileUploadPreferencesRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzalVar != null ? zzalVar.asBinder() : null);
                    this.zznF.transact(36, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zza(SetResourceParentsRequest setResourceParentsRequest, zzal zzalVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (setResourceParentsRequest != null) {
                        obtain.writeInt(1);
                        setResourceParentsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzalVar != null ? zzalVar.asBinder() : null);
                    this.zznF.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zza(TrashResourceRequest trashResourceRequest, zzal zzalVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (trashResourceRequest != null) {
                        obtain.writeInt(1);
                        trashResourceRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzalVar != null ? zzalVar.asBinder() : null);
                    this.zznF.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zza(UnsubscribeResourceRequest unsubscribeResourceRequest, zzal zzalVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (unsubscribeResourceRequest != null) {
                        obtain.writeInt(1);
                        unsubscribeResourceRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzalVar != null ? zzalVar.asBinder() : null);
                    this.zznF.transact(46, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zza(UntrashResourceRequest untrashResourceRequest, zzal zzalVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (untrashResourceRequest != null) {
                        obtain.writeInt(1);
                        untrashResourceRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzalVar != null ? zzalVar.asBinder() : null);
                    this.zznF.transact(38, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zza(UpdateMetadataRequest updateMetadataRequest, zzal zzalVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (updateMetadataRequest != null) {
                        obtain.writeInt(1);
                        updateMetadataRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzalVar != null ? zzalVar.asBinder() : null);
                    this.zznF.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zza(UpdatePermissionRequest updatePermissionRequest, zzal zzalVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (updatePermissionRequest != null) {
                        obtain.writeInt(1);
                        updatePermissionRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzalVar != null ? zzalVar.asBinder() : null);
                    this.zznF.transact(49, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zza(zzal zzalVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    obtain.writeStrongBinder(zzalVar != null ? zzalVar.asBinder() : null);
                    this.zznF.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zza(zzam zzamVar, zzal zzalVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    obtain.writeStrongBinder(zzamVar != null ? zzamVar.asBinder() : null);
                    obtain.writeStrongBinder(zzalVar != null ? zzalVar.asBinder() : null);
                    this.zznF.transact(52, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zzb(QueryRequest queryRequest, zzal zzalVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (queryRequest != null) {
                        obtain.writeInt(1);
                        queryRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzalVar != null ? zzalVar.asBinder() : null);
                    this.zznF.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zzb(zzal zzalVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    obtain.writeStrongBinder(zzalVar != null ? zzalVar.asBinder() : null);
                    this.zznF.transact(31, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zzc(zzal zzalVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    obtain.writeStrongBinder(zzalVar != null ? zzalVar.asBinder() : null);
                    this.zznF.transact(32, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zzd(zzal zzalVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    obtain.writeStrongBinder(zzalVar != null ? zzalVar.asBinder() : null);
                    this.zznF.transact(35, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zze(zzal zzalVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    obtain.writeStrongBinder(zzalVar != null ? zzalVar.asBinder() : null);
                    this.zznF.transact(41, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzak
            public void zzf(zzal zzalVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    obtain.writeStrongBinder(zzalVar != null ? zzalVar.asBinder() : null);
                    this.zznF.transact(43, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzak zzaO(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.drive.internal.IDriveService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzak)) ? new C0046zza(iBinder) : (zzak) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zza(parcel.readInt() != 0 ? GetMetadataRequest.CREATOR.createFromParcel(parcel) : null, zzal.zza.zzaP(parcel.readStrongBinder()));
                    break;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zza(parcel.readInt() != 0 ? QueryRequest.CREATOR.createFromParcel(parcel) : null, zzal.zza.zzaP(parcel.readStrongBinder()));
                    break;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zza(parcel.readInt() != 0 ? UpdateMetadataRequest.CREATOR.createFromParcel(parcel) : null, zzal.zza.zzaP(parcel.readStrongBinder()));
                    break;
                case 4:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zza(parcel.readInt() != 0 ? CreateContentsRequest.CREATOR.createFromParcel(parcel) : null, zzal.zza.zzaP(parcel.readStrongBinder()));
                    break;
                case 5:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zza(parcel.readInt() != 0 ? CreateFileRequest.CREATOR.createFromParcel(parcel) : null, zzal.zza.zzaP(parcel.readStrongBinder()));
                    break;
                case 6:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zza(parcel.readInt() != 0 ? CreateFolderRequest.CREATOR.createFromParcel(parcel) : null, zzal.zza.zzaP(parcel.readStrongBinder()));
                    break;
                case 7:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    DriveServiceResponse zza = zza(parcel.readInt() != 0 ? OpenContentsRequest.CREATOR.createFromParcel(parcel) : null, zzal.zza.zzaP(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (zza != null) {
                        parcel2.writeInt(1);
                        zza.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 8:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zza(parcel.readInt() != 0 ? CloseContentsRequest.CREATOR.createFromParcel(parcel) : null, zzal.zza.zzaP(parcel.readStrongBinder()));
                    break;
                case 9:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zza(zzal.zza.zzaP(parcel.readStrongBinder()));
                    break;
                case 10:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    IntentSender zza2 = zza(parcel.readInt() != 0 ? OpenFileIntentSenderRequest.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (zza2 != null) {
                        parcel2.writeInt(1);
                        zza2.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 11:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    IntentSender zza3 = zza(parcel.readInt() != 0 ? CreateFileIntentSenderRequest.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (zza3 != null) {
                        parcel2.writeInt(1);
                        zza3.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 12:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zza(parcel.readInt() != 0 ? AuthorizeAccessRequest.CREATOR.createFromParcel(parcel) : null, zzal.zza.zzaP(parcel.readStrongBinder()));
                    break;
                case 13:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zza(parcel.readInt() != 0 ? ListParentsRequest.CREATOR.createFromParcel(parcel) : null, zzal.zza.zzaP(parcel.readStrongBinder()));
                    break;
                case 14:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zza(parcel.readInt() != 0 ? AddEventListenerRequest.CREATOR.createFromParcel(parcel) : null, zzam.zza.zzaQ(parcel.readStrongBinder()), parcel.readString(), zzal.zza.zzaP(parcel.readStrongBinder()));
                    break;
                case 15:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zza(parcel.readInt() != 0 ? RemoveEventListenerRequest.CREATOR.createFromParcel(parcel) : null, zzam.zza.zzaQ(parcel.readStrongBinder()), parcel.readString(), zzal.zza.zzaP(parcel.readStrongBinder()));
                    break;
                case 16:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zza(parcel.readInt() != 0 ? DisconnectRequest.CREATOR.createFromParcel(parcel) : null);
                    break;
                case 17:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zza(parcel.readInt() != 0 ? TrashResourceRequest.CREATOR.createFromParcel(parcel) : null, zzal.zza.zzaP(parcel.readStrongBinder()));
                    break;
                case 18:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zza(parcel.readInt() != 0 ? CloseContentsAndUpdateMetadataRequest.CREATOR.createFromParcel(parcel) : null, zzal.zza.zzaP(parcel.readStrongBinder()));
                    break;
                case 19:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zzb(parcel.readInt() != 0 ? QueryRequest.CREATOR.createFromParcel(parcel) : null, zzal.zza.zzaP(parcel.readStrongBinder()));
                    break;
                case 24:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zza(parcel.readInt() != 0 ? DeleteResourceRequest.CREATOR.createFromParcel(parcel) : null, zzal.zza.zzaP(parcel.readStrongBinder()));
                    break;
                case 27:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zza(parcel.readInt() != 0 ? LoadRealtimeRequest.CREATOR.createFromParcel(parcel) : null, zzal.zza.zzaP(parcel.readStrongBinder()));
                    break;
                case 28:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zza(parcel.readInt() != 0 ? SetResourceParentsRequest.CREATOR.createFromParcel(parcel) : null, zzal.zza.zzaP(parcel.readStrongBinder()));
                    break;
                case 29:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zza(parcel.readInt() != 0 ? GetDriveIdFromUniqueIdentifierRequest.CREATOR.createFromParcel(parcel) : null, zzal.zza.zzaP(parcel.readStrongBinder()));
                    break;
                case 30:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zza(parcel.readInt() != 0 ? CheckResourceIdsExistRequest.CREATOR.createFromParcel(parcel) : null, zzal.zza.zzaP(parcel.readStrongBinder()));
                    break;
                case 31:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zzb(zzal.zza.zzaP(parcel.readStrongBinder()));
                    break;
                case 32:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zzc(zzal.zza.zzaP(parcel.readStrongBinder()));
                    break;
                case 33:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zza(parcel.readInt() != 0 ? SetDrivePreferencesRequest.CREATOR.createFromParcel(parcel) : null, zzal.zza.zzaP(parcel.readStrongBinder()));
                    break;
                case 34:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zza(parcel.readInt() != 0 ? RealtimeDocumentSyncRequest.CREATOR.createFromParcel(parcel) : null, zzal.zza.zzaP(parcel.readStrongBinder()));
                    break;
                case 35:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zzd(zzal.zza.zzaP(parcel.readStrongBinder()));
                    break;
                case 36:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zza(parcel.readInt() != 0 ? SetFileUploadPreferencesRequest.CREATOR.createFromParcel(parcel) : null, zzal.zza.zzaP(parcel.readStrongBinder()));
                    break;
                case 37:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zza(parcel.readInt() != 0 ? CancelPendingActionsRequest.CREATOR.createFromParcel(parcel) : null, zzal.zza.zzaP(parcel.readStrongBinder()));
                    break;
                case 38:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zza(parcel.readInt() != 0 ? UntrashResourceRequest.CREATOR.createFromParcel(parcel) : null, zzal.zza.zzaP(parcel.readStrongBinder()));
                    break;
                case 41:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zze(zzal.zza.zzaP(parcel.readStrongBinder()));
                    break;
                case 42:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zza(parcel.readInt() != 0 ? FetchThumbnailRequest.CREATOR.createFromParcel(parcel) : null, zzal.zza.zzaP(parcel.readStrongBinder()));
                    break;
                case 43:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zzf(zzal.zza.zzaP(parcel.readStrongBinder()));
                    break;
                case 44:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zza(parcel.readInt() != 0 ? GetChangesRequest.CREATOR.createFromParcel(parcel) : null, zzal.zza.zzaP(parcel.readStrongBinder()));
                    break;
                case 46:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zza(parcel.readInt() != 0 ? UnsubscribeResourceRequest.CREATOR.createFromParcel(parcel) : null, zzal.zza.zzaP(parcel.readStrongBinder()));
                    break;
                case 47:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zza(parcel.readInt() != 0 ? GetPermissionsRequest.CREATOR.createFromParcel(parcel) : null, zzal.zza.zzaP(parcel.readStrongBinder()));
                    break;
                case 48:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zza(parcel.readInt() != 0 ? AddPermissionRequest.CREATOR.createFromParcel(parcel) : null, zzal.zza.zzaP(parcel.readStrongBinder()));
                    break;
                case 49:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zza(parcel.readInt() != 0 ? UpdatePermissionRequest.CREATOR.createFromParcel(parcel) : null, zzal.zza.zzaP(parcel.readStrongBinder()));
                    break;
                case 50:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zza(parcel.readInt() != 0 ? RemovePermissionRequest.CREATOR.createFromParcel(parcel) : null, zzal.zza.zzaP(parcel.readStrongBinder()));
                    break;
                case 51:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zza(parcel.readInt() != 0 ? QueryRequest.CREATOR.createFromParcel(parcel) : null, zzam.zza.zzaQ(parcel.readStrongBinder()), zzal.zza.zzaP(parcel.readStrongBinder()));
                    break;
                case 52:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zza(zzam.zza.zzaQ(parcel.readStrongBinder()), zzal.zza.zzaP(parcel.readStrongBinder()));
                    break;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.drive.internal.IDriveService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel2.writeNoException();
            return true;
        }
    }

    IntentSender zza(CreateFileIntentSenderRequest createFileIntentSenderRequest) throws RemoteException;

    IntentSender zza(OpenFileIntentSenderRequest openFileIntentSenderRequest) throws RemoteException;

    DriveServiceResponse zza(OpenContentsRequest openContentsRequest, zzal zzalVar) throws RemoteException;

    void zza(RealtimeDocumentSyncRequest realtimeDocumentSyncRequest, zzal zzalVar) throws RemoteException;

    void zza(AddEventListenerRequest addEventListenerRequest, zzam zzamVar, String str, zzal zzalVar) throws RemoteException;

    void zza(AddPermissionRequest addPermissionRequest, zzal zzalVar) throws RemoteException;

    void zza(AuthorizeAccessRequest authorizeAccessRequest, zzal zzalVar) throws RemoteException;

    void zza(CancelPendingActionsRequest cancelPendingActionsRequest, zzal zzalVar) throws RemoteException;

    void zza(CheckResourceIdsExistRequest checkResourceIdsExistRequest, zzal zzalVar) throws RemoteException;

    void zza(CloseContentsAndUpdateMetadataRequest closeContentsAndUpdateMetadataRequest, zzal zzalVar) throws RemoteException;

    void zza(CloseContentsRequest closeContentsRequest, zzal zzalVar) throws RemoteException;

    void zza(CreateContentsRequest createContentsRequest, zzal zzalVar) throws RemoteException;

    void zza(CreateFileRequest createFileRequest, zzal zzalVar) throws RemoteException;

    void zza(CreateFolderRequest createFolderRequest, zzal zzalVar) throws RemoteException;

    void zza(DeleteResourceRequest deleteResourceRequest, zzal zzalVar) throws RemoteException;

    void zza(DisconnectRequest disconnectRequest) throws RemoteException;

    void zza(FetchThumbnailRequest fetchThumbnailRequest, zzal zzalVar) throws RemoteException;

    void zza(GetChangesRequest getChangesRequest, zzal zzalVar) throws RemoteException;

    void zza(GetDriveIdFromUniqueIdentifierRequest getDriveIdFromUniqueIdentifierRequest, zzal zzalVar) throws RemoteException;

    void zza(GetMetadataRequest getMetadataRequest, zzal zzalVar) throws RemoteException;

    void zza(GetPermissionsRequest getPermissionsRequest, zzal zzalVar) throws RemoteException;

    void zza(ListParentsRequest listParentsRequest, zzal zzalVar) throws RemoteException;

    void zza(LoadRealtimeRequest loadRealtimeRequest, zzal zzalVar) throws RemoteException;

    void zza(QueryRequest queryRequest, zzal zzalVar) throws RemoteException;

    void zza(QueryRequest queryRequest, zzam zzamVar, zzal zzalVar) throws RemoteException;

    void zza(RemoveEventListenerRequest removeEventListenerRequest, zzam zzamVar, String str, zzal zzalVar) throws RemoteException;

    void zza(RemovePermissionRequest removePermissionRequest, zzal zzalVar) throws RemoteException;

    void zza(SetDrivePreferencesRequest setDrivePreferencesRequest, zzal zzalVar) throws RemoteException;

    void zza(SetFileUploadPreferencesRequest setFileUploadPreferencesRequest, zzal zzalVar) throws RemoteException;

    void zza(SetResourceParentsRequest setResourceParentsRequest, zzal zzalVar) throws RemoteException;

    void zza(TrashResourceRequest trashResourceRequest, zzal zzalVar) throws RemoteException;

    void zza(UnsubscribeResourceRequest unsubscribeResourceRequest, zzal zzalVar) throws RemoteException;

    void zza(UntrashResourceRequest untrashResourceRequest, zzal zzalVar) throws RemoteException;

    void zza(UpdateMetadataRequest updateMetadataRequest, zzal zzalVar) throws RemoteException;

    void zza(UpdatePermissionRequest updatePermissionRequest, zzal zzalVar) throws RemoteException;

    void zza(zzal zzalVar) throws RemoteException;

    void zza(zzam zzamVar, zzal zzalVar) throws RemoteException;

    void zzb(QueryRequest queryRequest, zzal zzalVar) throws RemoteException;

    void zzb(zzal zzalVar) throws RemoteException;

    void zzc(zzal zzalVar) throws RemoteException;

    void zzd(zzal zzalVar) throws RemoteException;

    void zze(zzal zzalVar) throws RemoteException;

    void zzf(zzal zzalVar) throws RemoteException;
}
