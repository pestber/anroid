package com.google.android.gms.common.images;

import android.app.ActivityManager;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.util.Log;
import android.widget.ImageView;
import com.google.android.gms.common.images.zza;
import com.google.android.gms.internal.zzkj;
import com.google.android.gms.internal.zzku;
import com.google.android.gms.internal.zzlk;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public final class ImageManager {
    private static final Object zzYN = new Object();
    private static HashSet<Uri> zzYO = new HashSet<>();
    private static ImageManager zzYP;
    private static ImageManager zzYQ;
    private final Context mContext;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private final ExecutorService zzYR = Executors.newFixedThreadPool(4);
    private final zzb zzYS;
    private final zzkj zzYT;
    private final Map<com.google.android.gms.common.images.zza, ImageReceiver> zzYU;
    private final Map<Uri, ImageReceiver> zzYV;
    private final Map<Uri, Long> zzYW;

    private final class ImageReceiver extends ResultReceiver {
        private final Uri mUri;
        private final ArrayList<com.google.android.gms.common.images.zza> zzYX;

        ImageReceiver(Uri uri) {
            super(new Handler(Looper.getMainLooper()));
            this.mUri = uri;
            this.zzYX = new ArrayList<>();
        }

        @Override // android.os.ResultReceiver
        public void onReceiveResult(int i, Bundle bundle) {
            ImageManager.this.zzYR.execute(ImageManager.this.new zzc(this.mUri, (ParcelFileDescriptor) bundle.getParcelable("com.google.android.gms.extra.fileDescriptor")));
        }

        public void zzb(com.google.android.gms.common.images.zza zzaVar) {
            com.google.android.gms.common.internal.zzb.zzbY("ImageReceiver.addImageRequest() must be called in the main thread");
            this.zzYX.add(zzaVar);
        }

        public void zzc(com.google.android.gms.common.images.zza zzaVar) {
            com.google.android.gms.common.internal.zzb.zzbY("ImageReceiver.removeImageRequest() must be called in the main thread");
            this.zzYX.remove(zzaVar);
        }

        public void zzno() {
            Intent intent = new Intent("com.google.android.gms.common.images.LOAD_IMAGE");
            intent.putExtra("com.google.android.gms.extras.uri", this.mUri);
            intent.putExtra("com.google.android.gms.extras.resultReceiver", this);
            intent.putExtra("com.google.android.gms.extras.priority", 3);
            ImageManager.this.mContext.sendBroadcast(intent);
        }
    }

    public interface OnImageLoadedListener {
        void onImageLoaded(Uri uri, Drawable drawable, boolean z);
    }

    private static final class zza {
        static int zza(ActivityManager activityManager) {
            return activityManager.getLargeMemoryClass();
        }
    }

    private static final class zzb extends zzku<zza.C0036zza, Bitmap> {
        public zzb(Context context) {
            super(zzag(context));
        }

        private static int zzag(Context context) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            return (int) ((((context.getApplicationInfo().flags & AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START) == 0 || !zzlk.zzoR()) ? activityManager.getMemoryClass() : zza.zza(activityManager)) * AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START * 0.33f);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzku
        /* renamed from: zza, reason: merged with bridge method [inline-methods] */
        public int sizeOf(zza.C0036zza c0036zza, Bitmap bitmap) {
            return bitmap.getHeight() * bitmap.getRowBytes();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzku
        /* renamed from: zza, reason: merged with bridge method [inline-methods] */
        public void entryRemoved(boolean z, zza.C0036zza c0036zza, Bitmap bitmap, Bitmap bitmap2) {
            super.entryRemoved(z, c0036zza, bitmap, bitmap2);
        }
    }

    private final class zzc implements Runnable {
        private final Uri mUri;
        private final ParcelFileDescriptor zzYZ;

        public zzc(Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
            this.mUri = uri;
            this.zzYZ = parcelFileDescriptor;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.google.android.gms.common.internal.zzb.zzbZ("LoadBitmapFromDiskRunnable can't be executed in the main thread");
            boolean z = false;
            Bitmap bitmap = null;
            if (this.zzYZ != null) {
                try {
                    bitmap = BitmapFactory.decodeFileDescriptor(this.zzYZ.getFileDescriptor());
                } catch (OutOfMemoryError e) {
                    Log.e("ImageManager", "OOM while loading bitmap for uri: " + this.mUri, e);
                    z = true;
                }
                try {
                    this.zzYZ.close();
                } catch (IOException e2) {
                    Log.e("ImageManager", "closed failed", e2);
                }
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            ImageManager.this.mHandler.post(ImageManager.this.new zzf(this.mUri, bitmap, z, countDownLatch));
            try {
                countDownLatch.await();
            } catch (InterruptedException e3) {
                Log.w("ImageManager", "Latch interrupted while posting " + this.mUri);
            }
        }
    }

    private final class zzd implements Runnable {
        private final com.google.android.gms.common.images.zza zzZa;

        public zzd(com.google.android.gms.common.images.zza zzaVar) {
            this.zzZa = zzaVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.google.android.gms.common.internal.zzb.zzbY("LoadImageRunnable must be executed on the main thread");
            ImageReceiver imageReceiver = (ImageReceiver) ImageManager.this.zzYU.get(this.zzZa);
            if (imageReceiver != null) {
                ImageManager.this.zzYU.remove(this.zzZa);
                imageReceiver.zzc(this.zzZa);
            }
            zza.C0036zza c0036zza = this.zzZa.zzZc;
            if (c0036zza.uri == null) {
                this.zzZa.zza(ImageManager.this.mContext, ImageManager.this.zzYT, true);
                return;
            }
            Bitmap zza = ImageManager.this.zza(c0036zza);
            if (zza != null) {
                this.zzZa.zza(ImageManager.this.mContext, zza, true);
                return;
            }
            Long l = (Long) ImageManager.this.zzYW.get(c0036zza.uri);
            if (l != null) {
                if (SystemClock.elapsedRealtime() - l.longValue() < 3600000) {
                    this.zzZa.zza(ImageManager.this.mContext, ImageManager.this.zzYT, true);
                    return;
                }
                ImageManager.this.zzYW.remove(c0036zza.uri);
            }
            this.zzZa.zza(ImageManager.this.mContext, ImageManager.this.zzYT);
            ImageReceiver imageReceiver2 = (ImageReceiver) ImageManager.this.zzYV.get(c0036zza.uri);
            if (imageReceiver2 == null) {
                imageReceiver2 = ImageManager.this.new ImageReceiver(c0036zza.uri);
                ImageManager.this.zzYV.put(c0036zza.uri, imageReceiver2);
            }
            imageReceiver2.zzb(this.zzZa);
            if (!(this.zzZa instanceof zza.zzc)) {
                ImageManager.this.zzYU.put(this.zzZa, imageReceiver2);
            }
            synchronized (ImageManager.zzYN) {
                if (!ImageManager.zzYO.contains(c0036zza.uri)) {
                    ImageManager.zzYO.add(c0036zza.uri);
                    imageReceiver2.zzno();
                }
            }
        }
    }

    private static final class zze implements ComponentCallbacks2 {
        private final zzb zzYS;

        public zze(zzb zzbVar) {
            this.zzYS = zzbVar;
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
            this.zzYS.evictAll();
        }

        @Override // android.content.ComponentCallbacks2
        public void onTrimMemory(int i) {
            if (i >= 60) {
                this.zzYS.evictAll();
            } else if (i >= 20) {
                this.zzYS.trimToSize(this.zzYS.size() / 2);
            }
        }
    }

    private final class zzf implements Runnable {
        private final Bitmap mBitmap;
        private final Uri mUri;
        private boolean zzZb;
        private final CountDownLatch zzoD;

        public zzf(Uri uri, Bitmap bitmap, boolean z, CountDownLatch countDownLatch) {
            this.mUri = uri;
            this.mBitmap = bitmap;
            this.zzZb = z;
            this.zzoD = countDownLatch;
        }

        private void zza(ImageReceiver imageReceiver, boolean z) {
            ArrayList arrayList = imageReceiver.zzYX;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                com.google.android.gms.common.images.zza zzaVar = (com.google.android.gms.common.images.zza) arrayList.get(i);
                ImageManager imageManager = ImageManager.this;
                if (z) {
                    zzaVar.zza(imageManager.mContext, this.mBitmap, false);
                } else {
                    imageManager.zzYW.put(this.mUri, Long.valueOf(SystemClock.elapsedRealtime()));
                    zzaVar.zza(ImageManager.this.mContext, ImageManager.this.zzYT, false);
                }
                if (!(zzaVar instanceof zza.zzc)) {
                    ImageManager.this.zzYU.remove(zzaVar);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            com.google.android.gms.common.internal.zzb.zzbY("OnBitmapLoadedRunnable must be executed in the main thread");
            boolean z = this.mBitmap != null;
            if (ImageManager.this.zzYS != null) {
                if (this.zzZb) {
                    ImageManager.this.zzYS.evictAll();
                    System.gc();
                    this.zzZb = false;
                    ImageManager.this.mHandler.post(this);
                    return;
                }
                if (z) {
                    ImageManager.this.zzYS.put(new zza.C0036zza(this.mUri), this.mBitmap);
                }
            }
            ImageReceiver imageReceiver = (ImageReceiver) ImageManager.this.zzYV.remove(this.mUri);
            if (imageReceiver != null) {
                zza(imageReceiver, z);
            }
            this.zzoD.countDown();
            synchronized (ImageManager.zzYN) {
                ImageManager.zzYO.remove(this.mUri);
            }
        }
    }

    private ImageManager(Context context, boolean z) {
        this.mContext = context.getApplicationContext();
        if (z) {
            this.zzYS = new zzb(this.mContext);
            if (zzlk.zzoU()) {
                zznl();
            }
        } else {
            this.zzYS = null;
        }
        this.zzYT = new zzkj();
        this.zzYU = new HashMap();
        this.zzYV = new HashMap();
        this.zzYW = new HashMap();
    }

    public static ImageManager create(Context context) {
        return zzb(context, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap zza(zza.C0036zza c0036zza) {
        if (this.zzYS == null) {
            return null;
        }
        return this.zzYS.get(c0036zza);
    }

    public static ImageManager zzb(Context context, boolean z) {
        if (z) {
            if (zzYQ == null) {
                zzYQ = new ImageManager(context, true);
            }
            return zzYQ;
        }
        if (zzYP == null) {
            zzYP = new ImageManager(context, false);
        }
        return zzYP;
    }

    private void zznl() {
        this.mContext.registerComponentCallbacks(new zze(this.zzYS));
    }

    public void loadImage(ImageView imageView, int i) {
        zza(new zza.zzb(imageView, i));
    }

    public void loadImage(ImageView imageView, Uri uri) {
        zza(new zza.zzb(imageView, uri));
    }

    public void loadImage(ImageView imageView, Uri uri, int i) {
        zza.zzb zzbVar = new zza.zzb(imageView, uri);
        zzbVar.zzbm(i);
        zza(zzbVar);
    }

    public void loadImage(OnImageLoadedListener onImageLoadedListener, Uri uri) {
        zza(new zza.zzc(onImageLoadedListener, uri));
    }

    public void loadImage(OnImageLoadedListener onImageLoadedListener, Uri uri, int i) {
        zza.zzc zzcVar = new zza.zzc(onImageLoadedListener, uri);
        zzcVar.zzbm(i);
        zza(zzcVar);
    }

    public void zza(com.google.android.gms.common.images.zza zzaVar) {
        com.google.android.gms.common.internal.zzb.zzbY("ImageManager.loadImage() must be called in the main thread");
        new zzd(zzaVar).run();
    }
}
