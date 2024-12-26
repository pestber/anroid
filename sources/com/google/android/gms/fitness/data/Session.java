package com.google.android.gms.fitness.data;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.fitness.FitnessActivities;
import com.google.android.gms.plus.PlusShare;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class Session implements SafeParcelable {
    public static final Parcelable.Creator<Session> CREATOR = new zzp();
    public static final String EXTRA_SESSION = "vnd.google.fitness.session";
    public static final String MIME_TYPE_PREFIX = "vnd.google.fitness.session/";
    private final String mName;
    private final int zzCY;
    private final long zzKT;
    private final long zzajH;
    private final int zzajR;
    private final String zzakL;
    private final String zzakM;
    private final Long zzakN;
    private final Application zzake;

    public static class Builder {
        private String zzakL;
        private String zzakM;
        private Long zzakN;
        private Application zzake;
        private long zzKT = 0;
        private long zzajH = 0;
        private String mName = null;
        private int zzajR = 4;

        public Session build() {
            boolean z = true;
            zzu.zza(this.zzKT > 0, "Start time should be specified.");
            if (this.zzajH != 0 && this.zzajH <= this.zzKT) {
                z = false;
            }
            zzu.zza(z, "End time should be later than start time.");
            if (this.zzakL == null) {
                this.zzakL = (this.mName == null ? "" : this.mName) + this.zzKT;
            }
            return new Session(this);
        }

        public Builder setActiveTime(long j, TimeUnit timeUnit) {
            this.zzakN = Long.valueOf(timeUnit.toMillis(j));
            return this;
        }

        public Builder setActivity(String str) {
            return zzeo(FitnessActivities.zzcF(str));
        }

        public Builder setDescription(String str) {
            zzu.zzb(str.length() <= 1000, "Session description cannot exceed %d characters", 1000);
            this.zzakM = str;
            return this;
        }

        public Builder setEndTime(long j, TimeUnit timeUnit) {
            zzu.zza(j >= 0, "End time should be positive.");
            this.zzajH = timeUnit.toMillis(j);
            return this;
        }

        public Builder setIdentifier(String str) {
            zzu.zzV(str != null && TextUtils.getTrimmedLength(str) > 0);
            this.zzakL = str;
            return this;
        }

        public Builder setName(String str) {
            zzu.zzb(str.length() <= 100, "Session name cannot exceed %d characters", 100);
            this.mName = str;
            return this;
        }

        public Builder setStartTime(long j, TimeUnit timeUnit) {
            zzu.zza(j > 0, "Start time should be positive.");
            this.zzKT = timeUnit.toMillis(j);
            return this;
        }

        public Builder zzeo(int i) {
            this.zzajR = i;
            return this;
        }
    }

    Session(int i, long j, long j2, String str, String str2, String str3, int i2, Application application, Long l) {
        this.zzCY = i;
        this.zzKT = j;
        this.zzajH = j2;
        this.mName = str;
        this.zzakL = str2;
        this.zzakM = str3;
        this.zzajR = i2;
        this.zzake = application;
        this.zzakN = l;
    }

    public Session(long j, long j2, String str, String str2, String str3, int i, Application application, Long l) {
        this(3, j, j2, str, str2, str3, i, application, l);
    }

    private Session(Builder builder) {
        this(builder.zzKT, builder.zzajH, builder.mName, builder.zzakL, builder.zzakM, builder.zzajR, builder.zzake, builder.zzakN);
    }

    public static Session extract(Intent intent) {
        if (intent == null) {
            return null;
        }
        return (Session) com.google.android.gms.common.internal.safeparcel.zzc.zza(intent, EXTRA_SESSION, CREATOR);
    }

    public static String getMimeType(String str) {
        return MIME_TYPE_PREFIX + str;
    }

    private boolean zza(Session session) {
        return this.zzKT == session.zzKT && this.zzajH == session.zzajH && com.google.android.gms.common.internal.zzt.equal(this.mName, session.mName) && com.google.android.gms.common.internal.zzt.equal(this.zzakL, session.zzakL) && com.google.android.gms.common.internal.zzt.equal(this.zzakM, session.zzakM) && com.google.android.gms.common.internal.zzt.equal(this.zzake, session.zzake) && this.zzajR == session.zzajR;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof Session) && zza((Session) obj));
    }

    public long getActiveTime(TimeUnit timeUnit) {
        zzu.zza(this.zzakN != null, "Active time is not set");
        return timeUnit.convert(this.zzakN.longValue(), TimeUnit.MILLISECONDS);
    }

    public String getActivity() {
        return FitnessActivities.getName(this.zzajR);
    }

    public String getAppPackageName() {
        if (this.zzake == null) {
            return null;
        }
        return this.zzake.getPackageName();
    }

    public String getDescription() {
        return this.zzakM;
    }

    public long getEndTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzajH, TimeUnit.MILLISECONDS);
    }

    public String getIdentifier() {
        return this.zzakL;
    }

    public String getName() {
        return this.mName;
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzKT, TimeUnit.MILLISECONDS);
    }

    int getVersionCode() {
        return this.zzCY;
    }

    public boolean hasActiveTime() {
        return this.zzakN != null;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.zzt.hashCode(Long.valueOf(this.zzKT), Long.valueOf(this.zzajH), this.zzakL);
    }

    public boolean isOngoing() {
        return this.zzajH == 0;
    }

    public String toString() {
        return com.google.android.gms.common.internal.zzt.zzt(this).zzg("startTime", Long.valueOf(this.zzKT)).zzg("endTime", Long.valueOf(this.zzajH)).zzg("name", this.mName).zzg("identifier", this.zzakL).zzg(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, this.zzakM).zzg("activity", Integer.valueOf(this.zzajR)).zzg("application", this.zzake).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzp.zza(this, parcel, i);
    }

    public long zzkt() {
        return this.zzKT;
    }

    public Application zzqB() {
        return this.zzake;
    }

    public Long zzqJ() {
        return this.zzakN;
    }

    public int zzqq() {
        return this.zzajR;
    }

    public long zzqs() {
        return this.zzajH;
    }
}
