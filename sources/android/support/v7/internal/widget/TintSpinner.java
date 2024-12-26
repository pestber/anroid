package android.support.v7.internal.widget;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ListPopupWindow;
import android.widget.Spinner;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public class TintSpinner extends Spinner {
    private static final int[] TINT_ATTRS = {R.attr.background, R.attr.popupBackground};

    public TintSpinner(Context context) {
        this(context, null);
    }

    public TintSpinner(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.spinnerStyle);
    }

    public TintSpinner(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TintTypedArray a = TintTypedArray.obtainStyledAttributes(context, attrs, TINT_ATTRS, defStyleAttr, 0);
        setBackgroundDrawable(a.getDrawable(0));
        if (a.hasValue(1)) {
            Drawable background = a.getDrawable(1);
            setPopupBackgroundDrawable(background);
        }
        a.recycle();
    }

    private static void setPopupBackgroundDrawableV11(Spinner view, Drawable background) {
        try {
            Field popupField = Spinner.class.getDeclaredField("mPopup");
            popupField.setAccessible(true);
            Object popup = popupField.get(view);
            if (popup instanceof ListPopupWindow) {
                ((ListPopupWindow) popup).setBackgroundDrawable(background);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        }
    }
}
