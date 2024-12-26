package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.zzmp;

/* loaded from: classes.dex */
public class ListSubscriptionsRequest implements SafeParcelable {
    public static final Parcelable.Creator<ListSubscriptionsRequest> CREATOR = new zzp();
    private final int zzCY;
    private final String zzMZ;
    private final DataType zzajF;
    private final zzmp zzamn;

    ListSubscriptionsRequest(int i, DataType dataType, IBinder iBinder, String str) {
        this.zzCY = i;
        this.zzajF = dataType;
        this.zzamn = iBinder == null ? null : zzmp.zza.zzbA(iBinder);
        this.zzMZ = str;
    }

    public ListSubscriptionsRequest(DataType dataType, zzmp zzmpVar, String str) {
        this.zzCY = 2;
        this.zzajF = dataType;
        this.zzamn = zzmpVar;
        this.zzMZ = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public DataType getDataType() {
        return this.zzajF;
    }

    public String getPackageName() {
        return this.zzMZ;
    }

    int getVersionCode() {
        return this.zzCY;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzp.zza(this, parcel, i);
    }

    public IBinder zzqU() {
        if (this.zzamn == null) {
            return null;
        }
        return this.zzamn.asBinder();
    }
}
