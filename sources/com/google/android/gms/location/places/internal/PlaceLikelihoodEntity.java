package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.PlaceLikelihood;

/* loaded from: classes.dex */
public class PlaceLikelihoodEntity implements SafeParcelable, PlaceLikelihood {
    public static final Parcelable.Creator<PlaceLikelihoodEntity> CREATOR = new zzl();
    final int zzCY;
    final PlaceImpl zzaAK;
    final float zzaAL;

    PlaceLikelihoodEntity(int i, PlaceImpl placeImpl, float f) {
        this.zzCY = i;
        this.zzaAK = placeImpl;
        this.zzaAL = f;
    }

    public static PlaceLikelihoodEntity zza(PlaceImpl placeImpl, float f) {
        return new PlaceLikelihoodEntity(0, (PlaceImpl) com.google.android.gms.common.internal.zzu.zzu(placeImpl), f);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlaceLikelihoodEntity)) {
            return false;
        }
        PlaceLikelihoodEntity placeLikelihoodEntity = (PlaceLikelihoodEntity) obj;
        return this.zzaAK.equals(placeLikelihoodEntity.zzaAK) && this.zzaAL == placeLikelihoodEntity.zzaAL;
    }

    @Override // com.google.android.gms.location.places.PlaceLikelihood
    public float getLikelihood() {
        return this.zzaAL;
    }

    @Override // com.google.android.gms.location.places.PlaceLikelihood
    public Place getPlace() {
        return this.zzaAK;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.zzt.hashCode(this.zzaAK, Float.valueOf(this.zzaAL));
    }

    @Override // com.google.android.gms.common.data.Freezable
    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return com.google.android.gms.common.internal.zzt.zzt(this).zzg("place", this.zzaAK).zzg("likelihood", Float.valueOf(this.zzaAL)).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzl.zza(this, parcel, i);
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: zzuY, reason: merged with bridge method [inline-methods] */
    public PlaceLikelihood freeze() {
        return this;
    }
}
