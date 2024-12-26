package com.google.android.gms.location.places.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* loaded from: classes.dex */
public final class PlaceImpl implements SafeParcelable, Place {
    public static final zzk CREATOR = new zzk();
    private final String mName;
    final int zzCY;
    private final String zzKI;
    private final long zzaAA;
    private final List<Integer> zzaAB;
    private final String zzaAC;
    private final List<String> zzaAD;
    final boolean zzaAE;
    private final Map<Integer, String> zzaAF;
    private final TimeZone zzaAG;
    private zzo zzaAH;
    private Locale zzaAm;
    private final Bundle zzaAs;

    @Deprecated
    private final PlaceLocalization zzaAt;
    private final float zzaAu;
    private final LatLngBounds zzaAv;
    private final String zzaAw;
    private final boolean zzaAx;
    private final float zzaAy;
    private final int zzaAz;
    private final String zzajO;
    private final LatLng zzazn;
    private final List<Integer> zzazo;
    private final String zzazp;
    private final Uri zzazq;

    public static class zza {
        private String mName;
        private int zzCY = 0;
        private String zzKI;
        private long zzaAA;
        private String zzaAC;
        private List<String> zzaAD;
        private boolean zzaAE;
        private Bundle zzaAI;
        private List<Integer> zzaAJ;
        private float zzaAu;
        private LatLngBounds zzaAv;
        private String zzaAw;
        private boolean zzaAx;
        private float zzaAy;
        private int zzaAz;
        private String zzajO;
        private LatLng zzazn;
        private String zzazp;
        private Uri zzazq;

        public zza zza(LatLng latLng) {
            this.zzazn = latLng;
            return this;
        }

        public zza zza(LatLngBounds latLngBounds) {
            this.zzaAv = latLngBounds;
            return this;
        }

        public zza zzad(boolean z) {
            this.zzaAx = z;
            return this;
        }

        public zza zzae(boolean z) {
            this.zzaAE = z;
            return this;
        }

        public zza zzdq(String str) {
            this.zzKI = str;
            return this;
        }

        public zza zzdr(String str) {
            this.mName = str;
            return this;
        }

        public zza zzds(String str) {
            this.zzajO = str;
            return this;
        }

        public zza zzdt(String str) {
            this.zzazp = str;
            return this;
        }

        public zza zzf(float f) {
            this.zzaAu = f;
            return this;
        }

        public zza zzg(float f) {
            this.zzaAy = f;
            return this;
        }

        public zza zzgX(int i) {
            this.zzaAz = i;
            return this;
        }

        public zza zzk(Uri uri) {
            this.zzazq = uri;
            return this;
        }

        public zza zzm(List<Integer> list) {
            this.zzaAJ = list;
            return this;
        }

        public zza zzn(List<String> list) {
            this.zzaAD = list;
            return this;
        }

        public PlaceImpl zzuX() {
            return new PlaceImpl(this.zzCY, this.zzKI, this.zzaAJ, Collections.emptyList(), this.zzaAI, this.mName, this.zzajO, this.zzazp, this.zzaAC, this.zzaAD, this.zzazn, this.zzaAu, this.zzaAv, this.zzaAw, this.zzazq, this.zzaAx, this.zzaAy, this.zzaAz, this.zzaAA, this.zzaAE, PlaceLocalization.zza(this.mName, this.zzajO, this.zzazp, this.zzaAC, this.zzaAD));
        }
    }

    PlaceImpl(int i, String str, List<Integer> list, List<Integer> list2, Bundle bundle, String str2, String str3, String str4, String str5, List<String> list3, LatLng latLng, float f, LatLngBounds latLngBounds, String str6, Uri uri, boolean z, float f2, int i2, long j, boolean z2, PlaceLocalization placeLocalization) {
        this.zzCY = i;
        this.zzKI = str;
        this.zzazo = Collections.unmodifiableList(list);
        this.zzaAB = list2;
        this.zzaAs = bundle != null ? bundle : new Bundle();
        this.mName = str2;
        this.zzajO = str3;
        this.zzazp = str4;
        this.zzaAC = str5;
        this.zzaAD = list3 != null ? list3 : Collections.emptyList();
        this.zzazn = latLng;
        this.zzaAu = f;
        this.zzaAv = latLngBounds;
        this.zzaAw = str6 != null ? str6 : "UTC";
        this.zzazq = uri;
        this.zzaAx = z;
        this.zzaAy = f2;
        this.zzaAz = i2;
        this.zzaAA = j;
        this.zzaAF = Collections.unmodifiableMap(new HashMap());
        this.zzaAG = null;
        this.zzaAm = null;
        this.zzaAE = z2;
        this.zzaAt = placeLocalization;
    }

    private void zzdp(String str) {
        if (!this.zzaAE || this.zzaAH == null) {
            return;
        }
        this.zzaAH.zzA(this.zzKI, str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlaceImpl)) {
            return false;
        }
        PlaceImpl placeImpl = (PlaceImpl) obj;
        return this.zzKI.equals(placeImpl.zzKI) && com.google.android.gms.common.internal.zzt.equal(this.zzaAm, placeImpl.zzaAm) && this.zzaAA == placeImpl.zzaAA;
    }

    @Override // com.google.android.gms.location.places.Place
    public String getAddress() {
        zzdp("getAddress");
        return this.zzajO;
    }

    @Override // com.google.android.gms.location.places.Place
    public String getId() {
        zzdp("getId");
        return this.zzKI;
    }

    @Override // com.google.android.gms.location.places.Place
    public LatLng getLatLng() {
        zzdp("getLatLng");
        return this.zzazn;
    }

    @Override // com.google.android.gms.location.places.Place
    public Locale getLocale() {
        zzdp("getLocale");
        return this.zzaAm;
    }

    @Override // com.google.android.gms.location.places.Place
    public String getName() {
        zzdp("getName");
        return this.mName;
    }

    @Override // com.google.android.gms.location.places.Place
    public String getPhoneNumber() {
        zzdp("getPhoneNumber");
        return this.zzazp;
    }

    @Override // com.google.android.gms.location.places.Place
    public List<Integer> getPlaceTypes() {
        zzdp("getPlaceTypes");
        return this.zzazo;
    }

    @Override // com.google.android.gms.location.places.Place
    public int getPriceLevel() {
        zzdp("getPriceLevel");
        return this.zzaAz;
    }

    @Override // com.google.android.gms.location.places.Place
    public float getRating() {
        zzdp("getRating");
        return this.zzaAy;
    }

    @Override // com.google.android.gms.location.places.Place
    public LatLngBounds getViewport() {
        zzdp("getViewport");
        return this.zzaAv;
    }

    @Override // com.google.android.gms.location.places.Place
    public Uri getWebsiteUri() {
        zzdp("getWebsiteUri");
        return this.zzazq;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.zzt.hashCode(this.zzKI, this.zzaAm, Long.valueOf(this.zzaAA));
    }

    @Override // com.google.android.gms.common.data.Freezable
    public boolean isDataValid() {
        return true;
    }

    public void setLocale(Locale locale) {
        this.zzaAm = locale;
    }

    public String toString() {
        return com.google.android.gms.common.internal.zzt.zzt(this).zzg("id", this.zzKI).zzg("placeTypes", this.zzazo).zzg("locale", this.zzaAm).zzg("name", this.mName).zzg("address", this.zzajO).zzg("phoneNumber", this.zzazp).zzg("latlng", this.zzazn).zzg("viewport", this.zzaAv).zzg("websiteUri", this.zzazq).zzg("isPermanentlyClosed", Boolean.valueOf(this.zzaAx)).zzg("priceLevel", Integer.valueOf(this.zzaAz)).zzg("timestampSecs", Long.valueOf(this.zzaAA)).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzk.zza(this, parcel, i);
    }

    public void zza(zzo zzoVar) {
        this.zzaAH = zzoVar;
    }

    public List<Integer> zzuN() {
        zzdp("getTypesDeprecated");
        return this.zzaAB;
    }

    public float zzuO() {
        zzdp("getLevelNumber");
        return this.zzaAu;
    }

    public String zzuP() {
        zzdp("getRegularOpenHours");
        return this.zzaAC;
    }

    public List<String> zzuQ() {
        zzdp("getAttributions");
        return this.zzaAD;
    }

    public boolean zzuR() {
        zzdp("isPermanentlyClosed");
        return this.zzaAx;
    }

    public long zzuS() {
        return this.zzaAA;
    }

    public Bundle zzuT() {
        return this.zzaAs;
    }

    public String zzuU() {
        return this.zzaAw;
    }

    @Deprecated
    public PlaceLocalization zzuV() {
        zzdp("getLocalization");
        return this.zzaAt;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: zzuW, reason: merged with bridge method [inline-methods] */
    public Place freeze() {
        return this;
    }
}
