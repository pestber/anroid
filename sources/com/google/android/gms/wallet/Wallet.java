package com.google.android.gms.wallet;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.support.v7.internal.widget.ActivityChooserView;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.internal.zzqw;
import com.google.android.gms.internal.zzqx;
import com.google.android.gms.internal.zzqz;
import com.google.android.gms.internal.zzra;
import java.util.Locale;

/* loaded from: classes.dex */
public final class Wallet {
    private static final Api.ClientKey<zzqx> zzNX = new Api.ClientKey<>();
    private static final Api.zza<zzqx, WalletOptions> zzNY = new Api.zza<zzqx, WalletOptions>() { // from class: com.google.android.gms.wallet.Wallet.1
        @Override // com.google.android.gms.common.api.Api.zza
        public int getPriority() {
            return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }

        @Override // com.google.android.gms.common.api.Api.zza
        public zzqx zza(Context context, Looper looper, com.google.android.gms.common.internal.zze zzeVar, WalletOptions walletOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            zzu.zzb(context instanceof Activity, "An Activity must be used for Wallet APIs");
            Activity activity = (Activity) context;
            WalletOptions walletOptions2 = walletOptions != null ? walletOptions : new WalletOptions();
            return new zzqx(activity, looper, connectionCallbacks, onConnectionFailedListener, walletOptions2.environment, zzeVar.getAccountName(), walletOptions2.theme);
        }
    };
    public static final Api<WalletOptions> API = new Api<>("Wallet.API", zzNY, zzNX, new Scope[0]);
    public static final Payments Payments = new zzqw();
    public static final com.google.android.gms.wallet.wobs.zzj zzaRF = new zzra();
    public static final com.google.android.gms.wallet.firstparty.zza zzaRG = new zzqz();

    public static final class WalletOptions implements Api.ApiOptions.HasOptions {
        public final int environment;
        public final int theme;

        public static final class Builder {
            private int zzaRH = 3;
            private int mTheme = 0;

            public WalletOptions build() {
                return new WalletOptions(this);
            }

            public Builder setEnvironment(int i) {
                if (i != 0 && i != 2 && i != 1 && i != 3) {
                    throw new IllegalArgumentException(String.format(Locale.US, "Invalid environment value %d", Integer.valueOf(i)));
                }
                this.zzaRH = i;
                return this;
            }

            public Builder setTheme(int i) {
                if (i != 0 && i != 1) {
                    throw new IllegalArgumentException(String.format(Locale.US, "Invalid theme value %d", Integer.valueOf(i)));
                }
                this.mTheme = i;
                return this;
            }
        }

        private WalletOptions() {
            this(new Builder());
        }

        private WalletOptions(Builder builder) {
            this.environment = builder.zzaRH;
            this.theme = builder.mTheme;
        }
    }

    public static abstract class zza<R extends Result> extends zza.AbstractC0035zza<R, zzqx> {
        public zza(GoogleApiClient googleApiClient) {
            super(Wallet.zzNX, googleApiClient);
        }
    }

    public static abstract class zzb extends zza<Status> {
        public zzb(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.AbstractPendingResult
        /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public Status createFailedResult(Status status) {
            return status;
        }
    }

    private Wallet() {
    }

    @Deprecated
    public static void changeMaskedWallet(GoogleApiClient googleApiClient, String str, String str2, int i) {
        Payments.changeMaskedWallet(googleApiClient, str, str2, i);
    }

    @Deprecated
    public static void checkForPreAuthorization(GoogleApiClient googleApiClient, int i) {
        Payments.checkForPreAuthorization(googleApiClient, i);
    }

    @Deprecated
    public static void loadFullWallet(GoogleApiClient googleApiClient, FullWalletRequest fullWalletRequest, int i) {
        Payments.loadFullWallet(googleApiClient, fullWalletRequest, i);
    }

    @Deprecated
    public static void loadMaskedWallet(GoogleApiClient googleApiClient, MaskedWalletRequest maskedWalletRequest, int i) {
        Payments.loadMaskedWallet(googleApiClient, maskedWalletRequest, i);
    }

    @Deprecated
    public static void notifyTransactionStatus(GoogleApiClient googleApiClient, NotifyTransactionStatusRequest notifyTransactionStatusRequest) {
        Payments.notifyTransactionStatus(googleApiClient, notifyTransactionStatusRequest);
    }
}
