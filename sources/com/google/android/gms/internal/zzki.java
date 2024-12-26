package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.graphics.Path;
import android.net.Uri;
import android.widget.ImageView;

/* loaded from: classes.dex */
public final class zzki extends ImageView {
    private Uri zzZF;
    private int zzZG;
    private int zzZH;
    private zza zzZI;
    private int zzZJ;
    private float zzZK;

    public interface zza {
        Path zzk(int i, int i2);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.zzZI != null) {
            canvas.clipPath(this.zzZI.zzk(getWidth(), getHeight()));
        }
        super.onDraw(canvas);
        if (this.zzZH != 0) {
            canvas.drawColor(this.zzZH);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        int measuredHeight;
        int i3;
        super.onMeasure(i, i2);
        switch (this.zzZJ) {
            case 1:
                measuredHeight = getMeasuredHeight();
                i3 = (int) (measuredHeight * this.zzZK);
                break;
            case 2:
                i3 = getMeasuredWidth();
                measuredHeight = (int) (i3 / this.zzZK);
                break;
            default:
                return;
        }
        setMeasuredDimension(i3, measuredHeight);
    }

    public void zzbo(int i) {
        this.zzZG = i;
    }

    public void zzi(Uri uri) {
        this.zzZF = uri;
    }

    public int zznr() {
        return this.zzZG;
    }
}
