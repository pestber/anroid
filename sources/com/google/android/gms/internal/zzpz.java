package com.google.android.gms.internal;

import com.google.android.gms.internal.zzag;
import com.google.android.gms.internal.zzqf;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
final class zzpz {
    static zzag.zza zza(int i, JSONArray jSONArray, zzag.zza[] zzaVarArr, Set<Integer> set) throws zzqf.zzg, JSONException {
        int i2;
        if (set.contains(Integer.valueOf(i))) {
            zzeT("Value cycle detected. Current value reference: " + i + ".  Previous value references: " + set + ".");
        }
        Object zza = zza(jSONArray, i, "values");
        if (zzaVarArr[i] != null) {
            return zzaVarArr[i];
        }
        set.add(Integer.valueOf(i));
        zzag.zza zzaVar = new zzag.zza();
        int i3 = 0;
        if (zza instanceof JSONArray) {
            JSONArray jSONArray2 = (JSONArray) zza;
            zzaVar.type = 2;
            zzaVar.zzjb = true;
            zzaVar.zziS = new zzag.zza[jSONArray2.length()];
            while (i3 < zzaVar.zziS.length) {
                zzaVar.zziS[i3] = zza(jSONArray2.getInt(i3), jSONArray, zzaVarArr, set);
                i3++;
            }
        } else if (zza instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) zza;
            JSONArray optJSONArray = jSONObject.optJSONArray("escaping");
            if (optJSONArray != null) {
                zzaVar.zzja = new int[optJSONArray.length()];
                for (int i4 = 0; i4 < zzaVar.zzja.length; i4++) {
                    zzaVar.zzja[i4] = optJSONArray.getInt(i4);
                }
            }
            if (jSONObject.has("function_id")) {
                zzaVar.type = 5;
                zzaVar.zziW = jSONObject.getString("function_id");
            } else if (jSONObject.has("macro_reference")) {
                zzaVar.type = 4;
                zzaVar.zzjb = true;
                zzaVar.zziV = com.google.android.gms.tagmanager.zzdf.zzg(zza(jSONObject.getInt("macro_reference"), jSONArray, zzaVarArr, set));
            } else if (jSONObject.has("template_token")) {
                zzaVar.type = 7;
                zzaVar.zzjb = true;
                JSONArray jSONArray3 = jSONObject.getJSONArray("template_token");
                zzaVar.zziZ = new zzag.zza[jSONArray3.length()];
                while (i3 < zzaVar.zziZ.length) {
                    zzaVar.zziZ[i3] = zza(jSONArray3.getInt(i3), jSONArray, zzaVarArr, set);
                    i3++;
                }
            } else {
                zzaVar.type = 3;
                zzaVar.zzjb = true;
                int length = jSONObject.length();
                zzaVar.zziT = new zzag.zza[length];
                zzaVar.zziU = new zzag.zza[length];
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    zzaVar.zziT[i3] = zza(new Integer(next).intValue(), jSONArray, zzaVarArr, set);
                    zzaVar.zziU[i3] = zza(jSONObject.getInt(next), jSONArray, zzaVarArr, set);
                    i3++;
                }
            }
        } else if (zza instanceof String) {
            zzaVar.zziR = (String) zza;
            zzaVar.type = 1;
        } else {
            if (zza instanceof Boolean) {
                zzaVar.zziY = ((Boolean) zza).booleanValue();
                i2 = 8;
            } else if (zza instanceof Integer) {
                zzaVar.zziX = ((Integer) zza).intValue();
                i2 = 6;
            } else {
                zzeT("Invalid value type: " + zza);
            }
            zzaVar.type = i2;
        }
        zzaVarArr[i] = zzaVar;
        set.remove(Integer.valueOf(i));
        return zzaVar;
    }

    static zzqf.zza zza(JSONObject jSONObject, JSONArray jSONArray, JSONArray jSONArray2, zzag.zza[] zzaVarArr, int i) throws zzqf.zzg, JSONException {
        zzqf.zzb zzAm = zzqf.zza.zzAm();
        JSONArray jSONArray3 = jSONObject.getJSONArray("property");
        for (int i2 = 0; i2 < jSONArray3.length(); i2++) {
            JSONObject jSONObject2 = (JSONObject) zza(jSONArray, jSONArray3.getInt(i2), "properties");
            String str = (String) zza(jSONArray2, jSONObject2.getInt("key"), "key");
            zzag.zza zzaVar = (zzag.zza) zza(zzaVarArr, jSONObject2.getInt("value"), "value");
            if (zzae.PUSH_AFTER_EVALUATE.toString().equals(str)) {
                zzAm.zzq(zzaVar);
            } else {
                zzAm.zzb(str, zzaVar);
            }
        }
        return zzAm.zzAo();
    }

    static zzqf.zze zza(JSONObject jSONObject, List<zzqf.zza> list, List<zzqf.zza> list2, List<zzqf.zza> list3, zzag.zza[] zzaVarArr) throws JSONException {
        zzqf.zzf zzAt = zzqf.zze.zzAt();
        JSONArray optJSONArray = jSONObject.optJSONArray("positive_predicate");
        JSONArray optJSONArray2 = jSONObject.optJSONArray("negative_predicate");
        JSONArray optJSONArray3 = jSONObject.optJSONArray("add_tag");
        JSONArray optJSONArray4 = jSONObject.optJSONArray("remove_tag");
        JSONArray optJSONArray5 = jSONObject.optJSONArray("add_tag_rule_name");
        JSONArray optJSONArray6 = jSONObject.optJSONArray("remove_tag_rule_name");
        JSONArray optJSONArray7 = jSONObject.optJSONArray("add_macro");
        JSONArray optJSONArray8 = jSONObject.optJSONArray("remove_macro");
        JSONArray optJSONArray9 = jSONObject.optJSONArray("add_macro_rule_name");
        JSONArray optJSONArray10 = jSONObject.optJSONArray("remove_macro_rule_name");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                zzAt.zzd(list3.get(optJSONArray.getInt(i)));
            }
        }
        if (optJSONArray2 != null) {
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                zzAt.zze(list3.get(optJSONArray2.getInt(i2)));
            }
        }
        if (optJSONArray3 != null) {
            for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                zzAt.zzf(list.get(optJSONArray3.getInt(i3)));
            }
        }
        if (optJSONArray4 != null) {
            for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                zzAt.zzg(list.get(optJSONArray4.getInt(i4)));
            }
        }
        if (optJSONArray5 != null) {
            for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                zzAt.zzeW(zzaVarArr[optJSONArray5.getInt(i5)].zziR);
            }
        }
        if (optJSONArray6 != null) {
            for (int i6 = 0; i6 < optJSONArray6.length(); i6++) {
                zzAt.zzeX(zzaVarArr[optJSONArray6.getInt(i6)].zziR);
            }
        }
        if (optJSONArray7 != null) {
            for (int i7 = 0; i7 < optJSONArray7.length(); i7++) {
                zzAt.zzh(list2.get(optJSONArray7.getInt(i7)));
            }
        }
        if (optJSONArray8 != null) {
            for (int i8 = 0; i8 < optJSONArray8.length(); i8++) {
                zzAt.zzi(list2.get(optJSONArray8.getInt(i8)));
            }
        }
        if (optJSONArray9 != null) {
            for (int i9 = 0; i9 < optJSONArray9.length(); i9++) {
                zzAt.zzeY(zzaVarArr[optJSONArray9.getInt(i9)].zziR);
            }
        }
        if (optJSONArray10 != null) {
            for (int i10 = 0; i10 < optJSONArray10.length(); i10++) {
                zzAt.zzeZ(zzaVarArr[optJSONArray10.getInt(i10)].zziR);
            }
        }
        return zzAt.zzAE();
    }

    private static <T> T zza(JSONArray jSONArray, int i, String str) throws zzqf.zzg {
        if (i >= 0 && i < jSONArray.length()) {
            try {
                return (T) jSONArray.get(i);
            } catch (JSONException e) {
            }
        }
        zzeT("Index out of bounds detected: " + i + " in " + str);
        return null;
    }

    private static <T> T zza(T[] tArr, int i, String str) throws zzqf.zzg {
        if (i < 0 || i >= tArr.length) {
            zzeT("Index out of bounds detected: " + i + " in " + str);
        }
        return tArr[i];
    }

    static List<zzqf.zza> zza(JSONArray jSONArray, JSONArray jSONArray2, JSONArray jSONArray3, zzag.zza[] zzaVarArr) throws JSONException, zzqf.zzg {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(zza(jSONArray.getJSONObject(i), jSONArray2, jSONArray3, zzaVarArr, i));
        }
        return arrayList;
    }

    private static void zzeT(String str) throws zzqf.zzg {
        com.google.android.gms.tagmanager.zzbg.zzaz(str);
        throw new zzqf.zzg(str);
    }

    static zzqf.zzc zzey(String str) throws JSONException, zzqf.zzg {
        JSONObject jSONObject = new JSONObject(str);
        Object obj = jSONObject.get("resource");
        if (!(obj instanceof JSONObject)) {
            throw new zzqf.zzg("Resource map not found");
        }
        JSONObject jSONObject2 = (JSONObject) obj;
        zzqf.zzd zzAp = zzqf.zzc.zzAp();
        zzag.zza[] zzj = zzj(jSONObject2);
        JSONArray jSONArray = jSONObject2.getJSONArray("properties");
        JSONArray jSONArray2 = jSONObject2.getJSONArray("key");
        List<zzqf.zza> zza = zza(jSONObject2.getJSONArray("tags"), jSONArray, jSONArray2, zzj);
        List<zzqf.zza> zza2 = zza(jSONObject2.getJSONArray("predicates"), jSONArray, jSONArray2, zzj);
        List<zzqf.zza> zza3 = zza(jSONObject2.getJSONArray("macros"), jSONArray, jSONArray2, zzj);
        Iterator<zzqf.zza> it = zza3.iterator();
        while (it.hasNext()) {
            zzAp.zzc(it.next());
        }
        JSONArray jSONArray3 = jSONObject2.getJSONArray("rules");
        for (int i = 0; i < jSONArray3.length(); i++) {
            zzAp.zzb(zza(jSONArray3.getJSONObject(i), zza, zza3, zza2, zzj));
        }
        zzAp.zzeV("1");
        zzAp.zzjb(1);
        jSONObject.optJSONArray("runtime");
        return zzAp.zzAs();
    }

    static zzag.zza[] zzj(JSONObject jSONObject) throws JSONException, zzqf.zzg {
        Object opt = jSONObject.opt("values");
        if (!(opt instanceof JSONArray)) {
            throw new zzqf.zzg("Missing Values list");
        }
        JSONArray jSONArray = (JSONArray) opt;
        int length = jSONArray.length();
        zzag.zza[] zzaVarArr = new zzag.zza[length];
        for (int i = 0; i < length; i++) {
            zza(i, jSONArray, zzaVarArr, new HashSet(0));
        }
        return zzaVarArr;
    }
}
