package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.dynamic.zzd;

/* loaded from: classes.dex */
public final class GroundOverlayOptions implements SafeParcelable {
    public static final zzc CREATOR = new zzc();
    public static final float NO_DIMENSION = -1.0f;
    private final int zzCY;
    private float zzaCT;
    private float zzaDa;
    private boolean zzaDb;
    private BitmapDescriptor zzaDd;
    private LatLng zzaDe;
    private float zzaDf;
    private float zzaDg;
    private LatLngBounds zzaDh;
    private float zzaDi;
    private float zzaDj;
    private float zzaDk;

    public GroundOverlayOptions() {
        this.zzaDb = true;
        this.zzaDi = 0.0f;
        this.zzaDj = 0.5f;
        this.zzaDk = 0.5f;
        this.zzCY = 1;
    }

    GroundOverlayOptions(int i, IBinder iBinder, LatLng latLng, float f, float f2, LatLngBounds latLngBounds, float f3, float f4, boolean z, float f5, float f6, float f7) {
        this.zzaDb = true;
        this.zzaDi = 0.0f;
        this.zzaDj = 0.5f;
        this.zzaDk = 0.5f;
        this.zzCY = i;
        this.zzaDd = new BitmapDescriptor(zzd.zza.zzbg(iBinder));
        this.zzaDe = latLng;
        this.zzaDf = f;
        this.zzaDg = f2;
        this.zzaDh = latLngBounds;
        this.zzaCT = f3;
        this.zzaDa = f4;
        this.zzaDb = z;
        this.zzaDi = f5;
        this.zzaDj = f6;
        this.zzaDk = f7;
    }

    private GroundOverlayOptions zza(LatLng latLng, float f, float f2) {
        this.zzaDe = latLng;
        this.zzaDf = f;
        this.zzaDg = f2;
        return this;
    }

    public GroundOverlayOptions anchor(float f, float f2) {
        this.zzaDj = f;
        this.zzaDk = f2;
        return this;
    }

    public GroundOverlayOptions bearing(float f) {
        this.zzaCT = ((f % 360.0f) + 360.0f) % 360.0f;
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getAnchorU() {
        return this.zzaDj;
    }

    public float getAnchorV() {
        return this.zzaDk;
    }

    public float getBearing() {
        return this.zzaCT;
    }

    public LatLngBounds getBounds() {
        return this.zzaDh;
    }

    public float getHeight() {
        return this.zzaDg;
    }

    public BitmapDescriptor getImage() {
        return this.zzaDd;
    }

    public LatLng getLocation() {
        return this.zzaDe;
    }

    public float getTransparency() {
        return this.zzaDi;
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

    public GroundOverlayOptions image(BitmapDescriptor bitmapDescriptor) {
        this.zzaDd = bitmapDescriptor;
        return this;
    }

    public boolean isVisible() {
        return this.zzaDb;
    }

    public GroundOverlayOptions position(LatLng latLng, float f) {
        zzu.zza(this.zzaDh == null, "Position has already been set using positionFromBounds");
        zzu.zzb(latLng != null, "Location must be specified");
        zzu.zzb(f >= 0.0f, "Width must be non-negative");
        return zza(latLng, f, -1.0f);
    }

    public GroundOverlayOptions position(LatLng latLng, float f, float f2) {
        zzu.zza(this.zzaDh == null, "Position has already been set using positionFromBounds");
        zzu.zzb(latLng != null, "Location must be specified");
        zzu.zzb(f >= 0.0f, "Width must be non-negative");
        zzu.zzb(f2 >= 0.0f, "Height must be non-negative");
        return zza(latLng, f, f2);
    }

    public GroundOverlayOptions positionFromBounds(LatLngBounds latLngBounds) {
        zzu.zza(this.zzaDe == null, "Position has already been set using position: " + this.zzaDe);
        this.zzaDh = latLngBounds;
        return this;
    }

    public GroundOverlayOptions transparency(float f) {
        zzu.zzb(f >= 0.0f && f <= 1.0f, "Transparency must be in the range [0..1]");
        this.zzaDi = f;
        return this;
    }

    public GroundOverlayOptions visible(boolean z) {
        this.zzaDb = z;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }

    public GroundOverlayOptions zIndex(float f) {
        this.zzaDa = f;
        return this;
    }

    IBinder zzvI() {
        return this.zzaDd.zzvg().asBinder();
    }
}
