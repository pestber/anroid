package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class OnDownloadProgressResponse implements SafeParcelable {
    public static final Parcelable.Creator<OnDownloadProgressResponse> CREATOR = new zzaw();
    final int zzCY;
    final long zzagg;
    final long zzagh;

    OnDownloadProgressResponse(int i, long j, long j2) {
        this.zzCY = i;
        this.zzagg = j;
        this.zzagh = j2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzaw.zza(this, parcel, i);
    }

    public long zzpM() {
        return this.zzagg;
    }

    public long zzpN() {
        return this.zzagh;
    }
}
