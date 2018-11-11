package com.iqoption.feed;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.databinding.DataBindingUtil;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BaseTransientBottomBar.BaseCallback;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.ShareCompat.IntentBuilder;
import android.support.v4.util.ArrayMap;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.support.v7.widget.RecyclerView.OnChildAttachStateChangeListener;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.ErrorReason;
import com.google.android.youtube.player.YouTubePlayer.e;
import com.iqoption.analytics.EventManager;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.core.microservices.feed.response.FeedPriority;
import com.iqoption.core.util.i;
import com.iqoption.d.abe;
import com.iqoption.d.ajo;
import com.iqoption.d.kt;
import com.iqoption.d.yo;
import com.iqoption.d.ys;
import com.iqoption.dto.Event;
import com.iqoption.dto.Event.Builder;
import com.iqoption.feed.feedlist.b.g;
import com.iqoption.feed.feedlist.d;
import com.iqoption.feed.feedlist.j;
import com.iqoption.fragment.base.f;
import com.iqoption.service.WebSocketHandler;
import com.iqoption.util.be;
import com.iqoption.util.bg;
import com.iqoption.widget.h;
import com.iqoption.x.R;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.Pair;
import kotlin.l;

/* compiled from: SmartFeedFragment */
public class b extends f implements com.iqoption.view.e.a {
    public static final String TAG = "com.iqoption.feed.b";
    private static final List<InstrumentType> clO = Arrays.asList(new InstrumentType[]{InstrumentType.CRYPTO_INSTRUMENT, InstrumentType.FOREX_INSTRUMENT, InstrumentType.CFD_INSTRUMENT, InstrumentType.DIGITAL_INSTRUMENT, InstrumentType.FX_INSTRUMENT, InstrumentType.BINARY_INSTRUMENT, InstrumentType.TURBO_INSTRUMENT});
    private int aMA = -1;
    private boolean aWg;
    private d clD;
    private int clE = -1;
    private ajo clF;
    private ys clG;
    private abe clH;
    private FeedViewModel clI;
    private AudioManager clJ;
    private int clK;
    private boolean clL;
    private c clM;
    private Builder clN;
    private final Runnable clP = new c(this);
    private final OnChildAttachStateChangeListener clQ = new OnChildAttachStateChangeListener() {
        public void onChildViewAttachedToWindow(View view) {
        }

        public void onChildViewDetachedFromWindow(View view) {
            if (view.getId() == R.id.video_feed) {
                ViewHolder findContainingViewHolder = b.this.aga().findContainingViewHolder(view);
                if (findContainingViewHolder instanceof j) {
                    ((j) findContainingViewHolder).agy();
                }
            }
        }
    };
    private final OnScrollListener clR = new OnScrollListener() {
        private int aMz;

        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                b.this.c(recyclerView);
                b.this.afV();
                return;
            }
            b.this.afU();
        }

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            i = recyclerView.getChildCount();
            if (i != 0 && recyclerView.getAdapter() != null) {
                b.this.aMA = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition();
                if (b.this.aMA % 10 == 0) {
                    es(b.this.aMA);
                }
                if (b.this.aWg) {
                    i = recyclerView.getChildAdapterPosition(recyclerView.getChildAt(i - 1));
                    if (!b.this.clL && i > recyclerView.getAdapter().getItemCount() - 15) {
                        b.this.er(b.this.clK);
                    }
                }
            }
        }

        private void es(int i) {
            if (this.aMz < i) {
                this.aMz = i;
                EventManager.Bm().a(Event.Builder(Event.CATEGORY_SCROLL, "smart-feed_scroll").setValue(Double.valueOf((double) i)).build());
            }
        }
    };

    /* compiled from: SmartFeedFragment */
    public interface a {
        boolean agh();
    }

    /* compiled from: SmartFeedFragment */
    public interface b {
        void a(com.google.android.youtube.player.c cVar, YouTubePlayer youTubePlayer);

        void onError();
    }

    /* compiled from: SmartFeedFragment */
    public static class c {
        private final com.google.android.youtube.player.b cmg;
        private final Map<String, Integer> cmh = new ArrayMap();
        private boolean cmi;
        private boolean cmj;
        @Nullable
        private String cmk;
        @Nullable
        private YouTubePlayer cml;
        @Nullable
        private com.google.android.youtube.player.c cmm;
        private final Map<SurfaceView, ViewGroup> cmn = new HashMap();

        c(com.google.android.youtube.player.b bVar) {
            this.cmg = bVar;
        }

        public void a(b bVar) {
            if (this.cmi) {
                bVar.onError();
                return;
            }
            if (this.cmm == null) {
                this.cmi = true;
                b(bVar);
            } else {
                bVar.a(this.cmm, this.cml);
            }
        }

        public void cy(String str) {
            if (this.cml != null) {
                if (!(this.cmk == null || TextUtils.equals(this.cmk, str) || !this.cml.isPlaying())) {
                    ht(this.cmk);
                }
                this.cmk = str;
                this.cml.cy(str);
            }
        }

        public void ht(String str) {
            try {
                if (this.cml != null && hu(str) && this.cml.isPlaying()) {
                    this.cml.pause();
                    this.cmh.put(str, Integer.valueOf(this.cml.oX()));
                    this.cmk = null;
                }
            } catch (IllegalStateException unused) {
            }
        }

        public boolean hu(String str) {
            return TextUtils.equals(this.cmk, str);
        }

        private boolean onBackPressed() {
            if (this.cml == null || !this.cmj) {
                return false;
            }
            this.cml.setFullscreen(false);
            return true;
        }

        private void b(final b bVar) {
            if (this.cmg.isAdded()) {
                this.cmg.a(this.cmg.getString(R.string.you_tube_key), new com.google.android.youtube.player.YouTubePlayer.b() {
                    public void a(e eVar, YouTubeInitializationResult youTubeInitializationResult) {
                    }

                    public void a(e eVar, YouTubePlayer youTubePlayer, boolean z) {
                        com.google.android.youtube.player.c cVar = (com.google.android.youtube.player.c) c.this.cmg.getView();
                        if (cVar == null) {
                            c.this.cmi = false;
                            bVar.onError();
                            return;
                        }
                        c.this.cmm = cVar;
                        c.this.cmm.setLayoutParams(new LayoutParams(-1, -1));
                        c.this.cmm.setId(R.id.youtube_video);
                        c.this.cml = youTubePlayer;
                        c.this.cml.a(new v(this));
                        c.this.cml.a(new YouTubePlayer.d() {
                            public void a(ErrorReason errorReason) {
                            }

                            public void pb() {
                            }

                            public void pc() {
                            }

                            public void pa() {
                                c.this.k(c.this.cmm);
                            }

                            public void cz(String str) {
                                if (TextUtils.equals(c.this.cmk, str)) {
                                    Integer num = (Integer) c.this.cmh.get(str);
                                    if (num != null) {
                                        c.this.cml.au(num.intValue());
                                        c.this.cml.play();
                                    }
                                }
                            }

                            public void pd() {
                                c.this.cml.au(0);
                                c.this.cml.play();
                            }
                        });
                        c.this.cml.a(new com.google.android.youtube.player.YouTubePlayer.c() {
                            public void aa(boolean z) {
                            }

                            public void av(int i) {
                            }

                            public void oZ() {
                            }

                            public void onStopped() {
                            }

                            public void onPaused() {
                                if (c.this.cmk != null) {
                                    c.this.cmh.put(c.this.cmk, Integer.valueOf(c.this.cml.oX()));
                                }
                            }
                        });
                        c.this.cmi = false;
                        bVar.a(c.this.cmm, c.this.cml);
                    }

                    final /* synthetic */ void cM(boolean z) {
                        c.this.cmj = z;
                    }
                });
            } else {
                bVar.onError();
            }
        }

        private void k(com.google.android.youtube.player.c cVar) {
            au(cVar);
            for (Entry entry : this.cmn.entrySet()) {
                ViewGroup viewGroup = (ViewGroup) entry.getValue();
                ViewGroup viewGroup2 = (ViewGroup) viewGroup.getParent();
                if (viewGroup2 != null) {
                    viewGroup2.removeView(viewGroup);
                    viewGroup2.post(new u(entry, viewGroup2, viewGroup));
                }
            }
        }

        static final /* synthetic */ void a(Entry entry, ViewGroup viewGroup, ViewGroup viewGroup2) {
            ((SurfaceView) entry.getKey()).setZOrderMediaOverlay(true);
            viewGroup.addView(viewGroup2);
        }

        private SurfaceView au(View view) {
            if (view instanceof SurfaceView) {
                return (SurfaceView) view;
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    SurfaceView au = au(viewGroup.getChildAt(i));
                    if (au != null) {
                        au = au;
                        this.cmn.put(au, viewGroup);
                        return au;
                    }
                }
            }
            return null;
        }
    }

    public static b afT() {
        return new b();
    }

    final /* synthetic */ void agg() {
        if (isAdded()) {
            RecyclerView recyclerView = age().bKX;
            if (recyclerView.getScrollState() == 0) {
                int childCount = recyclerView.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = recyclerView.getChildAt(i);
                    ViewHolder findContainingViewHolder = recyclerView.findContainingViewHolder(childAt);
                    if (findContainingViewHolder instanceof com.iqoption.feed.feedlist.a) {
                        com.iqoption.feed.feedlist.a aVar = (com.iqoption.feed.feedlist.a) findContainingViewHolder;
                        if (aVar.Lg() && !aVar.agi() && bg.bT(childAt) >= 0.8f) {
                            aVar.agj();
                            break;
                        }
                    }
                }
            }
        }
    }

    private void afU() {
        if (this.clE != 1) {
            com.iqoption.core.d.a.aSe.removeCallbacks(this.clP);
        }
    }

    private void afV() {
        if (this.clE != 1) {
            com.iqoption.core.d.a.aSe.removeCallbacks(this.clP);
            com.iqoption.core.d.a.aSe.postDelayed(this.clP, 2000);
        }
    }

    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.clF = (ajo) DataBindingUtil.inflate(layoutInflater, R.layout.smart_feed_fragment, viewGroup, false);
        afX();
        a(this.clM);
        b(getResources().getConfiguration());
        a.cle.afJ().observe(this, new d(this));
        if (this.clE == 2) {
            a.cle.afG().observe(this, new l(this));
        }
        agb();
        return this.clF.getRoot();
    }

    final /* synthetic */ void y(Map map) {
        if (map != null && !map.isEmpty()) {
            this.clD.z(map);
        }
    }

    public boolean onBackPressed() {
        return (this.clM != null && this.clM.onBackPressed()) || afW() || super.aN();
    }

    public boolean onClose() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment instanceof a) {
            return ((a) parentFragment).agh();
        }
        zzakw().finish();
        return true;
    }

    private boolean afW() {
        View findViewWithTag = this.clF.bTt.findViewWithTag("OPTIONS_VIEW");
        if (findViewWithTag == null) {
            return false;
        }
        this.clF.bTt.removeView(findViewWithTag);
        return true;
    }

    public void onStart() {
        super.onStart();
        afY();
    }

    public void onStop() {
        afZ();
        super.onStop();
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.clI = FeedViewModel.clo.P(this);
        this.clJ = (AudioManager) requireContext().getSystemService("audio");
    }

    public void onDestroyView() {
        afU();
        super.onDestroyView();
    }

    public void onDestroy() {
        requireActivity().setRequestedOrientation(6);
        super.onDestroy();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            com.iqoption.core.microservices.feed.response.a aVar;
            boolean z = true;
            Object obj = this.clE == 1 ? 1 : null;
            if (i == 256) {
                aVar = (com.iqoption.core.microservices.feed.response.a) intent.getParcelableExtra(FeedPortraitActivity.ckV);
            } else if (i != 512) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unexpected case: ");
                stringBuilder.append(i);
                throw new IllegalStateException(stringBuilder.toString());
            } else {
                aVar = (com.iqoption.core.microservices.feed.response.a) intent.getParcelableExtra("EXTRA_WEB_CLICKED_BUTTON_ITEM");
                z = false;
            }
            if (obj != null) {
                d(aVar);
            } else {
                a(aVar, z, false);
            }
        }
    }

    private void d(@NonNull com.iqoption.core.microservices.feed.response.a aVar) {
        Intent intent = new Intent();
        intent.putExtra(FeedPortraitActivity.ckV, aVar);
        requireActivity().setResult(-1, intent);
        requireActivity().finish();
    }

    private void c(RecyclerView recyclerView) {
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            if (childAt.getId() == R.id.video_feed) {
                ViewHolder findContainingViewHolder = recyclerView.findContainingViewHolder(childAt);
                if ((findContainingViewHolder instanceof j) && bg.bT(childAt) >= 0.75f) {
                    ((j) findContainingViewHolder).agx();
                    return;
                }
            }
        }
    }

    private void afX() {
        Fragment bVar = new com.google.android.youtube.player.b();
        getChildFragmentManager().executePendingTransactions();
        getChildFragmentManager().beginTransaction().add(bVar, "YOU_TUBE").commitNow();
        this.clM = new c(bVar);
    }

    private void a(Builder builder, com.iqoption.core.microservices.feed.response.a aVar) {
        FeedPriority VR = aVar.VR();
        builder.setParameters(i.ZZ().l("news_id", Integer.valueOf(aVar.getId())).l("news_topic", "smart-feed").l("news_likes", Integer.valueOf(aVar.getRating())).l("news_views", Integer.valueOf(aVar.VV())).l("ordering_priority", VR != null ? Integer.valueOf(VR.getServerValue()) : null).aab());
        EventManager.Bm().a(builder.build());
    }

    private void a(c cVar) {
        this.clD = new d(cVar, new com.iqoption.feed.feedlist.d.a() {
            public void hs(String str) {
                b.this.hq(str);
            }

            public void f(com.iqoption.core.microservices.feed.response.a aVar) {
                b.this.clI.h(aVar.getId(), aVar.getType());
                if ("YouTube".equals(aVar.getSource())) {
                    b.this.e(aVar);
                } else {
                    b.this.a(aVar.VN(), aVar);
                }
                b.this.a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "smart-feed_open-news"), aVar);
            }

            public boolean h(com.iqoption.feed.feedlist.e eVar) {
                if (WebSocketHandler.aDm().isAuthorized()) {
                    com.iqoption.core.microservices.feed.response.a ags = eVar.ags();
                    b.this.a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "smart-feed_news-like").setValue(Double.valueOf(ags.VS() ? 0.0d : 1.0d)), ags);
                    b.this.clI.a(ags).observe(b.this, new t(this, eVar));
                    return true;
                }
                com.iqoption.app.a.b.FG();
                return false;
            }

            public void a(View view, com.iqoption.feed.feedlist.e eVar) {
                if (b.this.clE == 2) {
                    b.this.a(eVar, view);
                } else {
                    b.this.c(eVar);
                }
                b.this.a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "smart-feed_news-settings"), eVar.ags());
            }

            public void g(@NonNull com.iqoption.core.microservices.feed.response.a aVar) {
                if (b.this.clE == 1) {
                    b.this.d(aVar);
                } else {
                    b.this.a(aVar, true, true);
                }
            }
        });
        afV();
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void c(com.iqoption.feed.feedlist.e eVar) {
        yo yoVar = (yo) DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.macro_feed_options, this.clF.bTt, false);
        yoVar.bvN.setTranslationY((float) getResources().getDimensionPixelOffset(R.dimen.dp160));
        yoVar.getRoot().setTag("OPTIONS_VIEW");
        this.clF.bTt.addView(yoVar.getRoot());
        yoVar.bvN.animate().translationY(0.0f).setInterpolator(new AccelerateInterpolator()).setDuration(150).start();
        yoVar.bvO.setOnClickListener(new m(this, eVar, yoVar));
        yoVar.bvL.setOnClickListener(new n(this, eVar, yoVar));
        yoVar.bvM.setOnClickListener(new o(this, eVar, yoVar));
        yoVar.bKV.setOnTouchListener(new p(this, yoVar));
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void a(com.iqoption.feed.feedlist.e eVar, View view) {
        kt ktVar = (kt) DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.feed_options, null, false);
        View root = ktVar.getRoot();
        com.iqoption.core.ext.a.N(root);
        com.iqoption.widget.a.a aVar = new com.iqoption.widget.a.a();
        aVar.g(root, root.getMeasuredWidth(), root.getMeasuredHeight());
        ktVar.bvO.setOnClickListener(new q(this, eVar, aVar));
        ktVar.bvL.setOnClickListener(new r(this, eVar, aVar));
        ktVar.bvM.setOnClickListener(new s(this, eVar, aVar));
        aVar.L(view);
    }

    private void d(final com.iqoption.feed.feedlist.e eVar) {
        int j = this.clD.j(eVar);
        if (j != -1) {
            com.iqoption.core.microservices.feed.response.a ags = eVar.ags();
            a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "smart-feed_news-settings-remove"), ags);
            ((Snackbar) Snackbar.make(this.clF.getRoot(), (int) R.string.you_wont_see_this_post, 0).setAction((int) R.string.undo, new e(this, ags, eVar, j)).setActionTextColor(com.iqoption.core.ext.a.a((Fragment) this, (int) R.color.green)).addCallback(new BaseCallback<Snackbar>() {
                public void onDismissed(Snackbar snackbar, int i) {
                    if (i != 1) {
                        b.this.clI.b(eVar);
                    }
                }
            })).show();
        }
    }

    private void e(com.iqoption.feed.feedlist.e eVar) {
        a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "smart-feed_news-settings-copy"), eVar.ags());
        Object VM = eVar.ags().VM();
        if (!TextUtils.isEmpty(VM) && be.ag("FEED", VM)) {
            com.iqoption.app.a.b.cV(R.string.link_copied);
        }
    }

    private void f(com.iqoption.feed.feedlist.e eVar) {
        a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "smart-feed_news-settings-share"), eVar.ags());
        CharSequence VM = eVar.ags().VM();
        if (!TextUtils.isEmpty(VM)) {
            IntentBuilder.from(requireActivity()).setType("text/plain").setText(VM).setChooserTitle((int) R.string.share).startChooser();
        }
    }

    private void hq(@Nullable String str) {
        if (!TextUtils.isEmpty(str)) {
            Pair hr = hr(str);
            if (hr != null && hr.getFirst() != InstrumentType.UNKNOWN) {
                e(((com.iqoption.core.microservices.tradingengine.response.active.a) hr.aXF()).getActiveId(), (InstrumentType) hr.getFirst());
            }
        }
    }

    @Nullable
    private Pair<InstrumentType, com.iqoption.core.microservices.tradingengine.response.active.a> hr(@NonNull String str) {
        com.iqoption.app.helpers.a FI = com.iqoption.app.helpers.a.FI();
        for (InstrumentType instrumentType : clO) {
            com.iqoption.core.microservices.tradingengine.response.active.a a = FI.a(str, instrumentType);
            if (a != null) {
                return new Pair(instrumentType, a);
            }
        }
        return null;
    }

    private void a(@NonNull com.iqoption.core.microservices.feed.response.a aVar, boolean z, boolean z2) {
        com.iqoption.core.microservices.feed.response.c VT = aVar.VT();
        int VU = VT.VU();
        InstrumentType instrumentType = VT.getInstrumentType();
        FeedPriority VR = aVar.VR();
        com.iqoption.core.util.i.b l = i.ZZ().l("instrumentType", instrumentType).l("activeId", Integer.valueOf(VU)).l("ordering_priority", VR != null ? Integer.valueOf(VR.getServerValue()) : null);
        if (z) {
            l.l("screen_size", Integer.valueOf(z2 ^ 1));
        }
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, z ? "smart-feed_feed-trade" : "smart-feed_news-trade").setParameters(l.aab()).setValue(Double.valueOf((double) VT.getAction())).build());
        e(VU, instrumentType);
    }

    private void e(int i, InstrumentType instrumentType) {
        com.iqoption.core.microservices.tradingengine.response.active.a a = com.iqoption.app.helpers.a.FI().a(Integer.valueOf(i), instrumentType);
        if (a != null) {
            onBackPressed();
            com.iqoption.app.managers.tab.a.Il().d(a.getActiveId(), a.getInstrumentType());
        }
    }

    private void e(com.iqoption.core.microservices.feed.response.a aVar) {
        a(aVar.VN(), aVar);
    }

    private void afY() {
        if (VERSION.SDK_INT < 23 || this.clJ.isStreamMute(3)) {
            this.clJ.setStreamMute(3, true);
        } else {
            try {
                this.clJ.adjustStreamVolume(3, -100, 0);
            } catch (SecurityException unused) {
            }
        }
    }

    private void afZ() {
        if (VERSION.SDK_INT >= 23) {
            try {
                this.clJ.adjustStreamVolume(3, 100, 0);
            } catch (SecurityException unused) {
                return;
            }
        }
        this.clJ.setStreamMute(3, false);
    }

    private void a(String str, @NonNull com.iqoption.core.microservices.feed.response.a aVar) {
        if (!TextUtils.isEmpty(str)) {
            FeedWebViewActivity.clx.a(requireActivity(), this, str, this.clE == 2, aVar);
        }
    }

    private void b(Configuration configuration) {
        int i = configuration.orientation;
        if (this.clE != i) {
            this.clE = i;
            if (this.clN != null) {
                this.clN.calcDuration();
                EventManager.Bm().a(this.clN.build());
                this.clN = null;
            }
            switch (i) {
                case 1:
                    this.clN = Event.Builder(Event.CATEGORY_SCREEN_OPENED, "smart-feed_full-screen");
                    this.clD.cN(true);
                    this.clF.bTt.addView(agc().getRoot());
                    d(agc().bKX);
                    return;
                case 2:
                    this.clN = Event.Builder(Event.CATEGORY_SCREEN_OPENED, "smart-feed_show");
                    this.clD.cN(false);
                    this.clF.bTt.addView(age().getRoot());
                    d(age().bKX);
                    return;
                default:
                    return;
            }
        }
    }

    private RecyclerView aga() {
        if (this.clE == 2) {
            return age().bKX;
        }
        return agc().bKX;
    }

    private void d(@NonNull RecyclerView recyclerView) {
        int i = this.aMA;
        recyclerView.setAdapter(this.clD);
        recyclerView.addOnScrollListener(this.clR);
        recyclerView.setHasFixedSize(true);
        recyclerView.removeOnChildAttachStateChangeListener(this.clQ);
        recyclerView.addOnChildAttachStateChangeListener(this.clQ);
        if (i != -1) {
            recyclerView.post(new f(recyclerView, eq(i)));
        }
        recyclerView.setRecyclerListener(g.clW);
        switch (this.clE) {
            case 1:
                if (recyclerView.getItemDecorationCount() == 0) {
                    recyclerView.addItemDecoration(new h(getResources().getDimensionPixelOffset(R.dimen.dp12)));
                    break;
                }
                break;
            case 2:
                if (recyclerView.getItemDecorationCount() == 0) {
                    recyclerView.addItemDecoration(new g(com.iqoption.core.ext.a.d((Fragment) this, (int) R.drawable.feed_item_separator), getResources().getDimensionPixelOffset(R.dimen.dp12)));
                    break;
                }
                break;
        }
        ItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        defaultItemAnimator.setChangeDuration(0);
        defaultItemAnimator.setSupportsChangeAnimations(false);
        recyclerView.setItemAnimator(defaultItemAnimator);
        c(recyclerView);
    }

    private int eq(int i) {
        if (this.clE == 1) {
            return Math.max(0, i - 1);
        }
        return Math.max(0, i + 1);
    }

    private void agb() {
        this.clK = 0;
        this.clL = true;
        this.clI.cL(false).observe(this, new h(this));
    }

    private void er(int i) {
        this.clL = true;
        this.clI.ep(i).observe(this, new i(this));
    }

    private ys agc() {
        if (this.clG == null) {
            agd();
        }
        return this.clG;
    }

    private void agd() {
        this.clG = (ys) DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.macro_smart_feed, this.clF.bTt, false);
        this.clG.awN.setOnClickListener(new j(this));
    }

    final /* synthetic */ void at(View view) {
        Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "smart-feed_full-screen-close");
        requireActivity().finish();
    }

    private abe age() {
        if (this.clH == null) {
            agf();
        }
        return this.clH;
    }

    private void agf() {
        this.clH = (abe) DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.micro_smart_feed, this.clF.bTt, false);
        com.iqoption.core.ext.a.a(this.clH.axz, new k(this));
    }

    final /* synthetic */ l as(View view) {
        startActivityForResult(new Intent(getContext(), FeedPortraitActivity.class), 256);
        return null;
    }
}
