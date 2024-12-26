package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.support.v4.view.ViewCompat;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class PolygonOptions implements SafeParcelable {
    public static final zzg CREATOR = new zzg();
    private final int zzCY;
    private float zzaCX;
    private int zzaCY;
    private int zzaCZ;
    private final List<LatLng> zzaDA;
    private final List<List<LatLng>> zzaDB;
    private boolean zzaDC;
    private float zzaDa;
    private boolean zzaDb;

    public PolygonOptions() {
        this.zzaCX = 10.0f;
        this.zzaCY = ViewCompat.MEASURED_STATE_MASK;
        this.zzaCZ = 0;
        this.zzaDa = 0.0f;
        this.zzaDb = true;
        this.zzaDC = false;
        this.zzCY = 1;
        this.zzaDA = new ArrayList();
        this.zzaDB = new ArrayList();
    }

    PolygonOptions(int i, List<LatLng> list, List list2, float f, int i2, int i3, float f2, boolean z, boolean z2) {
        this.zzaCX = 10.0f;
        this.zzaCY = ViewCompat.MEASURED_STATE_MASK;
        this.zzaCZ = 0;
        this.zzaDa = 0.0f;
        this.zzaDb = true;
        this.zzaDC = false;
        this.zzCY = i;
        this.zzaDA = list;
        this.zzaDB = list2;
        this.zzaCX = f;
        this.zzaCY = i2;
        this.zzaCZ = i3;
        this.zzaDa = f2;
        this.zzaDb = z;
        this.zzaDC = z2;
    }

    public PolygonOptions add(LatLng latLng) {
        this.zzaDA.add(latLng);
        return this;
    }

    public PolygonOptions add(LatLng... latLngArr) {
        this.zzaDA.addAll(Arrays.asList(latLngArr));
        return this;
    }

    public PolygonOptions addAll(Iterable<LatLng> iterable) {
        Iterator<LatLng> it = iterable.iterator();
        while (it.hasNext()) {
            this.zzaDA.add(it.next());
        }
        return this;
    }

    public PolygonOptions addHole(Iterable<LatLng> iterable) {
        ArrayList arrayList = new ArrayList();
        Iterator<LatLng> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        this.zzaDB.add(arrayList);
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public PolygonOptions fillColor(int i) {
        this.zzaCZ = i;
        return this;
    }

    public PolygonOptions geodesic(boolean z) {
        this.zzaDC = z;
        return this;
    }

    public int getFillColor() {
        return this.zzaCZ;
    }

    public List<List<LatLng>> getHoles() {
        return this.zzaDB;
    }

    public List<LatLng> getPoints() {
        return this.zzaDA;
    }

    public int getStrokeColor() {
        return this.zzaCY;
    }

    public float getStrokeWidth() {
        return this.zzaCX;
    }

    int getVersionCode() {
        return this.zzCY;
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

    public PolygonOptions strokeColor(int i) {
        this.zzaCY = i;
        return this;
    }

    public PolygonOptions strokeWidth(float f) {
        this.zzaCX = f;
        return this;
    }

    public PolygonOptions visible(boolean z) {
        this.zzaDb = z;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzg.zza(this, parcel, i);
    }

    public PolygonOptions zIndex(float f) {
        this.zzaDa = f;
        return this;
    }

    List zzvK() {
        return this.zzaDB;
    }
}
