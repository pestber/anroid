package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public final class LineItem implements SafeParcelable {
    public static final Parcelable.Creator<LineItem> CREATOR = new zzi();
    String description;
    private final int zzCY;
    String zzaQI;
    String zzaQJ;
    int zzaQK;
    String zzaQf;
    String zzaQg;

    public final class Builder {
        private Builder() {
        }

        public LineItem build() {
            return LineItem.this;
        }

        public Builder setCurrencyCode(String str) {
            LineItem.this.zzaQg = str;
            return this;
        }

        public Builder setDescription(String str) {
            LineItem.this.description = str;
            return this;
        }

        public Builder setQuantity(String str) {
            LineItem.this.zzaQI = str;
            return this;
        }

        public Builder setRole(int i) {
            LineItem.this.zzaQK = i;
            return this;
        }

        public Builder setTotalPrice(String str) {
            LineItem.this.zzaQf = str;
            return this;
        }

        public Builder setUnitPrice(String str) {
            LineItem.this.zzaQJ = str;
            return this;
        }
    }

    public interface Role {
        public static final int REGULAR = 0;
        public static final int SHIPPING = 2;
        public static final int TAX = 1;
    }

    LineItem() {
        this.zzCY = 1;
        this.zzaQK = 0;
    }

    LineItem(int i, String str, String str2, String str3, String str4, int i2, String str5) {
        this.zzCY = i;
        this.description = str;
        this.zzaQI = str2;
        this.zzaQJ = str3;
        this.zzaQf = str4;
        this.zzaQK = i2;
        this.zzaQg = str5;
    }

    public static Builder newBuilder() {
        LineItem lineItem = new LineItem();
        lineItem.getClass();
        return new Builder();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getCurrencyCode() {
        return this.zzaQg;
    }

    public String getDescription() {
        return this.description;
    }

    public String getQuantity() {
        return this.zzaQI;
    }

    public int getRole() {
        return this.zzaQK;
    }

    public String getTotalPrice() {
        return this.zzaQf;
    }

    public String getUnitPrice() {
        return this.zzaQJ;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzi.zza(this, parcel, i);
    }
}
