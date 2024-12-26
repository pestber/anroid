package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;

/* loaded from: classes.dex */
public final class Application implements SafeParcelable {
    private final int zzCY;
    private final String zzMZ;
    private final String zzTQ;
    private final String zzajN;
    public static final Application zzajM = new Application("com.google.android.gms", String.valueOf(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE), null);
    public static final Parcelable.Creator<Application> CREATOR = new zza();

    Application(int i, String str, String str2, String str3) {
        this.zzCY = i;
        this.zzMZ = (String) zzu.zzu(str);
        this.zzTQ = "";
        this.zzajN = str3;
    }

    public Application(String str, String str2, String str3) {
        this(1, str, "", str3);
    }

    private boolean zza(Application application) {
        return this.zzMZ.equals(application.zzMZ) && com.google.android.gms.common.internal.zzt.equal(this.zzTQ, application.zzTQ) && com.google.android.gms.common.internal.zzt.equal(this.zzajN, application.zzajN);
    }

    public static Application zzcG(String str) {
        return zze(str, null, null);
    }

    public static Application zze(String str, String str2, String str3) {
        return "com.google.android.gms".equals(str) ? zzajM : new Application(str, str2, str3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof Application) && zza((Application) obj));
    }

    public String getPackageName() {
        return this.zzMZ;
    }

    public String getVersion() {
        return this.zzTQ;
    }

    int getVersionCode() {
        return this.zzCY;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.zzt.hashCode(this.zzMZ, this.zzTQ, this.zzajN);
    }

    public String toString() {
        return String.format("Application{%s:%s:%s}", this.zzMZ, this.zzTQ, this.zzajN);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    public String zzqp() {
        return this.zzajN;
    }
}
