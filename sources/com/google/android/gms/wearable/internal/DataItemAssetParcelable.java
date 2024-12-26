package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.DataItemAsset;

/* loaded from: classes.dex */
public class DataItemAssetParcelable implements SafeParcelable, DataItemAsset {
    public static final Parcelable.Creator<DataItemAssetParcelable> CREATOR = new zzy();
    final int zzCY;
    private final String zzKI;
    private final String zztw;

    DataItemAssetParcelable(int i, String str, String str2) {
        this.zzCY = i;
        this.zzKI = str;
        this.zztw = str2;
    }

    public DataItemAssetParcelable(DataItemAsset dataItemAsset) {
        this.zzCY = 1;
        this.zzKI = (String) com.google.android.gms.common.internal.zzu.zzu(dataItemAsset.getId());
        this.zztw = (String) com.google.android.gms.common.internal.zzu.zzu(dataItemAsset.getDataItemKey());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.wearable.DataItemAsset
    public String getDataItemKey() {
        return this.zztw;
    }

    @Override // com.google.android.gms.wearable.DataItemAsset
    public String getId() {
        return this.zzKI;
    }

    @Override // com.google.android.gms.common.data.Freezable
    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("DataItemAssetParcelable[");
        sb.append("@");
        sb.append(Integer.toHexString(hashCode()));
        if (this.zzKI == null) {
            str = ",noid";
        } else {
            sb.append(",");
            str = this.zzKI;
        }
        sb.append(str);
        sb.append(", key=");
        sb.append(this.zztw);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzy.zza(this, parcel, i);
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: zzBd, reason: merged with bridge method [inline-methods] */
    public DataItemAsset freeze() {
        return this;
    }
}
