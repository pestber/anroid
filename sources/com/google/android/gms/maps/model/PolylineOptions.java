package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.support.v4.view.ViewCompat;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class PolylineOptions implements SafeParcelable {
    public static final zzh CREATOR = new zzh();
    private int mColor;
    private final int zzCY;
    private final List<LatLng> zzaDA;
    private boolean zzaDC;
    private float zzaDa;
    private boolean zzaDb;
    private float zzaDf;

    public PolylineOptions() {
        this.zzaDf = 10.0f;
        this.mColor = ViewCompat.MEASURED_STATE_MASK;
        this.zzaDa = 0.0f;
        this.zzaDb = true;
        this.zzaDC = false;
        this.zzCY = 1;
        this.zzaDA = new ArrayList();
    }

    PolylineOptions(int i, List list, float f, int i2, float f2, boolean z, boolean z2) {
        this.zzaDf = 10.0f;
        this.mColor = ViewCompat.MEASURED_STATE_MASK;
        this.zzaDa = 0.0f;
        this.zzaDb = true;
        this.zzaDC = false;
        this.zzCY = i;
        this.zzaDA = list;
        this.zzaDf = f;
        this.mColor = i2;
        this.zzaDa = f2;
        this.zzaDb = z;
        this.zzaDC = z2;
    }

    public PolylineOptions add(LatLng latLng) {
        this.zzaDA.add(latLng);
        return this;
    }

    public PolylineOptions add(LatLng... latLngArr) {
        this.zzaDA.addAll(Arrays.asList(latLngArr));
        return this;
    }

    public PolylineOptions addAll(Iterable<LatLng> iterable) {
        Iterator<LatLng> it = iterable.iterator();
        while (it.hasNext()) {
            this.zzaDA.add(it.next());
        }
        return this;
    }

    public PolylineOptions color(int i) {
        this.mColor = i;
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public PolylineOptions geodesic(boolean z) {
        this.zzaDC = z;
        return this;
    }

    public int getColor() {
        return this.mColor;
    }

    public List<LatLng> getPoints() {
        return this.zzaDA;
    }

    int getVersionCode() {
        return this.zzCY;
    }

    public float getWidth() {
        return this.zzaDf;
    }

    public float getZIndex() {
        return this.zzaDa;
    }

    public boolean isGeodesic() {
        return this.zzaDC;
    }

    public boolean isVisible() {
        return this.zzaDb;
    }

    public PolylineOptions visible(boolean z) {
        this.zzaDb = z;
        return this;
    }

    public PolylineOptions width(float f) {
        this.zzaDf = f;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzh.zza(this, parcel, i);
    }

    public PolylineOptions zIndex(float f) {
        this.zzaDa = f;
        return this;
    }
}
