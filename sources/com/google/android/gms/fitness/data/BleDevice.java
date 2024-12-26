package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzlt;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class BleDevice implements SafeParcelable {
    public static final Parcelable.Creator<BleDevice> CREATOR = new zzb();
    private final String mName;
    private final int zzCY;
    private final String zzajO;
    private final List<String> zzajP;
    private final List<DataType> zzajQ;

    BleDevice(int i, String str, String str2, List<String> list, List<DataType> list2) {
        this.zzCY = i;
        this.zzajO = str;
        this.mName = str2;
        this.zzajP = Collections.unmodifiableList(list);
        this.zzajQ = Collections.unmodifiableList(list2);
    }

    private boolean zza(BleDevice bleDevice) {
        return this.mName.equals(bleDevice.mName) && this.zzajO.equals(bleDevice.zzajO) && zzlt.zza(bleDevice.zzajP, this.zzajP) && zzlt.zza(this.zzajQ, bleDevice.zzajQ);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof BleDevice) && zza((BleDevice) obj));
    }

    public String getAddress() {
        return this.zzajO;
    }

    public List<DataType> getDataTypes() {
        return this.zzajQ;
    }

    public String getName() {
        return this.mName;
    }

    public List<String> getSupportedProfiles() {
        return this.zzajP;
    }

    int getVersionCode() {
        return this.zzCY;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.zzt.hashCode(this.mName, this.zzajO, this.zzajP, this.zzajQ);
    }

    public String toString() {
        return com.google.android.gms.common.internal.zzt.zzt(this).zzg("name", this.mName).zzg("address", this.zzajO).zzg("dataTypes", this.zzajQ).zzg("supportedProfiles", this.zzajP).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }
}
