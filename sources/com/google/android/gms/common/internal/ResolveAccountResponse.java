package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class ResolveAccountResponse implements SafeParcelable {
    public static final Parcelable.Creator<ResolveAccountResponse> CREATOR = new zzw();
    final int zzCY;
    private boolean zzWY;
    private ConnectionResult zzYh;
    IBinder zzZO;
    private boolean zzabd;

    public ResolveAccountResponse(int i) {
        this(new ConnectionResult(i, null));
    }

    ResolveAccountResponse(int i, IBinder iBinder, ConnectionResult connectionResult, boolean z, boolean z2) {
        this.zzCY = i;
        this.zzZO = iBinder;
        this.zzYh = connectionResult;
        this.zzWY = z;
        this.zzabd = z2;
    }

    public ResolveAccountResponse(ConnectionResult connectionResult) {
        this(1, null, connectionResult, false, false);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResolveAccountResponse)) {
            return false;
        }
        ResolveAccountResponse resolveAccountResponse = (ResolveAccountResponse) obj;
        return this.zzYh.equals(resolveAccountResponse.zzYh) && zznZ().equals(resolveAccountResponse.zznZ());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzw.zza(this, parcel, i);
    }

    public IAccountAccessor zznZ() {
        return IAccountAccessor.zza.zzaD(this.zzZO);
    }

    public ConnectionResult zzoa() {
        return this.zzYh;
    }

    public boolean zzob() {
        return this.zzWY;
    }

    public boolean zzoc() {
        return this.zzabd;
    }
}
