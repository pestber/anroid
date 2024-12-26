package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.internal.view.SupportMenu;
import java.util.List;

/* loaded from: classes.dex */
public class zzb {
    private static int zzF(Parcel parcel, int i) {
        parcel.writeInt(i | SupportMenu.CATEGORY_MASK);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    private static void zzG(Parcel parcel, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.setDataPosition(i - 4);
        parcel.writeInt(dataPosition - i);
        parcel.setDataPosition(dataPosition);
    }

    public static void zzH(Parcel parcel, int i) {
        zzG(parcel, i);
    }

    public static void zza(Parcel parcel, int i, byte b) {
        zzb(parcel, i, 4);
        parcel.writeInt(b);
    }

    public static void zza(Parcel parcel, int i, double d) {
        zzb(parcel, i, 8);
        parcel.writeDouble(d);
    }

    public static void zza(Parcel parcel, int i, float f) {
        zzb(parcel, i, 4);
        parcel.writeFloat(f);
    }

    public static void zza(Parcel parcel, int i, long j) {
        zzb(parcel, i, 8);
        parcel.writeLong(j);
    }

    public static void zza(Parcel parcel, int i, Bundle bundle, boolean z) {
        if (bundle == null) {
            if (z) {
                zzb(parcel, i, 0);
            }
        } else {
            int zzF = zzF(parcel, i);
            parcel.writeBundle(bundle);
            zzG(parcel, zzF);
        }
    }

    public static void zza(Parcel parcel, int i, IBinder iBinder, boolean z) {
        if (iBinder == null) {
            if (z) {
                zzb(parcel, i, 0);
            }
        } else {
            int zzF = zzF(parcel, i);
            parcel.writeStrongBinder(iBinder);
            zzG(parcel, zzF);
        }
    }

    public static void zza(Parcel parcel, int i, Parcel parcel2, boolean z) {
        if (parcel2 == null) {
            if (z) {
                zzb(parcel, i, 0);
            }
        } else {
            int zzF = zzF(parcel, i);
            parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            zzG(parcel, zzF);
        }
    }

    public static void zza(Parcel parcel, int i, Parcelable parcelable, int i2, boolean z) {
        if (parcelable == null) {
            if (z) {
                zzb(parcel, i, 0);
            }
        } else {
            int zzF = zzF(parcel, i);
            parcelable.writeToParcel(parcel, i2);
            zzG(parcel, zzF);
        }
    }

    public static void zza(Parcel parcel, int i, Boolean bool, boolean z) {
        if (bool != null) {
            zzb(parcel, i, 4);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        } else if (z) {
            zzb(parcel, i, 0);
        }
    }

    public static void zza(Parcel parcel, int i, Integer num, boolean z) {
        if (num != null) {
            zzb(parcel, i, 4);
            parcel.writeInt(num.intValue());
        } else if (z) {
            zzb(parcel, i, 0);
        }
    }

    public static void zza(Parcel parcel, int i, Long l, boolean z) {
        if (l != null) {
            zzb(parcel, i, 8);
            parcel.writeLong(l.longValue());
        } else if (z) {
            zzb(parcel, i, 0);
        }
    }

    public static void zza(Parcel parcel, int i, String str, boolean z) {
        if (str == null) {
            if (z) {
                zzb(parcel, i, 0);
            }
        } else {
            int zzF = zzF(parcel, i);
            parcel.writeString(str);
            zzG(parcel, zzF);
        }
    }

    public static void zza(Parcel parcel, int i, List<Integer> list, boolean z) {
        if (list == null) {
            if (z) {
                zzb(parcel, i, 0);
                return;
            }
            return;
        }
        int zzF = zzF(parcel, i);
        int size = list.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeInt(list.get(i2).intValue());
        }
        zzG(parcel, zzF);
    }

    public static void zza(Parcel parcel, int i, short s) {
        zzb(parcel, i, 4);
        parcel.writeInt(s);
    }

    public static void zza(Parcel parcel, int i, boolean z) {
        zzb(parcel, i, 4);
        parcel.writeInt(z ? 1 : 0);
    }

    public static void zza(Parcel parcel, int i, byte[] bArr, boolean z) {
        if (bArr == null) {
            if (z) {
                zzb(parcel, i, 0);
            }
        } else {
            int zzF = zzF(parcel, i);
            parcel.writeByteArray(bArr);
            zzG(parcel, zzF);
        }
    }

    public static void zza(Parcel parcel, int i, int[] iArr, boolean z) {
        if (iArr == null) {
            if (z) {
                zzb(parcel, i, 0);
            }
        } else {
            int zzF = zzF(parcel, i);
            parcel.writeIntArray(iArr);
            zzG(parcel, zzF);
        }
    }

    public static <T extends Parcelable> void zza(Parcel parcel, int i, T[] tArr, int i2, boolean z) {
        if (tArr == null) {
            if (z) {
                zzb(parcel, i, 0);
                return;
            }
            return;
        }
        int zzF = zzF(parcel, i);
        parcel.writeInt(tArr.length);
        for (T t : tArr) {
            if (t == null) {
                parcel.writeInt(0);
            } else {
                zza(parcel, t, i2);
            }
        }
        zzG(parcel, zzF);
    }

    public static void zza(Parcel parcel, int i, String[] strArr, boolean z) {
        if (strArr == null) {
            if (z) {
                zzb(parcel, i, 0);
            }
        } else {
            int zzF = zzF(parcel, i);
            parcel.writeStringArray(strArr);
            zzG(parcel, zzF);
        }
    }

    public static void zza(Parcel parcel, int i, byte[][] bArr, boolean z) {
        if (bArr == null) {
            if (z) {
                zzb(parcel, i, 0);
                return;
            }
            return;
        }
        int zzF = zzF(parcel, i);
        parcel.writeInt(bArr.length);
        for (byte[] bArr2 : bArr) {
            parcel.writeByteArray(bArr2);
        }
        zzG(parcel, zzF);
    }

    private static <T extends Parcelable> void zza(Parcel parcel, T t, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        t.writeToParcel(parcel, i);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }

    public static int zzac(Parcel parcel) {
        return zzF(parcel, 20293);
    }

    private static void zzb(Parcel parcel, int i, int i2) {
        if (i2 < 65535) {
            parcel.writeInt(i | (i2 << 16));
        } else {
            parcel.writeInt(i | SupportMenu.CATEGORY_MASK);
            parcel.writeInt(i2);
        }
    }

    public static void zzb(Parcel parcel, int i, List<String> list, boolean z) {
        if (list == null) {
            if (z) {
                zzb(parcel, i, 0);
            }
        } else {
            int zzF = zzF(parcel, i);
            parcel.writeStringList(list);
            zzG(parcel, zzF);
        }
    }

    public static void zzc(Parcel parcel, int i, int i2) {
        zzb(parcel, i, 4);
        parcel.writeInt(i2);
    }

    public static <T extends Parcelable> void zzc(Parcel parcel, int i, List<T> list, boolean z) {
        if (list == null) {
            if (z) {
                zzb(parcel, i, 0);
                return;
            }
            return;
        }
        int zzF = zzF(parcel, i);
        int size = list.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            T t = list.get(i2);
            if (t == null) {
                parcel.writeInt(0);
            } else {
                zza(parcel, t, 0);
            }
        }
        zzG(parcel, zzF);
    }

    public static void zzd(Parcel parcel, int i, List list, boolean z) {
        if (list == null) {
            if (z) {
                zzb(parcel, i, 0);
            }
        } else {
            int zzF = zzF(parcel, i);
            parcel.writeList(list);
            zzG(parcel, zzF);
        }
    }
}
