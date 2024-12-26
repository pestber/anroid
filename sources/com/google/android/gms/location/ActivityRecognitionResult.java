package com.google.android.gms.location;

import android.content.Intent;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class ActivityRecognitionResult implements SafeParcelable {
    public static final ActivityRecognitionResultCreator CREATOR = new ActivityRecognitionResultCreator();
    private final int zzCY;
    List<DetectedActivity> zzaxr;
    long zzaxs;
    long zzaxt;
    int zzaxu;

    public ActivityRecognitionResult(int i, List<DetectedActivity> list, long j, long j2, int i2) {
        this.zzCY = i;
        this.zzaxr = list;
        this.zzaxs = j;
        this.zzaxt = j2;
        this.zzaxu = i2;
    }

    public ActivityRecognitionResult(DetectedActivity detectedActivity, long j, long j2) {
        this(detectedActivity, j, j2, 0);
    }

    public ActivityRecognitionResult(DetectedActivity detectedActivity, long j, long j2, int i) {
        this((List<DetectedActivity>) Collections.singletonList(detectedActivity), j, j2, i);
    }

    public ActivityRecognitionResult(List<DetectedActivity> list, long j, long j2) {
        this(list, j, j2, 0);
    }

    public ActivityRecognitionResult(List<DetectedActivity> list, long j, long j2, int i) {
        zzu.zzb(list != null && list.size() > 0, "Must have at least 1 detected activity");
        zzu.zzb(j > 0 && j2 > 0, "Must set times");
        this.zzCY = 2;
        this.zzaxr = list;
        this.zzaxs = j;
        this.zzaxt = j2;
        this.zzaxu = i;
    }

    public static ActivityRecognitionResult extractResult(Intent intent) {
        if (!hasResult(intent)) {
            return null;
        }
        Object obj = intent.getExtras().get("com.google.android.location.internal.EXTRA_ACTIVITY_RESULT");
        if (!(obj instanceof byte[])) {
            if (obj instanceof ActivityRecognitionResult) {
                return (ActivityRecognitionResult) obj;
            }
            return null;
        }
        Parcel obtain = Parcel.obtain();
        byte[] bArr = (byte[]) obj;
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        return CREATOR.createFromParcel(obtain);
    }

    public static boolean hasResult(Intent intent) {
        if (intent == null) {
            return false;
        }
        return intent.hasExtra("com.google.android.location.internal.EXTRA_ACTIVITY_RESULT");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getActivityConfidence(int i) {
        for (DetectedActivity detectedActivity : this.zzaxr) {
            if (detectedActivity.getType() == i) {
                return detectedActivity.getConfidence();
            }
        }
        return 0;
    }

    public long getElapsedRealtimeMillis() {
        return this.zzaxt;
    }

    public DetectedActivity getMostProbableActivity() {
        return this.zzaxr.get(0);
    }

    public List<DetectedActivity> getProbableActivities() {
        return this.zzaxr;
    }

    public long getTime() {
        return this.zzaxs;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    public String toString() {
        return "ActivityRecognitionResult [probableActivities=" + this.zzaxr + ", timeMillis=" + this.zzaxs + ", elapsedRealtimeMillis=" + this.zzaxt + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ActivityRecognitionResultCreator.zza(this, parcel, i);
    }
}
