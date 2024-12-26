package com.google.android.gms.analytics.internal;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes.dex */
class zzah extends zzd {
    private static final byte[] zzMs = "\n".getBytes();
    private final String zzFP;
    private final zzaj zzMr;

    private class zza {
        private int zzMt;
        private ByteArrayOutputStream zzMu = new ByteArrayOutputStream();

        public zza() {
        }

        public byte[] getPayload() {
            return this.zzMu.toByteArray();
        }

        public boolean zzj(zzab zzabVar) {
            com.google.android.gms.common.internal.zzu.zzu(zzabVar);
            if (this.zzMt + 1 > zzah.this.zzhR().zzji()) {
                return false;
            }
            String zza = zzah.this.zza(zzabVar, false);
            if (zza == null) {
                zzah.this.zzhQ().zza(zzabVar, "Error formatting hit");
                return true;
            }
            byte[] bytes = zza.getBytes();
            int length = bytes.length;
            if (length > zzah.this.zzhR().zzja()) {
                zzah.this.zzhQ().zza(zzabVar, "Hit size exceeds the maximum size limit");
                return true;
            }
            if (this.zzMu.size() > 0) {
                length++;
            }
            if (this.zzMu.size() + length > zzah.this.zzhR().zzjc()) {
                return false;
            }
            try {
                if (this.zzMu.size() > 0) {
                    this.zzMu.write(zzah.zzMs);
                }
                this.zzMu.write(bytes);
                this.zzMt++;
                return true;
            } catch (IOException e) {
                zzah.this.zze("Failed to write payload when batching hits", e);
                return true;
            }
        }

        public int zzkj() {
            return this.zzMt;
        }
    }

    zzah(zzf zzfVar) {
        super(zzfVar);
        this.zzFP = zza("GoogleAnalytics", zze.VERSION, Build.VERSION.RELEASE, zzam.zza(Locale.getDefault()), Build.MODEL, Build.ID);
        this.zzMr = new zzaj(zzfVar.zzhP());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:40:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0085 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.Object, java.net.URL] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.net.HttpURLConnection] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int zza(java.net.URL r5, byte[] r6) {
        /*
            r4 = this;
            java.lang.String r0 = "Error closing http post connection output stream"
            com.google.android.gms.common.internal.zzu.zzu(r5)
            com.google.android.gms.common.internal.zzu.zzu(r6)
            int r1 = r6.length
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.String r2 = "POST bytes, url"
            r4.zzb(r2, r1, r5)
            boolean r1 = r4.zzhZ()
            if (r1 == 0) goto L22
            java.lang.String r1 = new java.lang.String
            r1.<init>(r6)
            java.lang.String r2 = "Post payload\n"
            r4.zza(r2, r1)
        L22:
            r1 = 0
            java.net.HttpURLConnection r5 = r4.zzc(r5)     // Catch: java.lang.Throwable -> L68 java.io.IOException -> L6b
            r2 = 1
            r5.setDoOutput(r2)     // Catch: java.lang.Throwable -> L64 java.io.IOException -> L66
            int r2 = r6.length     // Catch: java.lang.Throwable -> L64 java.io.IOException -> L66
            r5.setFixedLengthStreamingMode(r2)     // Catch: java.lang.Throwable -> L64 java.io.IOException -> L66
            r5.connect()     // Catch: java.lang.Throwable -> L64 java.io.IOException -> L66
            java.io.OutputStream r1 = r5.getOutputStream()     // Catch: java.lang.Throwable -> L64 java.io.IOException -> L66
            r1.write(r6)     // Catch: java.lang.Throwable -> L64 java.io.IOException -> L66
            r4.zzb(r5)     // Catch: java.lang.Throwable -> L64 java.io.IOException -> L66
            int r6 = r5.getResponseCode()     // Catch: java.lang.Throwable -> L64 java.io.IOException -> L66
            r2 = 200(0xc8, float:2.8E-43)
            if (r6 != r2) goto L4b
            com.google.android.gms.analytics.internal.zzb r2 = r4.zzhl()     // Catch: java.lang.Throwable -> L64 java.io.IOException -> L66
            r2.zzhL()     // Catch: java.lang.Throwable -> L64 java.io.IOException -> L66
        L4b:
            java.lang.String r2 = "POST status"
            java.lang.Integer r3 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Throwable -> L64 java.io.IOException -> L66
            r4.zzb(r2, r3)     // Catch: java.lang.Throwable -> L64 java.io.IOException -> L66
            if (r1 == 0) goto L5e
            r1.close()     // Catch: java.io.IOException -> L5a
            goto L5e
        L5a:
            r1 = move-exception
            r4.zze(r0, r1)
        L5e:
            if (r5 == 0) goto L63
            r5.disconnect()
        L63:
            return r6
        L64:
            r6 = move-exception
            goto L83
        L66:
            r6 = move-exception
            goto L6d
        L68:
            r6 = move-exception
            r5 = r1
            goto L83
        L6b:
            r6 = move-exception
            r5 = r1
        L6d:
            java.lang.String r2 = "Network POST connection error"
            r4.zzd(r2, r6)     // Catch: java.lang.Throwable -> L64
            if (r1 == 0) goto L7c
            r1.close()     // Catch: java.io.IOException -> L78
            goto L7c
        L78:
            r6 = move-exception
            r4.zze(r0, r6)
        L7c:
            if (r5 == 0) goto L81
            r5.disconnect()
        L81:
            r5 = 0
            return r5
        L83:
            if (r1 == 0) goto L8d
            r1.close()     // Catch: java.io.IOException -> L89
            goto L8d
        L89:
            r1 = move-exception
            r4.zze(r0, r1)
        L8d:
            if (r5 == 0) goto L92
            r5.disconnect()
        L92:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.zzah.zza(java.net.URL, byte[]):int");
    }

    private static String zza(String str, String str2, String str3, String str4, String str5, String str6) {
        return String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", str, str2, str3, str4, str5, str6);
    }

    private void zza(StringBuilder sb, String str, String str2) throws UnsupportedEncodingException {
        if (sb.length() != 0) {
            sb.append('&');
        }
        sb.append(URLEncoder.encode(str, "UTF-8"));
        sb.append('=');
        sb.append(URLEncoder.encode(str2, "UTF-8"));
    }

    private int zzb(URL url) {
        com.google.android.gms.common.internal.zzu.zzu(url);
        zzb("GET request", url);
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                httpURLConnection = zzc(url);
                httpURLConnection.connect();
                zzb(httpURLConnection);
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode == 200) {
                    zzhl().zzhL();
                }
                zzb("GET status", Integer.valueOf(responseCode));
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return responseCode;
            } catch (IOException e) {
                zzd("Network GET connection error", e);
                if (httpURLConnection == null) {
                    return 0;
                }
                httpURLConnection.disconnect();
                return 0;
            }
        } catch (Throwable th) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ce A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int zzb(java.net.URL r11, byte[] r12) {
        /*
            Method dump skipped, instructions count: 220
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.zzah.zzb(java.net.URL, byte[]):int");
    }

    private URL zzb(zzab zzabVar, String str) {
        StringBuilder sb;
        String zzjl;
        if (zzabVar.zzjY()) {
            sb = new StringBuilder();
            zzjl = zzhR().zzjk();
        } else {
            sb = new StringBuilder();
            zzjl = zzhR().zzjl();
        }
        try {
            return new URL(sb.append(zzjl).append(zzhR().zzjm()).append("?").append(str).toString());
        } catch (MalformedURLException e) {
            zze("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    private void zzb(HttpURLConnection httpURLConnection) throws IOException {
        InputStream inputStream;
        try {
            inputStream = httpURLConnection.getInputStream();
        } catch (Throwable th) {
            th = th;
            inputStream = null;
        }
        try {
            do {
            } while (inputStream.read(new byte[1024]) > 0);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    zze("Error closing http connection input stream", e);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    zze("Error closing http connection input stream", e2);
                }
            }
            throw th;
        }
    }

    private boolean zzg(zzab zzabVar) {
        String str;
        zzaf zzhQ;
        String str2;
        com.google.android.gms.common.internal.zzu.zzu(zzabVar);
        String zza2 = zza(zzabVar, !zzabVar.zzjY());
        if (zza2 != null) {
            if (zza2.length() <= zzhR().zziZ()) {
                URL zzb = zzb(zzabVar, zza2);
                if (zzb != null) {
                    return zzb(zzb) == 200;
                }
                str = "Failed to build collect GET endpoint url";
            } else {
                String zza3 = zza(zzabVar, false);
                if (zza3 == null) {
                    zzhQ = zzhQ();
                    str2 = "Error formatting hit for POST upload";
                } else {
                    byte[] bytes = zza3.getBytes();
                    if (bytes.length > zzhR().zzjb()) {
                        zzhQ = zzhQ();
                        str2 = "Hit payload exceeds size limit";
                    } else {
                        URL zzh = zzh(zzabVar);
                        if (zzh != null) {
                            return zza(zzh, bytes) == 200;
                        }
                        str = "Failed to build collect POST endpoint url";
                    }
                }
            }
            zzaX(str);
            return false;
        }
        zzhQ = zzhQ();
        str2 = "Error formatting hit for upload";
        zzhQ.zza(zzabVar, str2);
        return true;
    }

    private static byte[] zzg(byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(bArr);
        gZIPOutputStream.close();
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    private URL zzh(zzab zzabVar) {
        StringBuilder sb;
        String zzjl;
        if (zzabVar.zzjY()) {
            sb = new StringBuilder();
            zzjl = zzhR().zzjk();
        } else {
            sb = new StringBuilder();
            zzjl = zzhR().zzjl();
        }
        try {
            return new URL(sb.append(zzjl).append(zzhR().zzjm()).toString());
        } catch (MalformedURLException e) {
            zze("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    private String zzi(zzab zzabVar) {
        return String.valueOf(zzabVar.zzjV());
    }

    private URL zzkh() {
        try {
            return new URL(zzhR().zzjk() + zzhR().zzjn());
        } catch (MalformedURLException e) {
            zze("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    String zza(zzab zzabVar, boolean z) {
        com.google.android.gms.common.internal.zzu.zzu(zzabVar);
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry<String, String> entry : zzabVar.zzn().entrySet()) {
                String key = entry.getKey();
                if (!"ht".equals(key) && !"qt".equals(key) && !"AppUID".equals(key) && !"z".equals(key) && !"_gmsv".equals(key)) {
                    zza(sb, key, entry.getValue());
                }
            }
            zza(sb, "ht", String.valueOf(zzabVar.zzjW()));
            zza(sb, "qt", String.valueOf(zzhP().currentTimeMillis() - zzabVar.zzjW()));
            if (zzhR().zziW()) {
                zza(sb, "_gmsv", zze.VERSION);
            }
            if (z) {
                long zzjZ = zzabVar.zzjZ();
                zza(sb, "z", zzjZ != 0 ? String.valueOf(zzjZ) : zzi(zzabVar));
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            zze("Failed to encode name or value", e);
            return null;
        }
    }

    List<Long> zza(List<zzab> list, boolean z) {
        com.google.android.gms.common.internal.zzu.zzV(!list.isEmpty());
        zza("Uploading batched hits. compression, count", Boolean.valueOf(z), Integer.valueOf(list.size()));
        zza zzaVar = new zza();
        ArrayList arrayList = new ArrayList();
        for (zzab zzabVar : list) {
            if (!zzaVar.zzj(zzabVar)) {
                break;
            }
            arrayList.add(Long.valueOf(zzabVar.zzjV()));
        }
        if (zzaVar.zzkj() == 0) {
            return arrayList;
        }
        URL zzkh = zzkh();
        if (zzkh == null) {
            zzaX("Failed to build batching endpoint url");
            return Collections.emptyList();
        }
        int zzb = z ? zzb(zzkh, zzaVar.getPayload()) : zza(zzkh, zzaVar.getPayload());
        if (200 == zzb) {
            zza("Batched upload completed. Hits batched", Integer.valueOf(zzaVar.zzkj()));
            return arrayList;
        }
        zza("Network error uploading hits. status code", Integer.valueOf(zzb));
        if (zzhR().zzjq().contains(Integer.valueOf(zzb))) {
            zzaW("Server instructed the client to stop batching");
            this.zzMr.start();
        }
        return Collections.emptyList();
    }

    HttpURLConnection zzc(URL url) throws IOException {
        URLConnection openConnection = url.openConnection();
        if (!(openConnection instanceof HttpURLConnection)) {
            throw new IOException("Failed to obtain http connection");
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
        httpURLConnection.setDefaultUseCaches(false);
        httpURLConnection.setConnectTimeout(zzhR().zzjz());
        httpURLConnection.setReadTimeout(zzhR().zzjA());
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestProperty("User-Agent", this.zzFP);
        httpURLConnection.setDoInput(true);
        return httpURLConnection;
    }

    public List<Long> zzf(List<zzab> list) {
        boolean z;
        zzhO();
        zzia();
        com.google.android.gms.common.internal.zzu.zzu(list);
        if (zzhR().zzjq().isEmpty() || !this.zzMr.zzv(zzhR().zzjj() * 1000)) {
            z = false;
        } else {
            r1 = zzhR().zzjo() != zzm.NONE;
            z = zzhR().zzjp() == zzo.GZIP;
        }
        return r1 ? zza(list, z) : zzg(list);
    }

    List<Long> zzg(List<zzab> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (zzab zzabVar : list) {
            if (!zzg(zzabVar)) {
                break;
            }
            arrayList.add(Long.valueOf(zzabVar.zzjV()));
            if (arrayList.size() >= zzhR().zzjh()) {
                break;
            }
        }
        return arrayList;
    }

    @Override // com.google.android.gms.analytics.internal.zzd
    protected void zzhn() {
        zza("Network initialized. User agent", this.zzFP);
    }

    public boolean zzkg() {
        NetworkInfo networkInfo;
        zzhO();
        zzia();
        try {
            networkInfo = ((ConnectivityManager) getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException e) {
            networkInfo = null;
        }
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        }
        zzaT("No network connectivity");
        return false;
    }
}
