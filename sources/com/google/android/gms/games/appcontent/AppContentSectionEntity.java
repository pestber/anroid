package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class AppContentSectionEntity implements SafeParcelable, AppContentSection {
    public static final AppContentSectionEntityCreator CREATOR = new AppContentSectionEntityCreator();
    private final ArrayList<AppContentActionEntity> mActions;
    private final Bundle mExtras;
    private final int zzCY;
    private final String zzEl;
    private final String zzKI;
    private final String zzadv;
    private final ArrayList<AppContentCardEntity> zzaoE;
    private final String zzaoF;
    private final String zzaom;
    private final ArrayList<AppContentAnnotationEntity> zzaov;
    private final String zzaox;

    AppContentSectionEntity(int i, ArrayList<AppContentActionEntity> arrayList, ArrayList<AppContentCardEntity> arrayList2, String str, Bundle bundle, String str2, String str3, String str4, String str5, String str6, ArrayList<AppContentAnnotationEntity> arrayList3) {
        this.zzCY = i;
        this.mActions = arrayList;
        this.zzaov = arrayList3;
        this.zzaoE = arrayList2;
        this.zzaoF = str6;
        this.zzaom = str;
        this.mExtras = bundle;
        this.zzKI = str5;
        this.zzaox = str2;
        this.zzadv = str3;
        this.zzEl = str4;
    }

    public AppContentSectionEntity(AppContentSection appContentSection) {
        this.zzCY = 5;
        this.zzaoF = appContentSection.zzsk();
        this.zzaom = appContentSection.zzrP();
        this.mExtras = appContentSection.getExtras();
        this.zzKI = appContentSection.getId();
        this.zzaox = appContentSection.zzsb();
        this.zzadv = appContentSection.getTitle();
        this.zzEl = appContentSection.getType();
        List<AppContentAction> actions = appContentSection.getActions();
        int size = actions.size();
        this.mActions = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            this.mActions.add((AppContentActionEntity) actions.get(i).freeze());
        }
        List<AppContentCard> zzsj = appContentSection.zzsj();
        int size2 = zzsj.size();
        this.zzaoE = new ArrayList<>(size2);
        for (int i2 = 0; i2 < size2; i2++) {
            this.zzaoE.add((AppContentCardEntity) zzsj.get(i2).freeze());
        }
        List<AppContentAnnotation> zzrZ = appContentSection.zzrZ();
        int size3 = zzrZ.size();
        this.zzaov = new ArrayList<>(size3);
        for (int i3 = 0; i3 < size3; i3++) {
            this.zzaov.add((AppContentAnnotationEntity) zzrZ.get(i3).freeze());
        }
    }

    static int zza(AppContentSection appContentSection) {
        return zzt.hashCode(appContentSection.getActions(), appContentSection.zzrZ(), appContentSection.zzsj(), appContentSection.zzsk(), appContentSection.zzrP(), appContentSection.getExtras(), appContentSection.getId(), appContentSection.zzsb(), appContentSection.getTitle(), appContentSection.getType());
    }

    static boolean zza(AppContentSection appContentSection, Object obj) {
        if (!(obj instanceof AppContentSection)) {
            return false;
        }
        if (appContentSection == obj) {
            return true;
        }
        AppContentSection appContentSection2 = (AppContentSection) obj;
        return zzt.equal(appContentSection2.getActions(), appContentSection.getActions()) && zzt.equal(appContentSection2.zzrZ(), appContentSection.zzrZ()) && zzt.equal(appContentSection2.zzsj(), appContentSection.zzsj()) && zzt.equal(appContentSection2.zzsk(), appContentSection.zzsk()) && zzt.equal(appContentSection2.zzrP(), appContentSection.zzrP()) && zzt.equal(appContentSection2.getExtras(), appContentSection.getExtras()) && zzt.equal(appContentSection2.getId(), appContentSection.getId()) && zzt.equal(appContentSection2.zzsb(), appContentSection.zzsb()) && zzt.equal(appContentSection2.getTitle(), appContentSection.getTitle()) && zzt.equal(appContentSection2.getType(), appContentSection.getType());
    }

    static String zzb(AppContentSection appContentSection) {
        return zzt.zzt(appContentSection).zzg("Actions", appContentSection.getActions()).zzg("Annotations", appContentSection.zzrZ()).zzg("Cards", appContentSection.zzsj()).zzg("CardType", appContentSection.zzsk()).zzg("ContentDescription", appContentSection.zzrP()).zzg("Extras", appContentSection.getExtras()).zzg("Id", appContentSection.getId()).zzg("Subtitle", appContentSection.zzsb()).zzg("Title", appContentSection.getTitle()).zzg("Type", appContentSection.getType()).toString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentSection
    public List<AppContentAction> getActions() {
        return new ArrayList(this.mActions);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentSection
    public Bundle getExtras() {
        return this.mExtras;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentSection
    public String getId() {
        return this.zzKI;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentSection
    public String getTitle() {
        return this.zzadv;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentSection
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
        AppContentSectionEntityCreator.zza(this, parcel, i);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentSection
    public String zzrP() {
        return this.zzaom;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentSection
    public List<AppContentAnnotation> zzrZ() {
        return new ArrayList(this.zzaov);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentSection
    public String zzsb() {
        return this.zzaox;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentSection
    public List<AppContentCard> zzsj() {
        return new ArrayList(this.zzaoE);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentSection
    public String zzsk() {
        return this.zzaoF;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: zzsl, reason: merged with bridge method [inline-methods] */
    public AppContentSection freeze() {
        return this;
    }
}
