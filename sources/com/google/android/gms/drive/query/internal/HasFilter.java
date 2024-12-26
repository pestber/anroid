package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* loaded from: classes.dex */
public class HasFilter<T> extends AbstractFilter {
    public static final zzi CREATOR = new zzi();
    final int zzCY;
    final MetadataBundle zzahR;
    final MetadataField<T> zzahS;

    HasFilter(int i, MetadataBundle metadataBundle) {
        this.zzCY = i;
        this.zzahR = metadataBundle;
        this.zzahS = (MetadataField<T>) zze.zzb(metadataBundle);
    }

    public HasFilter(SearchableMetadataField<T> searchableMetadataField, T t) {
        this(1, MetadataBundle.zza(searchableMetadataField, t));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public T getValue() {
        return (T) this.zzahR.zza(this.zzahS);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzi.zza(this, parcel, i);
    }

    @Override // com.google.android.gms.drive.query.Filter
    public <F> F zza(zzf<F> zzfVar) {
        return zzfVar.zzd(this.zzahS, getValue());
    }
}
