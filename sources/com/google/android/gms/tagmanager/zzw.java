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
import com.google.android.gms.tagmanager.DataLayer;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
class zzw implements DataLayer.zzc {
    private static final String zzaLp = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' STRING NOT NULL, '%s' BLOB NOT NULL, '%s' INTEGER NOT NULL);", "datalayer", "ID", "key", "value", "expires");
    private final Context mContext;
    private final Executor zzaLq;
    private zza zzaLr;
    private int zzaLs;
    private zzlb zzpw;

    class zza extends SQLiteOpenHelper {
        zza(Context context, String str) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
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
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM datalayer WHERE 0", null);
            HashSet hashSet = new HashSet();
            try {
                for (String str : rawQuery.getColumnNames()) {
                    hashSet.add(str);
                }
                rawQuery.close();
                if (!hashSet.remove("key") || !hashSet.remove("value") || !hashSet.remove("ID") || !hashSet.remove("expires")) {
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
            try {
                sQLiteDatabase = super.getWritableDatabase();
            } catch (SQLiteException e) {
                zzw.this.mContext.getDatabasePath("google_tagmanager.db").delete();
                sQLiteDatabase = null;
            }
            return sQLiteDatabase == null ? super.getWritableDatabase() : sQLiteDatabase;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            zzal.zzbe(sQLiteDatabase.getPath());
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            if (zza("datalayer", sQLiteDatabase)) {
                zzc(sQLiteDatabase);
            } else {
                sQLiteDatabase.execSQL(zzw.zzaLp);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    private static class zzb {
        final byte[] zzaLy;
        final String zztw;

        zzb(String str, byte[] bArr) {
            this.zztw = str;
            this.zzaLy = bArr;
        }

        public String toString() {
            return "KeyAndSerialized: key = " + this.zztw + " serialized hash = " + Arrays.hashCode(this.zzaLy);
        }
    }

    public zzw(Context context) {
        this(context, zzld.zzoQ(), "google_tagmanager.db", 2000, Executors.newSingleThreadExecutor());
    }

    zzw(Context context, zzlb zzlbVar, String str, int i, Executor executor) {
        this.mContext = context;
        this.zzpw = zzlbVar;
        this.zzaLs = i;
        this.zzaLq = executor;
        this.zzaLr = new zza(this.mContext, str);
    }

    private byte[] zzA(Object obj) {
        ObjectOutputStream objectOutputStream;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream2 = null;
        try {
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream.writeObject(obj);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    objectOutputStream.close();
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                }
                return byteArray;
            } catch (IOException e2) {
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException e3) {
                        return null;
                    }
                }
                byteArrayOutputStream.close();
                return null;
            } catch (Throwable th) {
                th = th;
                objectOutputStream2 = objectOutputStream;
                if (objectOutputStream2 != null) {
                    try {
                        objectOutputStream2.close();
                    } catch (IOException e4) {
                        throw th;
                    }
                }
                byteArrayOutputStream.close();
                throw th;
            }
        } catch (IOException e5) {
            objectOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private void zzS(long j) {
        SQLiteDatabase zzer = zzer("Error opening database for deleteOlderThan.");
        if (zzer == null) {
            return;
        }
        try {
            zzbg.zzaB("Deleted " + zzer.delete("datalayer", "expires <= ?", new String[]{Long.toString(j)}) + " expired items");
        } catch (SQLiteException e) {
            zzbg.zzaC("Error deleting old entries.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void zzb(List<zzb> list, long j) {
        try {
            long currentTimeMillis = this.zzpw.currentTimeMillis();
            zzS(currentTimeMillis);
            zziS(list.size());
            zzc(list, currentTimeMillis + j);
        } finally {
            zzyF();
        }
    }

    private void zzc(List<zzb> list, long j) {
        SQLiteDatabase zzer = zzer("Error opening database for writeEntryToDatabase.");
        if (zzer == null) {
            return;
        }
        for (zzb zzbVar : list) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("expires", Long.valueOf(j));
            contentValues.put("key", zzbVar.zztw);
            contentValues.put("value", zzbVar.zzaLy);
            zzer.insert("datalayer", null, contentValues);
        }
    }

    private void zze(String[] strArr) {
        SQLiteDatabase zzer;
        if (strArr == null || strArr.length == 0 || (zzer = zzer("Error opening database for deleteEntries.")) == null) {
            return;
        }
        try {
            zzer.delete("datalayer", String.format("%s in (%s)", "ID", TextUtils.join(",", Collections.nCopies(strArr.length, "?"))), strArr);
        } catch (SQLiteException e) {
            zzbg.zzaC("Error deleting entries " + Arrays.toString(strArr));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzeq(String str) {
        SQLiteDatabase zzer = zzer("Error opening database for clearKeysWithPrefix.");
        try {
            if (zzer == null) {
                return;
            }
            try {
                zzbg.zzaB("Cleared " + zzer.delete("datalayer", "key = ? OR key LIKE ?", new String[]{str, str + ".%"}) + " items");
            } catch (SQLiteException e) {
                zzbg.zzaC("Error deleting entries with key prefix: " + str + " (" + e + ").");
            }
        } finally {
            zzyF();
        }
    }

    private SQLiteDatabase zzer(String str) {
        try {
            return this.zzaLr.getWritableDatabase();
        } catch (SQLiteException e) {
            zzbg.zzaC(str);
            return null;
        }
    }

    private void zziS(int i) {
        int zzyE = (zzyE() - this.zzaLs) + i;
        if (zzyE > 0) {
            List<String> zziT = zziT(zzyE);
            zzbg.zzaA("DataLayer store full, deleting " + zziT.size() + " entries to make room.");
            zze((String[]) zziT.toArray(new String[0]));
        }
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
    private java.util.List<java.lang.String> zziT(int r14) {
        /*
            r13 = this;
            java.lang.String r0 = "ID"
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            if (r14 > 0) goto Lf
            java.lang.String r14 = "Invalid maxEntries specified. Skipping."
            com.google.android.gms.tagmanager.zzbg.zzaC(r14)
            return r1
        Lf:
            java.lang.String r2 = "Error opening database for peekEntryIds."
            android.database.sqlite.SQLiteDatabase r3 = r13.zzer(r2)
            if (r3 != 0) goto L18
            return r1
        L18:
            r2 = 0
            java.lang.String r4 = "datalayer"
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
            java.lang.String r3 = "Error in peekEntries fetching entryIds: "
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzw.zziT(int):java.util.List");
    }

    private List<DataLayer.zza> zzp(List<zzb> list) {
        ArrayList arrayList = new ArrayList();
        for (zzb zzbVar : list) {
            arrayList.add(new DataLayer.zza(zzbVar.zztw, zzq(zzbVar.zzaLy)));
        }
        return arrayList;
    }

    private Object zzq(byte[] bArr) {
        ObjectInputStream objectInputStream;
        Throwable th;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
        } catch (IOException e) {
            objectInputStream = null;
        } catch (ClassNotFoundException e2) {
            objectInputStream = null;
        } catch (Throwable th2) {
            objectInputStream = null;
            th = th2;
        }
        try {
            Object readObject = objectInputStream.readObject();
            try {
                objectInputStream.close();
                byteArrayInputStream.close();
            } catch (IOException e3) {
            }
            return readObject;
        } catch (IOException e4) {
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e5) {
                    return null;
                }
            }
            byteArrayInputStream.close();
            return null;
        } catch (ClassNotFoundException e6) {
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e7) {
                    return null;
                }
            }
            byteArrayInputStream.close();
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e8) {
                    throw th;
                }
            }
            byteArrayInputStream.close();
            throw th;
        }
    }

    private List<zzb> zzq(List<DataLayer.zza> list) {
        ArrayList arrayList = new ArrayList();
        for (DataLayer.zza zzaVar : list) {
            arrayList.add(new zzb(zzaVar.zztw, zzA(zzaVar.zzGK)));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<DataLayer.zza> zzyC() {
        try {
            zzS(this.zzpw.currentTimeMillis());
            return zzp(zzyD());
        } finally {
            zzyF();
        }
    }

    private List<zzb> zzyD() {
        SQLiteDatabase zzer = zzer("Error opening database for loadSerialized.");
        ArrayList arrayList = new ArrayList();
        if (zzer == null) {
            return arrayList;
        }
        Cursor query = zzer.query("datalayer", new String[]{"key", "value"}, null, null, null, null, "ID", null);
        while (query.moveToNext()) {
            try {
                arrayList.add(new zzb(query.getString(0), query.getBlob(1)));
            } finally {
                query.close();
            }
        }
        return arrayList;
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
    private int zzyE() {
        /*
            r4 = this;
            java.lang.String r0 = "Error opening database for getNumStoredEntries."
            android.database.sqlite.SQLiteDatabase r0 = r4.zzer(r0)
            r1 = 0
            if (r0 != 0) goto La
            return r1
        La:
            r2 = 0
            java.lang.String r3 = "SELECT COUNT(*) from datalayer"
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
            java.lang.String r0 = "Error getting numStoredEntries"
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzw.zzyE():int");
    }

    private void zzyF() {
        try {
            this.zzaLr.close();
        } catch (SQLiteException e) {
        }
    }

    @Override // com.google.android.gms.tagmanager.DataLayer.zzc
    public void zza(final DataLayer.zzc.zza zzaVar) {
        this.zzaLq.execute(new Runnable() { // from class: com.google.android.gms.tagmanager.zzw.2
            @Override // java.lang.Runnable
            public void run() {
                zzaVar.zzo(zzw.this.zzyC());
            }
        });
    }

    @Override // com.google.android.gms.tagmanager.DataLayer.zzc
    public void zza(List<DataLayer.zza> list, final long j) {
        final List<zzb> zzq = zzq(list);
        this.zzaLq.execute(new Runnable() { // from class: com.google.android.gms.tagmanager.zzw.1
            @Override // java.lang.Runnable
            public void run() {
                zzw.this.zzb(zzq, j);
            }
        });
    }

    @Override // com.google.android.gms.tagmanager.DataLayer.zzc
    public void zzep(final String str) {
        this.zzaLq.execute(new Runnable() { // from class: com.google.android.gms.tagmanager.zzw.3
            @Override // java.lang.Runnable
            public void run() {
                zzw.this.zzeq(str);
            }
        });
    }
}
