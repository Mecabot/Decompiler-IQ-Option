package com.jumio.nv.benchmark;

import android.content.Context;
import android.support.annotation.NonNull;
import com.jumio.commons.log.Log;
import com.jumio.nv.benchmark.BenchmarkAlgorithm.DeviceCategory;
import com.jumio.nv.benchmark.coremark.CoremarkC;
import com.jumio.nv.environment.NVEnvironment;
import com.jumio.persistence.DataAccess;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class Benchmark {
    private static final long MAX_WAIT_TIMEOUT = 2000;
    public static final String SERVICE = "BenchmarkService";
    private static final AtomicBoolean isMeasuring = new AtomicBoolean(false);
    private static ReentrantLock semaphor = new ReentrantLock();
    private DeviceCategory mCategory;
    @NonNull
    private Context mContext;

    public Benchmark(@NonNull Context context) {
        this.mContext = context;
        NVEnvironment.loadBenchmarkLib();
    }

    private void executeBenchmark() {
        String str = SERVICE;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("currently measuring: ");
        stringBuilder.append(isMeasuring.get());
        Log.v(str, stringBuilder.toString());
        if (isMeasuring.compareAndSet(false, true) && this.mCategory == null) {
            new Thread(new Runnable() {
                public void run() {
                    Log.v(Benchmark.SERVICE, "running benchmark, waiting for monitor...");
                    try {
                        Benchmark.semaphor.lock();
                        BenchmarkAlgorithm coremarkC = new CoremarkC();
                        String str = Benchmark.SERVICE;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("  monitor acquired starting benchmark ");
                        stringBuilder.append(coremarkC.getName());
                        Log.i(str, stringBuilder.toString());
                        long currentTimeMillis = System.currentTimeMillis();
                        coremarkC.execute();
                        Log.d(Benchmark.SERVICE, "  benchmark finished");
                        Benchmark.this.mCategory = coremarkC.getDeviceCategory();
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        Benchmark.this.storeSharedPref(Benchmark.this.mCategory);
                        Log.i(Benchmark.SERVICE, String.format("  Classified device as %s at %.2f %s (%s)", new Object[]{coremarkC.getDeviceCategory().toString(), coremarkC.getResult(), coremarkC.getUnitName(), coremarkC.getName()}));
                        String str2 = Benchmark.SERVICE;
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("releasing monitor (took ");
                        stringBuilder2.append(currentTimeMillis2);
                        stringBuilder2.append(" ms)");
                        Log.v(str2, stringBuilder2.toString());
                        Benchmark.isMeasuring.set(false);
                    } finally {
                        Benchmark.semaphor.unlock();
                    }
                }
            }, "BenchmarkThread").start();
        }
    }

    private void storeSharedPref(DeviceCategory deviceCategory) {
        DataAccess.update(this.mContext, DeviceCategory.class, (Serializable) deviceCategory);
    }

    private DeviceCategory loadDeviceCategory() {
        DeviceCategory deviceCategory = (DeviceCategory) DataAccess.load(this.mContext, DeviceCategory.class);
        if (deviceCategory == null) {
            Log.i(SERVICE, "No device category stored!");
        } else {
            String str = SERVICE;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Loading previously stored value ");
            stringBuilder.append(deviceCategory.toString());
            Log.i(str, stringBuilder.toString());
        }
        return deviceCategory;
    }

    public void reset() {
        DataAccess.delete(this.mContext, DeviceCategory.class);
    }

    public DeviceCategory getDeviceCategory() {
        this.mCategory = loadDeviceCategory();
        if (this.mCategory == null) {
            if (!isMeasuring.get()) {
                executeBenchmark();
            }
            Log.v(SERVICE, " waiting for category...");
            try {
                if (semaphor.tryLock(MAX_WAIT_TIMEOUT, TimeUnit.MILLISECONDS)) {
                    semaphor.unlock();
                } else {
                    String str = SERVICE;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(hashCode());
                    stringBuilder.append(" timeout expired - assuming FAST");
                    Log.d(str, stringBuilder.toString());
                    return DeviceCategory.FAST;
                }
            } catch (Throwable e) {
                Log.printStackTrace(e);
            }
        }
        Log.v(SERVICE, " dev category available!");
        return this.mCategory;
    }

    public void startMeasurement() {
        if (this.mCategory == null && loadDeviceCategory() == null) {
            executeBenchmark();
        }
    }
}
