package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzaf;
import com.google.android.gms.internal.zzqf;
import com.google.android.gms.tagmanager.zzcb;
import com.google.android.gms.tagmanager.zzt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class Container {
    private final Context mContext;
    private zzcp zzaKA;
    private volatile long zzaKD;
    private final String zzaKy;
    private final DataLayer zzaKz;
    private Map<String, FunctionCallMacroCallback> zzaKB = new HashMap();
    private Map<String, FunctionCallTagCallback> zzaKC = new HashMap();
    private volatile String zzaKE = "";

    public interface FunctionCallMacroCallback {
        Object getValue(String str, Map<String, Object> map);
    }

    public interface FunctionCallTagCallback {
        void execute(String str, Map<String, Object> map);
    }

    private class zza implements zzt.zza {
        private zza() {
        }

        @Override // com.google.android.gms.tagmanager.zzt.zza
        public Object zzd(String str, Map<String, Object> map) {
            FunctionCallMacroCallback zzef = Container.this.zzef(str);
            if (zzef == null) {
                return null;
            }
            return zzef.getValue(str, map);
        }
    }

    private class zzb implements zzt.zza {
        private zzb() {
        }

        @Override // com.google.android.gms.tagmanager.zzt.zza
        public Object zzd(String str, Map<String, Object> map) {
            FunctionCallTagCallback zzeg = Container.this.zzeg(str);
            if (zzeg != null) {
                zzeg.execute(str, map);
            }
            return zzdf.zzzP();
        }
    }

    Container(Context context, DataLayer dataLayer, String str, long j, zzaf.zzj zzjVar) {
        this.mContext = context;
        this.zzaKz = dataLayer;
        this.zzaKy = str;
        this.zzaKD = j;
        zza(zzjVar.zziO);
        if (zzjVar.zziN != null) {
            zza(zzjVar.zziN);
        }
    }

    Container(Context context, DataLayer dataLayer, String str, long j, zzqf.zzc zzcVar) {
        this.mContext = context;
        this.zzaKz = dataLayer;
        this.zzaKy = str;
        this.zzaKD = j;
        zza(zzcVar);
    }

    private void zza(zzaf.zzf zzfVar) {
        if (zzfVar == null) {
            throw new NullPointerException();
        }
        try {
            zza(zzqf.zzb(zzfVar));
        } catch (zzqf.zzg e) {
            zzbg.zzaz("Not loading resource: " + zzfVar + " because it is invalid: " + e.toString());
        }
    }

    private void zza(zzqf.zzc zzcVar) {
        this.zzaKE = zzcVar.getVersion();
        zza(new zzcp(this.mContext, zzcVar, this.zzaKz, new zza(), new zzb(), zzei(this.zzaKE)));
        if (getBoolean("_gtm.loadEventEnabled")) {
            this.zzaKz.pushEvent("gtm.load", DataLayer.mapOf("gtm.id", this.zzaKy));
        }
    }

    private synchronized void zza(zzcp zzcpVar) {
        this.zzaKA = zzcpVar;
    }

    private void zza(zzaf.zzi[] zziVarArr) {
        ArrayList arrayList = new ArrayList();
        for (zzaf.zzi zziVar : zziVarArr) {
            arrayList.add(zziVar);
        }
        zzyn().zzs(arrayList);
    }

    private synchronized zzcp zzyn() {
        return this.zzaKA;
    }

    public boolean getBoolean(String str) {
        String str2;
        zzcp zzyn = zzyn();
        if (zzyn == null) {
            str2 = "getBoolean called for closed container.";
        } else {
            try {
                return zzdf.zzk(zzyn.zzeD(str).getObject()).booleanValue();
            } catch (Exception e) {
                str2 = "Calling getBoolean() threw an exception: " + e.getMessage() + " Returning default value.";
            }
        }
        zzbg.zzaz(str2);
        return zzdf.zzzN().booleanValue();
    }

    public String getContainerId() {
        return this.zzaKy;
    }

    public double getDouble(String str) {
        String str2;
        zzcp zzyn = zzyn();
        if (zzyn == null) {
            str2 = "getDouble called for closed container.";
        } else {
            try {
                return zzdf.zzj(zzyn.zzeD(str).getObject()).doubleValue();
            } catch (Exception e) {
                str2 = "Calling getDouble() threw an exception: " + e.getMessage() + " Returning default value.";
            }
        }
        zzbg.zzaz(str2);
        return zzdf.zzzM().doubleValue();
    }

    public long getLastRefreshTime() {
        return this.zzaKD;
    }

    public long getLong(String str) {
        String str2;
        zzcp zzyn = zzyn();
        if (zzyn == null) {
            str2 = "getLong called for closed container.";
        } else {
            try {
                return zzdf.zzi(zzyn.zzeD(str).getObject()).longValue();
            } catch (Exception e) {
                str2 = "Calling getLong() threw an exception: " + e.getMessage() + " Returning default value.";
            }
        }
        zzbg.zzaz(str2);
        return zzdf.zzzL().longValue();
    }

    public String getString(String str) {
        String str2;
        zzcp zzyn = zzyn();
        if (zzyn == null) {
            str2 = "getString called for closed container.";
        } else {
            try {
                return zzdf.zzg(zzyn.zzeD(str).getObject());
            } catch (Exception e) {
                str2 = "Calling getString() threw an exception: " + e.getMessage() + " Returning default value.";
            }
        }
        zzbg.zzaz(str2);
        return zzdf.zzzP();
    }

    public boolean isDefault() {
        return getLastRefreshTime() == 0;
    }

    public void registerFunctionCallMacroCallback(String str, FunctionCallMacroCallback functionCallMacroCallback) {
        if (functionCallMacroCallback == null) {
            throw new NullPointerException("Macro handler must be non-null");
        }
        synchronized (this.zzaKB) {
            this.zzaKB.put(str, functionCallMacroCallback);
        }
    }

    public void registerFunctionCallTagCallback(String str, FunctionCallTagCallback functionCallTagCallback) {
        if (functionCallTagCallback == null) {
            throw new NullPointerException("Tag callback must be non-null");
        }
        synchronized (this.zzaKC) {
            this.zzaKC.put(str, functionCallTagCallback);
        }
    }

    void release() {
        this.zzaKA = null;
    }

    public void unregisterFunctionCallMacroCallback(String str) {
        synchronized (this.zzaKB) {
            this.zzaKB.remove(str);
        }
    }

    public void unregisterFunctionCallTagCallback(String str) {
        synchronized (this.zzaKC) {
            this.zzaKC.remove(str);
        }
    }

    FunctionCallMacroCallback zzef(String str) {
        FunctionCallMacroCallback functionCallMacroCallback;
        synchronized (this.zzaKB) {
            functionCallMacroCallback = this.zzaKB.get(str);
        }
        return functionCallMacroCallback;
    }

    FunctionCallTagCallback zzeg(String str) {
        FunctionCallTagCallback functionCallTagCallback;
        synchronized (this.zzaKC) {
            functionCallTagCallback = this.zzaKC.get(str);
        }
        return functionCallTagCallback;
    }

    void zzeh(String str) {
        zzyn().zzeh(str);
    }

    zzah zzei(String str) {
        zzcb.zzzf().zzzg().equals(zzcb.zza.CONTAINER_DEBUG);
        return new zzbo();
    }

    String zzym() {
        return this.zzaKE;
    }
}
