package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public final class CredentialRequest implements SafeParcelable {
    public static final Parcelable.Creator<CredentialRequest> CREATOR = new zzb();
    final int zzCY;
    private final boolean zzOY;
    private final String[] zzOZ;

    public static final class Builder {
        boolean zzOY;
        String[] zzOZ;

        public CredentialRequest build() {
            if (this.zzOZ == null) {
                this.zzOZ = new String[0];
            }
            if (this.zzOY || this.zzOZ.length != 0) {
                return new CredentialRequest(this);
            }
            throw new IllegalStateException("At least one authentication method must be specified");
        }

        public Builder setAccountTypes(String... strArr) {
            this.zzOZ = strArr;
            return this;
        }

        public Builder setSupportsPasswordLogin(boolean z) {
            this.zzOY = z;
            return this;
        }
    }

    CredentialRequest(int i, boolean z, String[] strArr) {
        this.zzCY = i;
        this.zzOY = z;
        this.zzOZ = strArr;
    }

    private CredentialRequest(Builder builder) {
        this.zzCY = 1;
        this.zzOY = builder.zzOY;
        this.zzOZ = builder.zzOZ;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String[] getAccountTypes() {
        return this.zzOZ;
    }

    public boolean getSupportsPasswordLogin() {
        return this.zzOY;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }
}
