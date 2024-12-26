package com.google.android.gms.cast;

import android.text.TextUtils;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.internal.zzlh;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class MediaInfo {
    public static final int STREAM_TYPE_BUFFERED = 1;
    public static final int STREAM_TYPE_INVALID = -1;
    public static final int STREAM_TYPE_LIVE = 2;
    public static final int STREAM_TYPE_NONE = 0;
    public static final long UNKNOWN_DURATION = -1;
    private final String zzRC;
    private int zzRD;
    private String zzRE;
    private MediaMetadata zzRF;
    private long zzRG;
    private List<MediaTrack> zzRH;
    private TextTrackStyle zzRI;
    private JSONObject zzRJ;

    public static class Builder {
        private final MediaInfo zzRK;

        public Builder(String str) throws IllegalArgumentException {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("Content ID cannot be empty");
            }
            this.zzRK = new MediaInfo(str);
        }

        public MediaInfo build() throws IllegalArgumentException {
            this.zzRK.zzlq();
            return this.zzRK;
        }

        public Builder setContentType(String str) throws IllegalArgumentException {
            this.zzRK.setContentType(str);
            return this;
        }

        public Builder setCustomData(JSONObject jSONObject) {
            this.zzRK.setCustomData(jSONObject);
            return this;
        }

        public Builder setMediaTracks(List<MediaTrack> list) {
            this.zzRK.zzj(list);
            return this;
        }

        public Builder setMetadata(MediaMetadata mediaMetadata) {
            this.zzRK.zza(mediaMetadata);
            return this;
        }

        public Builder setStreamDuration(long j) throws IllegalArgumentException {
            this.zzRK.zzx(j);
            return this;
        }

        public Builder setStreamType(int i) throws IllegalArgumentException {
            this.zzRK.setStreamType(i);
            return this;
        }

        public Builder setTextTrackStyle(TextTrackStyle textTrackStyle) {
            this.zzRK.setTextTrackStyle(textTrackStyle);
            return this;
        }
    }

    MediaInfo(String str) throws IllegalArgumentException {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("content ID cannot be null or empty");
        }
        this.zzRC = str;
        this.zzRD = -1;
        this.zzRG = -1L;
    }

    MediaInfo(JSONObject jSONObject) throws JSONException {
        this.zzRC = jSONObject.getString("contentId");
        String string = jSONObject.getString("streamType");
        if ("NONE".equals(string)) {
            this.zzRD = 0;
        } else {
            this.zzRD = "BUFFERED".equals(string) ? 1 : "LIVE".equals(string) ? 2 : -1;
        }
        this.zzRE = jSONObject.getString("contentType");
        if (jSONObject.has("metadata")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("metadata");
            this.zzRF = new MediaMetadata(jSONObject2.getInt("metadataType"));
            this.zzRF.zzf(jSONObject2);
        }
        this.zzRG = -1L;
        if (jSONObject.has("duration") && !jSONObject.isNull("duration")) {
            double optDouble = jSONObject.optDouble("duration", 0.0d);
            if (!Double.isNaN(optDouble) && !Double.isInfinite(optDouble)) {
                this.zzRG = zzf.zze(optDouble);
            }
        }
        if (jSONObject.has("tracks")) {
            this.zzRH = new ArrayList();
            JSONArray jSONArray = jSONObject.getJSONArray("tracks");
            for (int i = 0; i < jSONArray.length(); i++) {
                this.zzRH.add(new MediaTrack(jSONArray.getJSONObject(i)));
            }
        } else {
            this.zzRH = null;
        }
        if (jSONObject.has("textTrackStyle")) {
            JSONObject jSONObject3 = jSONObject.getJSONObject("textTrackStyle");
            TextTrackStyle textTrackStyle = new TextTrackStyle();
            textTrackStyle.zzf(jSONObject3);
            this.zzRI = textTrackStyle;
        } else {
            this.zzRI = null;
        }
        this.zzRJ = jSONObject.optJSONObject("customData");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaInfo)) {
            return false;
        }
        MediaInfo mediaInfo = (MediaInfo) obj;
        if ((this.zzRJ == null) != (mediaInfo.zzRJ == null)) {
            return false;
        }
        if (this.zzRJ == null || mediaInfo.zzRJ == null || zzlh.zzd(this.zzRJ, mediaInfo.zzRJ)) {
            return zzf.zza(this.zzRC, mediaInfo.zzRC) && this.zzRD == mediaInfo.zzRD && zzf.zza(this.zzRE, mediaInfo.zzRE) && zzf.zza(this.zzRF, mediaInfo.zzRF) && this.zzRG == mediaInfo.zzRG;
        }
        return false;
    }

    public String getContentId() {
        return this.zzRC;
    }

    public String getContentType() {
        return this.zzRE;
    }

    public JSONObject getCustomData() {
        return this.zzRJ;
    }

    public List<MediaTrack> getMediaTracks() {
        return this.zzRH;
    }

    public MediaMetadata getMetadata() {
        return this.zzRF;
    }

    public long getStreamDuration() {
        return this.zzRG;
    }

    public int getStreamType() {
        return this.zzRD;
    }

    public TextTrackStyle getTextTrackStyle() {
        return this.zzRI;
    }

    public int hashCode() {
        return zzt.hashCode(this.zzRC, Integer.valueOf(this.zzRD), this.zzRE, this.zzRF, Long.valueOf(this.zzRG), String.valueOf(this.zzRJ));
    }

    void setContentType(String str) throws IllegalArgumentException {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("content type cannot be null or empty");
        }
        this.zzRE = str;
    }

    void setCustomData(JSONObject jSONObject) {
        this.zzRJ = jSONObject;
    }

    void setStreamType(int i) throws IllegalArgumentException {
        if (i < -1 || i > 2) {
            throw new IllegalArgumentException("invalid stream type");
        }
        this.zzRD = i;
    }

    public void setTextTrackStyle(TextTrackStyle textTrackStyle) {
        this.zzRI = textTrackStyle;
    }

    public JSONObject toJson() {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("contentId", this.zzRC);
            switch (this.zzRD) {
                case 1:
                    str = "BUFFERED";
                    break;
                case 2:
                    str = "LIVE";
                    break;
                default:
                    str = "NONE";
                    break;
            }
            jSONObject.put("streamType", str);
            if (this.zzRE != null) {
                jSONObject.put("contentType", this.zzRE);
            }
            if (this.zzRF != null) {
                jSONObject.put("metadata", this.zzRF.toJson());
            }
            if (this.zzRG <= -1) {
                jSONObject.put("duration", JSONObject.NULL);
            } else {
                jSONObject.put("duration", zzf.zzA(this.zzRG));
            }
            if (this.zzRH != null) {
                JSONArray jSONArray = new JSONArray();
                Iterator<MediaTrack> it = this.zzRH.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().toJson());
                }
                jSONObject.put("tracks", jSONArray);
            }
            if (this.zzRI != null) {
                jSONObject.put("textTrackStyle", this.zzRI.toJson());
            }
            if (this.zzRJ != null) {
                jSONObject.put("customData", this.zzRJ);
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    void zza(MediaMetadata mediaMetadata) {
        this.zzRF = mediaMetadata;
    }

    void zzj(List<MediaTrack> list) {
        this.zzRH = list;
    }

    void zzlq() throws IllegalArgumentException {
        if (TextUtils.isEmpty(this.zzRC)) {
            throw new IllegalArgumentException("content ID cannot be null or empty");
        }
        if (TextUtils.isEmpty(this.zzRE)) {
            throw new IllegalArgumentException("content type cannot be null or empty");
        }
        if (this.zzRD == -1) {
            throw new IllegalArgumentException("a valid stream type must be specified");
        }
    }

    void zzx(long j) throws IllegalArgumentException {
        if (j < 0 && j != -1) {
            throw new IllegalArgumentException("Invalid stream duration");
        }
        this.zzRG = j;
    }
}
