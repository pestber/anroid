package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzmu;

/* loaded from: classes.dex */
public class SessionRegistrationRequest implements SafeParcelable {
    public static final Parcelable.Creator<SessionRegistrationRequest> CREATOR = new zzw();
    private final PendingIntent mPendingIntent;
    private final int zzCY;
    private final String zzMZ;
    private final zzmu zzalN;
    private final int zzamI;

    SessionRegistrationRequest(int i, PendingIntent pendingIntent, IBinder iBinder, String str, int i2) {
        this.zzCY = i;
        this.mPendingIntent = pendingIntent;
        this.zzalN = iBinder == null ? null : zzmu.zza.zzbF(iBinder);
        this.zzMZ = str;
        this.zzamI = i2;
    }

    public SessionRegistrationRequest(PendingIntent pendingIntent, zzmu zzmuVar, String str, int i) {
        this.zzCY = 5;
        this.mPendingIntent = pendingIntent;
        this.zzalN = zzmuVar;
        this.zzMZ = str;
        this.zzamI = i;
    }

    private boolean zzb(SessionRegistrationRequest sessionRegistrationRequest) {
        return this.zzamI == sessionRegistrationRequest.zzamI && com.google.android.gms.common.internal.zzt.equal(this.mPendingIntent, sessionRegistrationRequest.mPendingIntent);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof SessionRegistrationRequest) && zzb((SessionRegistrationRequest) obj));
    }

    public String getPackageName() {
        return this.zzMZ;
    }

    int getVersionCode() {
        return this.zzCY;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.zzt.hashCode(this.mPendingIntent, Integer.valueOf(this.zzamI));
    }

    public String toString() {
        return com.google.android.gms.common.internal.zzt.zzt(this).zzg("pendingIntent", this.mPendingIntent).zzg("sessionRegistrationOption", Integer.valueOf(this.zzamI)).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzw.zza(this, parcel, i);
    }

    public IBinder zzqU() {
        if (this.zzalN == null) {
            return null;
        }
        return this.zzalN.asBinder();
    }

    public PendingIntent zzrg() {
        return this.mPendingIntent;
    }

    public int zzrp() {
        return this.zzamI;
    }
}
