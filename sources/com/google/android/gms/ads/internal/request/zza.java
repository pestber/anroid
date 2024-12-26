package com.google.android.gms.ads.internal.request;

import android.content.Context;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.internal.zzan;
import com.google.android.gms.internal.zzbz;
import com.google.android.gms.internal.zzgd;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzhh;

@zzgd
/* loaded from: classes.dex */
public class zza {

    /* renamed from: com.google.android.gms.ads.internal.request.zza$zza, reason: collision with other inner class name */
    public interface InterfaceC0017zza {
        void zza(zzha.zza zzaVar);
    }

    public zzhh zza(Context context, AdRequestInfoParcel.zza zzaVar, zzan zzanVar, InterfaceC0017zza interfaceC0017zza) {
        zzhh zzbVar = (!zzbz.zzuu.get().booleanValue() || zzaVar.zzCm.extras.getBundle("sdk_less_server_data") == null) ? new zzb(context, zzaVar, zzanVar, interfaceC0017zza) : new zzl(context, zzaVar, interfaceC0017zza);
        zzbVar.zzgj();
        return zzbVar;
    }
}
