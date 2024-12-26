package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.ChangesAvailableEvent;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.ProgressEvent;
import com.google.android.gms.drive.events.QueryResultEventParcelable;

/* loaded from: classes.dex */
public class zzaz implements Parcelable.Creator<OnEventResponse> {
    static void zza(OnEventResponse onEventResponse, Parcel parcel, int i) {
        int zzac = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, onEventResponse.zzCY);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 2, onEventResponse.zzaca);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, (Parcelable) onEventResponse.zzagj, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, (Parcelable) onEventResponse.zzagk, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, (Parcelable) onEventResponse.zzagl, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, (Parcelable) onEventResponse.zzagm, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 8, (Parcelable) onEventResponse.zzagn, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzac);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzbe, reason: merged with bridge method [inline-methods] */
    public OnEventResponse createFromParcel(Parcel parcel) {
        int zzab = com.google.android.gms.common.internal.safeparcel.zza.zzab(parcel);
        int i = 0;
        int i2 = 0;
        ChangeEvent changeEvent = null;
        CompletionEvent completionEvent = null;
        QueryResultEventParcelable queryResultEventParcelable = null;
        ChangesAvailableEvent changesAvailableEvent = null;
        ProgressEvent progressEvent = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = com.google.android.gms.common.internal.safeparcel.zza.zzaa(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbA(zzaa)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzaa);
                    break;
                case 3:
                    changeEvent = (ChangeEvent) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzaa, ChangeEvent.CREATOR);
                    break;
                case 4:
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzaa);
                    break;
                case 5:
                    completionEvent = (CompletionEvent) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzaa, CompletionEvent.CREATOR);
                    break;
                case 6:
                    queryResultEventParcelable = (QueryResultEventParcelable) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzaa, QueryResultEventParcelable.CREATOR);
                    break;
                case 7:
                    changesAvailableEvent = (ChangesAvailableEvent) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzaa, ChangesAvailableEvent.CREATOR);
                    break;
                case 8:
                    progressEvent = (ProgressEvent) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzaa, ProgressEvent.CREATOR);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new OnEventResponse(i, i2, changeEvent, completionEvent, queryResultEventParcelable, changesAvailableEvent, progressEvent);
        }
        throw new zza.C0039zza("Overread allowed size end=" + zzab, parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzcT, reason: merged with bridge method [inline-methods] */
    public OnEventResponse[] newArray(int i) {
        return new OnEventResponse[i];
    }
}
