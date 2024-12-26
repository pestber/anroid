package com.google.android.gms.appdatasearch;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.appdatasearch.DocumentContents;
import com.google.android.gms.appdatasearch.RegisterSectionInfo;
import com.google.android.gms.appindexing.AppIndexApi;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zznj;
import com.google.android.gms.internal.zzrn;
import com.google.android.gms.plus.PlusShare;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.zip.CRC32;

/* loaded from: classes.dex */
public class UsageInfo implements SafeParcelable {
    public static final zzj CREATOR = new zzj();
    final int zzCY;
    final DocumentId zzNH;
    final long zzNI;
    int zzNJ;
    final DocumentContents zzNK;
    final boolean zzNL;
    int zzNM;
    int zzNN;
    public final String zztt;

    public static final class zza {
        private String zzHZ;
        private DocumentId zzNH;
        private DocumentContents zzNK;
        private long zzNI = -1;
        private int zzNJ = -1;
        private int zzNM = -1;
        private boolean zzNL = false;
        private int zzNN = 0;

        public zza zzL(boolean z) {
            this.zzNL = z;
            return this;
        }

        public zza zza(DocumentContents documentContents) {
            this.zzNK = documentContents;
            return this;
        }

        public zza zza(DocumentId documentId) {
            this.zzNH = documentId;
            return this;
        }

        public zza zzal(int i) {
            this.zzNJ = i;
            return this;
        }

        public zza zzam(int i) {
            this.zzNN = i;
            return this;
        }

        public UsageInfo zzkN() {
            return new UsageInfo(this.zzNH, this.zzNI, this.zzNJ, this.zzHZ, this.zzNK, this.zzNL, this.zzNM, this.zzNN);
        }

        public zza zzw(long j) {
            this.zzNI = j;
            return this;
        }
    }

    UsageInfo(int i, DocumentId documentId, long j, int i2, String str, DocumentContents documentContents, boolean z, int i3, int i4) {
        this.zzCY = i;
        this.zzNH = documentId;
        this.zzNI = j;
        this.zzNJ = i2;
        this.zztt = str;
        this.zzNK = documentContents;
        this.zzNL = z;
        this.zzNM = i3;
        this.zzNN = i4;
    }

    private UsageInfo(DocumentId documentId, long j, int i, String str, DocumentContents documentContents, boolean z, int i2, int i3) {
        this(1, documentId, j, i, str, documentContents, z, i2, i3);
    }

    public UsageInfo(String str, Intent intent, String str2, Uri uri, String str3, List<AppIndexApi.AppIndexingLink> list, int i) {
        this(1, zza(str, intent), System.currentTimeMillis(), 0, (String) null, zza(intent, str2, uri, str3, list).zzkJ(), false, -1, i);
    }

    public static DocumentContents.zza zza(Intent intent, String str, Uri uri, String str2, List<AppIndexApi.AppIndexingLink> list) {
        String string;
        DocumentContents.zza zzaVar = new DocumentContents.zza();
        zzaVar.zza(zzbt(str));
        if (uri != null) {
            zzaVar.zza(zzh(uri));
        }
        if (list != null) {
            zzaVar.zza(zzh(list));
        }
        String action = intent.getAction();
        if (action != null) {
            zzaVar.zza(zzp("intent_action", action));
        }
        String dataString = intent.getDataString();
        if (dataString != null) {
            zzaVar.zza(zzp("intent_data", dataString));
        }
        ComponentName component = intent.getComponent();
        if (component != null) {
            zzaVar.zza(zzp("intent_activity", component.getClassName()));
        }
        Bundle extras = intent.getExtras();
        if (extras != null && (string = extras.getString("intent_extra_data_key")) != null) {
            zzaVar.zza(zzp("intent_extra_data", string));
        }
        return zzaVar.zzbp(str2).zzI(true);
    }

    public static DocumentId zza(String str, Intent intent) {
        return zzo(str, zzg(intent));
    }

    private static DocumentSection zzbt(String str) {
        return new DocumentSection(str, new RegisterSectionInfo.zza(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE).zzaj(1).zzK(true).zzbs("name").zzkM(), "text1");
    }

    private static String zzg(Intent intent) {
        String uri = intent.toUri(1);
        CRC32 crc32 = new CRC32();
        try {
            crc32.update(uri.getBytes("UTF-8"));
            return Long.toHexString(crc32.getValue());
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException(e);
        }
    }

    private static DocumentSection zzh(Uri uri) {
        return new DocumentSection(uri.toString(), new RegisterSectionInfo.zza("web_url").zzaj(4).zzJ(true).zzbs(PlusShare.KEY_CALL_TO_ACTION_URL).zzkM());
    }

    private static DocumentSection zzh(List<AppIndexApi.AppIndexingLink> list) {
        zznj.zza zzaVar = new zznj.zza();
        int size = list.size();
        zznj.zza.C0143zza[] c0143zzaArr = new zznj.zza.C0143zza[size];
        for (int i = 0; i < size; i++) {
            c0143zzaArr[i] = new zznj.zza.C0143zza();
            AppIndexApi.AppIndexingLink appIndexingLink = list.get(i);
            c0143zzaArr[i].zzawm = appIndexingLink.appIndexingUrl.toString();
            c0143zzaArr[i].viewId = appIndexingLink.viewId;
            if (appIndexingLink.webUrl != null) {
                c0143zzaArr[i].zzawn = appIndexingLink.webUrl.toString();
            }
        }
        zzaVar.zzawk = c0143zzaArr;
        return new DocumentSection(zzrn.zzf(zzaVar), new RegisterSectionInfo.zza("outlinks").zzJ(true).zzbs(".private:outLinks").zzbr("blob").zzkM());
    }

    private static DocumentId zzo(String str, String str2) {
        return new DocumentId(str, "", str2);
    }

    private static DocumentSection zzp(String str, String str2) {
        return new DocumentSection(str2, new RegisterSectionInfo.zza(str).zzJ(true).zzkM(), str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return String.format("UsageInfo[documentId=%s, timestamp=%d, usageType=%d, status=%d]", this.zzNH, Long.valueOf(this.zzNI), Integer.valueOf(this.zzNJ), Integer.valueOf(this.zzNN));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzj.zza(this, parcel, i);
    }
}
