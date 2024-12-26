package com.google.android.gms.tagmanager;

import android.util.Base64;
import com.google.android.gms.internal.zzag;
import java.util.Map;

/* loaded from: classes.dex */
class zzad extends zzak {
    private static final String ID = com.google.android.gms.internal.zzad.ENCODE.toString();
    private static final String zzaLE = com.google.android.gms.internal.zzae.ARG0.toString();
    private static final String zzaLF = com.google.android.gms.internal.zzae.NO_PADDING.toString();
    private static final String zzaLG = com.google.android.gms.internal.zzae.INPUT_FORMAT.toString();
    private static final String zzaLH = com.google.android.gms.internal.zzae.OUTPUT_FORMAT.toString();

    public zzad() {
        super(ID, zzaLE);
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public zzag.zza zzE(Map<String, zzag.zza> map) {
        String str;
        byte[] decode;
        String encodeToString;
        zzag.zza zzaVar = map.get(zzaLE);
        if (zzaVar == null || zzaVar == zzdf.zzzQ()) {
            return zzdf.zzzQ();
        }
        String zzg = zzdf.zzg(zzaVar);
        zzag.zza zzaVar2 = map.get(zzaLG);
        String zzg2 = zzaVar2 == null ? "text" : zzdf.zzg(zzaVar2);
        zzag.zza zzaVar3 = map.get(zzaLH);
        String zzg3 = zzaVar3 == null ? "base16" : zzdf.zzg(zzaVar3);
        zzag.zza zzaVar4 = map.get(zzaLF);
        int i = (zzaVar4 == null || !zzdf.zzk(zzaVar4).booleanValue()) ? 2 : 3;
        try {
            if ("text".equals(zzg2)) {
                decode = zzg.getBytes();
            } else if ("base16".equals(zzg2)) {
                decode = zzk.zzee(zzg);
            } else if ("base64".equals(zzg2)) {
                decode = Base64.decode(zzg, i);
            } else {
                if (!"base64url".equals(zzg2)) {
                    zzbg.zzaz("Encode: unknown input format: " + zzg2);
                    return zzdf.zzzQ();
                }
                decode = Base64.decode(zzg, i | 8);
            }
        } catch (IllegalArgumentException e) {
            str = "Encode: invalid input:";
        }
        if ("base16".equals(zzg3)) {
            encodeToString = zzk.zzi(decode);
        } else {
            if (!"base64".equals(zzg3)) {
                if (!"base64url".equals(zzg3)) {
                    str = "Encode: unknown output format: " + zzg3;
                    zzbg.zzaz(str);
                    return zzdf.zzzQ();
                }
                i |= 8;
            }
            encodeToString = Base64.encodeToString(decode, i);
        }
        return zzdf.zzI(encodeToString);
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public boolean zzyh() {
        return true;
    }
}
