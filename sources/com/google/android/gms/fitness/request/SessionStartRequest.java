package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.internal.zzmu;

/* loaded from: classes.dex */
public class SessionStartRequest implements SafeParcelable {
    public static final Parcelable.Creator<SessionStartRequest> CREATOR = new zzx();
    private final int zzCY;
    private final String zzMZ;
    private final Session zzajJ;
    private final zzmu zzalN;

    SessionStartRequest(int i, Session session, IBinder iBinder, String str) {
        this.zzCY = i;
        this.zzajJ = session;
        this.zzalN = iBinder == null ? null : zzmu.zza.zzbF(iBinder);
        this.zzMZ = str;
    }

    public SessionStartRequest(Session session, zzmu zzmuVar, String str) {
        com.google.android.gms.common.internal.zzu.zzb(session.isOngoing(), "Cannot start a session which has already ended");
        this.zzCY = 2;
        this.zzajJ = session;
        this.zzalN = zzmuVar;
        this.zzMZ = str;
    }

    private boolean zzb(SessionStartRequest sessionStartRequest) {
        return com.google.android.gms.common.internal.zzt.equal(this.zzajJ, sessionStartRequest.zzajJ);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof SessionStartRequest) && zzb((SessionStartRequest) obj));
    }

    public String getPackageName() {
        return this.zzMZ;
    }

    public Session getSession() {
        return this.zzajJ;
    }

    int getVersionCode() {
        return this.zzCY;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.zzt.hashCode(this.zzajJ);
    }

    public String toString() {
        return com.google.android.gms.common.internal.zzt.zzt(this).zzg("session", this.zzajJ).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzx.zza(this, parcel, i);
    }

    public IBinder zzqU() {
        if (this.zzalN == null) {
            return null;
        }
        return this.zzalN.asBinder();
    }
}
