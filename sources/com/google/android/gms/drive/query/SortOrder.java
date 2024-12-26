package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.drive.query.internal.FieldWithSortOrder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public class SortOrder implements SafeParcelable {
    public static final Parcelable.Creator<SortOrder> CREATOR = new zzb();
    final int zzCY;
    final List<FieldWithSortOrder> zzahO;
    final boolean zzahP;

    public static class Builder {
        private final List<FieldWithSortOrder> zzahO = new ArrayList();
        private boolean zzahP = false;

        public Builder addSortAscending(SortableMetadataField sortableMetadataField) {
            this.zzahO.add(new FieldWithSortOrder(sortableMetadataField.getName(), true));
            return this;
        }

        public Builder addSortDescending(SortableMetadataField sortableMetadataField) {
            this.zzahO.add(new FieldWithSortOrder(sortableMetadataField.getName(), false));
            return this;
        }

        public SortOrder build() {
            return new SortOrder(this.zzahO, this.zzahP);
        }
    }

    SortOrder(int i, List<FieldWithSortOrder> list, boolean z) {
        this.zzCY = i;
        this.zzahO = list;
        this.zzahP = z;
    }

    private SortOrder(List<FieldWithSortOrder> list, boolean z) {
        this(1, list, z);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return String.format(Locale.US, "SortOrder[%s, %s]", TextUtils.join(",", this.zzahO), Boolean.valueOf(this.zzahP));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }
}
