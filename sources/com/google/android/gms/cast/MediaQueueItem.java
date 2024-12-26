package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.internal.zzlh;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class MediaQueueItem {
    public static final double DEFAULT_PLAYBACK_DURATION = Double.POSITIVE_INFINITY;
    public static final int INVALID_ITEM_ID = 0;
    private JSONObject zzRJ;
    private MediaInfo zzRS;
    private int zzRT;
    private boolean zzRU;
    private double zzRV;
    private double zzRW;
    private double zzRX;
    private long[] zzRY;

    public static class Builder {
        private final MediaQueueItem zzRZ;

        public Builder(MediaInfo mediaInfo) throws IllegalArgumentException {
            this.zzRZ = new MediaQueueItem(mediaInfo);
        }

        public Builder(MediaQueueItem mediaQueueItem) throws IllegalArgumentException {
            this.zzRZ = new MediaQueueItem();
        }

        public Builder(JSONObject jSONObject) throws JSONException {
            this.zzRZ = new MediaQueueItem(jSONObject);
        }

        public MediaQueueItem build() {
            this.zzRZ.zzlq();
            return this.zzRZ;
        }

        public Builder clearItemId() {
            this.zzRZ.zzaC(0);
            return this;
        }

        public Builder setActiveTrackIds(long[] jArr) {
            this.zzRZ.zza(jArr);
            return this;
        }

        public Builder setAutoplay(boolean z) {
            this.zzRZ.zzP(z);
            return this;
        }

        public Builder setCustomData(JSONObject jSONObject) {
            this.zzRZ.setCustomData(jSONObject);
            return this;
        }

        public Builder setPreloadTime(double d) throws IllegalArgumentException {
            this.zzRZ.zzc(d);
            return this;
        }

        public Builder setStartTime(double d) throws IllegalArgumentException {
            this.zzRZ.zzb(d);
            return this;
        }
    }

    private MediaQueueItem(MediaInfo mediaInfo) throws IllegalArgumentException {
        this.zzRT = 0;
        this.zzRU = true;
        this.zzRW = Double.POSITIVE_INFINITY;
        if (mediaInfo == null) {
            throw new IllegalArgumentException("media cannot be null.");
        }
        this.zzRS = mediaInfo;
    }

    private MediaQueueItem(MediaQueueItem mediaQueueItem) throws IllegalArgumentException {
        this.zzRT = 0;
        this.zzRU = true;
        this.zzRW = Double.POSITIVE_INFINITY;
        this.zzRS = mediaQueueItem.getMedia();
        if (this.zzRS == null) {
            throw new IllegalArgumentException("media cannot be null.");
        }
        this.zzRT = mediaQueueItem.getItemId();
        this.zzRU = mediaQueueItem.getAutoplay();
        this.zzRV = mediaQueueItem.getStartTime();
        this.zzRW = mediaQueueItem.zzlr();
        this.zzRX = mediaQueueItem.getPreloadTime();
        this.zzRY = mediaQueueItem.getActiveTrackIds();
        this.zzRJ = mediaQueueItem.getCustomData();
    }

    MediaQueueItem(JSONObject jSONObject) throws JSONException {
        this.zzRT = 0;
        this.zzRU = true;
        this.zzRW = Double.POSITIVE_INFINITY;
        zzg(jSONObject);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaQueueItem)) {
            return false;
        }
        MediaQueueItem mediaQueueItem = (MediaQueueItem) obj;
        if ((this.zzRJ == null) != (mediaQueueItem.zzRJ == null)) {
            return false;
        }
        if (this.zzRJ == null || mediaQueueItem.zzRJ == null || zzlh.zzd(this.zzRJ, mediaQueueItem.zzRJ)) {
            return zzf.zza(this.zzRS, mediaQueueItem.zzRS) && this.zzRT == mediaQueueItem.zzRT && this.zzRU == mediaQueueItem.zzRU && this.zzRV == mediaQueueItem.zzRV && this.zzRW == mediaQueueItem.zzRW && this.zzRX == mediaQueueItem.zzRX && zzf.zza(this.zzRY, mediaQueueItem.zzRY);
        }
        return false;
    }

    public long[] getActiveTrackIds() {
        return this.zzRY;
    }

    public boolean getAutoplay() {
        return this.zzRU;
    }

    public JSONObject getCustomData() {
        return this.zzRJ;
    }

    public int getItemId() {
        return this.zzRT;
    }

    public MediaInfo getMedia() {
        return this.zzRS;
    }

    public double getPreloadTime() {
        return this.zzRX;
    }

    public double getStartTime() {
        return this.zzRV;
    }

    public int hashCode() {
        return zzt.hashCode(this.zzRS, Integer.valueOf(this.zzRT), Boolean.valueOf(this.zzRU), Double.valueOf(this.zzRV), Double.valueOf(this.zzRW), Double.valueOf(this.zzRX), this.zzRY, String.valueOf(this.zzRJ));
    }

    void setCustomData(JSONObject jSONObject) {
        this.zzRJ = jSONObject;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("media", this.zzRS.toJson());
            if (this.zzRT != 0) {
                jSONObject.put("itemId", this.zzRT);
            }
            jSONObject.put("autoplay", this.zzRU);
            jSONObject.put("startTime", this.zzRV);
            if (this.zzRW != Double.POSITIVE_INFINITY) {
                jSONObject.put("playbackDuration", this.zzRW);
            }
            jSONObject.put("preloadTime", this.zzRX);
            if (this.zzRY != null && this.zzRY.length > 0) {
                JSONArray jSONArray = new JSONArray();
                for (long j : this.zzRY) {
                    jSONArray.put(j);
                }
                jSONObject.put("activeTrackIds", jSONArray);
            }
            if (this.zzRJ != null) {
                jSONObject.put("customData", this.zzRJ);
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    void zzP(boolean z) {
        this.zzRU = z;
    }

    void zza(long[] jArr) {
        this.zzRY = jArr;
    }

    void zzaC(int i) {
        this.zzRT = i;
    }

    void zzb(double d) throws IllegalArgumentException {
        if (Double.isNaN(d) || d < 0.0d) {
            throw new IllegalArgumentException("startTime cannot be negative or NaN.");
        }
        this.zzRV = d;
    }

    void zzc(double d) throws IllegalArgumentException {
        if (Double.isNaN(d) || d < 0.0d) {
            throw new IllegalArgumentException("preloadTime cannot be negative or NaN.");
        }
        this.zzRX = d;
    }

    public boolean zzg(JSONObject jSONObject) throws JSONException {
        boolean z;
        long[] jArr;
        boolean z2;
        int i;
        boolean z3 = false;
        if (jSONObject.has("media")) {
            this.zzRS = new MediaInfo(jSONObject.getJSONObject("media"));
            z = true;
        } else {
            z = false;
        }
        if (jSONObject.has("itemId") && this.zzRT != (i = jSONObject.getInt("itemId"))) {
            this.zzRT = i;
            z = true;
        }
        if (jSONObject.has("autoplay") && this.zzRU != (z2 = jSONObject.getBoolean("autoplay"))) {
            this.zzRU = z2;
            z = true;
        }
        if (jSONObject.has("startTime")) {
            double d = jSONObject.getDouble("startTime");
            if (Math.abs(d - this.zzRV) > 1.0E-7d) {
                this.zzRV = d;
                z = true;
            }
        }
        if (jSONObject.has("playbackDuration")) {
            double d2 = jSONObject.getDouble("playbackDuration");
            if (Math.abs(d2 - this.zzRW) > 1.0E-7d) {
                this.zzRW = d2;
                z = true;
            }
        }
        if (jSONObject.has("preloadTime")) {
            double d3 = jSONObject.getDouble("preloadTime");
            if (Math.abs(d3 - this.zzRX) > 1.0E-7d) {
                this.zzRX = d3;
                z = true;
            }
        }
        if (jSONObject.has("activeTrackIds")) {
            JSONArray jSONArray = jSONObject.getJSONArray("activeTrackIds");
            int length = jSONArray.length();
            jArr = new long[length];
            for (int i2 = 0; i2 < length; i2++) {
                jArr[i2] = jSONArray.getLong(i2);
            }
            if (this.zzRY != null && this.zzRY.length == length) {
                for (int i3 = 0; i3 < length; i3++) {
                    if (this.zzRY[i3] == jArr[i3]) {
                    }
                }
            }
            z3 = true;
            break;
        } else {
            jArr = null;
        }
        if (z3) {
            this.zzRY = jArr;
            z = true;
        }
        if (!jSONObject.has("customData")) {
            return z;
        }
        this.zzRJ = jSONObject.getJSONObject("customData");
        return true;
    }

    void zzlq() throws IllegalArgumentException {
        if (this.zzRS == null) {
            throw new IllegalArgumentException("media cannot be null.");
        }
        if (Double.isNaN(this.zzRV) || this.zzRV < 0.0d) {
            throw new IllegalArgumentException("startTime cannot be negative or NaN.");
        }
        if (Double.isNaN(this.zzRW)) {
            throw new IllegalArgumentException("playbackDuration cannot be NaN.");
        }
        if (Double.isNaN(this.zzRX) || this.zzRX < 0.0d) {
            throw new IllegalArgumentException("preloadTime cannot be negative or Nan.");
        }
    }

    public double zzlr() {
        return this.zzRW;
    }
}
