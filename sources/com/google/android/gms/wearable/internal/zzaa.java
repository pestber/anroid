package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class zzaa implements DataItem {
    private Uri mUri;
    private Map<String, DataItemAsset> zzaUo;
    private byte[] zzauL;

    public zzaa(DataItem dataItem) {
        this.mUri = dataItem.getUri();
        this.zzauL = dataItem.getData();
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, DataItemAsset> entry : dataItem.getAssets().entrySet()) {
            if (entry.getKey() != null) {
                hashMap.put(entry.getKey(), entry.getValue().freeze());
            }
        }
        this.zzaUo = Collections.unmodifiableMap(hashMap);
    }

    @Override // com.google.android.gms.wearable.DataItem
    public Map<String, DataItemAsset> getAssets() {
        return this.zzaUo;
    }

    @Override // com.google.android.gms.wearable.DataItem
    public byte[] getData() {
        return this.zzauL;
    }

    @Override // com.google.android.gms.wearable.DataItem
    public Uri getUri() {
        return this.mUri;
    }

    @Override // com.google.android.gms.common.data.Freezable
    public boolean isDataValid() {
        return true;
    }

    @Override // com.google.android.gms.wearable.DataItem
    public DataItem setData(byte[] bArr) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return toString(Log.isLoggable("DataItem", 3));
    }

    public String toString(boolean z) {
        StringBuilder sb = new StringBuilder("DataItemEntity{ ");
        sb.append("uri=" + this.mUri);
        sb.append(", dataSz=" + (this.zzauL == null ? "null" : Integer.valueOf(this.zzauL.length)));
        sb.append(", numAssets=" + this.zzaUo.size());
        if (z && !this.zzaUo.isEmpty()) {
            sb.append(", assets=[");
            String str = "";
            for (Map.Entry<String, DataItemAsset> entry : this.zzaUo.entrySet()) {
                sb.append(str + entry.getKey() + ": " + entry.getValue().getId());
                str = ", ";
            }
            sb.append("]");
        }
        sb.append(" }");
        return sb.toString();
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: zzBe, reason: merged with bridge method [inline-methods] */
    public DataItem freeze() {
        return this;
    }
}
