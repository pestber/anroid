package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public final class ConnectionEvent implements SafeParcelable {
    public static final Parcelable.Creator<ConnectionEvent> CREATOR = new zza();
    final int zzCY;
    private final long zzabZ;
    private int zzaca;
    private final String zzacb;
    private final String zzacc;
    private final String zzacd;
    private final String zzace;
    private final String zzacf;
    private final String zzacg;
    private final long zzach;
    private final long zzaci;
    private long zzacj;

    ConnectionEvent(int i, long j, int i2, String str, String str2, String str3, String str4, String str5, String str6, long j2, long j3) {
        this.zzCY = i;
        this.zzabZ = j;
        this.zzaca = i2;
        this.zzacb = str;
        this.zzacc = str2;
        this.zzacd = str3;
        this.zzace = str4;
        this.zzacj = -1L;
        this.zzacf = str5;
        this.zzacg = str6;
        this.zzach = j2;
        this.zzaci = j3;
    }

    public ConnectionEvent(long j, int i, String str, String str2, String str3, String str4, String str5, String str6, long j2, long j3) {
        this(1, j, i, str, str2, str3, str4, str5, str6, j2, j3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getEventType() {
        return this.zzaca;
    }

    public long getTimeMillis() {
        return this.zzabZ;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    public String zzoG() {
        return this.zzacb;
    }

    public String zzoH() {
        return this.zzacc;
    }

    public String zzoI() {
        return this.zzacd;
    }

    public String zzoJ() {
        return this.zzace;
    }

    public String zzoK() {
        return this.zzacf;
    }

    public String zzoL() {
        return this.zzacg;
    }

    public long zzoM() {
        return this.zzaci;
    }

    public long zzoN() {
        return this.zzach;
    }
}
