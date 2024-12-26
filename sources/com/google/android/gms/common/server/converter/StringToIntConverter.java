package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class StringToIntConverter implements SafeParcelable, FastJsonResponse.zza<String, Integer> {
    public static final zzb CREATOR = new zzb();
    private final int zzCY;
    private final HashMap<String, Integer> zzabB;
    private final HashMap<Integer, String> zzabC;
    private final ArrayList<Entry> zzabD;

    public static final class Entry implements SafeParcelable {
        public static final zzc CREATOR = new zzc();
        final int versionCode;
        final String zzabE;
        final int zzabF;

        Entry(int i, String str, int i2) {
            this.versionCode = i;
            this.zzabE = str;
            this.zzabF = i2;
        }

        Entry(String str, int i) {
            this.versionCode = 1;
            this.zzabE = str;
            this.zzabF = i;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            zzc.zza(this, parcel, i);
        }
    }

    public StringToIntConverter() {
        this.zzCY = 1;
        this.zzabB = new HashMap<>();
        this.zzabC = new HashMap<>();
        this.zzabD = null;
    }

    StringToIntConverter(int i, ArrayList<Entry> arrayList) {
        this.zzCY = i;
        this.zzabB = new HashMap<>();
        this.zzabC = new HashMap<>();
        this.zzabD = null;
        zzb(arrayList);
    }

    private void zzb(ArrayList<Entry> arrayList) {
        Iterator<Entry> it = arrayList.iterator();
        while (it.hasNext()) {
            Entry next = it.next();
            zzh(next.zzabE, next.zzabF);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    int getVersionCode() {
        return this.zzCY;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse.zza
    /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public String convertBack(Integer num) {
        String str = this.zzabC.get(num);
        return (str == null && this.zzabB.containsKey("gms_unknown")) ? "gms_unknown" : str;
    }

    public StringToIntConverter zzh(String str, int i) {
        this.zzabB.put(str, Integer.valueOf(i));
        this.zzabC.put(Integer.valueOf(i), str);
        return this;
    }

    ArrayList<Entry> zzoj() {
        ArrayList<Entry> arrayList = new ArrayList<>();
        for (String str : this.zzabB.keySet()) {
            arrayList.add(new Entry(str, this.zzabB.get(str).intValue()));
        }
        return arrayList;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse.zza
    public int zzok() {
        return 7;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse.zza
    public int zzol() {
        return 0;
    }
}
