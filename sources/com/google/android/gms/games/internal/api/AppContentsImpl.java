package com.google.android.gms.games.internal.api;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.appcontent.AppContents;
import com.google.android.gms.games.internal.GamesClientImpl;

/* loaded from: classes.dex */
public final class AppContentsImpl implements AppContents {

    /* renamed from: com.google.android.gms.games.internal.api.AppContentsImpl$1, reason: invalid class name */
    class AnonymousClass1 extends LoadsImpl {
        final /* synthetic */ int zzaqG;
        final /* synthetic */ String zzaqH;
        final /* synthetic */ String[] zzaqI;
        final /* synthetic */ boolean zzaqy;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza(this, this.zzaqG, this.zzaqH, this.zzaqI, this.zzaqy);
        }
    }

    private static abstract class LoadsImpl extends Games.BaseGamesApiMethodImpl<AppContents.LoadAppContentResult> {
        @Override // com.google.android.gms.common.api.AbstractPendingResult
        /* renamed from: zzV, reason: merged with bridge method [inline-methods] */
        public AppContents.LoadAppContentResult createFailedResult(final Status status) {
            return new AppContents.LoadAppContentResult() { // from class: com.google.android.gms.games.internal.api.AppContentsImpl.LoadsImpl.1
                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }

                @Override // com.google.android.gms.common.api.Releasable
                public void release() {
                }
            };
        }
    }
}
