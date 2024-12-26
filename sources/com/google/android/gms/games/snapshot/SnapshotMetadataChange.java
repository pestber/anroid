package com.google.android.gms.games.snapshot;

import android.graphics.Bitmap;
import android.net.Uri;
import com.google.android.gms.common.data.BitmapTeleporter;

/* loaded from: classes.dex */
public abstract class SnapshotMetadataChange {
    public static final SnapshotMetadataChange EMPTY_CHANGE = new SnapshotMetadataChangeEntity();

    public static final class Builder {
        private String zzakM;
        private Long zzavm;
        private Long zzavn;
        private BitmapTeleporter zzavo;
        private Uri zzavp;

        public SnapshotMetadataChange build() {
            return new SnapshotMetadataChangeEntity(this.zzakM, this.zzavm, this.zzavo, this.zzavp, this.zzavn);
        }

        public Builder fromMetadata(SnapshotMetadata snapshotMetadata) {
            this.zzakM = snapshotMetadata.getDescription();
            this.zzavm = Long.valueOf(snapshotMetadata.getPlayedTime());
            this.zzavn = Long.valueOf(snapshotMetadata.getProgressValue());
            if (this.zzavm.longValue() == -1) {
                this.zzavm = null;
            }
            this.zzavp = snapshotMetadata.getCoverImageUri();
            if (this.zzavp != null) {
                this.zzavo = null;
            }
            return this;
        }

        public Builder setCoverImage(Bitmap bitmap) {
            this.zzavo = new BitmapTeleporter(bitmap);
            this.zzavp = null;
            return this;
        }

        public Builder setDescription(String str) {
            this.zzakM = str;
            return this;
        }

        public Builder setPlayedTimeMillis(long j) {
            this.zzavm = Long.valueOf(j);
            return this;
        }

        public Builder setProgressValue(long j) {
            this.zzavn = Long.valueOf(j);
            return this;
        }
    }

    protected SnapshotMetadataChange() {
    }

    public abstract Bitmap getCoverImage();

    public abstract String getDescription();

    public abstract Long getPlayedTimeMillis();

    public abstract Long getProgressValue();

    public abstract BitmapTeleporter zztQ();
}
