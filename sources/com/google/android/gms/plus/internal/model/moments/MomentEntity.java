package com.google.android.gms.plus.internal.model.moments;

import android.os.Parcel;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse;
import com.google.android.gms.plus.model.moments.ItemScope;
import com.google.android.gms.plus.model.moments.Moment;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class MomentEntity extends FastSafeParcelableJsonResponse implements Moment {
    public static final zzb CREATOR = new zzb();
    private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzaHP = new HashMap<>();
    final int zzCY;
    String zzEl;
    String zzKI;
    final Set<Integer> zzaHQ;
    String zzaID;
    ItemScopeEntity zzaIL;
    ItemScopeEntity zzaIM;

    static {
        zzaHP.put("id", FastJsonResponse.Field.zzl("id", 2));
        zzaHP.put("result", FastJsonResponse.Field.zza("result", 4, ItemScopeEntity.class));
        zzaHP.put("startDate", FastJsonResponse.Field.zzl("startDate", 5));
        zzaHP.put("target", FastJsonResponse.Field.zza("target", 6, ItemScopeEntity.class));
        zzaHP.put("type", FastJsonResponse.Field.zzl("type", 7));
    }

    public MomentEntity() {
        this.zzCY = 1;
        this.zzaHQ = new HashSet();
    }

    MomentEntity(Set<Integer> set, int i, String str, ItemScopeEntity itemScopeEntity, String str2, ItemScopeEntity itemScopeEntity2, String str3) {
        this.zzaHQ = set;
        this.zzCY = i;
        this.zzKI = str;
        this.zzaIL = itemScopeEntity;
        this.zzaID = str2;
        this.zzaIM = itemScopeEntity2;
        this.zzEl = str3;
    }

    public MomentEntity(Set<Integer> set, String str, ItemScopeEntity itemScopeEntity, String str2, ItemScopeEntity itemScopeEntity2, String str3) {
        this.zzaHQ = set;
        this.zzCY = 1;
        this.zzKI = str;
        this.zzaIL = itemScopeEntity;
        this.zzaID = str2;
        this.zzaIM = itemScopeEntity2;
        this.zzEl = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MomentEntity)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        MomentEntity momentEntity = (MomentEntity) obj;
        for (FastJsonResponse.Field<?, ?> field : zzaHP.values()) {
            if (zza(field)) {
                if (!momentEntity.zza(field) || !zzb(field).equals(momentEntity.zzb(field))) {
                    return false;
                }
            } else if (momentEntity.zza(field)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.plus.model.moments.Moment
    public String getId() {
        return this.zzKI;
    }

    @Override // com.google.android.gms.plus.model.moments.Moment
    public ItemScope getResult() {
        return this.zzaIL;
    }

    @Override // com.google.android.gms.plus.model.moments.Moment
    public String getStartDate() {
        return this.zzaID;
    }

    @Override // com.google.android.gms.plus.model.moments.Moment
    public ItemScope getTarget() {
        return this.zzaIM;
    }

    @Override // com.google.android.gms.plus.model.moments.Moment
    public String getType() {
        return this.zzEl;
    }

    @Override // com.google.android.gms.plus.model.moments.Moment
    public boolean hasId() {
        return this.zzaHQ.contains(2);
    }

    @Override // com.google.android.gms.plus.model.moments.Moment
    public boolean hasResult() {
        return this.zzaHQ.contains(4);
    }

    @Override // com.google.android.gms.plus.model.moments.Moment
    public boolean hasStartDate() {
        return this.zzaHQ.contains(5);
    }

    @Override // com.google.android.gms.plus.model.moments.Moment
    public boolean hasTarget() {
        return this.zzaHQ.contains(6);
    }

    @Override // com.google.android.gms.plus.model.moments.Moment
    public boolean hasType() {
        return this.zzaHQ.contains(7);
    }

    public int hashCode() {
        int i = 0;
        for (FastJsonResponse.Field<?, ?> field : zzaHP.values()) {
            if (zza(field)) {
                i = i + field.zzot() + zzb(field).hashCode();
            }
        }
        return i;
    }

    @Override // com.google.android.gms.common.data.Freezable
    public boolean isDataValid() {
        return true;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected boolean zza(FastJsonResponse.Field field) {
        return this.zzaHQ.contains(Integer.valueOf(field.zzot()));
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected Object zzb(FastJsonResponse.Field field) {
        switch (field.zzot()) {
            case 2:
                return this.zzKI;
            case 3:
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + field.zzot());
            case 4:
                return this.zzaIL;
            case 5:
                return this.zzaID;
            case 6:
                return this.zzaIM;
            case 7:
                return this.zzEl;
        }
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    /* renamed from: zzxF, reason: merged with bridge method [inline-methods] */
    public HashMap<String, FastJsonResponse.Field<?, ?>> zzom() {
        return zzaHP;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: zzxH, reason: merged with bridge method [inline-methods] */
    public MomentEntity freeze() {
        return this;
    }
}
