package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class Credential implements SafeParcelable {
    public static final Parcelable.Creator<Credential> CREATOR = new zza();
    public static final String EXTRA_KEY = "com.google.android.gms.credentials.Credential";
    private final String mName;
    final int zzCY;
    private final String zzKI;
    private final String zzOS;
    private final String zzOT;
    private final Uri zzOU;
    private final List<IdToken> zzOV;
    private final String zzOW;
    private final String zzOX;

    public static class Builder {
        private String mName;
        private final String zzKI;
        private String zzOS;
        private String zzOT;
        private Uri zzOU;
        private List<IdToken> zzOV;
        private String zzOW;
        private String zzOX;

        public Builder(Credential credential) {
            this.zzKI = credential.zzKI;
            this.mName = credential.mName;
            this.zzOU = credential.zzOU;
            this.zzOV = credential.zzOV;
            this.zzOW = credential.zzOW;
            this.zzOX = credential.zzOX;
            this.zzOS = credential.zzOS;
            this.zzOT = credential.zzOT;
        }

        public Builder(String str) {
            this.zzKI = str;
        }

        public Credential build() {
            if (TextUtils.isEmpty(this.zzOW) || TextUtils.isEmpty(this.zzOX)) {
                return new Credential(1, this.zzOS, this.zzOT, this.zzKI, this.mName, this.zzOU, this.zzOV, this.zzOW, this.zzOX);
            }
            throw new IllegalStateException("Only one of password or accountType may be set");
        }

        public Builder setAccountType(String str) {
            this.zzOX = str;
            return this;
        }

        public Builder setName(String str) {
            this.mName = str;
            return this;
        }

        public Builder setPassword(String str) {
            this.zzOW = str;
            return this;
        }

        public Builder setProfilePictureUri(Uri uri) {
            this.zzOU = uri;
            return this;
        }
    }

    Credential(int i, String str, String str2, String str3, String str4, Uri uri, List<IdToken> list, String str5, String str6) {
        this.zzCY = i;
        this.zzOS = str;
        this.zzOT = str2;
        this.zzKI = (String) zzu.zzu(str3);
        this.mName = str4;
        this.zzOU = uri;
        this.zzOV = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        this.zzOW = str5;
        this.zzOX = str6;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAccountType() {
        return this.zzOX;
    }

    public String getId() {
        return this.zzKI;
    }

    public String getName() {
        return this.mName;
    }

    public String getPassword() {
        return this.zzOW;
    }

    public Uri getProfilePictureUri() {
        return this.zzOU;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    public String zzkZ() {
        return this.zzOS;
    }

    public String zzla() {
        return this.zzOT;
    }

    public List<IdToken> zzlb() {
        return this.zzOV;
    }
}
