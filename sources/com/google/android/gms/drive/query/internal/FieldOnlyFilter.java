package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* loaded from: classes.dex */
public class FieldOnlyFilter extends AbstractFilter {
    public static final Parcelable.Creator<FieldOnlyFilter> CREATOR = new zzb();
    final int zzCY;
    final MetadataBundle zzahR;
    private final MetadataField<?> zzahS;

    FieldOnlyFilter(int i, MetadataBundle metadataBundle) {
        this.zzCY = i;
        this.zzahR = metadataBundle;
        this.zzahS = zze.zzb(metadataBundle);
    }

    public FieldOnlyFilter(SearchableMetadataField<?> searchableMetadataField) {
        this(1, MetadataBundle.zza(searchableMetadataField, null));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }

    @Override // com.google.android.gms.drive.query.Filter
    public <T> T zza(zzf<T> zzfVar) {
        return zzfVar.zze(this.zzahS);
    }
}
