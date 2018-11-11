package com.jumio;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.jumio.sdk.models.CredentialsModel;

public class MobileActivity extends AppCompatActivity {
    public static final String EXTRA_CREDENTIALS = "com.jumio.nv.MobileActivity.EXTRA_CREDENTIALS";
    public static final String EXTRA_CUSTOM_THEME = "com.jumio.nv.MobileActivity.EXTRA_CUSTOM_THEME";
    private CredentialsModel credentialsModel = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent() != null) {
            int i = 0;
            if (getIntent().getExtras() != null) {
                i = getIntent().getExtras().getInt(EXTRA_CUSTOM_THEME);
            }
            if (i != 0) {
                setTheme(i);
            }
            if (this.credentialsModel != null) {
                return;
            }
            if (getIntent() != null) {
                this.credentialsModel = (CredentialsModel) getIntent().getSerializableExtra(EXTRA_CREDENTIALS);
            } else if (bundle != null) {
                this.credentialsModel = (CredentialsModel) bundle.getSerializable(EXTRA_CREDENTIALS);
            }
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            bundle.putSerializable(EXTRA_CREDENTIALS, this.credentialsModel);
        }
    }

    protected CredentialsModel getCredentialsModel() {
        return this.credentialsModel;
    }
}
