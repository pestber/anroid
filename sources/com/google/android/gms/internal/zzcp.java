package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.internal.zzck;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@zzgd
/* loaded from: classes.dex */
public class zzcp extends NativeAppInstallAd {
    private final zzco zzvK;
    private final List<NativeAd.Image> zzvL = new ArrayList();
    private final zzcl zzvM;

    public zzcp(zzco zzcoVar) {
        this.zzvK = zzcoVar;
        try {
            Iterator it = this.zzvK.getImages().iterator();
            while (it.hasNext()) {
                zzck zzd = zzd(it.next());
                if (zzd != null) {
                    this.zzvL.add(new zzcl(zzd));
                }
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzb("Failed to get image.", e);
        }
        zzcl zzclVar = null;
        try {
            zzck zzdy = this.zzvK.zzdy();
            if (zzdy != null) {
                zzclVar = new zzcl(zzdy);
            }
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.client.zzb.zzb("Failed to get icon.", e2);
        }
        this.zzvM = zzclVar;
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public CharSequence getBody() {
        try {
            return this.zzvK.getBody();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzb("Failed to get body.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public CharSequence getCallToAction() {
        try {
            return this.zzvK.zzdz();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzb("Failed to get call to action.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public CharSequence getHeadline() {
        try {
            return this.zzvK.zzdx();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzb("Failed to get headline.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public NativeAd.Image getIcon() {
        return this.zzvM;
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public List<NativeAd.Image> getImages() {
        return this.zzvL;
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public CharSequence getPrice() {
        try {
            return this.zzvK.zzdC();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzb("Failed to get price.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public Double getStarRating() {
        try {
            double zzdA = this.zzvK.zzdA();
            if (zzdA == -1.0d) {
                return null;
            }
            return Double.valueOf(zzdA);
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzb("Failed to get star rating.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public CharSequence getStore() {
        try {
            return this.zzvK.zzdB();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzb("Failed to get store", e);
            return null;
        }
    }

    zzck zzd(Object obj) {
        if (obj instanceof IBinder) {
            return zzck.zza.zzt((IBinder) obj);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.formats.NativeAd
    /* renamed from: zzdD, reason: merged with bridge method [inline-methods] */
    public com.google.android.gms.dynamic.zzd zzaH() {
        try {
            return this.zzvK.zzdD();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzb("Failed to retrieve native ad engine.", e);
            return null;
        }
    }
}
