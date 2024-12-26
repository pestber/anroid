package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.fitness.data.Session;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class SessionStopResult implements Result, SafeParcelable {
    public static final Parcelable.Creator<SessionStopResult> CREATOR = new zzk();
    private final int zzCY;
    private final Status zzOt;
    private final List<Session> zzalQ;

    SessionStopResult(int i, Status status, List<Session> list) {
        this.zzCY = i;
        this.zzOt = status;
        this.zzalQ = Collections.unmodifiableList(list);
    }

    public SessionStopResult(Status status, List<Session> list) {
        this.zzCY = 3;
        this.zzOt = status;
        this.zzalQ = Collections.unmodifiableList(list);
    }

    public static SessionStopResult zzP(Status status) {
        return new SessionStopResult(status, Collections.emptyList());
    }

    private boolean zzb(SessionStopResult sessionStopResult) {
        return this.zzOt.equals(sessionStopResult.zzOt) && zzt.equal(this.zzalQ, sessionStopResult.zzalQ);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof SessionStopResult) && zzb((SessionStopResult) obj));
    }

    public List<Session> getSessions() {
        return this.zzalQ;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.zzOt;
    }

    int getVersionCode() {
        return this.zzCY;
    }

    public int hashCode() {
        return zzt.hashCode(this.zzOt, this.zzalQ);
    }

    public String toString() {
        return zzt.zzt(this).zzg("status", this.zzOt).zzg("sessions", this.zzalQ).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzk.zza(this, parcel, i);
    }
}
