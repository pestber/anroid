package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.internal.client.zzy;

/* loaded from: classes.dex */
public final class PublisherAdView extends ViewGroup {
    private final zzy zznP;

    public PublisherAdView(Context context) {
        super(context);
        this.zznP = new zzy(this);
    }

    public PublisherAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.zznP = new zzy(this, attributeSet, true);
    }

    public PublisherAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.zznP = new zzy(this, attributeSet, true);
    }

    public void destroy() {
        this.zznP.destroy();
    }

    public AdListener getAdListener() {
        return this.zznP.getAdListener();
    }

    public AdSize getAdSize() {
        return this.zznP.getAdSize();
    }

    public AdSize[] getAdSizes() {
        return this.zznP.getAdSizes();
    }

    public String getAdUnitId() {
        return this.zznP.getAdUnitId();
    }

    public AppEventListener getAppEventListener() {
        return this.zznP.getAppEventListener();
    }

    public String getMediationAdapterClassName() {
        return this.zznP.getMediationAdapterClassName();
    }

    public OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.zznP.getOnCustomRenderedAdLoadedListener();
    }

    public void loadAd(PublisherAdRequest publisherAdRequest) {
        this.zznP.zza(publisherAdRequest.zzaF());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getVisibility() == 8) {
            return;
        }
        int measuredWidth = childAt.getMeasuredWidth();
        int measuredHeight = childAt.getMeasuredHeight();
        int i5 = ((i3 - i) - measuredWidth) / 2;
        int i6 = ((i4 - i2) - measuredHeight) / 2;
        childAt.layout(i5, i6, measuredWidth + i5, measuredHeight + i6);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4 = 0;
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getVisibility() == 8) {
            AdSize adSize = getAdSize();
            if (adSize != null) {
                Context context = getContext();
                int widthInPixels = adSize.getWidthInPixels(context);
                i3 = adSize.getHeightInPixels(context);
                i4 = widthInPixels;
            } else {
                i3 = 0;
            }
        } else {
            measureChild(childAt, i, i2);
            i4 = childAt.getMeasuredWidth();
            i3 = childAt.getMeasuredHeight();
        }
        setMeasuredDimension(View.resolveSize(Math.max(i4, getSuggestedMinimumWidth()), i), View.resolveSize(Math.max(i3, getSuggestedMinimumHeight()), i2));
    }

    public void pause() {
        this.zznP.pause();
    }

    public void recordManualImpression() {
        this.zznP.recordManualImpression();
    }

    public void resume() {
        this.zznP.resume();
    }

    public void setAdListener(AdListener adListener) {
        this.zznP.setAdListener(adListener);
    }

    public void setAdSizes(AdSize... adSizeArr) {
        if (adSizeArr == null || adSizeArr.length < 1) {
            throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
        }
        this.zznP.zza(adSizeArr);
    }

    public void setAdUnitId(String str) {
        this.zznP.setAdUnitId(str);
    }

    public void setAppEventListener(AppEventListener appEventListener) {
        this.zznP.setAppEventListener(appEventListener);
    }

    public void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.zznP.setOnCustomRenderedAdLoadedListener(onCustomRenderedAdLoadedListener);
    }
}
