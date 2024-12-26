package com.google.android.gms.games.internal;

import com.google.android.gms.common.internal.DowngradeableSafeParcel;
import com.google.android.gms.internal.zzlf;

/* loaded from: classes.dex */
public abstract class GamesDowngradeableSafeParcel extends DowngradeableSafeParcel {
    protected static boolean zzd(Integer num) {
        if (num == null) {
            return false;
        }
        return zzlf.zzbQ(num.intValue());
    }
}
