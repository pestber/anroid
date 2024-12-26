package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveSpace;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import com.google.android.gms.drive.query.internal.MatchAllFilter;
import com.google.android.gms.drive.query.internal.Operator;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* loaded from: classes.dex */
public class Query implements SafeParcelable {
    public static final Parcelable.Creator<Query> CREATOR = new zza();
    final int zzCY;
    final List<DriveSpace> zzadR;
    private final Set<DriveSpace> zzadS;
    final LogicalFilter zzahG;
    final String zzahH;
    final SortOrder zzahI;
    final List<String> zzahJ;
    final boolean zzahK;

    public static class Builder {
        private Set<DriveSpace> zzadS;
        private String zzahH;
        private SortOrder zzahI;
        private List<String> zzahJ;
        private boolean zzahK;
        private final List<Filter> zzahL = new ArrayList();

        public Builder() {
        }

        public Builder(Query query) {
            this.zzahL.add(query.getFilter());
            this.zzahH = query.getPageToken();
            this.zzahI = query.getSortOrder();
            this.zzahJ = query.zzpZ();
            this.zzahK = query.zzqa();
            this.zzadS = query.zzqb();
        }

        public Builder addFilter(Filter filter) {
            if (!(filter instanceof MatchAllFilter)) {
                this.zzahL.add(filter);
            }
            return this;
        }

        public Query build() {
            return new Query(new LogicalFilter(Operator.zzaim, this.zzahL), this.zzahH, this.zzahI, this.zzahJ, this.zzahK, this.zzadS);
        }

        @Deprecated
        public Builder setPageToken(String str) {
            this.zzahH = str;
            return this;
        }

        public Builder setSortOrder(SortOrder sortOrder) {
            this.zzahI = sortOrder;
            return this;
        }
    }

    Query(int i, LogicalFilter logicalFilter, String str, SortOrder sortOrder, List<String> list, boolean z, List<DriveSpace> list2) {
        this(i, logicalFilter, str, sortOrder, list, z, list2, list2 == null ? null : new HashSet(list2));
    }

    private Query(int i, LogicalFilter logicalFilter, String str, SortOrder sortOrder, List<String> list, boolean z, List<DriveSpace> list2, Set<DriveSpace> set) {
        this.zzCY = i;
        this.zzahG = logicalFilter;
        this.zzahH = str;
        this.zzahI = sortOrder;
        this.zzahJ = list;
        this.zzahK = z;
        this.zzadR = list2;
        this.zzadS = set;
    }

    private Query(LogicalFilter logicalFilter, String str, SortOrder sortOrder, List<String> list, boolean z, Set<DriveSpace> set) {
        this(1, logicalFilter, str, sortOrder, list, z, set == null ? null : new ArrayList(set), set);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Filter getFilter() {
        return this.zzahG;
    }

    @Deprecated
    public String getPageToken() {
        return this.zzahH;
    }

    public SortOrder getSortOrder() {
        return this.zzahI;
    }

    public String toString() {
        return String.format(Locale.US, "Query[%s,%s,PageToken=%s,Spaces=%s]", this.zzahG, this.zzahI, this.zzahH, this.zzadR);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    public List<String> zzpZ() {
        return this.zzahJ;
    }

    public boolean zzqa() {
        return this.zzahK;
    }

    public Set<DriveSpace> zzqb() {
        return this.zzadS;
    }
}
