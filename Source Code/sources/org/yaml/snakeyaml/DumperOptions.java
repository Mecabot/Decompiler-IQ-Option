package org.yaml.snakeyaml;

import java.util.Map;
import java.util.TimeZone;
import org.yaml.snakeyaml.c.a;
import org.yaml.snakeyaml.c.b;
import org.yaml.snakeyaml.error.YAMLException;

public class DumperOptions {
    private Map<String, String> aYH = null;
    private boolean allowUnicode = true;
    private ScalarStyle fhf = ScalarStyle.PLAIN;
    private FlowStyle fhg = FlowStyle.AUTO;
    private boolean fhh = false;
    private boolean fhi = false;
    private int fhj = 2;
    private int fhk = 0;
    private int fhl = 80;
    private boolean fhm = true;
    private LineBreak fhn = LineBreak.UNIX;
    private boolean fho = false;
    private boolean fhp = false;
    private TimeZone fhq = null;
    private Version fhr = null;
    private Boolean fhs = Boolean.valueOf(false);
    private a fht = new b(0);

    public enum FlowStyle {
        FLOW(Boolean.TRUE),
        BLOCK(Boolean.FALSE),
        AUTO(null);
        
        private Boolean styleBoolean;

        private FlowStyle(Boolean bool) {
            this.styleBoolean = bool;
        }

        public Boolean getStyleBoolean() {
            return this.styleBoolean;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Flow style: '");
            stringBuilder.append(this.styleBoolean);
            stringBuilder.append("'");
            return stringBuilder.toString();
        }
    }

    public enum LineBreak {
        WIN("\r\n"),
        MAC("\r"),
        UNIX("\n");
        
        private String lineBreak;

        private LineBreak(String str) {
            this.lineBreak = str;
        }

        public String getString() {
            return this.lineBreak;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Line break: ");
            stringBuilder.append(name());
            return stringBuilder.toString();
        }

        public static LineBreak getPlatformLineBreak() {
            String property = System.getProperty("line.separator");
            for (LineBreak lineBreak : values()) {
                if (lineBreak.lineBreak.equals(property)) {
                    return lineBreak;
                }
            }
            return UNIX;
        }
    }

    public enum ScalarStyle {
        DOUBLE_QUOTED(Character.valueOf('\"')),
        SINGLE_QUOTED(Character.valueOf('\'')),
        LITERAL(Character.valueOf('|')),
        FOLDED(Character.valueOf('>')),
        PLAIN(null);
        
        private Character styleChar;

        private ScalarStyle(Character ch) {
            this.styleChar = ch;
        }

        public Character getChar() {
            return this.styleChar;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Scalar style: '");
            stringBuilder.append(this.styleChar);
            stringBuilder.append("'");
            return stringBuilder.toString();
        }

        public static ScalarStyle createStyle(Character ch) {
            if (ch == null) {
                return PLAIN;
            }
            char charValue = ch.charValue();
            if (charValue == '\"') {
                return DOUBLE_QUOTED;
            }
            if (charValue == '\'') {
                return SINGLE_QUOTED;
            }
            if (charValue == '>') {
                return FOLDED;
            }
            if (charValue == '|') {
                return LITERAL;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unknown scalar style character: ");
            stringBuilder.append(ch);
            throw new YAMLException(stringBuilder.toString());
        }
    }

    public enum Version {
        V1_0(new Integer[]{Integer.valueOf(1), Integer.valueOf(0)}),
        V1_1(new Integer[]{Integer.valueOf(1), Integer.valueOf(1)});
        
        private Integer[] version;

        private Version(Integer[] numArr) {
            this.version = numArr;
        }

        public int major() {
            return this.version[0].intValue();
        }

        public int minor() {
            return this.version[1].intValue();
        }

        public String getRepresentation() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.version[0]);
            stringBuilder.append(".");
            stringBuilder.append(this.version[1]);
            return stringBuilder.toString();
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Version: ");
            stringBuilder.append(getRepresentation());
            return stringBuilder.toString();
        }
    }

    public ScalarStyle bDE() {
        return this.fhf;
    }

    public void a(ScalarStyle scalarStyle) {
        if (scalarStyle == null) {
            throw new NullPointerException("Use ScalarStyle enum.");
        }
        this.fhf = scalarStyle;
    }

    public int getIndent() {
        return this.fhj;
    }

    public int bDF() {
        return this.fhk;
    }

    public void a(FlowStyle flowStyle) {
        if (flowStyle == null) {
            throw new NullPointerException("Use FlowStyle enum.");
        }
        this.fhg = flowStyle;
    }

    public FlowStyle bDG() {
        return this.fhg;
    }

    public boolean bDH() {
        return this.fhi;
    }

    public void hu(boolean z) {
        this.fhi = z;
    }

    public TimeZone getTimeZone() {
        return this.fhq;
    }

    public void setTimeZone(TimeZone timeZone) {
        this.fhq = timeZone;
    }
}
