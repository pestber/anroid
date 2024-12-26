package com.google.android.gms.maps;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

/* loaded from: classes.dex */
public final class StreetViewPanoramaOptions implements SafeParcelable {
    public static final zzb CREATOR = new zzb();
    private final int zzCY;
    private Boolean zzaBJ;
    private Boolean zzaBP;
    private Boolean zzaCA;
    private Boolean zzaCB;
    private StreetViewPanoramaCamera zzaCv;
    private String zzaCw;
    private LatLng zzaCx;
    private Integer zzaCy;
    private Boolean zzaCz;

    public StreetViewPanoramaOptions() {
        this.zzaCz = true;
        this.zzaBP = true;
        this.zzaCA = true;
        this.zzaCB = true;
        this.zzCY = 1;
    }

    StreetViewPanoramaOptions(int i, StreetViewPanoramaCamera streetViewPanoramaCamera, String str, LatLng latLng, Integer num, byte b, byte b2, byte b3, byte b4, byte b5) {
        this.zzaCz = true;
        this.zzaBP = true;
        this.zzaCA = true;
        this.zzaCB = true;
        this.zzCY = i;
        this.zzaCv = streetViewPanoramaCamera;
        this.zzaCx = latLng;
        this.zzaCy = num;
        this.zzaCw = str;
        this.zzaCz = com.google.android.gms.maps.internal.zza.zza(b);
        this.zzaBP = com.google.android.gms.maps.internal.zza.zza(b2);
        this.zzaCA = com.google.android.gms.maps.internal.zza.zza(b3);
        this.zzaCB = com.google.android.gms.maps.internal.zza.zza(b4);
        this.zzaBJ = com.google.android.gms.maps.internal.zza.zza(b5);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Boolean getPanningGesturesEnabled() {
        return this.zzaCA;
    }

    public String getPanoramaId() {
        return this.zzaCw;
    }

    public LatLng getPosition() {
        return this.zzaCx;
    }

    public Integer getRadius() {
        return this.zzaCy;
    }

    public Boolean getStreetNamesEnabled() {
        return this.zzaCB;
    }

    public StreetViewPanoramaCamera getStreetViewPanoramaCamera() {
        return this.zzaCv;
    }

    public Boolean getUseViewLifecycleInFragment() {
        return this.zzaBJ;
    }

    public Boolean getUserNavigationEnabled() {
        return this.zzaCz;
    }

    int getVersionCode() {
        return this.zzCY;
    }

    public Boolean getZoomGesturesEnabled() {
        return this.zzaBP;
    }

    public StreetViewPanoramaOptions panningGesturesEnabled(boolean z) {
        this.zzaCA = Boolean.valueOf(z);
        return this;
    }

    public StreetViewPanoramaOptions panoramaCamera(StreetViewPanoramaCamera streetViewPanoramaCamera) {
        this.zzaCv = streetViewPanoramaCamera;
        return this;
    }

    public StreetViewPanoramaOptions panoramaId(String str) {
        this.zzaCw = str;
        return this;
    }

    public StreetViewPanoramaOptions position(LatLng latLng) {
        this.zzaCx = latLng;
        return this;
    }

    public StreetViewPanoramaOptions position(LatLng latLng, Integer num) {
        this.zzaCx = latLng;
        this.zzaCy = num;
        return this;
    }

    public StreetViewPanoramaOptions streetNamesEnabled(boolean z) {
        this.zzaCB = Boolean.valueOf(z);
        return this;
    }

    public StreetViewPanoramaOptions useViewLifecycleInFragment(boolean z) {
        this.zzaBJ = Boolean.valueOf(z);
        return this;
    }

    public StreetViewPanoramaOptions userNavigationEnabled(boolean z) {
        this.zzaCz = Boolean.valueOf(z);
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }

    public StreetViewPanoramaOptions zoomGesturesEnabled(boolean z) {
        this.zzaBP = Boolean.valueOf(z);
        return this;
    }

    byte zzvA() {
        return com.google.android.gms.maps.internal.zza.zze(this.zzaCB);
    }

    byte zzvk() {
        return com.google.android.gms.maps.internal.zza.zze(this.zzaBJ);
    }

    byte zzvo() {
        return com.google.android.gms.maps.internal.zza.zze(this.zzaBP);
    }

    byte zzvy() {
        return com.google.android.gms.maps.internal.zza.zze(this.zzaCz);
    }

    byte zzvz() {
        return com.google.android.gms.maps.internal.zza.zze(this.zzaCA);
    }
}
