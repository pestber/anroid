package com.google.android.gms.common;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.internal.zzy;
import com.google.android.gms.dynamic.zzg;

/* loaded from: classes.dex */
public final class SignInButton extends FrameLayout implements View.OnClickListener {
    public static final int COLOR_DARK = 0;
    public static final int COLOR_LIGHT = 1;
    public static final int SIZE_ICON_ONLY = 2;
    public static final int SIZE_STANDARD = 0;
    public static final int SIZE_WIDE = 1;
    private int mColor;
    private int mSize;
    private View zzVZ;
    private View.OnClickListener zzWa;

    public SignInButton(Context context) {
        this(context, null);
    }

    public SignInButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SignInButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.zzWa = null;
        setStyle(0, 0);
    }

    private static Button zza(Context context, int i, int i2) {
        zzy zzyVar = new zzy(context);
        zzyVar.zza(context.getResources(), i, i2);
        return zzyVar;
    }

    private void zzaf(Context context) {
        if (this.zzVZ != null) {
            removeView(this.zzVZ);
        }
        try {
            this.zzVZ = zzx.zzb(context, this.mSize, this.mColor);
        } catch (zzg.zza e) {
            Log.w("SignInButton", "Sign in button not found, using placeholder instead");
            this.zzVZ = zza(context, this.mSize, this.mColor);
        }
        addView(this.zzVZ);
        this.zzVZ.setEnabled(isEnabled());
        this.zzVZ.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.zzWa == null || view != this.zzVZ) {
            return;
        }
        this.zzWa.onClick(this);
    }

    public void setColorScheme(int i) {
        setStyle(this.mSize, i);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.zzVZ.setEnabled(z);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.zzWa = onClickListener;
        if (this.zzVZ != null) {
            this.zzVZ.setOnClickListener(this);
        }
    }

    public void setSize(int i) {
        setStyle(i, this.mColor);
    }

    public void setStyle(int i, int i2) {
        zzu.zza(i >= 0 && i < 3, "Unknown button size %d", Integer.valueOf(i));
        zzu.zza(i2 >= 0 && i2 < 2, "Unknown color scheme %s", Integer.valueOf(i2));
        this.mSize = i;
        this.mColor = i2;
        zzaf(getContext());
    }
}
