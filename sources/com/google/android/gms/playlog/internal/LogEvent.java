package com.google.android.gms.playlog.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class LogEvent implements SafeParcelable {
    public static final zzc CREATOR = new zzc();
    public final String tag;
    public final int versionCode;
    public final long zzaGF;
    public final byte[] zzaGG;
    public final Bundle zzaGH;

    LogEvent(int i, long j, String str, byte[] bArr, Bundle bundle) {
        this.versionCode = i;
        this.zzaGF = j;
        this.tag = str;
        this.zzaGG = bArr;
        this.zzaGH = bundle;
    }

    public LogEvent(long j, String str, byte[] bArr, String... strArr) {
        this.versionCode = 1;
        this.zzaGF = j;
        this.tag = str;
        this.zzaGG = bArr;
        this.zzaGH = zzd(strArr);
    }

    private static Bundle zzd(String... strArr) {
        if (strArr == null) {
            return null;
        }
        if (strArr.length % 2 != 0) {
            throw new IllegalArgumentException("extras must have an even number of elements");
        }
        int length = strArr.length / 2;
        if (length == 0) {
            return null;
        }
        Bundle bundle = new Bundle(length);
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bundle.putString(strArr[i2], strArr[i2 + 1]);
        }
        return bundle;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("tag=").append(this.tag).append(",");
        sb.append("eventTime=").append(this.zzaGF).append(",");
        if (this.zzaGH != null && !this.zzaGH.isEmpty()) {
            sb.append("keyValues=");
            for (String str : this.zzaGH.keySet()) {
                sb.append("(").append(str).append(",");
                sb.append(this.zzaGH.getString(str)).append(")");
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }
}
