package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;

/* loaded from: classes.dex */
public class Asset implements SafeParcelable {
    public static final Parcelable.Creator<Asset> CREATOR = new zzc();
    public Uri uri;
    final int zzCY;
    private String zzaSM;
    public ParcelFileDescriptor zzaSN;
    private byte[] zzauL;

    Asset(int i, byte[] bArr, String str, ParcelFileDescriptor parcelFileDescriptor, Uri uri) {
        this.zzCY = i;
        this.zzauL = bArr;
        this.zzaSM = str;
        this.zzaSN = parcelFileDescriptor;
        this.uri = uri;
    }

    public static Asset createFromBytes(byte[] bArr) {
        if (bArr != null) {
            return new Asset(1, bArr, null, null, null);
        }
        throw new IllegalArgumentException("Asset data cannot be null");
    }

    public static Asset createFromFd(ParcelFileDescriptor parcelFileDescriptor) {
        if (parcelFileDescriptor != null) {
            return new Asset(1, null, null, parcelFileDescriptor, null);
        }
        throw new IllegalArgumentException("Asset fd cannot be null");
    }

    public static Asset createFromRef(String str) {
        if (str != null) {
            return new Asset(1, null, str, null, null);
        }
        throw new IllegalArgumentException("Asset digest cannot be null");
    }

    public static Asset createFromUri(Uri uri) {
        if (uri != null) {
            return new Asset(1, null, null, null, uri);
        }
        throw new IllegalArgumentException("Asset uri cannot be null");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Asset)) {
            return false;
        }
        Asset asset = (Asset) obj;
        return zzt.equal(this.zzauL, asset.zzauL) && zzt.equal(this.zzaSM, asset.zzaSM) && zzt.equal(this.zzaSN, asset.zzaSN) && zzt.equal(this.uri, asset.uri);
    }

    public byte[] getData() {
        return this.zzauL;
    }

    public String getDigest() {
        return this.zzaSM;
    }

    public ParcelFileDescriptor getFd() {
        return this.zzaSN;
    }

    public Uri getUri() {
        return this.uri;
    }

    public int hashCode() {
        return zzt.hashCode(this.zzauL, this.zzaSM, this.zzaSN, this.uri);
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("Asset[@");
        sb.append(Integer.toHexString(hashCode()));
        if (this.zzaSM == null) {
            str = ", nodigest";
        } else {
            sb.append(", ");
            str = this.zzaSM;
        }
        sb.append(str);
        if (this.zzauL != null) {
            sb.append(", size=");
            sb.append(this.zzauL.length);
        }
        if (this.zzaSN != null) {
            sb.append(", fd=");
            sb.append(this.zzaSN);
        }
        if (this.uri != null) {
            sb.append(", uri=");
            sb.append(this.uri);
        }
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i | 1);
    }
}
