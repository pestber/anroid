package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zzf implements Parcelable.Creator<DataSource> {
    static void zza(DataSource dataSource, Parcel parcel, int i) {
        int zzac = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, (Parcelable) dataSource.getDataType(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, dataSource.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, dataSource.getName(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 3, dataSource.getType());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, (Parcelable) dataSource.getDevice(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, (Parcelable) dataSource.zzqB(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, dataSource.getStreamName(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzac);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzcn, reason: merged with bridge method [inline-methods] */
    public DataSource createFromParcel(Parcel parcel) {
        int zzab = com.google.android.gms.common.internal.safeparcel.zza.zzab(parcel);
        int i = 0;
        int i2 = 0;
        DataType dataType = null;
        String str = null;
        Device device = null;
        Application application = null;
        String str2 = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = com.google.android.gms.common.internal.safeparcel.zza.zzaa(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbA(zzaa)) {
                case 1:
                    dataType = (DataType) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzaa, DataType.CREATOR);
                    break;
                case 2:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    break;
                case 3:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzaa);
                    break;
                case 4:
                    device = (Device) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzaa, Device.CREATOR);
                    break;
                case 5:
                    application = (Application) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzaa, Application.CREATOR);
                    break;
                case 6:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    break;
                case 1000:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzaa);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new DataSource(i, dataType, str, i2, device, application, str2);
        }
        throw new zza.C0039zza("Overread allowed size end=" + zzab, parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzeg, reason: merged with bridge method [inline-methods] */
    public DataSource[] newArray(int i) {
        return new DataSource[i];
    }
}
