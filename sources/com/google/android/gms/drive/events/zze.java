package com.google.android.gms.drive.events;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class zze implements Parcelable.Creator<CompletionEvent> {
    static void zza(CompletionEvent completionEvent, Parcel parcel, int i) {
        int zzac = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, completionEvent.zzCY);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, (Parcelable) completionEvent.zzacT, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, completionEvent.zzOx, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, (Parcelable) completionEvent.zzadT, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, (Parcelable) completionEvent.zzadU, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, (Parcelable) completionEvent.zzadV, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzb(parcel, 7, completionEvent.zzadW, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 8, completionEvent.zzwS);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 9, completionEvent.zzadX, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzac);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzay, reason: merged with bridge method [inline-methods] */
    public CompletionEvent createFromParcel(Parcel parcel) {
        int zzab = com.google.android.gms.common.internal.safeparcel.zza.zzab(parcel);
        int i = 0;
        int i2 = 0;
        DriveId driveId = null;
        String str = null;
        ParcelFileDescriptor parcelFileDescriptor = null;
        ParcelFileDescriptor parcelFileDescriptor2 = null;
        MetadataBundle metadataBundle = null;
        ArrayList<String> arrayList = null;
        IBinder iBinder = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = com.google.android.gms.common.internal.safeparcel.zza.zzaa(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbA(zzaa)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    driveId = (DriveId) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzaa, DriveId.CREATOR);
                    break;
                case 3:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    break;
                case 4:
                    parcelFileDescriptor = (ParcelFileDescriptor) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzaa, ParcelFileDescriptor.CREATOR);
                    break;
                case 5:
                    parcelFileDescriptor2 = (ParcelFileDescriptor) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzaa, ParcelFileDescriptor.CREATOR);
                    break;
                case 6:
                    metadataBundle = (MetadataBundle) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzaa, MetadataBundle.CREATOR);
                    break;
                case 7:
                    arrayList = com.google.android.gms.common.internal.safeparcel.zza.zzC(parcel, zzaa);
                    break;
                case 8:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzaa);
                    break;
                case 9:
                    iBinder = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzaa);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new CompletionEvent(i, driveId, str, parcelFileDescriptor, parcelFileDescriptor2, metadataBundle, arrayList, i2, iBinder);
        }
        throw new zza.C0039zza("Overread allowed size end=" + zzab, parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzch, reason: merged with bridge method [inline-methods] */
    public CompletionEvent[] newArray(int i) {
        return new CompletionEvent[i];
    }
}
