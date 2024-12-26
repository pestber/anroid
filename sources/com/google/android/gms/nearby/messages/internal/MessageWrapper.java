package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.nearby.messages.Message;

/* loaded from: classes.dex */
public class MessageWrapper implements SafeParcelable {
    public static final zze CREATOR = new zze();
    final int versionCode;
    public final Message zzaFZ;

    MessageWrapper(int i, Message message) {
        this.versionCode = i;
        this.zzaFZ = (Message) zzu.zzu(message);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zze.zza(this, parcel, i);
    }
}
