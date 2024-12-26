package com.google.android.gms.cast;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class zza implements Parcelable.Creator<ApplicationMetadata> {
    static void zza(ApplicationMetadata applicationMetadata, Parcel parcel, int i) {
        int zzac = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, applicationMetadata.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, applicationMetadata.getApplicationId(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, applicationMetadata.getName(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 4, applicationMetadata.getImages(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzb(parcel, 5, applicationMetadata.zzQw, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, applicationMetadata.getSenderAppIdentifier(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, (Parcelable) applicationMetadata.zzle(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzac);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzJ, reason: merged with bridge method [inline-methods] */
    public ApplicationMetadata createFromParcel(Parcel parcel) {
        int zzab = com.google.android.gms.common.internal.safeparcel.zza.zzab(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        ArrayList arrayList = null;
        ArrayList<String> arrayList2 = null;
        String str3 = null;
        Uri uri = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = com.google.android.gms.common.internal.safeparcel.zza.zzaa(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbA(zzaa)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    break;
                case 3:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    break;
                case 4:
                    arrayList = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzaa, WebImage.CREATOR);
                    break;
                case 5:
                    arrayList2 = com.google.android.gms.common.internal.safeparcel.zza.zzC(parcel, zzaa);
                    break;
                case 6:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    break;
                case 7:
                    uri = (Uri) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzaa, Uri.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new ApplicationMetadata(i, str, str2, arrayList, arrayList2, str3, uri);
        }
        throw new zza.C0039zza("Overread allowed size end=" + zzab, parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzaz, reason: merged with bridge method [inline-methods] */
    public ApplicationMetadata[] newArray(int i) {
        return new ApplicationMetadata[i];
    }
}
