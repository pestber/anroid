package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class AppVisibleCustomProperties implements SafeParcelable, Iterable<CustomProperty> {
    public static final Parcelable.Creator<AppVisibleCustomProperties> CREATOR = new com.google.android.gms.drive.metadata.internal.zza();
    public static final AppVisibleCustomProperties zzagD = new zza().zzpU();
    final int zzCY;
    final List<CustomProperty> zzagE;

    public static class zza {
        private final Map<CustomPropertyKey, CustomProperty> zzagF = new HashMap();

        public zza zza(CustomPropertyKey customPropertyKey, String str) {
            zzu.zzb(customPropertyKey, "key");
            this.zzagF.put(customPropertyKey, new CustomProperty(customPropertyKey, str));
            return this;
        }

        public AppVisibleCustomProperties zzpU() {
            return new AppVisibleCustomProperties(this.zzagF.values());
        }
    }

    AppVisibleCustomProperties(int i, Collection<CustomProperty> collection) {
        this.zzCY = i;
        zzu.zzu(collection);
        this.zzagE = new ArrayList(collection);
    }

    private AppVisibleCustomProperties(Collection<CustomProperty> collection) {
        this(1, collection);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Iterable
    public Iterator<CustomProperty> iterator() {
        return this.zzagE.iterator();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        com.google.android.gms.drive.metadata.internal.zza.zza(this, parcel, i);
    }

    public Map<CustomPropertyKey, String> zzpT() {
        HashMap hashMap = new HashMap(this.zzagE.size());
        for (CustomProperty customProperty : this.zzagE) {
            hashMap.put(customProperty.zzpV(), customProperty.getValue());
        }
        return Collections.unmodifiableMap(hashMap);
    }
}
