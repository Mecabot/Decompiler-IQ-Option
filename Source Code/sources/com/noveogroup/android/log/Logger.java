package com.noveogroup.android.log;

public interface Logger {

    public enum Level {
        VERBOSE(2),
        DEBUG(3),
        INFO(4),
        WARN(5),
        ERROR(6),
        ASSERT(7);
        
        private final int intValue;

        private Level(int i) {
            this.intValue = i;
        }

        public int intValue() {
            return this.intValue;
        }

        public boolean includes(Level level) {
            return level != null && intValue() <= level.intValue();
        }
    }

    void a(Level level, String str, Throwable th);

    void a(Level level, Throwable th, String str, Object... objArr);

    void a(Throwable th, String str, Object... objArr);

    boolean a(Level level);

    void f(String str, Object... objArr);

    void g(String str, Object... objArr);

    String getName();
}
