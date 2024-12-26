package com.google.android.gms.wallet.firstparty;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public final class GetInstrumentsResponse implements SafeParcelable {
    public static final Parcelable.Creator<GetInstrumentsResponse> CREATOR = new zze();
    private final int zzCY;
    String[] zzaRM;
    byte[][] zzaRN;

    GetInstrumentsResponse() {
        this(1, new String[0], new byte[0][]);
    }

    GetInstrumentsResponse(int i, String[] strArr, byte[][] bArr) {
        this.zzCY = i;
        this.zzaRM = strArr;
        this.zzaRN = bArr;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zze.zza(this, parcel, i);
    }
}
