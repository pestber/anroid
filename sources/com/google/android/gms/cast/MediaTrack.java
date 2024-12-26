package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.internal.zzlh;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class MediaTrack {
    public static final int SUBTYPE_CAPTIONS = 2;
    public static final int SUBTYPE_CHAPTERS = 4;
    public static final int SUBTYPE_DESCRIPTIONS = 3;
    public static final int SUBTYPE_METADATA = 5;
    public static final int SUBTYPE_NONE = 0;
    public static final int SUBTYPE_SUBTITLES = 1;
    public static final int SUBTYPE_UNKNOWN = -1;
    public static final int TYPE_AUDIO = 2;
    public static final int TYPE_TEXT = 1;
    public static final int TYPE_UNKNOWN = 0;
    public static final int TYPE_VIDEO = 3;
    private String mName;
    private long zzOw;
    private String zzRA;
    private String zzRC;
    private String zzRE;
    private JSONObject zzRJ;
    private int zzSq;
    private int zzSr;

    public static class Builder {
        private final MediaTrack zzSs;

        public Builder(long j, int i) throws IllegalArgumentException {
            this.zzSs = new MediaTrack(j, i);
        }

        public MediaTrack build() {
            return this.zzSs;
        }

        public Builder setContentId(String str) {
            this.zzSs.setContentId(str);
            return this;
        }

        public Builder setContentType(String str) {
            this.zzSs.setContentType(str);
            return this;
        }

        public Builder setCustomData(JSONObject jSONObject) {
            this.zzSs.setCustomData(jSONObject);
            return this;
        }

        public Builder setLanguage(String str) {
            this.zzSs.setLanguage(str);
            return this;
        }

        public Builder setLanguage(Locale locale) {
            this.zzSs.setLanguage(zzf.zzb(locale));
            return this;
        }

        public Builder setName(String str) {
            this.zzSs.setName(str);
            return this;
        }

        public Builder setSubtype(int i) throws IllegalArgumentException {
            this.zzSs.zzaG(i);
            return this;
        }
    }

    MediaTrack(long j, int i) throws IllegalArgumentException {
        clear();
        this.zzOw = j;
        if (i <= 0 || i > 3) {
            throw new IllegalArgumentException("invalid type " + i);
        }
        this.zzSq = i;
    }

    MediaTrack(JSONObject jSONObject) throws JSONException {
        zzf(jSONObject);
    }

    private void clear() {
        this.zzOw = 0L;
        this.zzSq = 0;
        this.zzRC = null;
        this.mName = null;
        this.zzRA = null;
        this.zzSr = -1;
        this.zzRJ = null;
    }

    private void zzf(JSONObject jSONObject) throws JSONException {
        int i;
        clear();
        this.zzOw = jSONObject.getLong("trackId");
        String string = jSONObject.getString("type");
        if ("TEXT".equals(string)) {
            this.zzSq = 1;
        } else if ("AUDIO".equals(string)) {
            this.zzSq = 2;
        } else {
            if (!"VIDEO".equals(string)) {
                throw new JSONException("invalid type: " + string);
            }
            this.zzSq = 3;
        }
        this.zzRC = jSONObject.optString("trackContentId", null);
        this.zzRE = jSONObject.optString("trackContentType", null);
        this.mName = jSONObject.optString("name", null);
        this.zzRA = jSONObject.optString("language", null);
        if (jSONObject.has("subtype")) {
            String string2 = jSONObject.getString("subtype");
            if ("SUBTITLES".equals(string2)) {
                this.zzSr = 1;
            } else if ("CAPTIONS".equals(string2)) {
                this.zzSr = 2;
            } else if ("DESCRIPTIONS".equals(string2)) {
                this.zzSr = 3;
            } else if ("CHAPTERS".equals(string2)) {
                i = 4;
            } else {
                if (!"METADATA".equals(string2)) {
                    throw new JSONException("invalid subtype: " + string2);
                }
                i = 5;
            }
            this.zzRJ = jSONObject.optJSONObject("customData");
        }
        i = 0;
        this.zzSr = i;
        this.zzRJ = jSONObject.optJSONObject("customData");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaTrack)) {
            return false;
        }
        MediaTrack mediaTrack = (MediaTrack) obj;
        if ((this.zzRJ == null) != (mediaTrack.zzRJ == null)) {
            return false;
        }
        if (this.zzRJ == null || mediaTrack.zzRJ == null || zzlh.zzd(this.zzRJ, mediaTrack.zzRJ)) {
            return this.zzOw == mediaTrack.zzOw && this.zzSq == mediaTrack.zzSq && zzf.zza(this.zzRC, mediaTrack.zzRC) && zzf.zza(this.zzRE, mediaTrack.zzRE) && zzf.zza(this.mName, mediaTrack.mName) && zzf.zza(this.zzRA, mediaTrack.zzRA) && this.zzSr == mediaTrack.zzSr;
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

    public long getId() {
        return this.zzOw;
    }

    public String getLanguage() {
        return this.zzRA;
    }

    public String getName() {
        return this.mName;
    }

    public int getSubtype() {
        return this.zzSr;
    }

    public int getType() {
        return this.zzSq;
    }

    public int hashCode() {
        return zzt.hashCode(Long.valueOf(this.zzOw), Integer.valueOf(this.zzSq), this.zzRC, this.zzRE, this.mName, this.zzRA, Integer.valueOf(this.zzSr), this.zzRJ);
    }

    public void setContentId(String str) {
        this.zzRC = str;
    }

    public void setContentType(String str) {
        this.zzRE = str;
    }

    void setCustomData(JSONObject jSONObject) {
        this.zzRJ = jSONObject;
    }

    void setLanguage(String str) {
        this.zzRA = str;
    }

    void setName(String str) {
        this.mName = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0024 A[Catch: JSONException -> 0x0076, TryCatch #0 {JSONException -> 0x0076, blocks: (B:3:0x0005, B:7:0x0016, B:10:0x0020, B:12:0x0024, B:13:0x002b, B:15:0x002f, B:16:0x0036, B:18:0x003a, B:19:0x0041, B:21:0x0049, B:22:0x0050, B:26:0x005a, B:31:0x006a, B:33:0x006e), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x002f A[Catch: JSONException -> 0x0076, TryCatch #0 {JSONException -> 0x0076, blocks: (B:3:0x0005, B:7:0x0016, B:10:0x0020, B:12:0x0024, B:13:0x002b, B:15:0x002f, B:16:0x0036, B:18:0x003a, B:19:0x0041, B:21:0x0049, B:22:0x0050, B:26:0x005a, B:31:0x006a, B:33:0x006e), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003a A[Catch: JSONException -> 0x0076, TryCatch #0 {JSONException -> 0x0076, blocks: (B:3:0x0005, B:7:0x0016, B:10:0x0020, B:12:0x0024, B:13:0x002b, B:15:0x002f, B:16:0x0036, B:18:0x003a, B:19:0x0041, B:21:0x0049, B:22:0x0050, B:26:0x005a, B:31:0x006a, B:33:0x006e), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0049 A[Catch: JSONException -> 0x0076, TryCatch #0 {JSONException -> 0x0076, blocks: (B:3:0x0005, B:7:0x0016, B:10:0x0020, B:12:0x0024, B:13:0x002b, B:15:0x002f, B:16:0x0036, B:18:0x003a, B:19:0x0041, B:21:0x0049, B:22:0x0050, B:26:0x005a, B:31:0x006a, B:33:0x006e), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006a A[Catch: JSONException -> 0x0076, TryCatch #0 {JSONException -> 0x0076, blocks: (B:3:0x0005, B:7:0x0016, B:10:0x0020, B:12:0x0024, B:13:0x002b, B:15:0x002f, B:16:0x0036, B:18:0x003a, B:19:0x0041, B:21:0x0049, B:22:0x0050, B:26:0x005a, B:31:0x006a, B:33:0x006e), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006e A[Catch: JSONException -> 0x0076, TRY_LEAVE, TryCatch #0 {JSONException -> 0x0076, blocks: (B:3:0x0005, B:7:0x0016, B:10:0x0020, B:12:0x0024, B:13:0x002b, B:15:0x002f, B:16:0x0036, B:18:0x003a, B:19:0x0041, B:21:0x0049, B:22:0x0050, B:26:0x005a, B:31:0x006a, B:33:0x006e), top: B:2:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.json.JSONObject toJson() {
        /*
            r4 = this;
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            java.lang.String r1 = "trackId"
            long r2 = r4.zzOw     // Catch: org.json.JSONException -> L76
            r0.put(r1, r2)     // Catch: org.json.JSONException -> L76
            int r1 = r4.zzSq     // Catch: org.json.JSONException -> L76
            java.lang.String r2 = "type"
            switch(r1) {
                case 1: goto L1d;
                case 2: goto L1a;
                case 3: goto L14;
                default: goto L13;
            }
        L13:
            goto L20
        L14:
            java.lang.String r1 = "VIDEO"
        L16:
            r0.put(r2, r1)     // Catch: org.json.JSONException -> L76
            goto L20
        L1a:
            java.lang.String r1 = "AUDIO"
            goto L16
        L1d:
            java.lang.String r1 = "TEXT"
            goto L16
        L20:
            java.lang.String r1 = r4.zzRC     // Catch: org.json.JSONException -> L76
            if (r1 == 0) goto L2b
            java.lang.String r1 = "trackContentId"
            java.lang.String r2 = r4.zzRC     // Catch: org.json.JSONException -> L76
            r0.put(r1, r2)     // Catch: org.json.JSONException -> L76
        L2b:
            java.lang.String r1 = r4.zzRE     // Catch: org.json.JSONException -> L76
            if (r1 == 0) goto L36
            java.lang.String r1 = "trackContentType"
            java.lang.String r2 = r4.zzRE     // Catch: org.json.JSONException -> L76
            r0.put(r1, r2)     // Catch: org.json.JSONException -> L76
        L36:
            java.lang.String r1 = r4.mName     // Catch: org.json.JSONException -> L76
            if (r1 == 0) goto L41
            java.lang.String r1 = "name"
            java.lang.String r2 = r4.mName     // Catch: org.json.JSONException -> L76
            r0.put(r1, r2)     // Catch: org.json.JSONException -> L76
        L41:
            java.lang.String r1 = r4.zzRA     // Catch: org.json.JSONException -> L76
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: org.json.JSONException -> L76
            if (r1 != 0) goto L50
            java.lang.String r1 = "language"
            java.lang.String r2 = r4.zzRA     // Catch: org.json.JSONException -> L76
            r0.put(r1, r2)     // Catch: org.json.JSONException -> L76
        L50:
            int r1 = r4.zzSr     // Catch: org.json.JSONException -> L76
            java.lang.String r2 = "subtype"
            switch(r1) {
                case 1: goto L67;
                case 2: goto L64;
                case 3: goto L61;
                case 4: goto L5e;
                case 5: goto L58;
                default: goto L57;
            }
        L57:
            goto L6a
        L58:
            java.lang.String r1 = "METADATA"
        L5a:
            r0.put(r2, r1)     // Catch: org.json.JSONException -> L76
            goto L6a
        L5e:
            java.lang.String r1 = "CHAPTERS"
            goto L5a
        L61:
            java.lang.String r1 = "DESCRIPTIONS"
            goto L5a
        L64:
            java.lang.String r1 = "CAPTIONS"
            goto L5a
        L67:
            java.lang.String r1 = "SUBTITLES"
            goto L5a
        L6a:
            org.json.JSONObject r1 = r4.zzRJ     // Catch: org.json.JSONException -> L76
            if (r1 == 0) goto L77
            java.lang.String r1 = "customData"
            org.json.JSONObject r2 = r4.zzRJ     // Catch: org.json.JSONException -> L76
            r0.put(r1, r2)     // Catch: org.json.JSONException -> L76
            goto L77
        L76:
            r1 = move-exception
        L77:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.MediaTrack.toJson():org.json.JSONObject");
    }

    void zzaG(int i) throws IllegalArgumentException {
        if (i <= -1 || i > 5) {
            throw new IllegalArgumentException("invalid subtype " + i);
        }
        if (i != 0 && this.zzSq != 1) {
            throw new IllegalArgumentException("subtypes are only valid for text tracks");
        }
        this.zzSr = i;
    }
}
