package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.places.AutocompletePrediction;
import com.google.android.gms.plus.PlusShare;
import java.util.List;

/* loaded from: classes.dex */
public class AutocompletePredictionEntity implements SafeParcelable, AutocompletePrediction {
    public static final Parcelable.Creator<AutocompletePredictionEntity> CREATOR = new zza();
    final int zzCY;
    final List<SubstringEntity> zzaAe;
    final int zzaAf;
    final String zzakM;
    final String zzazK;
    final List<Integer> zzazo;

    public static class SubstringEntity implements SafeParcelable, AutocompletePrediction.Substring {
        public static final Parcelable.Creator<SubstringEntity> CREATOR = new zzu();
        final int mLength;
        final int mOffset;
        final int zzCY;

        public SubstringEntity(int i, int i2, int i3) {
            this.zzCY = i;
            this.mOffset = i2;
            this.mLength = i3;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SubstringEntity)) {
                return false;
            }
            SubstringEntity substringEntity = (SubstringEntity) obj;
            return com.google.android.gms.common.internal.zzt.equal(Integer.valueOf(this.mOffset), Integer.valueOf(substringEntity.mOffset)) && com.google.android.gms.common.internal.zzt.equal(Integer.valueOf(this.mLength), Integer.valueOf(substringEntity.mLength));
        }

        @Override // com.google.android.gms.location.places.AutocompletePrediction.Substring
        public int getLength() {
            return this.mLength;
        }

        @Override // com.google.android.gms.location.places.AutocompletePrediction.Substring
        public int getOffset() {
            return this.mOffset;
        }

        public int hashCode() {
            return com.google.android.gms.common.internal.zzt.hashCode(Integer.valueOf(this.mOffset), Integer.valueOf(this.mLength));
        }

        public String toString() {
            return com.google.android.gms.common.internal.zzt.zzt(this).zzg("offset", Integer.valueOf(this.mOffset)).zzg("length", Integer.valueOf(this.mLength)).toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            zzu.zza(this, parcel, i);
        }
    }

    AutocompletePredictionEntity(int i, String str, String str2, List<Integer> list, List<SubstringEntity> list2, int i2) {
        this.zzCY = i;
        this.zzakM = str;
        this.zzazK = str2;
        this.zzazo = list;
        this.zzaAe = list2;
        this.zzaAf = i2;
    }

    public static AutocompletePredictionEntity zza(String str, String str2, List<Integer> list, List<SubstringEntity> list2, int i) {
        return new AutocompletePredictionEntity(0, (String) com.google.android.gms.common.internal.zzu.zzu(str), str2, list, list2, i);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AutocompletePredictionEntity)) {
            return false;
        }
        AutocompletePredictionEntity autocompletePredictionEntity = (AutocompletePredictionEntity) obj;
        return com.google.android.gms.common.internal.zzt.equal(this.zzakM, autocompletePredictionEntity.zzakM) && com.google.android.gms.common.internal.zzt.equal(this.zzazK, autocompletePredictionEntity.zzazK) && com.google.android.gms.common.internal.zzt.equal(this.zzazo, autocompletePredictionEntity.zzazo) && com.google.android.gms.common.internal.zzt.equal(this.zzaAe, autocompletePredictionEntity.zzaAe) && com.google.android.gms.common.internal.zzt.equal(Integer.valueOf(this.zzaAf), Integer.valueOf(autocompletePredictionEntity.zzaAf));
    }

    @Override // com.google.android.gms.location.places.AutocompletePrediction
    public String getDescription() {
        return this.zzakM;
    }

    @Override // com.google.android.gms.location.places.AutocompletePrediction
    public List<? extends AutocompletePrediction.Substring> getMatchedSubstrings() {
        return this.zzaAe;
    }

    @Override // com.google.android.gms.location.places.AutocompletePrediction
    public String getPlaceId() {
        return this.zzazK;
    }

    @Override // com.google.android.gms.location.places.AutocompletePrediction
    public List<Integer> getPlaceTypes() {
        return this.zzazo;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.zzt.hashCode(this.zzakM, this.zzazK, this.zzazo, this.zzaAe, Integer.valueOf(this.zzaAf));
    }

    @Override // com.google.android.gms.common.data.Freezable
    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return com.google.android.gms.common.internal.zzt.zzt(this).zzg(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, this.zzakM).zzg("placeId", this.zzazK).zzg("placeTypes", this.zzazo).zzg("substrings", this.zzaAe).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: zzuL, reason: merged with bridge method [inline-methods] */
    public AutocompletePrediction freeze() {
        return this;
    }
}
