package com.google.android.gms.drive.metadata.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.drive.internal.zzx;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.zzlo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public final class MetadataBundle implements SafeParcelable {
    public static final Parcelable.Creator<MetadataBundle> CREATOR = new zzh();
    final int zzCY;
    final Bundle zzagI;

    MetadataBundle(int i, Bundle bundle) {
        this.zzCY = i;
        this.zzagI = (Bundle) zzu.zzu(bundle);
        this.zzagI.setClassLoader(getClass().getClassLoader());
        ArrayList arrayList = new ArrayList();
        for (String str : this.zzagI.keySet()) {
            if (zze.zzcw(str) == null) {
                arrayList.add(str);
                zzx.zzu("MetadataBundle", "Ignored unknown metadata field in bundle: " + str);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.zzagI.remove((String) it.next());
        }
    }

    private MetadataBundle(Bundle bundle) {
        this(1, bundle);
    }

    public static <T> MetadataBundle zza(MetadataField<T> metadataField, T t) {
        MetadataBundle zzpX = zzpX();
        zzpX.zzb(metadataField, t);
        return zzpX;
    }

    public static MetadataBundle zza(MetadataBundle metadataBundle) {
        return new MetadataBundle(new Bundle(metadataBundle.zzagI));
    }

    public static MetadataBundle zzpX() {
        return new MetadataBundle(new Bundle());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MetadataBundle)) {
            return false;
        }
        MetadataBundle metadataBundle = (MetadataBundle) obj;
        Set<String> keySet = this.zzagI.keySet();
        if (!keySet.equals(metadataBundle.zzagI.keySet())) {
            return false;
        }
        for (String str : keySet) {
            if (!zzt.equal(this.zzagI.get(str), metadataBundle.zzagI.get(str))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        Iterator<String> it = this.zzagI.keySet().iterator();
        int i = 1;
        while (it.hasNext()) {
            i = (i * 31) + this.zzagI.get(it.next()).hashCode();
        }
        return i;
    }

    public void setContext(Context context) {
        BitmapTeleporter bitmapTeleporter = (BitmapTeleporter) zza(zzlo.zzaho);
        if (bitmapTeleporter != null) {
            bitmapTeleporter.zzc(context.getCacheDir());
        }
    }

    public String toString() {
        return "MetadataBundle [values=" + this.zzagI + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzh.zza(this, parcel, i);
    }

    public <T> T zza(MetadataField<T> metadataField) {
        return metadataField.zzi(this.zzagI);
    }

    public <T> void zzb(MetadataField<T> metadataField, T t) {
        if (zze.zzcw(metadataField.getName()) == null) {
            throw new IllegalArgumentException("Unregistered field: " + metadataField.getName());
        }
        metadataField.zza(t, this.zzagI);
    }

    public boolean zzc(MetadataField<?> metadataField) {
        return this.zzagI.containsKey(metadataField.getName());
    }

    public Set<MetadataField<?>> zzpY() {
        HashSet hashSet = new HashSet();
        Iterator<String> it = this.zzagI.keySet().iterator();
        while (it.hasNext()) {
            hashSet.add(zze.zzcw(it.next()));
        }
        return hashSet;
    }
}
