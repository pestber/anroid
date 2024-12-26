package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;

/* loaded from: classes.dex */
public final class AppContentAnnotationEntity implements SafeParcelable, AppContentAnnotation {
    public static final AppContentAnnotationEntityCreator CREATOR = new AppContentAnnotationEntityCreator();
    private final int zzCY;
    private final String zzKI;
    private final String zzadv;
    private final String zzakM;
    private final Uri zzaop;
    private final String zzaoq;
    private final String zzaor;
    private final int zzaos;
    private final int zzaot;
    private final Bundle zzaou;

    AppContentAnnotationEntity(int i, String str, Uri uri, String str2, String str3, String str4, String str5, int i2, int i3, Bundle bundle) {
        this.zzCY = i;
        this.zzakM = str;
        this.zzKI = str3;
        this.zzaor = str5;
        this.zzaos = i2;
        this.zzaop = uri;
        this.zzaot = i3;
        this.zzaoq = str4;
        this.zzaou = bundle;
        this.zzadv = str2;
    }

    public AppContentAnnotationEntity(AppContentAnnotation appContentAnnotation) {
        this.zzCY = 4;
        this.zzakM = appContentAnnotation.getDescription();
        this.zzKI = appContentAnnotation.getId();
        this.zzaor = appContentAnnotation.zzrS();
        this.zzaos = appContentAnnotation.zzrT();
        this.zzaop = appContentAnnotation.zzrU();
        this.zzaot = appContentAnnotation.zzrW();
        this.zzaoq = appContentAnnotation.zzrX();
        this.zzaou = appContentAnnotation.zzrV();
        this.zzadv = appContentAnnotation.getTitle();
    }

    static int zza(AppContentAnnotation appContentAnnotation) {
        return zzt.hashCode(appContentAnnotation.getDescription(), appContentAnnotation.getId(), appContentAnnotation.zzrS(), Integer.valueOf(appContentAnnotation.zzrT()), appContentAnnotation.zzrU(), Integer.valueOf(appContentAnnotation.zzrW()), appContentAnnotation.zzrX(), appContentAnnotation.zzrV(), appContentAnnotation.getTitle());
    }

    static boolean zza(AppContentAnnotation appContentAnnotation, Object obj) {
        if (!(obj instanceof AppContentAnnotation)) {
            return false;
        }
        if (appContentAnnotation == obj) {
            return true;
        }
        AppContentAnnotation appContentAnnotation2 = (AppContentAnnotation) obj;
        return zzt.equal(appContentAnnotation2.getDescription(), appContentAnnotation.getDescription()) && zzt.equal(appContentAnnotation2.getId(), appContentAnnotation.getId()) && zzt.equal(appContentAnnotation2.zzrS(), appContentAnnotation.zzrS()) && zzt.equal(Integer.valueOf(appContentAnnotation2.zzrT()), Integer.valueOf(appContentAnnotation.zzrT())) && zzt.equal(appContentAnnotation2.zzrU(), appContentAnnotation.zzrU()) && zzt.equal(Integer.valueOf(appContentAnnotation2.zzrW()), Integer.valueOf(appContentAnnotation.zzrW())) && zzt.equal(appContentAnnotation2.zzrX(), appContentAnnotation.zzrX()) && zzt.equal(appContentAnnotation2.zzrV(), appContentAnnotation.zzrV()) && zzt.equal(appContentAnnotation2.getTitle(), appContentAnnotation.getTitle());
    }

    static String zzb(AppContentAnnotation appContentAnnotation) {
        return zzt.zzt(appContentAnnotation).zzg("Description", appContentAnnotation.getDescription()).zzg("Id", appContentAnnotation.getId()).zzg("ImageDefaultId", appContentAnnotation.zzrS()).zzg("ImageHeight", Integer.valueOf(appContentAnnotation.zzrT())).zzg("ImageUri", appContentAnnotation.zzrU()).zzg("ImageWidth", Integer.valueOf(appContentAnnotation.zzrW())).zzg("LayoutSlot", appContentAnnotation.zzrX()).zzg("Modifiers", appContentAnnotation.zzrV()).zzg("Title", appContentAnnotation.getTitle()).toString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAnnotation
    public String getDescription() {
        return this.zzakM;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAnnotation
    public String getId() {
        return this.zzKI;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAnnotation
    public String getTitle() {
        return this.zzadv;
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
        AppContentAnnotationEntityCreator.zza(this, parcel, i);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAnnotation
    public String zzrS() {
        return this.zzaor;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAnnotation
    public int zzrT() {
        return this.zzaos;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAnnotation
    public Uri zzrU() {
        return this.zzaop;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAnnotation
    public Bundle zzrV() {
        return this.zzaou;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAnnotation
    public int zzrW() {
        return this.zzaot;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAnnotation
    public String zzrX() {
        return this.zzaoq;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: zzrY, reason: merged with bridge method [inline-methods] */
    public AppContentAnnotation freeze() {
        return this;
    }
}
