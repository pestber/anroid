package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;

/* loaded from: classes.dex */
public class MessageType implements SafeParcelable {
    public static final Parcelable.Creator<MessageType> CREATOR = new zzd();
    public final String type;
    final int versionCode;
    public final String zzaby;

    MessageType(int i, String str, String str2) {
        this.versionCode = i;
        this.zzaby = str;
        this.type = str2;
    }

    public MessageType(String str, String str2) {
        this(1, str, str2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MessageType)) {
            return false;
        }
        MessageType messageType = (MessageType) obj;
        return zzt.equal(this.zzaby, messageType.zzaby) && zzt.equal(this.type, messageType.type);
    }

    public int hashCode() {
        return zzt.hashCode(this.zzaby, this.type);
    }

    public String toString() {
        return "namespace=" + this.zzaby + ", type=" + this.type;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzd.zza(this, parcel, i);
    }
}
