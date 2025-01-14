package com.google.android.gms.analytics.internal;

import com.google.android.gms.internal.zzkf;

/* loaded from: classes.dex */
public final class zzy {
    public static zza<Boolean> zzKZ = zza.zzd("analytics.service_enabled", false);
    public static zza<Boolean> zzLa = zza.zzd("analytics.service_client_enabled", true);
    public static zza<String> zzLb = zza.zzd("analytics.log_tag", "GAv4", "GAv4-SVC");
    public static zza<Long> zzLc = zza.zzc("analytics.max_tokens", 60);
    public static zza<Float> zzLd = zza.zza("analytics.tokens_per_sec", 0.5f);
    public static zza<Integer> zzLe = zza.zza("analytics.max_stored_hits", 2000, 20000);
    public static zza<Integer> zzLf = zza.zze("analytics.max_stored_hits_per_app", 2000);
    public static zza<Integer> zzLg = zza.zze("analytics.max_stored_properties_per_app", 100);
    public static zza<Long> zzLh = zza.zza("analytics.local_dispatch_millis", 1800000L, 120000L);
    public static zza<Long> zzLi = zza.zza("analytics.initial_local_dispatch_millis", 5000L, 5000L);
    public static zza<Long> zzLj = zza.zzc("analytics.min_local_dispatch_millis", 120000);
    public static zza<Long> zzLk = zza.zzc("analytics.max_local_dispatch_millis", 7200000);
    public static zza<Long> zzLl = zza.zzc("analytics.dispatch_alarm_millis", 7200000);
    public static zza<Long> zzLm = zza.zzc("analytics.max_dispatch_alarm_millis", 32400000);
    public static zza<Integer> zzLn = zza.zze("analytics.max_hits_per_dispatch", 20);
    public static zza<Integer> zzLo = zza.zze("analytics.max_hits_per_batch", 20);
    public static zza<String> zzLp = zza.zzm("analytics.insecure_host", "http://www.google-analytics.com");
    public static zza<String> zzLq = zza.zzm("analytics.secure_host", "https://ssl.google-analytics.com");
    public static zza<String> zzLr = zza.zzm("analytics.simple_endpoint", "/collect");
    public static zza<String> zzLs = zza.zzm("analytics.batching_endpoint", "/batch");
    public static zza<Integer> zzLt = zza.zze("analytics.max_get_length", 2036);
    public static zza<String> zzLu = zza.zzd("analytics.batching_strategy.k", zzm.BATCH_BY_COUNT.name(), zzm.BATCH_BY_COUNT.name());
    public static zza<String> zzLv = zza.zzm("analytics.compression_strategy.k", zzo.GZIP.name());
    public static zza<Integer> zzLw = zza.zze("analytics.max_hits_per_request.k", 20);
    public static zza<Integer> zzLx = zza.zze("analytics.max_hit_length.k", 8192);
    public static zza<Integer> zzLy = zza.zze("analytics.max_post_length.k", 8192);
    public static zza<Integer> zzLz = zza.zze("analytics.max_batch_post_length", 8192);
    public static zza<String> zzLA = zza.zzm("analytics.fallback_responses.k", "404,502");
    public static zza<Integer> zzLB = zza.zze("analytics.batch_retry_interval.seconds.k", 3600);
    public static zza<Long> zzLC = zza.zzc("analytics.service_monitor_interval", 86400000);
    public static zza<Integer> zzLD = zza.zze("analytics.http_connection.connect_timeout_millis", 60000);
    public static zza<Integer> zzLE = zza.zze("analytics.http_connection.read_timeout_millis", 61000);
    public static zza<Long> zzLF = zza.zzc("analytics.campaigns.time_limit", 86400000);
    public static zza<String> zzLG = zza.zzm("analytics.first_party_experiment_id", "");
    public static zza<Integer> zzLH = zza.zze("analytics.first_party_experiment_variant", 0);
    public static zza<Boolean> zzLI = zza.zzd("analytics.test.disable_receiver", false);
    public static zza<Long> zzLJ = zza.zza("analytics.service_client.idle_disconnect_millis", 10000L, 10000L);
    public static zza<Long> zzLK = zza.zzc("analytics.service_client.connect_timeout_millis", 5000);
    public static zza<Long> zzLL = zza.zzc("analytics.service_client.second_connect_delay_millis", 5000);
    public static zza<Long> zzLM = zza.zzc("analytics.service_client.unexpected_reconnect_millis", 60000);
    public static zza<Long> zzLN = zza.zzc("analytics.service_client.reconnect_throttle_millis", 1800000);
    public static zza<Long> zzLO = zza.zzc("analytics.monitoring.sample_period_millis", 86400000);
    public static zza<Long> zzLP = zza.zzc("analytics.initialization_warning_threshold", 5000);

    public static final class zza<V> {
        private final V zzLQ;
        private final zzkf<V> zzLR;
        private V zzLS;

        private zza(zzkf<V> zzkfVar, V v) {
            com.google.android.gms.common.internal.zzu.zzu(zzkfVar);
            this.zzLR = zzkfVar;
            this.zzLQ = v;
        }

        static zza<Float> zza(String str, float f) {
            return zza(str, f, f);
        }

        static zza<Float> zza(String str, float f, float f2) {
            return new zza<>(zzkf.zza(str, Float.valueOf(f2)), Float.valueOf(f));
        }

        static zza<Integer> zza(String str, int i, int i2) {
            return new zza<>(zzkf.zza(str, Integer.valueOf(i2)), Integer.valueOf(i));
        }

        static zza<Long> zza(String str, long j, long j2) {
            return new zza<>(zzkf.zza(str, Long.valueOf(j2)), Long.valueOf(j));
        }

        static zza<Boolean> zza(String str, boolean z, boolean z2) {
            return new zza<>(zzkf.zzg(str, z2), Boolean.valueOf(z));
        }

        static zza<Long> zzc(String str, long j) {
            return zza(str, j, j);
        }

        static zza<String> zzd(String str, String str2, String str3) {
            return new zza<>(zzkf.zzs(str, str3), str2);
        }

        static zza<Boolean> zzd(String str, boolean z) {
            return zza(str, z, z);
        }

        static zza<Integer> zze(String str, int i) {
            return zza(str, i, i);
        }

        static zza<String> zzm(String str, String str2) {
            return zzd(str, str2, str2);
        }

        public V get() {
            return this.zzLS != null ? this.zzLS : (com.google.android.gms.common.internal.zzd.zzZR && zzkf.isInitialized()) ? this.zzLR.zzmZ() : this.zzLQ;
        }
    }
}
