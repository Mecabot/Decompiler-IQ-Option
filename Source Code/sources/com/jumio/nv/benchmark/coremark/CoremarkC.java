package com.jumio.nv.benchmark.coremark;

import com.jumio.nv.benchmark.BenchmarkAlgorithm;
import com.jumio.nv.benchmark.BenchmarkAlgorithm.DeviceCategory;

public class CoremarkC extends BenchmarkAlgorithm {
    public static String a() {
        return "CoreMark";
    }

    public static native double runCoremark();

    public String getUnitName() {
        return "Instr./Sec";
    }

    protected double run() {
        return runCoremark();
    }

    public String getName() {
        return a();
    }

    public DeviceCategory getDeviceCategory() {
        if (getResult() == null) {
            execute();
        }
        if (getResult().doubleValue() > 3000.0d) {
            return DeviceCategory.FAST;
        }
        if (getResult().doubleValue() < 2000.0d) {
            return DeviceCategory.SLOW;
        }
        return DeviceCategory.MEDIUM;
    }
}
