package com.google.android.gms.ads.internal.purchase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.SystemClock;
import com.google.android.gms.internal.zzgd;

@zzgd
/* loaded from: classes.dex */
public class zzh {
    private static zzh zzAZ;
    private final zza zzAY;
    private static final String zzAX = String.format("CREATE TABLE IF NOT EXISTS %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, %s TEXT NOT NULL, %s TEXT NOT NULL, %s INTEGER)", "InAppPurchase", "purchase_id", "product_id", "developer_payload", "record_time");
    private static final Object zzqt = new Object();

    public class zza extends SQLiteOpenHelper {
        public zza(Context context, String str) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, 4);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL(zzh.zzAX);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaA("Database updated from version " + i + " to version " + i2);
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS InAppPurchase");
            onCreate(sQLiteDatabase);
        }
    }

    zzh(Context context) {
        this.zzAY = new zza(context, "google_inapp_purchase.db");
    }

    public static zzh zzy(Context context) {
        zzh zzhVar;
        synchronized (zzqt) {
            if (zzAZ == null) {
                zzAZ = new zzh(context);
            }
            zzhVar = zzAZ;
        }
        return zzhVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0024, code lost:
    
        if (r3 != null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0026, code lost:
    
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004b, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0047, code lost:
    
        if (r3 == null) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int getRecordCount() {
        /*
            r6 = this;
            java.lang.Object r0 = com.google.android.gms.ads.internal.purchase.zzh.zzqt
            monitor-enter(r0)
            android.database.sqlite.SQLiteDatabase r1 = r6.getWritableDatabase()     // Catch: java.lang.Throwable -> L52
            r2 = 0
            if (r1 != 0) goto Lc
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L52
            return r2
        Lc:
            r3 = 0
            java.lang.String r4 = "select count(*) from InAppPurchase"
            android.database.Cursor r3 = r1.rawQuery(r4, r3)     // Catch: java.lang.Throwable -> L2a android.database.sqlite.SQLiteException -> L2c
            boolean r1 = r3.moveToFirst()     // Catch: java.lang.Throwable -> L2a android.database.sqlite.SQLiteException -> L2c
            if (r1 == 0) goto L24
            int r1 = r3.getInt(r2)     // Catch: java.lang.Throwable -> L2a android.database.sqlite.SQLiteException -> L2c
            if (r3 == 0) goto L22
            r3.close()     // Catch: java.lang.Throwable -> L52
        L22:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L52
            return r1
        L24:
            if (r3 == 0) goto L4a
        L26:
            r3.close()     // Catch: java.lang.Throwable -> L52
            goto L4a
        L2a:
            r1 = move-exception
            goto L4c
        L2c:
            r1 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2a
            r4.<init>()     // Catch: java.lang.Throwable -> L2a
            java.lang.String r5 = "Error getting record count"
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> L2a
            java.lang.String r1 = r1.getMessage()     // Catch: java.lang.Throwable -> L2a
            java.lang.StringBuilder r1 = r4.append(r1)     // Catch: java.lang.Throwable -> L2a
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L2a
            com.google.android.gms.ads.internal.util.client.zzb.zzaC(r1)     // Catch: java.lang.Throwable -> L2a
            if (r3 == 0) goto L4a
            goto L26
        L4a:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L52
            return r2
        L4c:
            if (r3 == 0) goto L51
            r3.close()     // Catch: java.lang.Throwable -> L52
        L51:
            throw r1     // Catch: java.lang.Throwable -> L52
        L52:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L52
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.purchase.zzh.getRecordCount():int");
    }

    public SQLiteDatabase getWritableDatabase() {
        try {
            return this.zzAY.getWritableDatabase();
        } catch (SQLiteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("Error opening writable conversion tracking database");
            return null;
        }
    }

    public zzf zza(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        return new zzf(cursor.getLong(0), cursor.getString(1), cursor.getString(2));
    }

    public void zza(zzf zzfVar) {
        if (zzfVar == null) {
            return;
        }
        synchronized (zzqt) {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null) {
                return;
            }
            writableDatabase.delete("InAppPurchase", String.format("%s = %d", "purchase_id", Long.valueOf(zzfVar.zzAR)), null);
        }
    }

    public void zzb(zzf zzfVar) {
        if (zzfVar == null) {
            return;
        }
        synchronized (zzqt) {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("product_id", zzfVar.zzAT);
            contentValues.put("developer_payload", zzfVar.zzAS);
            contentValues.put("record_time", Long.valueOf(SystemClock.elapsedRealtime()));
            zzfVar.zzAR = writableDatabase.insert("InAppPurchase", null, contentValues);
            if (getRecordCount() > 20000) {
                zzfg();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0064, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0060, code lost:
    
        if (r11 == null) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<com.google.android.gms.ads.internal.purchase.zzf> zzf(long r13) {
        /*
            r12 = this;
            java.lang.Object r0 = com.google.android.gms.ads.internal.purchase.zzh.zzqt
            monitor-enter(r0)
            java.util.LinkedList r1 = new java.util.LinkedList     // Catch: java.lang.Throwable -> L6b
            r1.<init>()     // Catch: java.lang.Throwable -> L6b
            r2 = 0
            int r2 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
            if (r2 > 0) goto L10
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L6b
            return r1
        L10:
            android.database.sqlite.SQLiteDatabase r2 = r12.getWritableDatabase()     // Catch: java.lang.Throwable -> L6b
            if (r2 != 0) goto L18
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L6b
            return r1
        L18:
            r11 = 0
            java.lang.String r9 = "record_time ASC"
            java.lang.String r3 = "InAppPurchase"
            java.lang.String r10 = java.lang.String.valueOf(r13)     // Catch: java.lang.Throwable -> L43 android.database.sqlite.SQLiteException -> L45
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r11 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L43 android.database.sqlite.SQLiteException -> L45
            boolean r13 = r11.moveToFirst()     // Catch: java.lang.Throwable -> L43 android.database.sqlite.SQLiteException -> L45
            if (r13 == 0) goto L3d
        L30:
            com.google.android.gms.ads.internal.purchase.zzf r13 = r12.zza(r11)     // Catch: java.lang.Throwable -> L43 android.database.sqlite.SQLiteException -> L45
            r1.add(r13)     // Catch: java.lang.Throwable -> L43 android.database.sqlite.SQLiteException -> L45
            boolean r13 = r11.moveToNext()     // Catch: java.lang.Throwable -> L43 android.database.sqlite.SQLiteException -> L45
            if (r13 != 0) goto L30
        L3d:
            if (r11 == 0) goto L63
        L3f:
            r11.close()     // Catch: java.lang.Throwable -> L6b
            goto L63
        L43:
            r13 = move-exception
            goto L65
        L45:
            r13 = move-exception
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L43
            r14.<init>()     // Catch: java.lang.Throwable -> L43
            java.lang.String r2 = "Error extracing purchase info: "
            java.lang.StringBuilder r14 = r14.append(r2)     // Catch: java.lang.Throwable -> L43
            java.lang.String r13 = r13.getMessage()     // Catch: java.lang.Throwable -> L43
            java.lang.StringBuilder r13 = r14.append(r13)     // Catch: java.lang.Throwable -> L43
            java.lang.String r13 = r13.toString()     // Catch: java.lang.Throwable -> L43
            com.google.android.gms.ads.internal.util.client.zzb.zzaC(r13)     // Catch: java.lang.Throwable -> L43
            if (r11 == 0) goto L63
            goto L3f
        L63:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L6b
            return r1
        L65:
            if (r11 == 0) goto L6a
            r11.close()     // Catch: java.lang.Throwable -> L6b
        L6a:
            throw r13     // Catch: java.lang.Throwable -> L6b
        L6b:
            r13 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L6b
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.purchase.zzh.zzf(long):java.util.List");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0051, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004d, code lost:
    
        if (r10 == null) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void zzfg() {
        /*
            r11 = this;
            java.lang.Object r0 = com.google.android.gms.ads.internal.purchase.zzh.zzqt
            monitor-enter(r0)
            android.database.sqlite.SQLiteDatabase r1 = r11.getWritableDatabase()     // Catch: java.lang.Throwable -> L58
            if (r1 != 0) goto Lb
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L58
            return
        Lb:
            r10 = 0
            java.lang.String r8 = "record_time ASC"
            java.lang.String r2 = "InAppPurchase"
            java.lang.String r9 = "1"
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r10 = r1.query(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L32
            if (r10 == 0) goto L2a
            boolean r1 = r10.moveToFirst()     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L32
            if (r1 == 0) goto L2a
            com.google.android.gms.ads.internal.purchase.zzf r1 = r11.zza(r10)     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L32
            r11.zza(r1)     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L32
        L2a:
            if (r10 == 0) goto L50
        L2c:
            r10.close()     // Catch: java.lang.Throwable -> L58
            goto L50
        L30:
            r1 = move-exception
            goto L52
        L32:
            r1 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L30
            r2.<init>()     // Catch: java.lang.Throwable -> L30
            java.lang.String r3 = "Error remove oldest record"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L30
            java.lang.String r1 = r1.getMessage()     // Catch: java.lang.Throwable -> L30
            java.lang.StringBuilder r1 = r2.append(r1)     // Catch: java.lang.Throwable -> L30
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L30
            com.google.android.gms.ads.internal.util.client.zzb.zzaC(r1)     // Catch: java.lang.Throwable -> L30
            if (r10 == 0) goto L50
            goto L2c
        L50:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L58
            return
        L52:
            if (r10 == 0) goto L57
            r10.close()     // Catch: java.lang.Throwable -> L58
        L57:
            throw r1     // Catch: java.lang.Throwable -> L58
        L58:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L58
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.purchase.zzh.zzfg():void");
    }
}
