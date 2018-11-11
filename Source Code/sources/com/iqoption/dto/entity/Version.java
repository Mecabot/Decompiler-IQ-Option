package com.iqoption.dto.entity;

import com.google.gson.annotations.SerializedName;

public class Version {
    @SerializedName("android")
    private Android android;
    @SerializedName("androidx")
    private Androidx androidx;

    public class Android {
        @SerializedName("current")
        private Integer current;
        @SerializedName("min")
        private Integer min;
        @SerializedName("update_link")
        private String path;

        public Integer getCurrent() {
            return Integer.valueOf(this.current == null ? -1 : this.current.intValue());
        }

        public void setCurrent(Integer num) {
            this.current = num;
        }

        public Integer getMin() {
            return Integer.valueOf(this.min == null ? -1 : this.min.intValue());
        }

        public void setMin(Integer num) {
            this.min = num;
        }

        public String getPath() {
            return this.path;
        }

        public void setPath(String str) {
            this.path = str;
        }
    }

    public class Androidx extends Android {
        public Androidx() {
            super();
        }
    }

    public Android getAndroid() {
        return this.androidx;
    }
}
