package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.nearby.messages.internal.MessageType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class MessageFilter implements SafeParcelable {
    public static final Parcelable.Creator<MessageFilter> CREATOR = new zzb();
    public static final MessageFilter zzaFO = new zza().zzwX().zzwY();
    final int versionCode;
    private final List<MessageType> zzaFP;

    public static final class zza {
        private final List<MessageType> zzaFP = new ArrayList();

        private zza zzC(String str, String str2) {
            this.zzaFP.add(new MessageType(str, str2));
            return this;
        }

        public zza zzwX() {
            return zzC("", "");
        }

        public MessageFilter zzwY() {
            zzu.zza(!this.zzaFP.isEmpty(), "At least one of the include methods must be called.");
            return new MessageFilter(this.zzaFP);
        }
    }

    MessageFilter(int i, List<MessageType> list) {
        this.versionCode = i;
        this.zzaFP = Collections.unmodifiableList((List) zzu.zzu(list));
    }

    private MessageFilter(List<MessageType> list) {
        this(1, list);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MessageFilter) {
            return zzt.equal(this.zzaFP, ((MessageFilter) obj).zzaFP);
        }
        return false;
    }

    public int hashCode() {
        return zzt.hashCode(this.zzaFP);
    }

    public String toString() {
        return "MessageFilter" + this.zzaFP;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }

    List<MessageType> zzwW() {
        return this.zzaFP;
    }
}
