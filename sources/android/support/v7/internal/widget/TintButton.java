package android.support.v7.internal.widget;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

/* loaded from: classes.dex */
public class TintButton extends Button {
    private static final int[] TINT_ATTRS = {R.attr.background, R.attr.textAppearance};
    private final TintManager mTintManager;

    public TintButton(Context context) {
        this(context, null);
    }

    public TintButton(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.buttonStyle);
    }

    public TintButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TintTypedArray a = TintTypedArray.obtainStyledAttributes(context, attrs, TINT_ATTRS, defStyleAttr, 0);
        if (a.hasValue(0)) {
            setBackgroundDrawable(a.getDrawable(0));
        }
        this.mTintManager = a.getTintManager();
    }

    @Override // android.view.View
    public void setBackgroundResource(int resid) {
        setBackgroundDrawable(this.mTintManager.getDrawable(resid));
    }
}
