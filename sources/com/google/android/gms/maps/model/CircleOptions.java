package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.support.v4.view.ViewCompat;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public final class CircleOptions implements SafeParcelable {
    public static final zzb CREATOR = new zzb();
    private final int zzCY;
    private LatLng zzaCV;
    private double zzaCW;
    private float zzaCX;
    private int zzaCY;
    private int zzaCZ;
    private float zzaDa;
    private boolean zzaDb;

    public CircleOptions() {
        this.zzaCV = null;
        this.zzaCW = 0.0d;
        this.zzaCX = 10.0f;
        this.zzaCY = ViewCompat.MEASURED_STATE_MASK;
        this.zzaCZ = 0;
        this.zzaDa = 0.0f;
        this.zzaDb = true;
        this.zzCY = 1;
    }

    CircleOptions(int i, LatLng latLng, double d, float f, int i2, int i3, float f2, boolean z) {
        this.zzaCV = null;
        this.zzaCW = 0.0d;
        this.zzaCX = 10.0f;
        this.zzaCY = ViewCompat.MEASURED_STATE_MASK;
        this.zzaCZ = 0;
        this.zzaDa = 0.0f;
        this.zzaDb = true;
        this.zzCY = i;
        this.zzaCV = latLng;
        this.zzaCW = d;
        this.zzaCX = f;
        this.zzaCY = i2;
        this.zzaCZ = i3;
        this.zzaDa = f2;
        this.zzaDb = z;
    }

    public CircleOptions center(LatLng latLng) {
        this.zzaCV = latLng;
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public CircleOptions fillColor(int i) {
        this.zzaCZ = i;
        return this;
    }

    public LatLng getCenter() {
        return this.zzaCV;
    }

    public int getFillColor() {
        return this.zzaCZ;
    }

    public double getRadius() {
        return this.zzaCW;
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

    public boolean isVisible() {
        return this.zzaDb;
    }

    public CircleOptions radius(double d) {
        this.zzaCW = d;
        return this;
    }

    public CircleOptions strokeColor(int i) {
        this.zzaCY = i;
        return this;
    }

    public CircleOptions strokeWidth(float f) {
        this.zzaCX = f;
        return this;
    }

    public CircleOptions visible(boolean z) {
        this.zzaDb = z;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }

    public CircleOptions zIndex(float f) {
        this.zzaDa = f;
        return this;
    }
}
