package com.google.android.gms.appindexing;

import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.plus.PlusShare;

/* loaded from: classes.dex */
public class Thing {
    final Bundle zzNV;

    public static class Builder {
        final Bundle zzNW = new Bundle();

        public Thing build() {
            return new Thing(this.zzNW);
        }

        public Builder put(String str, Thing thing) {
            zzu.zzu(str);
            if (thing != null) {
                this.zzNW.putParcelable(str, thing.zzNV);
            }
            return this;
        }

        public Builder put(String str, String str2) {
            zzu.zzu(str);
            if (str2 != null) {
                this.zzNW.putString(str, str2);
            }
            return this;
        }

        public Builder setDescription(String str) {
            put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, str);
            return this;
        }

        public Builder setId(String str) {
            if (str != null) {
                put("id", str);
            }
            return this;
        }

        public Builder setName(String str) {
            zzu.zzu(str);
            put("name", str);
            return this;
        }

        public Builder setType(String str) {
            put("type", str);
            return this;
        }

        public Builder setUrl(Uri uri) {
            zzu.zzu(uri);
            put(PlusShare.KEY_CALL_TO_ACTION_URL, uri.toString());
            return this;
        }
    }

    Thing(Bundle bundle) {
        this.zzNV = bundle;
    }

    public Bundle zzkP() {
        return this.zzNV;
    }
}
