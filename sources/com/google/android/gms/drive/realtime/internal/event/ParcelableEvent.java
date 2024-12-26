package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

/* loaded from: classes.dex */
public class ParcelableEvent implements SafeParcelable {
    public static final Parcelable.Creator<ParcelableEvent> CREATOR = new zzc();
    final int zzCY;
    final String zzEO;
    final String zzFE;
    final List<String> zzaiC;
    final boolean zzaiD;
    final boolean zzaiE;
    final boolean zzaiF;
    final String zzaiG;
    final TextInsertedDetails zzaiH;
    final TextDeletedDetails zzaiI;
    final ValuesAddedDetails zzaiJ;
    final ValuesRemovedDetails zzaiK;
    final ValuesSetDetails zzaiL;
    final ValueChangedDetails zzaiM;
    final ReferenceShiftedDetails zzaiN;
    final ObjectChangedDetails zzaiO;
    final FieldChangedDetails zzaiP;
    final String zzaiw;

    ParcelableEvent(int i, String str, String str2, List<String> list, boolean z, boolean z2, boolean z3, String str3, String str4, TextInsertedDetails textInsertedDetails, TextDeletedDetails textDeletedDetails, ValuesAddedDetails valuesAddedDetails, ValuesRemovedDetails valuesRemovedDetails, ValuesSetDetails valuesSetDetails, ValueChangedDetails valueChangedDetails, ReferenceShiftedDetails referenceShiftedDetails, ObjectChangedDetails objectChangedDetails, FieldChangedDetails fieldChangedDetails) {
        this.zzCY = i;
        this.zzFE = str;
        this.zzEO = str2;
        this.zzaiC = list;
        this.zzaiD = z;
        this.zzaiE = z2;
        this.zzaiF = z3;
        this.zzaiw = str3;
        this.zzaiG = str4;
        this.zzaiH = textInsertedDetails;
        this.zzaiI = textDeletedDetails;
        this.zzaiJ = valuesAddedDetails;
        this.zzaiK = valuesRemovedDetails;
        this.zzaiL = valuesSetDetails;
        this.zzaiM = valueChangedDetails;
        this.zzaiN = referenceShiftedDetails;
        this.zzaiO = objectChangedDetails;
        this.zzaiP = fieldChangedDetails;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }
}
