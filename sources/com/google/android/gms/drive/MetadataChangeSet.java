package com.google.android.gms.drive;

import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.zzlo;
import com.google.android.gms.internal.zzlq;
import java.util.Collections;
import java.util.Date;
import java.util.Map;

/* loaded from: classes.dex */
public final class MetadataChangeSet {
    public static final int CUSTOM_PROPERTY_SIZE_LIMIT_BYTES = 124;
    public static final int INDEXABLE_TEXT_SIZE_LIMIT_BYTES = 131072;
    public static final int MAX_PRIVATE_PROPERTIES_PER_RESOURCE_PER_APP = 30;
    public static final int MAX_PUBLIC_PROPERTIES_PER_RESOURCE = 30;
    public static final int MAX_TOTAL_PROPERTIES_PER_RESOURCE = 100;
    public static final MetadataChangeSet zzads = new MetadataChangeSet(MetadataBundle.zzpX());
    private final MetadataBundle zzadt;

    public static class Builder {
        private final MetadataBundle zzadt = MetadataBundle.zzpX();
        private AppVisibleCustomProperties.zza zzadu;

        private int zzcu(String str) {
            if (str == null) {
                return 0;
            }
            return str.getBytes().length;
        }

        private String zzj(String str, int i, int i2) {
            return String.format("%s must be no more than %d bytes, but is %d bytes.", str, Integer.valueOf(i), Integer.valueOf(i2));
        }

        private void zzk(String str, int i, int i2) {
            zzu.zzb(i2 <= i, zzj(str, i, i2));
        }

        private AppVisibleCustomProperties.zza zzpn() {
            if (this.zzadu == null) {
                this.zzadu = new AppVisibleCustomProperties.zza();
            }
            return this.zzadu;
        }

        public MetadataChangeSet build() {
            if (this.zzadu != null) {
                this.zzadt.zzb(zzlo.zzagM, this.zzadu.zzpU());
            }
            return new MetadataChangeSet(this.zzadt);
        }

        public Builder deleteCustomProperty(CustomPropertyKey customPropertyKey) {
            zzu.zzb(customPropertyKey, "key");
            zzpn().zza(customPropertyKey, null);
            return this;
        }

        public Builder setCustomProperty(CustomPropertyKey customPropertyKey, String str) {
            zzu.zzb(customPropertyKey, "key");
            zzu.zzb(str, "value");
            zzk("The total size of key string and value string of a custom property", MetadataChangeSet.CUSTOM_PROPERTY_SIZE_LIMIT_BYTES, zzcu(customPropertyKey.getKey()) + zzcu(str));
            zzpn().zza(customPropertyKey, str);
            return this;
        }

        public Builder setDescription(String str) {
            this.zzadt.zzb(zzlo.zzagN, str);
            return this;
        }

        public Builder setIndexableText(String str) {
            zzk("Indexable text size", 131072, zzcu(str));
            this.zzadt.zzb(zzlo.zzagT, str);
            return this;
        }

        public Builder setLastViewedByMeDate(Date date) {
            this.zzadt.zzb(zzlq.zzahz, date);
            return this;
        }

        public Builder setMimeType(String str) {
            this.zzadt.zzb(zzlo.zzahg, str);
            return this;
        }

        public Builder setPinned(boolean z) {
            this.zzadt.zzb(zzlo.zzagY, Boolean.valueOf(z));
            return this;
        }

        public Builder setStarred(boolean z) {
            this.zzadt.zzb(zzlo.zzahn, Boolean.valueOf(z));
            return this;
        }

        public Builder setTitle(String str) {
            this.zzadt.zzb(zzlo.zzahp, str);
            return this;
        }

        public Builder setViewed(boolean z) {
            this.zzadt.zzb(zzlo.zzahf, Boolean.valueOf(z));
            return this;
        }
    }

    public MetadataChangeSet(MetadataBundle metadataBundle) {
        this.zzadt = MetadataBundle.zza(metadataBundle);
    }

    public Map<CustomPropertyKey, String> getCustomPropertyChangeMap() {
        AppVisibleCustomProperties appVisibleCustomProperties = (AppVisibleCustomProperties) this.zzadt.zza(zzlo.zzagM);
        return appVisibleCustomProperties == null ? Collections.emptyMap() : appVisibleCustomProperties.zzpT();
    }

    public String getDescription() {
        return (String) this.zzadt.zza(zzlo.zzagN);
    }

    public String getIndexableText() {
        return (String) this.zzadt.zza(zzlo.zzagT);
    }

    public Date getLastViewedByMeDate() {
        return (Date) this.zzadt.zza(zzlq.zzahz);
    }

    public String getMimeType() {
        return (String) this.zzadt.zza(zzlo.zzahg);
    }

    public String getTitle() {
        return (String) this.zzadt.zza(zzlo.zzahp);
    }

    public Boolean isPinned() {
        return (Boolean) this.zzadt.zza(zzlo.zzagY);
    }

    public Boolean isStarred() {
        return (Boolean) this.zzadt.zza(zzlo.zzahn);
    }

    public Boolean isViewed() {
        return (Boolean) this.zzadt.zza(zzlo.zzahf);
    }

    public MetadataBundle zzpm() {
        return this.zzadt;
    }
}
