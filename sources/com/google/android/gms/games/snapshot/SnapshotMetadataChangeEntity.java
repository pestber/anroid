package com.google.android.gms.games.snapshot;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public final class SnapshotMetadataChangeEntity extends SnapshotMetadataChange implements SafeParcelable {
    public static final SnapshotMetadataChangeCreator CREATOR = new SnapshotMetadataChangeCreator();
    private final int zzCY;
    private final String zzakM;
    private final Long zzavn;
    private final Uri zzavp;
    private final Long zzavq;
    private BitmapTeleporter zzavr;

    SnapshotMetadataChangeEntity() {
        this(5, null, null, null, null, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0027, code lost:
    
        if (r4.zzavr == null) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0019, code lost:
    
        if (r4.zzavp == null) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x001c, code lost:
    
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x001d, code lost:
    
        com.google.android.gms.common.internal.zzu.zza(r2, "Cannot set both a URI and an image");
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x002a, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    SnapshotMetadataChangeEntity(int r5, java.lang.String r6, java.lang.Long r7, com.google.android.gms.common.data.BitmapTeleporter r8, android.net.Uri r9, java.lang.Long r10) {
        /*
            r4 = this;
            r4.<init>()
            r4.zzCY = r5
            r4.zzakM = r6
            r4.zzavq = r7
            r4.zzavr = r8
            r4.zzavp = r9
            r4.zzavn = r10
            com.google.android.gms.common.data.BitmapTeleporter r0 = r4.zzavr
            java.lang.String r1 = "Cannot set both a URI and an image"
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L21
            android.net.Uri r0 = r4.zzavp
            if (r0 != 0) goto L1c
            goto L1d
        L1c:
            r2 = r3
        L1d:
            com.google.android.gms.common.internal.zzu.zza(r2, r1)
            goto L2a
        L21:
            android.net.Uri r0 = r4.zzavp
            if (r0 == 0) goto L2a
            com.google.android.gms.common.data.BitmapTeleporter r0 = r4.zzavr
            if (r0 != 0) goto L1c
            goto L1d
        L2a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.games.snapshot.SnapshotMetadataChangeEntity.<init>(int, java.lang.String, java.lang.Long, com.google.android.gms.common.data.BitmapTeleporter, android.net.Uri, java.lang.Long):void");
    }

    SnapshotMetadataChangeEntity(String str, Long l, BitmapTeleporter bitmapTeleporter, Uri uri, Long l2) {
        this(5, str, l, bitmapTeleporter, uri, l2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadataChange
    public Bitmap getCoverImage() {
        if (this.zzavr == null) {
            return null;
        }
        return this.zzavr.zznc();
    }

    public Uri getCoverImageUri() {
        return this.zzavp;
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadataChange
    public String getDescription() {
        return this.zzakM;
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadataChange
    public Long getPlayedTimeMillis() {
        return this.zzavq;
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadataChange
    public Long getProgressValue() {
        return this.zzavn;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        SnapshotMetadataChangeCreator.zza(this, parcel, i);
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadataChange
    public BitmapTeleporter zztQ() {
        return this.zzavr;
    }
}
