package com.google.android.gms.drive.events;

import com.google.android.gms.drive.DriveId;

/* loaded from: classes.dex */
public class zzg {
    public static boolean zza(int i, DriveId driveId) {
        switch (i) {
            case 1:
                if (driveId == null) {
                    break;
                }
                break;
            case 4:
                if (driveId != null) {
                    break;
                }
                break;
            case 5:
            case 6:
                if (driveId == null) {
                    break;
                }
                break;
        }
        return false;
    }
}
