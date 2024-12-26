package com.google.android.gms.location.places.personalized;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.plus.PlusShare;
import java.util.List;

/* loaded from: classes.dex */
public class HereContent implements SafeParcelable {
    public static final zzb CREATOR = new zzb();
    final int zzCY;
    private final String zzaBe;
    private final List<Action> zzaBf;

    public static final class Action implements SafeParcelable {
        public static final zza CREATOR = new zza();
        final int zzCY;
        private final String zzNb;
        private final String zzadv;

        Action(int i, String str, String str2) {
            this.zzCY = i;
            this.zzadv = str;
            this.zzNb = str2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Action)) {
                return false;
            }
            Action action = (Action) obj;
            return zzt.equal(this.zzadv, action.zzadv) && zzt.equal(this.zzNb, action.zzNb);
        }

        public String getTitle() {
            return this.zzadv;
        }

        public String getUri() {
            return this.zzNb;
        }

        public int hashCode() {
            return zzt.hashCode(this.zzadv, this.zzNb);
        }

        public String toString() {
            return zzt.zzt(this).zzg(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, this.zzadv).zzg("uri", this.zzNb).toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            zza.zza(this, parcel, i);
        }
    }

    HereContent(int i, String str, List<Action> list) {
        this.zzCY = i;
        this.zzaBe = str;
        this.zzaBf = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HereContent)) {
            return false;
        }
        HereContent hereContent = (HereContent) obj;
        return zzt.equal(this.zzaBe, hereContent.zzaBe) && zzt.equal(this.zzaBf, hereContent.zzaBf);
    }

    public List<Action> getActions() {
        return this.zzaBf;
    }

    public String getData() {
        return this.zzaBe;
    }

    public int hashCode() {
        return zzt.hashCode(this.zzaBe, this.zzaBf);
    }

    public String toString() {
        return zzt.zzt(this).zzg("data", this.zzaBe).zzg("actions", this.zzaBf).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }
}
