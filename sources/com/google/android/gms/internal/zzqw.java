package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;
import com.google.android.gms.wallet.Payments;
import com.google.android.gms.wallet.Wallet;

/* loaded from: classes.dex */
public class zzqw implements Payments {
    @Override // com.google.android.gms.wallet.Payments
    public void changeMaskedWallet(GoogleApiClient googleApiClient, final String str, final String str2, final int i) {
        googleApiClient.zza((GoogleApiClient) new Wallet.zzb(googleApiClient) { // from class: com.google.android.gms.internal.zzqw.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zzqx zzqxVar) {
                zzqxVar.zze(str, str2, i);
                setResult(Status.zzXP);
            }
        });
    }

    @Override // com.google.android.gms.wallet.Payments
    public void checkForPreAuthorization(GoogleApiClient googleApiClient, final int i) {
        googleApiClient.zza((GoogleApiClient) new Wallet.zzb(googleApiClient) { // from class: com.google.android.gms.internal.zzqw.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zzqx zzqxVar) {
                zzqxVar.zzjB(i);
                setResult(Status.zzXP);
            }
        });
    }

    @Override // com.google.android.gms.wallet.Payments
    public void isNewUser(GoogleApiClient googleApiClient, final int i) {
        googleApiClient.zza((GoogleApiClient) new Wallet.zzb(googleApiClient) { // from class: com.google.android.gms.internal.zzqw.6
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zzqx zzqxVar) {
                zzqxVar.zzjC(i);
                setResult(Status.zzXP);
            }
        });
    }

    @Override // com.google.android.gms.wallet.Payments
    public void loadFullWallet(GoogleApiClient googleApiClient, final FullWalletRequest fullWalletRequest, final int i) {
        googleApiClient.zza((GoogleApiClient) new Wallet.zzb(googleApiClient) { // from class: com.google.android.gms.internal.zzqw.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zzqx zzqxVar) {
                zzqxVar.zza(fullWalletRequest, i);
                setResult(Status.zzXP);
            }
        });
    }

    @Override // com.google.android.gms.wallet.Payments
    public void loadMaskedWallet(GoogleApiClient googleApiClient, final MaskedWalletRequest maskedWalletRequest, final int i) {
        googleApiClient.zza((GoogleApiClient) new Wallet.zzb(googleApiClient) { // from class: com.google.android.gms.internal.zzqw.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zzqx zzqxVar) {
                zzqxVar.zza(maskedWalletRequest, i);
                setResult(Status.zzXP);
            }
        });
    }

    @Override // com.google.android.gms.wallet.Payments
    public void notifyTransactionStatus(GoogleApiClient googleApiClient, final NotifyTransactionStatusRequest notifyTransactionStatusRequest) {
        googleApiClient.zza((GoogleApiClient) new Wallet.zzb(googleApiClient) { // from class: com.google.android.gms.internal.zzqw.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zzqx zzqxVar) {
                zzqxVar.zza(notifyTransactionStatusRequest);
                setResult(Status.zzXP);
            }
        });
    }
}
