package android.support.v7.internal.widget;

import android.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.widget.RatingBar;
import com.google.android.gms.search.SearchAuth;

/* loaded from: classes.dex */
public class TintRatingBar extends RatingBar {
    private static final int[] TINT_ATTRS = {R.attr.indeterminateDrawable, R.attr.progressDrawable};
    private Bitmap mSampleTile;

    public TintRatingBar(Context context) {
        this(context, null);
    }

    public TintRatingBar(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.ratingBarStyle);
    }

    public TintRatingBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TintTypedArray a = TintTypedArray.obtainStyledAttributes(context, attrs, TINT_ATTRS, defStyleAttr, 0);
        Drawable drawable = a.getDrawable(0);
        if (drawable != null) {
            setIndeterminateDrawable(tileifyIndeterminate(drawable));
        }
        Drawable drawable2 = a.getDrawable(1);
        if (drawable2 != null) {
            setProgressDrawable(tileify(drawable2, false));
        }
        a.recycle();
    }

    private Drawable tileify(Drawable drawable, boolean clip) {
        if (drawable instanceof DrawableWrapper) {
            Drawable inner = ((DrawableWrapper) drawable).getWrappedDrawable();
            if (inner != null) {
                ((DrawableWrapper) drawable).setWrappedDrawable(tileify(inner, clip));
            }
        } else {
            if (drawable instanceof LayerDrawable) {
                LayerDrawable background = (LayerDrawable) drawable;
                int N = background.getNumberOfLayers();
                Drawable[] outDrawables = new Drawable[N];
                for (int i = 0; i < N; i++) {
                    int id = background.getId(i);
                    outDrawables[i] = tileify(background.getDrawable(i), id == 16908301 || id == 16908303);
                }
                LayerDrawable newBg = new LayerDrawable(outDrawables);
                for (int i2 = 0; i2 < N; i2++) {
                    newBg.setId(i2, background.getId(i2));
                }
                return newBg;
            }
            if (drawable instanceof BitmapDrawable) {
                Bitmap tileBitmap = ((BitmapDrawable) drawable).getBitmap();
                if (this.mSampleTile == null) {
                    this.mSampleTile = tileBitmap;
                }
                ShapeDrawable shapeDrawable = new ShapeDrawable(getDrawableShape());
                BitmapShader bitmapShader = new BitmapShader(tileBitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP);
                shapeDrawable.getPaint().setShader(bitmapShader);
                return clip ? new ClipDrawable(shapeDrawable, 3, 1) : shapeDrawable;
            }
        }
        return drawable;
    }

    private Drawable tileifyIndeterminate(Drawable drawable) {
        if (drawable instanceof AnimationDrawable) {
            AnimationDrawable background = (AnimationDrawable) drawable;
            int N = background.getNumberOfFrames();
            AnimationDrawable newBg = new AnimationDrawable();
            newBg.setOneShot(background.isOneShot());
            for (int i = 0; i < N; i++) {
                Drawable frame = tileify(background.getFrame(i), true);
                frame.setLevel(SearchAuth.StatusCodes.AUTH_DISABLED);
                newBg.addFrame(frame, background.getDuration(i));
            }
            newBg.setLevel(SearchAuth.StatusCodes.AUTH_DISABLED);
            return newBg;
        }
        return drawable;
    }

    private Shape getDrawableShape() {
        float[] roundedCorners = {5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f};
        return new RoundRectShape(roundedCorners, null, null);
    }

    @Override // android.widget.RatingBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (this.mSampleTile != null) {
            int width = this.mSampleTile.getWidth() * getNumStars();
            setMeasuredDimension(ViewCompat.resolveSizeAndState(width, widthMeasureSpec, 0), getMeasuredHeight());
        }
    }
}
