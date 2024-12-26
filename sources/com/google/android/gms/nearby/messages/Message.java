package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;

/* loaded from: classes.dex */
public class Message implements SafeParcelable {
    public static final Parcelable.Creator<Message> CREATOR = new zza();
    private final byte[] content;
    private final String type;
    final int versionCode;
    private final String zzaby;

    Message(int i, byte[] bArr, String str, String str2) {
        zzu.zzb(bArr.length <= 102400, "Content length(%d) must not exceed MAX_CONTENT_SIZE_BYTES(%d)", Integer.valueOf(bArr.length), 102400);
        this.versionCode = i;
        this.content = (byte[]) zzu.zzu(bArr);
        this.type = (String) zzu.zzu(str2);
        this.zzaby = str == null ? "" : str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getNamespace() {
        return this.zzaby;
    }

    public String getType() {
        return this.type;
    }

    public String toString() {
        return "Message{type='" + this.type + "', namespace='" + this.zzaby + "', content=[" + this.content.length + " bytes]}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    public byte[] zzwV() {
        return this.content;
    }
}
