package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.internal.zzag;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
class zzj extends zzdd {
    private static final String ID = com.google.android.gms.internal.zzad.ARBITRARY_PIXEL.toString();
    private static final String URL = com.google.android.gms.internal.zzae.URL.toString();
    private static final String zzaKr = com.google.android.gms.internal.zzae.ADDITIONAL_PARAMS.toString();
    private static final String zzaKs = com.google.android.gms.internal.zzae.UNREPEATABLE.toString();
    static final String zzaKt = "gtm_" + ID + "_unrepeatable";
    private static final Set<String> zzaKu = new HashSet();
    private final Context mContext;
    private final zza zzaKv;

    public interface zza {
        zzar zzyi();
    }

    public zzj(final Context context) {
        this(context, new zza() { // from class: com.google.android.gms.tagmanager.zzj.1
            @Override // com.google.android.gms.tagmanager.zzj.zza
            public zzar zzyi() {
                return zzz.zzaF(context);
            }
        });
    }

    zzj(Context context, zza zzaVar) {
        super(ID, URL);
        this.zzaKv = zzaVar;
        this.mContext = context;
    }

    private synchronized boolean zzeb(String str) {
        if (zzed(str)) {
            return true;
        }
        if (!zzec(str)) {
            return false;
        }
        zzaKu.add(str);
        return true;
    }

    @Override // com.google.android.gms.tagmanager.zzdd
    public void zzG(Map<String, zzag.zza> map) {
        StringBuilder sb;
        String str;
        String zzg = map.get(zzaKs) != null ? zzdf.zzg(map.get(zzaKs)) : null;
        if (zzg == null || !zzeb(zzg)) {
            Uri.Builder buildUpon = Uri.parse(zzdf.zzg(map.get(URL))).buildUpon();
            zzag.zza zzaVar = map.get(zzaKr);
            if (zzaVar != null) {
                Object zzl = zzdf.zzl(zzaVar);
                if (zzl instanceof List) {
                    for (Object obj : (List) zzl) {
                        if (obj instanceof Map) {
                            for (Map.Entry entry : ((Map) obj).entrySet()) {
                                buildUpon.appendQueryParameter(entry.getKey().toString(), entry.getValue().toString());
                            }
                        } else {
                            sb = new StringBuilder();
                            str = "ArbitraryPixel: additional params contains non-map: not sending partial hit: ";
                        }
                    }
                } else {
                    sb = new StringBuilder();
                    str = "ArbitraryPixel: additional params not a list: not sending partial hit: ";
                }
                zzbg.zzaz(sb.append(str).append(buildUpon.build().toString()).toString());
                return;
            }
            String uri = buildUpon.build().toString();
            this.zzaKv.zzyi().zzes(uri);
            zzbg.zzaB("ArbitraryPixel: url = " + uri);
            if (zzg != null) {
                synchronized (zzj.class) {
                    zzaKu.add(zzg);
                    zzcv.zza(this.mContext, zzaKt, zzg, "true");
                }
            }
        }
    }

    boolean zzec(String str) {
        return this.mContext.getSharedPreferences(zzaKt, 0).contains(str);
    }

    boolean zzed(String str) {
        return zzaKu.contains(str);
    }
}
