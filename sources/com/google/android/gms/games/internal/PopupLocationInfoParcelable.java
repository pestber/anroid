package com.google.android.gms.games.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.internal.PopupManager;

/* loaded from: classes.dex */
public final class PopupLocationInfoParcelable implements SafeParcelable {
    public static final PopupLocationInfoParcelableCreator CREATOR = new PopupLocationInfoParcelableCreator();
    private final int zzCY;
    private final Bundle zzaqr;
    private final IBinder zzaqs;

    PopupLocationInfoParcelable(int i, Bundle bundle, IBinder iBinder) {
        this.zzCY = i;
        this.zzaqr = bundle;
        this.zzaqs = iBinder;
    }

    public PopupLocationInfoParcelable(PopupManager.PopupLocationInfo popupLocationInfo) {
        this.zzCY = 1;
        this.zzaqr = popupLocationInfo.zztc();
        this.zzaqs = popupLocationInfo.zzaqv;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    public IBinder getWindowToken() {
        return this.zzaqs;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        PopupLocationInfoParcelableCreator.zza(this, parcel, i);
    }

    public Bundle zztc() {
        return this.zzaqr;
    }
}
