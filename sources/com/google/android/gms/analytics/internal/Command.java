package com.google.android.gms.analytics.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class Command implements Parcelable {

    @Deprecated
    public static final Parcelable.Creator<Command> CREATOR = new Parcelable.Creator<Command>() { // from class: com.google.android.gms.analytics.internal.Command.1
        @Override // android.os.Parcelable.Creator
        @Deprecated
        /* renamed from: zzaa, reason: merged with bridge method [inline-methods] */
        public Command[] newArray(int i) {
            return new Command[i];
        }

        @Override // android.os.Parcelable.Creator
        @Deprecated
        /* renamed from: zzq, reason: merged with bridge method [inline-methods] */
        public Command createFromParcel(Parcel parcel) {
            return new Command(parcel);
        }
    };
    private String mValue;
    private String zzKI;
    private String zzKJ;

    @Deprecated
    public Command() {
    }

    @Deprecated
    Command(Parcel parcel) {
        readFromParcel(parcel);
    }

    @Deprecated
    private void readFromParcel(Parcel parcel) {
        this.zzKI = parcel.readString();
        this.zzKJ = parcel.readString();
        this.mValue = parcel.readString();
    }

    @Override // android.os.Parcelable
    @Deprecated
    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.zzKI;
    }

    public String getValue() {
        return this.mValue;
    }

    @Override // android.os.Parcelable
    @Deprecated
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zzKI);
        parcel.writeString(this.zzKJ);
        parcel.writeString(this.mValue);
    }
}
