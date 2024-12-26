package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;

/* loaded from: classes.dex */
public final class AppContentConditionEntity implements SafeParcelable, AppContentCondition {
    public static final AppContentConditionEntityCreator CREATOR = new AppContentConditionEntityCreator();
    private final int zzCY;
    private final String zzaoA;
    private final String zzaoB;
    private final Bundle zzaoC;
    private final String zzaoz;

    AppContentConditionEntity(int i, String str, String str2, String str3, Bundle bundle) {
        this.zzCY = i;
        this.zzaoz = str;
        this.zzaoA = str2;
        this.zzaoB = str3;
        this.zzaoC = bundle;
    }

    public AppContentConditionEntity(AppContentCondition appContentCondition) {
        this.zzCY = 1;
        this.zzaoz = appContentCondition.zzse();
        this.zzaoA = appContentCondition.zzsf();
        this.zzaoB = appContentCondition.zzsg();
        this.zzaoC = appContentCondition.zzsh();
    }

    static int zza(AppContentCondition appContentCondition) {
        return zzt.hashCode(appContentCondition.zzse(), appContentCondition.zzsf(), appContentCondition.zzsg(), appContentCondition.zzsh());
    }

    static boolean zza(AppContentCondition appContentCondition, Object obj) {
        if (!(obj instanceof AppContentCondition)) {
            return false;
        }
        if (appContentCondition == obj) {
            return true;
        }
        AppContentCondition appContentCondition2 = (AppContentCondition) obj;
        return zzt.equal(appContentCondition2.zzse(), appContentCondition.zzse()) && zzt.equal(appContentCondition2.zzsf(), appContentCondition.zzsf()) && zzt.equal(appContentCondition2.zzsg(), appContentCondition.zzsg()) && zzt.equal(appContentCondition2.zzsh(), appContentCondition.zzsh());
    }

    static String zzb(AppContentCondition appContentCondition) {
        return zzt.zzt(appContentCondition).zzg("DefaultValue", appContentCondition.zzse()).zzg("ExpectedValue", appContentCondition.zzsf()).zzg("Predicate", appContentCondition.zzsg()).zzg("PredicateParameters", appContentCondition.zzsh()).toString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
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
        AppContentConditionEntityCreator.zza(this, parcel, i);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCondition
    public String zzse() {
        return this.zzaoz;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCondition
    public String zzsf() {
        return this.zzaoA;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCondition
    public String zzsg() {
        return this.zzaoB;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCondition
    public Bundle zzsh() {
        return this.zzaoC;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: zzsi, reason: merged with bridge method [inline-methods] */
    public AppContentCondition freeze() {
        return this;
    }
}
