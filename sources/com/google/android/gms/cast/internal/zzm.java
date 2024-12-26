package com.google.android.gms.cast.internal;

import android.os.SystemClock;
import android.support.v7.media.MediaRouteProviderProtocol;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.RemoteMediaPlayer;
import com.google.android.gms.cast.TextTrackStyle;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class zzm extends zzc {
    private static final String NAMESPACE = zzf.zzbE("com.google.cast.media");
    private final List<zzp> zzTo;
    private long zzUY;
    private MediaStatus zzUZ;
    private final zzp zzVa;
    private final zzp zzVb;
    private final zzp zzVc;
    private final zzp zzVd;
    private final zzp zzVe;
    private final zzp zzVf;
    private final zzp zzVg;
    private final zzp zzVh;
    private final zzp zzVi;
    private final zzp zzVj;
    private final zzp zzVk;
    private final zzp zzVl;
    private final zzp zzVm;
    private final zzp zzVn;

    public zzm(String str) {
        super(NAMESPACE, "MediaControlChannel", str, 1000L);
        this.zzVa = new zzp(86400000L);
        this.zzVb = new zzp(86400000L);
        this.zzVc = new zzp(86400000L);
        this.zzVd = new zzp(86400000L);
        this.zzVe = new zzp(86400000L);
        this.zzVf = new zzp(86400000L);
        this.zzVg = new zzp(86400000L);
        this.zzVh = new zzp(86400000L);
        this.zzVi = new zzp(86400000L);
        this.zzVj = new zzp(86400000L);
        this.zzVk = new zzp(86400000L);
        this.zzVl = new zzp(86400000L);
        this.zzVm = new zzp(86400000L);
        this.zzVn = new zzp(86400000L);
        this.zzTo = new ArrayList();
        this.zzTo.add(this.zzVa);
        this.zzTo.add(this.zzVb);
        this.zzTo.add(this.zzVc);
        this.zzTo.add(this.zzVd);
        this.zzTo.add(this.zzVe);
        this.zzTo.add(this.zzVf);
        this.zzTo.add(this.zzVg);
        this.zzTo.add(this.zzVh);
        this.zzTo.add(this.zzVi);
        this.zzTo.add(this.zzVj);
        this.zzTo.add(this.zzVk);
        this.zzTo.add(this.zzVl);
        this.zzTo.add(this.zzVm);
        this.zzTo.add(this.zzVn);
        zzmc();
    }

    private void zza(long j, JSONObject jSONObject) throws JSONException {
        int i;
        boolean zzB = this.zzVa.zzB(j);
        boolean z = true;
        boolean z2 = this.zzVe.zzme() && !this.zzVe.zzB(j);
        if ((!this.zzVf.zzme() || this.zzVf.zzB(j)) && (!this.zzVg.zzme() || this.zzVg.zzB(j))) {
            z = false;
        }
        int i2 = z2 ? 2 : 0;
        if (z) {
            i2 |= 1;
        }
        if (zzB || this.zzUZ == null) {
            this.zzUZ = new MediaStatus(jSONObject);
            this.zzUY = SystemClock.elapsedRealtime();
            i = 31;
        } else {
            i = this.zzUZ.zza(jSONObject, i2);
        }
        if ((i & 1) != 0) {
            this.zzUY = SystemClock.elapsedRealtime();
            onStatusUpdated();
        }
        if ((i & 2) != 0) {
            this.zzUY = SystemClock.elapsedRealtime();
            onStatusUpdated();
        }
        if ((i & 4) != 0) {
            onMetadataUpdated();
        }
        if ((i & 8) != 0) {
            onQueueStatusUpdated();
        }
        if ((i & 16) != 0) {
            onPreloadStatusUpdated();
        }
        Iterator<zzp> it = this.zzTo.iterator();
        while (it.hasNext()) {
            it.next().zzc(j, 0);
        }
    }

    private void zzmc() {
        this.zzUY = 0L;
        this.zzUZ = null;
        Iterator<zzp> it = this.zzTo.iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
    }

    public long getApproximateStreamPosition() {
        MediaInfo mediaInfo = getMediaInfo();
        if (mediaInfo == null || this.zzUY == 0) {
            return 0L;
        }
        double playbackRate = this.zzUZ.getPlaybackRate();
        long streamPosition = this.zzUZ.getStreamPosition();
        int playerState = this.zzUZ.getPlayerState();
        if (playbackRate == 0.0d || playerState != 2) {
            return streamPosition;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.zzUY;
        if (elapsedRealtime < 0) {
            elapsedRealtime = 0;
        }
        if (elapsedRealtime == 0) {
            return streamPosition;
        }
        long streamDuration = mediaInfo.getStreamDuration();
        long j = streamPosition + ((long) (elapsedRealtime * playbackRate));
        if (streamDuration > 0 && j > streamDuration) {
            return streamDuration;
        }
        if (j < 0) {
            return 0L;
        }
        return j;
    }

    public MediaInfo getMediaInfo() {
        if (this.zzUZ == null) {
            return null;
        }
        return this.zzUZ.getMediaInfo();
    }

    public MediaStatus getMediaStatus() {
        return this.zzUZ;
    }

    public long getStreamDuration() {
        MediaInfo mediaInfo = getMediaInfo();
        if (mediaInfo != null) {
            return mediaInfo.getStreamDuration();
        }
        return 0L;
    }

    protected void onMetadataUpdated() {
    }

    protected void onPreloadStatusUpdated() {
    }

    protected void onQueueStatusUpdated() {
    }

    protected void onStatusUpdated() {
    }

    public long zza(zzo zzoVar) throws IOException {
        JSONObject jSONObject = new JSONObject();
        long zzlK = zzlK();
        this.zzVh.zza(zzlK, zzoVar);
        zzQ(true);
        try {
            jSONObject.put("requestId", zzlK);
            jSONObject.put("type", "GET_STATUS");
            if (this.zzUZ != null) {
                jSONObject.put("mediaSessionId", this.zzUZ.zzls());
            }
        } catch (JSONException e) {
        }
        zza(jSONObject.toString(), zzlK, (String) null);
        return zzlK;
    }

    public long zza(zzo zzoVar, double d, JSONObject jSONObject) throws IOException, IllegalStateException, IllegalArgumentException {
        if (Double.isInfinite(d) || Double.isNaN(d)) {
            throw new IllegalArgumentException("Volume cannot be " + d);
        }
        JSONObject jSONObject2 = new JSONObject();
        long zzlK = zzlK();
        this.zzVf.zza(zzlK, zzoVar);
        zzQ(true);
        try {
            jSONObject2.put("requestId", zzlK);
            jSONObject2.put("type", "SET_VOLUME");
            jSONObject2.put("mediaSessionId", zzls());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("level", d);
            jSONObject2.put(MediaRouteProviderProtocol.CLIENT_DATA_VOLUME, jSONObject3);
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        zza(jSONObject2.toString(), zzlK, (String) null);
        return zzlK;
    }

    public long zza(zzo zzoVar, int i, MediaQueueItem[] mediaQueueItemArr, int i2, Integer num, JSONObject jSONObject) throws IOException, IllegalStateException {
        String str;
        JSONObject jSONObject2 = new JSONObject();
        long zzlK = zzlK();
        this.zzVl.zza(zzlK, zzoVar);
        zzQ(true);
        try {
            jSONObject2.put("requestId", zzlK);
            jSONObject2.put("type", "QUEUE_UPDATE");
            jSONObject2.put("mediaSessionId", zzls());
            if (i != 0) {
                jSONObject2.put("currentItemId", i);
            }
            if (i2 != 0) {
                jSONObject2.put("jump", i2);
            }
            if (mediaQueueItemArr != null && mediaQueueItemArr.length > 0) {
                JSONArray jSONArray = new JSONArray();
                for (int i3 = 0; i3 < mediaQueueItemArr.length; i3++) {
                    jSONArray.put(i3, mediaQueueItemArr[i3].toJson());
                }
                jSONObject2.put("items", jSONArray);
            }
            if (num != null) {
                switch (num.intValue()) {
                    case 0:
                        str = "REPEAT_OFF";
                        break;
                    case 1:
                        str = "REPEAT_ALL";
                        break;
                    case 2:
                        str = "REPEAT_SINGLE";
                        break;
                    case 3:
                        str = "REPEAT_ALL_AND_SHUFFLE";
                        break;
                }
                jSONObject2.put("repeatMode", str);
            }
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        zza(jSONObject2.toString(), zzlK, (String) null);
        return zzlK;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0042 A[Catch: JSONException -> 0x0048, TRY_LEAVE, TryCatch #0 {JSONException -> 0x0048, blocks: (B:3:0x0012, B:7:0x0036, B:9:0x0042), top: B:2:0x0012 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long zza(com.google.android.gms.cast.internal.zzo r7, long r8, int r10, org.json.JSONObject r11) throws java.io.IOException, java.lang.IllegalStateException {
        /*
            r6 = this;
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            long r1 = r6.zzlK()
            com.google.android.gms.cast.internal.zzp r3 = r6.zzVe
            r3.zza(r1, r7)
            r7 = 1
            r6.zzQ(r7)
            java.lang.String r3 = "requestId"
            r0.put(r3, r1)     // Catch: org.json.JSONException -> L48
            java.lang.String r3 = "type"
            java.lang.String r4 = "SEEK"
            r0.put(r3, r4)     // Catch: org.json.JSONException -> L48
            java.lang.String r3 = "mediaSessionId"
            long r4 = r6.zzls()     // Catch: org.json.JSONException -> L48
            r0.put(r3, r4)     // Catch: org.json.JSONException -> L48
            java.lang.String r3 = "currentTime"
            double r8 = com.google.android.gms.cast.internal.zzf.zzA(r8)     // Catch: org.json.JSONException -> L48
            r0.put(r3, r8)     // Catch: org.json.JSONException -> L48
            java.lang.String r8 = "resumeState"
            if (r10 != r7) goto L3a
            java.lang.String r7 = "PLAYBACK_START"
        L36:
            r0.put(r8, r7)     // Catch: org.json.JSONException -> L48
            goto L40
        L3a:
            r7 = 2
            if (r10 != r7) goto L40
            java.lang.String r7 = "PLAYBACK_PAUSE"
            goto L36
        L40:
            if (r11 == 0) goto L49
            java.lang.String r7 = "customData"
            r0.put(r7, r11)     // Catch: org.json.JSONException -> L48
            goto L49
        L48:
            r7 = move-exception
        L49:
            java.lang.String r7 = r0.toString()
            r8 = 0
            r6.zza(r7, r1, r8)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.internal.zzm.zza(com.google.android.gms.cast.internal.zzo, long, int, org.json.JSONObject):long");
    }

    public long zza(zzo zzoVar, MediaInfo mediaInfo, boolean z, long j, long[] jArr, JSONObject jSONObject) throws IOException {
        JSONObject jSONObject2 = new JSONObject();
        long zzlK = zzlK();
        this.zzVa.zza(zzlK, zzoVar);
        zzQ(true);
        try {
            jSONObject2.put("requestId", zzlK);
            jSONObject2.put("type", "LOAD");
            jSONObject2.put("media", mediaInfo.toJson());
            jSONObject2.put("autoplay", z);
            jSONObject2.put("currentTime", zzf.zzA(j));
            if (jArr != null) {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < jArr.length; i++) {
                    jSONArray.put(i, jArr[i]);
                }
                jSONObject2.put("activeTrackIds", jSONArray);
            }
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        zza(jSONObject2.toString(), zzlK, (String) null);
        return zzlK;
    }

    public long zza(zzo zzoVar, TextTrackStyle textTrackStyle) throws IOException {
        JSONObject jSONObject = new JSONObject();
        long zzlK = zzlK();
        this.zzVj.zza(zzlK, zzoVar);
        zzQ(true);
        try {
            jSONObject.put("requestId", zzlK);
            jSONObject.put("type", "EDIT_TRACKS_INFO");
            if (textTrackStyle != null) {
                jSONObject.put("textTrackStyle", textTrackStyle.toJson());
            }
            jSONObject.put("mediaSessionId", zzls());
        } catch (JSONException e) {
        }
        zza(jSONObject.toString(), zzlK, (String) null);
        return zzlK;
    }

    public long zza(zzo zzoVar, JSONObject jSONObject) throws IOException {
        JSONObject jSONObject2 = new JSONObject();
        long zzlK = zzlK();
        this.zzVb.zza(zzlK, zzoVar);
        zzQ(true);
        try {
            jSONObject2.put("requestId", zzlK);
            jSONObject2.put("type", "PAUSE");
            jSONObject2.put("mediaSessionId", zzls());
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        zza(jSONObject2.toString(), zzlK, (String) null);
        return zzlK;
    }

    public long zza(zzo zzoVar, boolean z, JSONObject jSONObject) throws IOException, IllegalStateException {
        JSONObject jSONObject2 = new JSONObject();
        long zzlK = zzlK();
        this.zzVg.zza(zzlK, zzoVar);
        zzQ(true);
        try {
            jSONObject2.put("requestId", zzlK);
            jSONObject2.put("type", "SET_VOLUME");
            jSONObject2.put("mediaSessionId", zzls());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("muted", z);
            jSONObject2.put(MediaRouteProviderProtocol.CLIENT_DATA_VOLUME, jSONObject3);
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        zza(jSONObject2.toString(), zzlK, (String) null);
        return zzlK;
    }

    public long zza(zzo zzoVar, int[] iArr, int i, JSONObject jSONObject) throws IOException, IllegalStateException, IllegalArgumentException {
        if (iArr == null || iArr.length == 0) {
            throw new IllegalArgumentException("itemIdsToReorder must not be null or empty.");
        }
        JSONObject jSONObject2 = new JSONObject();
        long zzlK = zzlK();
        this.zzVn.zza(zzlK, zzoVar);
        zzQ(true);
        try {
            jSONObject2.put("requestId", zzlK);
            jSONObject2.put("type", "QUEUE_REORDER");
            jSONObject2.put("mediaSessionId", zzls());
            JSONArray jSONArray = new JSONArray();
            for (int i2 = 0; i2 < iArr.length; i2++) {
                jSONArray.put(i2, iArr[i2]);
            }
            jSONObject2.put("itemIds", jSONArray);
            if (i != 0) {
                jSONObject2.put("insertBefore", i);
            }
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        zza(jSONObject2.toString(), zzlK, (String) null);
        return zzlK;
    }

    public long zza(zzo zzoVar, int[] iArr, JSONObject jSONObject) throws IOException, IllegalStateException, IllegalArgumentException {
        if (iArr == null || iArr.length == 0) {
            throw new IllegalArgumentException("itemIdsToRemove must not be null or empty.");
        }
        JSONObject jSONObject2 = new JSONObject();
        long zzlK = zzlK();
        this.zzVm.zza(zzlK, zzoVar);
        zzQ(true);
        try {
            jSONObject2.put("requestId", zzlK);
            jSONObject2.put("type", "QUEUE_REMOVE");
            jSONObject2.put("mediaSessionId", zzls());
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < iArr.length; i++) {
                jSONArray.put(i, iArr[i]);
            }
            jSONObject2.put("itemIds", jSONArray);
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        zza(jSONObject2.toString(), zzlK, (String) null);
        return zzlK;
    }

    public long zza(zzo zzoVar, long[] jArr) throws IOException {
        JSONObject jSONObject = new JSONObject();
        long zzlK = zzlK();
        this.zzVi.zza(zzlK, zzoVar);
        zzQ(true);
        try {
            jSONObject.put("requestId", zzlK);
            jSONObject.put("type", "EDIT_TRACKS_INFO");
            jSONObject.put("mediaSessionId", zzls());
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < jArr.length; i++) {
                jSONArray.put(i, jArr[i]);
            }
            jSONObject.put("activeTrackIds", jSONArray);
        } catch (JSONException e) {
        }
        zza(jSONObject.toString(), zzlK, (String) null);
        return zzlK;
    }

    public long zza(zzo zzoVar, MediaQueueItem[] mediaQueueItemArr, int i, int i2, JSONObject jSONObject) throws IOException, IllegalArgumentException {
        String str;
        if (mediaQueueItemArr == null || mediaQueueItemArr.length == 0) {
            throw new IllegalArgumentException("items must not be null or empty.");
        }
        if (i < 0 || i >= mediaQueueItemArr.length) {
            throw new IllegalArgumentException("Invalid startIndex: " + i);
        }
        JSONObject jSONObject2 = new JSONObject();
        long zzlK = zzlK();
        this.zzVa.zza(zzlK, zzoVar);
        zzQ(true);
        try {
            jSONObject2.put("requestId", zzlK);
            jSONObject2.put("type", "QUEUE_LOAD");
            JSONArray jSONArray = new JSONArray();
            for (int i3 = 0; i3 < mediaQueueItemArr.length; i3++) {
                jSONArray.put(i3, mediaQueueItemArr[i3].toJson());
            }
            jSONObject2.put("items", jSONArray);
            switch (i2) {
                case 0:
                    str = "REPEAT_OFF";
                    break;
                case 1:
                    str = "REPEAT_ALL";
                    break;
                case 2:
                    str = "REPEAT_SINGLE";
                    break;
                case 3:
                    str = "REPEAT_ALL_AND_SHUFFLE";
                    break;
                default:
                    throw new IllegalArgumentException("Invalid repeat mode: " + i2);
            }
            jSONObject2.put("repeatMode", str);
            jSONObject2.put("startIndex", i);
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        zza(jSONObject2.toString(), zzlK, (String) null);
        return zzlK;
    }

    public long zza(zzo zzoVar, MediaQueueItem[] mediaQueueItemArr, int i, JSONObject jSONObject) throws IOException, IllegalStateException, IllegalStateException {
        if (mediaQueueItemArr == null || mediaQueueItemArr.length == 0) {
            throw new IllegalArgumentException("itemsToInsert must not be null or empty.");
        }
        JSONObject jSONObject2 = new JSONObject();
        long zzlK = zzlK();
        this.zzVk.zza(zzlK, zzoVar);
        zzQ(true);
        try {
            jSONObject2.put("requestId", zzlK);
            jSONObject2.put("type", "QUEUE_INSERT");
            jSONObject2.put("mediaSessionId", zzls());
            JSONArray jSONArray = new JSONArray();
            for (int i2 = 0; i2 < mediaQueueItemArr.length; i2++) {
                jSONArray.put(i2, mediaQueueItemArr[i2].toJson());
            }
            jSONObject2.put("items", jSONArray);
            if (i != 0) {
                jSONObject2.put("insertBefore", i);
            }
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        zza(jSONObject2.toString(), zzlK, (String) null);
        return zzlK;
    }

    public long zzb(zzo zzoVar, JSONObject jSONObject) throws IOException {
        JSONObject jSONObject2 = new JSONObject();
        long zzlK = zzlK();
        this.zzVd.zza(zzlK, zzoVar);
        zzQ(true);
        try {
            jSONObject2.put("requestId", zzlK);
            jSONObject2.put("type", "STOP");
            jSONObject2.put("mediaSessionId", zzls());
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        zza(jSONObject2.toString(), zzlK, (String) null);
        return zzlK;
    }

    @Override // com.google.android.gms.cast.internal.zzd
    public void zzb(long j, int i) {
        Iterator<zzp> it = this.zzTo.iterator();
        while (it.hasNext()) {
            it.next().zzc(j, i);
        }
    }

    @Override // com.google.android.gms.cast.internal.zzd
    public final void zzbB(String str) {
        this.zzUi.zzb("message received: %s", str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("type");
            long optLong = jSONObject.optLong("requestId", -1L);
            if (string.equals("MEDIA_STATUS")) {
                JSONArray jSONArray = jSONObject.getJSONArray("status");
                if (jSONArray.length() > 0) {
                    zza(optLong, jSONArray.getJSONObject(0));
                    return;
                }
                this.zzUZ = null;
                onStatusUpdated();
                onMetadataUpdated();
                onQueueStatusUpdated();
                onPreloadStatusUpdated();
                this.zzVh.zzc(optLong, 0);
                return;
            }
            if (string.equals("INVALID_PLAYER_STATE")) {
                this.zzUi.zzf("received unexpected error: Invalid Player State.", new Object[0]);
                JSONObject optJSONObject = jSONObject.optJSONObject("customData");
                Iterator<zzp> it = this.zzTo.iterator();
                while (it.hasNext()) {
                    it.next().zzc(optLong, 2100, optJSONObject);
                }
                return;
            }
            if (string.equals("LOAD_FAILED")) {
                this.zzVa.zzc(optLong, 2100, jSONObject.optJSONObject("customData"));
                return;
            }
            if (string.equals("LOAD_CANCELLED")) {
                this.zzVa.zzc(optLong, RemoteMediaPlayer.STATUS_CANCELED, jSONObject.optJSONObject("customData"));
            } else if (string.equals("INVALID_REQUEST")) {
                this.zzUi.zzf("received unexpected error: Invalid Request.", new Object[0]);
                JSONObject optJSONObject2 = jSONObject.optJSONObject("customData");
                Iterator<zzp> it2 = this.zzTo.iterator();
                while (it2.hasNext()) {
                    it2.next().zzc(optLong, 2100, optJSONObject2);
                }
            }
        } catch (JSONException e) {
            this.zzUi.zzf("Message is malformed (%s); ignoring: %s", e.getMessage(), str);
        }
    }

    public long zzc(zzo zzoVar, JSONObject jSONObject) throws IOException, IllegalStateException {
        JSONObject jSONObject2 = new JSONObject();
        long zzlK = zzlK();
        this.zzVc.zza(zzlK, zzoVar);
        zzQ(true);
        try {
            jSONObject2.put("requestId", zzlK);
            jSONObject2.put("type", "PLAY");
            jSONObject2.put("mediaSessionId", zzls());
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        zza(jSONObject2.toString(), zzlK, (String) null);
        return zzlK;
    }

    @Override // com.google.android.gms.cast.internal.zzc, com.google.android.gms.cast.internal.zzd
    public void zzlJ() {
        super.zzlJ();
        zzmc();
    }

    public long zzls() throws IllegalStateException {
        if (this.zzUZ != null) {
            return this.zzUZ.zzls();
        }
        throw new IllegalStateException("No current media session");
    }

    @Override // com.google.android.gms.cast.internal.zzc
    protected boolean zzz(long j) {
        boolean z;
        Iterator<zzp> it = this.zzTo.iterator();
        while (it.hasNext()) {
            it.next().zzd(j, RemoteMediaPlayer.STATUS_TIMED_OUT);
        }
        synchronized (zzp.zzVr) {
            Iterator<zzp> it2 = this.zzTo.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z = false;
                    break;
                }
                if (it2.next().zzme()) {
                    z = true;
                    break;
                }
            }
        }
        return z;
    }
}
