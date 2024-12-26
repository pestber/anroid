package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.data.DataType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class BleDevicesResult implements Result, SafeParcelable {
    public static final Parcelable.Creator<BleDevicesResult> CREATOR = new zza();
    private final int zzCY;
    private final Status zzOt;
    private final List<BleDevice> zzamO;

    BleDevicesResult(int i, List<BleDevice> list, Status status) {
        this.zzCY = i;
        this.zzamO = Collections.unmodifiableList(list);
        this.zzOt = status;
    }

    public BleDevicesResult(List<BleDevice> list, Status status) {
        this.zzCY = 3;
        this.zzamO = Collections.unmodifiableList(list);
        this.zzOt = status;
    }

    public static BleDevicesResult zzJ(Status status) {
        return new BleDevicesResult(Collections.emptyList(), status);
    }

    private boolean zzb(BleDevicesResult bleDevicesResult) {
        return this.zzOt.equals(bleDevicesResult.zzOt) && zzt.equal(this.zzamO, bleDevicesResult.zzamO);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof BleDevicesResult) && zzb((BleDevicesResult) obj));
    }

    public List<BleDevice> getClaimedBleDevices() {
        return this.zzamO;
    }

    public List<BleDevice> getClaimedBleDevices(DataType dataType) {
        ArrayList arrayList = new ArrayList();
        for (BleDevice bleDevice : this.zzamO) {
            if (bleDevice.getDataTypes().contains(dataType)) {
                arrayList.add(bleDevice);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.zzOt;
    }

    int getVersionCode() {
        return this.zzCY;
    }

    public int hashCode() {
        return zzt.hashCode(this.zzOt, this.zzamO);
    }

    public String toString() {
        return zzt.zzt(this).zzg("status", this.zzOt).zzg("bleDevices", this.zzamO).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }
}
