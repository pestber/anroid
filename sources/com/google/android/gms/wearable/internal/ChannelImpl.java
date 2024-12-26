package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.ChannelApi;
import com.google.android.gms.wearable.internal.zzi;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class ChannelImpl implements SafeParcelable, Channel {
    public static final Parcelable.Creator<ChannelImpl> CREATOR = new zzl();
    final int zzCY;
    private final String zzaST;
    private final String zzaTK;
    private final String zzaTQ;

    static final class zza implements Channel.GetInputStreamResult {
        private final Status zzOt;
        private final InputStream zzaTV;

        zza(Status status, InputStream inputStream) {
            this.zzOt = (Status) com.google.android.gms.common.internal.zzu.zzu(status);
            this.zzaTV = inputStream;
        }

        @Override // com.google.android.gms.wearable.Channel.GetInputStreamResult
        public InputStream getInputStream() {
            return this.zzaTV;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzOt;
        }

        @Override // com.google.android.gms.common.api.Releasable
        public void release() {
            if (this.zzaTV != null) {
                try {
                    this.zzaTV.close();
                } catch (IOException e) {
                }
            }
        }
    }

    static final class zzb implements Channel.GetOutputStreamResult {
        private final Status zzOt;
        private final OutputStream zzaTW;

        zzb(Status status, OutputStream outputStream) {
            this.zzOt = (Status) com.google.android.gms.common.internal.zzu.zzu(status);
            this.zzaTW = outputStream;
        }

        @Override // com.google.android.gms.wearable.Channel.GetOutputStreamResult
        public OutputStream getOutputStream() {
            return this.zzaTW;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzOt;
        }

        @Override // com.google.android.gms.common.api.Releasable
        public void release() {
            if (this.zzaTW != null) {
                try {
                    this.zzaTW.close();
                } catch (IOException e) {
                }
            }
        }
    }

    ChannelImpl(int i, String str, String str2, String str3) {
        this.zzCY = i;
        this.zzaTK = (String) com.google.android.gms.common.internal.zzu.zzu(str);
        this.zzaST = (String) com.google.android.gms.common.internal.zzu.zzu(str2);
        this.zzaTQ = (String) com.google.android.gms.common.internal.zzu.zzu(str3);
    }

    @Override // com.google.android.gms.wearable.Channel
    public PendingResult<Status> addListener(GoogleApiClient googleApiClient, ChannelApi.ChannelListener channelListener) {
        com.google.android.gms.common.internal.zzu.zzb(googleApiClient, "client is null");
        com.google.android.gms.common.internal.zzu.zzb(channelListener, "listener is null");
        return googleApiClient.zza((GoogleApiClient) new zzi.zza(googleApiClient, channelListener, this.zzaTK));
    }

    @Override // com.google.android.gms.wearable.Channel
    public PendingResult<Status> close(GoogleApiClient googleApiClient) {
        return googleApiClient.zzb(new zzf<Status>(googleApiClient) { // from class: com.google.android.gms.wearable.internal.ChannelImpl.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zzbk zzbkVar) throws RemoteException {
                zzbkVar.zzt(this, ChannelImpl.this.zzaTK);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.AbstractPendingResult
            /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
            public Status createFailedResult(Status status) {
                return status;
            }
        });
    }

    @Override // com.google.android.gms.wearable.Channel
    public PendingResult<Status> close(GoogleApiClient googleApiClient, final int i) {
        return googleApiClient.zzb(new zzf<Status>(googleApiClient) { // from class: com.google.android.gms.wearable.internal.ChannelImpl.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zzbk zzbkVar) throws RemoteException {
                zzbkVar.zzh(this, ChannelImpl.this.zzaTK, i);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.AbstractPendingResult
            /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
            public Status createFailedResult(Status status) {
                return status;
            }
        });
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ChannelImpl)) {
            return false;
        }
        ChannelImpl channelImpl = (ChannelImpl) obj;
        return this.zzaTK.equals(channelImpl.zzaTK) && com.google.android.gms.common.internal.zzt.equal(channelImpl.zzaST, this.zzaST) && com.google.android.gms.common.internal.zzt.equal(channelImpl.zzaTQ, this.zzaTQ) && channelImpl.zzCY == this.zzCY;
    }

    @Override // com.google.android.gms.wearable.Channel
    public PendingResult<Channel.GetInputStreamResult> getInputStream(GoogleApiClient googleApiClient) {
        return googleApiClient.zzb(new zzf<Channel.GetInputStreamResult>(googleApiClient) { // from class: com.google.android.gms.wearable.internal.ChannelImpl.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zzbk zzbkVar) throws RemoteException {
                zzbkVar.zzu(this, ChannelImpl.this.zzaTK);
            }

            @Override // com.google.android.gms.common.api.AbstractPendingResult
            /* renamed from: zzbb, reason: merged with bridge method [inline-methods] */
            public Channel.GetInputStreamResult createFailedResult(Status status) {
                return new zza(status, null);
            }
        });
    }

    @Override // com.google.android.gms.wearable.Channel
    public String getNodeId() {
        return this.zzaST;
    }

    @Override // com.google.android.gms.wearable.Channel
    public PendingResult<Channel.GetOutputStreamResult> getOutputStream(GoogleApiClient googleApiClient) {
        return googleApiClient.zzb(new zzf<Channel.GetOutputStreamResult>(googleApiClient) { // from class: com.google.android.gms.wearable.internal.ChannelImpl.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zzbk zzbkVar) throws RemoteException {
                zzbkVar.zzv(this, ChannelImpl.this.zzaTK);
            }

            @Override // com.google.android.gms.common.api.AbstractPendingResult
            /* renamed from: zzbc, reason: merged with bridge method [inline-methods] */
            public Channel.GetOutputStreamResult createFailedResult(Status status) {
                return new zzb(status, null);
            }
        });
    }

    @Override // com.google.android.gms.wearable.Channel
    public String getPath() {
        return this.zzaTQ;
    }

    public String getToken() {
        return this.zzaTK;
    }

    public int hashCode() {
        return this.zzaTK.hashCode();
    }

    @Override // com.google.android.gms.wearable.Channel
    public PendingResult<Status> receiveFile(GoogleApiClient googleApiClient, final Uri uri, final boolean z) {
        com.google.android.gms.common.internal.zzu.zzb(googleApiClient, "client is null");
        com.google.android.gms.common.internal.zzu.zzb(uri, "uri is null");
        return googleApiClient.zzb(new zzf<Status>(googleApiClient) { // from class: com.google.android.gms.wearable.internal.ChannelImpl.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zzbk zzbkVar) throws RemoteException {
                zzbkVar.zza(this, ChannelImpl.this.zzaTK, uri, z);
            }

            @Override // com.google.android.gms.common.api.AbstractPendingResult
            /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
            public Status createFailedResult(Status status) {
                return status;
            }
        });
    }

    @Override // com.google.android.gms.wearable.Channel
    public PendingResult<Status> removeListener(GoogleApiClient googleApiClient, ChannelApi.ChannelListener channelListener) {
        com.google.android.gms.common.internal.zzu.zzb(googleApiClient, "client is null");
        com.google.android.gms.common.internal.zzu.zzb(channelListener, "listener is null");
        return googleApiClient.zza((GoogleApiClient) new zzi.zzc(googleApiClient, channelListener, this.zzaTK));
    }

    @Override // com.google.android.gms.wearable.Channel
    public PendingResult<Status> sendFile(GoogleApiClient googleApiClient, Uri uri) {
        return sendFile(googleApiClient, uri, 0L, -1L);
    }

    @Override // com.google.android.gms.wearable.Channel
    public PendingResult<Status> sendFile(GoogleApiClient googleApiClient, final Uri uri, final long j, final long j2) {
        com.google.android.gms.common.internal.zzu.zzb(googleApiClient, "client is null");
        com.google.android.gms.common.internal.zzu.zzb(this.zzaTK, "token is null");
        com.google.android.gms.common.internal.zzu.zzb(uri, "uri is null");
        boolean z = true;
        com.google.android.gms.common.internal.zzu.zzb(j >= 0, "startOffset is negative: %s", Long.valueOf(j));
        if (j2 < 0 && j2 != -1) {
            z = false;
        }
        com.google.android.gms.common.internal.zzu.zzb(z, "invalid length: %s", Long.valueOf(j2));
        return googleApiClient.zzb(new zzf<Status>(googleApiClient) { // from class: com.google.android.gms.wearable.internal.ChannelImpl.6
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zzbk zzbkVar) throws RemoteException {
                zzbkVar.zza(this, ChannelImpl.this.zzaTK, uri, j, j2);
            }

            @Override // com.google.android.gms.common.api.AbstractPendingResult
            /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
            public Status createFailedResult(Status status) {
                return status;
            }
        });
    }

    public String toString() {
        return "ChannelImpl{versionCode=" + this.zzCY + ", token='" + this.zzaTK + "', nodeId='" + this.zzaST + "', path='" + this.zzaTQ + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzl.zza(this, parcel, i);
    }
}
