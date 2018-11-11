package com.jumio.dv.view.interactors;

import com.jumio.sdk.models.CredentialsModel;
import com.jumio.sdk.view.InteractibleView;

public interface CompleteView extends InteractibleView {
    CredentialsModel getCredentialsModel();

    void uploadComplete();
}
