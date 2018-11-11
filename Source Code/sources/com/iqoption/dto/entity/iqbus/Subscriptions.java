package com.iqoption.dto.entity.iqbus;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class Subscriptions {
    @SerializedName("categories")
    public ArrayList<Category> categories;
    @SerializedName("enabled")
    public Boolean enabled;

    public static class Category {
        @SerializedName("groups")
        public ArrayList<Group> groups;
        @SerializedName("id")
        public Long id;
        @SerializedName("title")
        public String title;
    }

    public static class Group {
        @SerializedName("description")
        public String description;
        @SerializedName("enabled")
        public Boolean enabled;
        @SerializedName("id")
        public Long id;
        @SerializedName("title")
        public String title;
    }
}
