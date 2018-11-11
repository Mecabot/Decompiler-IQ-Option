package com.google.android.gms.internal;

import com.iqoption.dto.ChartTimeInterval;

public final class zzast {
    private static zzasu<Boolean> zzebl = zzasu.zza("analytics.service_enabled", false, false);
    public static zzasu<Boolean> zzebm = zzasu.zza("analytics.service_client_enabled", true, true);
    public static zzasu<String> zzebn = zzasu.zzd("analytics.log_tag", "GAv4", "GAv4-SVC");
    private static zzasu<Long> zzebo = zzasu.zza("analytics.max_tokens", 60, 60);
    private static zzasu<Float> zzebp = zzasu.zza("analytics.tokens_per_sec", 0.5f, 0.5f);
    public static zzasu<Integer> zzebq = zzasu.zza("analytics.max_stored_hits", 2000, 20000);
    private static zzasu<Integer> zzebr = zzasu.zza("analytics.max_stored_hits_per_app", 2000, 2000);
    public static zzasu<Integer> zzebs = zzasu.zza("analytics.max_stored_properties_per_app", 100, 100);
    public static zzasu<Long> zzebt = zzasu.zza("analytics.local_dispatch_millis", 1800000, 120000);
    public static zzasu<Long> zzebu = zzasu.zza("analytics.initial_local_dispatch_millis", 5000, 5000);
    private static zzasu<Long> zzebv = zzasu.zza("analytics.min_local_dispatch_millis", 120000, 120000);
    private static zzasu<Long> zzebw = zzasu.zza("analytics.max_local_dispatch_millis", 7200000, 7200000);
    public static zzasu<Long> zzebx = zzasu.zza("analytics.dispatch_alarm_millis", 7200000, 7200000);
    public static zzasu<Long> zzeby = zzasu.zza("analytics.max_dispatch_alarm_millis", 32400000, 32400000);
    public static zzasu<Integer> zzebz = zzasu.zza("analytics.max_hits_per_dispatch", 20, 20);
    public static zzasu<Integer> zzeca = zzasu.zza("analytics.max_hits_per_batch", 20, 20);
    public static zzasu<String> zzecb;
    public static zzasu<String> zzecc;
    public static zzasu<String> zzecd;
    public static zzasu<String> zzece;
    public static zzasu<Integer> zzecf = zzasu.zza("analytics.max_get_length", 2036, 2036);
    public static zzasu<String> zzecg = zzasu.zzd("analytics.batching_strategy.k", zzasb.BATCH_BY_COUNT.name(), zzasb.BATCH_BY_COUNT.name());
    public static zzasu<String> zzech;
    private static zzasu<Integer> zzeci = zzasu.zza("analytics.max_hits_per_request.k", 20, 20);
    public static zzasu<Integer> zzecj = zzasu.zza("analytics.max_hit_length.k", 8192, 8192);
    public static zzasu<Integer> zzeck = zzasu.zza("analytics.max_post_length.k", 8192, 8192);
    public static zzasu<Integer> zzecl = zzasu.zza("analytics.max_batch_post_length", 8192, 8192);
    public static zzasu<String> zzecm;
    public static zzasu<Integer> zzecn = zzasu.zza("analytics.batch_retry_interval.seconds.k", (int) ChartTimeInterval.CANDLE_1H, (int) ChartTimeInterval.CANDLE_1H);
    private static zzasu<Long> zzeco = zzasu.zza("analytics.service_monitor_interval", 86400000, 86400000);
    public static zzasu<Integer> zzecp = zzasu.zza("analytics.http_connection.connect_timeout_millis", 60000, 60000);
    public static zzasu<Integer> zzecq = zzasu.zza("analytics.http_connection.read_timeout_millis", 61000, 61000);
    public static zzasu<Long> zzecr = zzasu.zza("analytics.campaigns.time_limit", 86400000, 86400000);
    private static zzasu<String> zzecs;
    private static zzasu<Integer> zzect = zzasu.zza("analytics.first_party_experiment_variant", 0, 0);
    public static zzasu<Boolean> zzecu = zzasu.zza("analytics.test.disable_receiver", false, false);
    public static zzasu<Long> zzecv = zzasu.zza("analytics.service_client.idle_disconnect_millis", 10000, 10000);
    public static zzasu<Long> zzecw = zzasu.zza("analytics.service_client.connect_timeout_millis", 5000, 5000);
    private static zzasu<Long> zzecx = zzasu.zza("analytics.service_client.second_connect_delay_millis", 5000, 5000);
    private static zzasu<Long> zzecy = zzasu.zza("analytics.service_client.unexpected_reconnect_millis", 60000, 60000);
    public static zzasu<Long> zzecz = zzasu.zza("analytics.service_client.reconnect_throttle_millis", 1800000, 1800000);
    public static zzasu<Long> zzeda = zzasu.zza("analytics.monitoring.sample_period_millis", 86400000, 86400000);
    public static zzasu<Long> zzedb = zzasu.zza("analytics.initialization_warning_threshold", 5000, 5000);

    static {
        String str = "http://www.google-analytics.com";
        zzecb = zzasu.zzd("analytics.insecure_host", str, str);
        str = "https://ssl.google-analytics.com";
        zzecc = zzasu.zzd("analytics.secure_host", str, str);
        str = "/collect";
        zzecd = zzasu.zzd("analytics.simple_endpoint", str, str);
        str = "/batch";
        zzece = zzasu.zzd("analytics.batching_endpoint", str, str);
        str = zzash.GZIP.name();
        zzech = zzasu.zzd("analytics.compression_strategy.k", str, str);
        String str2 = "404,502";
        zzecm = zzasu.zzd("analytics.fallback_responses.k", str2, str2);
        String str3 = "";
        zzecs = zzasu.zzd("analytics.first_party_experiment_id", str3, str3);
    }
}
