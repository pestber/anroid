package com.google.android.gms.identity.intents;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class UserAddressRequest implements SafeParcelable {
    public static final Parcelable.Creator<UserAddressRequest> CREATOR = new zza();
    private final int zzCY;
    List<CountrySpecification> zzawx;

    public final class Builder {
        private Builder() {
        }

        public Builder addAllowedCountrySpecification(CountrySpecification countrySpecification) {
            if (UserAddressRequest.this.zzawx == null) {
                UserAddressRequest.this.zzawx = new ArrayList();
            }
            UserAddressRequest.this.zzawx.add(countrySpecification);
            return this;
        }

        public Builder addAllowedCountrySpecifications(Collection<CountrySpecification> collection) {
            if (UserAddressRequest.this.zzawx == null) {
                UserAddressRequest.this.zzawx = new ArrayList();
            }
            UserAddressRequest.this.zzawx.addAll(collection);
            return this;
        }

        public UserAddressRequest build() {
            if (UserAddressRequest.this.zzawx != null) {
                UserAddressRequest.this.zzawx = Collections.unmodifiableList(UserAddressRequest.this.zzawx);
            }
            return UserAddressRequest.this;
        }
    }

    UserAddressRequest() {
        this.zzCY = 1;
    }

    UserAddressRequest(int i, List<CountrySpecification> list) {
        this.zzCY = i;
        this.zzawx = list;
    }

    public static Builder newBuilder() {
        UserAddressRequest userAddressRequest = new UserAddressRequest();
        userAddressRequest.getClass();
        return new Builder();
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
        zza.zza(this, parcel, i);
    }
}
