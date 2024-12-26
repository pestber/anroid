package com.google.android.gms.location;

import android.os.SystemClock;
import com.google.android.gms.location.internal.ParcelableGeofence;

/* loaded from: classes.dex */
public interface Geofence {
    public static final int GEOFENCE_TRANSITION_DWELL = 4;
    public static final int GEOFENCE_TRANSITION_ENTER = 1;
    public static final int GEOFENCE_TRANSITION_EXIT = 2;
    public static final long NEVER_EXPIRE = -1;

    public static final class Builder {
        private double zzaxB;
        private double zzaxC;
        private float zzaxD;
        private String zzDK = null;
        private int zzaxy = 0;
        private long zzaxz = Long.MIN_VALUE;
        private short zzaxA = -1;
        private int zzaxE = 0;
        private int zzaxF = -1;

        public Geofence build() {
            if (this.zzDK == null) {
                throw new IllegalArgumentException("Request ID not set.");
            }
            if (this.zzaxy == 0) {
                throw new IllegalArgumentException("Transitions types not set.");
            }
            if ((this.zzaxy & 4) != 0 && this.zzaxF < 0) {
                throw new IllegalArgumentException("Non-negative loitering delay needs to be set when transition types include GEOFENCE_TRANSITION_DWELLING.");
            }
            if (this.zzaxz == Long.MIN_VALUE) {
                throw new IllegalArgumentException("Expiration not set.");
            }
            if (this.zzaxA == -1) {
                throw new IllegalArgumentException("Geofence region not set.");
            }
            if (this.zzaxE >= 0) {
                return new ParcelableGeofence(this.zzDK, this.zzaxy, (short) 1, this.zzaxB, this.zzaxC, this.zzaxD, this.zzaxz, this.zzaxE, this.zzaxF);
            }
            throw new IllegalArgumentException("Notification responsiveness should be nonnegative.");
        }

        public Builder setCircularRegion(double d, double d2, float f) {
            this.zzaxA = (short) 1;
            this.zzaxB = d;
            this.zzaxC = d2;
            this.zzaxD = f;
            return this;
        }

        public Builder setExpirationDuration(long j) {
            this.zzaxz = j < 0 ? -1L : SystemClock.elapsedRealtime() + j;
            return this;
        }

        public Builder setLoiteringDelay(int i) {
            this.zzaxF = i;
            return this;
        }

        public Builder setNotificationResponsiveness(int i) {
            this.zzaxE = i;
            return this;
        }

        public Builder setRequestId(String str) {
            this.zzDK = str;
            return this;
        }

        public Builder setTransitionTypes(int i) {
            this.zzaxy = i;
            return this;
        }
    }

    String getRequestId();
}
