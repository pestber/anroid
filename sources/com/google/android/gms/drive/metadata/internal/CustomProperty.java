package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.drive.metadata.CustomPropertyKey;

/* loaded from: classes.dex */
public class CustomProperty implements SafeParcelable {
    public static final Parcelable.Creator<CustomProperty> CREATOR = new zzc();
    final String mValue;
    final int zzCY;
    final CustomPropertyKey zzagG;

    CustomProperty(int i, CustomPropertyKey customPropertyKey, String str) {
        this.zzCY = i;
        zzu.zzb(customPropertyKey, "key");
        this.zzagG = customPropertyKey;
        this.mValue = str;
    }

    public CustomProperty(CustomPropertyKey customPropertyKey, String str) {
        this(1, customPropertyKey, str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getValue() {
        return this.mValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }

    public CustomPropertyKey zzpV() {
        return this.zzagG;
    }
}
