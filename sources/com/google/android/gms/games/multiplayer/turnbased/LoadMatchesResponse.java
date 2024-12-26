package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.constants.TurnBasedMatchTurnStatus;
import com.google.android.gms.games.multiplayer.InvitationBuffer;

/* loaded from: classes.dex */
public final class LoadMatchesResponse {
    private final InvitationBuffer zzauD;
    private final TurnBasedMatchBuffer zzauE;
    private final TurnBasedMatchBuffer zzauF;
    private final TurnBasedMatchBuffer zzauG;

    public LoadMatchesResponse(Bundle bundle) {
        DataHolder zza = zza(bundle, 0);
        if (zza != null) {
            this.zzauD = new InvitationBuffer(zza);
        } else {
            this.zzauD = null;
        }
        DataHolder zza2 = zza(bundle, 1);
        if (zza2 != null) {
            this.zzauE = new TurnBasedMatchBuffer(zza2);
        } else {
            this.zzauE = null;
        }
        DataHolder zza3 = zza(bundle, 2);
        if (zza3 != null) {
            this.zzauF = new TurnBasedMatchBuffer(zza3);
        } else {
            this.zzauF = null;
        }
        DataHolder zza4 = zza(bundle, 3);
        this.zzauG = zza4 != null ? new TurnBasedMatchBuffer(zza4) : null;
    }

    private static DataHolder zza(Bundle bundle, int i) {
        String zzfG = TurnBasedMatchTurnStatus.zzfG(i);
        if (bundle.containsKey(zzfG)) {
            return (DataHolder) bundle.getParcelable(zzfG);
        }
        return null;
    }

    @Deprecated
    public void close() {
        release();
    }

    public TurnBasedMatchBuffer getCompletedMatches() {
        return this.zzauG;
    }

    public InvitationBuffer getInvitations() {
        return this.zzauD;
    }

    public TurnBasedMatchBuffer getMyTurnMatches() {
        return this.zzauE;
    }

    public TurnBasedMatchBuffer getTheirTurnMatches() {
        return this.zzauF;
    }

    public boolean hasData() {
        if (this.zzauD != null && this.zzauD.getCount() > 0) {
            return true;
        }
        if (this.zzauE != null && this.zzauE.getCount() > 0) {
            return true;
        }
        if (this.zzauF == null || this.zzauF.getCount() <= 0) {
            return this.zzauG != null && this.zzauG.getCount() > 0;
        }
        return true;
    }

    public void release() {
        if (this.zzauD != null) {
            this.zzauD.release();
        }
        if (this.zzauE != null) {
            this.zzauE.release();
        }
        if (this.zzauF != null) {
            this.zzauF.release();
        }
        if (this.zzauG != null) {
            this.zzauG.release();
        }
    }
}
