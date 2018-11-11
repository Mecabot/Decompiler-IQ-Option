package com.iqoption.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.SwitchCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.iqoption.x.R;

public final class SettingItemView extends LinearLayout {
    private b dDF;
    private a dDG;
    private TextView dDH;
    private ProgressBar dDI;
    private SwitchCompat dDJ;

    public interface a {
        void b(@NonNull SettingItemView settingItemView, boolean z);
    }

    public interface b {
        boolean a(@NonNull SettingItemView settingItemView, boolean z);
    }

    public SettingItemView(Context context) {
        super(context);
        init(null);
    }

    public SettingItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    public SettingItemView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet);
    }

    @TargetApi(21)
    public SettingItemView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init(attributeSet);
    }

    private void init(@Nullable AttributeSet attributeSet) {
        inflate(getContext(), R.layout.setting_item_view, this);
        setGravity(16);
        setClickable(true);
        setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (SettingItemView.this.dDF == null || !SettingItemView.this.dDF.a(SettingItemView.this, SettingItemView.this.dDJ.isChecked())) {
                    SettingItemView.this.a();
                }
            }
        });
        this.dDH = (TextView) findViewById(R.id.setting_label);
        this.dDI = (ProgressBar) findViewById(R.id.setting_progress);
        this.dDJ = (SwitchCompat) findViewById(R.id.setting_switch);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, com.iqoption.b.b.SettingItemView);
            setLabel(obtainStyledAttributes.getText(1));
            setChecked(obtainStyledAttributes.getBoolean(0, false));
            obtainStyledAttributes.recycle();
        }
    }

    public void setLabel(@Nullable CharSequence charSequence) {
        this.dDH.setText(charSequence);
    }

    public void setProgressVisible(boolean z) {
        this.dDI.setVisibility(z ? 0 : 8);
    }

    public void setChecked(boolean z) {
        this.dDJ.setChecked(z);
    }

    /* renamed from: toggle */
    public void a() {
        this.dDJ.performClick();
        if (this.dDG != null) {
            this.dDG.b(this, this.dDJ.isChecked());
        }
    }

    public void setToggleHandler(@Nullable b bVar) {
        this.dDF = bVar;
    }

    public void setOnToggleListener(@Nullable a aVar) {
        this.dDG = aVar;
    }
}
