package com.jumio.nv.nfc.core.communication;

import java.io.Serializable;
import java.util.Date;

public class TagAccessSpec implements Serializable {
    private String a;
    private Date b;
    private Date c;
    private String d;
    private boolean e;

    public TagAccessSpec(String str, Date date, Date date2, String str2, boolean z) {
        this.a = str;
        this.b = date;
        this.c = date2;
        this.d = str2;
        this.e = z;
    }

    public TagAccessSpec(String str, Date date, Date date2, String str2) {
        this(str, date, date2, str2, false);
    }

    public String getIdNumber() {
        return this.a;
    }

    public Date getDateOfBirth() {
        return this.b;
    }

    public Date getDateOfExpiry() {
        return this.c;
    }

    public String getCountryIso3() {
        return this.d;
    }

    public boolean shouldDownloadFaceImage() {
        return this.e;
    }

    public void setDateOfExpiry(Date date) {
        this.c = date;
    }

    public void setIdNumber(String str) {
        this.a = str;
    }

    public void setDateOfBirth(Date date) {
        this.b = date;
    }

    public void setCountryIso3(String str) {
        this.d = str;
    }

    public void setShouldDownloadFaceimage(boolean z) {
        this.e = z;
    }
}
