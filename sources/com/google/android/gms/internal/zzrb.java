package com.google.android.gms.internal;

import com.google.android.gms.internal.zzrc;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public final class zzrb {

    public static class zza {
        public final zzrc zzaVj;
        public final List<Asset> zzaVk;

        public zza(zzrc zzrcVar, List<Asset> list) {
            this.zzaVj = zzrcVar;
            this.zzaVk = list;
        }
    }

    private static int zza(String str, zzrc.zza.C0166zza[] c0166zzaArr) {
        int i = 14;
        for (zzrc.zza.C0166zza c0166zza : c0166zzaArr) {
            int i2 = c0166zza.type;
            if (i != 14) {
                if (i2 != i) {
                    throw new IllegalArgumentException("The ArrayList elements should all be the same type, but ArrayList with key " + str + " contains items of type " + i + " and " + c0166zza.type);
                }
            } else if (i2 == 9 || c0166zza.type == 2 || c0166zza.type == 6) {
                i = c0166zza.type;
            } else if (c0166zza.type != 14) {
                throw new IllegalArgumentException("Unexpected TypedValue type: " + c0166zza.type + " for key " + str);
            }
        }
        return i;
    }

    static int zza(List<Asset> list, Asset asset) {
        list.add(asset);
        return list.size() - 1;
    }

    public static zza zza(DataMap dataMap) {
        zzrc zzrcVar = new zzrc();
        ArrayList arrayList = new ArrayList();
        zzrcVar.zzaVl = zza(dataMap, arrayList);
        return new zza(zzrcVar, arrayList);
    }

    private static zzrc.zza.C0166zza zza(List<Asset> list, Object obj) {
        zzrc.zza.C0166zza c0166zza = new zzrc.zza.C0166zza();
        if (obj == null) {
            c0166zza.type = 14;
            return c0166zza;
        }
        c0166zza.zzaVp = new zzrc.zza.C0166zza.C0167zza();
        if (obj instanceof String) {
            c0166zza.type = 2;
            c0166zza.zzaVp.zzaVr = (String) obj;
        } else if (obj instanceof Integer) {
            c0166zza.type = 6;
            c0166zza.zzaVp.zzaVv = ((Integer) obj).intValue();
        } else if (obj instanceof Long) {
            c0166zza.type = 5;
            c0166zza.zzaVp.zzaVu = ((Long) obj).longValue();
        } else if (obj instanceof Double) {
            c0166zza.type = 3;
            c0166zza.zzaVp.zzaVs = ((Double) obj).doubleValue();
        } else if (obj instanceof Float) {
            c0166zza.type = 4;
            c0166zza.zzaVp.zzaVt = ((Float) obj).floatValue();
        } else if (obj instanceof Boolean) {
            c0166zza.type = 8;
            c0166zza.zzaVp.zzaVx = ((Boolean) obj).booleanValue();
        } else if (obj instanceof Byte) {
            c0166zza.type = 7;
            c0166zza.zzaVp.zzaVw = ((Byte) obj).byteValue();
        } else if (obj instanceof byte[]) {
            c0166zza.type = 1;
            c0166zza.zzaVp.zzaVq = (byte[]) obj;
        } else if (obj instanceof String[]) {
            c0166zza.type = 11;
            c0166zza.zzaVp.zzaVA = (String[]) obj;
        } else if (obj instanceof long[]) {
            c0166zza.type = 12;
            c0166zza.zzaVp.zzaVB = (long[]) obj;
        } else if (obj instanceof float[]) {
            c0166zza.type = 15;
            c0166zza.zzaVp.zzaVC = (float[]) obj;
        } else if (obj instanceof Asset) {
            c0166zza.type = 13;
            c0166zza.zzaVp.zzaVD = zza(list, (Asset) obj);
        } else {
            int i = 0;
            if (obj instanceof DataMap) {
                c0166zza.type = 9;
                DataMap dataMap = (DataMap) obj;
                Set<String> keySet = dataMap.keySet();
                zzrc.zza[] zzaVarArr = new zzrc.zza[keySet.size()];
                for (String str : keySet) {
                    zzaVarArr[i] = new zzrc.zza();
                    zzaVarArr[i].name = str;
                    zzaVarArr[i].zzaVn = zza(list, dataMap.get(str));
                    i++;
                }
                c0166zza.zzaVp.zzaVy = zzaVarArr;
            } else {
                if (!(obj instanceof ArrayList)) {
                    throw new RuntimeException("newFieldValueFromValue: unexpected value " + obj.getClass().getSimpleName());
                }
                c0166zza.type = 10;
                ArrayList arrayList = (ArrayList) obj;
                zzrc.zza.C0166zza[] c0166zzaArr = new zzrc.zza.C0166zza[arrayList.size()];
                int size = arrayList.size();
                Object obj2 = null;
                int i2 = 14;
                while (i < size) {
                    Object obj3 = arrayList.get(i);
                    zzrc.zza.C0166zza zza2 = zza(list, obj3);
                    if (zza2.type != 14 && zza2.type != 2 && zza2.type != 6 && zza2.type != 9) {
                        throw new IllegalArgumentException("The only ArrayList element types supported by DataBundleUtil are String, Integer, Bundle, and null, but this ArrayList contains a " + obj3.getClass());
                    }
                    if (i2 == 14 && zza2.type != 14) {
                        i2 = zza2.type;
                        obj2 = obj3;
                    } else if (zza2.type != i2) {
                        throw new IllegalArgumentException("ArrayList elements must all be of the sameclass, but this one contains a " + obj2.getClass() + " and a " + obj3.getClass());
                    }
                    c0166zzaArr[i] = zza2;
                    i++;
                }
                c0166zza.zzaVp.zzaVz = c0166zzaArr;
            }
        }
        return c0166zza;
    }

    public static DataMap zza(zza zzaVar) {
        DataMap dataMap = new DataMap();
        for (zzrc.zza zzaVar2 : zzaVar.zzaVj.zzaVl) {
            zza(zzaVar.zzaVk, dataMap, zzaVar2.name, zzaVar2.zzaVn);
        }
        return dataMap;
    }

    private static ArrayList zza(List<Asset> list, zzrc.zza.C0166zza.C0167zza c0167zza, int i) {
        Object valueOf;
        ArrayList arrayList = new ArrayList(c0167zza.zzaVz.length);
        for (zzrc.zza.C0166zza c0166zza : c0167zza.zzaVz) {
            if (c0166zza.type == 14) {
                valueOf = null;
            } else if (i == 9) {
                DataMap dataMap = new DataMap();
                for (zzrc.zza zzaVar : c0166zza.zzaVp.zzaVy) {
                    zza(list, dataMap, zzaVar.name, zzaVar.zzaVn);
                }
                arrayList.add(dataMap);
            } else if (i == 2) {
                valueOf = c0166zza.zzaVp.zzaVr;
            } else {
                if (i != 6) {
                    throw new IllegalArgumentException("Unexpected typeOfArrayList: " + i);
                }
                valueOf = Integer.valueOf(c0166zza.zzaVp.zzaVv);
            }
            arrayList.add(valueOf);
        }
        return arrayList;
    }

    private static void zza(List<Asset> list, DataMap dataMap, String str, zzrc.zza.C0166zza c0166zza) {
        int i = c0166zza.type;
        if (i == 14) {
            dataMap.putString(str, null);
            return;
        }
        zzrc.zza.C0166zza.C0167zza c0167zza = c0166zza.zzaVp;
        if (i == 1) {
            dataMap.putByteArray(str, c0167zza.zzaVq);
            return;
        }
        if (i == 11) {
            dataMap.putStringArray(str, c0167zza.zzaVA);
            return;
        }
        if (i == 12) {
            dataMap.putLongArray(str, c0167zza.zzaVB);
            return;
        }
        if (i == 15) {
            dataMap.putFloatArray(str, c0167zza.zzaVC);
            return;
        }
        if (i == 2) {
            dataMap.putString(str, c0167zza.zzaVr);
            return;
        }
        if (i == 3) {
            dataMap.putDouble(str, c0167zza.zzaVs);
            return;
        }
        if (i == 4) {
            dataMap.putFloat(str, c0167zza.zzaVt);
            return;
        }
        if (i == 5) {
            dataMap.putLong(str, c0167zza.zzaVu);
            return;
        }
        if (i == 6) {
            dataMap.putInt(str, c0167zza.zzaVv);
            return;
        }
        if (i == 7) {
            dataMap.putByte(str, (byte) c0167zza.zzaVw);
            return;
        }
        if (i == 8) {
            dataMap.putBoolean(str, c0167zza.zzaVx);
            return;
        }
        if (i == 13) {
            if (list == null) {
                throw new RuntimeException("populateBundle: unexpected type for: " + str);
            }
            dataMap.putAsset(str, list.get((int) c0167zza.zzaVD));
            return;
        }
        if (i == 9) {
            DataMap dataMap2 = new DataMap();
            for (zzrc.zza zzaVar : c0167zza.zzaVy) {
                zza(list, dataMap2, zzaVar.name, zzaVar.zzaVn);
            }
            dataMap.putDataMap(str, dataMap2);
            return;
        }
        if (i != 10) {
            throw new RuntimeException("populateBundle: unexpected type " + i);
        }
        int zza2 = zza(str, c0167zza.zzaVz);
        ArrayList<Integer> zza3 = zza(list, c0167zza, zza2);
        if (zza2 != 14) {
            if (zza2 == 9) {
                dataMap.putDataMapArrayList(str, zza3);
                return;
            } else if (zza2 != 2) {
                if (zza2 != 6) {
                    throw new IllegalStateException("Unexpected typeOfArrayList: " + zza2);
                }
                dataMap.putIntegerArrayList(str, zza3);
                return;
            }
        }
        dataMap.putStringArrayList(str, zza3);
    }

    private static zzrc.zza[] zza(DataMap dataMap, List<Asset> list) {
        Set<String> keySet = dataMap.keySet();
        zzrc.zza[] zzaVarArr = new zzrc.zza[keySet.size()];
        int i = 0;
        for (String str : keySet) {
            Object obj = dataMap.get(str);
            zzaVarArr[i] = new zzrc.zza();
            zzaVarArr[i].name = str;
            zzaVarArr[i].zzaVn = zza(list, obj);
            i++;
        }
        return zzaVarArr;
    }
}
