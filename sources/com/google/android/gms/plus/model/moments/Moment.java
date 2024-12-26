package com.google.android.gms.plus.model.moments;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.plus.internal.model.moments.ItemScopeEntity;
import com.google.android.gms.plus.internal.model.moments.MomentEntity;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public interface Moment extends Freezable<Moment> {

    public static class Builder {
        private String zzEl;
        private String zzKI;
        private final Set<Integer> zzaHQ = new HashSet();
        private String zzaID;
        private ItemScopeEntity zzaIL;
        private ItemScopeEntity zzaIM;

        public Moment build() {
            return new MomentEntity(this.zzaHQ, this.zzKI, this.zzaIL, this.zzaID, this.zzaIM, this.zzEl);
        }

        public Builder setId(String str) {
            this.zzKI = str;
            this.zzaHQ.add(2);
            return this;
        }

        public Builder setResult(ItemScope itemScope) {
            this.zzaIL = (ItemScopeEntity) itemScope;
            this.zzaHQ.add(4);
            return this;
        }

        public Builder setStartDate(String str) {
            this.zzaID = str;
            this.zzaHQ.add(5);
            return this;
        }

        public Builder setTarget(ItemScope itemScope) {
            this.zzaIM = (ItemScopeEntity) itemScope;
            this.zzaHQ.add(6);
            return this;
        }

        public Builder setType(String str) {
            this.zzEl = str;
            this.zzaHQ.add(7);
            return this;
        }
    }

    String getId();

    ItemScope getResult();

    String getStartDate();

    ItemScope getTarget();

    String getType();

    boolean hasId();

    boolean hasResult();

    boolean hasStartDate();

    boolean hasTarget();

    boolean hasType();
}
