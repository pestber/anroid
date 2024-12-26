package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.games.multiplayer.Multiplayer;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class TurnBasedMatchConfig {

    public static final class Builder {
        int zzauH;
        int zzaui;
        ArrayList<String> zzaux;
        Bundle zzauy;

        private Builder() {
            this.zzaui = -1;
            this.zzaux = new ArrayList<>();
            this.zzauy = null;
            this.zzauH = 2;
        }

        public Builder addInvitedPlayer(String str) {
            zzu.zzu(str);
            this.zzaux.add(str);
            return this;
        }

        public Builder addInvitedPlayers(ArrayList<String> arrayList) {
            zzu.zzu(arrayList);
            this.zzaux.addAll(arrayList);
            return this;
        }

        public TurnBasedMatchConfig build() {
            return new TurnBasedMatchConfigImpl(this);
        }

        public Builder setAutoMatchCriteria(Bundle bundle) {
            this.zzauy = bundle;
            return this;
        }

        public Builder setVariant(int i) {
            zzu.zzb(i == -1 || i > 0, "Variant must be a positive integer or TurnBasedMatch.MATCH_VARIANT_ANY");
            this.zzaui = i;
            return this;
        }
    }

    protected TurnBasedMatchConfig() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Bundle createAutoMatchCriteria(int i, int i2, long j) {
        Bundle bundle = new Bundle();
        bundle.putInt(Multiplayer.EXTRA_MIN_AUTOMATCH_PLAYERS, i);
        bundle.putInt(Multiplayer.EXTRA_MAX_AUTOMATCH_PLAYERS, i2);
        bundle.putLong(Multiplayer.EXTRA_EXCLUSIVE_BIT_MASK, j);
        return bundle;
    }

    public abstract Bundle getAutoMatchCriteria();

    public abstract String[] getInvitedPlayerIds();

    public abstract int getVariant();

    public abstract int zztL();
}
