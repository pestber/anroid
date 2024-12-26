package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.ChannelApi;

/* loaded from: classes.dex */
public final class ChannelEventParcelable implements SafeParcelable {
    public static final Parcelable.Creator<ChannelEventParcelable> CREATOR = new zzk();
    final int type;
    final int zzCY;
    final int zzaTN;
    final int zzaTO;
    final ChannelImpl zzaTP;

    ChannelEventParcelable(int i, ChannelImpl channelImpl, int i2, int i3, int i4) {
        this.zzCY = i;
        this.zzaTP = channelImpl;
        this.type = i2;
        this.zzaTN = i3;
        this.zzaTO = i4;
    }

    private static String zzjT(int i) {
        switch (i) {
            case 1:
                return "CHANNEL_OPENED";
            case 2:
                return "CHANNEL_CLOSED";
            case 3:
                return "INPUT_CLOSED";
            case 4:
                return "OUTPUT_CLOSED";
            default:
                return Integer.toString(i);
        }
    }

    private static String zzjU(int i) {
        switch (i) {
            case 0:
                return "CLOSE_REASON_NORMAL";
            case 1:
                return "CLOSE_REASON_DISCONNECTED";
            case 2:
                return "CLOSE_REASON_REMOTE_CLOSE";
            case 3:
                return "CLOSE_REASON_LOCAL_CLOSE";
            default:
                return Integer.toString(i);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ChannelEventParcelable[versionCode=" + this.zzCY + ", channel=" + this.zzaTP + ", type=" + zzjT(this.type) + ", closeReason=" + zzjU(this.zzaTN) + ", appErrorCode=" + this.zzaTO + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzk.zza(this, parcel, i);
    }

    public void zza(ChannelApi.ChannelListener channelListener) {
        switch (this.type) {
            case 1:
                channelListener.onChannelOpened(this.zzaTP);
                break;
            case 2:
                channelListener.onChannelClosed(this.zzaTP, this.zzaTN, this.zzaTO);
                break;
            case 3:
                channelListener.onInputClosed(this.zzaTP, this.zzaTN, this.zzaTO);
                break;
            case 4:
                channelListener.onOutputClosed(this.zzaTP, this.zzaTN, this.zzaTO);
                break;
            default:
                Log.w("ChannelEventParcelable", "Unknown type: " + this.type);
                break;
        }
    }
}
