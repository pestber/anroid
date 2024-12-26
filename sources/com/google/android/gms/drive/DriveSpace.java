package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class DriveSpace implements SafeParcelable {
    public static final Parcelable.Creator<DriveSpace> CREATOR = new zzg();
    public static final DriveSpace zzadi = new DriveSpace("DRIVE");
    public static final DriveSpace zzadj = new DriveSpace("APP_DATA_FOLDER");
    public static final DriveSpace zzadk = new DriveSpace("PHOTOS");
    public static final Set<DriveSpace> zzadl = Collections.unmodifiableSet(new HashSet(Arrays.asList(zzadi, zzadj, zzadk)));
    public static final String zzadm = TextUtils.join(",", zzadl.toArray());
    private final String mName;
    final int zzCY;

    DriveSpace(int i, String str) {
        this.zzCY = i;
        this.mName = (String) zzu.zzu(str);
    }

    private DriveSpace(String str) {
        this(1, str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != DriveSpace.class) {
            return false;
        }
        return this.mName.equals(((DriveSpace) obj).mName);
    }

    public String getName() {
        return this.mName;
    }

    public int hashCode() {
        return this.mName.hashCode() ^ 1247068382;
    }

    public String toString() {
        return this.mName;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzg.zza(this, parcel, i);
    }
}
