package android.support.v7.internal.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public class ListViewCompat extends ListView {
    public static final int INVALID_POSITION = -1;
    public static final int NO_POSITION = -1;
    private static final int[] STATE_SET_NOTHING = {0};
    private Field mIsChildViewEnabled;
    int mSelectionBottomPadding;
    int mSelectionLeftPadding;
    int mSelectionRightPadding;
    int mSelectionTopPadding;
    private GateKeeperDrawable mSelector;
    final Rect mSelectorRect;

    public ListViewCompat(Context context) {
        this(context, null);
    }

    public ListViewCompat(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ListViewCompat(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mSelectorRect = new Rect();
        this.mSelectionLeftPadding = 0;
        this.mSelectionTopPadding = 0;
        this.mSelectionRightPadding = 0;
        this.mSelectionBottomPadding = 0;
        try {
            this.mIsChildViewEnabled = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.mIsChildViewEnabled.setAccessible(true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable sel) {
        this.mSelector = new GateKeeperDrawable(sel);
        super.setSelector(this.mSelector);
        Rect padding = new Rect();
        sel.getPadding(padding);
        this.mSelectionLeftPadding = padding.left;
        this.mSelectionTopPadding = padding.top;
        this.mSelectionRightPadding = padding.right;
        this.mSelectionBottomPadding = padding.bottom;
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.mSelector.setEnabled(true);
        updateSelectorStateCompat();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        drawSelectorCompat(canvas);
        super.dispatchDraw(canvas);
    }

    protected void updateSelectorStateCompat() {
        Drawable selector = getSelector();
        if (selector != null && shouldShowSelectorCompat()) {
            selector.setState(getDrawableState());
        }
    }

    protected boolean shouldShowSelectorCompat() {
        return touchModeDrawsInPressedStateCompat() && isPressed();
    }

    protected boolean touchModeDrawsInPressedStateCompat() {
        return false;
    }

    protected void drawSelectorCompat(Canvas canvas) {
        if (!this.mSelectorRect.isEmpty()) {
            Drawable selector = getSelector();
            selector.setBounds(this.mSelectorRect);
            selector.draw(canvas);
        }
    }

    public int lookForSelectablePosition(int position, boolean lookDown) {
        int position2;
        ListAdapter adapter = getAdapter();
        if (adapter == null || isInTouchMode()) {
            return -1;
        }
        int count = adapter.getCount();
        if (!getAdapter().areAllItemsEnabled()) {
            if (lookDown) {
                position2 = Math.max(0, position);
                while (position2 < count && !adapter.isEnabled(position2)) {
                    position2++;
                }
            } else {
                position2 = Math.min(position, count - 1);
                while (position2 >= 0 && !adapter.isEnabled(position2)) {
                    position2--;
                }
            }
            if (position2 < 0 || position2 >= count) {
                return -1;
            }
            return position2;
        }
        if (position < 0 || position >= count) {
            return -1;
        }
        return position;
    }

    protected void positionSelectorLikeTouchCompat(int position, View sel, float x, float y) {
        positionSelectorLikeFocusCompat(position, sel);
        Drawable selector = getSelector();
        if (selector != null && position != -1) {
            DrawableCompat.setHotspot(selector, x, y);
        }
    }

    protected void positionSelectorLikeFocusCompat(int position, View sel) {
        Drawable selector = getSelector();
        boolean manageState = (selector == null || position == -1) ? false : true;
        if (manageState) {
            selector.setVisible(false, false);
        }
        positionSelectorCompat(position, sel);
        if (manageState) {
            Rect bounds = this.mSelectorRect;
            float x = bounds.exactCenterX();
            float y = bounds.exactCenterY();
            selector.setVisible(getVisibility() == 0, false);
            DrawableCompat.setHotspot(selector, x, y);
        }
    }

    protected void positionSelectorCompat(int position, View sel) {
        Rect selectorRect = this.mSelectorRect;
        selectorRect.set(sel.getLeft(), sel.getTop(), sel.getRight(), sel.getBottom());
        selectorRect.left -= this.mSelectionLeftPadding;
        selectorRect.top -= this.mSelectionTopPadding;
        selectorRect.right += this.mSelectionRightPadding;
        selectorRect.bottom += this.mSelectionBottomPadding;
        try {
            boolean isChildViewEnabled = this.mIsChildViewEnabled.getBoolean(this);
            if (sel.isEnabled() != isChildViewEnabled) {
                this.mIsChildViewEnabled.set(this, Boolean.valueOf(!isChildViewEnabled));
                if (position != -1) {
                    refreshDrawableState();
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0082 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int measureHeightOfChildrenCompat(int r23, int r24, int r25, int r26, int r27) {
        /*
            r22 = this;
            r0 = r26
            r1 = r27
            int r2 = r22.getListPaddingTop()
            int r3 = r22.getListPaddingBottom()
            int r4 = r22.getListPaddingLeft()
            int r5 = r22.getListPaddingRight()
            int r6 = r22.getDividerHeight()
            android.graphics.drawable.Drawable r7 = r22.getDivider()
            android.widget.ListAdapter r8 = r22.getAdapter()
            if (r8 != 0) goto L25
            int r9 = r2 + r3
            return r9
        L25:
            int r9 = r2 + r3
            if (r6 <= 0) goto L2d
            if (r7 == 0) goto L2d
            r11 = r6
            goto L2e
        L2d:
            r11 = 0
        L2e:
            r12 = 0
            r13 = 0
            r14 = 0
            int r15 = r8.getCount()
            r16 = 0
            r10 = r16
        L39:
            if (r10 >= r15) goto L9c
            r17 = r2
            int r2 = r8.getItemViewType(r10)
            if (r2 == r14) goto L45
            r13 = 0
            r14 = r2
        L45:
            r18 = r2
            r2 = r22
            android.view.View r13 = r8.getView(r10, r13, r2)
            android.view.ViewGroup$LayoutParams r2 = r13.getLayoutParams()
            if (r2 == 0) goto L69
            r19 = r3
            int r3 = r2.height
            if (r3 <= 0) goto L66
            int r3 = r2.height
            r20 = r2
            r2 = 1073741824(0x40000000, float:2.0)
            int r2 = android.view.View.MeasureSpec.makeMeasureSpec(r3, r2)
            r3 = r2
            r2 = 0
            goto L72
        L66:
            r20 = r2
            goto L6d
        L69:
            r20 = r2
            r19 = r3
        L6d:
            r2 = 0
            int r3 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r2)
        L72:
            r2 = r23
            r13.measure(r2, r3)
            if (r10 <= 0) goto L7a
            int r9 = r9 + r11
        L7a:
            int r21 = r13.getMeasuredHeight()
            int r9 = r9 + r21
            if (r9 < r0) goto L90
            if (r1 < 0) goto L8d
            if (r10 <= r1) goto L8d
            if (r12 <= 0) goto L8d
            if (r9 == r0) goto L8d
            r16 = r12
            goto L8f
        L8d:
            r16 = r0
        L8f:
            return r16
        L90:
            if (r1 < 0) goto L95
            if (r10 < r1) goto L95
            r12 = r9
        L95:
            int r10 = r10 + 1
            r2 = r17
            r3 = r19
            goto L39
        L9c:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.internal.widget.ListViewCompat.measureHeightOfChildrenCompat(int, int, int, int, int):int");
    }

    protected void setSelectorEnabled(boolean enabled) {
        this.mSelector.setEnabled(enabled);
    }

    private static class GateKeeperDrawable extends DrawableWrapper {
        private boolean mEnabled;

        public GateKeeperDrawable(Drawable drawable) {
            super(drawable);
            this.mEnabled = true;
        }

        void setEnabled(boolean enabled) {
            this.mEnabled = enabled;
        }

        @Override // android.support.v7.internal.widget.DrawableWrapper, android.graphics.drawable.Drawable
        public boolean setState(int[] stateSet) {
            if (this.mEnabled) {
                return super.setState(stateSet);
            }
            return false;
        }

        @Override // android.support.v7.internal.widget.DrawableWrapper, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            if (this.mEnabled) {
                super.draw(canvas);
            }
        }

        @Override // android.support.v7.internal.widget.DrawableWrapper, android.graphics.drawable.Drawable
        public void setHotspot(float x, float y) {
            if (this.mEnabled) {
                super.setHotspot(x, y);
            }
        }

        @Override // android.support.v7.internal.widget.DrawableWrapper, android.graphics.drawable.Drawable
        public void setHotspotBounds(int left, int top, int right, int bottom) {
            if (this.mEnabled) {
                super.setHotspotBounds(left, top, right, bottom);
            }
        }

        @Override // android.support.v7.internal.widget.DrawableWrapper, android.graphics.drawable.Drawable
        public boolean setVisible(boolean visible, boolean restart) {
            if (this.mEnabled) {
                return super.setVisible(visible, restart);
            }
            return false;
        }
    }
}
