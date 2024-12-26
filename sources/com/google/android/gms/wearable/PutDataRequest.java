package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.wearable.internal.DataItemAssetParcelable;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/* loaded from: classes.dex */
public class PutDataRequest implements SafeParcelable {
    public static final String WEAR_URI_SCHEME = "wear";
    private final Uri mUri;
    final int zzCY;
    private final Bundle zzaSY;
    private byte[] zzauL;
    public static final Parcelable.Creator<PutDataRequest> CREATOR = new zzf();
    private static final Random zzaSX = new SecureRandom();

    private PutDataRequest(int i, Uri uri) {
        this(i, uri, new Bundle(), null);
    }

    PutDataRequest(int i, Uri uri, Bundle bundle, byte[] bArr) {
        this.zzCY = i;
        this.mUri = uri;
        this.zzaSY = bundle;
        this.zzaSY.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
        this.zzauL = bArr;
    }

    public static PutDataRequest create(String str) {
        return zzn(zzfg(str));
    }

    public static PutDataRequest createFromDataItem(DataItem dataItem) {
        PutDataRequest zzn = zzn(dataItem.getUri());
        for (Map.Entry<String, DataItemAsset> entry : dataItem.getAssets().entrySet()) {
            if (entry.getValue().getId() == null) {
                throw new IllegalStateException("Cannot create an asset for a put request without a digest: " + entry.getKey());
            }
            zzn.putAsset(entry.getKey(), Asset.createFromRef(entry.getValue().getId()));
        }
        zzn.setData(dataItem.getData());
        return zzn;
    }

    public static PutDataRequest createWithAutoAppendedId(String str) {
        StringBuilder sb = new StringBuilder(str);
        if (!str.endsWith("/")) {
            sb.append("/");
        }
        sb.append("PN").append(zzaSX.nextLong());
        return new PutDataRequest(1, zzfg(sb.toString()));
    }

    private static Uri zzfg(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("An empty path was supplied.");
        }
        if (!str.startsWith("/")) {
            throw new IllegalArgumentException("A path must start with a single / .");
        }
        if (str.startsWith("//")) {
            throw new IllegalArgumentException("A path must start with a single / .");
        }
        return new Uri.Builder().scheme(WEAR_URI_SCHEME).path(str).build();
    }

    public static PutDataRequest zzn(Uri uri) {
        return new PutDataRequest(1, uri);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Asset getAsset(String str) {
        return (Asset) this.zzaSY.getParcelable(str);
    }

    public Map<String, Asset> getAssets() {
        HashMap hashMap = new HashMap();
        for (String str : this.zzaSY.keySet()) {
            hashMap.put(str, (Asset) this.zzaSY.getParcelable(str));
        }
        return Collections.unmodifiableMap(hashMap);
    }

    public byte[] getData() {
        return this.zzauL;
    }

    public Uri getUri() {
        return this.mUri;
    }

    public boolean hasAsset(String str) {
        return this.zzaSY.containsKey(str);
    }

    public PutDataRequest putAsset(String str, Asset asset) {
        zzu.zzu(str);
        zzu.zzu(asset);
        this.zzaSY.putParcelable(str, asset);
        return this;
    }

    public PutDataRequest removeAsset(String str) {
        this.zzaSY.remove(str);
        return this;
    }

    public PutDataRequest setData(byte[] bArr) {
        this.zzauL = bArr;
        return this;
    }

    public String toString() {
        return toString(Log.isLoggable(DataMap.TAG, 3));
    }

    public String toString(boolean z) {
        String str;
        StringBuilder sb = new StringBuilder("PutDataRequest[");
        sb.append("dataSz=" + (this.zzauL == null ? "null" : Integer.valueOf(this.zzauL.length)));
        sb.append(", numAssets=" + this.zzaSY.size());
        sb.append(", uri=" + this.mUri);
        if (z) {
            sb.append("]\n  assets: ");
            for (String str2 : this.zzaSY.keySet()) {
                sb.append("\n    " + str2 + ": " + this.zzaSY.getParcelable(str2));
            }
            str = "\n  ]";
        } else {
            str = "]";
        }
        sb.append(str);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzf.zza(this, parcel, i);
    }

    public Bundle zzAR() {
        return this.zzaSY;
    }
}
