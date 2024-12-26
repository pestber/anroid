package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.internal.zzal;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class zzam extends zzal {
    private static AdvertisingIdClient zznn = null;
    private static CountDownLatch zzno = new CountDownLatch(1);
    private static boolean zznp;
    private boolean zznq;

    class zza {
        private String zznr;
        private boolean zzns;

        public zza(String str, boolean z) {
            this.zznr = str;
            this.zzns = z;
        }

        public String getId() {
            return this.zznr;
        }

        public boolean isLimitAdTrackingEnabled() {
            return this.zzns;
        }
    }

    private static final class zzb implements Runnable {
        private Context zznu;

        public zzb(Context context) {
            this.zznu = context.getApplicationContext();
            if (this.zznu == null) {
                this.zznu = context;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                try {
                    AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(this.zznu);
                    advertisingIdClient.start();
                    synchronized (zzam.class) {
                        if (zzam.zznn == null) {
                            AdvertisingIdClient unused = zzam.zznn = advertisingIdClient;
                        } else {
                            advertisingIdClient.finish();
                        }
                    }
                } catch (GooglePlayServicesRepairableException | IOException e) {
                }
            } catch (GooglePlayServicesNotAvailableException e2) {
                boolean unused2 = zzam.zznp = true;
            }
            zzam.zzno.countDown();
        }
    }

    protected zzam(Context context, zzap zzapVar, zzaq zzaqVar, boolean z) {
        super(context, zzapVar, zzaqVar);
        this.zznq = z;
    }

    public static zzam zza(String str, Context context, boolean z) {
        zzah zzahVar = new zzah();
        zza(str, context, zzahVar);
        if (z) {
            synchronized (zzam.class) {
                if (zznn == null) {
                    new Thread(new zzb(context)).start();
                }
            }
        }
        return new zzam(context, zzahVar, new zzas(239), z);
    }

    zza zzY() throws IOException {
        synchronized (zzam.class) {
            try {
                if (!zzno.await(2L, TimeUnit.SECONDS)) {
                    return new zza(null, false);
                }
                if (zznn == null) {
                    return new zza(null, false);
                }
                AdvertisingIdClient.Info info = zznn.getInfo();
                return new zza(zzk(info.getId()), info.isLimitAdTrackingEnabled());
            } catch (InterruptedException e) {
                return new zza(null, false);
            }
        }
    }

    @Override // com.google.android.gms.internal.zzal, com.google.android.gms.internal.zzak
    protected void zzc(Context context) {
        super.zzc(context);
        try {
            if (!zznp && this.zznq) {
                zza zzY = zzY();
                String id = zzY.getId();
                if (id != null) {
                    zza(28, zzY.isLimitAdTrackingEnabled() ? 1L : 0L);
                    zza(26, 5L);
                    zza(24, id);
                    return;
                }
                return;
            }
            zza(24, zze(context));
        } catch (zzal.zza e) {
        } catch (IOException e2) {
        }
    }
}
