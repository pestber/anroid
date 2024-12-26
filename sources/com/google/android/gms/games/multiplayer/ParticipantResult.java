package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.games.internal.constants.MatchResult;

/* loaded from: classes.dex */
public final class ParticipantResult implements SafeParcelable {
    public static final Parcelable.Creator<ParticipantResult> CREATOR = new ParticipantResultCreator();
    public static final int MATCH_RESULT_DISAGREED = 5;
    public static final int MATCH_RESULT_DISCONNECT = 4;
    public static final int MATCH_RESULT_LOSS = 1;
    public static final int MATCH_RESULT_NONE = 3;
    public static final int MATCH_RESULT_TIE = 2;
    public static final int MATCH_RESULT_UNINITIALIZED = -1;
    public static final int MATCH_RESULT_WIN = 0;
    public static final int PLACING_UNINITIALIZED = -1;
    private final int zzCY;
    private final String zzapO;
    private final int zzauo;
    private final int zzaup;

    public ParticipantResult(int i, String str, int i2, int i3) {
        this.zzCY = i;
        this.zzapO = (String) zzu.zzu(str);
        zzu.zzU(MatchResult.isValid(i2));
        this.zzauo = i2;
        this.zzaup = i3;
    }

    public ParticipantResult(String str, int i, int i2) {
        this(1, str, i, i2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getParticipantId() {
        return this.zzapO;
    }

    public int getPlacing() {
        return this.zzaup;
    }

    public int getResult() {
        return this.zzauo;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParticipantResultCreator.zza(this, parcel, i);
    }
}
