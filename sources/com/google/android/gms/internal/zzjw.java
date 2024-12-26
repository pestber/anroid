package com.google.android.gms.internal;

import com.google.android.gms.cast.games.GameManagerState;
import com.google.android.gms.cast.games.PlayerInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzjw implements GameManagerState {
    private final String zzTO;
    private final int zzTP;
    private final int zzTU;
    private final int zzTV;
    private final JSONObject zzTX;
    private final String zzTY;
    private final Map<String, PlayerInfo> zzUa;

    public zzjw(int i, int i2, String str, JSONObject jSONObject, Collection<PlayerInfo> collection, String str2, int i3) {
        this.zzTV = i;
        this.zzTU = i2;
        this.zzTY = str;
        this.zzTX = jSONObject;
        this.zzTO = str2;
        this.zzTP = i3;
        this.zzUa = new HashMap(collection.size());
        for (PlayerInfo playerInfo : collection) {
            this.zzUa.put(playerInfo.getPlayerId(), playerInfo);
        }
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof GameManagerState)) {
            return false;
        }
        GameManagerState gameManagerState = (GameManagerState) obj;
        if (getPlayers().size() != gameManagerState.getPlayers().size()) {
            return false;
        }
        for (PlayerInfo playerInfo : getPlayers()) {
            boolean z = false;
            for (PlayerInfo playerInfo2 : gameManagerState.getPlayers()) {
                if (com.google.android.gms.cast.internal.zzf.zza(playerInfo.getPlayerId(), playerInfo2.getPlayerId())) {
                    if (!com.google.android.gms.cast.internal.zzf.zza(playerInfo, playerInfo2)) {
                        return false;
                    }
                    z = true;
                }
            }
            if (!z) {
                return false;
            }
        }
        return this.zzTV == gameManagerState.getLobbyState() && this.zzTU == gameManagerState.getGameplayState() && this.zzTP == gameManagerState.getMaxPlayers() && com.google.android.gms.cast.internal.zzf.zza(this.zzTO, gameManagerState.getApplicationName()) && com.google.android.gms.cast.internal.zzf.zza(this.zzTY, gameManagerState.getGameStatusText()) && zzlh.zzd(this.zzTX, gameManagerState.getGameData());
    }

    @Override // com.google.android.gms.cast.games.GameManagerState
    public CharSequence getApplicationName() {
        return this.zzTO;
    }

    @Override // com.google.android.gms.cast.games.GameManagerState
    public List<PlayerInfo> getConnectedControllablePlayers() {
        ArrayList arrayList = new ArrayList();
        for (PlayerInfo playerInfo : getPlayers()) {
            if (playerInfo.isConnected() && playerInfo.isControllable()) {
                arrayList.add(playerInfo);
            }
        }
        return arrayList;
    }

    @Override // com.google.android.gms.cast.games.GameManagerState
    public List<PlayerInfo> getConnectedPlayers() {
        ArrayList arrayList = new ArrayList();
        for (PlayerInfo playerInfo : getPlayers()) {
            if (playerInfo.isConnected()) {
                arrayList.add(playerInfo);
            }
        }
        return arrayList;
    }

    @Override // com.google.android.gms.cast.games.GameManagerState
    public List<PlayerInfo> getControllablePlayers() {
        ArrayList arrayList = new ArrayList();
        for (PlayerInfo playerInfo : getPlayers()) {
            if (playerInfo.isControllable()) {
                arrayList.add(playerInfo);
            }
        }
        return arrayList;
    }

    @Override // com.google.android.gms.cast.games.GameManagerState
    public JSONObject getGameData() {
        return this.zzTX;
    }

    @Override // com.google.android.gms.cast.games.GameManagerState
    public CharSequence getGameStatusText() {
        return this.zzTY;
    }

    @Override // com.google.android.gms.cast.games.GameManagerState
    public int getGameplayState() {
        return this.zzTU;
    }

    @Override // com.google.android.gms.cast.games.GameManagerState
    public Collection<String> getListOfChangedPlayers(GameManagerState gameManagerState) {
        HashSet hashSet = new HashSet();
        for (PlayerInfo playerInfo : getPlayers()) {
            PlayerInfo player = gameManagerState.getPlayer(playerInfo.getPlayerId());
            if (player == null || !playerInfo.equals(player)) {
                hashSet.add(playerInfo.getPlayerId());
            }
        }
        for (PlayerInfo playerInfo2 : gameManagerState.getPlayers()) {
            if (getPlayer(playerInfo2.getPlayerId()) == null) {
                hashSet.add(playerInfo2.getPlayerId());
            }
        }
        return hashSet;
    }

    @Override // com.google.android.gms.cast.games.GameManagerState
    public int getLobbyState() {
        return this.zzTV;
    }

    @Override // com.google.android.gms.cast.games.GameManagerState
    public int getMaxPlayers() {
        return this.zzTP;
    }

    @Override // com.google.android.gms.cast.games.GameManagerState
    public PlayerInfo getPlayer(String str) {
        if (str == null) {
            return null;
        }
        return this.zzUa.get(str);
    }

    @Override // com.google.android.gms.cast.games.GameManagerState
    public Collection<PlayerInfo> getPlayers() {
        return Collections.unmodifiableCollection(this.zzUa.values());
    }

    @Override // com.google.android.gms.cast.games.GameManagerState
    public List<PlayerInfo> getPlayersInState(int i) {
        ArrayList arrayList = new ArrayList();
        for (PlayerInfo playerInfo : getPlayers()) {
            if (playerInfo.getPlayerState() == i) {
                arrayList.add(playerInfo);
            }
        }
        return arrayList;
    }

    @Override // com.google.android.gms.cast.games.GameManagerState
    public boolean hasGameDataChanged(GameManagerState gameManagerState) {
        return !zzlh.zzd(this.zzTX, gameManagerState.getGameData());
    }

    @Override // com.google.android.gms.cast.games.GameManagerState
    public boolean hasGameStatusTextChanged(GameManagerState gameManagerState) {
        return !com.google.android.gms.cast.internal.zzf.zza(this.zzTY, gameManagerState.getGameStatusText());
    }

    @Override // com.google.android.gms.cast.games.GameManagerState
    public boolean hasGameplayStateChanged(GameManagerState gameManagerState) {
        return this.zzTU != gameManagerState.getGameplayState();
    }

    @Override // com.google.android.gms.cast.games.GameManagerState
    public boolean hasLobbyStateChanged(GameManagerState gameManagerState) {
        return this.zzTV != gameManagerState.getLobbyState();
    }

    @Override // com.google.android.gms.cast.games.GameManagerState
    public boolean hasPlayerChanged(String str, GameManagerState gameManagerState) {
        return !com.google.android.gms.cast.internal.zzf.zza(getPlayer(str), gameManagerState.getPlayer(str));
    }

    @Override // com.google.android.gms.cast.games.GameManagerState
    public boolean hasPlayerDataChanged(String str, GameManagerState gameManagerState) {
        PlayerInfo player = getPlayer(str);
        PlayerInfo player2 = gameManagerState.getPlayer(str);
        if (player == null && player2 == null) {
            return false;
        }
        if (player == null || player2 == null) {
            return true;
        }
        return !zzlh.zzd(player.getPlayerData(), player2.getPlayerData());
    }

    @Override // com.google.android.gms.cast.games.GameManagerState
    public boolean hasPlayerStateChanged(String str, GameManagerState gameManagerState) {
        PlayerInfo player = getPlayer(str);
        PlayerInfo player2 = gameManagerState.getPlayer(str);
        if (player == null && player2 == null) {
            return false;
        }
        return player == null || player2 == null || player.getPlayerState() != player2.getPlayerState();
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.zzt.hashCode(Integer.valueOf(this.zzTV), Integer.valueOf(this.zzTU), this.zzUa, this.zzTY, this.zzTX, this.zzTO, Integer.valueOf(this.zzTP));
    }
}
