package com.iqoption.kyc;

import android.support.annotation.StringRes;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

/* compiled from: ToolbarUtils */
public final class i {
    public static void a(AppCompatActivity appCompatActivity, Toolbar toolbar) {
        appCompatActivity.setSupportActionBar(toolbar);
        ActionBar supportActionBar = appCompatActivity.getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
            supportActionBar.setDisplayShowHomeEnabled(true);
            supportActionBar.setDisplayShowTitleEnabled(false);
        }
    }

    public static void b(AppCompatActivity appCompatActivity, Toolbar toolbar) {
        appCompatActivity.setSupportActionBar(toolbar);
        ActionBar supportActionBar = appCompatActivity.getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayShowHomeEnabled(false);
            supportActionBar.setDisplayHomeAsUpEnabled(false);
            supportActionBar.setDisplayShowTitleEnabled(false);
        }
    }

    public static void a(AppCompatActivity appCompatActivity) {
        ActionBar supportActionBar = appCompatActivity.getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayShowHomeEnabled(false);
            supportActionBar.setDisplayHomeAsUpEnabled(false);
            supportActionBar.setDisplayShowTitleEnabled(false);
        }
    }

    public static void a(AppCompatActivity appCompatActivity, Toolbar toolbar, @StringRes int i) {
        a(appCompatActivity, toolbar, appCompatActivity.getString(i));
    }

    public static void a(AppCompatActivity appCompatActivity, Toolbar toolbar, CharSequence charSequence) {
        appCompatActivity.setSupportActionBar(toolbar);
        ActionBar supportActionBar = appCompatActivity.getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
            supportActionBar.setDisplayShowHomeEnabled(true);
            supportActionBar.setTitle(charSequence);
            supportActionBar.setDisplayShowTitleEnabled(true);
        }
    }

    public static void b(AppCompatActivity appCompatActivity, Toolbar toolbar, CharSequence charSequence) {
        appCompatActivity.setSupportActionBar(toolbar);
        ActionBar supportActionBar = appCompatActivity.getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(false);
            supportActionBar.setDisplayShowHomeEnabled(false);
            supportActionBar.setTitle(charSequence);
            supportActionBar.setDisplayShowTitleEnabled(true);
        }
    }

    public static void a(AppCompatActivity appCompatActivity, CharSequence charSequence) {
        ActionBar supportActionBar = appCompatActivity.getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setTitle(charSequence);
            int identifier = appCompatActivity.getResources().getIdentifier("action_bar_title", "id", "android");
            if (identifier != 0) {
                TextView textView = (TextView) appCompatActivity.findViewById(identifier);
                if (textView != null) {
                    textView.setGravity(17);
                }
            }
        }
    }

    public static void b(AppCompatActivity appCompatActivity) {
        ActionBar supportActionBar = appCompatActivity.getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(false);
            supportActionBar.setDisplayShowHomeEnabled(false);
            supportActionBar.setDisplayShowTitleEnabled(false);
        }
    }
}
