package com.google.android.gms.fitness.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.fitness.FitnessActivities;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes.dex */
public final class Value implements SafeParcelable {
    public static final Parcelable.Creator<Value> CREATOR = new zzt();
    private final int zzCY;
    private final int zzakB;
    private float zzakF;
    private boolean zzakR;
    private String zzakS;
    private Map<String, MapValue> zzakT;

    public Value(int i) {
        this(2, i, false, 0.0f, null, null);
    }

    Value(int i, int i2, boolean z, float f, String str, Bundle bundle) {
        this.zzCY = i;
        this.zzakB = i2;
        this.zzakR = z;
        this.zzakF = f;
        this.zzakS = str;
        this.zzakT = zzr(bundle);
    }

    private boolean zza(Value value) {
        if (this.zzakB != value.zzakB || this.zzakR != value.zzakR) {
            return false;
        }
        switch (this.zzakB) {
            case 1:
                return asInt() == value.asInt();
            case 2:
                return asFloat() == value.asFloat();
            case 3:
                return asString().equals(value.asString());
            case 4:
                return zzpT().equals(value.zzpT());
            default:
                return this.zzakF == value.zzakF;
        }
    }

    private static Map<String, MapValue> zzr(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        bundle.setClassLoader(MapValue.class.getClassLoader());
        ArrayMap arrayMap = new ArrayMap(bundle.size());
        for (String str : bundle.keySet()) {
            arrayMap.put(str, bundle.getParcelable(str));
        }
        return arrayMap;
    }

    public String asActivity() {
        return FitnessActivities.getName(asInt());
    }

    public float asFloat() {
        zzu.zza(this.zzakB == 2, "Value is not in float format");
        return this.zzakF;
    }

    public int asInt() {
        zzu.zza(this.zzakB == 1, "Value is not in int format");
        return Float.floatToRawIntBits(this.zzakF);
    }

    public String asString() {
        zzu.zza(this.zzakB == 3, "Value is not in string format");
        return this.zzakS;
    }

    public void clearKey(String str) {
        zzu.zza(this.zzakB == 4, "Attempting to set a key's value to a field that is not in FLOAT_MAP format.  Please check the data type definition and use the right format.");
        if (this.zzakT != null) {
            this.zzakT.remove(str);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof Value) && zza((Value) obj));
    }

    public int getFormat() {
        return this.zzakB;
    }

    public Float getKeyValue(String str) {
        zzu.zza(this.zzakB == 4, "Value is not in float map format");
        if (this.zzakT == null || !this.zzakT.containsKey(str)) {
            return null;
        }
        return Float.valueOf(this.zzakT.get(str).asFloat());
    }

    int getVersionCode() {
        return this.zzCY;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.zzt.hashCode(Float.valueOf(this.zzakF), this.zzakS, this.zzakT);
    }

    public boolean isSet() {
        return this.zzakR;
    }

    public void setActivity(String str) {
        setInt(FitnessActivities.zzcF(str));
    }

    public void setFloat(float f) {
        zzu.zza(this.zzakB == 2, "Attempting to set an float value to a field that is not in FLOAT format.  Please check the data type definition and use the right format.");
        this.zzakR = true;
        this.zzakF = f;
    }

    public void setInt(int i) {
        zzu.zza(this.zzakB == 1, "Attempting to set an int value to a field that is not in INT32 format.  Please check the data type definition and use the right format.");
        this.zzakR = true;
        this.zzakF = Float.intBitsToFloat(i);
    }

    public void setKeyValue(String str, float f) {
        zzu.zza(this.zzakB == 4, "Attempting to set a key's value to a field that is not in FLOAT_MAP format.  Please check the data type definition and use the right format.");
        this.zzakR = true;
        if (this.zzakT == null) {
            this.zzakT = new HashMap();
        }
        this.zzakT.put(str, MapValue.zzc(f));
    }

    public void setString(String str) {
        zzu.zza(this.zzakB == 3, "Attempting to set a string value to a field that is not in STRING format.  Please check the data type definition and use the right format.");
        this.zzakR = true;
        this.zzakS = str;
    }

    public String toString() {
        if (!this.zzakR) {
            return "unset";
        }
        switch (this.zzakB) {
            case 1:
                return Integer.toString(asInt());
            case 2:
                return Float.toString(asFloat());
            case 3:
                return this.zzakS;
            case 4:
                return new TreeMap(this.zzakT).toString();
            default:
                return "unknown";
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzt.zza(this, parcel, i);
    }

    public Map<String, MapValue> zzpT() {
        zzu.zza(this.zzakB == 4, "Value is not in float map format");
        return this.zzakT == null ? Collections.emptyMap() : this.zzakT;
    }

    float zzqI() {
        return this.zzakF;
    }

    String zzqO() {
        return this.zzakS;
    }

    Bundle zzqP() {
        if (this.zzakT == null) {
            return null;
        }
        Bundle bundle = new Bundle(this.zzakT.size());
        for (Map.Entry<String, MapValue> entry : this.zzakT.entrySet()) {
            bundle.putParcelable(entry.getKey(), entry.getValue());
        }
        return bundle;
    }
}
