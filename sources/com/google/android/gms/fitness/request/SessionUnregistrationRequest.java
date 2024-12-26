package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzmu;

/* loaded from: classes.dex */
public class SessionUnregistrationRequest implements SafeParcelable {
    public static final Parcelable.Creator<SessionUnregistrationRequest> CREATOR = new zzz();
    private final PendingIntent mPendingIntent;
    private final int zzCY;
    private final String zzMZ;
    private final zzmu zzalN;

    SessionUnregistrationRequest(int i, PendingIntent pendingIntent, IBinder iBinder, String str) {
        this.zzCY = i;
        this.mPendingIntent = pendingIntent;
        this.zzalN = iBinder == null ? null : zzmu.zza.zzbF(iBinder);
        this.zzMZ = str;
    }

    public SessionUnregistrationRequest(PendingIntent pendingIntent, zzmu zzmuVar, String str) {
        this.zzCY = 4;
        this.mPendingIntent = pendingIntent;
        this.zzalN = zzmuVar;
        this.zzMZ = str;
    }

    private boolean zzb(SessionUnregistrationRequest sessionUnregistrationRequest) {
        return com.google.android.gms.common.internal.zzt.equal(this.mPendingIntent, sessionUnregistrationRequest.mPendingIntent);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof SessionUnregistrationRequest) && zzb((SessionUnregistrationRequest) obj));
    }

    public String getPackageName() {
        return this.zzMZ;
    }

    int getVersionCode() {
        return this.zzCY;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.zzt.hashCode(this.mPendingIntent);
    }

    public String toString() {
        return com.google.android.gms.common.internal.zzt.zzt(this).zzg("pendingIntent", this.mPendingIntent).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzz.zza(this, parcel, i);
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
}
