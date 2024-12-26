package com.google.android.gms.cast;

import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.internal.zze;
import com.google.android.gms.cast.internal.zzm;
import com.google.android.gms.cast.internal.zzn;
import com.google.android.gms.cast.internal.zzo;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import java.io.IOException;
import java.util.Locale;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class RemoteMediaPlayer implements Cast.MessageReceivedCallback {
    public static final int RESUME_STATE_PAUSE = 2;
    public static final int RESUME_STATE_PLAY = 1;
    public static final int RESUME_STATE_UNCHANGED = 0;
    public static final int STATUS_CANCELED = 2101;
    public static final int STATUS_FAILED = 2100;
    public static final int STATUS_REPLACED = 2103;
    public static final int STATUS_SUCCEEDED = 0;
    public static final int STATUS_TIMED_OUT = 2102;
    private OnPreloadStatusUpdatedListener zzSv;
    private OnQueueStatusUpdatedListener zzSw;
    private OnMetadataUpdatedListener zzSx;
    private OnStatusUpdatedListener zzSy;
    private final Object zzqt = new Object();
    private final zza zzSu = new zza();
    private final zzm zzSt = new zzm(null) { // from class: com.google.android.gms.cast.RemoteMediaPlayer.1
        @Override // com.google.android.gms.cast.internal.zzm
        protected void onMetadataUpdated() {
            RemoteMediaPlayer.this.onMetadataUpdated();
        }

        @Override // com.google.android.gms.cast.internal.zzm
        protected void onPreloadStatusUpdated() {
            RemoteMediaPlayer.this.onPreloadStatusUpdated();
        }

        @Override // com.google.android.gms.cast.internal.zzm
        protected void onQueueStatusUpdated() {
            RemoteMediaPlayer.this.onQueueStatusUpdated();
        }

        @Override // com.google.android.gms.cast.internal.zzm
        protected void onStatusUpdated() {
            RemoteMediaPlayer.this.onStatusUpdated();
        }
    };

    public interface MediaChannelResult extends Result {
        JSONObject getCustomData();
    }

    public interface OnMetadataUpdatedListener {
        void onMetadataUpdated();
    }

    public interface OnPreloadStatusUpdatedListener {
        void onPreloadStatusUpdated();
    }

    public interface OnQueueStatusUpdatedListener {
        void onQueueStatusUpdated();
    }

    public interface OnStatusUpdatedListener {
        void onStatusUpdated();
    }

    private class zza implements zzn {
        private GoogleApiClient zzSW;
        private long zzSX = 0;

        /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer$zza$zza, reason: collision with other inner class name */
        private final class C0033zza implements ResultCallback<Status> {
            private final long zzSY;

            C0033zza(long j) {
                this.zzSY = j;
            }

            @Override // com.google.android.gms.common.api.ResultCallback
            /* renamed from: zzm, reason: merged with bridge method [inline-methods] */
            public void onResult(Status status) {
                if (status.isSuccess()) {
                    return;
                }
                RemoteMediaPlayer.this.zzSt.zzb(this.zzSY, status.getStatusCode());
            }
        }

        public zza() {
        }

        @Override // com.google.android.gms.cast.internal.zzn
        public void zza(String str, String str2, long j, String str3) throws IOException {
            if (this.zzSW == null) {
                throw new IOException("No GoogleApiClient available");
            }
            Cast.CastApi.sendMessage(this.zzSW, str, str2).setResultCallback(new C0033zza(j));
        }

        public void zzb(GoogleApiClient googleApiClient) {
            this.zzSW = googleApiClient;
        }

        @Override // com.google.android.gms.cast.internal.zzn
        public long zzlu() {
            long j = this.zzSX + 1;
            this.zzSX = j;
            return j;
        }
    }

    private static abstract class zzb extends com.google.android.gms.cast.internal.zzb<MediaChannelResult> {
        zzo zzTa;

        zzb(GoogleApiClient googleApiClient) {
            super(googleApiClient);
            this.zzTa = new zzo() { // from class: com.google.android.gms.cast.RemoteMediaPlayer.zzb.1
                @Override // com.google.android.gms.cast.internal.zzo
                public void zza(long j, int i, Object obj) {
                    zzb.this.setResult(new zzc(new Status(i), obj instanceof JSONObject ? (JSONObject) obj : null));
                }

                @Override // com.google.android.gms.cast.internal.zzo
                public void zzy(long j) {
                    zzb.this.setResult(zzb.this.createFailedResult(new Status(2103)));
                }
            };
        }

        @Override // com.google.android.gms.common.api.AbstractPendingResult
        /* renamed from: zzn, reason: merged with bridge method [inline-methods] */
        public MediaChannelResult createFailedResult(final Status status) {
            return new MediaChannelResult() { // from class: com.google.android.gms.cast.RemoteMediaPlayer.zzb.2
                @Override // com.google.android.gms.cast.RemoteMediaPlayer.MediaChannelResult
                public JSONObject getCustomData() {
                    return null;
                }

                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    private static final class zzc implements MediaChannelResult {
        private final Status zzOt;
        private final JSONObject zzRJ;

        zzc(Status status, JSONObject jSONObject) {
            this.zzOt = status;
            this.zzRJ = jSONObject;
        }

        @Override // com.google.android.gms.cast.RemoteMediaPlayer.MediaChannelResult
        public JSONObject getCustomData() {
            return this.zzRJ;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzOt;
        }
    }

    public RemoteMediaPlayer() {
        this.zzSt.zza(this.zzSu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onMetadataUpdated() {
        if (this.zzSx != null) {
            this.zzSx.onMetadataUpdated();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPreloadStatusUpdated() {
        if (this.zzSv != null) {
            this.zzSv.onPreloadStatusUpdated();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onQueueStatusUpdated() {
        if (this.zzSw != null) {
            this.zzSw.onQueueStatusUpdated();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStatusUpdated() {
        if (this.zzSy != null) {
            this.zzSy.onStatusUpdated();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int zzaH(int i) {
        MediaStatus mediaStatus = getMediaStatus();
        for (int i2 = 0; i2 < mediaStatus.getQueueItemCount(); i2++) {
            if (mediaStatus.getQueueItem(i2).getItemId() == i) {
                return i2;
            }
        }
        return -1;
    }

    public long getApproximateStreamPosition() {
        long approximateStreamPosition;
        synchronized (this.zzqt) {
            approximateStreamPosition = this.zzSt.getApproximateStreamPosition();
        }
        return approximateStreamPosition;
    }

    public MediaInfo getMediaInfo() {
        MediaInfo mediaInfo;
        synchronized (this.zzqt) {
            mediaInfo = this.zzSt.getMediaInfo();
        }
        return mediaInfo;
    }

    public MediaStatus getMediaStatus() {
        MediaStatus mediaStatus;
        synchronized (this.zzqt) {
            mediaStatus = this.zzSt.getMediaStatus();
        }
        return mediaStatus;
    }

    public String getNamespace() {
        return this.zzSt.getNamespace();
    }

    public long getStreamDuration() {
        long streamDuration;
        synchronized (this.zzqt) {
            streamDuration = this.zzSt.getStreamDuration();
        }
        return streamDuration;
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient googleApiClient, MediaInfo mediaInfo) {
        return load(googleApiClient, mediaInfo, true, 0L, null, null);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient googleApiClient, MediaInfo mediaInfo, boolean z) {
        return load(googleApiClient, mediaInfo, z, 0L, null, null);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient googleApiClient, MediaInfo mediaInfo, boolean z, long j) {
        return load(googleApiClient, mediaInfo, z, j, null, null);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient googleApiClient, MediaInfo mediaInfo, boolean z, long j, JSONObject jSONObject) {
        return load(googleApiClient, mediaInfo, z, j, null, jSONObject);
    }

    public PendingResult<MediaChannelResult> load(final GoogleApiClient googleApiClient, final MediaInfo mediaInfo, final boolean z, final long j, final long[] jArr, final JSONObject jSONObject) {
        return googleApiClient.zzb(new zzb(googleApiClient) { // from class: com.google.android.gms.cast.RemoteMediaPlayer.12
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zze zzeVar) {
                zza zzaVar;
                synchronized (RemoteMediaPlayer.this.zzqt) {
                    RemoteMediaPlayer.this.zzSu.zzb(googleApiClient);
                    try {
                        try {
                            RemoteMediaPlayer.this.zzSt.zza(this.zzTa, mediaInfo, z, j, jArr, jSONObject);
                            zzaVar = RemoteMediaPlayer.this.zzSu;
                        } catch (IOException e) {
                            setResult(createFailedResult(new Status(2100)));
                            zzaVar = RemoteMediaPlayer.this.zzSu;
                        }
                        zzaVar.zzb(null);
                    } catch (Throwable th) {
                        RemoteMediaPlayer.this.zzSu.zzb(null);
                        throw th;
                    }
                }
            }
        });
    }

    @Override // com.google.android.gms.cast.Cast.MessageReceivedCallback
    public void onMessageReceived(CastDevice castDevice, String str, String str2) {
        this.zzSt.zzbB(str2);
    }

    public PendingResult<MediaChannelResult> pause(GoogleApiClient googleApiClient) {
        return pause(googleApiClient, null);
    }

    public PendingResult<MediaChannelResult> pause(final GoogleApiClient googleApiClient, final JSONObject jSONObject) {
        return googleApiClient.zzb(new zzb(googleApiClient) { // from class: com.google.android.gms.cast.RemoteMediaPlayer.16
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zze zzeVar) {
                zza zzaVar;
                synchronized (RemoteMediaPlayer.this.zzqt) {
                    RemoteMediaPlayer.this.zzSu.zzb(googleApiClient);
                    try {
                        try {
                            RemoteMediaPlayer.this.zzSt.zza(this.zzTa, jSONObject);
                            zzaVar = RemoteMediaPlayer.this.zzSu;
                        } catch (IOException e) {
                            setResult(createFailedResult(new Status(2100)));
                            zzaVar = RemoteMediaPlayer.this.zzSu;
                        }
                        zzaVar.zzb(null);
                    } catch (Throwable th) {
                        RemoteMediaPlayer.this.zzSu.zzb(null);
                        throw th;
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> play(GoogleApiClient googleApiClient) {
        return play(googleApiClient, null);
    }

    public PendingResult<MediaChannelResult> play(final GoogleApiClient googleApiClient, final JSONObject jSONObject) {
        return googleApiClient.zzb(new zzb(googleApiClient) { // from class: com.google.android.gms.cast.RemoteMediaPlayer.18
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zze zzeVar) {
                zza zzaVar;
                synchronized (RemoteMediaPlayer.this.zzqt) {
                    RemoteMediaPlayer.this.zzSu.zzb(googleApiClient);
                    try {
                        try {
                            RemoteMediaPlayer.this.zzSt.zzc(this.zzTa, jSONObject);
                            zzaVar = RemoteMediaPlayer.this.zzSu;
                        } catch (IOException e) {
                            setResult(createFailedResult(new Status(2100)));
                            zzaVar = RemoteMediaPlayer.this.zzSu;
                        }
                        zzaVar.zzb(null);
                    } catch (Throwable th) {
                        RemoteMediaPlayer.this.zzSu.zzb(null);
                        throw th;
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queueAppendItem(GoogleApiClient googleApiClient, MediaQueueItem mediaQueueItem, JSONObject jSONObject) throws IllegalArgumentException {
        return queueInsertItems(googleApiClient, new MediaQueueItem[]{mediaQueueItem}, 0, jSONObject);
    }

    public PendingResult<MediaChannelResult> queueInsertItems(final GoogleApiClient googleApiClient, final MediaQueueItem[] mediaQueueItemArr, final int i, final JSONObject jSONObject) throws IllegalArgumentException {
        return googleApiClient.zzb(new zzb(googleApiClient) { // from class: com.google.android.gms.cast.RemoteMediaPlayer.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zze zzeVar) {
                zza zzaVar;
                synchronized (RemoteMediaPlayer.this.zzqt) {
                    RemoteMediaPlayer.this.zzSu.zzb(googleApiClient);
                    try {
                        try {
                            RemoteMediaPlayer.this.zzSt.zza(this.zzTa, mediaQueueItemArr, i, jSONObject);
                            zzaVar = RemoteMediaPlayer.this.zzSu;
                        } catch (Throwable th) {
                            RemoteMediaPlayer.this.zzSu.zzb(null);
                            throw th;
                        }
                    } catch (IOException e) {
                        setResult(createFailedResult(new Status(2100)));
                        zzaVar = RemoteMediaPlayer.this.zzSu;
                    }
                    zzaVar.zzb(null);
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queueJumpToItem(final GoogleApiClient googleApiClient, final int i, final JSONObject jSONObject) {
        return googleApiClient.zzb(new zzb(googleApiClient) { // from class: com.google.android.gms.cast.RemoteMediaPlayer.14
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zze zzeVar) {
                zza zzaVar;
                synchronized (RemoteMediaPlayer.this.zzqt) {
                    if (RemoteMediaPlayer.this.zzaH(i) == -1) {
                        setResult(createFailedResult(new Status(0)));
                        return;
                    }
                    RemoteMediaPlayer.this.zzSu.zzb(googleApiClient);
                    try {
                        try {
                            RemoteMediaPlayer.this.zzSt.zza(this.zzTa, i, (MediaQueueItem[]) null, 0, (Integer) null, jSONObject);
                            zzaVar = RemoteMediaPlayer.this.zzSu;
                        } catch (IOException e) {
                            setResult(createFailedResult(new Status(2100)));
                            zzaVar = RemoteMediaPlayer.this.zzSu;
                        }
                        zzaVar.zzb(null);
                    } catch (Throwable th) {
                        RemoteMediaPlayer.this.zzSu.zzb(null);
                        throw th;
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queueLoad(final GoogleApiClient googleApiClient, final MediaQueueItem[] mediaQueueItemArr, final int i, final int i2, final JSONObject jSONObject) throws IllegalArgumentException {
        return googleApiClient.zzb(new zzb(googleApiClient) { // from class: com.google.android.gms.cast.RemoteMediaPlayer.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zze zzeVar) {
                zza zzaVar;
                synchronized (RemoteMediaPlayer.this.zzqt) {
                    RemoteMediaPlayer.this.zzSu.zzb(googleApiClient);
                    try {
                        try {
                            RemoteMediaPlayer.this.zzSt.zza(this.zzTa, mediaQueueItemArr, i, i2, jSONObject);
                            zzaVar = RemoteMediaPlayer.this.zzSu;
                        } catch (IOException e) {
                            setResult(createFailedResult(new Status(2100)));
                            zzaVar = RemoteMediaPlayer.this.zzSu;
                        }
                        zzaVar.zzb(null);
                    } catch (Throwable th) {
                        RemoteMediaPlayer.this.zzSu.zzb(null);
                        throw th;
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queueMoveItemToNewIndex(final GoogleApiClient googleApiClient, final int i, final int i2, final JSONObject jSONObject) {
        return googleApiClient.zzb(new zzb(googleApiClient) { // from class: com.google.android.gms.cast.RemoteMediaPlayer.15
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zze zzeVar) {
                zza zzaVar;
                synchronized (RemoteMediaPlayer.this.zzqt) {
                    int zzaH = RemoteMediaPlayer.this.zzaH(i);
                    if (zzaH == -1) {
                        setResult(createFailedResult(new Status(0)));
                        return;
                    }
                    if (i2 < 0) {
                        setResult(createFailedResult(new Status(2001, String.format(Locale.ROOT, "Invalid request: Invalid newIndex %d.", Integer.valueOf(i2)))));
                        return;
                    }
                    if (zzaH == i2) {
                        setResult(createFailedResult(new Status(0)));
                        return;
                    }
                    MediaQueueItem queueItem = RemoteMediaPlayer.this.getMediaStatus().getQueueItem(i2 > zzaH ? i2 + 1 : i2);
                    int itemId = queueItem != null ? queueItem.getItemId() : 0;
                    RemoteMediaPlayer.this.zzSu.zzb(googleApiClient);
                    try {
                        try {
                            RemoteMediaPlayer.this.zzSt.zza(this.zzTa, new int[]{i}, itemId, jSONObject);
                            zzaVar = RemoteMediaPlayer.this.zzSu;
                        } catch (Throwable th) {
                            RemoteMediaPlayer.this.zzSu.zzb(null);
                            throw th;
                        }
                    } catch (IOException e) {
                        setResult(createFailedResult(new Status(2100)));
                        zzaVar = RemoteMediaPlayer.this.zzSu;
                    }
                    zzaVar.zzb(null);
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queueNext(final GoogleApiClient googleApiClient, final JSONObject jSONObject) {
        return googleApiClient.zzb(new zzb(googleApiClient) { // from class: com.google.android.gms.cast.RemoteMediaPlayer.10
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zze zzeVar) {
                zza zzaVar;
                synchronized (RemoteMediaPlayer.this.zzqt) {
                    RemoteMediaPlayer.this.zzSu.zzb(googleApiClient);
                    try {
                        try {
                            RemoteMediaPlayer.this.zzSt.zza(this.zzTa, 0, (MediaQueueItem[]) null, 1, (Integer) null, jSONObject);
                            zzaVar = RemoteMediaPlayer.this.zzSu;
                        } catch (Throwable th) {
                            RemoteMediaPlayer.this.zzSu.zzb(null);
                            throw th;
                        }
                    } catch (IOException e) {
                        setResult(createFailedResult(new Status(2100)));
                        zzaVar = RemoteMediaPlayer.this.zzSu;
                    }
                    zzaVar.zzb(null);
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queuePrev(final GoogleApiClient googleApiClient, final JSONObject jSONObject) {
        return googleApiClient.zzb(new zzb(googleApiClient) { // from class: com.google.android.gms.cast.RemoteMediaPlayer.9
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zze zzeVar) {
                zza zzaVar;
                synchronized (RemoteMediaPlayer.this.zzqt) {
                    RemoteMediaPlayer.this.zzSu.zzb(googleApiClient);
                    try {
                        try {
                            RemoteMediaPlayer.this.zzSt.zza(this.zzTa, 0, (MediaQueueItem[]) null, -1, (Integer) null, jSONObject);
                            zzaVar = RemoteMediaPlayer.this.zzSu;
                        } catch (Throwable th) {
                            RemoteMediaPlayer.this.zzSu.zzb(null);
                            throw th;
                        }
                    } catch (IOException e) {
                        setResult(createFailedResult(new Status(2100)));
                        zzaVar = RemoteMediaPlayer.this.zzSu;
                    }
                    zzaVar.zzb(null);
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queueRemoveItem(final GoogleApiClient googleApiClient, final int i, final JSONObject jSONObject) {
        return googleApiClient.zzb(new zzb(googleApiClient) { // from class: com.google.android.gms.cast.RemoteMediaPlayer.13
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zze zzeVar) {
                zza zzaVar;
                synchronized (RemoteMediaPlayer.this.zzqt) {
                    if (RemoteMediaPlayer.this.zzaH(i) == -1) {
                        setResult(createFailedResult(new Status(0)));
                        return;
                    }
                    RemoteMediaPlayer.this.zzSu.zzb(googleApiClient);
                    try {
                        try {
                            RemoteMediaPlayer.this.zzSt.zza(this.zzTa, new int[]{i}, jSONObject);
                            zzaVar = RemoteMediaPlayer.this.zzSu;
                        } catch (IOException e) {
                            setResult(createFailedResult(new Status(2100)));
                            zzaVar = RemoteMediaPlayer.this.zzSu;
                        }
                        zzaVar.zzb(null);
                    } catch (Throwable th) {
                        RemoteMediaPlayer.this.zzSu.zzb(null);
                        throw th;
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queueRemoveItems(final GoogleApiClient googleApiClient, final int[] iArr, final JSONObject jSONObject) throws IllegalArgumentException {
        return googleApiClient.zzb(new zzb(googleApiClient) { // from class: com.google.android.gms.cast.RemoteMediaPlayer.7
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zze zzeVar) {
                zza zzaVar;
                synchronized (RemoteMediaPlayer.this.zzqt) {
                    RemoteMediaPlayer.this.zzSu.zzb(googleApiClient);
                    try {
                        try {
                            RemoteMediaPlayer.this.zzSt.zza(this.zzTa, iArr, jSONObject);
                            zzaVar = RemoteMediaPlayer.this.zzSu;
                        } catch (IOException e) {
                            setResult(createFailedResult(new Status(2100)));
                            zzaVar = RemoteMediaPlayer.this.zzSu;
                        }
                        zzaVar.zzb(null);
                    } catch (Throwable th) {
                        RemoteMediaPlayer.this.zzSu.zzb(null);
                        throw th;
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queueReorderItems(final GoogleApiClient googleApiClient, final int[] iArr, final int i, final JSONObject jSONObject) throws IllegalArgumentException {
        return googleApiClient.zzb(new zzb(googleApiClient) { // from class: com.google.android.gms.cast.RemoteMediaPlayer.8
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zze zzeVar) {
                zza zzaVar;
                synchronized (RemoteMediaPlayer.this.zzqt) {
                    RemoteMediaPlayer.this.zzSu.zzb(googleApiClient);
                    try {
                        try {
                            RemoteMediaPlayer.this.zzSt.zza(this.zzTa, iArr, i, jSONObject);
                            zzaVar = RemoteMediaPlayer.this.zzSu;
                        } catch (Throwable th) {
                            RemoteMediaPlayer.this.zzSu.zzb(null);
                            throw th;
                        }
                    } catch (IOException e) {
                        setResult(createFailedResult(new Status(2100)));
                        zzaVar = RemoteMediaPlayer.this.zzSu;
                    }
                    zzaVar.zzb(null);
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queueSetRepeatMode(final GoogleApiClient googleApiClient, final int i, final JSONObject jSONObject) {
        return googleApiClient.zzb(new zzb(googleApiClient) { // from class: com.google.android.gms.cast.RemoteMediaPlayer.11
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zze zzeVar) {
                zza zzaVar;
                synchronized (RemoteMediaPlayer.this.zzqt) {
                    RemoteMediaPlayer.this.zzSu.zzb(googleApiClient);
                    try {
                        try {
                            RemoteMediaPlayer.this.zzSt.zza(this.zzTa, 0, (MediaQueueItem[]) null, 0, Integer.valueOf(i), jSONObject);
                            zzaVar = RemoteMediaPlayer.this.zzSu;
                        } catch (IOException e) {
                            setResult(createFailedResult(new Status(2100)));
                            zzaVar = RemoteMediaPlayer.this.zzSu;
                        }
                        zzaVar.zzb(null);
                    } catch (Throwable th) {
                        RemoteMediaPlayer.this.zzSu.zzb(null);
                        throw th;
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queueUpdateItems(final GoogleApiClient googleApiClient, final MediaQueueItem[] mediaQueueItemArr, final JSONObject jSONObject) {
        return googleApiClient.zzb(new zzb(googleApiClient) { // from class: com.google.android.gms.cast.RemoteMediaPlayer.6
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zze zzeVar) {
                zza zzaVar;
                synchronized (RemoteMediaPlayer.this.zzqt) {
                    RemoteMediaPlayer.this.zzSu.zzb(googleApiClient);
                    try {
                        try {
                            RemoteMediaPlayer.this.zzSt.zza(this.zzTa, 0, mediaQueueItemArr, 0, (Integer) null, jSONObject);
                            zzaVar = RemoteMediaPlayer.this.zzSu;
                        } catch (Throwable th) {
                            RemoteMediaPlayer.this.zzSu.zzb(null);
                            throw th;
                        }
                    } catch (IOException e) {
                        setResult(createFailedResult(new Status(2100)));
                        zzaVar = RemoteMediaPlayer.this.zzSu;
                    }
                    zzaVar.zzb(null);
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> requestStatus(final GoogleApiClient googleApiClient) {
        return googleApiClient.zzb(new zzb(googleApiClient) { // from class: com.google.android.gms.cast.RemoteMediaPlayer.22
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zze zzeVar) {
                zza zzaVar;
                synchronized (RemoteMediaPlayer.this.zzqt) {
                    RemoteMediaPlayer.this.zzSu.zzb(googleApiClient);
                    try {
                        try {
                            RemoteMediaPlayer.this.zzSt.zza(this.zzTa);
                            zzaVar = RemoteMediaPlayer.this.zzSu;
                        } catch (IOException e) {
                            setResult(createFailedResult(new Status(2100)));
                            zzaVar = RemoteMediaPlayer.this.zzSu;
                        }
                        zzaVar.zzb(null);
                    } catch (Throwable th) {
                        RemoteMediaPlayer.this.zzSu.zzb(null);
                        throw th;
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> seek(GoogleApiClient googleApiClient, long j) {
        return seek(googleApiClient, j, 0, null);
    }

    public PendingResult<MediaChannelResult> seek(GoogleApiClient googleApiClient, long j, int i) {
        return seek(googleApiClient, j, i, null);
    }

    public PendingResult<MediaChannelResult> seek(final GoogleApiClient googleApiClient, final long j, final int i, final JSONObject jSONObject) {
        return googleApiClient.zzb(new zzb(googleApiClient) { // from class: com.google.android.gms.cast.RemoteMediaPlayer.19
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zze zzeVar) {
                zza zzaVar;
                synchronized (RemoteMediaPlayer.this.zzqt) {
                    RemoteMediaPlayer.this.zzSu.zzb(googleApiClient);
                    try {
                        try {
                            RemoteMediaPlayer.this.zzSt.zza(this.zzTa, j, i, jSONObject);
                            zzaVar = RemoteMediaPlayer.this.zzSu;
                        } catch (Throwable th) {
                            RemoteMediaPlayer.this.zzSu.zzb(null);
                            throw th;
                        }
                    } catch (IOException e) {
                        setResult(createFailedResult(new Status(2100)));
                        zzaVar = RemoteMediaPlayer.this.zzSu;
                    }
                    zzaVar.zzb(null);
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> setActiveMediaTracks(final GoogleApiClient googleApiClient, final long[] jArr) {
        if (jArr != null) {
            return googleApiClient.zzb(new zzb(googleApiClient) { // from class: com.google.android.gms.cast.RemoteMediaPlayer.2
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
                public void zza(zze zzeVar) {
                    zza zzaVar;
                    synchronized (RemoteMediaPlayer.this.zzqt) {
                        RemoteMediaPlayer.this.zzSu.zzb(googleApiClient);
                        try {
                            try {
                                RemoteMediaPlayer.this.zzSt.zza(this.zzTa, jArr);
                                zzaVar = RemoteMediaPlayer.this.zzSu;
                            } catch (IOException e) {
                                setResult(createFailedResult(new Status(2100)));
                                zzaVar = RemoteMediaPlayer.this.zzSu;
                            }
                            zzaVar.zzb(null);
                        } catch (Throwable th) {
                            RemoteMediaPlayer.this.zzSu.zzb(null);
                            throw th;
                        }
                    }
                }
            });
        }
        throw new IllegalArgumentException("trackIds cannot be null");
    }

    public void setOnMetadataUpdatedListener(OnMetadataUpdatedListener onMetadataUpdatedListener) {
        this.zzSx = onMetadataUpdatedListener;
    }

    public void setOnPreloadStatusUpdatedListener(OnPreloadStatusUpdatedListener onPreloadStatusUpdatedListener) {
        this.zzSv = onPreloadStatusUpdatedListener;
    }

    public void setOnQueueStatusUpdatedListener(OnQueueStatusUpdatedListener onQueueStatusUpdatedListener) {
        this.zzSw = onQueueStatusUpdatedListener;
    }

    public void setOnStatusUpdatedListener(OnStatusUpdatedListener onStatusUpdatedListener) {
        this.zzSy = onStatusUpdatedListener;
    }

    public PendingResult<MediaChannelResult> setStreamMute(GoogleApiClient googleApiClient, boolean z) {
        return setStreamMute(googleApiClient, z, null);
    }

    public PendingResult<MediaChannelResult> setStreamMute(final GoogleApiClient googleApiClient, final boolean z, final JSONObject jSONObject) {
        return googleApiClient.zzb(new zzb(googleApiClient) { // from class: com.google.android.gms.cast.RemoteMediaPlayer.21
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zze zzeVar) {
                zza zzaVar;
                synchronized (RemoteMediaPlayer.this.zzqt) {
                    RemoteMediaPlayer.this.zzSu.zzb(googleApiClient);
                    try {
                        try {
                            RemoteMediaPlayer.this.zzSt.zza(this.zzTa, z, jSONObject);
                            zzaVar = RemoteMediaPlayer.this.zzSu;
                        } catch (Throwable th) {
                            RemoteMediaPlayer.this.zzSu.zzb(null);
                            throw th;
                        }
                    } catch (IOException | IllegalStateException e) {
                        setResult(createFailedResult(new Status(2100)));
                        zzaVar = RemoteMediaPlayer.this.zzSu;
                    }
                    zzaVar.zzb(null);
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> setStreamVolume(GoogleApiClient googleApiClient, double d) throws IllegalArgumentException {
        return setStreamVolume(googleApiClient, d, null);
    }

    public PendingResult<MediaChannelResult> setStreamVolume(final GoogleApiClient googleApiClient, final double d, final JSONObject jSONObject) throws IllegalArgumentException {
        if (Double.isInfinite(d) || Double.isNaN(d)) {
            throw new IllegalArgumentException("Volume cannot be " + d);
        }
        return googleApiClient.zzb(new zzb(googleApiClient) { // from class: com.google.android.gms.cast.RemoteMediaPlayer.20
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zze zzeVar) {
                zza zzaVar;
                synchronized (RemoteMediaPlayer.this.zzqt) {
                    RemoteMediaPlayer.this.zzSu.zzb(googleApiClient);
                    try {
                        try {
                            RemoteMediaPlayer.this.zzSt.zza(this.zzTa, d, jSONObject);
                            zzaVar = RemoteMediaPlayer.this.zzSu;
                        } catch (Throwable th) {
                            RemoteMediaPlayer.this.zzSu.zzb(null);
                            throw th;
                        }
                    } catch (IOException | IllegalArgumentException | IllegalStateException e) {
                        setResult(createFailedResult(new Status(2100)));
                        zzaVar = RemoteMediaPlayer.this.zzSu;
                    }
                    zzaVar.zzb(null);
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> setTextTrackStyle(final GoogleApiClient googleApiClient, final TextTrackStyle textTrackStyle) {
        if (textTrackStyle != null) {
            return googleApiClient.zzb(new zzb(googleApiClient) { // from class: com.google.android.gms.cast.RemoteMediaPlayer.3
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
                public void zza(zze zzeVar) {
                    zza zzaVar;
                    synchronized (RemoteMediaPlayer.this.zzqt) {
                        RemoteMediaPlayer.this.zzSu.zzb(googleApiClient);
                        try {
                            try {
                                RemoteMediaPlayer.this.zzSt.zza(this.zzTa, textTrackStyle);
                                zzaVar = RemoteMediaPlayer.this.zzSu;
                            } catch (IOException e) {
                                setResult(createFailedResult(new Status(2100)));
                                zzaVar = RemoteMediaPlayer.this.zzSu;
                            }
                            zzaVar.zzb(null);
                        } catch (Throwable th) {
                            RemoteMediaPlayer.this.zzSu.zzb(null);
                            throw th;
                        }
                    }
                }
            });
        }
        throw new IllegalArgumentException("trackStyle cannot be null");
    }

    public PendingResult<MediaChannelResult> stop(GoogleApiClient googleApiClient) {
        return stop(googleApiClient, null);
    }

    public PendingResult<MediaChannelResult> stop(final GoogleApiClient googleApiClient, final JSONObject jSONObject) {
        return googleApiClient.zzb(new zzb(googleApiClient) { // from class: com.google.android.gms.cast.RemoteMediaPlayer.17
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zze zzeVar) {
                zza zzaVar;
                synchronized (RemoteMediaPlayer.this.zzqt) {
                    RemoteMediaPlayer.this.zzSu.zzb(googleApiClient);
                    try {
                        try {
                            RemoteMediaPlayer.this.zzSt.zzb(this.zzTa, jSONObject);
                            zzaVar = RemoteMediaPlayer.this.zzSu;
                        } catch (IOException e) {
                            setResult(createFailedResult(new Status(2100)));
                            zzaVar = RemoteMediaPlayer.this.zzSu;
                        }
                        zzaVar.zzb(null);
                    } catch (Throwable th) {
                        RemoteMediaPlayer.this.zzSu.zzb(null);
                        throw th;
                    }
                }
            }
        });
    }
}
