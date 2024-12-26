package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.DataItemAsset;

/* loaded from: classes.dex */
public class zzx implements DataItemAsset {
    private final String zzKI;
    private final String zztw;

    public zzx(DataItemAsset dataItemAsset) {
        this.zzKI = dataItemAsset.getId();
        this.zztw = dataItemAsset.getDataItemKey();
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
        sb.append("DataItemAssetEntity[");
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

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: zzBd, reason: merged with bridge method [inline-methods] */
    public DataItemAsset freeze() {
        return this;
    }
}
