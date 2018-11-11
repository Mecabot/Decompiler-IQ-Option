package com.jumio.nv.benchmark;

import com.jumio.commons.PersistWith;
import java.io.Serializable;

public abstract class BenchmarkAlgorithm implements Serializable {
    private Double mResult;

    @PersistWith("DeviceCategory")
    public enum DeviceCategory {
        SLOW,
        MEDIUM,
        FAST
    }

    public abstract DeviceCategory getDeviceCategory();

    public abstract String getName();

    public abstract String getUnitName();

    public abstract double run();

    public double execute() {
        this.mResult = Double.valueOf(run());
        return this.mResult.doubleValue();
    }

    public Double getResult() {
        return this.mResult;
    }
}
