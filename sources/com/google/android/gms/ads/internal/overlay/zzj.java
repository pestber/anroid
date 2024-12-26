package com.google.android.gms.ads.internal.overlay;

import android.R;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.google.android.gms.internal.zzgd;

@zzgd
/* loaded from: classes.dex */
public class zzj extends FrameLayout implements View.OnClickListener {
    private final ImageButton zzAo;
    private final zzl zzAp;

    public zzj(Context context, int i, zzl zzlVar) {
        super(context);
        this.zzAp = zzlVar;
        setOnClickListener(this);
        this.zzAo = new ImageButton(context);
        this.zzAo.setImageResource(R.drawable.btn_dialog);
        this.zzAo.setBackgroundColor(0);
        this.zzAo.setOnClickListener(this);
        this.zzAo.setPadding(0, 0, 0, 0);
        this.zzAo.setContentDescription("Interstitial close button");
        int zzb = com.google.android.gms.ads.internal.client.zzk.zzcA().zzb(context, i);
        addView(this.zzAo, new FrameLayout.LayoutParams(zzb, zzb, 17));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.zzAp != null) {
            this.zzAp.zzes();
        }
    }

    public void zza(boolean z, boolean z2) {
        ImageButton imageButton;
        int i;
        if (!z2) {
            imageButton = this.zzAo;
            i = 0;
        } else if (z) {
            imageButton = this.zzAo;
            i = 4;
        } else {
            imageButton = this.zzAo;
            i = 8;
        }
        imageButton.setVisibility(i);
    }
}
