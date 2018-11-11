package com.iqoption.dto;

import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.gson.JsonElement;
import com.iqoption.system.d.a;
import io.card.payment.BuildConfig;

public class Event {
    public static final String API_CALL_EVENT = "api-call";
    public static final String CATEGORY_BUTTON_PRESSED = "button_pressed";
    public static final String CATEGORY_BUTTON_STATE = "button_state";
    public static final String CATEGORY_CONTROLL_CHANGED = "controll_changed";
    public static final String CATEGORY_CONTROLL_SWITCHED = "controll_switched";
    public static final String CATEGORY_DRAG = "drag";
    public static final String CATEGORY_DROPDOWN_CHANGED = "dropdown_changed";
    public static final String CATEGORY_FOCUS_ON = "focus_on";
    public static final String CATEGORY_INDICATOR_ADDED = "indicator_added";
    public static final String CATEGORY_INDICATOR_DELETED = "indicator_deleted";
    public static final String CATEGORY_POPUP_SERVED = "popup_served";
    public static final String CATEGORY_SCREEN_OPENED = "screen_opened";
    public static final String CATEGORY_SCROLL = "scroll";
    public static final String CATEGORY_SWIPE = "swipe";
    public static final String CATEGORY_SYSTEM = "system";
    public static final String CATEGORY_TEXT_CHANGED = "text_changed";
    public static final String LAUNCH_STAT_EVENT = "launch-stat";
    public static final String MICROSERVICE_EVENT = "microservice";
    public static final String MQL = "became_MQL";
    public String app_version = BuildConfig.PRODUCT_VERSION;
    public String category;
    public String device_id;
    public Long duration;
    public transient Long elapsedTime;
    public Long id;
    public String name;
    public JsonElement parameters;
    public Integer platform_id = Integer.valueOf(17);
    public Boolean technical_logs = Boolean.valueOf(false);
    public Long time;
    public Long user_id;
    public Double value = Double.valueOf(Double.MIN_VALUE);

    public class Builder {
        public Builder incValue() {
            if (Event.this.value.doubleValue() == Double.MIN_VALUE) {
                Event.this.value = Double.valueOf(0.0d);
            }
            Event event = Event.this;
            Double d = event.value;
            event.value = Double.valueOf(event.value.doubleValue() + 1.0d);
            return this;
        }

        public Builder setValue(Double d) {
            Event.this.value = d;
            return this;
        }

        public Builder setTechnicalLogs(Boolean bool) {
            Event.this.technical_logs = bool;
            return this;
        }

        public Builder calcDuration() {
            Event.this.duration = Long.valueOf(currentDuration());
            return this;
        }

        public long currentDuration() {
            return SystemClock.elapsedRealtime() - Event.this.elapsedTime.longValue();
        }

        public Builder setDuration(long j) {
            Event.this.duration = Long.valueOf(j);
            return this;
        }

        public Builder setParameters(JsonElement jsonElement) {
            Event.this.parameters = jsonElement;
            return this;
        }

        public Event build() {
            return Event.this;
        }
    }

    public static class ApiCallEventBusEvent {
        public final Event apiCallEvent;
        public final String apiName;
        public boolean isRemoved;
        public final Throwable t;

        public ApiCallEventBusEvent(@NonNull String str, @NonNull Event event, @Nullable Throwable th) {
            this.apiName = str;
            this.apiCallEvent = event;
            this.t = th;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.apiCallEvent.toString());
            stringBuilder.append(this.t == null ? "" : " ERROR!");
            return stringBuilder.toString();
        }
    }

    public Event(Long l, String str, String str2) {
        this.id = l;
        this.category = str;
        this.name = str2;
        this.elapsedTime = Long.valueOf(SystemClock.elapsedRealtime());
        this.time = Long.valueOf(a.ca(SystemClock.elapsedRealtime()));
    }

    public Event(String str, String str2) {
        this.category = str;
        this.name = str2;
        this.elapsedTime = Long.valueOf(SystemClock.elapsedRealtime());
        this.time = Long.valueOf(a.ca(SystemClock.elapsedRealtime()));
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Event{device_id='");
        stringBuilder.append(this.device_id);
        stringBuilder.append('\'');
        stringBuilder.append(", user_id=");
        stringBuilder.append(this.user_id);
        stringBuilder.append(", category='");
        stringBuilder.append(this.category);
        stringBuilder.append('\'');
        stringBuilder.append(", name='");
        stringBuilder.append(this.name);
        stringBuilder.append('\'');
        stringBuilder.append(", value=");
        stringBuilder.append(this.value);
        stringBuilder.append(", time=");
        stringBuilder.append(this.time);
        stringBuilder.append(", elapsedTime=");
        stringBuilder.append(this.elapsedTime);
        stringBuilder.append(", duration=");
        stringBuilder.append(this.duration);
        stringBuilder.append(", technical_logs=");
        stringBuilder.append(this.technical_logs);
        stringBuilder.append(", parameters='");
        stringBuilder.append(this.parameters);
        stringBuilder.append('\'');
        stringBuilder.append(", platform_id=");
        stringBuilder.append(this.platform_id);
        stringBuilder.append(", app_version='");
        stringBuilder.append(this.app_version);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public static Builder Builder(String str, String str2) {
        Event event = new Event(str, str2);
        event.getClass();
        return new Builder();
    }

    public static Builder ApiCallBuilder(final String str) {
        Event anonymousClass1 = new Event(CATEGORY_SYSTEM, API_CALL_EVENT) {
            public String toString() {
                StringBuilder stringBuilder;
                String str;
                if (this.duration != null) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(this.duration);
                    str = " ";
                } else {
                    stringBuilder = new StringBuilder();
                    str = "... ";
                }
                stringBuilder.append(str);
                stringBuilder.append(str);
                return stringBuilder.toString();
            }
        };
        anonymousClass1.getClass();
        return new Builder().setTechnicalLogs(Boolean.valueOf(true));
    }
}
