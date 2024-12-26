package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.data.SessionDataSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class SessionReadResult implements Result, SafeParcelable {
    public static final Parcelable.Creator<SessionReadResult> CREATOR = new zzj();
    private final int zzCY;
    private final Status zzOt;
    private final List<Session> zzalQ;
    private final List<SessionDataSet> zzamX;

    SessionReadResult(int i, List<Session> list, List<SessionDataSet> list2, Status status) {
        this.zzCY = i;
        this.zzalQ = list;
        this.zzamX = Collections.unmodifiableList(list2);
        this.zzOt = status;
    }

    public SessionReadResult(List<Session> list, List<SessionDataSet> list2, Status status) {
        this.zzCY = 3;
        this.zzalQ = list;
        this.zzamX = Collections.unmodifiableList(list2);
        this.zzOt = status;
    }

    public static SessionReadResult zzO(Status status) {
        return new SessionReadResult(new ArrayList(), new ArrayList(), status);
    }

    private boolean zzb(SessionReadResult sessionReadResult) {
        return this.zzOt.equals(sessionReadResult.zzOt) && zzt.equal(this.zzalQ, sessionReadResult.zzalQ) && zzt.equal(this.zzamX, sessionReadResult.zzamX);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof SessionReadResult) && zzb((SessionReadResult) obj));
    }

    public List<DataSet> getDataSet(Session session) {
        zzu.zzb(this.zzalQ.contains(session), "Attempting to read data for session %s which was not returned", session);
        ArrayList arrayList = new ArrayList();
        for (SessionDataSet sessionDataSet : this.zzamX) {
            if (zzt.equal(session, sessionDataSet.getSession())) {
                arrayList.add(sessionDataSet.zzqK());
            }
        }
        return arrayList;
    }

    public List<DataSet> getDataSet(Session session, DataType dataType) {
        zzu.zzb(this.zzalQ.contains(session), "Attempting to read data for session %s which was not returned", session);
        ArrayList arrayList = new ArrayList();
        for (SessionDataSet sessionDataSet : this.zzamX) {
            if (zzt.equal(session, sessionDataSet.getSession()) && dataType.equals(sessionDataSet.zzqK().getDataType())) {
                arrayList.add(sessionDataSet.zzqK());
            }
        }
        return arrayList;
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
        return zzt.hashCode(this.zzOt, this.zzalQ, this.zzamX);
    }

    public String toString() {
        return zzt.zzt(this).zzg("status", this.zzOt).zzg("sessions", this.zzalQ).zzg("sessionDataSets", this.zzamX).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzj.zza(this, parcel, i);
    }

    public List<SessionDataSet> zzry() {
        return this.zzamX;
    }
}
