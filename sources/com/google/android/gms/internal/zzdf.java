package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzgd
/* loaded from: classes.dex */
public final class zzdf {
    public static final zzdg zzvV = new zzdg() { // from class: com.google.android.gms.internal.zzdf.1
        @Override // com.google.android.gms.internal.zzdg
        public void zza(zzid zzidVar, Map<String, String> map) {
        }
    };
    public static final zzdg zzvW = new zzdg() { // from class: com.google.android.gms.internal.zzdf.2
        @Override // com.google.android.gms.internal.zzdg
        public void zza(zzid zzidVar, Map<String, String> map) {
            String str = map.get("urls");
            if (TextUtils.isEmpty(str)) {
                com.google.android.gms.ads.internal.util.client.zzb.zzaC("URLs missing in canOpenURLs GMSG.");
                return;
            }
            String[] split = str.split(",");
            HashMap hashMap = new HashMap();
            PackageManager packageManager = zzidVar.getContext().getPackageManager();
            for (String str2 : split) {
                String[] split2 = str2.split(";", 2);
                boolean z = true;
                if (packageManager.resolveActivity(new Intent(split2.length > 1 ? split2[1].trim() : "android.intent.action.VIEW", Uri.parse(split2[0].trim())), 65536) == null) {
                    z = false;
                }
                hashMap.put(str2, Boolean.valueOf(z));
            }
            zzidVar.zzc("openableURLs", hashMap);
        }
    };
    public static final zzdg zzvX = new zzdg() { // from class: com.google.android.gms.internal.zzdf.3
        @Override // com.google.android.gms.internal.zzdg
        public void zza(zzid zzidVar, Map<String, String> map) {
            JSONObject jSONObject;
            String str;
            String optString;
            Intent intent;
            PackageManager packageManager = zzidVar.getContext().getPackageManager();
            try {
            } catch (JSONException e) {
                jSONObject = new JSONObject();
            }
            try {
                JSONArray jSONArray = new JSONObject(map.get("data")).getJSONArray("intents");
                JSONObject jSONObject2 = new JSONObject();
                for (int i = 0; i < jSONArray.length(); i++) {
                    try {
                        JSONObject jSONObject3 = jSONArray.getJSONObject(i);
                        optString = jSONObject3.optString("id");
                        String optString2 = jSONObject3.optString("u");
                        String optString3 = jSONObject3.optString("i");
                        String optString4 = jSONObject3.optString("m");
                        String optString5 = jSONObject3.optString("p");
                        String optString6 = jSONObject3.optString("c");
                        jSONObject3.optString("f");
                        jSONObject3.optString("e");
                        intent = new Intent();
                        if (!TextUtils.isEmpty(optString2)) {
                            intent.setData(Uri.parse(optString2));
                        }
                        if (!TextUtils.isEmpty(optString3)) {
                            intent.setAction(optString3);
                        }
                        if (!TextUtils.isEmpty(optString4)) {
                            intent.setType(optString4);
                        }
                        if (!TextUtils.isEmpty(optString5)) {
                            intent.setPackage(optString5);
                        }
                        if (!TextUtils.isEmpty(optString6)) {
                            String[] split = optString6.split("/", 2);
                            if (split.length == 2) {
                                intent.setComponent(new ComponentName(split[0], split[1]));
                            }
                        }
                    } catch (JSONException e2) {
                        e = e2;
                        str = "Error parsing the intent data.";
                    }
                    try {
                        jSONObject2.put(optString, packageManager.resolveActivity(intent, 65536) != null);
                    } catch (JSONException e3) {
                        e = e3;
                        str = "Error constructing openable urls response.";
                        com.google.android.gms.ads.internal.util.client.zzb.zzb(str, e);
                    }
                }
                zzidVar.zzb("openableIntents", jSONObject2);
            } catch (JSONException e4) {
                jSONObject = new JSONObject();
                zzidVar.zzb("openableIntents", jSONObject);
            }
        }
    };
    public static final zzdg zzvY = new zzdg() { // from class: com.google.android.gms.internal.zzdf.4
        @Override // com.google.android.gms.internal.zzdg
        public void zza(zzid zzidVar, Map<String, String> map) {
            String str = map.get("u");
            if (str == null) {
                com.google.android.gms.ads.internal.util.client.zzb.zzaC("URL missing from click GMSG.");
                return;
            }
            Uri parse = Uri.parse(str);
            try {
                zzan zzgH = zzidVar.zzgH();
                if (zzgH != null && zzgH.zzb(parse)) {
                    parse = zzgH.zza(parse, zzidVar.getContext());
                }
            } catch (zzao e) {
                com.google.android.gms.ads.internal.util.client.zzb.zzaC("Unable to append parameter to URL: " + str);
            }
            new zzhp(zzidVar.getContext(), zzidVar.zzgI().zzGG, parse.toString()).zzgi();
        }
    };
    public static final zzdg zzvZ = new zzdg() { // from class: com.google.android.gms.internal.zzdf.5
        @Override // com.google.android.gms.internal.zzdg
        public void zza(zzid zzidVar, Map<String, String> map) {
            com.google.android.gms.ads.internal.overlay.zzc zzgD = zzidVar.zzgD();
            if (zzgD != null) {
                zzgD.close();
                return;
            }
            com.google.android.gms.ads.internal.overlay.zzc zzgE = zzidVar.zzgE();
            if (zzgE != null) {
                zzgE.close();
            } else {
                com.google.android.gms.ads.internal.util.client.zzb.zzaC("A GMSG tried to close something that wasn't an overlay.");
            }
        }
    };
    public static final zzdg zzwa = new zzdg() { // from class: com.google.android.gms.internal.zzdf.6
        @Override // com.google.android.gms.internal.zzdg
        public void zza(zzid zzidVar, Map<String, String> map) {
            zzidVar.zzC("1".equals(map.get("custom_close")));
        }
    };
    public static final zzdg zzwb = new zzdg() { // from class: com.google.android.gms.internal.zzdf.7
        @Override // com.google.android.gms.internal.zzdg
        public void zza(zzid zzidVar, Map<String, String> map) {
            String str = map.get("u");
            if (str == null) {
                com.google.android.gms.ads.internal.util.client.zzb.zzaC("URL missing from httpTrack GMSG.");
            } else {
                new zzhp(zzidVar.getContext(), zzidVar.zzgI().zzGG, str).zzgi();
            }
        }
    };
    public static final zzdg zzwc = new zzdg() { // from class: com.google.android.gms.internal.zzdf.8
        @Override // com.google.android.gms.internal.zzdg
        public void zza(zzid zzidVar, Map<String, String> map) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaA("Received log message: " + map.get("string"));
        }
    };
    public static final zzdg zzwd = new zzdg() { // from class: com.google.android.gms.internal.zzdf.9
        @Override // com.google.android.gms.internal.zzdg
        public void zza(zzid zzidVar, Map<String, String> map) {
            String str = map.get("tx");
            String str2 = map.get("ty");
            String str3 = map.get("td");
            try {
                int parseInt = Integer.parseInt(str);
                int parseInt2 = Integer.parseInt(str2);
                int parseInt3 = Integer.parseInt(str3);
                zzan zzgH = zzidVar.zzgH();
                if (zzgH != null) {
                    zzgH.zzab().zza(parseInt, parseInt2, parseInt3);
                }
            } catch (NumberFormatException e) {
                com.google.android.gms.ads.internal.util.client.zzb.zzaC("Could not parse touch parameters from gmsg.");
            }
        }
    };
    public static final zzdg zzwe = new zzdo();
    public static final zzdg zzwf = new zzds();
}
