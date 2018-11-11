package org.slf4j.helpers;

/* compiled from: SubstituteLogger */
public class b implements org.slf4j.b {
    private volatile org.slf4j.b fds;
    private final String name;

    public b(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }

    public boolean isDebugEnabled() {
        return bCf().isDebugEnabled();
    }

    public void debug(String str) {
        bCf().debug(str);
    }

    public void error(String str) {
        bCf().error(str);
    }

    public void error(String str, Throwable th) {
        bCf().error(str, th);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.name.equals(((b) obj).name);
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    org.slf4j.b bCf() {
        return this.fds != null ? this.fds : NOPLogger.fdr;
    }

    public void a(org.slf4j.b bVar) {
        this.fds = bVar;
    }
}
