package com.google.android.gms.tagmanager;

import android.net.Uri;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/* loaded from: classes.dex */
class zzcb {
    private static zzcb zzaME;
    private volatile String zzaKy;
    private volatile zza zzaMF;
    private volatile String zzaMG;
    private volatile String zzaMH;

    enum zza {
        NONE,
        CONTAINER,
        CONTAINER_DEBUG
    }

    zzcb() {
        clear();
    }

    private String zzeA(String str) {
        return str.split("&")[0].split("=")[1];
    }

    private String zzm(Uri uri) {
        return uri.getQuery().replace("&gtm_debug=x", "");
    }

    static zzcb zzzf() {
        zzcb zzcbVar;
        synchronized (zzcb.class) {
            if (zzaME == null) {
                zzaME = new zzcb();
            }
            zzcbVar = zzaME;
        }
        return zzcbVar;
    }

    void clear() {
        this.zzaMF = zza.NONE;
        this.zzaMG = null;
        this.zzaKy = null;
        this.zzaMH = null;
    }

    String getContainerId() {
        return this.zzaKy;
    }

    synchronized boolean zzl(Uri uri) {
        try {
            String decode = URLDecoder.decode(uri.toString(), "UTF-8");
            if (decode.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_auth=\\S+&gtm_preview=\\d+(&gtm_debug=x)?$")) {
                zzbg.zzaB("Container preview url: " + decode);
                this.zzaMF = decode.matches(".*?&gtm_debug=x$") ? zza.CONTAINER_DEBUG : zza.CONTAINER;
                this.zzaMH = zzm(uri);
                if (this.zzaMF == zza.CONTAINER || this.zzaMF == zza.CONTAINER_DEBUG) {
                    this.zzaMG = "/r?" + this.zzaMH;
                }
                this.zzaKy = zzeA(this.zzaMH);
                return true;
            }
            if (!decode.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_preview=$")) {
                zzbg.zzaC("Invalid preview uri: " + decode);
                return false;
            }
            if (!zzeA(uri.getQuery()).equals(this.zzaKy)) {
                return false;
            }
            zzbg.zzaB("Exit preview mode for container: " + this.zzaKy);
            this.zzaMF = zza.NONE;
            this.zzaMG = null;
            return true;
        } catch (UnsupportedEncodingException e) {
            return false;
        }
    }

    zza zzzg() {
        return this.zzaMF;
    }

    String zzzh() {
        return this.zzaMG;
    }
}
