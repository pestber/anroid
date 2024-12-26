package com.google.android.gms.location.places;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class AddPlaceRequest implements SafeParcelable {
    public static final Parcelable.Creator<AddPlaceRequest> CREATOR = new zzb();
    private final String mName;
    final int zzCY;
    private final String zzajO;
    private final LatLng zzazn;
    private final List<Integer> zzazo;
    private final String zzazp;
    private final Uri zzazq;

    AddPlaceRequest(int i, String str, LatLng latLng, String str2, List<Integer> list, String str3, Uri uri) {
        this.zzCY = i;
        this.mName = zzu.zzcj(str);
        this.zzazn = (LatLng) zzu.zzu(latLng);
        this.zzajO = str2;
        this.zzazo = new ArrayList(list);
        zzu.zzb((TextUtils.isEmpty(str3) && uri == null) ? false : true, "One of phone number or URI should be provided.");
        this.zzazp = str3;
        this.zzazq = uri;
    }

    public AddPlaceRequest(String str, LatLng latLng, String str2, List<Integer> list, Uri uri) {
        this(str, latLng, str2, list, null, (Uri) zzu.zzu(uri));
    }

    public AddPlaceRequest(String str, LatLng latLng, String str2, List<Integer> list, String str3) {
        this(str, latLng, str2, list, zzu.zzcj(str3), null);
    }

    public AddPlaceRequest(String str, LatLng latLng, String str2, List<Integer> list, String str3, Uri uri) {
        this(0, str, latLng, str2, list, str3, uri);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAddress() {
        return this.zzajO;
    }

    public LatLng getLatLng() {
        return this.zzazn;
    }

    public String getName() {
        return this.mName;
    }

    public String getPhoneNumber() {
        return this.zzazp;
    }

    public List<Integer> getPlaceTypes() {
        return this.zzazo;
    }

    public Uri getWebsiteUri() {
        return this.zzazq;
    }

    public String toString() {
        return zzt.zzt(this).zzg("name", this.mName).zzg("latLng", this.zzazn).zzg("address", this.zzajO).zzg("placeTypes", this.zzazo).zzg("phoneNumer", this.zzazp).zzg("websiteUri", this.zzazq).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }
}
