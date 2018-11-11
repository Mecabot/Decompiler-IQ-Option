package com.jumio.nv.view.interactors;

import com.jumio.sdk.models.CredentialsModel;
import com.jumio.sdk.view.InteractibleView;

public interface UploadView extends InteractibleView {
    int getCloseDelay();

    CredentialsModel getCredentialsModel();

    void uploadComplete();
}
