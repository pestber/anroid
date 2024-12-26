package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.MessageEvent;

/* loaded from: classes.dex */
public class MessageEventParcelable implements SafeParcelable, MessageEvent {
    public static final Parcelable.Creator<MessageEventParcelable> CREATOR = new zzaw();
    final int zzCY;
    private final String zzaTQ;
    private final int zzacR;
    private final byte[] zzauL;
    private final String zzazL;

    MessageEventParcelable(int i, int i2, String str, byte[] bArr, String str2) {
        this.zzCY = i;
        this.zzacR = i2;
        this.zzaTQ = str;
        this.zzauL = bArr;
        this.zzazL = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.wearable.MessageEvent
    public byte[] getData() {
        return this.zzauL;
    }

    @Override // com.google.android.gms.wearable.MessageEvent
    public String getPath() {
        return this.zzaTQ;
    }

    @Override // com.google.android.gms.wearable.MessageEvent
    public int getRequestId() {
        return this.zzacR;
    }

    @Override // com.google.android.gms.wearable.MessageEvent
    public String getSourceNodeId() {
        return this.zzazL;
    }

    public String toString() {
        return "MessageEventParcelable[" + this.zzacR + "," + this.zzaTQ + ", size=" + (this.zzauL == null ? "null" : Integer.valueOf(this.zzauL.length)) + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzaw.zza(this, parcel, i);
    }
}
