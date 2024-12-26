package com.google.android.gms.games.internal;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.gms.internal.zzlk;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class PopupManager {
    protected GamesClientImpl zzaqt;
    protected PopupLocationInfo zzaqu;

    public static final class PopupLocationInfo {
        public int bottom;
        public int gravity;
        public int left;
        public int right;
        public int top;
        public IBinder zzaqv;
        public int zzaqw;

        private PopupLocationInfo(int i, IBinder iBinder) {
            this.zzaqw = -1;
            this.left = 0;
            this.top = 0;
            this.right = 0;
            this.bottom = 0;
            this.gravity = i;
            this.zzaqv = iBinder;
        }

        public Bundle zztc() {
            Bundle bundle = new Bundle();
            bundle.putInt("popupLocationInfo.gravity", this.gravity);
            bundle.putInt("popupLocationInfo.displayId", this.zzaqw);
            bundle.putInt("popupLocationInfo.left", this.left);
            bundle.putInt("popupLocationInfo.top", this.top);
            bundle.putInt("popupLocationInfo.right", this.right);
            bundle.putInt("popupLocationInfo.bottom", this.bottom);
            return bundle;
        }
    }

    private static final class PopupManagerHCMR1 extends PopupManager implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener {
        private boolean zzaoV;
        private WeakReference<View> zzaqx;

        protected PopupManagerHCMR1(GamesClientImpl gamesClientImpl, int i) {
            super(gamesClientImpl, i);
            this.zzaoV = false;
        }

        private void zzp(View view) {
            Display display;
            int i = -1;
            if (zzlk.zzoW() && (display = view.getDisplay()) != null) {
                i = display.getDisplayId();
            }
            IBinder windowToken = view.getWindowToken();
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            int width = view.getWidth();
            int height = view.getHeight();
            this.zzaqu.zzaqw = i;
            this.zzaqu.zzaqv = windowToken;
            this.zzaqu.left = iArr[0];
            this.zzaqu.top = iArr[1];
            this.zzaqu.right = iArr[0] + width;
            this.zzaqu.bottom = iArr[1] + height;
            if (this.zzaoV) {
                zztd();
                this.zzaoV = false;
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            View view;
            if (this.zzaqx == null || (view = this.zzaqx.get()) == null) {
                return;
            }
            zzp(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            zzp(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            this.zzaqt.zzsR();
            view.removeOnAttachStateChangeListener(this);
        }

        @Override // com.google.android.gms.games.internal.PopupManager
        protected void zzfF(int i) {
            this.zzaqu = new PopupLocationInfo(i, null);
        }

        @Override // com.google.android.gms.games.internal.PopupManager
        public void zzo(View view) {
            this.zzaqt.zzsR();
            if (this.zzaqx != null) {
                View view2 = this.zzaqx.get();
                Context context = this.zzaqt.getContext();
                if (view2 == null && (context instanceof Activity)) {
                    view2 = ((Activity) context).getWindow().getDecorView();
                }
                if (view2 != null) {
                    view2.removeOnAttachStateChangeListener(this);
                    ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
                    if (zzlk.zzoV()) {
                        viewTreeObserver.removeOnGlobalLayoutListener(this);
                    } else {
                        viewTreeObserver.removeGlobalOnLayoutListener(this);
                    }
                }
            }
            this.zzaqx = null;
            Context context2 = this.zzaqt.getContext();
            if (view == null && (context2 instanceof Activity)) {
                Activity activity = (Activity) context2;
                view = activity.findViewById(R.id.content);
                if (view == null) {
                    view = activity.getWindow().getDecorView();
                }
                GamesLog.zzu("PopupManager", "You have not specified a View to use as content view for popups. Falling back to the Activity content view. Note that this may not work as expected in multi-screen environments");
            }
            if (view == null) {
                GamesLog.zzv("PopupManager", "No content view usable to display popups. Popups will not be displayed in response to this client's calls. Use setViewForPopups() to set your content view.");
                return;
            }
            zzp(view);
            this.zzaqx = new WeakReference<>(view);
            view.addOnAttachStateChangeListener(this);
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        @Override // com.google.android.gms.games.internal.PopupManager
        public void zztd() {
            if (this.zzaqu.zzaqv != null) {
                super.zztd();
            } else {
                this.zzaoV = this.zzaqx != null;
            }
        }
    }

    private PopupManager(GamesClientImpl gamesClientImpl, int i) {
        this.zzaqt = gamesClientImpl;
        zzfF(i);
    }

    public static PopupManager zza(GamesClientImpl gamesClientImpl, int i) {
        return zzlk.zzoS() ? new PopupManagerHCMR1(gamesClientImpl, i) : new PopupManager(gamesClientImpl, i);
    }

    public void setGravity(int i) {
        this.zzaqu.gravity = i;
    }

    protected void zzfF(int i) {
        this.zzaqu = new PopupLocationInfo(i, new Binder());
    }

    public void zzo(View view) {
    }

    public void zztd() {
        this.zzaqt.zza(this.zzaqu.zzaqv, this.zzaqu.zztc());
    }

    public Bundle zzte() {
        return this.zzaqu.zztc();
    }

    public IBinder zztf() {
        return this.zzaqu.zzaqv;
    }

    public PopupLocationInfo zztg() {
        return this.zzaqu;
    }
}
