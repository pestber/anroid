package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* loaded from: classes.dex */
public class ComparisonFilter<T> extends AbstractFilter {
    public static final zza CREATOR = new zza();
    final int zzCY;
    final Operator zzahQ;
    final MetadataBundle zzahR;
    final MetadataField<T> zzahS;

    ComparisonFilter(int i, Operator operator, MetadataBundle metadataBundle) {
        this.zzCY = i;
        this.zzahQ = operator;
        this.zzahR = metadataBundle;
        this.zzahS = (MetadataField<T>) zze.zzb(metadataBundle);
    }

    public ComparisonFilter(Operator operator, SearchableMetadataField<T> searchableMetadataField, T t) {
        this(1, operator, MetadataBundle.zza(searchableMetadataField, t));
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
        zza.zza(this, parcel, i);
    }

    @Override // com.google.android.gms.drive.query.Filter
    public <F> F zza(zzf<F> zzfVar) {
        return zzfVar.zzb(this.zzahQ, this.zzahS, getValue());
    }
}
