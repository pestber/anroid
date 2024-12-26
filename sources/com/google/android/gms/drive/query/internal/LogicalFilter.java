package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.drive.query.Filter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class LogicalFilter extends AbstractFilter {
    public static final Parcelable.Creator<LogicalFilter> CREATOR = new zzk();
    final int zzCY;
    private List<Filter> zzahL;
    final Operator zzahQ;
    final List<FilterHolder> zzaif;

    LogicalFilter(int i, Operator operator, List<FilterHolder> list) {
        this.zzCY = i;
        this.zzahQ = operator;
        this.zzaif = list;
    }

    public LogicalFilter(Operator operator, Filter filter, Filter... filterArr) {
        this.zzCY = 1;
        this.zzahQ = operator;
        this.zzaif = new ArrayList(filterArr.length + 1);
        this.zzaif.add(new FilterHolder(filter));
        this.zzahL = new ArrayList(filterArr.length + 1);
        this.zzahL.add(filter);
        for (Filter filter2 : filterArr) {
            this.zzaif.add(new FilterHolder(filter2));
            this.zzahL.add(filter2);
        }
    }

    public LogicalFilter(Operator operator, Iterable<Filter> iterable) {
        this.zzCY = 1;
        this.zzahQ = operator;
        this.zzahL = new ArrayList();
        this.zzaif = new ArrayList();
        for (Filter filter : iterable) {
            this.zzahL.add(filter);
            this.zzaif.add(new FilterHolder(filter));
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzk.zza(this, parcel, i);
    }

    @Override // com.google.android.gms.drive.query.Filter
    public <T> T zza(zzf<T> zzfVar) {
        ArrayList arrayList = new ArrayList();
        Iterator<FilterHolder> it = this.zzaif.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getFilter().zza(zzfVar));
        }
        return zzfVar.zzb(this.zzahQ, arrayList);
    }
}
