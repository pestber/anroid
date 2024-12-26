package com.google.android.gms.wallet.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.android.gms.R;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzf;
import com.google.android.gms.dynamic.zzh;
import com.google.android.gms.internal.zzqq;
import com.google.android.gms.internal.zzqr;
import com.google.android.gms.internal.zzqy;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

/* loaded from: classes.dex */
public final class SupportWalletFragment extends Fragment {
    private zzb zzaRO;
    private WalletFragmentOptions zzaRS;
    private WalletFragmentInitParams zzaRT;
    private MaskedWalletRequest zzaRU;
    private MaskedWallet zzaRV;
    private Boolean zzaRW;
    private boolean mCreated = false;
    private final zzh zzaRP = zzh.zza(this);
    private final zzc zzaRQ = new zzc();
    private zza zzaRR = new zza(this);
    private final Fragment zzZX = this;

    public interface OnStateChangedListener {
        void onStateChanged(SupportWalletFragment supportWalletFragment, int i, int i2, Bundle bundle);
    }

    static class zza extends zzqr.zza {
        private OnStateChangedListener zzaRX;
        private final SupportWalletFragment zzaRY;

        zza(SupportWalletFragment supportWalletFragment) {
            this.zzaRY = supportWalletFragment;
        }

        @Override // com.google.android.gms.internal.zzqr
        public void zza(int i, int i2, Bundle bundle) {
            if (this.zzaRX != null) {
                this.zzaRX.onStateChanged(this.zzaRY, i, i2, bundle);
            }
        }

        public void zza(OnStateChangedListener onStateChangedListener) {
            this.zzaRX = onStateChangedListener;
        }
    }

    private static class zzb implements LifecycleDelegate {
        private final zzqq zzaRZ;

        private zzb(zzqq zzqqVar) {
            this.zzaRZ = zzqqVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int getState() {
            try {
                return this.zzaRZ.getState();
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void initialize(WalletFragmentInitParams walletFragmentInitParams) {
            try {
                this.zzaRZ.initialize(walletFragmentInitParams);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onActivityResult(int i, int i2, Intent intent) {
            try {
                this.zzaRZ.onActivityResult(i, i2, intent);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEnabled(boolean z) {
            try {
                this.zzaRZ.setEnabled(z);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void updateMaskedWallet(MaskedWallet maskedWallet) {
            try {
                this.zzaRZ.updateMaskedWallet(maskedWallet);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void updateMaskedWalletRequest(MaskedWalletRequest maskedWalletRequest) {
            try {
                this.zzaRZ.updateMaskedWalletRequest(maskedWalletRequest);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onCreate(Bundle bundle) {
            try {
                this.zzaRZ.onCreate(bundle);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            try {
                return (View) zze.zzn(this.zzaRZ.onCreateView(zze.zzw(layoutInflater), zze.zzw(viewGroup), bundle));
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onDestroy() {
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onDestroyView() {
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onInflate(Activity activity, Bundle bundle, Bundle bundle2) {
            try {
                this.zzaRZ.zza(zze.zzw(activity), (WalletFragmentOptions) bundle.getParcelable("extraWalletFragmentOptions"), bundle2);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onLowMemory() {
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onPause() {
            try {
                this.zzaRZ.onPause();
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onResume() {
            try {
                this.zzaRZ.onResume();
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onSaveInstanceState(Bundle bundle) {
            try {
                this.zzaRZ.onSaveInstanceState(bundle);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onStart() {
            try {
                this.zzaRZ.onStart();
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onStop() {
            try {
                this.zzaRZ.onStop();
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private class zzc extends com.google.android.gms.dynamic.zza<zzb> implements View.OnClickListener {
        private zzc() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FragmentActivity activity = SupportWalletFragment.this.zzZX.getActivity();
            GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(activity), activity, -1);
        }

        @Override // com.google.android.gms.dynamic.zza
        protected void zza(FrameLayout frameLayout) {
            WalletFragmentStyle fragmentStyle;
            Button button = new Button(SupportWalletFragment.this.zzZX.getActivity());
            button.setText(R.string.wallet_buy_button_place_holder);
            int i = -1;
            int i2 = -2;
            if (SupportWalletFragment.this.zzaRS != null && (fragmentStyle = SupportWalletFragment.this.zzaRS.getFragmentStyle()) != null) {
                DisplayMetrics displayMetrics = SupportWalletFragment.this.zzZX.getResources().getDisplayMetrics();
                i = fragmentStyle.zza("buyButtonWidth", displayMetrics, -1);
                i2 = fragmentStyle.zza("buyButtonHeight", displayMetrics, -2);
            }
            button.setLayoutParams(new ViewGroup.LayoutParams(i, i2));
            button.setOnClickListener(this);
            frameLayout.addView(button);
        }

        @Override // com.google.android.gms.dynamic.zza
        protected void zza(zzf<zzb> zzfVar) {
            FragmentActivity activity = SupportWalletFragment.this.zzZX.getActivity();
            if (SupportWalletFragment.this.zzaRO == null && SupportWalletFragment.this.mCreated && activity != null) {
                try {
                    zzqq zza = zzqy.zza(activity, SupportWalletFragment.this.zzaRP, SupportWalletFragment.this.zzaRS, SupportWalletFragment.this.zzaRR);
                    SupportWalletFragment.this.zzaRO = new zzb(zza);
                    SupportWalletFragment.this.zzaRS = null;
                    zzfVar.zza(SupportWalletFragment.this.zzaRO);
                    if (SupportWalletFragment.this.zzaRT != null) {
                        SupportWalletFragment.this.zzaRO.initialize(SupportWalletFragment.this.zzaRT);
                        SupportWalletFragment.this.zzaRT = null;
                    }
                    if (SupportWalletFragment.this.zzaRU != null) {
                        SupportWalletFragment.this.zzaRO.updateMaskedWalletRequest(SupportWalletFragment.this.zzaRU);
                        SupportWalletFragment.this.zzaRU = null;
                    }
                    if (SupportWalletFragment.this.zzaRV != null) {
                        SupportWalletFragment.this.zzaRO.updateMaskedWallet(SupportWalletFragment.this.zzaRV);
                        SupportWalletFragment.this.zzaRV = null;
                    }
                    if (SupportWalletFragment.this.zzaRW != null) {
                        SupportWalletFragment.this.zzaRO.setEnabled(SupportWalletFragment.this.zzaRW.booleanValue());
                        SupportWalletFragment.this.zzaRW = null;
                    }
                } catch (GooglePlayServicesNotAvailableException e) {
                }
            }
        }
    }

    public static SupportWalletFragment newInstance(WalletFragmentOptions walletFragmentOptions) {
        SupportWalletFragment supportWalletFragment = new SupportWalletFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("extraWalletFragmentOptions", walletFragmentOptions);
        supportWalletFragment.zzZX.setArguments(bundle);
        return supportWalletFragment;
    }

    public int getState() {
        if (this.zzaRO != null) {
            return this.zzaRO.getState();
        }
        return 0;
    }

    public void initialize(WalletFragmentInitParams walletFragmentInitParams) {
        String str;
        if (this.zzaRO != null) {
            this.zzaRO.initialize(walletFragmentInitParams);
            this.zzaRT = null;
            return;
        }
        if (this.zzaRT == null) {
            this.zzaRT = walletFragmentInitParams;
            if (this.zzaRU != null) {
                Log.w("SupportWalletFragment", "updateMaskedWalletRequest() was called before initialize()");
            }
            if (this.zzaRV == null) {
                return;
            } else {
                str = "updateMaskedWallet() was called before initialize()";
            }
        } else {
            str = "initialize(WalletFragmentInitParams) was called more than once. Ignoring.";
        }
        Log.w("SupportWalletFragment", str);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.zzaRO != null) {
            this.zzaRO.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        WalletFragmentOptions walletFragmentOptions;
        super.onCreate(bundle);
        if (bundle != null) {
            bundle.setClassLoader(WalletFragmentOptions.class.getClassLoader());
            WalletFragmentInitParams walletFragmentInitParams = (WalletFragmentInitParams) bundle.getParcelable("walletFragmentInitParams");
            if (walletFragmentInitParams != null) {
                if (this.zzaRT != null) {
                    Log.w("SupportWalletFragment", "initialize(WalletFragmentInitParams) was called more than once.Ignoring.");
                }
                this.zzaRT = walletFragmentInitParams;
            }
            if (this.zzaRU == null) {
                this.zzaRU = (MaskedWalletRequest) bundle.getParcelable("maskedWalletRequest");
            }
            if (this.zzaRV == null) {
                this.zzaRV = (MaskedWallet) bundle.getParcelable("maskedWallet");
            }
            if (bundle.containsKey("walletFragmentOptions")) {
                this.zzaRS = (WalletFragmentOptions) bundle.getParcelable("walletFragmentOptions");
            }
            if (bundle.containsKey("enabled")) {
                this.zzaRW = Boolean.valueOf(bundle.getBoolean("enabled"));
            }
        } else if (this.zzZX.getArguments() != null && (walletFragmentOptions = (WalletFragmentOptions) this.zzZX.getArguments().getParcelable("extraWalletFragmentOptions")) != null) {
            walletFragmentOptions.zzaL(this.zzZX.getActivity());
            this.zzaRS = walletFragmentOptions;
        }
        this.mCreated = true;
        this.zzaRQ.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.zzaRQ.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.mCreated = false;
    }

    @Override // android.support.v4.app.Fragment
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(activity, attributeSet, bundle);
        if (this.zzaRS == null) {
            this.zzaRS = WalletFragmentOptions.zza(activity, attributeSet);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("attrKeyWalletFragmentOptions", this.zzaRS);
        this.zzaRQ.onInflate(activity, bundle2, bundle);
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.zzaRQ.onPause();
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.zzaRQ.onResume();
        FragmentManager supportFragmentManager = this.zzZX.getActivity().getSupportFragmentManager();
        Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(GooglePlayServicesUtil.GMS_ERROR_DIALOG);
        if (findFragmentByTag != null) {
            supportFragmentManager.beginTransaction().remove(findFragmentByTag).commit();
            GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.zzZX.getActivity()), this.zzZX.getActivity(), -1);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.setClassLoader(WalletFragmentOptions.class.getClassLoader());
        this.zzaRQ.onSaveInstanceState(bundle);
        if (this.zzaRT != null) {
            bundle.putParcelable("walletFragmentInitParams", this.zzaRT);
            this.zzaRT = null;
        }
        if (this.zzaRU != null) {
            bundle.putParcelable("maskedWalletRequest", this.zzaRU);
            this.zzaRU = null;
        }
        if (this.zzaRV != null) {
            bundle.putParcelable("maskedWallet", this.zzaRV);
            this.zzaRV = null;
        }
        if (this.zzaRS != null) {
            bundle.putParcelable("walletFragmentOptions", this.zzaRS);
            this.zzaRS = null;
        }
        if (this.zzaRW != null) {
            bundle.putBoolean("enabled", this.zzaRW.booleanValue());
            this.zzaRW = null;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.zzaRQ.onStart();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.zzaRQ.onStop();
    }

    public void setEnabled(boolean z) {
        Boolean valueOf;
        if (this.zzaRO != null) {
            this.zzaRO.setEnabled(z);
            valueOf = null;
        } else {
            valueOf = Boolean.valueOf(z);
        }
        this.zzaRW = valueOf;
    }

    public void setOnStateChangedListener(OnStateChangedListener onStateChangedListener) {
        this.zzaRR.zza(onStateChangedListener);
    }

    public void updateMaskedWallet(MaskedWallet maskedWallet) {
        if (this.zzaRO == null) {
            this.zzaRV = maskedWallet;
        } else {
            this.zzaRO.updateMaskedWallet(maskedWallet);
            this.zzaRV = null;
        }
    }

    public void updateMaskedWalletRequest(MaskedWalletRequest maskedWalletRequest) {
        if (this.zzaRO == null) {
            this.zzaRU = maskedWalletRequest;
        } else {
            this.zzaRO.updateMaskedWalletRequest(maskedWalletRequest);
            this.zzaRU = null;
        }
    }
}
