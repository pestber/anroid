package com.google.android.gms.games.request;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public final class GameRequestEntity implements SafeParcelable, GameRequest {
    public static final Parcelable.Creator<GameRequestEntity> CREATOR = new GameRequestEntityCreator();
    private final int zzCY;
    private final String zzDK;
    private final int zzSq;
    private final byte[] zzauL;
    private final GameEntity zzaud;
    private final long zzaue;
    private final PlayerEntity zzavf;
    private final ArrayList<PlayerEntity> zzavg;
    private final long zzavh;
    private final Bundle zzavi;
    private final int zzwS;

    GameRequestEntity(int i, GameEntity gameEntity, PlayerEntity playerEntity, byte[] bArr, String str, ArrayList<PlayerEntity> arrayList, int i2, long j, long j2, Bundle bundle, int i3) {
        this.zzCY = i;
        this.zzaud = gameEntity;
        this.zzavf = playerEntity;
        this.zzauL = bArr;
        this.zzDK = str;
        this.zzavg = arrayList;
        this.zzSq = i2;
        this.zzaue = j;
        this.zzavh = j2;
        this.zzavi = bundle;
        this.zzwS = i3;
    }

    public GameRequestEntity(GameRequest gameRequest) {
        this.zzCY = 2;
        this.zzaud = new GameEntity(gameRequest.getGame());
        this.zzavf = new PlayerEntity(gameRequest.getSender());
        this.zzDK = gameRequest.getRequestId();
        this.zzSq = gameRequest.getType();
        this.zzaue = gameRequest.getCreationTimestamp();
        this.zzavh = gameRequest.getExpirationTimestamp();
        this.zzwS = gameRequest.getStatus();
        byte[] data = gameRequest.getData();
        if (data == null) {
            this.zzauL = null;
        } else {
            this.zzauL = new byte[data.length];
            System.arraycopy(data, 0, this.zzauL, 0, data.length);
        }
        List<Player> recipients = gameRequest.getRecipients();
        int size = recipients.size();
        this.zzavg = new ArrayList<>(size);
        this.zzavi = new Bundle();
        for (int i = 0; i < size; i++) {
            Player freeze = recipients.get(i).freeze();
            String playerId = freeze.getPlayerId();
            this.zzavg.add((PlayerEntity) freeze);
            this.zzavi.putInt(playerId, gameRequest.getRecipientStatus(playerId));
        }
    }

    static int zza(GameRequest gameRequest) {
        return zzt.hashCode(gameRequest.getGame(), gameRequest.getRecipients(), gameRequest.getRequestId(), gameRequest.getSender(), zzb(gameRequest), Integer.valueOf(gameRequest.getType()), Long.valueOf(gameRequest.getCreationTimestamp()), Long.valueOf(gameRequest.getExpirationTimestamp()));
    }

    static boolean zza(GameRequest gameRequest, Object obj) {
        if (!(obj instanceof GameRequest)) {
            return false;
        }
        if (gameRequest == obj) {
            return true;
        }
        GameRequest gameRequest2 = (GameRequest) obj;
        return zzt.equal(gameRequest2.getGame(), gameRequest.getGame()) && zzt.equal(gameRequest2.getRecipients(), gameRequest.getRecipients()) && zzt.equal(gameRequest2.getRequestId(), gameRequest.getRequestId()) && zzt.equal(gameRequest2.getSender(), gameRequest.getSender()) && Arrays.equals(zzb(gameRequest2), zzb(gameRequest)) && zzt.equal(Integer.valueOf(gameRequest2.getType()), Integer.valueOf(gameRequest.getType())) && zzt.equal(Long.valueOf(gameRequest2.getCreationTimestamp()), Long.valueOf(gameRequest.getCreationTimestamp())) && zzt.equal(Long.valueOf(gameRequest2.getExpirationTimestamp()), Long.valueOf(gameRequest.getExpirationTimestamp()));
    }

    private static int[] zzb(GameRequest gameRequest) {
        List<Player> recipients = gameRequest.getRecipients();
        int size = recipients.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = gameRequest.getRecipientStatus(recipients.get(i).getPlayerId());
        }
        return iArr;
    }

    static String zzc(GameRequest gameRequest) {
        return zzt.zzt(gameRequest).zzg("Game", gameRequest.getGame()).zzg("Sender", gameRequest.getSender()).zzg("Recipients", gameRequest.getRecipients()).zzg("Data", gameRequest.getData()).zzg("RequestId", gameRequest.getRequestId()).zzg("Type", Integer.valueOf(gameRequest.getType())).zzg("CreationTimestamp", Long.valueOf(gameRequest.getCreationTimestamp())).zzg("ExpirationTimestamp", Long.valueOf(gameRequest.getExpirationTimestamp())).toString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.gms.common.data.Freezable
    public GameRequest freeze() {
        return this;
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public long getCreationTimestamp() {
        return this.zzaue;
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public byte[] getData() {
        return this.zzauL;
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public long getExpirationTimestamp() {
        return this.zzavh;
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public Game getGame() {
        return this.zzaud;
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public int getRecipientStatus(String str) {
        return this.zzavi.getInt(str, 0);
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public List<Player> getRecipients() {
        return new ArrayList(this.zzavg);
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public String getRequestId() {
        return this.zzDK;
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public Player getSender() {
        return this.zzavf;
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public int getStatus() {
        return this.zzwS;
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public int getType() {
        return this.zzSq;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    public int hashCode() {
        return zza(this);
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public boolean isConsumed(String str) {
        return getRecipientStatus(str) == 1;
    }

    @Override // com.google.android.gms.common.data.Freezable
    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzc(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        GameRequestEntityCreator.zza(this, parcel, i);
    }

    public Bundle zztP() {
        return this.zzavi;
    }
}
