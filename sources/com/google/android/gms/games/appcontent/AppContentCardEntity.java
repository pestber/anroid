package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class AppContentCardEntity implements SafeParcelable, AppContentCard {
    public static final AppContentCardEntityCreator CREATOR = new AppContentCardEntityCreator();
    private final ArrayList<AppContentActionEntity> mActions;
    private final Bundle mExtras;
    private final int zzCY;
    private final String zzEl;
    private final String zzKI;
    private final String zzadv;
    private final String zzakM;
    private final ArrayList<AppContentConditionEntity> zzaol;
    private final String zzaom;
    private final ArrayList<AppContentAnnotationEntity> zzaov;
    private final int zzaow;
    private final String zzaox;
    private final int zzaoy;

    AppContentCardEntity(int i, ArrayList<AppContentActionEntity> arrayList, ArrayList<AppContentAnnotationEntity> arrayList2, ArrayList<AppContentConditionEntity> arrayList3, String str, int i2, String str2, Bundle bundle, String str3, String str4, int i3, String str5, String str6) {
        this.zzCY = i;
        this.mActions = arrayList;
        this.zzaov = arrayList2;
        this.zzaol = arrayList3;
        this.zzaom = str;
        this.zzaow = i2;
        this.zzakM = str2;
        this.mExtras = bundle;
        this.zzKI = str6;
        this.zzaox = str3;
        this.zzadv = str4;
        this.zzaoy = i3;
        this.zzEl = str5;
    }

    public AppContentCardEntity(AppContentCard appContentCard) {
        this.zzCY = 4;
        this.zzaom = appContentCard.zzrP();
        this.zzaow = appContentCard.zzsa();
        this.zzakM = appContentCard.getDescription();
        this.mExtras = appContentCard.getExtras();
        this.zzKI = appContentCard.getId();
        this.zzadv = appContentCard.getTitle();
        this.zzaox = appContentCard.zzsb();
        this.zzaoy = appContentCard.zzsc();
        this.zzEl = appContentCard.getType();
        List<AppContentAction> actions = appContentCard.getActions();
        int size = actions.size();
        this.mActions = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            this.mActions.add((AppContentActionEntity) actions.get(i).freeze());
        }
        List<AppContentAnnotation> zzrZ = appContentCard.zzrZ();
        int size2 = zzrZ.size();
        this.zzaov = new ArrayList<>(size2);
        for (int i2 = 0; i2 < size2; i2++) {
            this.zzaov.add((AppContentAnnotationEntity) zzrZ.get(i2).freeze());
        }
        List<AppContentCondition> zzrO = appContentCard.zzrO();
        int size3 = zzrO.size();
        this.zzaol = new ArrayList<>(size3);
        for (int i3 = 0; i3 < size3; i3++) {
            this.zzaol.add((AppContentConditionEntity) zzrO.get(i3).freeze());
        }
    }

    static int zza(AppContentCard appContentCard) {
        return zzt.hashCode(appContentCard.getActions(), appContentCard.zzrZ(), appContentCard.zzrO(), appContentCard.zzrP(), Integer.valueOf(appContentCard.zzsa()), appContentCard.getDescription(), appContentCard.getExtras(), appContentCard.getId(), appContentCard.zzsb(), appContentCard.getTitle(), Integer.valueOf(appContentCard.zzsc()), appContentCard.getType());
    }

    static boolean zza(AppContentCard appContentCard, Object obj) {
        if (!(obj instanceof AppContentCard)) {
            return false;
        }
        if (appContentCard == obj) {
            return true;
        }
        AppContentCard appContentCard2 = (AppContentCard) obj;
        return zzt.equal(appContentCard2.getActions(), appContentCard.getActions()) && zzt.equal(appContentCard2.zzrZ(), appContentCard.zzrZ()) && zzt.equal(appContentCard2.zzrO(), appContentCard.zzrO()) && zzt.equal(appContentCard2.zzrP(), appContentCard.zzrP()) && zzt.equal(Integer.valueOf(appContentCard2.zzsa()), Integer.valueOf(appContentCard.zzsa())) && zzt.equal(appContentCard2.getDescription(), appContentCard.getDescription()) && zzt.equal(appContentCard2.getExtras(), appContentCard.getExtras()) && zzt.equal(appContentCard2.getId(), appContentCard.getId()) && zzt.equal(appContentCard2.zzsb(), appContentCard.zzsb()) && zzt.equal(appContentCard2.getTitle(), appContentCard.getTitle()) && zzt.equal(Integer.valueOf(appContentCard2.zzsc()), Integer.valueOf(appContentCard.zzsc())) && zzt.equal(appContentCard2.getType(), appContentCard.getType());
    }

    static String zzb(AppContentCard appContentCard) {
        return zzt.zzt(appContentCard).zzg("Actions", appContentCard.getActions()).zzg("Annotations", appContentCard.zzrZ()).zzg("Conditions", appContentCard.zzrO()).zzg("ContentDescription", appContentCard.zzrP()).zzg("CurrentSteps", Integer.valueOf(appContentCard.zzsa())).zzg("Description", appContentCard.getDescription()).zzg("Extras", appContentCard.getExtras()).zzg("Id", appContentCard.getId()).zzg("Subtitle", appContentCard.zzsb()).zzg("Title", appContentCard.getTitle()).zzg("TotalSteps", Integer.valueOf(appContentCard.zzsc())).zzg("Type", appContentCard.getType()).toString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public List<AppContentAction> getActions() {
        return new ArrayList(this.mActions);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public String getDescription() {
        return this.zzakM;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public Bundle getExtras() {
        return this.mExtras;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public String getId() {
        return this.zzKI;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public String getTitle() {
        return this.zzadv;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
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
        AppContentCardEntityCreator.zza(this, parcel, i);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public List<AppContentCondition> zzrO() {
        return new ArrayList(this.zzaol);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public String zzrP() {
        return this.zzaom;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public List<AppContentAnnotation> zzrZ() {
        return new ArrayList(this.zzaov);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public int zzsa() {
        return this.zzaow;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public String zzsb() {
        return this.zzaox;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public int zzsc() {
        return this.zzaoy;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: zzsd, reason: merged with bridge method [inline-methods] */
    public AppContentCard freeze() {
        return this;
    }
}
