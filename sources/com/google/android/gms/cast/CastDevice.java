package com.google.android.gms.cast;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class CastDevice implements SafeParcelable {
    public static final int CAPABILITY_AUDIO_IN = 8;
    public static final int CAPABILITY_AUDIO_OUT = 4;
    public static final int CAPABILITY_VIDEO_IN = 2;
    public static final int CAPABILITY_VIDEO_OUT = 1;
    public static final Parcelable.Creator<CastDevice> CREATOR = new zzb();
    private final int zzCY;
    private String zzQL;
    String zzQM;
    private Inet4Address zzQN;
    private String zzQO;
    private String zzQP;
    private String zzQQ;
    private int zzQR;
    private List<WebImage> zzQS;
    private int zzQT;
    private int zzwS;

    private CastDevice() {
        this(3, null, null, null, null, null, -1, new ArrayList(), 0, -1);
    }

    CastDevice(int i, String str, String str2, String str3, String str4, String str5, int i2, List<WebImage> list, int i3, int i4) {
        this.zzCY = i;
        this.zzQL = str;
        this.zzQM = str2;
        if (this.zzQM != null) {
            try {
                InetAddress byName = InetAddress.getByName(this.zzQM);
                if (byName instanceof Inet4Address) {
                    this.zzQN = (Inet4Address) byName;
                }
            } catch (UnknownHostException e) {
                this.zzQN = null;
            }
        }
        this.zzQO = str3;
        this.zzQP = str4;
        this.zzQQ = str5;
        this.zzQR = i2;
        this.zzQS = list;
        this.zzQT = i3;
        this.zzwS = i4;
    }

    public static CastDevice getFromBundle(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        bundle.setClassLoader(CastDevice.class.getClassLoader());
        return (CastDevice) bundle.getParcelable("com.google.android.gms.cast.EXTRA_CAST_DEVICE");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CastDevice)) {
            return false;
        }
        CastDevice castDevice = (CastDevice) obj;
        return getDeviceId() == null ? castDevice.getDeviceId() == null : zzf.zza(this.zzQL, castDevice.zzQL) && zzf.zza(this.zzQN, castDevice.zzQN) && zzf.zza(this.zzQP, castDevice.zzQP) && zzf.zza(this.zzQO, castDevice.zzQO) && zzf.zza(this.zzQQ, castDevice.zzQQ) && this.zzQR == castDevice.zzQR && zzf.zza(this.zzQS, castDevice.zzQS) && this.zzQT == castDevice.zzQT && this.zzwS == castDevice.zzwS;
    }

    public int getCapabilities() {
        return this.zzQT;
    }

    public String getDeviceId() {
        return this.zzQL;
    }

    public String getDeviceVersion() {
        return this.zzQQ;
    }

    public String getFriendlyName() {
        return this.zzQO;
    }

    public WebImage getIcon(int i, int i2) {
        WebImage webImage = null;
        if (this.zzQS.isEmpty()) {
            return null;
        }
        if (i <= 0 || i2 <= 0) {
            return this.zzQS.get(0);
        }
        WebImage webImage2 = null;
        for (WebImage webImage3 : this.zzQS) {
            int width = webImage3.getWidth();
            int height = webImage3.getHeight();
            if (width < i || height < i2) {
                if (width < i && height < i2 && (webImage2 == null || (webImage2.getWidth() < width && webImage2.getHeight() < height))) {
                    webImage2 = webImage3;
                }
            } else if (webImage == null || (webImage.getWidth() > width && webImage.getHeight() > height)) {
                webImage = webImage3;
            }
        }
        return webImage != null ? webImage : webImage2 != null ? webImage2 : this.zzQS.get(0);
    }

    public List<WebImage> getIcons() {
        return Collections.unmodifiableList(this.zzQS);
    }

    public Inet4Address getIpAddress() {
        return this.zzQN;
    }

    public String getModelName() {
        return this.zzQP;
    }

    public int getServicePort() {
        return this.zzQR;
    }

    public int getStatus() {
        return this.zzwS;
    }

    int getVersionCode() {
        return this.zzCY;
    }

    public boolean hasCapabilities(int[] iArr) {
        if (iArr == null) {
            return false;
        }
        for (int i : iArr) {
            if (!hasCapability(i)) {
                return false;
            }
        }
        return true;
    }

    public boolean hasCapability(int i) {
        return (this.zzQT & i) == i;
    }

    public boolean hasIcons() {
        return !this.zzQS.isEmpty();
    }

    public int hashCode() {
        if (this.zzQL == null) {
            return 0;
        }
        return this.zzQL.hashCode();
    }

    public boolean isOnLocalNetwork() {
        return !this.zzQL.startsWith("__cast_nearby__");
    }

    public boolean isSameDevice(CastDevice castDevice) {
        if (castDevice == null) {
            return false;
        }
        return getDeviceId() == null ? castDevice.getDeviceId() == null : zzf.zza(getDeviceId(), castDevice.getDeviceId());
    }

    public void putInBundle(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        bundle.putParcelable("com.google.android.gms.cast.EXTRA_CAST_DEVICE", this);
    }

    public String toString() {
        return String.format("\"%s\" (%s)", this.zzQO, this.zzQL);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }
}
