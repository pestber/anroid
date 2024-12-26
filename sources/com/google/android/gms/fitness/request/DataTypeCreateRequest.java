package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Field;
import com.google.android.gms.internal.zzmh;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class DataTypeCreateRequest implements SafeParcelable {
    public static final Parcelable.Creator<DataTypeCreateRequest> CREATOR = new zzi();
    private final String mName;
    private final int zzCY;
    private final String zzMZ;
    private final List<Field> zzakq;
    private final zzmh zzamk;

    public static class Builder {
        private String mName;
        private List<Field> zzakq = new ArrayList();

        public Builder addField(Field field) {
            if (!this.zzakq.contains(field)) {
                this.zzakq.add(field);
            }
            return this;
        }

        public Builder addField(String str, int i) {
            com.google.android.gms.common.internal.zzu.zzb((str == null || str.isEmpty()) ? false : true, "Invalid name specified");
            return addField(Field.zzn(str, i));
        }

        public DataTypeCreateRequest build() {
            com.google.android.gms.common.internal.zzu.zza(this.mName != null, "Must set the name");
            com.google.android.gms.common.internal.zzu.zza(!this.zzakq.isEmpty(), "Must specify the data fields");
            return new DataTypeCreateRequest(this);
        }

        public Builder setName(String str) {
            this.mName = str;
            return this;
        }
    }

    DataTypeCreateRequest(int i, String str, List<Field> list, IBinder iBinder, String str2) {
        this.zzCY = i;
        this.mName = str;
        this.zzakq = Collections.unmodifiableList(list);
        this.zzamk = iBinder == null ? null : zzmh.zza.zzbs(iBinder);
        this.zzMZ = str2;
    }

    private DataTypeCreateRequest(Builder builder) {
        this(builder.mName, builder.zzakq, null, null);
    }

    public DataTypeCreateRequest(DataTypeCreateRequest dataTypeCreateRequest, zzmh zzmhVar, String str) {
        this(dataTypeCreateRequest.mName, dataTypeCreateRequest.zzakq, zzmhVar, str);
    }

    public DataTypeCreateRequest(String str, List<Field> list, zzmh zzmhVar, String str2) {
        this.zzCY = 2;
        this.mName = str;
        this.zzakq = Collections.unmodifiableList(list);
        this.zzamk = zzmhVar;
        this.zzMZ = str2;
    }

    private boolean zzb(DataTypeCreateRequest dataTypeCreateRequest) {
        return com.google.android.gms.common.internal.zzt.equal(this.mName, dataTypeCreateRequest.mName) && com.google.android.gms.common.internal.zzt.equal(this.zzakq, dataTypeCreateRequest.zzakq);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof DataTypeCreateRequest) && zzb((DataTypeCreateRequest) obj));
    }

    public List<Field> getFields() {
        return this.zzakq;
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
        return com.google.android.gms.common.internal.zzt.hashCode(this.mName, this.zzakq);
    }

    public String toString() {
        return com.google.android.gms.common.internal.zzt.zzt(this).zzg("name", this.mName).zzg("fields", this.zzakq).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzi.zza(this, parcel, i);
    }

    public IBinder zzqU() {
        if (this.zzamk == null) {
            return null;
        }
        return this.zzamk.asBinder();
    }
}
