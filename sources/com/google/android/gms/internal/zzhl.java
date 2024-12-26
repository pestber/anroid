package com.google.android.gms.internal;

import android.R;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.PopupWindow;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzgd
/* loaded from: classes.dex */
public class zzhl {
    public static final Handler zzGk = new zzhi(Looper.getMainLooper());
    private String zzFP;
    private final Object zzqt = new Object();
    private boolean zzGl = true;
    private boolean zzGm = false;

    private final class zza extends BroadcastReceiver {
        private zza() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            zzhl zzhlVar;
            boolean z;
            if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
                zzhlVar = zzhl.this;
                z = true;
            } else {
                if (!"android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                    return;
                }
                zzhlVar = zzhl.this;
                z = false;
            }
            zzhlVar.zzGl = z;
        }
    }

    public static void runOnUiThread(Runnable runnable) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            runnable.run();
        } else {
            zzGk.post(runnable);
        }
    }

    private JSONArray zza(Collection<?> collection) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            zza(jSONArray, it.next());
        }
        return jSONArray;
    }

    private void zza(JSONArray jSONArray, Object obj) throws JSONException {
        if (obj instanceof Bundle) {
            obj = zzd((Bundle) obj);
        } else if (obj instanceof Map) {
            obj = zzy((Map) obj);
        } else if (obj instanceof Collection) {
            obj = zza((Collection<?>) obj);
        } else if (obj instanceof Object[]) {
            obj = zza((Object[]) obj);
        }
        jSONArray.put(obj);
    }

    private void zza(JSONObject jSONObject, String str, Object obj) throws JSONException {
        Collection<?> asList;
        if (obj instanceof Bundle) {
            obj = zzd((Bundle) obj);
        } else if (obj instanceof Map) {
            obj = zzy((Map) obj);
        } else {
            if (obj instanceof Collection) {
                if (str == null) {
                    str = "null";
                }
                asList = (Collection) obj;
            } else if (obj instanceof Object[]) {
                asList = Arrays.asList((Object[]) obj);
            }
            obj = zza(asList);
        }
        jSONObject.put(str, obj);
    }

    private JSONObject zzd(Bundle bundle) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            zza(jSONObject, str, bundle.get(str));
        }
        return jSONObject;
    }

    private boolean zzr(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            return false;
        }
        return powerManager.isScreenOn();
    }

    public boolean zzG(Context context) {
        String str;
        boolean z;
        Intent intent = new Intent();
        intent.setClassName(context, AdActivity.CLASS_NAME);
        ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 65536);
        if (resolveActivity == null || resolveActivity.activityInfo == null) {
            str = "Could not find com.google.android.gms.ads.AdActivity, please make sure it is declared in AndroidManifest.xml.";
        } else {
            if ((resolveActivity.activityInfo.configChanges & 16) == 0) {
                com.google.android.gms.ads.internal.util.client.zzb.zzaC(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", "keyboard"));
                z = false;
            } else {
                z = true;
            }
            if ((resolveActivity.activityInfo.configChanges & 32) == 0) {
                com.google.android.gms.ads.internal.util.client.zzb.zzaC(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", "keyboardHidden"));
                z = false;
            }
            if ((resolveActivity.activityInfo.configChanges & 128) == 0) {
                com.google.android.gms.ads.internal.util.client.zzb.zzaC(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", "orientation"));
                z = false;
            }
            if ((resolveActivity.activityInfo.configChanges & 256) == 0) {
                com.google.android.gms.ads.internal.util.client.zzb.zzaC(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", "screenLayout"));
                z = false;
            }
            if ((resolveActivity.activityInfo.configChanges & 512) == 0) {
                com.google.android.gms.ads.internal.util.client.zzb.zzaC(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", "uiMode"));
                z = false;
            }
            if ((resolveActivity.activityInfo.configChanges & 1024) == 0) {
                com.google.android.gms.ads.internal.util.client.zzb.zzaC(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", "screenSize"));
                z = false;
            }
            if ((resolveActivity.activityInfo.configChanges & 2048) != 0) {
                return z;
            }
            str = String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", "smallestScreenSize");
        }
        com.google.android.gms.ads.internal.util.client.zzb.zzaC(str);
        return false;
    }

    public boolean zzH(Context context) {
        if (this.zzGm) {
            return false;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        context.getApplicationContext().registerReceiver(new zza(), intentFilter);
        this.zzGm = true;
        return true;
    }

    protected String zzI(Context context) {
        return new WebView(context).getSettings().getUserAgentString();
    }

    public AlertDialog.Builder zzJ(Context context) {
        return new AlertDialog.Builder(context);
    }

    public zzbq zzK(Context context) {
        return new zzbq(context);
    }

    public String zzL(Context context) {
        List<ActivityManager.RunningTaskInfo> runningTasks;
        ActivityManager.RunningTaskInfo runningTaskInfo;
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager != null && (runningTasks = activityManager.getRunningTasks(1)) != null && !runningTasks.isEmpty() && (runningTaskInfo = runningTasks.get(0)) != null && runningTaskInfo.topActivity != null) {
                return runningTaskInfo.topActivity.getClassName();
            }
        } catch (Exception e) {
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0039, code lost:
    
        if (r3.importance != 100) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003f, code lost:
    
        if (r2.inKeyguardRestrictedInputMode() != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0045, code lost:
    
        if (zzr(r7) == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0047, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean zzM(android.content.Context r7) {
        /*
            r6 = this;
            r0 = 0
            java.lang.String r1 = "activity"
            java.lang.Object r1 = r7.getSystemService(r1)     // Catch: java.lang.Throwable -> L4a
            android.app.ActivityManager r1 = (android.app.ActivityManager) r1     // Catch: java.lang.Throwable -> L4a
            java.lang.String r2 = "keyguard"
            java.lang.Object r2 = r7.getSystemService(r2)     // Catch: java.lang.Throwable -> L4a
            android.app.KeyguardManager r2 = (android.app.KeyguardManager) r2     // Catch: java.lang.Throwable -> L4a
            if (r1 == 0) goto L49
            if (r2 != 0) goto L16
            goto L49
        L16:
            java.util.List r1 = r1.getRunningAppProcesses()     // Catch: java.lang.Throwable -> L4a
            if (r1 != 0) goto L1d
            return r0
        L1d:
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> L4a
        L21:
            boolean r3 = r1.hasNext()     // Catch: java.lang.Throwable -> L4a
            if (r3 == 0) goto L49
            java.lang.Object r3 = r1.next()     // Catch: java.lang.Throwable -> L4a
            android.app.ActivityManager$RunningAppProcessInfo r3 = (android.app.ActivityManager.RunningAppProcessInfo) r3     // Catch: java.lang.Throwable -> L4a
            int r4 = android.os.Process.myPid()     // Catch: java.lang.Throwable -> L4a
            int r5 = r3.pid     // Catch: java.lang.Throwable -> L4a
            if (r4 != r5) goto L21
            int r1 = r3.importance     // Catch: java.lang.Throwable -> L4a
            r3 = 100
            if (r1 != r3) goto L49
            boolean r1 = r2.inKeyguardRestrictedInputMode()     // Catch: java.lang.Throwable -> L4a
            if (r1 != 0) goto L49
            boolean r7 = r6.zzr(r7)     // Catch: java.lang.Throwable -> L4a
            if (r7 == 0) goto L49
            r7 = 1
            return r7
        L49:
            return r0
        L4a:
            r7 = move-exception
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzhl.zzM(android.content.Context):boolean");
    }

    public DisplayMetrics zza(WindowManager windowManager) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    public PopupWindow zza(View view, int i, int i2, boolean z) {
        return new PopupWindow(view, i, i2, z);
    }

    public String zza(Context context, View view, AdSizeParcel adSizeParcel) {
        if (!zzbz.zzuo.get().booleanValue()) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("width", adSizeParcel.width);
            jSONObject2.put("height", adSizeParcel.height);
            jSONObject.put("size", jSONObject2);
            jSONObject.put("activity", zzL(context));
            if (!adSizeParcel.zzsn) {
                JSONArray jSONArray = new JSONArray();
                while (view != null) {
                    Object parent = view.getParent();
                    if (parent != null) {
                        int indexOfChild = parent instanceof ViewGroup ? ((ViewGroup) parent).indexOfChild(view) : -1;
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("type", parent.getClass().getName());
                        jSONObject3.put("index_of_child", indexOfChild);
                        jSONArray.put(jSONObject3);
                    }
                    view = (parent == null || !(parent instanceof View)) ? null : (View) parent;
                }
                if (jSONArray.length() > 0) {
                    jSONObject.put("parents", jSONArray);
                }
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Fail to get view hierarchy json", e);
            return null;
        }
    }

    public String zza(Context context, zzan zzanVar, String str) {
        if (zzanVar == null) {
            return str;
        }
        try {
            Uri parse = Uri.parse(str);
            if (zzanVar.zzc(parse)) {
                parse = zzanVar.zza(parse, context);
            }
            return parse.toString();
        } catch (Exception e) {
            return str;
        }
    }

    public String zza(zzid zzidVar, String str) {
        return zza(zzidVar.getContext(), zzidVar.zzgH(), str);
    }

    public String zza(InputStreamReader inputStreamReader) throws IOException {
        StringBuilder sb = new StringBuilder(8192);
        char[] cArr = new char[2048];
        while (true) {
            int read = inputStreamReader.read(cArr);
            if (read == -1) {
                return sb.toString();
            }
            sb.append(cArr, 0, read);
        }
    }

    JSONArray zza(Object[] objArr) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (Object obj : objArr) {
            zza(jSONArray, obj);
        }
        return jSONArray;
    }

    public void zza(Activity activity, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        Window window = activity.getWindow();
        if (window == null || window.getDecorView() == null || window.getDecorView().getViewTreeObserver() == null) {
            return;
        }
        window.getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    public void zza(Activity activity, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        Window window = activity.getWindow();
        if (window == null || window.getDecorView() == null || window.getDecorView().getViewTreeObserver() == null) {
            return;
        }
        window.getDecorView().getViewTreeObserver().addOnScrollChangedListener(onScrollChangedListener);
    }

    public void zza(Context context, String str, WebSettings webSettings) {
        webSettings.setUserAgentString(zzf(context, str));
    }

    public void zza(Context context, String str, String str2, Bundle bundle, boolean z) {
        if (zzbz.zzux.get().booleanValue()) {
            if (z) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext == null) {
                    applicationContext = context;
                }
                bundle.putString("os", Build.VERSION.RELEASE);
                bundle.putString("api", String.valueOf(Build.VERSION.SDK_INT));
                bundle.putString("device", com.google.android.gms.ads.internal.zzo.zzbv().zzgo());
                bundle.putString("js", str);
                bundle.putString("appid", applicationContext.getPackageName());
                bundle.putString("eids", TextUtils.join(",", zzbz.zzdb()));
            }
            Uri.Builder appendQueryParameter = new Uri.Builder().scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("id", str2);
            for (String str3 : bundle.keySet()) {
                appendQueryParameter.appendQueryParameter(str3, bundle.getString(str3));
            }
            com.google.android.gms.ads.internal.zzo.zzbv().zzc(context, str, appendQueryParameter.toString());
        }
    }

    public void zza(Context context, String str, List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            new zzhp(context, str, it.next()).zzgi();
        }
    }

    public void zza(Context context, String str, List<String> list, String str2) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            new zzhp(context, str, it.next(), str2).zzgi();
        }
    }

    public void zza(Context context, String str, boolean z, HttpURLConnection httpURLConnection) {
        zza(context, str, z, httpURLConnection, false);
    }

    public void zza(Context context, String str, boolean z, HttpURLConnection httpURLConnection, String str2) {
        httpURLConnection.setConnectTimeout(60000);
        httpURLConnection.setInstanceFollowRedirects(z);
        httpURLConnection.setReadTimeout(60000);
        httpURLConnection.setRequestProperty("User-Agent", str2);
        httpURLConnection.setUseCaches(false);
    }

    public void zza(Context context, String str, boolean z, HttpURLConnection httpURLConnection, boolean z2) {
        httpURLConnection.setConnectTimeout(60000);
        httpURLConnection.setInstanceFollowRedirects(z);
        httpURLConnection.setReadTimeout(60000);
        httpURLConnection.setRequestProperty("User-Agent", zzf(context, str));
        httpURLConnection.setUseCaches(z2);
    }

    public boolean zza(PackageManager packageManager, String str, String str2) {
        return packageManager.checkPermission(str2, str) == 0;
    }

    public boolean zza(ClassLoader classLoader, Class<?> cls, String str) {
        try {
            return cls.isAssignableFrom(Class.forName(str, false, classLoader));
        } catch (Throwable th) {
            return false;
        }
    }

    public String zzat(String str) {
        return Uri.parse(str).buildUpon().query(null).build().toString();
    }

    public int zzau(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("Could not parse value:" + e);
            return 0;
        }
    }

    public boolean zzav(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp|webp))$)");
    }

    public void zzb(Activity activity, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        Window window = activity.getWindow();
        if (window == null || window.getDecorView() == null || window.getDecorView().getViewTreeObserver() == null) {
            return;
        }
        window.getDecorView().getViewTreeObserver().removeOnScrollChangedListener(onScrollChangedListener);
    }

    public void zzc(Context context, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str2);
        zza(context, str, arrayList);
    }

    public Map<String, String> zzd(Uri uri) {
        if (uri == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (String str : com.google.android.gms.ads.internal.zzo.zzbx().zze(uri)) {
            hashMap.put(str, uri.getQueryParameter(str));
        }
        return hashMap;
    }

    public String zzf(final Context context, String str) {
        synchronized (this.zzqt) {
            if (this.zzFP != null) {
                return this.zzFP;
            }
            try {
                this.zzFP = com.google.android.gms.ads.internal.zzo.zzbx().getDefaultUserAgent(context);
            } catch (Exception e) {
            }
            if (TextUtils.isEmpty(this.zzFP)) {
                if (com.google.android.gms.ads.internal.client.zzk.zzcA().zzgw()) {
                    try {
                        this.zzFP = zzI(context);
                    } catch (Exception e2) {
                        this.zzFP = zzgm();
                    }
                } else {
                    this.zzFP = null;
                    zzGk.post(new Runnable() { // from class: com.google.android.gms.internal.zzhl.1
                        @Override // java.lang.Runnable
                        public void run() {
                            synchronized (zzhl.this.zzqt) {
                                zzhl.this.zzFP = zzhl.this.zzI(context);
                                zzhl.this.zzqt.notifyAll();
                            }
                        }
                    });
                    while (this.zzFP == null) {
                        try {
                            this.zzqt.wait();
                        } catch (InterruptedException e3) {
                            this.zzFP = zzgm();
                            com.google.android.gms.ads.internal.util.client.zzb.zzaC("Interrupted, use default user agent: " + this.zzFP);
                        }
                    }
                }
            }
            this.zzFP += " (Mobile; " + str + ")";
            return this.zzFP;
        }
    }

    public int[] zzg(Activity activity) {
        View findViewById;
        Window window = activity.getWindow();
        return (window == null || (findViewById = window.findViewById(R.id.content)) == null) ? zzgp() : new int[]{findViewById.getWidth(), findViewById.getHeight()};
    }

    public boolean zzgl() {
        return this.zzGl;
    }

    String zzgm() {
        StringBuffer stringBuffer = new StringBuffer(256);
        stringBuffer.append("Mozilla/5.0 (Linux; U; Android");
        if (Build.VERSION.RELEASE != null) {
            stringBuffer.append(" ").append(Build.VERSION.RELEASE);
        }
        stringBuffer.append("; ").append(Locale.getDefault());
        if (Build.DEVICE != null) {
            stringBuffer.append("; ").append(Build.DEVICE);
            if (Build.DISPLAY != null) {
                stringBuffer.append(" Build/").append(Build.DISPLAY);
            }
        }
        stringBuffer.append(") AppleWebKit/533 Version/4.0 Safari/533");
        return stringBuffer.toString();
    }

    public String zzgn() {
        UUID randomUUID = UUID.randomUUID();
        byte[] byteArray = BigInteger.valueOf(randomUUID.getLeastSignificantBits()).toByteArray();
        byte[] byteArray2 = BigInteger.valueOf(randomUUID.getMostSignificantBits()).toByteArray();
        String bigInteger = new BigInteger(1, byteArray).toString();
        for (int i = 0; i < 2; i++) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(byteArray);
                messageDigest.update(byteArray2);
                byte[] bArr = new byte[8];
                System.arraycopy(messageDigest.digest(), 0, bArr, 0, 8);
                bigInteger = new BigInteger(1, bArr).toString();
            } catch (NoSuchAlgorithmException e) {
            }
        }
        return bigInteger;
    }

    public String zzgo() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        return str2.startsWith(str) ? str2 : str + " " + str2;
    }

    protected int[] zzgp() {
        return new int[]{0, 0};
    }

    public int[] zzh(Activity activity) {
        int[] zzg = zzg(activity);
        return new int[]{com.google.android.gms.ads.internal.client.zzk.zzcA().zzc(activity, zzg[0]), com.google.android.gms.ads.internal.client.zzk.zzcA().zzc(activity, zzg[1])};
    }

    public int[] zzi(Activity activity) {
        View findViewById;
        Window window = activity.getWindow();
        return (window == null || (findViewById = window.findViewById(R.id.content)) == null) ? zzgp() : new int[]{findViewById.getTop(), findViewById.getBottom()};
    }

    public Bitmap zzj(View view) {
        view.setDrawingCacheEnabled(true);
        Bitmap createBitmap = Bitmap.createBitmap(view.getDrawingCache());
        view.setDrawingCacheEnabled(false);
        return createBitmap;
    }

    public int[] zzj(Activity activity) {
        int[] zzi = zzi(activity);
        return new int[]{com.google.android.gms.ads.internal.client.zzk.zzcA().zzc(activity, zzi[0]), com.google.android.gms.ads.internal.client.zzk.zzcA().zzc(activity, zzi[1])};
    }

    public int zzk(Activity activity) {
        String str;
        if (activity == null) {
            str = "Fail to get AdActivity type since it is null";
        } else {
            AdOverlayInfoParcel zzb = AdOverlayInfoParcel.zzb(activity.getIntent());
            if (zzb != null) {
                switch (zzb.zzzK) {
                }
                return 0;
            }
            str = "Fail to get AdOverlayInfo";
        }
        com.google.android.gms.ads.internal.util.client.zzb.zzaC(str);
        return 0;
    }

    public JSONObject zzy(Map<String, ?> map) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            for (String str : map.keySet()) {
                zza(jSONObject, str, map.get(str));
            }
            return jSONObject;
        } catch (ClassCastException e) {
            throw new JSONException("Could not convert map to JSON: " + e.getMessage());
        }
    }
}
