package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.internal.widget.ActivityChooserView;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;

/* loaded from: classes.dex */
public class Strategy implements SafeParcelable {
    public static final Parcelable.Creator<Strategy> CREATOR = new zzf();
    public static final Strategy zzaFQ = new zza().zzwZ();
    public static final Strategy zzaFR = new zza().zzie(2).zzif(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED).zzwZ();

    @Deprecated
    public static final Strategy zzaFS = zzaFR;
    final int versionCode;

    @Deprecated
    final int zzaFT;
    final int zzaFU;
    final int zzaFV;

    @Deprecated
    final boolean zzaFW;
    final int zzaFX;
    final int zzaFY;

    public static class zza {
        private int zzaFY = 3;
        private int zzaFU = 300;
        private int zzaFV = 0;
        private int zzaFX = 1;

        public zza zzie(int i) {
            this.zzaFX = i;
            return this;
        }

        public zza zzif(int i) {
            zzu.zzb(i == Integer.MAX_VALUE || (i > 0 && i <= 86400), "ttlSeconds(%d) must either be TTL_SECONDS_INFINITE, or it must be between 1 and TTL_SECONDS_MAX(%d) inclusive", Integer.valueOf(i), 86400);
            this.zzaFU = i;
            return this;
        }

        public Strategy zzwZ() {
            if (this.zzaFX == 2) {
                if (this.zzaFY != 3) {
                    throw new IllegalStateException("Discovery mode must be DISCOVERY_MODE_DEFAULT.");
                }
                if (this.zzaFV == 1) {
                    throw new IllegalStateException("Cannot set EARSHOT with BLE only mode.");
                }
            }
            return new Strategy(2, 0, this.zzaFU, this.zzaFV, false, this.zzaFX, this.zzaFY);
        }
    }

    Strategy(int i, int i2, int i3, int i4, boolean z, int i5, int i6) {
        this.versionCode = i;
        this.zzaFT = i2;
        if (i2 != 0) {
            switch (i2) {
                case 2:
                    this.zzaFY = 1;
                    break;
                case 3:
                    this.zzaFY = 2;
                    break;
                default:
                    this.zzaFY = 3;
                    break;
            }
        } else {
            this.zzaFY = i6;
        }
        this.zzaFV = i4;
        this.zzaFW = z;
        if (z) {
            this.zzaFX = 2;
            this.zzaFU = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        } else {
            if (i5 == 0) {
                this.zzaFX = 1;
            } else {
                this.zzaFX = i5;
            }
            this.zzaFU = i3;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Strategy)) {
            return false;
        }
        Strategy strategy = (Strategy) obj;
        return this.versionCode == strategy.versionCode && this.zzaFY == strategy.zzaFY && this.zzaFU == strategy.zzaFU && this.zzaFV == strategy.zzaFV && this.zzaFX == strategy.zzaFX;
    }

    public int hashCode() {
        return (((((((this.versionCode * 31) + this.zzaFY) * 31) + this.zzaFU) * 31) + this.zzaFV) * 31) + this.zzaFX;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzf.zza(this, parcel, i);
    }
}
