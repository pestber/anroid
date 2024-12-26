package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class ValidateAccountRequest implements SafeParcelable {
    public static final Parcelable.Creator<ValidateAccountRequest> CREATOR = new zzaa();
    final int zzCY;
    final IBinder zzZO;
    private final Scope[] zzZP;
    private final int zzabg;
    private final Bundle zzabh;
    private final String zzabi;

    ValidateAccountRequest(int i, int i2, IBinder iBinder, Scope[] scopeArr, Bundle bundle, String str) {
        this.zzCY = i;
        this.zzabg = i2;
        this.zzZO = iBinder;
        this.zzZP = scopeArr;
        this.zzabh = bundle;
        this.zzabi = str;
    }

    public ValidateAccountRequest(IAccountAccessor iAccountAccessor, Scope[] scopeArr, String str, Bundle bundle) {
        this(1, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, iAccountAccessor == null ? null : iAccountAccessor.asBinder(), scopeArr, bundle, str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getCallingPackage() {
        return this.zzabi;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzaa.zza(this, parcel, i);
    }

    public int zzod() {
        return this.zzabg;
    }

    public Scope[] zzoe() {
        return this.zzZP;
    }

    public Bundle zzof() {
        return this.zzabh;
    }
}
