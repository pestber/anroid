package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzag;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class zzdf {
    private static final Object zzaOt = null;
    private static Long zzaOu = new Long(0);
    private static Double zzaOv = new Double(0.0d);
    private static zzde zzaOw = zzde.zzT(0);
    private static String zzaOx = new String("");
    private static Boolean zzaOy = new Boolean(false);
    private static List<Object> zzaOz = new ArrayList(0);
    private static Map<Object, Object> zzaOA = new HashMap();
    private static zzag.zza zzaOB = zzI(zzaOx);

    private static double getDouble(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).doubleValue();
        }
        zzbg.zzaz("getDouble received non-Number");
        return 0.0d;
    }

    public static String zzD(Object obj) {
        return obj == null ? zzaOx : obj.toString();
    }

    public static zzde zzE(Object obj) {
        return obj instanceof zzde ? (zzde) obj : zzK(obj) ? zzde.zzT(zzL(obj)) : zzJ(obj) ? zzde.zza(Double.valueOf(getDouble(obj))) : zzeK(zzD(obj));
    }

    public static Long zzF(Object obj) {
        return zzK(obj) ? Long.valueOf(zzL(obj)) : zzeL(zzD(obj));
    }

    public static Double zzG(Object obj) {
        return zzJ(obj) ? Double.valueOf(getDouble(obj)) : zzeM(zzD(obj));
    }

    public static Boolean zzH(Object obj) {
        return obj instanceof Boolean ? (Boolean) obj : zzeN(zzD(obj));
    }

    public static zzag.zza zzI(Object obj) {
        String obj2;
        zzag.zza zzaVar = new zzag.zza();
        if (obj instanceof zzag.zza) {
            return (zzag.zza) obj;
        }
        boolean z = false;
        if (!(obj instanceof String)) {
            if (obj instanceof List) {
                zzaVar.type = 2;
                List list = (List) obj;
                ArrayList arrayList = new ArrayList(list.size());
                Iterator it = list.iterator();
                boolean z2 = false;
                while (it.hasNext()) {
                    zzag.zza zzI = zzI(it.next());
                    if (zzI == zzaOB) {
                        return zzaOB;
                    }
                    z2 = z2 || zzI.zzjb;
                    arrayList.add(zzI);
                }
                zzaVar.zziS = (zzag.zza[]) arrayList.toArray(new zzag.zza[0]);
                z = z2;
            } else if (obj instanceof Map) {
                zzaVar.type = 3;
                Set<Map.Entry> entrySet = ((Map) obj).entrySet();
                ArrayList arrayList2 = new ArrayList(entrySet.size());
                ArrayList arrayList3 = new ArrayList(entrySet.size());
                boolean z3 = false;
                for (Map.Entry entry : entrySet) {
                    zzag.zza zzI2 = zzI(entry.getKey());
                    zzag.zza zzI3 = zzI(entry.getValue());
                    if (zzI2 == zzaOB || zzI3 == zzaOB) {
                        return zzaOB;
                    }
                    z3 = z3 || zzI2.zzjb || zzI3.zzjb;
                    arrayList2.add(zzI2);
                    arrayList3.add(zzI3);
                }
                zzaVar.zziT = (zzag.zza[]) arrayList2.toArray(new zzag.zza[0]);
                zzaVar.zziU = (zzag.zza[]) arrayList3.toArray(new zzag.zza[0]);
                z = z3;
            } else if (zzJ(obj)) {
                zzaVar.type = 1;
                obj2 = obj.toString();
            } else if (zzK(obj)) {
                zzaVar.type = 6;
                zzaVar.zziX = zzL(obj);
            } else {
                if (!(obj instanceof Boolean)) {
                    zzbg.zzaz("Converting to Value from unknown object type: " + (obj == null ? "null" : obj.getClass().toString()));
                    return zzaOB;
                }
                zzaVar.type = 8;
                zzaVar.zziY = ((Boolean) obj).booleanValue();
            }
            zzaVar.zzjb = z;
            return zzaVar;
        }
        zzaVar.type = 1;
        obj2 = (String) obj;
        zzaVar.zziR = obj2;
        zzaVar.zzjb = z;
        return zzaVar;
    }

    private static boolean zzJ(Object obj) {
        return (obj instanceof Double) || (obj instanceof Float) || ((obj instanceof zzde) && ((zzde) obj).zzzF());
    }

    private static boolean zzK(Object obj) {
        return (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long) || ((obj instanceof zzde) && ((zzde) obj).zzzG());
    }

    private static long zzL(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).longValue();
        }
        zzbg.zzaz("getInt64 received non-Number");
        return 0L;
    }

    public static zzag.zza zzeJ(String str) {
        zzag.zza zzaVar = new zzag.zza();
        zzaVar.type = 5;
        zzaVar.zziW = str;
        return zzaVar;
    }

    private static zzde zzeK(String str) {
        try {
            return zzde.zzeI(str);
        } catch (NumberFormatException e) {
            zzbg.zzaz("Failed to convert '" + str + "' to a number.");
            return zzaOw;
        }
    }

    private static Long zzeL(String str) {
        zzde zzeK = zzeK(str);
        return zzeK == zzaOw ? zzaOu : Long.valueOf(zzeK.longValue());
    }

    private static Double zzeM(String str) {
        zzde zzeK = zzeK(str);
        return zzeK == zzaOw ? zzaOv : Double.valueOf(zzeK.doubleValue());
    }

    private static Boolean zzeN(String str) {
        return "true".equalsIgnoreCase(str) ? Boolean.TRUE : "false".equalsIgnoreCase(str) ? Boolean.FALSE : zzaOy;
    }

    public static String zzg(zzag.zza zzaVar) {
        return zzD(zzl(zzaVar));
    }

    public static zzde zzh(zzag.zza zzaVar) {
        return zzE(zzl(zzaVar));
    }

    public static Long zzi(zzag.zza zzaVar) {
        return zzF(zzl(zzaVar));
    }

    public static Double zzj(zzag.zza zzaVar) {
        return zzG(zzl(zzaVar));
    }

    public static Boolean zzk(zzag.zza zzaVar) {
        return zzH(zzl(zzaVar));
    }

    public static Object zzl(zzag.zza zzaVar) {
        if (zzaVar == null) {
            return zzaOt;
        }
        int i = 0;
        switch (zzaVar.type) {
            case 1:
                break;
            case 2:
                ArrayList arrayList = new ArrayList(zzaVar.zziS.length);
                zzag.zza[] zzaVarArr = zzaVar.zziS;
                int length = zzaVarArr.length;
                while (i < length) {
                    Object zzl = zzl(zzaVarArr[i]);
                    if (zzl == zzaOt) {
                        break;
                    } else {
                        arrayList.add(zzl);
                        i++;
                    }
                }
                break;
            case 3:
                if (zzaVar.zziT.length == zzaVar.zziU.length) {
                    HashMap hashMap = new HashMap(zzaVar.zziU.length);
                    while (i < zzaVar.zziT.length) {
                        Object zzl2 = zzl(zzaVar.zziT[i]);
                        Object zzl3 = zzl(zzaVar.zziU[i]);
                        if (zzl2 == zzaOt || zzl3 == zzaOt) {
                            break;
                        } else {
                            hashMap.put(zzl2, zzl3);
                            i++;
                        }
                    }
                    break;
                } else {
                    zzbg.zzaz("Converting an invalid value to object: " + zzaVar.toString());
                    break;
                }
                break;
            case 4:
                zzbg.zzaz("Trying to convert a macro reference to object");
                break;
            case 5:
                zzbg.zzaz("Trying to convert a function id to object");
                break;
            case 6:
                break;
            case 7:
                StringBuffer stringBuffer = new StringBuffer();
                zzag.zza[] zzaVarArr2 = zzaVar.zziZ;
                int length2 = zzaVarArr2.length;
                while (i < length2) {
                    String zzg = zzg(zzaVarArr2[i]);
                    if (zzg == zzaOx) {
                        break;
                    } else {
                        stringBuffer.append(zzg);
                        i++;
                    }
                }
                break;
            case 8:
                break;
            default:
                zzbg.zzaz("Failed to convert a value of type: " + zzaVar.type);
                break;
        }
        return zzaOt;
    }

    public static Object zzzK() {
        return zzaOt;
    }

    public static Long zzzL() {
        return zzaOu;
    }

    public static Double zzzM() {
        return zzaOv;
    }

    public static Boolean zzzN() {
        return zzaOy;
    }

    public static zzde zzzO() {
        return zzaOw;
    }

    public static String zzzP() {
        return zzaOx;
    }

    public static zzag.zza zzzQ() {
        return zzaOB;
    }
}
