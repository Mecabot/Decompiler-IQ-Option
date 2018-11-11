package com.jumio.nv.models;

import com.jumio.sdk.models.CredentialsModel;

public class NetverifyCredentialsModel extends CredentialsModel {
    private NetverifyOfflineCredentialsModel a;
    private boolean b = false;
    private boolean c = false;

    public void setOfflineSwitch(boolean z) {
        this.b = z;
    }

    public boolean useOffline() {
        return this.b;
    }

    public void setFinalize(boolean z) {
        this.c = z;
    }

    public boolean shouldFinalize() {
        return this.c;
    }

    public void setOfflineCredentialsModel(NetverifyOfflineCredentialsModel netverifyOfflineCredentialsModel) {
        this.a = netverifyOfflineCredentialsModel;
    }

    public NetverifyOfflineCredentialsModel getOfflineCredentialsModel() {
        return this.a;
    }
}
