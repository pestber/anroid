package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.zzd;

/* loaded from: classes.dex */
public final class MarkerOptions implements SafeParcelable {
    public static final zzf CREATOR = new zzf();
    private float mAlpha;
    private final int zzCY;
    private LatLng zzaCx;
    private boolean zzaDb;
    private float zzaDj;
    private float zzaDk;
    private String zzaDs;
    private BitmapDescriptor zzaDt;
    private boolean zzaDu;
    private boolean zzaDv;
    private float zzaDw;
    private float zzaDx;
    private float zzaDy;
    private String zzadv;

    public MarkerOptions() {
        this.zzaDj = 0.5f;
        this.zzaDk = 1.0f;
        this.zzaDb = true;
        this.zzaDv = false;
        this.zzaDw = 0.0f;
        this.zzaDx = 0.5f;
        this.zzaDy = 0.0f;
        this.mAlpha = 1.0f;
        this.zzCY = 1;
    }

    MarkerOptions(int i, LatLng latLng, String str, String str2, IBinder iBinder, float f, float f2, boolean z, boolean z2, boolean z3, float f3, float f4, float f5, float f6) {
        this.zzaDj = 0.5f;
        this.zzaDk = 1.0f;
        this.zzaDb = true;
        this.zzaDv = false;
        this.zzaDw = 0.0f;
        this.zzaDx = 0.5f;
        this.zzaDy = 0.0f;
        this.mAlpha = 1.0f;
        this.zzCY = i;
        this.zzaCx = latLng;
        this.zzadv = str;
        this.zzaDs = str2;
        this.zzaDt = iBinder == null ? null : new BitmapDescriptor(zzd.zza.zzbg(iBinder));
        this.zzaDj = f;
        this.zzaDk = f2;
        this.zzaDu = z;
        this.zzaDb = z2;
        this.zzaDv = z3;
        this.zzaDw = f3;
        this.zzaDx = f4;
        this.zzaDy = f5;
        this.mAlpha = f6;
    }

    public MarkerOptions alpha(float f) {
        this.mAlpha = f;
        return this;
    }

    public MarkerOptions anchor(float f, float f2) {
        this.zzaDj = f;
        this.zzaDk = f2;
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public MarkerOptions draggable(boolean z) {
        this.zzaDu = z;
        return this;
    }

    public MarkerOptions flat(boolean z) {
        this.zzaDv = z;
        return this;
    }

    public float getAlpha() {
        return this.mAlpha;
    }

    public float getAnchorU() {
        return this.zzaDj;
    }

    public float getAnchorV() {
        return this.zzaDk;
    }

    public BitmapDescriptor getIcon() {
        return this.zzaDt;
    }

    public float getInfoWindowAnchorU() {
        return this.zzaDx;
    }

    public float getInfoWindowAnchorV() {
        return this.zzaDy;
    }

    public LatLng getPosition() {
        return this.zzaCx;
    }

    public float getRotation() {
        return this.zzaDw;
    }

    public String getSnippet() {
        return this.zzaDs;
    }

    public String getTitle() {
        return this.zzadv;
    }

    int getVersionCode() {
        return this.zzCY;
    }

    public MarkerOptions icon(BitmapDescriptor bitmapDescriptor) {
        this.zzaDt = bitmapDescriptor;
        return this;
    }

    public MarkerOptions infoWindowAnchor(float f, float f2) {
        this.zzaDx = f;
        this.zzaDy = f2;
        return this;
    }

    public boolean isDraggable() {
        return this.zzaDu;
    }

    public boolean isFlat() {
        return this.zzaDv;
    }

    public boolean isVisible() {
        return this.zzaDb;
    }

    public MarkerOptions position(LatLng latLng) {
        this.zzaCx = latLng;
        return this;
    }

    public MarkerOptions rotation(float f) {
        this.zzaDw = f;
        return this;
    }

    public MarkerOptions snippet(String str) {
        this.zzaDs = str;
        return this;
    }

    public MarkerOptions title(String str) {
        this.zzadv = str;
        return this;
    }

    public MarkerOptions visible(boolean z) {
        this.zzaDb = z;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzf.zza(this, parcel, i);
    }

    IBinder zzvJ() {
        if (this.zzaDt == null) {
            return null;
        }
        return this.zzaDt.zzvg().asBinder();
    }
}
