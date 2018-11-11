package com.appsflyer.a;

import java.util.Scanner;

public class b {
    private String pJ;
    private String pk;
    private String po;
    private String pr;

    public b(String str, String str2, String str3) {
        this.pJ = str;
        this.pk = str2;
        this.pr = str3;
    }

    public b(char[] cArr) {
        Scanner scanner = new Scanner(new String(cArr));
        while (scanner.hasNextLine()) {
            String nextLine = scanner.nextLine();
            if (nextLine.startsWith("url=")) {
                this.pJ = nextLine.substring(4).trim();
            } else if (nextLine.startsWith("version=")) {
                this.pr = nextLine.substring(8).trim();
            } else if (nextLine.startsWith("data=")) {
                this.pk = nextLine.substring(5).trim();
            }
        }
        scanner.close();
    }

    public String getVersion() {
        return this.pr;
    }

    public String fQ() {
        return this.pk;
    }

    public String fR() {
        return this.pJ;
    }

    public String fS() {
        return this.po;
    }

    public void aC(String str) {
        this.po = str;
    }
}
