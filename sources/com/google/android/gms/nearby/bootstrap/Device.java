package com.google.android.gms.nearby.bootstrap;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;

/* loaded from: classes.dex */
public class Device implements SafeParcelable {
    public static final Parcelable.Creator<Device> CREATOR = new zzb();
    private final String description;
    private final String name;
    final int versionCode;
    private final String zzaFf;
    private final byte zzaFg;

    Device(int i, String str, String str2, String str3, byte b) {
        this.versionCode = i;
        this.name = zzu.zzcj(str);
        this.description = (String) zzu.zzu(str2);
        this.zzaFf = (String) zzu.zzu(str3);
        zzu.zzb(b <= 3, "Unknown device type");
        this.zzaFg = b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDescription() {
        return this.description;
    }

    public String getDeviceId() {
        return this.zzaFf;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return this.name + ": " + this.description + "[" + ((int) this.zzaFg) + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }

    public byte zzwK() {
        return this.zzaFg;
    }
}
