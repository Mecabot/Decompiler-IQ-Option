package com.google.android.youtube.player;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.youtube.player.YouTubePlayer.e;

public class b extends Fragment implements e {
    private final a KX = new a(this, (byte) 0);
    private Bundle La;
    private c Lb;
    private com.google.android.youtube.player.YouTubePlayer.b Lc;
    private String d;
    private boolean f;

    private final class a implements b {
        private a() {
        }

        /* synthetic */ a(b bVar, byte b) {
            this();
        }

        public final void a(c cVar) {
        }
    }

    private void a() {
        if (this.Lb != null && this.Lc != null) {
            this.Lb.a(this.f);
            this.Lb.a(zzakw(), this, this.d, this.Lc, this.La);
            this.La = null;
            this.Lc = null;
        }
    }

    public void a(String str, com.google.android.youtube.player.YouTubePlayer.b bVar) {
        this.d = com.google.android.youtube.player.internal.b.c(str, "Developer key cannot be null or empty");
        this.Lc = bVar;
        a();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.La = bundle != null ? bundle.getBundle("YouTubePlayerSupportFragment.KEY_PLAYER_VIEW_STATE") : null;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.Lb = new c(zzakw(), null, 0, this.KX);
        a();
        return this.Lb;
    }

    public void onDestroy() {
        if (this.Lb != null) {
            Activity activity = zzakw();
            c cVar = this.Lb;
            boolean z = activity == null || activity.isFinishing();
            cVar.b(z);
        }
        super.onDestroy();
    }

    public void onDestroyView() {
        this.Lb.c(zzakw().isFinishing());
        this.Lb = null;
        super.onDestroyView();
    }

    public void onPause() {
        this.Lb.c();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.Lb.b();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBundle("YouTubePlayerSupportFragment.KEY_PLAYER_VIEW_STATE", this.Lb != null ? this.Lb.pe() : this.La);
    }

    public void onStart() {
        super.onStart();
        this.Lb.a();
    }

    public void onStop() {
        this.Lb.d();
        super.onStop();
    }
}
