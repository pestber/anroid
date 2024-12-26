package com.google.android.gms.maps;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.util.AttributeSet;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.CameraPosition;

/* loaded from: classes.dex */
public final class GoogleMapOptions implements SafeParcelable {
    public static final zza CREATOR = new zza();
    private final int zzCY;
    private Boolean zzaBI;
    private Boolean zzaBJ;
    private int zzaBK;
    private CameraPosition zzaBL;
    private Boolean zzaBM;
    private Boolean zzaBN;
    private Boolean zzaBO;
    private Boolean zzaBP;
    private Boolean zzaBQ;
    private Boolean zzaBR;
    private Boolean zzaBS;
    private Boolean zzaBT;

    public GoogleMapOptions() {
        this.zzaBK = -1;
        this.zzCY = 1;
    }

    GoogleMapOptions(int i, byte b, byte b2, int i2, CameraPosition cameraPosition, byte b3, byte b4, byte b5, byte b6, byte b7, byte b8, byte b9, byte b10) {
        this.zzaBK = -1;
        this.zzCY = i;
        this.zzaBI = com.google.android.gms.maps.internal.zza.zza(b);
        this.zzaBJ = com.google.android.gms.maps.internal.zza.zza(b2);
        this.zzaBK = i2;
        this.zzaBL = cameraPosition;
        this.zzaBM = com.google.android.gms.maps.internal.zza.zza(b3);
        this.zzaBN = com.google.android.gms.maps.internal.zza.zza(b4);
        this.zzaBO = com.google.android.gms.maps.internal.zza.zza(b5);
        this.zzaBP = com.google.android.gms.maps.internal.zza.zza(b6);
        this.zzaBQ = com.google.android.gms.maps.internal.zza.zza(b7);
        this.zzaBR = com.google.android.gms.maps.internal.zza.zza(b8);
        this.zzaBS = com.google.android.gms.maps.internal.zza.zza(b9);
        this.zzaBT = com.google.android.gms.maps.internal.zza.zza(b10);
    }

    public static GoogleMapOptions createFromAttributes(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            return null;
        }
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, com.google.android.gms.R.styleable.MapAttrs);
        GoogleMapOptions googleMapOptions = new GoogleMapOptions();
        if (obtainAttributes.hasValue(com.google.android.gms.R.styleable.MapAttrs_mapType)) {
            googleMapOptions.mapType(obtainAttributes.getInt(com.google.android.gms.R.styleable.MapAttrs_mapType, -1));
        }
        if (obtainAttributes.hasValue(com.google.android.gms.R.styleable.MapAttrs_zOrderOnTop)) {
            googleMapOptions.zOrderOnTop(obtainAttributes.getBoolean(com.google.android.gms.R.styleable.MapAttrs_zOrderOnTop, false));
        }
        if (obtainAttributes.hasValue(com.google.android.gms.R.styleable.MapAttrs_useViewLifecycle)) {
            googleMapOptions.useViewLifecycleInFragment(obtainAttributes.getBoolean(com.google.android.gms.R.styleable.MapAttrs_useViewLifecycle, false));
        }
        if (obtainAttributes.hasValue(com.google.android.gms.R.styleable.MapAttrs_uiCompass)) {
            googleMapOptions.compassEnabled(obtainAttributes.getBoolean(com.google.android.gms.R.styleable.MapAttrs_uiCompass, true));
        }
        if (obtainAttributes.hasValue(com.google.android.gms.R.styleable.MapAttrs_uiRotateGestures)) {
            googleMapOptions.rotateGesturesEnabled(obtainAttributes.getBoolean(com.google.android.gms.R.styleable.MapAttrs_uiRotateGestures, true));
        }
        if (obtainAttributes.hasValue(com.google.android.gms.R.styleable.MapAttrs_uiScrollGestures)) {
            googleMapOptions.scrollGesturesEnabled(obtainAttributes.getBoolean(com.google.android.gms.R.styleable.MapAttrs_uiScrollGestures, true));
        }
        if (obtainAttributes.hasValue(com.google.android.gms.R.styleable.MapAttrs_uiTiltGestures)) {
            googleMapOptions.tiltGesturesEnabled(obtainAttributes.getBoolean(com.google.android.gms.R.styleable.MapAttrs_uiTiltGestures, true));
        }
        if (obtainAttributes.hasValue(com.google.android.gms.R.styleable.MapAttrs_uiZoomGestures)) {
            googleMapOptions.zoomGesturesEnabled(obtainAttributes.getBoolean(com.google.android.gms.R.styleable.MapAttrs_uiZoomGestures, true));
        }
        if (obtainAttributes.hasValue(com.google.android.gms.R.styleable.MapAttrs_uiZoomControls)) {
            googleMapOptions.zoomControlsEnabled(obtainAttributes.getBoolean(com.google.android.gms.R.styleable.MapAttrs_uiZoomControls, true));
        }
        if (obtainAttributes.hasValue(com.google.android.gms.R.styleable.MapAttrs_liteMode)) {
            googleMapOptions.liteMode(obtainAttributes.getBoolean(com.google.android.gms.R.styleable.MapAttrs_liteMode, false));
        }
        if (obtainAttributes.hasValue(com.google.android.gms.R.styleable.MapAttrs_uiMapToolbar)) {
            googleMapOptions.mapToolbarEnabled(obtainAttributes.getBoolean(com.google.android.gms.R.styleable.MapAttrs_uiMapToolbar, true));
        }
        googleMapOptions.camera(CameraPosition.createFromAttributes(context, attributeSet));
        obtainAttributes.recycle();
        return googleMapOptions;
    }

    public GoogleMapOptions camera(CameraPosition cameraPosition) {
        this.zzaBL = cameraPosition;
        return this;
    }

    public GoogleMapOptions compassEnabled(boolean z) {
        this.zzaBN = Boolean.valueOf(z);
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public CameraPosition getCamera() {
        return this.zzaBL;
    }

    public Boolean getCompassEnabled() {
        return this.zzaBN;
    }

    public Boolean getLiteMode() {
        return this.zzaBS;
    }

    public Boolean getMapToolbarEnabled() {
        return this.zzaBT;
    }

    public int getMapType() {
        return this.zzaBK;
    }

    public Boolean getRotateGesturesEnabled() {
        return this.zzaBR;
    }

    public Boolean getScrollGesturesEnabled() {
        return this.zzaBO;
    }

    public Boolean getTiltGesturesEnabled() {
        return this.zzaBQ;
    }

    public Boolean getUseViewLifecycleInFragment() {
        return this.zzaBJ;
    }

    int getVersionCode() {
        return this.zzCY;
    }

    public Boolean getZOrderOnTop() {
        return this.zzaBI;
    }

    public Boolean getZoomControlsEnabled() {
        return this.zzaBM;
    }

    public Boolean getZoomGesturesEnabled() {
        return this.zzaBP;
    }

    public GoogleMapOptions liteMode(boolean z) {
        this.zzaBS = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions mapToolbarEnabled(boolean z) {
        this.zzaBT = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions mapType(int i) {
        this.zzaBK = i;
        return this;
    }

    public GoogleMapOptions rotateGesturesEnabled(boolean z) {
        this.zzaBR = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions scrollGesturesEnabled(boolean z) {
        this.zzaBO = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions tiltGesturesEnabled(boolean z) {
        this.zzaBQ = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions useViewLifecycleInFragment(boolean z) {
        this.zzaBJ = Boolean.valueOf(z);
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    public GoogleMapOptions zOrderOnTop(boolean z) {
        this.zzaBI = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions zoomControlsEnabled(boolean z) {
        this.zzaBM = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions zoomGesturesEnabled(boolean z) {
        this.zzaBP = Boolean.valueOf(z);
        return this;
    }

    byte zzvj() {
        return com.google.android.gms.maps.internal.zza.zze(this.zzaBI);
    }

    byte zzvk() {
        return com.google.android.gms.maps.internal.zza.zze(this.zzaBJ);
    }

    byte zzvl() {
        return com.google.android.gms.maps.internal.zza.zze(this.zzaBM);
    }

    byte zzvm() {
        return com.google.android.gms.maps.internal.zza.zze(this.zzaBN);
    }

    byte zzvn() {
        return com.google.android.gms.maps.internal.zza.zze(this.zzaBO);
    }

    byte zzvo() {
        return com.google.android.gms.maps.internal.zza.zze(this.zzaBP);
    }

    byte zzvp() {
        return com.google.android.gms.maps.internal.zza.zze(this.zzaBQ);
    }

    byte zzvq() {
        return com.google.android.gms.maps.internal.zza.zze(this.zzaBR);
    }

    byte zzvr() {
        return com.google.android.gms.maps.internal.zza.zze(this.zzaBS);
    }

    byte zzvs() {
        return com.google.android.gms.maps.internal.zza.zze(this.zzaBT);
    }
}
