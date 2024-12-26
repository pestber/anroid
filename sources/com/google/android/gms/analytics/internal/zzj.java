package com.google.android.gms.analytics.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.text.TextUtils;
import java.io.Closeable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

/* loaded from: classes.dex */
class zzj extends zzd implements Closeable {
    private static final String zzKg = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL, '%s' TEXT NOT NULL, '%s' INTEGER);", "hits2", "hit_id", "hit_time", "hit_url", "hit_string", "hit_app_id");
    private static final String zzKh = String.format("SELECT MAX(%s) FROM %s WHERE 1;", "hit_time", "hits2");
    private final zza zzKi;
    private final zzaj zzKj;
    private final zzaj zzKk;

    class zza extends SQLiteOpenHelper {
        zza(Context context, String str) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
        }

        private void zza(SQLiteDatabase sQLiteDatabase) {
            Set<String> zzb = zzb(sQLiteDatabase, "hits2");
            String[] strArr = {"hit_id", "hit_string", "hit_time", "hit_url"};
            for (int i = 0; i < 4; i++) {
                String str = strArr[i];
                if (!zzb.remove(str)) {
                    throw new SQLiteException("Database hits2 is missing required column: " + str);
                }
            }
            boolean remove = zzb.remove("hit_app_id");
            if (!zzb.isEmpty()) {
                throw new SQLiteException("Database hits2 has extra columns");
            }
            if (remove) {
                return;
            }
            sQLiteDatabase.execSQL("ALTER TABLE hits2 ADD COLUMN hit_app_id INTEGER");
        }

        private boolean zza(SQLiteDatabase sQLiteDatabase, String str) {
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
                    zzj.this.zzc("Error querying for table", str, e);
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

        private Set<String> zzb(SQLiteDatabase sQLiteDatabase, String str) {
            HashSet hashSet = new HashSet();
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM " + str + " LIMIT 0", null);
            try {
                for (String str2 : rawQuery.getColumnNames()) {
                    hashSet.add(str2);
                }
                return hashSet;
            } finally {
                rawQuery.close();
            }
        }

        private void zzb(SQLiteDatabase sQLiteDatabase) {
            Set<String> zzb = zzb(sQLiteDatabase, "properties");
            String[] strArr = {"app_uid", "cid", "tid", "params", "adid", "hits_count"};
            for (int i = 0; i < 6; i++) {
                String str = strArr[i];
                if (!zzb.remove(str)) {
                    throw new SQLiteException("Database properties is missing required column: " + str);
                }
            }
            if (!zzb.isEmpty()) {
                throw new SQLiteException("Database properties table has extra columns");
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public SQLiteDatabase getWritableDatabase() {
            if (!zzj.this.zzKk.zzv(3600000L)) {
                throw new SQLiteException("Database open failed");
            }
            try {
                return super.getWritableDatabase();
            } catch (SQLiteException e) {
                zzj.this.zzKk.start();
                zzj.this.zzaX("Opening the database failed, dropping the table and recreating it");
                zzj.this.getContext().getDatabasePath(zzj.this.zziv()).delete();
                try {
                    SQLiteDatabase writableDatabase = super.getWritableDatabase();
                    zzj.this.zzKk.clear();
                    return writableDatabase;
                } catch (SQLiteException e2) {
                    zzj.this.zze("Failed to open freshly created database", e2);
                    throw e2;
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            zzx.zzbe(sQLiteDatabase.getPath());
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            if (zza(sQLiteDatabase, "hits2")) {
                zza(sQLiteDatabase);
            } else {
                sQLiteDatabase.execSQL(zzj.zzKg);
            }
            if (zza(sQLiteDatabase, "properties")) {
                zzb(sQLiteDatabase);
            } else {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS properties ( app_uid INTEGER NOT NULL, cid TEXT NOT NULL, tid TEXT NOT NULL, params TEXT NOT NULL, adid INTEGER NOT NULL, hits_count INTEGER NOT NULL, PRIMARY KEY (app_uid, cid, tid)) ;");
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    zzj(zzf zzfVar) {
        super(zzfVar);
        this.zzKj = new zzaj(zzhP());
        this.zzKk = new zzaj(zzhP());
        this.zzKi = new zza(zzfVar.getContext(), zziv());
    }

    private static String zzA(Map<String, String> map) {
        com.google.android.gms.common.internal.zzu.zzu(map);
        Uri.Builder builder = new Uri.Builder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            builder.appendQueryParameter(entry.getKey(), entry.getValue());
        }
        String encodedQuery = builder.build().getEncodedQuery();
        return encodedQuery == null ? "" : encodedQuery;
    }

    private long zza(String str, String[] strArr, long j) {
        Cursor cursor = null;
        try {
            try {
                cursor = getWritableDatabase().rawQuery(str, strArr);
                if (cursor.moveToFirst()) {
                    return cursor.getLong(0);
                }
                if (cursor != null) {
                    cursor.close();
                }
                return j;
            } catch (SQLiteException e) {
                zzd("Database error", str, e);
                throw e;
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private long zzb(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            try {
                Cursor rawQuery = getWritableDatabase().rawQuery(str, strArr);
                if (!rawQuery.moveToFirst()) {
                    throw new SQLiteException("Database returned empty set");
                }
                long j = rawQuery.getLong(0);
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return j;
            } catch (SQLiteException e) {
                zzd("Database error", str, e);
                throw e;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    private String zzd(zzab zzabVar) {
        return zzabVar.zzjY() ? zzhR().zzjk() : zzhR().zzjl();
    }

    private static String zze(zzab zzabVar) {
        com.google.android.gms.common.internal.zzu.zzu(zzabVar);
        Uri.Builder builder = new Uri.Builder();
        for (Map.Entry<String, String> entry : zzabVar.zzn().entrySet()) {
            String key = entry.getKey();
            if (!"ht".equals(key) && !"qt".equals(key) && !"AppUID".equals(key)) {
                builder.appendQueryParameter(key, entry.getValue());
            }
        }
        String encodedQuery = builder.build().getEncodedQuery();
        return encodedQuery == null ? "" : encodedQuery;
    }

    private void zziu() {
        int zzju = zzhR().zzju();
        long zzil = zzil();
        if (zzil > zzju - 1) {
            List<Long> zzo = zzo((zzil - zzju) + 1);
            zzd("Store full, deleting hits to make room, count", Integer.valueOf(zzo.size()));
            zzd(zzo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String zziv() {
        if (zzhR().zziW() && !zzhR().zziX()) {
            return zzhR().zzjx();
        }
        return zzhR().zzjw();
    }

    public void beginTransaction() {
        zzia();
        getWritableDatabase().beginTransaction();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        String str;
        try {
            this.zzKi.close();
        } catch (SQLiteException e) {
            e = e;
            str = "Sql error closing database";
            zze(str, e);
        } catch (IllegalStateException e2) {
            e = e2;
            str = "Error closing database";
            zze(str, e);
        }
    }

    public void endTransaction() {
        zzia();
        getWritableDatabase().endTransaction();
    }

    SQLiteDatabase getWritableDatabase() {
        try {
            return this.zzKi.getWritableDatabase();
        } catch (SQLiteException e) {
            zzd("Error opening database", e);
            throw e;
        }
    }

    boolean isEmpty() {
        return zzil() == 0;
    }

    public void setTransactionSuccessful() {
        zzia();
        getWritableDatabase().setTransactionSuccessful();
    }

    public long zza(long j, String str, String str2) {
        com.google.android.gms.common.internal.zzu.zzcj(str);
        com.google.android.gms.common.internal.zzu.zzcj(str2);
        zzia();
        zzhO();
        return zza("SELECT hits_count FROM properties WHERE app_uid=? AND cid=? AND tid=?", new String[]{String.valueOf(j), str, str2}, 0L);
    }

    public void zza(long j, String str) {
        com.google.android.gms.common.internal.zzu.zzcj(str);
        zzia();
        zzhO();
        int delete = getWritableDatabase().delete("properties", "app_uid=? AND cid<>?", new String[]{String.valueOf(j), str});
        if (delete > 0) {
            zza("Deleted property records", Integer.valueOf(delete));
        }
    }

    Map<String, String> zzaY(String str) {
        if (TextUtils.isEmpty(str)) {
            return new HashMap(0);
        }
        try {
            if (!str.startsWith("?")) {
                str = "?" + str;
            }
            List<NameValuePair> parse = URLEncodedUtils.parse(new URI(str), "UTF-8");
            HashMap hashMap = new HashMap(parse.size());
            for (NameValuePair nameValuePair : parse) {
                hashMap.put(nameValuePair.getName(), nameValuePair.getValue());
            }
            return hashMap;
        } catch (URISyntaxException e) {
            zze("Error parsing hit parameters", e);
            return new HashMap(0);
        }
    }

    Map<String, String> zzaZ(String str) {
        if (TextUtils.isEmpty(str)) {
            return new HashMap(0);
        }
        try {
            List<NameValuePair> parse = URLEncodedUtils.parse(new URI("?" + str), "UTF-8");
            HashMap hashMap = new HashMap(parse.size());
            for (NameValuePair nameValuePair : parse) {
                hashMap.put(nameValuePair.getName(), nameValuePair.getValue());
            }
            return hashMap;
        } catch (URISyntaxException e) {
            zze("Error parsing property parameters", e);
            return new HashMap(0);
        }
    }

    public void zzb(zzh zzhVar) {
        com.google.android.gms.common.internal.zzu.zzu(zzhVar);
        zzia();
        zzhO();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        String zzA = zzA(zzhVar.zzn());
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_uid", Long.valueOf(zzhVar.zzii()));
        contentValues.put("cid", zzhVar.getClientId());
        contentValues.put("tid", zzhVar.zzij());
        contentValues.put("adid", Integer.valueOf(zzhVar.zzik() ? 1 : 0));
        contentValues.put("hits_count", Long.valueOf(zzhVar.zzil()));
        contentValues.put("params", zzA);
        try {
            if (writableDatabase.insertWithOnConflict("properties", null, contentValues, 5) == -1) {
                zzaX("Failed to insert/update a property (got -1)");
            }
        } catch (SQLiteException e) {
            zze("Error storing a property", e);
        }
    }

    public void zzc(zzab zzabVar) {
        com.google.android.gms.common.internal.zzu.zzu(zzabVar);
        zzhO();
        zzia();
        String zze = zze(zzabVar);
        if (zze.length() > 8192) {
            zzhQ().zza(zzabVar, "Hit length exceeds the maximum allowed size");
            return;
        }
        zziu();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("hit_string", zze);
        contentValues.put("hit_time", Long.valueOf(zzabVar.zzjW()));
        contentValues.put("hit_app_id", Integer.valueOf(zzabVar.zzjU()));
        contentValues.put("hit_url", zzd(zzabVar));
        try {
            long insert = writableDatabase.insert("hits2", null, contentValues);
            if (insert == -1) {
                zzaX("Failed to insert a hit (got -1)");
            } else {
                zzb("Hit saved to database. db-id, hit", Long.valueOf(insert), zzabVar);
            }
        } catch (SQLiteException e) {
            zze("Error storing a hit", e);
        }
    }

    public void zzd(List<Long> list) {
        com.google.android.gms.common.internal.zzu.zzu(list);
        zzhO();
        zzia();
        if (list.isEmpty()) {
            return;
        }
        StringBuilder sb = new StringBuilder("hit_id");
        sb.append(" in (");
        for (int i = 0; i < list.size(); i++) {
            Long l = list.get(i);
            if (l == null || l.longValue() == 0) {
                throw new SQLiteException("Invalid hit id");
            }
            if (i > 0) {
                sb.append(",");
            }
            sb.append(l);
        }
        sb.append(")");
        String sb2 = sb.toString();
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            zza("Deleting dispatched hits. count", Integer.valueOf(list.size()));
            int delete = writableDatabase.delete("hits2", sb2, null);
            if (delete != list.size()) {
                zzb("Deleted fewer hits then expected", Integer.valueOf(list.size()), Integer.valueOf(delete), sb2);
            }
        } catch (SQLiteException e) {
            zze("Error deleting hits", e);
            throw e;
        }
    }

    @Override // com.google.android.gms.analytics.internal.zzd
    protected void zzhn() {
    }

    public long zzil() {
        zzhO();
        zzia();
        return zzb("SELECT COUNT(*) FROM hits2", (String[]) null);
    }

    public void zziq() {
        zzhO();
        zzia();
        getWritableDatabase().delete("hits2", null, null);
    }

    public void zzir() {
        zzhO();
        zzia();
        getWritableDatabase().delete("properties", null, null);
    }

    public int zzis() {
        zzhO();
        zzia();
        if (!this.zzKj.zzv(86400000L)) {
            return 0;
        }
        this.zzKj.start();
        zzaT("Deleting stale hits (if any)");
        int delete = getWritableDatabase().delete("hits2", "hit_time < ?", new String[]{Long.toString(zzhP().currentTimeMillis() - 2592000000L)});
        zza("Deleted stale hits, count", Integer.valueOf(delete));
        return delete;
    }

    public long zzit() {
        zzhO();
        zzia();
        return zza(zzKh, (String[]) null, 0L);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0056, code lost:
    
        if (r10 != null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0066, code lost:
    
        return r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0063, code lost:
    
        r10.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0061, code lost:
    
        if (r10 == null) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<java.lang.Long> zzo(long r13) {
        /*
            r12 = this;
            java.lang.String r0 = "hit_id"
            r12.zzhO()
            r12.zzia()
            r1 = 0
            int r1 = (r13 > r1 ? 1 : (r13 == r1 ? 0 : -1))
            if (r1 > 0) goto L13
            java.util.List r13 = java.util.Collections.emptyList()
            return r13
        L13:
            android.database.sqlite.SQLiteDatabase r1 = r12.getWritableDatabase()
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            r10 = 0
            java.lang.String r2 = "hits2"
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L59 android.database.sqlite.SQLiteException -> L5b
            r11 = 0
            r3[r11] = r0     // Catch: java.lang.Throwable -> L59 android.database.sqlite.SQLiteException -> L5b
            java.lang.String r4 = "%s ASC"
            java.lang.Object[] r0 = new java.lang.Object[]{r0}     // Catch: java.lang.Throwable -> L59 android.database.sqlite.SQLiteException -> L5b
            java.lang.String r7 = java.lang.String.format(r4, r0)     // Catch: java.lang.Throwable -> L59 android.database.sqlite.SQLiteException -> L5b
            java.lang.String r8 = java.lang.Long.toString(r13)     // Catch: java.lang.Throwable -> L59 android.database.sqlite.SQLiteException -> L5b
            r13 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r0 = r1
            r1 = r2
            r2 = r3
            r3 = r13
            android.database.Cursor r10 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L59 android.database.sqlite.SQLiteException -> L5b
            boolean r13 = r10.moveToFirst()     // Catch: java.lang.Throwable -> L59 android.database.sqlite.SQLiteException -> L5b
            if (r13 == 0) goto L56
        L45:
            long r13 = r10.getLong(r11)     // Catch: java.lang.Throwable -> L59 android.database.sqlite.SQLiteException -> L5b
            java.lang.Long r13 = java.lang.Long.valueOf(r13)     // Catch: java.lang.Throwable -> L59 android.database.sqlite.SQLiteException -> L5b
            r9.add(r13)     // Catch: java.lang.Throwable -> L59 android.database.sqlite.SQLiteException -> L5b
            boolean r13 = r10.moveToNext()     // Catch: java.lang.Throwable -> L59 android.database.sqlite.SQLiteException -> L5b
            if (r13 != 0) goto L45
        L56:
            if (r10 == 0) goto L66
            goto L63
        L59:
            r13 = move-exception
            goto L67
        L5b:
            r13 = move-exception
            java.lang.String r14 = "Error selecting hit ids"
            r12.zzd(r14, r13)     // Catch: java.lang.Throwable -> L59
            if (r10 == 0) goto L66
        L63:
            r10.close()
        L66:
            return r9
        L67:
            if (r10 == 0) goto L6c
            r10.close()
        L6c:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.zzj.zzo(long):java.util.List");
    }

    public List<zzab> zzp(long j) {
        int i = 1;
        com.google.android.gms.common.internal.zzu.zzV(j >= 0);
        zzhO();
        zzia();
        Cursor cursor = null;
        try {
            try {
                int i2 = 2;
                int i3 = 3;
                int i4 = 4;
                Cursor query = getWritableDatabase().query("hits2", new String[]{"hit_id", "hit_time", "hit_string", "hit_url", "hit_app_id"}, null, null, null, null, String.format("%s ASC", "hit_id"), Long.toString(j));
                try {
                    ArrayList arrayList = new ArrayList();
                    if (query.moveToFirst()) {
                        while (true) {
                            int i5 = i3;
                            int i6 = i4;
                            int i7 = i2;
                            arrayList.add(new zzab(this, zzaY(query.getString(i2)), query.getLong(i), zzam.zzbn(query.getString(i3)), query.getLong(0), query.getInt(i4)));
                            if (!query.moveToNext()) {
                                break;
                            }
                            i2 = i7;
                            i4 = i6;
                            i3 = i5;
                            i = 1;
                        }
                    }
                    if (query != null) {
                        query.close();
                    }
                    return arrayList;
                } catch (SQLiteException e) {
                    e = e;
                    cursor = query;
                    zze("Error loading hits from the database", e);
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (SQLiteException e2) {
            e = e2;
        }
    }

    public void zzq(long j) {
        zzhO();
        zzia();
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(Long.valueOf(j));
        zza("Deleting hit, id", Long.valueOf(j));
        zzd(arrayList);
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00c5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<com.google.android.gms.analytics.internal.zzh> zzr(long r26) {
        /*
            r25 = this;
            r1 = r25
            r25.zzia()
            r25.zzhO()
            android.database.sqlite.SQLiteDatabase r2 = r25.getWritableDatabase()
            r0 = 5
            java.lang.String[] r4 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> Lb7 android.database.sqlite.SQLiteException -> Lba
            java.lang.String r0 = "cid"
            r12 = 0
            r4[r12] = r0     // Catch: java.lang.Throwable -> Lb7 android.database.sqlite.SQLiteException -> Lba
            java.lang.String r0 = "tid"
            r13 = 1
            r4[r13] = r0     // Catch: java.lang.Throwable -> Lb7 android.database.sqlite.SQLiteException -> Lba
            java.lang.String r0 = "adid"
            r14 = 2
            r4[r14] = r0     // Catch: java.lang.Throwable -> Lb7 android.database.sqlite.SQLiteException -> Lba
            java.lang.String r0 = "hits_count"
            r15 = 3
            r4[r15] = r0     // Catch: java.lang.Throwable -> Lb7 android.database.sqlite.SQLiteException -> Lba
            java.lang.String r0 = "params"
            r10 = 4
            r4[r10] = r0     // Catch: java.lang.Throwable -> Lb7 android.database.sqlite.SQLiteException -> Lba
            com.google.android.gms.analytics.internal.zzr r0 = r25.zzhR()     // Catch: java.lang.Throwable -> Lb7 android.database.sqlite.SQLiteException -> Lba
            int r0 = r0.zzjv()     // Catch: java.lang.Throwable -> Lb7 android.database.sqlite.SQLiteException -> Lba
            java.lang.String r16 = java.lang.String.valueOf(r0)     // Catch: java.lang.Throwable -> Lb7 android.database.sqlite.SQLiteException -> Lba
            java.lang.String r5 = "app_uid=?"
            java.lang.String[] r6 = new java.lang.String[r13]     // Catch: java.lang.Throwable -> Lb7 android.database.sqlite.SQLiteException -> Lba
            java.lang.String r3 = java.lang.String.valueOf(r26)     // Catch: java.lang.Throwable -> Lb7 android.database.sqlite.SQLiteException -> Lba
            r6[r12] = r3     // Catch: java.lang.Throwable -> Lb7 android.database.sqlite.SQLiteException -> Lba
            java.lang.String r3 = "properties"
            r8 = 0
            r9 = 0
            r7 = 0
            r11 = r10
            r10 = r16
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> Lb7 android.database.sqlite.SQLiteException -> Lba
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: java.lang.Throwable -> Lb1 android.database.sqlite.SQLiteException -> Lb4
            r3.<init>()     // Catch: java.lang.Throwable -> Lb1 android.database.sqlite.SQLiteException -> Lb4
            boolean r4 = r2.moveToFirst()     // Catch: java.lang.Throwable -> Lb1 android.database.sqlite.SQLiteException -> Lb4
            if (r4 == 0) goto La0
        L55:
            java.lang.String r4 = r2.getString(r12)     // Catch: java.lang.Throwable -> Lb1 android.database.sqlite.SQLiteException -> Lb4
            java.lang.String r5 = r2.getString(r13)     // Catch: java.lang.Throwable -> Lb1 android.database.sqlite.SQLiteException -> Lb4
            int r6 = r2.getInt(r14)     // Catch: java.lang.Throwable -> Lb1 android.database.sqlite.SQLiteException -> Lb4
            if (r6 == 0) goto L66
            r21 = r13
            goto L68
        L66:
            r21 = r12
        L68:
            int r6 = r2.getInt(r15)     // Catch: java.lang.Throwable -> Lb1 android.database.sqlite.SQLiteException -> Lb4
            long r6 = (long) r6     // Catch: java.lang.Throwable -> Lb1 android.database.sqlite.SQLiteException -> Lb4
            java.lang.String r8 = r2.getString(r11)     // Catch: java.lang.Throwable -> Lb1 android.database.sqlite.SQLiteException -> Lb4
            java.util.Map r24 = r1.zzaZ(r8)     // Catch: java.lang.Throwable -> Lb1 android.database.sqlite.SQLiteException -> Lb4
            boolean r8 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> Lb1 android.database.sqlite.SQLiteException -> Lb4
            if (r8 != 0) goto L95
            boolean r8 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> Lb1 android.database.sqlite.SQLiteException -> Lb4
            if (r8 == 0) goto L82
            goto L95
        L82:
            com.google.android.gms.analytics.internal.zzh r8 = new com.google.android.gms.analytics.internal.zzh     // Catch: java.lang.Throwable -> Lb1 android.database.sqlite.SQLiteException -> Lb4
            r16 = r8
            r17 = r26
            r19 = r4
            r20 = r5
            r22 = r6
            r16.<init>(r17, r19, r20, r21, r22, r24)     // Catch: java.lang.Throwable -> Lb1 android.database.sqlite.SQLiteException -> Lb4
            r3.add(r8)     // Catch: java.lang.Throwable -> Lb1 android.database.sqlite.SQLiteException -> Lb4
            goto L9a
        L95:
            java.lang.String r6 = "Read property with empty client id or tracker id"
            r1.zzc(r6, r4, r5)     // Catch: java.lang.Throwable -> Lb1 android.database.sqlite.SQLiteException -> Lb4
        L9a:
            boolean r4 = r2.moveToNext()     // Catch: java.lang.Throwable -> Lb1 android.database.sqlite.SQLiteException -> Lb4
            if (r4 != 0) goto L55
        La0:
            int r4 = r3.size()     // Catch: java.lang.Throwable -> Lb1 android.database.sqlite.SQLiteException -> Lb4
            if (r4 < r0) goto Lab
            java.lang.String r0 = "Sending hits to too many properties. Campaign report might be incorrect"
            r1.zzaW(r0)     // Catch: java.lang.Throwable -> Lb1 android.database.sqlite.SQLiteException -> Lb4
        Lab:
            if (r2 == 0) goto Lb0
            r2.close()
        Lb0:
            return r3
        Lb1:
            r0 = move-exception
            r11 = r2
            goto Lc3
        Lb4:
            r0 = move-exception
            r11 = r2
            goto Lbc
        Lb7:
            r0 = move-exception
            r11 = 0
            goto Lc3
        Lba:
            r0 = move-exception
            r11 = 0
        Lbc:
            java.lang.String r2 = "Error loading hits from the database"
            r1.zze(r2, r0)     // Catch: java.lang.Throwable -> Lc2
            throw r0     // Catch: java.lang.Throwable -> Lc2
        Lc2:
            r0 = move-exception
        Lc3:
            if (r11 == 0) goto Lc8
            r11.close()
        Lc8:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.zzj.zzr(long):java.util.List");
    }
}
