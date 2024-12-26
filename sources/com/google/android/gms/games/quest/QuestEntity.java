package com.google.android.gms.games.quest;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.internal.zzlc;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class QuestEntity implements SafeParcelable, Quest {
    public static final Parcelable.Creator<QuestEntity> CREATOR = new QuestEntityCreator();
    private final String mName;
    private final int mState;
    private final int zzCY;
    private final int zzSq;
    private final String zzakM;
    private final long zzaoj;
    private final String zzauV;
    private final long zzauW;
    private final Uri zzauX;
    private final String zzauY;
    private final long zzauZ;
    private final GameEntity zzaud;
    private final Uri zzava;
    private final String zzavb;
    private final long zzavc;
    private final long zzavd;
    private final ArrayList<MilestoneEntity> zzave;

    QuestEntity(int i, GameEntity gameEntity, String str, long j, Uri uri, String str2, String str3, long j2, long j3, Uri uri2, String str4, String str5, long j4, long j5, int i2, int i3, ArrayList<MilestoneEntity> arrayList) {
        this.zzCY = i;
        this.zzaud = gameEntity;
        this.zzauV = str;
        this.zzauW = j;
        this.zzauX = uri;
        this.zzauY = str2;
        this.zzakM = str3;
        this.zzauZ = j2;
        this.zzaoj = j3;
        this.zzava = uri2;
        this.zzavb = str4;
        this.mName = str5;
        this.zzavc = j4;
        this.zzavd = j5;
        this.mState = i2;
        this.zzSq = i3;
        this.zzave = arrayList;
    }

    public QuestEntity(Quest quest) {
        this.zzCY = 2;
        this.zzaud = new GameEntity(quest.getGame());
        this.zzauV = quest.getQuestId();
        this.zzauW = quest.getAcceptedTimestamp();
        this.zzakM = quest.getDescription();
        this.zzauX = quest.getBannerImageUri();
        this.zzauY = quest.getBannerImageUrl();
        this.zzauZ = quest.getEndTimestamp();
        this.zzava = quest.getIconImageUri();
        this.zzavb = quest.getIconImageUrl();
        this.zzaoj = quest.getLastUpdatedTimestamp();
        this.mName = quest.getName();
        this.zzavc = quest.zztO();
        this.zzavd = quest.getStartTimestamp();
        this.mState = quest.getState();
        this.zzSq = quest.getType();
        List<Milestone> zztN = quest.zztN();
        int size = zztN.size();
        this.zzave = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            this.zzave.add((MilestoneEntity) zztN.get(i).freeze());
        }
    }

    static int zza(Quest quest) {
        return zzt.hashCode(quest.getGame(), quest.getQuestId(), Long.valueOf(quest.getAcceptedTimestamp()), quest.getBannerImageUri(), quest.getDescription(), Long.valueOf(quest.getEndTimestamp()), quest.getIconImageUri(), Long.valueOf(quest.getLastUpdatedTimestamp()), quest.zztN(), quest.getName(), Long.valueOf(quest.zztO()), Long.valueOf(quest.getStartTimestamp()), Integer.valueOf(quest.getState()));
    }

    static boolean zza(Quest quest, Object obj) {
        if (!(obj instanceof Quest)) {
            return false;
        }
        if (quest == obj) {
            return true;
        }
        Quest quest2 = (Quest) obj;
        return zzt.equal(quest2.getGame(), quest.getGame()) && zzt.equal(quest2.getQuestId(), quest.getQuestId()) && zzt.equal(Long.valueOf(quest2.getAcceptedTimestamp()), Long.valueOf(quest.getAcceptedTimestamp())) && zzt.equal(quest2.getBannerImageUri(), quest.getBannerImageUri()) && zzt.equal(quest2.getDescription(), quest.getDescription()) && zzt.equal(Long.valueOf(quest2.getEndTimestamp()), Long.valueOf(quest.getEndTimestamp())) && zzt.equal(quest2.getIconImageUri(), quest.getIconImageUri()) && zzt.equal(Long.valueOf(quest2.getLastUpdatedTimestamp()), Long.valueOf(quest.getLastUpdatedTimestamp())) && zzt.equal(quest2.zztN(), quest.zztN()) && zzt.equal(quest2.getName(), quest.getName()) && zzt.equal(Long.valueOf(quest2.zztO()), Long.valueOf(quest.zztO())) && zzt.equal(Long.valueOf(quest2.getStartTimestamp()), Long.valueOf(quest.getStartTimestamp())) && zzt.equal(Integer.valueOf(quest2.getState()), Integer.valueOf(quest.getState()));
    }

    static String zzb(Quest quest) {
        return zzt.zzt(quest).zzg("Game", quest.getGame()).zzg("QuestId", quest.getQuestId()).zzg("AcceptedTimestamp", Long.valueOf(quest.getAcceptedTimestamp())).zzg("BannerImageUri", quest.getBannerImageUri()).zzg("BannerImageUrl", quest.getBannerImageUrl()).zzg("Description", quest.getDescription()).zzg("EndTimestamp", Long.valueOf(quest.getEndTimestamp())).zzg("IconImageUri", quest.getIconImageUri()).zzg("IconImageUrl", quest.getIconImageUrl()).zzg("LastUpdatedTimestamp", Long.valueOf(quest.getLastUpdatedTimestamp())).zzg("Milestones", quest.zztN()).zzg("Name", quest.getName()).zzg("NotifyTimestamp", Long.valueOf(quest.zztO())).zzg("StartTimestamp", Long.valueOf(quest.getStartTimestamp())).zzg("State", Integer.valueOf(quest.getState())).toString();
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
    public Quest freeze() {
        return this;
    }

    @Override // com.google.android.gms.games.quest.Quest
    public long getAcceptedTimestamp() {
        return this.zzauW;
    }

    @Override // com.google.android.gms.games.quest.Quest
    public Uri getBannerImageUri() {
        return this.zzauX;
    }

    @Override // com.google.android.gms.games.quest.Quest
    public String getBannerImageUrl() {
        return this.zzauY;
    }

    @Override // com.google.android.gms.games.quest.Quest
    public Milestone getCurrentMilestone() {
        return zztN().get(0);
    }

    @Override // com.google.android.gms.games.quest.Quest
    public String getDescription() {
        return this.zzakM;
    }

    @Override // com.google.android.gms.games.quest.Quest
    public void getDescription(CharArrayBuffer charArrayBuffer) {
        zzlc.zzb(this.zzakM, charArrayBuffer);
    }

    @Override // com.google.android.gms.games.quest.Quest
    public long getEndTimestamp() {
        return this.zzauZ;
    }

    @Override // com.google.android.gms.games.quest.Quest
    public Game getGame() {
        return this.zzaud;
    }

    @Override // com.google.android.gms.games.quest.Quest
    public Uri getIconImageUri() {
        return this.zzava;
    }

    @Override // com.google.android.gms.games.quest.Quest
    public String getIconImageUrl() {
        return this.zzavb;
    }

    @Override // com.google.android.gms.games.quest.Quest
    public long getLastUpdatedTimestamp() {
        return this.zzaoj;
    }

    @Override // com.google.android.gms.games.quest.Quest
    public String getName() {
        return this.mName;
    }

    @Override // com.google.android.gms.games.quest.Quest
    public void getName(CharArrayBuffer charArrayBuffer) {
        zzlc.zzb(this.mName, charArrayBuffer);
    }

    @Override // com.google.android.gms.games.quest.Quest
    public String getQuestId() {
        return this.zzauV;
    }

    @Override // com.google.android.gms.games.quest.Quest
    public long getStartTimestamp() {
        return this.zzavd;
    }

    @Override // com.google.android.gms.games.quest.Quest
    public int getState() {
        return this.mState;
    }

    @Override // com.google.android.gms.games.quest.Quest
    public int getType() {
        return this.zzSq;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    public int hashCode() {
        return zza(this);
    }

    @Override // com.google.android.gms.common.data.Freezable
    public boolean isDataValid() {
        return true;
    }

    @Override // com.google.android.gms.games.quest.Quest
    public boolean isEndingSoon() {
        return this.zzavc <= System.currentTimeMillis() + 1800000;
    }

    public String toString() {
        return zzb(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        QuestEntityCreator.zza(this, parcel, i);
    }

    @Override // com.google.android.gms.games.quest.Quest
    public List<Milestone> zztN() {
        return new ArrayList(this.zzave);
    }

    @Override // com.google.android.gms.games.quest.Quest
    public long zztO() {
        return this.zzavc;
    }
}
