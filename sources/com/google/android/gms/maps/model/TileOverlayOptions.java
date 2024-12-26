package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.internal.zzl;

/* loaded from: classes.dex */
public final class TileOverlayOptions implements SafeParcelable {
    public static final zzn CREATOR = new zzn();
    private final int zzCY;
    private com.google.android.gms.maps.model.internal.zzl zzaDG;
    private TileProvider zzaDH;
    private boolean zzaDI;
    private float zzaDa;
    private boolean zzaDb;

    public TileOverlayOptions() {
        this.zzaDb = true;
        this.zzaDI = true;
        this.zzCY = 1;
    }

    TileOverlayOptions(int i, IBinder iBinder, boolean z, float f, boolean z2) {
        this.zzaDb = true;
        this.zzaDI = true;
        this.zzCY = i;
        this.zzaDG = zzl.zza.zzcT(iBinder);
        this.zzaDH = this.zzaDG == null ? null : new TileProvider() { // from class: com.google.android.gms.maps.model.TileOverlayOptions.1
            private final com.google.android.gms.maps.model.internal.zzl zzaDJ;

            {
                this.zzaDJ = TileOverlayOptions.this.zzaDG;
            }

            @Override // com.google.android.gms.maps.model.TileProvider
            public Tile getTile(int i2, int i3, int i4) {
                try {
                    return this.zzaDJ.getTile(i2, i3, i4);
                } catch (RemoteException e) {
                    return null;
                }
            }
        };
        this.zzaDb = z;
        this.zzaDa = f;
        this.zzaDI = z2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public TileOverlayOptions fadeIn(boolean z) {
        this.zzaDI = z;
        return this;
    }

    public boolean getFadeIn() {
        return this.zzaDI;
    }

    public TileProvider getTileProvider() {
        return this.zzaDH;
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

    public TileOverlayOptions tileProvider(final TileProvider tileProvider) {
        this.zzaDH = tileProvider;
        this.zzaDG = this.zzaDH == null ? null : new zzl.zza() { // from class: com.google.android.gms.maps.model.TileOverlayOptions.2
            @Override // com.google.android.gms.maps.model.internal.zzl
            public Tile getTile(int i, int i2, int i3) {
                return tileProvider.getTile(i, i2, i3);
            }
        };
        return this;
    }

    public TileOverlayOptions visible(boolean z) {
        this.zzaDb = z;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzn.zza(this, parcel, i);
    }

    public TileOverlayOptions zIndex(float f) {
        this.zzaDa = f;
        return this;
    }

    IBinder zzvL() {
        return this.zzaDG.asBinder();
    }
}
