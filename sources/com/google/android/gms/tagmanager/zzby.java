package com.google.android.gms.tagmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.google.android.gms.internal.zzlb;
import com.google.android.gms.internal.zzld;
import com.google.android.gms.tagmanager.zzcx;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import org.apache.http.impl.client.DefaultHttpClient;

/* loaded from: classes.dex */
class zzby implements zzau {
    private static final String zzKg = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL,'%s' INTEGER NOT NULL);", "gtm_hits", "hit_id", "hit_time", "hit_url", "hit_first_send_time");
    private final Context mContext;
    private final zzb zzaMs;
    private volatile zzac zzaMt;
    private final zzav zzaMu;
    private final String zzaMv;
    private long zzaMw;
    private final int zzaMx;
    private zzlb zzpw;

    class zza implements zzcx.zza {
        zza() {
        }

        @Override // com.google.android.gms.tagmanager.zzcx.zza
        public void zza(zzaq zzaqVar) {
            zzby.this.zzq(zzaqVar.zzyO());
        }

        @Override // com.google.android.gms.tagmanager.zzcx.zza
        public void zzb(zzaq zzaqVar) {
            zzby.this.zzq(zzaqVar.zzyO());
            zzbg.zzaB("Permanent failure dispatching hitId: " + zzaqVar.zzyO());
        }

        @Override // com.google.android.gms.tagmanager.zzcx.zza
        public void zzc(zzaq zzaqVar) {
            long zzyP = zzaqVar.zzyP();
            if (zzyP == 0) {
                zzby.this.zzd(zzaqVar.zzyO(), zzby.this.zzpw.currentTimeMillis());
            } else if (zzyP + 14400000 < zzby.this.zzpw.currentTimeMillis()) {
                zzby.this.zzq(zzaqVar.zzyO());
                zzbg.zzaB("Giving up on failed hitId: " + zzaqVar.zzyO());
            }
        }
    }

    class zzb extends SQLiteOpenHelper {
        private long zzaMA;
        private boolean zzaMz;

        zzb(Context context, String str) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
            this.zzaMA = 0L;
        }

        private boolean zza(String str, SQLiteDatabase sQLiteDatabase) {
            Cursor cursor = null;
            try {
                try {
                    cursor = sQLiteDatabase.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, null, null, null);
                    boolean moveToFirst = cursor.moveToFirst();
                    if (cursor != null) {
                        cursor.close();
                    }
                    return moveToFirst;
                } catch (SQLiteException e) {
                    zzbg.zzaC("Error querying for table " + str);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return false;
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }

        private void zzc(SQLiteDatabase sQLiteDatabase) {
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM gtm_hits WHERE 0", null);
            HashSet hashSet = new HashSet();
            try {
                for (String str : rawQuery.getColumnNames()) {
                    hashSet.add(str);
                }
                rawQuery.close();
                if (!hashSet.remove("hit_id") || !hashSet.remove("hit_url") || !hashSet.remove("hit_time") || !hashSet.remove("hit_first_send_time")) {
                    throw new SQLiteException("Database column missing");
                }
                if (!hashSet.isEmpty()) {
                    throw new SQLiteException("Database has extra columns");
                }
            } catch (Throwable th) {
                rawQuery.close();
                throw th;
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public SQLiteDatabase getWritableDatabase() {
            SQLiteDatabase sQLiteDatabase;
            if (this.zzaMz && this.zzaMA + 3600000 > zzby.this.zzpw.currentTimeMillis()) {
                throw new SQLiteException("Database creation failed");
            }
            this.zzaMz = true;
            this.zzaMA = zzby.this.zzpw.currentTimeMillis();
            try {
                sQLiteDatabase = super.getWritableDatabase();
            } catch (SQLiteException e) {
                zzby.this.mContext.getDatabasePath(zzby.this.zzaMv).delete();
                sQLiteDatabase = null;
            }
            if (sQLiteDatabase == null) {
                sQLiteDatabase = super.getWritableDatabase();
            }
            this.zzaMz = false;
            return sQLiteDatabase;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            zzal.zzbe(sQLiteDatabase.getPath());
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            if (zza("gtm_hits", sQLiteDatabase)) {
                zzc(sQLiteDatabase);
            } else {
                sQLiteDatabase.execSQL(zzby.zzKg);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    zzby(zzav zzavVar, Context context) {
        this(zzavVar, context, "gtm_urls.db", 2000);
    }

    zzby(zzav zzavVar, Context context, String str, int i) {
        this.mContext = context.getApplicationContext();
        this.zzaMv = str;
        this.zzaMu = zzavVar;
        this.zzpw = zzld.zzoQ();
        this.zzaMs = new zzb(this.mContext, this.zzaMv);
        this.zzaMt = new zzcx(new DefaultHttpClient(), this.mContext, new zza());
        this.zzaMw = 0L;
        this.zzaMx = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzd(long j, long j2) {
        SQLiteDatabase zzer = zzer("Error opening database for getNumStoredHits.");
        if (zzer == null) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("hit_first_send_time", Long.valueOf(j2));
        try {
            zzer.update("gtm_hits", contentValues, "hit_id=?", new String[]{String.valueOf(j)});
        } catch (SQLiteException e) {
            zzbg.zzaC("Error setting HIT_FIRST_DISPATCH_TIME for hitId: " + j);
            zzq(j);
        }
    }

    private SQLiteDatabase zzer(String str) {
        try {
            return this.zzaMs.getWritableDatabase();
        } catch (SQLiteException e) {
            zzbg.zzaC(str);
            return null;
        }
    }

    private void zzh(long j, String str) {
        SQLiteDatabase zzer = zzer("Error opening database for putHit");
        if (zzer == null) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("hit_time", Long.valueOf(j));
        contentValues.put("hit_url", str);
        contentValues.put("hit_first_send_time", (Integer) 0);
        try {
            zzer.insert("gtm_hits", null, contentValues);
            this.zzaMu.zzan(false);
        } catch (SQLiteException e) {
            zzbg.zzaC("Error storing hit");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzq(long j) {
        zzf(new String[]{String.valueOf(j)});
    }

    private void zzzb() {
        int zzzc = (zzzc() - this.zzaMx) + 1;
        if (zzzc > 0) {
            List<String> zziY = zziY(zzzc);
            zzbg.zzaB("Store full, deleting " + zziY.size() + " hits to make room.");
            zzf((String[]) zziY.toArray(new String[0]));
        }
    }

    @Override // com.google.android.gms.tagmanager.zzau
    public void dispatch() {
        zzbg.zzaB("GTM Dispatch running...");
        if (this.zzaMt.zzyH()) {
            List<zzaq> zziZ = zziZ(40);
            if (zziZ.isEmpty()) {
                zzbg.zzaB("...nothing to dispatch");
                this.zzaMu.zzan(true);
            } else {
                this.zzaMt.zzr(zziZ);
                if (zzzd() > 0) {
                    zzcu.zzzz().dispatch();
                }
            }
        }
    }

    void zzf(String[] strArr) {
        SQLiteDatabase zzer;
        if (strArr == null || strArr.length == 0 || (zzer = zzer("Error opening database for deleteHits.")) == null) {
            return;
        }
        try {
            zzer.delete("gtm_hits", String.format("HIT_ID in (%s)", TextUtils.join(",", Collections.nCopies(strArr.length, "?"))), strArr);
            this.zzaMu.zzan(zzzc() == 0);
        } catch (SQLiteException e) {
            zzbg.zzaC("Error deleting hits");
        }
    }

    @Override // com.google.android.gms.tagmanager.zzau
    public void zzg(long j, String str) {
        zzis();
        zzzb();
        zzh(j, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x004e, code lost:
    
        if (r2 != null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0073, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0070, code lost:
    
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006e, code lost:
    
        if (r2 == null) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    java.util.List<java.lang.String> zziY(int r14) {
        /*
            r13 = this;
            java.lang.String r0 = "hit_id"
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            if (r14 > 0) goto Lf
            java.lang.String r14 = "Invalid maxHits specified. Skipping"
            com.google.android.gms.tagmanager.zzbg.zzaC(r14)
            return r1
        Lf:
            java.lang.String r2 = "Error opening database for peekHitIds."
            android.database.sqlite.SQLiteDatabase r3 = r13.zzer(r2)
            if (r3 != 0) goto L18
            return r1
        L18:
            r2 = 0
            java.lang.String r4 = "gtm_hits"
            r5 = 1
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteException -> L53
            r12 = 0
            r5[r12] = r0     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteException -> L53
            java.lang.String r6 = "%s ASC"
            java.lang.Object[] r0 = new java.lang.Object[]{r0}     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteException -> L53
            java.lang.String r10 = java.lang.String.format(r6, r0)     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteException -> L53
            java.lang.String r11 = java.lang.Integer.toString(r14)     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteException -> L53
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r2 = r3.query(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteException -> L53
            boolean r14 = r2.moveToFirst()     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteException -> L53
            if (r14 == 0) goto L4e
        L3d:
            long r3 = r2.getLong(r12)     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteException -> L53
            java.lang.String r14 = java.lang.String.valueOf(r3)     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteException -> L53
            r1.add(r14)     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteException -> L53
            boolean r14 = r2.moveToNext()     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteException -> L53
            if (r14 != 0) goto L3d
        L4e:
            if (r2 == 0) goto L73
            goto L70
        L51:
            r14 = move-exception
            goto L74
        L53:
            r14 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L51
            r0.<init>()     // Catch: java.lang.Throwable -> L51
            java.lang.String r3 = "Error in peekHits fetching hitIds: "
            java.lang.StringBuilder r0 = r0.append(r3)     // Catch: java.lang.Throwable -> L51
            java.lang.String r14 = r14.getMessage()     // Catch: java.lang.Throwable -> L51
            java.lang.StringBuilder r14 = r0.append(r14)     // Catch: java.lang.Throwable -> L51
            java.lang.String r14 = r14.toString()     // Catch: java.lang.Throwable -> L51
            com.google.android.gms.tagmanager.zzbg.zzaC(r14)     // Catch: java.lang.Throwable -> L51
            if (r2 == 0) goto L73
        L70:
            r2.close()
        L73:
            return r1
        L74:
            if (r2 == 0) goto L79
            r2.close()
        L79:
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzby.zziY(int):java.util.List");
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0170  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<com.google.android.gms.tagmanager.zzaq> zziZ(int r18) {
        /*
            Method dump skipped, instructions count: 372
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzby.zziZ(int):java.util.List");
    }

    int zzis() {
        long currentTimeMillis = this.zzpw.currentTimeMillis();
        if (currentTimeMillis <= this.zzaMw + 86400000) {
            return 0;
        }
        this.zzaMw = currentTimeMillis;
        SQLiteDatabase zzer = zzer("Error opening database for deleteStaleHits.");
        if (zzer == null) {
            return 0;
        }
        int delete = zzer.delete("gtm_hits", "HIT_TIME < ?", new String[]{Long.toString(this.zzpw.currentTimeMillis() - 2592000000L)});
        this.zzaMu.zzan(zzzc() == 0);
        return delete;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002e, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x002b, code lost:
    
        if (r2 == null) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    int zzzc() {
        /*
            r4 = this;
            java.lang.String r0 = "Error opening database for getNumStoredHits."
            android.database.sqlite.SQLiteDatabase r0 = r4.zzer(r0)
            r1 = 0
            if (r0 != 0) goto La
            return r1
        La:
            r2 = 0
            java.lang.String r3 = "SELECT COUNT(*) from gtm_hits"
            android.database.Cursor r2 = r0.rawQuery(r3, r2)     // Catch: java.lang.Throwable -> L23 android.database.sqlite.SQLiteException -> L25
            boolean r0 = r2.moveToFirst()     // Catch: java.lang.Throwable -> L23 android.database.sqlite.SQLiteException -> L25
            if (r0 == 0) goto L1d
            long r0 = r2.getLong(r1)     // Catch: java.lang.Throwable -> L23 android.database.sqlite.SQLiteException -> L25
            int r0 = (int) r0
            r1 = r0
        L1d:
            if (r2 == 0) goto L2e
        L1f:
            r2.close()
            goto L2e
        L23:
            r0 = move-exception
            goto L2f
        L25:
            r0 = move-exception
            java.lang.String r0 = "Error getting numStoredHits"
            com.google.android.gms.tagmanager.zzbg.zzaC(r0)     // Catch: java.lang.Throwable -> L23
            if (r2 == 0) goto L2e
            goto L1f
        L2e:
            return r1
        L2f:
            if (r2 == 0) goto L34
            r2.close()
        L34:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzby.zzzc():int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0038, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0035, code lost:
    
        if (r9 == null) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    int zzzd() {
        /*
            r10 = this;
            java.lang.String r0 = "Error opening database for getNumStoredHits."
            android.database.sqlite.SQLiteDatabase r1 = r10.zzer(r0)
            r0 = 0
            if (r1 != 0) goto La
            return r0
        La:
            r9 = 0
            java.lang.String r2 = "gtm_hits"
            r3 = 2
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L2d android.database.sqlite.SQLiteException -> L2f
            java.lang.String r4 = "hit_id"
            r3[r0] = r4     // Catch: java.lang.Throwable -> L2d android.database.sqlite.SQLiteException -> L2f
            java.lang.String r4 = "hit_first_send_time"
            r5 = 1
            r3[r5] = r4     // Catch: java.lang.Throwable -> L2d android.database.sqlite.SQLiteException -> L2f
            java.lang.String r4 = "hit_first_send_time=0"
            r7 = 0
            r8 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r9 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L2d android.database.sqlite.SQLiteException -> L2f
            int r0 = r9.getCount()     // Catch: java.lang.Throwable -> L2d android.database.sqlite.SQLiteException -> L2f
            if (r9 == 0) goto L38
        L29:
            r9.close()
            goto L38
        L2d:
            r0 = move-exception
            goto L39
        L2f:
            r1 = move-exception
            java.lang.String r1 = "Error getting num untried hits"
            com.google.android.gms.tagmanager.zzbg.zzaC(r1)     // Catch: java.lang.Throwable -> L2d
            if (r9 == 0) goto L38
            goto L29
        L38:
            return r0
        L39:
            if (r9 == 0) goto L3e
            r9.close()
        L3e:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzby.zzzd():int");
    }
}
