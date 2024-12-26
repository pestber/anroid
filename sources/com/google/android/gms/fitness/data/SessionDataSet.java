package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class SessionDataSet implements SafeParcelable {
    public static final Parcelable.Creator<SessionDataSet> CREATOR = new zzq();
    final int zzCY;
    private final Session zzajJ;
    private final DataSet zzakO;

    SessionDataSet(int i, Session session, DataSet dataSet) {
        this.zzCY = i;
        this.zzajJ = session;
        this.zzakO = dataSet;
    }

    private boolean zza(SessionDataSet sessionDataSet) {
        return com.google.android.gms.common.internal.zzt.equal(this.zzajJ, sessionDataSet.zzajJ) && com.google.android.gms.common.internal.zzt.equal(this.zzakO, sessionDataSet.zzakO);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof SessionDataSet) && zza((SessionDataSet) obj));
    }

    public Session getSession() {
        return this.zzajJ;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.zzt.hashCode(this.zzajJ, this.zzakO);
    }

    public String toString() {
        return com.google.android.gms.common.internal.zzt.zzt(this).zzg("session", this.zzajJ).zzg("dataSet", this.zzakO).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzq.zza(this, parcel, i);
    }

    public DataSet zzqK() {
        return this.zzakO;
    }
}
