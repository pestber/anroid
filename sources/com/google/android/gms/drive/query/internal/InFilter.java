package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.Collection;
import java.util.Collections;

/* loaded from: classes.dex */
public class InFilter<T> extends AbstractFilter {
    public static final zzj CREATOR = new zzj();
    final int zzCY;
    final MetadataBundle zzahR;
    private final com.google.android.gms.drive.metadata.zzb<T> zzaie;

    InFilter(int i, MetadataBundle metadataBundle) {
        this.zzCY = i;
        this.zzahR = metadataBundle;
        this.zzaie = (com.google.android.gms.drive.metadata.zzb) zze.zzb(metadataBundle);
    }

    public InFilter(SearchableCollectionMetadataField<T> searchableCollectionMetadataField, T t) {
        this(1, MetadataBundle.zza(searchableCollectionMetadataField, Collections.singleton(t)));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public T getValue() {
        return (T) ((Collection) this.zzahR.zza(this.zzaie)).iterator().next();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzj.zza(this, parcel, i);
    }

    @Override // com.google.android.gms.drive.query.Filter
    public <F> F zza(zzf<F> zzfVar) {
        return zzfVar.zzb((com.google.android.gms.drive.metadata.zzb<com.google.android.gms.drive.metadata.zzb<T>>) this.zzaie, (com.google.android.gms.drive.metadata.zzb<T>) getValue());
    }
}
