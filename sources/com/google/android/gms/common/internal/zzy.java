package com.google.android.gms.common.internal;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;

/* loaded from: classes.dex */
public final class zzy extends Button {
    public zzy(Context context) {
        this(context, null);
    }

    public zzy(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.buttonStyle);
    }

    private void zza(Resources resources) {
        setTypeface(Typeface.DEFAULT_BOLD);
        setTextSize(14.0f);
        int i = (int) ((resources.getDisplayMetrics().density * 48.0f) + 0.5f);
        setMinHeight(i);
        setMinWidth(i);
    }

    private int zzb(int i, int i2, int i3) {
        switch (i) {
            case 0:
                return i2;
            case 1:
                return i3;
            default:
                throw new IllegalStateException("Unknown color scheme: " + i);
        }
    }

    private void zzb(Resources resources, int i, int i2) {
        int i3;
        int i4;
        switch (i) {
            case 0:
            case 1:
                i3 = com.google.android.gms.R.drawable.common_signin_btn_text_dark;
                i4 = com.google.android.gms.R.drawable.common_signin_btn_text_light;
                break;
            case 2:
                i3 = com.google.android.gms.R.drawable.common_signin_btn_icon_dark;
                i4 = com.google.android.gms.R.drawable.common_signin_btn_icon_light;
                break;
            default:
                throw new IllegalStateException("Unknown button size: " + i);
        }
        int zzb = zzb(i2, i3, i4);
        if (zzb == -1) {
            throw new IllegalStateException("Could not find background resource!");
        }
        setBackgroundDrawable(resources.getDrawable(zzb));
    }

    private void zzc(Resources resources, int i, int i2) {
        int i3;
        String string;
        setTextColor(resources.getColorStateList(zzb(i2, com.google.android.gms.R.color.common_signin_btn_text_dark, com.google.android.gms.R.color.common_signin_btn_text_light)));
        switch (i) {
            case 0:
                i3 = com.google.android.gms.R.string.common_signin_button_text;
                string = resources.getString(i3);
                setText(string);
                return;
            case 1:
                i3 = com.google.android.gms.R.string.common_signin_button_text_long;
                string = resources.getString(i3);
                setText(string);
                return;
            case 2:
                string = null;
                setText(string);
                return;
            default:
                throw new IllegalStateException("Unknown button size: " + i);
        }
    }

    public void zza(Resources resources, int i, int i2) {
        zzu.zza(i >= 0 && i < 3, "Unknown button size %d", Integer.valueOf(i));
        zzu.zza(i2 >= 0 && i2 < 2, "Unknown color scheme %s", Integer.valueOf(i2));
        zza(resources);
        zzb(resources, i, i2);
        zzc(resources, i, i2);
    }
}
