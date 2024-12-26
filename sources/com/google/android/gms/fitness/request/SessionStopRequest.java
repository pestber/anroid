package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzmt;

/* loaded from: classes.dex */
public class SessionStopRequest implements SafeParcelable {
    public static final Parcelable.Creator<SessionStopRequest> CREATOR = new zzy();
    private final String mName;
    private final int zzCY;
    private final String zzMZ;
    private final String zzakL;
    private final zzmt zzamJ;

    SessionStopRequest(int i, String str, String str2, IBinder iBinder, String str3) {
        this.zzCY = i;
        this.mName = str;
        this.zzakL = str2;
        this.zzamJ = iBinder == null ? null : zzmt.zza.zzbE(iBinder);
        this.zzMZ = str3;
    }

    public SessionStopRequest(String str, String str2, zzmt zzmtVar, String str3) {
        this.zzCY = 2;
        this.mName = str;
        this.zzakL = str2;
        this.zzamJ = zzmtVar;
        this.zzMZ = str3;
    }

    private boolean zzb(SessionStopRequest sessionStopRequest) {
        return com.google.android.gms.common.internal.zzt.equal(this.mName, sessionStopRequest.mName) && com.google.android.gms.common.internal.zzt.equal(this.zzakL, sessionStopRequest.zzakL);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof SessionStopRequest) && zzb((SessionStopRequest) obj));
    }

    public String getIdentifier() {
        return this.zzakL;
    }

    public String getName() {
        return this.mName;
    }

    public String getPackageName() {
        return this.zzMZ;
    }

    int getVersionCode() {
        return this.zzCY;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.zzt.hashCode(this.mName, this.zzakL);
    }

    public String toString() {
        return com.google.android.gms.common.internal.zzt.zzt(this).zzg("name", this.mName).zzg("identifier", this.zzakL).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzy.zza(this, parcel, i);
    }

    public IBinder zzqU() {
        if (this.zzamJ == null) {
            return null;
        }
        return this.zzamJ.asBinder();
    }
}
