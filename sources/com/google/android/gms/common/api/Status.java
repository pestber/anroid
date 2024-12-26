package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;

/* loaded from: classes.dex */
public final class Status implements Result, SafeParcelable {
    private final PendingIntent mPendingIntent;
    private final int zzCY;
    private final int zzTS;
    private final String zzXU;
    public static final Status zzXP = new Status(0);
    public static final Status zzXQ = new Status(14);
    public static final Status zzXR = new Status(8);
    public static final Status zzXS = new Status(15);
    public static final Status zzXT = new Status(16);
    public static final Parcelable.Creator<Status> CREATOR = new zzk();

    public Status(int i) {
        this(i, null);
    }

    Status(int i, int i2, String str, PendingIntent pendingIntent) {
        this.zzCY = i;
        this.zzTS = i2;
        this.zzXU = str;
        this.mPendingIntent = pendingIntent;
    }

    public Status(int i, String str) {
        this(1, i, str, null);
    }

    public Status(int i, String str, PendingIntent pendingIntent) {
        this(1, i, str, pendingIntent);
    }

    private String zzmU() {
        return this.zzXU != null ? this.zzXU : CommonStatusCodes.getStatusCodeString(this.zzTS);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.zzCY == status.zzCY && this.zzTS == status.zzTS && zzt.equal(this.zzXU, status.zzXU) && zzt.equal(this.mPendingIntent, status.mPendingIntent);
    }

    public PendingIntent getResolution() {
        return this.mPendingIntent;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this;
    }

    public int getStatusCode() {
        return this.zzTS;
    }

    public String getStatusMessage() {
        return this.zzXU;
    }

    int getVersionCode() {
        return this.zzCY;
    }

    public boolean hasResolution() {
        return this.mPendingIntent != null;
    }

    public int hashCode() {
        return zzt.hashCode(Integer.valueOf(this.zzCY), Integer.valueOf(this.zzTS), this.zzXU, this.mPendingIntent);
    }

    public boolean isCanceled() {
        return this.zzTS == 16;
    }

    public boolean isInterrupted() {
        return this.zzTS == 14;
    }

    public boolean isSuccess() {
        return this.zzTS <= 0;
    }

    public void startResolutionForResult(Activity activity, int i) throws IntentSender.SendIntentException {
        if (hasResolution()) {
            activity.startIntentSenderForResult(this.mPendingIntent.getIntentSender(), i, null, 0, 0, 0);
        }
    }

    public String toString() {
        return zzt.zzt(this).zzg("statusCode", zzmU()).zzg("resolution", this.mPendingIntent).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzk.zza(this, parcel, i);
    }

    PendingIntent zzmT() {
        return this.mPendingIntent;
    }
}
