package com.iqoption.dto.entity.debug;

import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;

public class ContainerEntity {
    public ArrayList<BuildProject> buildProjects;
    public Container container;
    public Long id;
    public String status;
    public User user;

    public static class BuildProject {
        @SerializedName("branchName")
        public String branchName;
        @SerializedName("build_recipe_id")
        public Long buildRecipeId;
        @SerializedName("projectName")
        public String projectName;
    }

    public static class Container {
        @SerializedName("hostname")
        public String hostname;
        @SerializedName("id")
        public Long id;
        @SerializedName("node_id")
        public Long nodeId;
        @SerializedName("status")
        public String status;

        public String getHostname() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("http://");
            stringBuilder.append(this.hostname);
            stringBuilder.append("/");
            return stringBuilder.toString();
        }
    }

    public static class List extends ArrayList<ContainerEntity> {
    }

    public static class User {
        @SerializedName("id")
        public Long id;
        @SerializedName("username")
        public String username;
    }

    public boolean isSuccess() {
        boolean z = false;
        if (this.container == null || TextUtils.isEmpty(this.status) || TextUtils.isEmpty(this.container.status)) {
            return false;
        }
        if (this.status.equals(b.SUCCESS) && this.container.status.equals("running")) {
            z = true;
        }
        return z;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Owner: ");
        stringBuilder.append(this.user.username);
        stringBuilder.append("\n_____________\n");
        Iterator it = this.buildProjects.iterator();
        while (it.hasNext()) {
            BuildProject buildProject = (BuildProject) it.next();
            stringBuilder.append(buildProject.projectName);
            stringBuilder.append("-");
            stringBuilder.append(buildProject.branchName);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
