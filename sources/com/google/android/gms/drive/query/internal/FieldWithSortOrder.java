package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Locale;

/* loaded from: classes.dex */
public class FieldWithSortOrder implements SafeParcelable {
    public static final zzc CREATOR = new zzc();
    final int zzCY;
    final String zzagy;
    final boolean zzahT;

    FieldWithSortOrder(int i, String str, boolean z) {
        this.zzCY = i;
        this.zzagy = str;
        this.zzahT = z;
    }

    public FieldWithSortOrder(String str, boolean z) {
        this(1, str, z);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return String.format(Locale.US, "FieldWithSortOrder[%s %s]", this.zzagy, this.zzahT ? "ASC" : "DESC");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }
}
