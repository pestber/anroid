package com.google.android.gms.appinvite;

import android.accounts.Account;
import android.content.Intent;
import android.net.Uri;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.common.internal.zzu;

/* loaded from: classes.dex */
public final class AppInviteInvitation {

    public static final class IntentBuilder {
        public static final int MAX_MESSAGE_LENGTH = 100;
        public static final int PROJECT_PLATFORM_IOS = 1;
        private final Intent mIntent;

        public IntentBuilder(CharSequence charSequence) {
            zzu.zzu(charSequence);
            this.mIntent = new Intent("com.google.android.gms.appinvite.ACTION_APP_INVITE");
            this.mIntent.putExtra("com.google.android.gms.appinvite.TITLE", charSequence);
            this.mIntent.setPackage("com.google.android.gms");
        }

        public Intent build() {
            return this.mIntent;
        }

        public IntentBuilder setAccount(Account account) {
            if (account == null || !GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE.equals(account.type)) {
                this.mIntent.removeExtra("com.google.android.gms.appinvite.ACCOUNT_NAME");
            } else {
                this.mIntent.putExtra("com.google.android.gms.appinvite.ACCOUNT_NAME", account);
            }
            return this;
        }

        public IntentBuilder setDeepLink(Uri uri) {
            Intent intent = this.mIntent;
            if (uri != null) {
                intent.putExtra("com.google.android.gms.appinvite.DEEP_LINK_URL", uri);
            } else {
                intent.removeExtra("com.google.android.gms.appinvite.DEEP_LINK_URL");
            }
            return this;
        }

        public IntentBuilder setGoogleAnalyticsTrackingId(String str) {
            this.mIntent.putExtra("com.google.android.gms.appinvite.GOOGLE_ANALYTICS_TRACKING_ID", str);
            return this;
        }

        public IntentBuilder setMessage(CharSequence charSequence) {
            if (charSequence != null && charSequence.length() > 100) {
                throw new IllegalArgumentException(String.format("Message must be %d chars or less.", 100));
            }
            this.mIntent.putExtra("com.google.android.gms.appinvite.MESSAGE", charSequence);
            return this;
        }

        public IntentBuilder setOtherPlatformsTargetApplication(int i, String str) {
            if (i == 1) {
                this.mIntent.putExtra("com.google.android.gms.appinvite.iosTargetApplication", str);
            }
            return this;
        }
    }

    private AppInviteInvitation() {
    }

    public static String[] getInvitationIds(int i, Intent intent) {
        if (i == -1) {
            return intent.getStringArrayExtra("com.google.android.gms.appinvite.RESULT_INVITATION_IDS");
        }
        return null;
    }
}
