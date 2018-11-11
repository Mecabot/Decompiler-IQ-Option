package com.noveogroup.android.log;

import com.noveogroup.android.log.Logger.Level;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: Pattern */
public abstract class d {
    private final int count;
    private final int length;

    /* compiled from: Pattern */
    public static class b {
        private String ebG;
        private List<c> ebH;
        private final Pattern ebI = Pattern.compile("%%");
        private final Pattern ebJ = Pattern.compile("%n");
        private final Pattern ebK = Pattern.compile("%([+-]?\\d+)?(\\.([+-]?\\d+))?level");
        private final Pattern ebL = Pattern.compile("%([+-]?\\d+)?(\\.([+-]?\\d+))?logger(\\{([+-]?\\d+)?(\\.([+-]?\\d+))?\\})?");
        private final Pattern ebM = Pattern.compile("%([+-]?\\d+)?(\\.([+-]?\\d+))?caller(\\{([+-]?\\d+)?(\\.([+-]?\\d+))?\\})?");
        private final Pattern ebN = Pattern.compile("%([+-]?\\d+)?(\\.([+-]?\\d+))?source");
        private final Pattern ebO = Pattern.compile("%date(\\{(.*?)\\})?");
        private final Pattern ebP = Pattern.compile("%([+-]?\\d+)?(\\.([+-]?\\d+))?\\(");
        private final Pattern ebQ = Pattern.compile("%d(\\{(.*?)\\})?");
        private final Pattern ebR = Pattern.compile("%([+-]?\\d+)?(\\.([+-]?\\d+))?p");
        private final Pattern ebS = Pattern.compile("%([+-]?\\d+)?(\\.([+-]?\\d+))?c(\\{([+-]?\\d+)?(\\.([+-]?\\d+))?\\})?");
        private final Pattern ebT = Pattern.compile("%([+-]?\\d+)?(\\.([+-]?\\d+))?C(\\{([+-]?\\d+)?(\\.([+-]?\\d+))?\\})?");
        private final Pattern ebU = Pattern.compile("%([+-]?\\d+)?(\\.([+-]?\\d+))?s");
        private final Pattern ebV = Pattern.compile("%([+-]?\\d+)?(\\.([+-]?\\d+))?thread");
        private final Pattern ebW = Pattern.compile("%([+-]?\\d+)?(\\.([+-]?\\d+))?t");
        private int position;

        public d lc(String str) {
            if (str == null) {
                return null;
            }
            this.position = 0;
            this.ebG = str;
            this.ebH = new ArrayList();
            this.ebH.add(new c(0, 0, new ArrayList()));
            while (str.length() > this.position) {
                int indexOf = str.indexOf("%", this.position);
                int indexOf2 = str.indexOf(")", this.position);
                if (this.ebH.size() > 1 && indexOf2 < indexOf) {
                    ((c) this.ebH.get(this.ebH.size() - 1)).a(new g(0, 0, str.substring(this.position, indexOf2)));
                    ((c) this.ebH.get(this.ebH.size() - 2)).a((d) this.ebH.remove(this.ebH.size() - 1));
                    this.position = indexOf2 + 1;
                }
                if (indexOf == -1) {
                    ((c) this.ebH.get(this.ebH.size() - 1)).a(new g(0, 0, str.substring(this.position)));
                    break;
                }
                ((c) this.ebH.get(this.ebH.size() - 1)).a(new g(0, 0, str.substring(this.position, indexOf)));
                this.position = indexOf;
                parse();
            }
            return (d) this.ebH.get(0);
        }

        private void parse() {
            Matcher a = a(this.ebI);
            if (a != null) {
                ((c) this.ebH.get(this.ebH.size() - 1)).a(new g(0, 0, "%"));
                this.position = a.end();
                return;
            }
            a = a(this.ebJ);
            if (a != null) {
                ((c) this.ebH.get(this.ebH.size() - 1)).a(new g(0, 0, "\n"));
                this.position = a.end();
                return;
            }
            a = a(this.ebK);
            if (a == null) {
                a = a(this.ebR);
                if (a == null) {
                    a = a(this.ebM);
                    if (a == null) {
                        a = a(this.ebT);
                        if (a == null) {
                            a = a(this.ebN);
                            if (a == null) {
                                a = a(this.ebU);
                                if (a == null) {
                                    a = a(this.ebL);
                                    if (a == null) {
                                        a = a(this.ebS);
                                        if (a == null) {
                                            a = a(this.ebO);
                                            if (a == null) {
                                                a = a(this.ebQ);
                                                if (a == null) {
                                                    a = a(this.ebV);
                                                    if (a == null) {
                                                        a = a(this.ebW);
                                                        if (a == null) {
                                                            a = a(this.ebP);
                                                            if (a != null) {
                                                                this.ebH.add(new c(Integer.parseInt(a.group(1) == null ? "0" : a.group(1)), Integer.parseInt(a.group(3) == null ? "0" : a.group(3)), new ArrayList()));
                                                                this.position = a.end();
                                                                return;
                                                            }
                                                            throw new IllegalArgumentException();
                                                        }
                                                    }
                                                    ((c) this.ebH.get(this.ebH.size() - 1)).a(new i(Integer.parseInt(a.group(1) == null ? "0" : a.group(1)), Integer.parseInt(a.group(3) == null ? "0" : a.group(3))));
                                                    this.position = a.end();
                                                    return;
                                                }
                                            }
                                            ((c) this.ebH.get(this.ebH.size() - 1)).a(new d(0, 0, a.group(2)));
                                            this.position = a.end();
                                            return;
                                        }
                                    }
                                    ((c) this.ebH.get(this.ebH.size() - 1)).a(new f(Integer.parseInt(a.group(1) == null ? "0" : a.group(1)), Integer.parseInt(a.group(3) == null ? "0" : a.group(3)), Integer.parseInt(a.group(5) == null ? "0" : a.group(5)), Integer.parseInt(a.group(7) == null ? "0" : a.group(7))));
                                    this.position = a.end();
                                    return;
                                }
                            }
                            ((c) this.ebH.get(this.ebH.size() - 1)).a(new h(Integer.parseInt(a.group(1) == null ? "0" : a.group(1)), Integer.parseInt(a.group(3) == null ? "0" : a.group(3))));
                            this.position = a.end();
                            return;
                        }
                    }
                    ((c) this.ebH.get(this.ebH.size() - 1)).a(new a(Integer.parseInt(a.group(1) == null ? "0" : a.group(1)), Integer.parseInt(a.group(3) == null ? "0" : a.group(3)), Integer.parseInt(a.group(5) == null ? "0" : a.group(5)), Integer.parseInt(a.group(7) == null ? "0" : a.group(7))));
                    this.position = a.end();
                    return;
                }
            }
            ((c) this.ebH.get(this.ebH.size() - 1)).a(new e(Integer.parseInt(a.group(1) == null ? "0" : a.group(1)), Integer.parseInt(a.group(3) == null ? "0" : a.group(3))));
            this.position = a.end();
        }

        private Matcher a(Pattern pattern) {
            Matcher matcher = pattern.matcher(this.ebG);
            return (matcher.find(this.position) && matcher.start() == this.position) ? matcher : null;
        }
    }

    /* compiled from: Pattern */
    public static class a extends d {
        private int ebE;
        private int ebF;

        protected boolean isCallerNeeded() {
            return true;
        }

        public a(int i, int i2, int i3, int i4) {
            super(i, i2);
            this.ebE = i3;
            this.ebF = i4;
        }

        protected String b(StackTraceElement stackTraceElement, String str, Level level) {
            if (stackTraceElement == null) {
                throw new IllegalArgumentException("Caller not found");
            }
            String format;
            if (stackTraceElement.getLineNumber() < 0) {
                format = String.format("%s#%s", new Object[]{stackTraceElement.getClassName(), stackTraceElement.getMethodName()});
            } else {
                format = String.format("%s#%s:%d", new Object[]{stackTraceElement.getClassName(), stackTraceElement.getMethodName(), Integer.valueOf(stackTraceElement.getLineNumber())});
            }
            return g.e(format, this.ebE, this.ebF);
        }
    }

    /* compiled from: Pattern */
    public static class c extends d {
        private final List<d> ebX;

        public c(int i, int i2, List<d> list) {
            super(i, i2);
            this.ebX = new ArrayList(list);
        }

        public void a(d dVar) {
            this.ebX.add(dVar);
        }

        protected String b(StackTraceElement stackTraceElement, String str, Level level) {
            StringBuilder stringBuilder = new StringBuilder();
            for (d a : this.ebX) {
                stringBuilder.append(a.a(stackTraceElement, str, level));
            }
            return stringBuilder.toString();
        }

        protected boolean isCallerNeeded() {
            for (d isCallerNeeded : this.ebX) {
                if (isCallerNeeded.isCallerNeeded()) {
                    return true;
                }
            }
            return false;
        }
    }

    /* compiled from: Pattern */
    public static class d extends d {
        private final SimpleDateFormat dateFormat;

        public d(int i, int i2, String str) {
            super(i, i2);
            if (str != null) {
                this.dateFormat = new SimpleDateFormat(str);
            } else {
                this.dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            }
        }

        protected String b(StackTraceElement stackTraceElement, String str, Level level) {
            return this.dateFormat.format(new Date());
        }
    }

    /* compiled from: Pattern */
    public static class e extends d {
        public e(int i, int i2) {
            super(i, i2);
        }

        protected String b(StackTraceElement stackTraceElement, String str, Level level) {
            return level.toString();
        }
    }

    /* compiled from: Pattern */
    public static class f extends d {
        private int ebY;
        private int ebZ;

        public f(int i, int i2, int i3, int i4) {
            super(i, i2);
            this.ebY = i3;
            this.ebZ = i4;
        }

        protected String b(StackTraceElement stackTraceElement, String str, Level level) {
            return g.e(str, this.ebY, this.ebZ);
        }
    }

    /* compiled from: Pattern */
    public static class g extends d {
        private final String string;

        public g(int i, int i2, String str) {
            super(i, i2);
            this.string = str;
        }

        protected String b(StackTraceElement stackTraceElement, String str, Level level) {
            return this.string;
        }
    }

    /* compiled from: Pattern */
    public static class h extends d {
        protected boolean isCallerNeeded() {
            return true;
        }

        public h(int i, int i2) {
            super(i, i2);
        }

        protected String b(StackTraceElement stackTraceElement, String str, Level level) {
            if (stackTraceElement == null) {
                throw new IllegalArgumentException("Caller not found");
            }
            StringBuilder stringBuilder = new StringBuilder();
            if (stackTraceElement.isNativeMethod()) {
                stringBuilder.append("(native)");
            } else if (stackTraceElement.getFileName() == null) {
                stringBuilder.append("(unknown)");
            } else if (stackTraceElement.getLineNumber() >= 0) {
                stringBuilder.append(String.format("(%s:%d)", new Object[]{stackTraceElement.getFileName(), Integer.valueOf(stackTraceElement.getLineNumber())}));
            } else {
                stringBuilder.append(String.format("(%s)", new Object[]{stackTraceElement.getFileName()}));
            }
            return stringBuilder.toString();
        }
    }

    /* compiled from: Pattern */
    public static class i extends d {
        public i(int i, int i2) {
            super(i, i2);
        }

        protected String b(StackTraceElement stackTraceElement, String str, Level level) {
            return Thread.currentThread().getName();
        }
    }

    protected abstract String b(StackTraceElement stackTraceElement, String str, Level level);

    protected boolean isCallerNeeded() {
        return false;
    }

    private d(int i, int i2) {
        this.count = i;
        this.length = i2;
    }

    public final String a(StackTraceElement stackTraceElement, String str, Level level) {
        return g.d(b(stackTraceElement, str, level), this.count, this.length);
    }

    public static d lc(String str) {
        d dVar;
        if (str == null) {
            dVar = null;
        } else {
            try {
                dVar = new b().lc(str);
            } catch (Throwable e) {
                c.lb("ROOT").a(e, "cannot parse pattern: '%s'", str);
                return new g(0, 0, str);
            }
        }
        return dVar;
    }
}
