package com.google.android.gms.wearable;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.internal.zzrb;
import com.google.android.gms.internal.zzrc;
import com.google.android.gms.internal.zzrm;
import com.google.android.gms.internal.zzrn;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public class DataMap {
    public static final String TAG = "DataMap";
    private final HashMap<String, Object> zzaSU = new HashMap<>();

    public static ArrayList<DataMap> arrayListFromBundleArrayList(ArrayList<Bundle> arrayList) {
        ArrayList<DataMap> arrayList2 = new ArrayList<>();
        Iterator<Bundle> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(fromBundle(it.next()));
        }
        return arrayList2;
    }

    public static DataMap fromBundle(Bundle bundle) {
        bundle.setClassLoader(Asset.class.getClassLoader());
        DataMap dataMap = new DataMap();
        for (String str : bundle.keySet()) {
            zza(dataMap, str, bundle.get(str));
        }
        return dataMap;
    }

    public static DataMap fromByteArray(byte[] bArr) {
        try {
            return zzrb.zza(new zzrb.zza(zzrc.zzw(bArr), new ArrayList()));
        } catch (zzrm e) {
            throw new IllegalArgumentException("Unable to convert data", e);
        }
    }

    private static void zza(Bundle bundle, String str, Object obj) {
        Parcelable bundle2;
        if (obj instanceof String) {
            bundle.putString(str, (String) obj);
            return;
        }
        if (obj instanceof Integer) {
            bundle.putInt(str, ((Integer) obj).intValue());
            return;
        }
        if (obj instanceof Long) {
            bundle.putLong(str, ((Long) obj).longValue());
            return;
        }
        if (obj instanceof Double) {
            bundle.putDouble(str, ((Double) obj).doubleValue());
            return;
        }
        if (obj instanceof Float) {
            bundle.putFloat(str, ((Float) obj).floatValue());
            return;
        }
        if (obj instanceof Boolean) {
            bundle.putBoolean(str, ((Boolean) obj).booleanValue());
            return;
        }
        if (obj instanceof Byte) {
            bundle.putByte(str, ((Byte) obj).byteValue());
            return;
        }
        if (obj instanceof byte[]) {
            bundle.putByteArray(str, (byte[]) obj);
            return;
        }
        if (obj instanceof String[]) {
            bundle.putStringArray(str, (String[]) obj);
            return;
        }
        if (obj instanceof long[]) {
            bundle.putLongArray(str, (long[]) obj);
            return;
        }
        if (obj instanceof float[]) {
            bundle.putFloatArray(str, (float[]) obj);
            return;
        }
        if (obj instanceof Asset) {
            bundle2 = (Asset) obj;
        } else {
            if (!(obj instanceof DataMap)) {
                if (obj instanceof ArrayList) {
                    ArrayList<String> arrayList = (ArrayList) obj;
                    switch (zzd(arrayList)) {
                        case 0:
                        case 1:
                        case 3:
                            bundle.putStringArrayList(str, arrayList);
                            break;
                        case 2:
                            bundle.putIntegerArrayList(str, arrayList);
                            break;
                        case 4:
                            ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>();
                            Iterator<String> it = arrayList.iterator();
                            while (it.hasNext()) {
                                arrayList2.add(((DataMap) it.next()).toBundle());
                            }
                            bundle.putParcelableArrayList(str, arrayList2);
                            break;
                    }
                    return;
                }
                return;
            }
            bundle2 = ((DataMap) obj).toBundle();
        }
        bundle.putParcelable(str, bundle2);
    }

    private static void zza(DataMap dataMap, String str, Object obj) {
        if (obj instanceof String) {
            dataMap.putString(str, (String) obj);
            return;
        }
        if (obj instanceof Integer) {
            dataMap.putInt(str, ((Integer) obj).intValue());
            return;
        }
        if (obj instanceof Long) {
            dataMap.putLong(str, ((Long) obj).longValue());
            return;
        }
        if (obj instanceof Double) {
            dataMap.putDouble(str, ((Double) obj).doubleValue());
            return;
        }
        if (obj instanceof Float) {
            dataMap.putFloat(str, ((Float) obj).floatValue());
            return;
        }
        if (obj instanceof Boolean) {
            dataMap.putBoolean(str, ((Boolean) obj).booleanValue());
            return;
        }
        if (obj instanceof Byte) {
            dataMap.putByte(str, ((Byte) obj).byteValue());
            return;
        }
        if (obj instanceof byte[]) {
            dataMap.putByteArray(str, (byte[]) obj);
            return;
        }
        if (obj instanceof String[]) {
            dataMap.putStringArray(str, (String[]) obj);
            return;
        }
        if (obj instanceof long[]) {
            dataMap.putLongArray(str, (long[]) obj);
            return;
        }
        if (obj instanceof float[]) {
            dataMap.putFloatArray(str, (float[]) obj);
            return;
        }
        if (obj instanceof Asset) {
            dataMap.putAsset(str, (Asset) obj);
            return;
        }
        if (obj instanceof Bundle) {
            dataMap.putDataMap(str, fromBundle((Bundle) obj));
            return;
        }
        if (obj instanceof ArrayList) {
            ArrayList<String> arrayList = (ArrayList) obj;
            switch (zzd(arrayList)) {
                case 0:
                case 1:
                case 3:
                    dataMap.putStringArrayList(str, arrayList);
                    break;
                case 2:
                    dataMap.putIntegerArrayList(str, arrayList);
                    break;
                case 5:
                    dataMap.putDataMapArrayList(str, arrayListFromBundleArrayList(arrayList));
                    break;
            }
        }
    }

    private void zza(String str, Object obj, String str2, ClassCastException classCastException) {
        zza(str, obj, str2, "<null>", classCastException);
    }

    private void zza(String str, Object obj, String str2, Object obj2, ClassCastException classCastException) {
        Log.w(TAG, "Key " + str + " expected " + str2 + " but value was a " + obj.getClass().getName() + ".  The default value " + obj2 + " was returned.");
        Log.w(TAG, "Attempt to cast generated internal exception:", classCastException);
    }

    private static boolean zza(Asset asset, Asset asset2) {
        return (asset == null || asset2 == null) ? asset == asset2 : !TextUtils.isEmpty(asset.getDigest()) ? asset.getDigest().equals(asset2.getDigest()) : Arrays.equals(asset.getData(), asset2.getData());
    }

    private static boolean zza(DataMap dataMap, DataMap dataMap2) {
        if (dataMap.size() != dataMap2.size()) {
            return false;
        }
        for (String str : dataMap.keySet()) {
            Object obj = dataMap.get(str);
            Object obj2 = dataMap2.get(str);
            if (obj instanceof Asset) {
                if (!(obj2 instanceof Asset) || !zza((Asset) obj, (Asset) obj2)) {
                    return false;
                }
            } else if (obj instanceof String[]) {
                if (!(obj2 instanceof String[]) || !Arrays.equals((String[]) obj, (String[]) obj2)) {
                    return false;
                }
            } else if (obj instanceof long[]) {
                if (!(obj2 instanceof long[]) || !Arrays.equals((long[]) obj, (long[]) obj2)) {
                    return false;
                }
            } else if (obj instanceof float[]) {
                if (!(obj2 instanceof float[]) || !Arrays.equals((float[]) obj, (float[]) obj2)) {
                    return false;
                }
            } else if (obj instanceof byte[]) {
                if (!(obj2 instanceof byte[]) || !Arrays.equals((byte[]) obj, (byte[]) obj2)) {
                    return false;
                }
            } else {
                if (obj == null || obj2 == null) {
                    return obj == obj2;
                }
                if (!obj.equals(obj2)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int zzd(ArrayList<?> arrayList) {
        if (arrayList.isEmpty()) {
            return 0;
        }
        Iterator<?> it = arrayList.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next != null) {
                if (next instanceof Integer) {
                    return 2;
                }
                if (next instanceof String) {
                    return 3;
                }
                if (next instanceof DataMap) {
                    return 4;
                }
                if (next instanceof Bundle) {
                    return 5;
                }
            }
        }
        return 1;
    }

    public void clear() {
        this.zzaSU.clear();
    }

    public boolean containsKey(String str) {
        return this.zzaSU.containsKey(str);
    }

    public boolean equals(Object obj) {
        if (obj instanceof DataMap) {
            return zza(this, (DataMap) obj);
        }
        return false;
    }

    public <T> T get(String str) {
        return (T) this.zzaSU.get(str);
    }

    public Asset getAsset(String str) {
        Object obj = this.zzaSU.get(str);
        if (obj == null) {
            return null;
        }
        try {
            return (Asset) obj;
        } catch (ClassCastException e) {
            zza(str, obj, "Asset", e);
            return null;
        }
    }

    public boolean getBoolean(String str) {
        return getBoolean(str, false);
    }

    public boolean getBoolean(String str, boolean z) {
        Object obj = this.zzaSU.get(str);
        if (obj == null) {
            return z;
        }
        try {
            return ((Boolean) obj).booleanValue();
        } catch (ClassCastException e) {
            zza(str, obj, "Boolean", Boolean.valueOf(z), e);
            return z;
        }
    }

    public byte getByte(String str) {
        return getByte(str, (byte) 0);
    }

    public byte getByte(String str, byte b) {
        Object obj = this.zzaSU.get(str);
        if (obj == null) {
            return b;
        }
        try {
            return ((Byte) obj).byteValue();
        } catch (ClassCastException e) {
            zza(str, obj, "Byte", Byte.valueOf(b), e);
            return b;
        }
    }

    public byte[] getByteArray(String str) {
        Object obj = this.zzaSU.get(str);
        if (obj == null) {
            return null;
        }
        try {
            return (byte[]) obj;
        } catch (ClassCastException e) {
            zza(str, obj, "byte[]", e);
            return null;
        }
    }

    public DataMap getDataMap(String str) {
        Object obj = this.zzaSU.get(str);
        if (obj == null) {
            return null;
        }
        try {
            return (DataMap) obj;
        } catch (ClassCastException e) {
            zza(str, obj, TAG, e);
            return null;
        }
    }

    public ArrayList<DataMap> getDataMapArrayList(String str) {
        Object obj = this.zzaSU.get(str);
        if (obj == null) {
            return null;
        }
        try {
            return (ArrayList) obj;
        } catch (ClassCastException e) {
            zza(str, obj, "ArrayList<DataMap>", e);
            return null;
        }
    }

    public double getDouble(String str) {
        return getDouble(str, 0.0d);
    }

    public double getDouble(String str, double d) {
        Object obj = this.zzaSU.get(str);
        if (obj == null) {
            return d;
        }
        try {
            return ((Double) obj).doubleValue();
        } catch (ClassCastException e) {
            zza(str, obj, "Double", Double.valueOf(d), e);
            return d;
        }
    }

    public float getFloat(String str) {
        return getFloat(str, 0.0f);
    }

    public float getFloat(String str, float f) {
        Object obj = this.zzaSU.get(str);
        if (obj == null) {
            return f;
        }
        try {
            return ((Float) obj).floatValue();
        } catch (ClassCastException e) {
            zza(str, obj, "Float", Float.valueOf(f), e);
            return f;
        }
    }

    public float[] getFloatArray(String str) {
        Object obj = this.zzaSU.get(str);
        if (obj == null) {
            return null;
        }
        try {
            return (float[]) obj;
        } catch (ClassCastException e) {
            zza(str, obj, "float[]", e);
            return null;
        }
    }

    public int getInt(String str) {
        return getInt(str, 0);
    }

    public int getInt(String str, int i) {
        Object obj = this.zzaSU.get(str);
        if (obj == null) {
            return i;
        }
        try {
            return ((Integer) obj).intValue();
        } catch (ClassCastException e) {
            zza(str, obj, "Integer", e);
            return i;
        }
    }

    public ArrayList<Integer> getIntegerArrayList(String str) {
        Object obj = this.zzaSU.get(str);
        if (obj == null) {
            return null;
        }
        try {
            return (ArrayList) obj;
        } catch (ClassCastException e) {
            zza(str, obj, "ArrayList<Integer>", e);
            return null;
        }
    }

    public long getLong(String str) {
        return getLong(str, 0L);
    }

    public long getLong(String str, long j) {
        Object obj = this.zzaSU.get(str);
        if (obj == null) {
            return j;
        }
        try {
            return ((Long) obj).longValue();
        } catch (ClassCastException e) {
            zza(str, obj, "long", e);
            return j;
        }
    }

    public long[] getLongArray(String str) {
        Object obj = this.zzaSU.get(str);
        if (obj == null) {
            return null;
        }
        try {
            return (long[]) obj;
        } catch (ClassCastException e) {
            zza(str, obj, "long[]", e);
            return null;
        }
    }

    public String getString(String str) {
        Object obj = this.zzaSU.get(str);
        if (obj == null) {
            return null;
        }
        try {
            return (String) obj;
        } catch (ClassCastException e) {
            zza(str, obj, "String", e);
            return null;
        }
    }

    public String getString(String str, String str2) {
        String string = getString(str);
        return string == null ? str2 : string;
    }

    public String[] getStringArray(String str) {
        Object obj = this.zzaSU.get(str);
        if (obj == null) {
            return null;
        }
        try {
            return (String[]) obj;
        } catch (ClassCastException e) {
            zza(str, obj, "String[]", e);
            return null;
        }
    }

    public ArrayList<String> getStringArrayList(String str) {
        Object obj = this.zzaSU.get(str);
        if (obj == null) {
            return null;
        }
        try {
            return (ArrayList) obj;
        } catch (ClassCastException e) {
            zza(str, obj, "ArrayList<String>", e);
            return null;
        }
    }

    public int hashCode() {
        return this.zzaSU.hashCode() * 29;
    }

    public boolean isEmpty() {
        return this.zzaSU.isEmpty();
    }

    public Set<String> keySet() {
        return this.zzaSU.keySet();
    }

    public void putAll(DataMap dataMap) {
        for (String str : dataMap.keySet()) {
            this.zzaSU.put(str, dataMap.get(str));
        }
    }

    public void putAsset(String str, Asset asset) {
        this.zzaSU.put(str, asset);
    }

    public void putBoolean(String str, boolean z) {
        this.zzaSU.put(str, Boolean.valueOf(z));
    }

    public void putByte(String str, byte b) {
        this.zzaSU.put(str, Byte.valueOf(b));
    }

    public void putByteArray(String str, byte[] bArr) {
        this.zzaSU.put(str, bArr);
    }

    public void putDataMap(String str, DataMap dataMap) {
        this.zzaSU.put(str, dataMap);
    }

    public void putDataMapArrayList(String str, ArrayList<DataMap> arrayList) {
        this.zzaSU.put(str, arrayList);
    }

    public void putDouble(String str, double d) {
        this.zzaSU.put(str, Double.valueOf(d));
    }

    public void putFloat(String str, float f) {
        this.zzaSU.put(str, Float.valueOf(f));
    }

    public void putFloatArray(String str, float[] fArr) {
        this.zzaSU.put(str, fArr);
    }

    public void putInt(String str, int i) {
        this.zzaSU.put(str, Integer.valueOf(i));
    }

    public void putIntegerArrayList(String str, ArrayList<Integer> arrayList) {
        this.zzaSU.put(str, arrayList);
    }

    public void putLong(String str, long j) {
        this.zzaSU.put(str, Long.valueOf(j));
    }

    public void putLongArray(String str, long[] jArr) {
        this.zzaSU.put(str, jArr);
    }

    public void putString(String str, String str2) {
        this.zzaSU.put(str, str2);
    }

    public void putStringArray(String str, String[] strArr) {
        this.zzaSU.put(str, strArr);
    }

    public void putStringArrayList(String str, ArrayList<String> arrayList) {
        this.zzaSU.put(str, arrayList);
    }

    public Object remove(String str) {
        return this.zzaSU.remove(str);
    }

    public int size() {
        return this.zzaSU.size();
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        for (String str : this.zzaSU.keySet()) {
            zza(bundle, str, this.zzaSU.get(str));
        }
        return bundle;
    }

    public byte[] toByteArray() {
        return zzrn.zzf(zzrb.zza(this).zzaVj);
    }

    public String toString() {
        return this.zzaSU.toString();
    }
}
