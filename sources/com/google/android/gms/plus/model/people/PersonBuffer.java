package com.google.android.gms.plus.model.people;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzd;
import com.google.android.gms.plus.internal.model.people.PersonEntity;
import com.google.android.gms.plus.internal.model.people.zzk;

/* loaded from: classes.dex */
public final class PersonBuffer extends AbstractDataBuffer<Person> {
    private final zzd<PersonEntity> zzaJw;

    public PersonBuffer(DataHolder dataHolder) {
        super(dataHolder);
        this.zzaJw = (dataHolder.zznb() == null || !dataHolder.zznb().getBoolean("com.google.android.gms.plus.IsSafeParcelable", false)) ? null : new zzd<>(dataHolder, PersonEntity.CREATOR);
    }

    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    public Person get(int i) {
        return this.zzaJw != null ? this.zzaJw.get(i) : new zzk(this.zzWu, i);
    }
}
