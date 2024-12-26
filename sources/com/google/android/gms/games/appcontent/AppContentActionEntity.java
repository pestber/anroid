package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class AppContentActionEntity implements SafeParcelable, AppContentAction {
    public static final AppContentActionEntityCreator CREATOR = new AppContentActionEntityCreator();
    private final Bundle mExtras;
    private final int zzCY;
    private final String zzEl;
    private final String zzKI;
    private final ArrayList<AppContentConditionEntity> zzaol;
    private final String zzaom;
    private final AppContentAnnotationEntity zzaon;
    private final String zzaoo;

    AppContentActionEntity(int i, ArrayList<AppContentConditionEntity> arrayList, String str, Bundle bundle, String str2, String str3, AppContentAnnotationEntity appContentAnnotationEntity, String str4) {
        this.zzCY = i;
        this.zzaon = appContentAnnotationEntity;
        this.zzaol = arrayList;
        this.zzaom = str;
        this.mExtras = bundle;
        this.zzKI = str3;
        this.zzaoo = str4;
        this.zzEl = str2;
    }

    public AppContentActionEntity(AppContentAction appContentAction) {
        this.zzCY = 5;
        this.zzaon = (AppContentAnnotationEntity) appContentAction.zzrN().freeze();
        this.zzaom = appContentAction.zzrP();
        this.mExtras = appContentAction.getExtras();
        this.zzKI = appContentAction.getId();
        this.zzaoo = appContentAction.zzrQ();
        this.zzEl = appContentAction.getType();
        List<AppContentCondition> zzrO = appContentAction.zzrO();
        int size = zzrO.size();
        this.zzaol = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            this.zzaol.add((AppContentConditionEntity) zzrO.get(i).freeze());
        }
    }

    static int zza(AppContentAction appContentAction) {
        return zzt.hashCode(appContentAction.zzrN(), appContentAction.zzrO(), appContentAction.zzrP(), appContentAction.getExtras(), appContentAction.getId(), appContentAction.zzrQ(), appContentAction.getType());
    }

    static boolean zza(AppContentAction appContentAction, Object obj) {
        if (!(obj instanceof AppContentAction)) {
            return false;
        }
        if (appContentAction == obj) {
            return true;
        }
        AppContentAction appContentAction2 = (AppContentAction) obj;
        return zzt.equal(appContentAction2.zzrN(), appContentAction.zzrN()) && zzt.equal(appContentAction2.zzrO(), appContentAction.zzrO()) && zzt.equal(appContentAction2.zzrP(), appContentAction.zzrP()) && zzt.equal(appContentAction2.getExtras(), appContentAction.getExtras()) && zzt.equal(appContentAction2.getId(), appContentAction.getId()) && zzt.equal(appContentAction2.zzrQ(), appContentAction.zzrQ()) && zzt.equal(appContentAction2.getType(), appContentAction.getType());
    }

    static String zzb(AppContentAction appContentAction) {
        return zzt.zzt(appContentAction).zzg("Annotation", appContentAction.zzrN()).zzg("Conditions", appContentAction.zzrO()).zzg("ContentDescription", appContentAction.zzrP()).zzg("Extras", appContentAction.getExtras()).zzg("Id", appContentAction.getId()).zzg("OverflowText", appContentAction.zzrQ()).zzg("Type", appContentAction.getType()).toString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAction
    public Bundle getExtras() {
        return this.mExtras;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAction
    public String getId() {
        return this.zzKI;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAction
    public String getType() {
        return this.zzEl;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    public int hashCode() {
        return zza(this);
    }

    @Override // com.google.android.gms.common.data.Freezable
    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzb(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        AppContentActionEntityCreator.zza(this, parcel, i);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAction
    public AppContentAnnotation zzrN() {
        return this.zzaon;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAction
    public List<AppContentCondition> zzrO() {
        return new ArrayList(this.zzaol);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAction
    public String zzrP() {
        return this.zzaom;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAction
    public String zzrQ() {
        return this.zzaoo;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: zzrR, reason: merged with bridge method [inline-methods] */
    public AppContentAction freeze() {
        return this;
    }
}
