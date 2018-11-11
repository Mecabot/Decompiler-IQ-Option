package com.iqoption.chat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import com.iqoption.chat.fragment.RoomListFragment.b;
import com.iqoption.chat.fragment.ab;
import com.iqoption.chat.fragment.x;
import com.iqoption.microservice.chat.ChatRoomType;
import com.iqoption.microservice.chat.n;
import com.iqoption.util.am;
import com.iqoption.x.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00172\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0005J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016J\u0012\u0010\u0010\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, aXE = {"Lcom/iqoption/chat/ChatActivity;", "Landroid/support/v7/app/AppCompatActivity;", "Lcom/iqoption/chat/fragment/SearchRoomFragment$InteractionListener;", "Lcom/iqoption/chat/fragment/RoomListFragment$InteractionListener;", "Lcom/iqoption/chat/fragment/RoomFragment$InteractionListener;", "()V", "backListeners", "", "Lcom/iqoption/view/BackController$OnBackListener;", "addBackListener", "", "onBackListener", "doBack", "onBackPressed", "onCloseChat", "onCloseChats", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onOpenChat", "chat", "Lcom/iqoption/microservice/chat/ChatRoom;", "removeBackListener", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: ChatActivity.kt */
public final class ChatActivity extends AppCompatActivity implements b, ab.b, x.b {
    private static final String TAG = "com.iqoption.chat.ChatActivity";
    public static final a aCF = new a();
    private final List<com.iqoption.view.e.a> aCE = new ArrayList();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \u0007*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, aXE = {"Lcom/iqoption/chat/ChatActivity$Companion;", "", "()V", "EXTRA_ROOM_ID", "", "EXTRA_ROOM_TYPE", "TAG", "kotlin.jvm.PlatformType", "openChat", "", "context", "Landroid/content/Context;", "roomId", "roomType", "Lcom/iqoption/microservice/chat/ChatRoomType;", "openChats", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: ChatActivity.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final void aZ(Context context) {
            h.e(context, "context");
            context.startActivity(new Intent(context, ChatActivity.class).addFlags(536870912));
        }

        public final void a(Context context, String str, ChatRoomType chatRoomType) {
            h.e(context, "context");
            h.e(chatRoomType, "roomType");
            context.startActivity(new Intent(context, ChatActivity.class).addFlags(536870912).putExtra("extra.roomId", str).putExtra("extra.roomType", chatRoomType.ordinal()));
        }
    }

    public static final void a(Context context, String str, ChatRoomType chatRoomType) {
        aCF.a(context, str, chatRoomType);
    }

    public static final void aZ(Context context) {
        aCF.aZ(context);
    }

    public void a(com.iqoption.view.e.a aVar) {
        h.e(aVar, "onBackListener");
        this.aCE.add(0, aVar);
    }

    public void b(com.iqoption.view.e.a aVar) {
        h.e(aVar, "onBackListener");
        this.aCE.remove(aVar);
    }

    public void Oo() {
        Oq();
    }

    public void c(n nVar) {
        h.e(nVar, "chat");
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        h.d(supportFragmentManager, "supportFragmentManager");
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        h.d(beginTransaction, "ft");
        x a = x.aIp.a(nVar.getId(), nVar.Qh());
        String Ll = x.aIp.Ll();
        beginTransaction.add(R.id.contentLayer, a, Ll);
        beginTransaction.addToBackStack(Ll);
        beginTransaction.commitAllowingStateLoss();
        supportFragmentManager.executePendingTransactions();
    }

    public void Op() {
        Oq();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_chat);
        if (bundle == null) {
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            h.d(supportFragmentManager, "supportFragmentManager");
            FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
            h.d(beginTransaction, "ft");
            String stringExtra = getIntent().getStringExtra("extra.roomId");
            if (stringExtra != null || getIntent().hasExtra("extra.roomType")) {
                beginTransaction.add(R.id.contentLayer, x.aIp.a(stringExtra, ChatRoomType.values()[getIntent().getIntExtra("extra.roomType", 0)]), x.aIp.Ll());
            } else {
                beginTransaction.add(R.id.contentLayer, new ab(), ab.aIT.Ll());
            }
            beginTransaction.commitAllowingStateLoss();
            supportFragmentManager.executePendingTransactions();
        }
    }

    public void onBackPressed() {
        for (com.iqoption.view.e.a onBackPressed : this.aCE) {
            if (onBackPressed.onBackPressed()) {
                return;
            }
        }
        Oq();
    }

    private final void Oq() {
        am.n(this);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        h.d(supportFragmentManager, "supportFragmentManager");
        if (supportFragmentManager.getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        } else {
            finish();
        }
    }
}
