package com.google.android.gms.fitness.data;

import android.content.Context;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.Settings;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.internal.zzlv;
import com.google.android.gms.internal.zzmy;

/* loaded from: classes.dex */
public final class Device implements SafeParcelable {
    public static final Parcelable.Creator<Device> CREATOR = new zzh();
    public static final int TYPE_CHEST_STRAP = 4;
    public static final int TYPE_PHONE = 1;
    public static final int TYPE_SCALE = 5;
    public static final int TYPE_TABLET = 2;
    public static final int TYPE_UNKNOWN = 0;
    public static final int TYPE_WATCH = 3;
    private final int zzCY;
    private final int zzSq;
    private final String zzTQ;
    private final String zzakr;
    private final String zzaks;
    private final String zzakt;
    private final int zzaku;

    Device(int i, String str, String str2, String str3, String str4, int i2, int i3) {
        this.zzCY = i;
        this.zzakr = (String) zzu.zzu(str);
        this.zzaks = (String) zzu.zzu(str2);
        this.zzTQ = "";
        this.zzakt = (String) zzu.zzu(str4);
        this.zzSq = i2;
        this.zzaku = i3;
    }

    public Device(String str, String str2, String str3, int i) {
        this(str, str2, "", str3, i, 0);
    }

    public Device(String str, String str2, String str3, String str4, int i, int i2) {
        this(1, str, str2, "", str4, i, i2);
    }

    public static Device getLocalDevice(Context context) {
        int zzap = zzlv.zzap(context);
        return new Device(Build.MANUFACTURER, Build.MODEL, Build.VERSION.RELEASE, zzal(context), zzap, 2);
    }

    private boolean zza(Device device) {
        return com.google.android.gms.common.internal.zzt.equal(this.zzakr, device.zzakr) && com.google.android.gms.common.internal.zzt.equal(this.zzaks, device.zzaks) && com.google.android.gms.common.internal.zzt.equal(this.zzTQ, device.zzTQ) && com.google.android.gms.common.internal.zzt.equal(this.zzakt, device.zzakt) && this.zzSq == device.zzSq && this.zzaku == device.zzaku;
    }

    private static String zzal(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), "android_id");
    }

    private boolean zzqF() {
        return zzqE() == 1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof Device) && zza((Device) obj));
    }

    public String getManufacturer() {
        return this.zzakr;
    }

    public String getModel() {
        return this.zzaks;
    }

    String getStreamIdentifier() {
        return String.format("%s:%s:%s", this.zzakr, this.zzaks, this.zzakt);
    }

    public int getType() {
        return this.zzSq;
    }

    public String getUid() {
        return this.zzakt;
    }

    public String getVersion() {
        return this.zzTQ;
    }

    int getVersionCode() {
        return this.zzCY;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.zzt.hashCode(this.zzakr, this.zzaks, this.zzTQ, this.zzakt, Integer.valueOf(this.zzSq));
    }

    public String toString() {
        return String.format("Device{%s:%s:%s:%s}", getStreamIdentifier(), this.zzTQ, Integer.valueOf(this.zzSq), Integer.valueOf(this.zzaku));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzh.zza(this, parcel, i);
    }

    public int zzqE() {
        return this.zzaku;
    }

    public String zzqG() {
        return zzqF() ? this.zzakt : zzmy.zzcL(this.zzakt);
    }
}
