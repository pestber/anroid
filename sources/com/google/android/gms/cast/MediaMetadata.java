package com.google.android.gms.cast;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.internal.zzjz;
import com.google.android.gms.plus.PlusShare;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class MediaMetadata {
    public static final int MEDIA_TYPE_GENERIC = 0;
    public static final int MEDIA_TYPE_MOVIE = 1;
    public static final int MEDIA_TYPE_MUSIC_TRACK = 3;
    public static final int MEDIA_TYPE_PHOTO = 4;
    public static final int MEDIA_TYPE_TV_SHOW = 2;
    public static final int MEDIA_TYPE_USER = 100;
    private final Bundle zzRN;
    private int zzRO;
    private final List<WebImage> zzvi;
    private static final String[] zzRL = {null, "String", "int", "double", "ISO-8601 date String"};
    public static final String KEY_CREATION_DATE = "com.google.android.gms.cast.metadata.CREATION_DATE";
    public static final String KEY_RELEASE_DATE = "com.google.android.gms.cast.metadata.RELEASE_DATE";
    public static final String KEY_BROADCAST_DATE = "com.google.android.gms.cast.metadata.BROADCAST_DATE";
    public static final String KEY_TITLE = "com.google.android.gms.cast.metadata.TITLE";
    public static final String KEY_SUBTITLE = "com.google.android.gms.cast.metadata.SUBTITLE";
    public static final String KEY_ARTIST = "com.google.android.gms.cast.metadata.ARTIST";
    public static final String KEY_ALBUM_ARTIST = "com.google.android.gms.cast.metadata.ALBUM_ARTIST";
    public static final String KEY_ALBUM_TITLE = "com.google.android.gms.cast.metadata.ALBUM_TITLE";
    public static final String KEY_COMPOSER = "com.google.android.gms.cast.metadata.COMPOSER";
    public static final String KEY_DISC_NUMBER = "com.google.android.gms.cast.metadata.DISC_NUMBER";
    public static final String KEY_TRACK_NUMBER = "com.google.android.gms.cast.metadata.TRACK_NUMBER";
    public static final String KEY_SEASON_NUMBER = "com.google.android.gms.cast.metadata.SEASON_NUMBER";
    public static final String KEY_EPISODE_NUMBER = "com.google.android.gms.cast.metadata.EPISODE_NUMBER";
    public static final String KEY_SERIES_TITLE = "com.google.android.gms.cast.metadata.SERIES_TITLE";
    public static final String KEY_STUDIO = "com.google.android.gms.cast.metadata.STUDIO";
    public static final String KEY_WIDTH = "com.google.android.gms.cast.metadata.WIDTH";
    public static final String KEY_HEIGHT = "com.google.android.gms.cast.metadata.HEIGHT";
    public static final String KEY_LOCATION_NAME = "com.google.android.gms.cast.metadata.LOCATION_NAME";
    public static final String KEY_LOCATION_LATITUDE = "com.google.android.gms.cast.metadata.LOCATION_LATITUDE";
    public static final String KEY_LOCATION_LONGITUDE = "com.google.android.gms.cast.metadata.LOCATION_LONGITUDE";
    private static final zza zzRM = new zza().zzb(KEY_CREATION_DATE, "creationDateTime", 4).zzb(KEY_RELEASE_DATE, "releaseDate", 4).zzb(KEY_BROADCAST_DATE, "originalAirdate", 4).zzb(KEY_TITLE, PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, 1).zzb(KEY_SUBTITLE, "subtitle", 1).zzb(KEY_ARTIST, "artist", 1).zzb(KEY_ALBUM_ARTIST, "albumArtist", 1).zzb(KEY_ALBUM_TITLE, "albumName", 1).zzb(KEY_COMPOSER, "composer", 1).zzb(KEY_DISC_NUMBER, "discNumber", 2).zzb(KEY_TRACK_NUMBER, "trackNumber", 2).zzb(KEY_SEASON_NUMBER, "season", 2).zzb(KEY_EPISODE_NUMBER, "episode", 2).zzb(KEY_SERIES_TITLE, "seriesTitle", 1).zzb(KEY_STUDIO, "studio", 1).zzb(KEY_WIDTH, "width", 2).zzb(KEY_HEIGHT, "height", 2).zzb(KEY_LOCATION_NAME, "location", 1).zzb(KEY_LOCATION_LATITUDE, "latitude", 3).zzb(KEY_LOCATION_LONGITUDE, "longitude", 3);

    private static class zza {
        private final Map<String, String> zzRP = new HashMap();
        private final Map<String, String> zzRQ = new HashMap();
        private final Map<String, Integer> zzRR = new HashMap();

        public zza zzb(String str, String str2, int i) {
            this.zzRP.put(str, str2);
            this.zzRQ.put(str2, str);
            this.zzRR.put(str, Integer.valueOf(i));
            return this;
        }

        public String zzbw(String str) {
            return this.zzRP.get(str);
        }

        public String zzbx(String str) {
            return this.zzRQ.get(str);
        }

        public int zzby(String str) {
            Integer num = this.zzRR.get(str);
            if (num != null) {
                return num.intValue();
            }
            return 0;
        }
    }

    public MediaMetadata() {
        this(0);
    }

    public MediaMetadata(int i) {
        this.zzvi = new ArrayList();
        this.zzRN = new Bundle();
        this.zzRO = i;
    }

    private void zza(JSONObject jSONObject, String... strArr) {
        try {
            for (String str : strArr) {
                if (this.zzRN.containsKey(str)) {
                    switch (zzRM.zzby(str)) {
                        case 1:
                        case 4:
                            jSONObject.put(zzRM.zzbw(str), this.zzRN.getString(str));
                            break;
                        case 2:
                            jSONObject.put(zzRM.zzbw(str), this.zzRN.getInt(str));
                            break;
                        case 3:
                            jSONObject.put(zzRM.zzbw(str), this.zzRN.getDouble(str));
                            break;
                    }
                }
            }
            for (String str2 : this.zzRN.keySet()) {
                if (!str2.startsWith("com.google.")) {
                    Object obj = this.zzRN.get(str2);
                    if (!(obj instanceof String) && !(obj instanceof Integer) && !(obj instanceof Double)) {
                    }
                    jSONObject.put(str2, obj);
                }
            }
        } catch (JSONException e) {
        }
    }

    private void zzb(JSONObject jSONObject, String... strArr) {
        Bundle bundle;
        HashSet hashSet = new HashSet(Arrays.asList(strArr));
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!"metadataType".equals(next)) {
                    String zzbx = zzRM.zzbx(next);
                    if (zzbx == null) {
                        Object obj = jSONObject.get(next);
                        if (obj instanceof String) {
                            this.zzRN.putString(next, (String) obj);
                        } else if (obj instanceof Integer) {
                            this.zzRN.putInt(next, ((Integer) obj).intValue());
                        } else if (obj instanceof Double) {
                            this.zzRN.putDouble(next, ((Double) obj).doubleValue());
                        }
                    } else if (hashSet.contains(zzbx)) {
                        try {
                            Object obj2 = jSONObject.get(next);
                            if (obj2 != null) {
                                switch (zzRM.zzby(zzbx)) {
                                    case 1:
                                        if (!(obj2 instanceof String)) {
                                            break;
                                        } else {
                                            bundle = this.zzRN;
                                            break;
                                        }
                                    case 2:
                                        if (obj2 instanceof Integer) {
                                            this.zzRN.putInt(zzbx, ((Integer) obj2).intValue());
                                            break;
                                        } else {
                                            continue;
                                        }
                                    case 3:
                                        if (obj2 instanceof Double) {
                                            this.zzRN.putDouble(zzbx, ((Double) obj2).doubleValue());
                                            break;
                                        } else {
                                            continue;
                                        }
                                    case 4:
                                        if ((obj2 instanceof String) && zzjz.zzbK((String) obj2) != null) {
                                            bundle = this.zzRN;
                                            break;
                                        }
                                        break;
                                    default:
                                        continue;
                                }
                                bundle.putString(zzbx, (String) obj2);
                            }
                        } catch (JSONException e) {
                        }
                    }
                }
            }
        } catch (JSONException e2) {
        }
    }

    private boolean zzb(Bundle bundle, Bundle bundle2) {
        if (bundle.size() != bundle2.size()) {
            return false;
        }
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            Object obj2 = bundle2.get(str);
            if ((obj instanceof Bundle) && (obj2 instanceof Bundle) && !zzb((Bundle) obj, (Bundle) obj2)) {
                return false;
            }
            if (obj == null) {
                if (obj2 != null || !bundle2.containsKey(str)) {
                    return false;
                }
            } else if (!obj.equals(obj2)) {
                return false;
            }
        }
        return true;
    }

    private void zzf(String str, int i) throws IllegalArgumentException {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("null and empty keys are not allowed");
        }
        int zzby = zzRM.zzby(str);
        if (zzby != i && zzby != 0) {
            throw new IllegalArgumentException("Value for " + str + " must be a " + zzRL[i]);
        }
    }

    public void addImage(WebImage webImage) {
        this.zzvi.add(webImage);
    }

    public void clear() {
        this.zzRN.clear();
        this.zzvi.clear();
    }

    public void clearImages() {
        this.zzvi.clear();
    }

    public boolean containsKey(String str) {
        return this.zzRN.containsKey(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaMetadata)) {
            return false;
        }
        MediaMetadata mediaMetadata = (MediaMetadata) obj;
        return zzb(this.zzRN, mediaMetadata.zzRN) && this.zzvi.equals(mediaMetadata.zzvi);
    }

    public Calendar getDate(String str) {
        zzf(str, 4);
        String string = this.zzRN.getString(str);
        if (string != null) {
            return zzjz.zzbK(string);
        }
        return null;
    }

    public String getDateAsString(String str) {
        zzf(str, 4);
        return this.zzRN.getString(str);
    }

    public double getDouble(String str) {
        zzf(str, 3);
        return this.zzRN.getDouble(str);
    }

    public List<WebImage> getImages() {
        return this.zzvi;
    }

    public int getInt(String str) {
        zzf(str, 2);
        return this.zzRN.getInt(str);
    }

    public int getMediaType() {
        return this.zzRO;
    }

    public String getString(String str) {
        zzf(str, 1);
        return this.zzRN.getString(str);
    }

    public boolean hasImages() {
        return (this.zzvi == null || this.zzvi.isEmpty()) ? false : true;
    }

    public int hashCode() {
        Iterator<String> it = this.zzRN.keySet().iterator();
        int i = 17;
        while (it.hasNext()) {
            i = (i * 31) + this.zzRN.get(it.next()).hashCode();
        }
        return (i * 31) + this.zzvi.hashCode();
    }

    public Set<String> keySet() {
        return this.zzRN.keySet();
    }

    public void putDate(String str, Calendar calendar) {
        zzf(str, 4);
        this.zzRN.putString(str, zzjz.zza(calendar));
    }

    public void putDouble(String str, double d) {
        zzf(str, 3);
        this.zzRN.putDouble(str, d);
    }

    public void putInt(String str, int i) {
        zzf(str, 2);
        this.zzRN.putInt(str, i);
    }

    public void putString(String str, String str2) {
        zzf(str, 1);
        this.zzRN.putString(str, str2);
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("metadataType", this.zzRO);
        } catch (JSONException e) {
        }
        zzjz.zza(jSONObject, this.zzvi);
        switch (this.zzRO) {
            case 0:
                zza(jSONObject, KEY_TITLE, KEY_ARTIST, KEY_SUBTITLE, KEY_RELEASE_DATE);
                return jSONObject;
            case 1:
                zza(jSONObject, KEY_TITLE, KEY_STUDIO, KEY_SUBTITLE, KEY_RELEASE_DATE);
                return jSONObject;
            case 2:
                zza(jSONObject, KEY_TITLE, KEY_SERIES_TITLE, KEY_SEASON_NUMBER, KEY_EPISODE_NUMBER, KEY_BROADCAST_DATE);
                return jSONObject;
            case 3:
                zza(jSONObject, KEY_TITLE, KEY_ARTIST, KEY_ALBUM_TITLE, KEY_ALBUM_ARTIST, KEY_COMPOSER, KEY_TRACK_NUMBER, KEY_DISC_NUMBER, KEY_RELEASE_DATE);
                return jSONObject;
            case 4:
                zza(jSONObject, KEY_TITLE, KEY_ARTIST, KEY_LOCATION_NAME, KEY_LOCATION_LATITUDE, KEY_LOCATION_LONGITUDE, KEY_WIDTH, KEY_HEIGHT, KEY_CREATION_DATE);
                return jSONObject;
            default:
                zza(jSONObject, new String[0]);
                return jSONObject;
        }
    }

    public void zzf(JSONObject jSONObject) {
        clear();
        this.zzRO = 0;
        try {
            this.zzRO = jSONObject.getInt("metadataType");
        } catch (JSONException e) {
        }
        zzjz.zza(this.zzvi, jSONObject);
        switch (this.zzRO) {
            case 0:
                zzb(jSONObject, KEY_TITLE, KEY_ARTIST, KEY_SUBTITLE, KEY_RELEASE_DATE);
                break;
            case 1:
                zzb(jSONObject, KEY_TITLE, KEY_STUDIO, KEY_SUBTITLE, KEY_RELEASE_DATE);
                break;
            case 2:
                zzb(jSONObject, KEY_TITLE, KEY_SERIES_TITLE, KEY_SEASON_NUMBER, KEY_EPISODE_NUMBER, KEY_BROADCAST_DATE);
                break;
            case 3:
                zzb(jSONObject, KEY_TITLE, KEY_ALBUM_TITLE, KEY_ARTIST, KEY_ALBUM_ARTIST, KEY_COMPOSER, KEY_TRACK_NUMBER, KEY_DISC_NUMBER, KEY_RELEASE_DATE);
                break;
            case 4:
                zzb(jSONObject, KEY_TITLE, KEY_ARTIST, KEY_LOCATION_NAME, KEY_LOCATION_LATITUDE, KEY_LOCATION_LONGITUDE, KEY_WIDTH, KEY_HEIGHT, KEY_CREATION_DATE);
                break;
            default:
                zzb(jSONObject, new String[0]);
                break;
        }
    }
}
