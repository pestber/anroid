package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.Node;

/* loaded from: classes.dex */
public class NodeParcelable implements SafeParcelable, Node {
    public static final Parcelable.Creator<NodeParcelable> CREATOR = new zzay();
    final int zzCY;
    private final String zzKI;
    private final int zzaUL;
    private final boolean zzaUM;
    private final String zzadI;

    NodeParcelable(int i, String str, String str2, int i2, boolean z) {
        this.zzCY = i;
        this.zzKI = str;
        this.zzadI = str2;
        this.zzaUL = i2;
        this.zzaUM = z;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj instanceof NodeParcelable) {
            return ((NodeParcelable) obj).zzKI.equals(this.zzKI);
        }
        return false;
    }

    @Override // com.google.android.gms.wearable.Node
    public String getDisplayName() {
        return this.zzadI;
    }

    public int getHopCount() {
        return this.zzaUL;
    }

    @Override // com.google.android.gms.wearable.Node
    public String getId() {
        return this.zzKI;
    }

    public int hashCode() {
        return this.zzKI.hashCode();
    }

    @Override // com.google.android.gms.wearable.Node
    public boolean isNearby() {
        return this.zzaUM;
    }

    public String toString() {
        return "Node{" + this.zzadI + ", id=" + this.zzKI + ", hops=" + this.zzaUL + ", isNearby=" + this.zzaUM + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzay.zza(this, parcel, i);
    }
}
