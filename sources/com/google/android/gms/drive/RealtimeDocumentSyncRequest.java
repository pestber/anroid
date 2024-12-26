package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import java.util.List;

/* loaded from: classes.dex */
public class RealtimeDocumentSyncRequest implements SafeParcelable {
    public static final Parcelable.Creator<RealtimeDocumentSyncRequest> CREATOR = new zzi();
    final int zzCY;
    final List<String> zzadF;
    final List<String> zzadG;

    RealtimeDocumentSyncRequest(int i, List<String> list, List<String> list2) {
        this.zzCY = i;
        this.zzadF = (List) zzu.zzu(list);
        this.zzadG = (List) zzu.zzu(list2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzi.zza(this, parcel, i);
    }
}
