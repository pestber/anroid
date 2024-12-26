package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.google.android.gms.ads.internal.zzo;
import com.google.android.gms.internal.zzgd;
import com.google.android.gms.internal.zzhl;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@zzgd
/* loaded from: classes.dex */
public class zzi extends SurfaceView implements AudioManager.OnAudioFocusChangeListener, MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener, SurfaceHolder.Callback {
    private static final Map<Integer, String> zzzU = new HashMap();
    private int zzAa;
    private int zzAb;
    private int zzAc;
    private int zzAd;
    private int zzAe;
    private float zzAf;
    private boolean zzAg;
    private boolean zzAh;
    private int zzAi;
    private zzg zzAj;
    private int zzzV;
    private int zzzW;
    private SurfaceHolder zzzX;
    private MediaPlayer zzzY;
    private Uri zzzZ;

    static {
        zzzU.put(-1004, "MEDIA_ERROR_IO");
        zzzU.put(-1007, "MEDIA_ERROR_MALFORMED");
        zzzU.put(-1010, "MEDIA_ERROR_UNSUPPORTED");
        zzzU.put(-110, "MEDIA_ERROR_TIMED_OUT");
        zzzU.put(100, "MEDIA_ERROR_SERVER_DIED");
        zzzU.put(1, "MEDIA_ERROR_UNKNOWN");
        zzzU.put(1, "MEDIA_INFO_UNKNOWN");
        zzzU.put(700, "MEDIA_INFO_VIDEO_TRACK_LAGGING");
        zzzU.put(3, "MEDIA_INFO_VIDEO_RENDERING_START");
        zzzU.put(701, "MEDIA_INFO_BUFFERING_START");
        zzzU.put(702, "MEDIA_INFO_BUFFERING_END");
        zzzU.put(800, "MEDIA_INFO_BAD_INTERLEAVING");
        zzzU.put(801, "MEDIA_INFO_NOT_SEEKABLE");
        zzzU.put(802, "MEDIA_INFO_METADATA_UPDATE");
        zzzU.put(901, "MEDIA_INFO_UNSUPPORTED_SUBTITLE");
        zzzU.put(902, "MEDIA_INFO_SUBTITLE_TIMED_OUT");
    }

    public zzi(Context context) {
        super(context);
        this.zzzV = 0;
        this.zzzW = 0;
        this.zzAf = 1.0f;
        getHolder().addCallback(this);
    }

    private void zzb(float f) {
        if (this.zzzY == null) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("AdVideoView setMediaPlayerVolume() called before onPrepared().");
        } else {
            try {
                this.zzzY.setVolume(f, f);
            } catch (IllegalStateException e) {
            }
        }
    }

    private void zzeP() {
        com.google.android.gms.ads.internal.util.client.zzb.zzaB("AdVideoView init MediaPlayer");
        if (this.zzzZ == null || this.zzzX == null) {
            return;
        }
        zzv(false);
        try {
            this.zzzY = new MediaPlayer();
            this.zzzY.setOnBufferingUpdateListener(this);
            this.zzzY.setOnCompletionListener(this);
            this.zzzY.setOnErrorListener(this);
            this.zzzY.setOnInfoListener(this);
            this.zzzY.setOnPreparedListener(this);
            this.zzzY.setOnVideoSizeChangedListener(this);
            this.zzAe = 0;
            this.zzzY.setDataSource(getContext(), this.zzzZ);
            this.zzzY.setDisplay(this.zzzX);
            this.zzzY.setAudioStreamType(3);
            this.zzzY.setScreenOnWhilePlaying(true);
            this.zzzY.prepareAsync();
            this.zzzV = 1;
        } catch (IOException | IllegalArgumentException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to initialize MediaPlayer at " + this.zzzZ, e);
            onError(this.zzzY, 1, 0);
        }
    }

    private void zzeQ() {
        if (!zzeT() || this.zzzW == 3) {
            return;
        }
        com.google.android.gms.ads.internal.util.client.zzb.zzaB("AdVideoView nudging MediaPlayer");
        this.zzzY.start();
        int currentPosition = this.zzzY.getCurrentPosition();
        long currentTimeMillis = zzo.zzbz().currentTimeMillis();
        while (zzeT() && this.zzzY.getCurrentPosition() == currentPosition && zzo.zzbz().currentTimeMillis() - currentTimeMillis <= 250) {
        }
        this.zzzY.pause();
    }

    private void zzeR() {
        AudioManager zzeX = zzeX();
        if (zzeX == null || this.zzAh) {
            return;
        }
        if (zzeX.requestAudioFocus(this, 3, 2) == 1) {
            zzeU();
        } else {
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("AdVideoView audio focus request failed");
        }
    }

    private void zzeS() {
        com.google.android.gms.ads.internal.util.client.zzb.zzaB("AdVideoView abandon audio focus");
        AudioManager zzeX = zzeX();
        if (zzeX == null || !this.zzAh) {
            return;
        }
        if (zzeX.abandonAudioFocus(this) == 1) {
            this.zzAh = false;
        } else {
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("AdVideoView abandon audio focus failed");
        }
    }

    private boolean zzeT() {
        return (this.zzzY == null || this.zzzV == -1 || this.zzzV == 0 || this.zzzV == 1) ? false : true;
    }

    private void zzeU() {
        com.google.android.gms.ads.internal.util.client.zzb.zzaB("AdVideoView audio focus gained");
        this.zzAh = true;
        zzeW();
    }

    private void zzeV() {
        com.google.android.gms.ads.internal.util.client.zzb.zzaB("AdVideoView audio focus lost");
        this.zzAh = false;
        zzeW();
    }

    private void zzeW() {
        zzb((this.zzAg || !this.zzAh) ? 0.0f : this.zzAf);
    }

    private AudioManager zzeX() {
        return (AudioManager) getContext().getSystemService("audio");
    }

    private void zzv(boolean z) {
        com.google.android.gms.ads.internal.util.client.zzb.zzaB("AdVideoView release");
        if (this.zzzY != null) {
            this.zzzY.reset();
            this.zzzY.release();
            this.zzzY = null;
            this.zzzV = 0;
            if (z) {
                this.zzzW = 0;
            }
            zzeS();
        }
    }

    public int getCurrentPosition() {
        if (zzeT()) {
            return this.zzzY.getCurrentPosition();
        }
        return 0;
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public void onAudioFocusChange(int i) {
        if (i > 0) {
            zzeU();
        } else if (i < 0) {
            zzeV();
        }
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        this.zzAe = i;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        com.google.android.gms.ads.internal.util.client.zzb.zzaB("AdVideoView completion");
        this.zzzV = 5;
        this.zzzW = 5;
        zzhl.zzGk.post(new Runnable() { // from class: com.google.android.gms.ads.internal.overlay.zzi.2
            @Override // java.lang.Runnable
            public void run() {
                if (zzi.this.zzAj != null) {
                    zzi.this.zzAj.zzeF();
                }
            }
        });
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        final String str = zzzU.get(Integer.valueOf(i));
        final String str2 = zzzU.get(Integer.valueOf(i2));
        com.google.android.gms.ads.internal.util.client.zzb.zzaC("AdVideoView MediaPlayer error: " + str + ":" + str2);
        this.zzzV = -1;
        this.zzzW = -1;
        zzhl.zzGk.post(new Runnable() { // from class: com.google.android.gms.ads.internal.overlay.zzi.3
            @Override // java.lang.Runnable
            public void run() {
                if (zzi.this.zzAj != null) {
                    zzi.this.zzAj.zzg(str, str2);
                }
            }
        });
        return true;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        com.google.android.gms.ads.internal.util.client.zzb.zzaB("AdVideoView MediaPlayer info: " + zzzU.get(Integer.valueOf(i)) + ":" + zzzU.get(Integer.valueOf(i2)));
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x003f, code lost:
    
        if ((r8.zzAa * r3) > (r8.zzAb * r1)) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0041, code lost:
    
        r0 = (r8.zzAb * r1) / r8.zzAa;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0054, code lost:
    
        if (r0 > r3) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0065, code lost:
    
        if (r2 > r1) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007f, code lost:
    
        if (r2 > r1) goto L14;
     */
    @Override // android.view.SurfaceView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onMeasure(int r9, int r10) {
        /*
            r8 = this;
            int r0 = r8.zzAa
            int r0 = getDefaultSize(r0, r9)
            int r1 = r8.zzAb
            int r1 = getDefaultSize(r1, r10)
            int r2 = r8.zzAa
            if (r2 <= 0) goto L82
            int r2 = r8.zzAb
            if (r2 <= 0) goto L82
            int r0 = android.view.View.MeasureSpec.getMode(r9)
            int r1 = android.view.View.MeasureSpec.getSize(r9)
            int r2 = android.view.View.MeasureSpec.getMode(r10)
            int r3 = android.view.View.MeasureSpec.getSize(r10)
            r4 = 1073741824(0x40000000, float:2.0)
            if (r0 != r4) goto L48
            if (r2 != r4) goto L48
            int r0 = r8.zzAa
            int r0 = r0 * r3
            int r2 = r8.zzAb
            int r2 = r2 * r1
            if (r0 >= r2) goto L39
            int r0 = r8.zzAa
            int r0 = r0 * r3
            int r1 = r8.zzAb
            int r0 = r0 / r1
            goto L6a
        L39:
            int r0 = r8.zzAa
            int r0 = r0 * r3
            int r2 = r8.zzAb
            int r2 = r2 * r1
            if (r0 <= r2) goto L67
        L41:
            int r0 = r8.zzAb
            int r0 = r0 * r1
            int r2 = r8.zzAa
            int r0 = r0 / r2
            goto L57
        L48:
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 != r4) goto L5b
            int r0 = r8.zzAb
            int r0 = r0 * r1
            int r4 = r8.zzAa
            int r0 = r0 / r4
            if (r2 != r5) goto L57
            if (r0 <= r3) goto L57
            goto L67
        L57:
            r7 = r1
            r1 = r0
            r0 = r7
            goto L82
        L5b:
            if (r2 != r4) goto L6c
            int r2 = r8.zzAa
            int r2 = r2 * r3
            int r4 = r8.zzAb
            int r2 = r2 / r4
            if (r0 != r5) goto L69
            if (r2 <= r1) goto L69
        L67:
            r0 = r1
            goto L6a
        L69:
            r0 = r2
        L6a:
            r1 = r3
            goto L82
        L6c:
            int r4 = r8.zzAa
            int r6 = r8.zzAb
            if (r2 != r5) goto L7b
            if (r6 <= r3) goto L7b
            int r2 = r8.zzAa
            int r2 = r2 * r3
            int r4 = r8.zzAb
            int r2 = r2 / r4
            goto L7d
        L7b:
            r2 = r4
            r3 = r6
        L7d:
            if (r0 != r5) goto L69
            if (r2 <= r1) goto L69
            goto L41
        L82:
            r8.setMeasuredDimension(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.overlay.zzi.onMeasure(int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0070, code lost:
    
        if (r4.zzzW == 3) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0077, code lost:
    
        play();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0075, code lost:
    
        if (r4.zzzW == 3) goto L18;
     */
    @Override // android.media.MediaPlayer.OnPreparedListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onPrepared(final android.media.MediaPlayer r5) {
        /*
            r4 = this;
            java.lang.String r0 = "AdVideoView prepared"
            com.google.android.gms.ads.internal.util.client.zzb.zzaB(r0)
            r0 = 2
            r4.zzzV = r0
            android.os.Handler r0 = com.google.android.gms.internal.zzhl.zzGk
            com.google.android.gms.ads.internal.overlay.zzi$1 r1 = new com.google.android.gms.ads.internal.overlay.zzi$1
            r1.<init>()
            r0.post(r1)
            int r0 = r5.getVideoWidth()
            r4.zzAa = r0
            int r0 = r5.getVideoHeight()
            r4.zzAb = r0
            int r0 = r4.zzAi
            if (r0 == 0) goto L27
            int r0 = r4.zzAi
            r4.seekTo(r0)
        L27:
            r4.zzeQ()
            int r0 = r4.zzAa
            r1 = 3
            if (r0 == 0) goto L73
            int r0 = r4.zzAb
            if (r0 == 0) goto L73
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "AdVideoView stream dimensions: "
            java.lang.StringBuilder r0 = r0.append(r2)
            int r2 = r4.zzAa
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r2 = " x "
            java.lang.StringBuilder r0 = r0.append(r2)
            int r2 = r4.zzAb
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.google.android.gms.ads.internal.util.client.zzb.zzaA(r0)
            android.view.SurfaceHolder r0 = r4.getHolder()
            int r2 = r4.zzAa
            int r3 = r4.zzAb
            r0.setFixedSize(r2, r3)
            int r0 = r4.zzAc
            int r2 = r4.zzAa
            if (r0 != r2) goto L7a
            int r0 = r4.zzAd
            int r2 = r4.zzAb
            if (r0 != r2) goto L7a
            int r0 = r4.zzzW
            if (r0 != r1) goto L7a
            goto L77
        L73:
            int r0 = r4.zzzW
            if (r0 != r1) goto L7a
        L77:
            r4.play()
        L7a:
            r4.zzeR()
            r4.zzeW()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.overlay.zzi.onPrepared(android.media.MediaPlayer):void");
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        com.google.android.gms.ads.internal.util.client.zzb.zzaB("AdVideoView size changed: " + i + " x " + i2);
        this.zzAa = mediaPlayer.getVideoWidth();
        this.zzAb = mediaPlayer.getVideoHeight();
        if (this.zzAa == 0 || this.zzAb == 0) {
            return;
        }
        getHolder().setFixedSize(this.zzAa, this.zzAb);
        requestLayout();
    }

    public void pause() {
        com.google.android.gms.ads.internal.util.client.zzb.zzaB("AdVideoView pause");
        if (zzeT() && this.zzzY.isPlaying()) {
            this.zzzY.pause();
            this.zzzV = 4;
            zzhl.zzGk.post(new Runnable() { // from class: com.google.android.gms.ads.internal.overlay.zzi.7
                @Override // java.lang.Runnable
                public void run() {
                    if (zzi.this.zzAj != null) {
                        zzi.this.zzAj.onPaused();
                    }
                }
            });
        }
        this.zzzW = 4;
    }

    public void play() {
        com.google.android.gms.ads.internal.util.client.zzb.zzaB("AdVideoView play");
        if (zzeT()) {
            this.zzzY.start();
            this.zzzV = 3;
            zzhl.zzGk.post(new Runnable() { // from class: com.google.android.gms.ads.internal.overlay.zzi.6
                @Override // java.lang.Runnable
                public void run() {
                    if (zzi.this.zzAj != null) {
                        zzi.this.zzAj.zzeE();
                    }
                }
            });
        }
        this.zzzW = 3;
    }

    public void seekTo(int i) {
        com.google.android.gms.ads.internal.util.client.zzb.zzaB("AdVideoView seek " + i);
        if (!zzeT()) {
            this.zzAi = i;
        } else {
            this.zzzY.seekTo(i);
            this.zzAi = 0;
        }
    }

    public void setVideoPath(String str) {
        setVideoURI(Uri.parse(str));
    }

    public void setVideoURI(Uri uri) {
        this.zzzZ = uri;
        this.zzAi = 0;
        zzeP();
        requestLayout();
        invalidate();
    }

    public void stop() {
        com.google.android.gms.ads.internal.util.client.zzb.zzaB("AdVideoView stop");
        if (this.zzzY != null) {
            this.zzzY.stop();
            this.zzzY.release();
            this.zzzY = null;
            this.zzzV = 0;
            this.zzzW = 0;
            zzeS();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        com.google.android.gms.ads.internal.util.client.zzb.zzaB("AdVideoView surface changed");
        this.zzAc = i2;
        this.zzAd = i3;
        boolean z = this.zzzW == 3;
        boolean z2 = this.zzAa == i2 && this.zzAb == i3;
        if (this.zzzY != null && z && z2) {
            if (this.zzAi != 0) {
                seekTo(this.zzAi);
            }
            play();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        com.google.android.gms.ads.internal.util.client.zzb.zzaB("AdVideoView surface created");
        this.zzzX = surfaceHolder;
        zzeP();
        zzhl.zzGk.post(new Runnable() { // from class: com.google.android.gms.ads.internal.overlay.zzi.4
            @Override // java.lang.Runnable
            public void run() {
                if (zzi.this.zzAj != null) {
                    zzi.this.zzAj.zzeD();
                }
            }
        });
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        com.google.android.gms.ads.internal.util.client.zzb.zzaB("AdVideoView surface destroyed");
        if (this.zzzY != null && this.zzAi == 0) {
            this.zzAi = this.zzzY.getCurrentPosition();
        }
        this.zzzX = null;
        zzhl.zzGk.post(new Runnable() { // from class: com.google.android.gms.ads.internal.overlay.zzi.5
            @Override // java.lang.Runnable
            public void run() {
                if (zzi.this.zzAj != null) {
                    zzi.this.zzAj.onPaused();
                    zzi.this.zzAj.zzeG();
                }
            }
        });
        zzv(true);
    }

    @Override // android.view.View
    public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }

    public void zza(float f) {
        this.zzAf = f;
        zzeW();
    }

    public void zza(zzg zzgVar) {
        this.zzAj = zzgVar;
    }

    public void zzeI() {
        this.zzAg = true;
        zzeW();
    }

    public void zzeJ() {
        this.zzAg = false;
        zzeW();
    }
}
