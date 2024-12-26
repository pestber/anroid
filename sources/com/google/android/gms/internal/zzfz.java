package com.google.android.gms.internal;

import com.google.android.gms.internal.zzfy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import org.json.JSONException;
import org.json.JSONObject;

@zzgd
/* loaded from: classes.dex */
public class zzfz implements zzfy.zza<com.google.android.gms.ads.internal.formats.zzd> {
    private final boolean zzBY;
    private final boolean zzBZ;

    public zzfz(boolean z, boolean z2) {
        this.zzBY = z;
        this.zzBZ = z2;
    }

    @Override // com.google.android.gms.internal.zzfy.zza
    /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public com.google.android.gms.ads.internal.formats.zzd zza(zzfy zzfyVar, JSONObject jSONObject) throws JSONException, InterruptedException, ExecutionException {
        List<zzhv<com.google.android.gms.ads.internal.formats.zzc>> zza = zzfyVar.zza(jSONObject, "images", true, this.zzBY, this.zzBZ);
        zzhv<com.google.android.gms.ads.internal.formats.zzc> zza2 = zzfyVar.zza(jSONObject, "app_icon", true, this.zzBY);
        zzhv<com.google.android.gms.ads.internal.formats.zza> zze = zzfyVar.zze(jSONObject);
        ArrayList arrayList = new ArrayList();
        Iterator<zzhv<com.google.android.gms.ads.internal.formats.zzc>> it = zza.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().get());
        }
        return new com.google.android.gms.ads.internal.formats.zzd(jSONObject.getString("headline"), arrayList, jSONObject.getString("body"), zza2.get(), jSONObject.getString("call_to_action"), jSONObject.optDouble("rating", -1.0d), jSONObject.optString("store"), jSONObject.optString("price"), zze.get());
    }
}
