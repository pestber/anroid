package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.ChannelApi;

/* loaded from: classes.dex */
final class zzbf implements ChannelApi.ChannelListener {
    private final String zzaTK;
    private final ChannelApi.ChannelListener zzaUO;

    zzbf(String str, ChannelApi.ChannelListener channelListener) {
        this.zzaTK = (String) com.google.android.gms.common.internal.zzu.zzu(str);
        this.zzaUO = (ChannelApi.ChannelListener) com.google.android.gms.common.internal.zzu.zzu(channelListener);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbf)) {
            return false;
        }
        zzbf zzbfVar = (zzbf) obj;
        return this.zzaUO.equals(zzbfVar.zzaUO) && this.zzaTK.equals(zzbfVar.zzaTK);
    }

    public int hashCode() {
        return (this.zzaTK.hashCode() * 31) + this.zzaUO.hashCode();
    }

    @Override // com.google.android.gms.wearable.ChannelApi.ChannelListener
    public void onChannelClosed(Channel channel, int i, int i2) {
        this.zzaUO.onChannelClosed(channel, i, i2);
    }

    @Override // com.google.android.gms.wearable.ChannelApi.ChannelListener
    public void onChannelOpened(Channel channel) {
        this.zzaUO.onChannelOpened(channel);
    }

    @Override // com.google.android.gms.wearable.ChannelApi.ChannelListener
    public void onInputClosed(Channel channel, int i, int i2) {
        this.zzaUO.onInputClosed(channel, i, i2);
    }

    @Override // com.google.android.gms.wearable.ChannelApi.ChannelListener
    public void onOutputClosed(Channel channel, int i, int i2) {
        this.zzaUO.onOutputClosed(channel, i, i2);
    }
}
