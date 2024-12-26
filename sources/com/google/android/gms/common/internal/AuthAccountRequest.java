package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Set;

/* loaded from: classes.dex */
public class AuthAccountRequest implements SafeParcelable {
    public static final Parcelable.Creator<AuthAccountRequest> CREATOR = new zzc();
    final int zzCY;
    final IBinder zzZO;
    final Scope[] zzZP;

    AuthAccountRequest(int i, IBinder iBinder, Scope[] scopeArr) {
        this.zzCY = i;
        this.zzZO = iBinder;
        this.zzZP = scopeArr;
    }

    public AuthAccountRequest(IAccountAccessor iAccountAccessor, Set<Scope> set) {
        this(1, iAccountAccessor.asBinder(), (Scope[]) set.toArray(new Scope[set.size()]));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }
}
