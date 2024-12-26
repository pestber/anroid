package com.google.android.gms.maps;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzf;
import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;
import com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate;
import com.google.android.gms.maps.internal.StreetViewLifecycleDelegate;
import com.google.android.gms.maps.internal.zzv;
import com.google.android.gms.maps.internal.zzy;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class StreetViewPanoramaView extends FrameLayout {
    private final zzb zzaCC;
    private StreetViewPanorama zzaCq;

    static class zza implements StreetViewLifecycleDelegate {
        private final IStreetViewPanoramaViewDelegate zzaCD;
        private View zzaCE;
        private final ViewGroup zzaCc;

        public zza(ViewGroup viewGroup, IStreetViewPanoramaViewDelegate iStreetViewPanoramaViewDelegate) {
            this.zzaCD = (IStreetViewPanoramaViewDelegate) zzu.zzu(iStreetViewPanoramaViewDelegate);
            this.zzaCc = (ViewGroup) zzu.zzu(viewGroup);
        }

        @Override // com.google.android.gms.maps.internal.StreetViewLifecycleDelegate
        public void getStreetViewPanoramaAsync(final OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
            try {
                this.zzaCD.getStreetViewPanoramaAsync(new zzv.zza() { // from class: com.google.android.gms.maps.StreetViewPanoramaView.zza.1
                    @Override // com.google.android.gms.maps.internal.zzv
                    public void zza(IStreetViewPanoramaDelegate iStreetViewPanoramaDelegate) throws RemoteException {
                        onStreetViewPanoramaReadyCallback.onStreetViewPanoramaReady(new StreetViewPanorama(iStreetViewPanoramaDelegate));
                    }
                });
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onCreate(Bundle bundle) {
            try {
                this.zzaCD.onCreate(bundle);
                this.zzaCE = (View) zze.zzn(this.zzaCD.getView());
                this.zzaCc.removeAllViews();
                this.zzaCc.addView(this.zzaCE);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            throw new UnsupportedOperationException("onCreateView not allowed on StreetViewPanoramaViewDelegate");
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onDestroy() {
            try {
                this.zzaCD.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onDestroyView() {
            throw new UnsupportedOperationException("onDestroyView not allowed on StreetViewPanoramaViewDelegate");
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onInflate(Activity activity, Bundle bundle, Bundle bundle2) {
            throw new UnsupportedOperationException("onInflate not allowed on StreetViewPanoramaViewDelegate");
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onLowMemory() {
            try {
                this.zzaCD.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onPause() {
            try {
                this.zzaCD.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onResume() {
            try {
                this.zzaCD.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onSaveInstanceState(Bundle bundle) {
            try {
                this.zzaCD.onSaveInstanceState(bundle);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onStart() {
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onStop() {
        }

        public IStreetViewPanoramaViewDelegate zzvB() {
            return this.zzaCD;
        }
    }

    static class zzb extends com.google.android.gms.dynamic.zza<zza> {
        private final Context mContext;
        protected zzf<zza> zzaBZ;
        private final StreetViewPanoramaOptions zzaCG;
        private final ViewGroup zzaCg;
        private final List<OnStreetViewPanoramaReadyCallback> zzaCu = new ArrayList();

        zzb(ViewGroup viewGroup, Context context, StreetViewPanoramaOptions streetViewPanoramaOptions) {
            this.zzaCg = viewGroup;
            this.mContext = context;
            this.zzaCG = streetViewPanoramaOptions;
        }

        public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
            if (zzqj() != null) {
                zzqj().getStreetViewPanoramaAsync(onStreetViewPanoramaReadyCallback);
            } else {
                this.zzaCu.add(onStreetViewPanoramaReadyCallback);
            }
        }

        @Override // com.google.android.gms.dynamic.zza
        protected void zza(zzf<zza> zzfVar) {
            this.zzaBZ = zzfVar;
            zzvu();
        }

        public void zzvu() {
            if (this.zzaBZ == null || zzqj() != null) {
                return;
            }
            try {
                this.zzaBZ.zza(new zza(this.zzaCg, zzy.zzay(this.mContext).zza(zze.zzw(this.mContext), this.zzaCG)));
                Iterator<OnStreetViewPanoramaReadyCallback> it = this.zzaCu.iterator();
                while (it.hasNext()) {
                    zzqj().getStreetViewPanoramaAsync(it.next());
                }
                this.zzaCu.clear();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            } catch (GooglePlayServicesNotAvailableException e2) {
            }
        }
    }

    public StreetViewPanoramaView(Context context) {
        super(context);
        this.zzaCC = new zzb(this, context, null);
    }

    public StreetViewPanoramaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.zzaCC = new zzb(this, context, null);
    }

    public StreetViewPanoramaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.zzaCC = new zzb(this, context, null);
    }

    public StreetViewPanoramaView(Context context, StreetViewPanoramaOptions streetViewPanoramaOptions) {
        super(context);
        this.zzaCC = new zzb(this, context, streetViewPanoramaOptions);
    }

    @Deprecated
    public final StreetViewPanorama getStreetViewPanorama() {
        if (this.zzaCq != null) {
            return this.zzaCq;
        }
        this.zzaCC.zzvu();
        if (this.zzaCC.zzqj() == null) {
            return null;
        }
        try {
            this.zzaCq = new StreetViewPanorama(this.zzaCC.zzqj().zzvB().getStreetViewPanorama());
            return this.zzaCq;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
        zzu.zzbY("getStreetViewPanoramaAsync() must be called on the main thread");
        this.zzaCC.getStreetViewPanoramaAsync(onStreetViewPanoramaReadyCallback);
    }

    public final void onCreate(Bundle bundle) {
        this.zzaCC.onCreate(bundle);
        if (this.zzaCC.zzqj() == null) {
            com.google.android.gms.dynamic.zza.zzb(this);
        }
    }

    public final void onDestroy() {
        this.zzaCC.onDestroy();
    }

    public final void onLowMemory() {
        this.zzaCC.onLowMemory();
    }

    public final void onPause() {
        this.zzaCC.onPause();
    }

    public final void onResume() {
        this.zzaCC.onResume();
    }

    public final void onSaveInstanceState(Bundle bundle) {
        this.zzaCC.onSaveInstanceState(bundle);
    }
}
