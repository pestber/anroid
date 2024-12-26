package com.google.android.gms.games.event;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.zzlc;

/* loaded from: classes.dex */
public final class EventEntity implements SafeParcelable, Event {
    public static final EventEntityCreator CREATOR = new EventEntityCreator();
    private final String mName;
    private final int zzCY;
    private final String zzakM;
    private final Uri zzanf;
    private final String zzanq;
    private final String zzaoK;
    private final long zzaoL;
    private final String zzaoM;
    private final boolean zzaoN;
    private final PlayerEntity zzaog;

    EventEntity(int i, String str, String str2, String str3, Uri uri, String str4, Player player, long j, String str5, boolean z) {
        this.zzCY = i;
        this.zzaoK = str;
        this.mName = str2;
        this.zzakM = str3;
        this.zzanf = uri;
        this.zzanq = str4;
        this.zzaog = new PlayerEntity(player);
        this.zzaoL = j;
        this.zzaoM = str5;
        this.zzaoN = z;
    }

    public EventEntity(Event event) {
        this.zzCY = 1;
        this.zzaoK = event.getEventId();
        this.mName = event.getName();
        this.zzakM = event.getDescription();
        this.zzanf = event.getIconImageUri();
        this.zzanq = event.getIconImageUrl();
        this.zzaog = (PlayerEntity) event.getPlayer().freeze();
        this.zzaoL = event.getValue();
        this.zzaoM = event.getFormattedValue();
        this.zzaoN = event.isVisible();
    }

    static int zza(Event event) {
        return zzt.hashCode(event.getEventId(), event.getName(), event.getDescription(), event.getIconImageUri(), event.getIconImageUrl(), event.getPlayer(), Long.valueOf(event.getValue()), event.getFormattedValue(), Boolean.valueOf(event.isVisible()));
    }

    static boolean zza(Event event, Object obj) {
        if (!(obj instanceof Event)) {
            return false;
        }
        if (event == obj) {
            return true;
        }
        Event event2 = (Event) obj;
        return zzt.equal(event2.getEventId(), event.getEventId()) && zzt.equal(event2.getName(), event.getName()) && zzt.equal(event2.getDescription(), event.getDescription()) && zzt.equal(event2.getIconImageUri(), event.getIconImageUri()) && zzt.equal(event2.getIconImageUrl(), event.getIconImageUrl()) && zzt.equal(event2.getPlayer(), event.getPlayer()) && zzt.equal(Long.valueOf(event2.getValue()), Long.valueOf(event.getValue())) && zzt.equal(event2.getFormattedValue(), event.getFormattedValue()) && zzt.equal(Boolean.valueOf(event2.isVisible()), Boolean.valueOf(event.isVisible()));
    }

    static String zzb(Event event) {
        return zzt.zzt(event).zzg("Id", event.getEventId()).zzg("Name", event.getName()).zzg("Description", event.getDescription()).zzg("IconImageUri", event.getIconImageUri()).zzg("IconImageUrl", event.getIconImageUrl()).zzg("Player", event.getPlayer()).zzg("Value", Long.valueOf(event.getValue())).zzg("FormattedValue", event.getFormattedValue()).zzg("isVisible", Boolean.valueOf(event.isVisible())).toString();
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
    public Event freeze() {
        return this;
    }

    @Override // com.google.android.gms.games.event.Event
    public String getDescription() {
        return this.zzakM;
    }

    @Override // com.google.android.gms.games.event.Event
    public void getDescription(CharArrayBuffer charArrayBuffer) {
        zzlc.zzb(this.zzakM, charArrayBuffer);
    }

    @Override // com.google.android.gms.games.event.Event
    public String getEventId() {
        return this.zzaoK;
    }

    @Override // com.google.android.gms.games.event.Event
    public String getFormattedValue() {
        return this.zzaoM;
    }

    @Override // com.google.android.gms.games.event.Event
    public void getFormattedValue(CharArrayBuffer charArrayBuffer) {
        zzlc.zzb(this.zzaoM, charArrayBuffer);
    }

    @Override // com.google.android.gms.games.event.Event
    public Uri getIconImageUri() {
        return this.zzanf;
    }

    @Override // com.google.android.gms.games.event.Event
    public String getIconImageUrl() {
        return this.zzanq;
    }

    @Override // com.google.android.gms.games.event.Event
    public String getName() {
        return this.mName;
    }

    @Override // com.google.android.gms.games.event.Event
    public void getName(CharArrayBuffer charArrayBuffer) {
        zzlc.zzb(this.mName, charArrayBuffer);
    }

    @Override // com.google.android.gms.games.event.Event
    public Player getPlayer() {
        return this.zzaog;
    }

    @Override // com.google.android.gms.games.event.Event
    public long getValue() {
        return this.zzaoL;
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

    @Override // com.google.android.gms.games.event.Event
    public boolean isVisible() {
        return this.zzaoN;
    }

    public String toString() {
        return zzb(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        EventEntityCreator.zza(this, parcel, i);
    }
}
