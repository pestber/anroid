package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public class AutocompleteFilter implements SafeParcelable {
    public static final zzc CREATOR = new zzc();
    final int zzCY;
    final boolean zzazr;
    final List<Integer> zzazs;
    private final Set<Integer> zzazt;

    AutocompleteFilter(int i, boolean z, Collection<Integer> collection) {
        this.zzCY = i;
        this.zzazr = z;
        this.zzazs = collection == null ? Collections.emptyList() : new ArrayList<>(collection);
        this.zzazt = this.zzazs.isEmpty() ? Collections.emptySet() : Collections.unmodifiableSet(new HashSet(this.zzazs));
    }

    public static AutocompleteFilter create(Collection<Integer> collection) {
        return zza(true, collection);
    }

    public static AutocompleteFilter zza(boolean z, Collection<Integer> collection) {
        return new AutocompleteFilter(0, z, collection);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AutocompleteFilter)) {
            return false;
        }
        AutocompleteFilter autocompleteFilter = (AutocompleteFilter) obj;
        return this.zzazt.equals(autocompleteFilter.zzazt) && this.zzazr == autocompleteFilter.zzazr;
    }

    public Set<Integer> getPlaceTypes() {
        return this.zzazt;
    }

    public int hashCode() {
        return zzt.hashCode(Boolean.valueOf(this.zzazr), this.zzazt);
    }

    public String toString() {
        zzt.zza zzt = zzt.zzt(this);
        if (!this.zzazr) {
            zzt.zzg("restrictedToPlaces", Boolean.valueOf(this.zzazr));
        }
        zzt.zzg("placeTypes", this.zzazt);
        return zzt.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }

    public boolean zzuE() {
        return this.zzazr;
    }
}
