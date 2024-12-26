package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzag;
import com.google.android.gms.plus.PlusShare;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
class zzay extends zzak {
    private static final String ID = com.google.android.gms.internal.zzad.JOINER.toString();
    private static final String zzaLE = com.google.android.gms.internal.zzae.ARG0.toString();
    private static final String zzaLW = com.google.android.gms.internal.zzae.ITEM_SEPARATOR.toString();
    private static final String zzaLX = com.google.android.gms.internal.zzae.KEY_VALUE_SEPARATOR.toString();
    private static final String zzaLY = com.google.android.gms.internal.zzae.ESCAPE.toString();

    private enum zza {
        NONE,
        URL,
        BACKSLASH
    }

    public zzay() {
        super(ID, zzaLE);
    }

    private String zza(String str, zza zzaVar, Set<Character> set) {
        switch (zzaVar) {
            case URL:
                try {
                    return zzdj.zzeQ(str);
                } catch (UnsupportedEncodingException e) {
                    zzbg.zzb("Joiner: unsupported encoding", e);
                    return str;
                }
            case BACKSLASH:
                String replace = str.replace("\\", "\\\\");
                Iterator<Character> it = set.iterator();
                while (it.hasNext()) {
                    String ch = it.next().toString();
                    replace = replace.replace(ch, "\\" + ch);
                }
                return replace;
            default:
                return str;
        }
    }

    private void zza(StringBuilder sb, String str, zza zzaVar, Set<Character> set) {
        sb.append(zza(str, zzaVar, set));
    }

    private void zza(Set<Character> set, String str) {
        for (int i = 0; i < str.length(); i++) {
            set.add(Character.valueOf(str.charAt(i)));
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.tagmanager.zzak
    public zzag.zza zzE(Map<String, zzag.zza> map) {
        zzag.zza zzaVar = map.get(zzaLE);
        if (zzaVar == null) {
            return zzdf.zzzQ();
        }
        zzag.zza zzaVar2 = map.get(zzaLW);
        String zzg = zzaVar2 != null ? zzdf.zzg(zzaVar2) : "";
        zzag.zza zzaVar3 = map.get(zzaLX);
        String zzg2 = zzaVar3 != null ? zzdf.zzg(zzaVar3) : "=";
        zza zzaVar4 = zza.NONE;
        zzag.zza zzaVar5 = map.get(zzaLY);
        HashSet hashSet = null;
        if (zzaVar5 != null) {
            String zzg3 = zzdf.zzg(zzaVar5);
            if (PlusShare.KEY_CALL_TO_ACTION_URL.equals(zzg3)) {
                zzaVar4 = zza.URL;
            } else {
                if (!"backslash".equals(zzg3)) {
                    zzbg.zzaz("Joiner: unsupported escape type: " + zzg3);
                    return zzdf.zzzQ();
                }
                zzaVar4 = zza.BACKSLASH;
                hashSet = new HashSet();
                zza(hashSet, zzg);
                zza(hashSet, zzg2);
                hashSet.remove('\\');
            }
        }
        StringBuilder sb = new StringBuilder();
        switch (zzaVar.type) {
            case 2:
                zzag.zza[] zzaVarArr = zzaVar.zziS;
                int length = zzaVarArr.length;
                boolean z = true;
                int i = 0;
                while (i < length) {
                    zzag.zza zzaVar6 = zzaVarArr[i];
                    if (!z) {
                        sb.append(zzg);
                    }
                    zza(sb, zzdf.zzg(zzaVar6), zzaVar4, hashSet);
                    i++;
                    z = false;
                }
                break;
            case 3:
                for (int i2 = 0; i2 < zzaVar.zziT.length; i2++) {
                    if (i2 > 0) {
                        sb.append(zzg);
                    }
                    String zzg4 = zzdf.zzg(zzaVar.zziT[i2]);
                    String zzg5 = zzdf.zzg(zzaVar.zziU[i2]);
                    zza(sb, zzg4, zzaVar4, hashSet);
                    sb.append(zzg2);
                    zza(sb, zzg5, zzaVar4, hashSet);
                }
                break;
            default:
                zza(sb, zzdf.zzg(zzaVar), zzaVar4, hashSet);
                break;
        }
        return zzdf.zzI(sb.toString());
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public boolean zzyh() {
        return true;
    }
}
