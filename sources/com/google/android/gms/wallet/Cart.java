package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class Cart implements SafeParcelable {
    public static final Parcelable.Creator<Cart> CREATOR = new zzb();
    private final int zzCY;
    String zzaQf;
    String zzaQg;
    ArrayList<LineItem> zzaQh;

    public final class Builder {
        private Builder() {
        }

        public Builder addLineItem(LineItem lineItem) {
            Cart.this.zzaQh.add(lineItem);
            return this;
        }

        public Cart build() {
            return Cart.this;
        }

        public Builder setCurrencyCode(String str) {
            Cart.this.zzaQg = str;
            return this;
        }

        public Builder setLineItems(List<LineItem> list) {
            Cart.this.zzaQh.clear();
            Cart.this.zzaQh.addAll(list);
            return this;
        }

        public Builder setTotalPrice(String str) {
            Cart.this.zzaQf = str;
            return this;
        }
    }

    Cart() {
        this.zzCY = 1;
        this.zzaQh = new ArrayList<>();
    }

    Cart(int i, String str, String str2, ArrayList<LineItem> arrayList) {
        this.zzCY = i;
        this.zzaQf = str;
        this.zzaQg = str2;
        this.zzaQh = arrayList;
    }

    public static Builder newBuilder() {
        Cart cart = new Cart();
        cart.getClass();
        return new Builder();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getCurrencyCode() {
        return this.zzaQg;
    }

    public ArrayList<LineItem> getLineItems() {
        return this.zzaQh;
    }

    public String getTotalPrice() {
        return this.zzaQf;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }
}
