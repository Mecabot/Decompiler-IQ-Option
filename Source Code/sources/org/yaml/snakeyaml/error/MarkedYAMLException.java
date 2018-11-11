package org.yaml.snakeyaml.error;

public class MarkedYAMLException extends YAMLException {
    private static final long serialVersionUID = -9119388488683035101L;
    private String context;
    private Mark contextMark;
    private String note;
    private String problem;
    private Mark problemMark;

    protected MarkedYAMLException(String str, Mark mark, String str2, Mark mark2, String str3) {
        this(str, mark, str2, mark2, str3, null);
    }

    protected MarkedYAMLException(String str, Mark mark, String str2, Mark mark2, String str3, Throwable th) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("; ");
        stringBuilder.append(str2);
        stringBuilder.append("; ");
        stringBuilder.append(mark2);
        super(stringBuilder.toString(), th);
        this.context = str;
        this.contextMark = mark;
        this.problem = str2;
        this.problemMark = mark2;
        this.note = str3;
    }

    protected MarkedYAMLException(String str, Mark mark, String str2, Mark mark2) {
        this(str, mark, str2, mark2, null, null);
    }

    protected MarkedYAMLException(String str, Mark mark, String str2, Mark mark2, Throwable th) {
        this(str, mark, str2, mark2, null, th);
    }

    public String getMessage() {
        return toString();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.context != null) {
            stringBuilder.append(this.context);
            stringBuilder.append("\n");
        }
        if (this.contextMark != null && (this.problem == null || this.problemMark == null || this.contextMark.getName().equals(this.problemMark.getName()) || this.contextMark.bDX() != this.problemMark.bDX() || this.contextMark.getColumn() != this.problemMark.getColumn())) {
            stringBuilder.append(this.contextMark.toString());
            stringBuilder.append("\n");
        }
        if (this.problem != null) {
            stringBuilder.append(this.problem);
            stringBuilder.append("\n");
        }
        if (this.problemMark != null) {
            stringBuilder.append(this.problemMark.toString());
            stringBuilder.append("\n");
        }
        if (this.note != null) {
            stringBuilder.append(this.note);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
