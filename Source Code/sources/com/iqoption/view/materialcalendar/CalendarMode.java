package com.iqoption.view.materialcalendar;

public enum CalendarMode {
    MONTHS(6),
    WEEKS(1);
    
    final int visibleWeeksCount;

    private CalendarMode(int i) {
        this.visibleWeeksCount = i;
    }
}
