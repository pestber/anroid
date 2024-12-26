package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.IAccountAccessor;

/* loaded from: classes.dex */
public class zza extends IAccountAccessor.zza {
    private Context mContext;
    private Account zzMY;
    int zzZN;

    public static Account zza(IAccountAccessor iAccountAccessor) {
        if (iAccountAccessor != null) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                return iAccountAccessor.getAccount();
            } catch (RemoteException e) {
                Log.w("AccountAccessor", "Remote account accessor probably died");
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zza) {
            return this.zzMY.equals(((zza) obj).zzMY);
        }
        return false;
    }

    @Override // com.google.android.gms.common.internal.IAccountAccessor
    public Account getAccount() {
        int callingUid = Binder.getCallingUid();
        if (callingUid == this.zzZN) {
            return this.zzMY;
        }
        if (!GooglePlayServicesUtil.zzd(this.mContext, callingUid)) {
            throw new SecurityException("Caller is not GooglePlayServices");
        }
        this.zzZN = callingUid;
        return this.zzMY;
    }
}
