package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import java.util.List;

@zzgd
/* loaded from: classes.dex */
public class zzct implements NativeCustomTemplateAd {
    private final zzcs zzvP;

    public zzct(zzcs zzcsVar) {
        this.zzvP = zzcsVar;
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public List<String> getAvailableAssetNames() {
        try {
            return this.zzvP.getAvailableAssetNames();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzb("Failed to get available asset names.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public String getCustomTemplateId() {
        try {
            return this.zzvP.getCustomTemplateId();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzb("Failed to get custom template id.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public NativeAd.Image getImage(String str) {
        try {
            zzck zzR = this.zzvP.zzR(str);
            if (zzR != null) {
                return new zzcl(zzR);
            }
            return null;
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzb("Failed to get image.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public CharSequence getText(String str) {
        try {
            return this.zzvP.zzQ(str);
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzb("Failed to get string.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public void performClick(String str) {
        try {
            this.zzvP.performClick(str);
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzb("Failed to perform click.", e);
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public void recordImpression() {
        try {
            this.zzvP.recordImpression();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzb("Failed to record impression.", e);
        }
    }
}
