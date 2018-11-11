package com.iqoption.dto;

public class Country extends AbstractEntity {
    public long id;
    public String name;
    public int phoneCode;

    public String toString() {
        if (this.name != null) {
            return this.name;
        }
        return super.toString();
    }
}
