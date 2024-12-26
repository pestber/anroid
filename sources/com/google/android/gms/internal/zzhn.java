package com.google.android.gms.internal;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.MotionEvent;
import java.util.Map;

@zzgd
/* loaded from: classes.dex */
public class zzhn {
    private final Context mContext;
    private int mState;
    private String zzGo;
    private float zzGp;
    private float zzGq;
    private float zzGr;
    private final float zzyV;

    public zzhn(Context context) {
        this.mState = 0;
        this.mContext = context;
        this.zzyV = context.getResources().getDisplayMetrics().density;
    }

    public zzhn(Context context, String str) {
        this(context);
        this.zzGo = str;
    }

    private void showDialog() {
        if (!(this.mContext instanceof Activity)) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaA("Can not create dialog without Activity Context");
            return;
        }
        final String str = "No debug information";
        if (!TextUtils.isEmpty(this.zzGo)) {
            Uri build = new Uri.Builder().encodedQuery(this.zzGo).build();
            StringBuilder sb = new StringBuilder();
            Map<String, String> zzd = com.google.android.gms.ads.internal.zzo.zzbv().zzd(build);
            for (String str2 : zzd.keySet()) {
                sb.append(str2).append(" = ").append(zzd.get(str2)).append("\n\n");
            }
            String trim = sb.toString().trim();
            if (!TextUtils.isEmpty(trim)) {
                str = trim;
            }
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this.mContext);
        builder.setMessage(str);
        builder.setTitle("Ad Information");
        builder.setPositiveButton("Share", new DialogInterface.OnClickListener() { // from class: com.google.android.gms.internal.zzhn.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                zzhn.this.mContext.startActivity(Intent.createChooser(new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", str), "Share via"));
            }
        });
        builder.setNegativeButton("Close", new DialogInterface.OnClickListener() { // from class: com.google.android.gms.internal.zzhn.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        builder.create().show();
    }

    void zza(int i, float f, float f2) {
        if (i == 0) {
            this.mState = 0;
            this.zzGp = f;
            this.zzGq = f2;
            this.zzGr = f2;
            return;
        }
        if (this.mState == -1) {
            return;
        }
        if (i != 2) {
            if (i == 1 && this.mState == 4) {
                showDialog();
                return;
            }
            return;
        }
        if (f2 > this.zzGq) {
            this.zzGq = f2;
        } else if (f2 < this.zzGr) {
            this.zzGr = f2;
        }
        if (this.zzGq - this.zzGr > this.zzyV * 30.0f) {
            this.mState = -1;
            return;
        }
        if (this.mState == 0 || this.mState == 2 ? f - this.zzGp >= this.zzyV * 50.0f : !((this.mState != 1 && this.mState != 3) || f - this.zzGp > this.zzyV * (-50.0f))) {
            this.zzGp = f;
            this.mState++;
        }
        if (this.mState == 1 || this.mState == 3) {
            if (f <= this.zzGp) {
                return;
            }
        } else if (this.mState != 2 || f >= this.zzGp) {
            return;
        }
        this.zzGp = f;
    }

    public void zzaw(String str) {
        this.zzGo = str;
    }

    public void zzd(MotionEvent motionEvent) {
        int historySize = motionEvent.getHistorySize();
        for (int i = 0; i < historySize; i++) {
            zza(motionEvent.getActionMasked(), motionEvent.getHistoricalX(0, i), motionEvent.getHistoricalY(0, i));
        }
        zza(motionEvent.getActionMasked(), motionEvent.getX(), motionEvent.getY());
    }
}
