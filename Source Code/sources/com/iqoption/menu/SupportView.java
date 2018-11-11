package com.iqoption.menu;

import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.google.android.gms.analytics.HitBuilders.ScreenViewBuilder;
import com.google.android.gms.analytics.Tracker;
import com.iqoption.a.u;
import com.iqoption.a.v;
import com.iqoption.analytics.EventManager;
import com.iqoption.app.IQApp;
import com.iqoption.chat.ChatActivity;
import com.iqoption.dto.Event;
import com.iqoption.dto.SupportMessage;
import com.iqoption.dto.SupportSubject;
import com.iqoption.mobbtech.connect.RequestManager;
import com.iqoption.mobbtech.connect.request.a.a.a;
import com.iqoption.mobbtech.connect.response.g;
import com.iqoption.mobbtech.connect.response.h;
import com.iqoption.view.d.b;
import com.iqoption.view.spinner.AwesomeTextSpinner;
import com.iqoption.x.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SupportView extends FrameLayout {
    private FragmentActivity aik;
    private ProgressBar bly;
    private List<SupportSubject> cOO;
    private Button cOP;
    private Button cOQ;
    private ListView cOR;
    private TextView cOS;
    private View cOT;
    private EditText cOU;
    private AwesomeTextSpinner cOV;
    private View cOW;
    private ListView cOX;
    private EditText cOY;
    private v cOZ;
    private u cPa;
    private Mode cPb;
    private long cPc;
    private b cPd;
    private b cPe;
    private b cPf;
    private b cPg;

    private enum Mode {
        OVERVIEW,
        CHAT,
        NEW_MESSAGE
    }

    public SupportView(FragmentActivity fragmentActivity) {
        this(fragmentActivity, null);
    }

    public SupportView(FragmentActivity fragmentActivity, AttributeSet attributeSet) {
        this(fragmentActivity, attributeSet, 0);
    }

    public SupportView(FragmentActivity fragmentActivity, AttributeSet attributeSet, int i) {
        super(fragmentActivity, attributeSet, i);
        this.cOO = new ArrayList();
        this.cPd = new b() {
            public void q(View view) {
                SupportView.this.a(null, Long.valueOf(SupportView.this.cPc), SupportView.this.cOY.getText().toString());
                EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "support-old-dialog_send-message").build());
            }
        };
        this.cPe = new b() {
            public void q(View view) {
                ChatActivity.aZ(SupportView.this.aik);
            }
        };
        this.cPf = new b() {
            public void q(View view) {
                SupportView.this.setMode(Mode.NEW_MESSAGE);
                EventManager.Bm().a(new Event(Event.CATEGORY_BUTTON_PRESSED, "support_create-dialog"));
            }
        };
        this.cPg = new b() {
            public void q(View view) {
                SupportView.this.a(((SupportSubject) SupportView.this.cOO.get(SupportView.this.cOV.getSelection())).name, null, SupportView.this.cOU.getText().toString());
                EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "support-new-dialog_send").build());
            }
        };
        this.aik = fragmentActivity;
        LayoutInflater.from(getContext()).inflate(R.layout.support_view, this, true);
        aep();
        setMode(Mode.OVERVIEW);
        Tracker aP = IQApp.aP(getContext());
        aP.setScreenName("Support page");
        aP.send(((ScreenViewBuilder) new ScreenViewBuilder().setCustomDimension(2, aP.get("&cid"))).build());
    }

    private void u(final Long l) {
        arc();
        HashMap hashMap = new HashMap();
        if (l != null) {
            hashMap.put("pid", l);
        }
        hashMap.put("l", Integer.valueOf(999));
        hashMap.put("p", Integer.valueOf(0));
        String clusterApi = IQApp.Dl().getClusterApi();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(clusterApi);
        stringBuilder.append("api/ticket/list");
        new a(RequestManager.b(stringBuilder.toString(), hashMap, getContext()), new com.iqoption.mobbtech.connect.a.a() {
            /* renamed from: a */
            public void onSuccess(h hVar) {
                SupportView.this.ard();
                try {
                    SupportView.this.cOO.clear();
                    JSONObject jSONObject = hVar.auV().getJSONObject("result");
                    JSONArray jSONArray = jSONObject.getJSONArray("subjects");
                    int i = 0;
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        SupportView.this.cOO.add(new SupportSubject(jSONArray.getJSONObject(i2)));
                    }
                    BaseAdapter arrayAdapter = new ArrayAdapter(SupportView.this.aik, R.layout.dark_string_item, R.id.name, SupportView.this.cOO);
                    SupportView.this.cOV.setAdapter(arrayAdapter);
                    if (!arrayAdapter.isEmpty()) {
                        SupportView.this.cOV.setSelection(0);
                    }
                    List arrayList = new ArrayList();
                    JSONArray jSONArray2 = jSONObject.getJSONArray("tickets");
                    while (i < jSONArray2.length()) {
                        arrayList.add(new SupportMessage(jSONArray2.getJSONObject(i)));
                        i++;
                    }
                    Collections.sort(arrayList, new Comparator<SupportMessage>() {
                        /* renamed from: a */
                        public int compare(SupportMessage supportMessage, SupportMessage supportMessage2) {
                            return supportMessage.created.compareTo(supportMessage2.created);
                        }
                    });
                    if (l == null) {
                        SupportView.this.cOZ.y(arrayList);
                        SupportView.this.cOZ.notifyDataSetChanged();
                    } else {
                        SupportView.this.cPa.y(arrayList);
                        SupportView.this.cPa.notifyDataSetChanged();
                    }
                } catch (JSONException unused) {
                }
            }

            public void a(g gVar) {
                SupportView.this.ard();
            }
        }, "api/ticket/list").auG();
    }

    private void aep() {
        findViewById(R.id.backButton).setOnClickListener(new e(this));
        this.bly = (ProgressBar) findViewById(R.id.progress);
        this.cOQ = (Button) findViewById(R.id.newMessage);
        this.cOR = (ListView) findViewById(R.id.overviewListView);
        this.cOS = (TextView) findViewById(R.id.overviewEmptyText);
        this.cOR.setEmptyView(this.cOS);
        this.cOR.setOnItemClickListener(new f(this));
        this.cOZ = new v(this.aik, null);
        this.cOR.setAdapter(this.cOZ);
        this.cOT = findViewById(R.id.newMessageLayout);
        this.cOU = (EditText) findViewById(R.id.newMessageEdit);
        this.cOU.setHorizontallyScrolling(false);
        this.cOU.setMaxLines(100);
        this.cOU.setOnClickListener(g.cni);
        this.cOV = (AwesomeTextSpinner) findViewById(R.id.subjectSpinner);
        this.cOV.setItemSelectedListener(new AwesomeTextSpinner.a() {
            public void fi(int i) {
                EventManager.Bm().a(Event.Builder(Event.CATEGORY_DROPDOWN_CHANGED, "support-new-dialog_change-subject").setValue(Double.valueOf((double) ((SupportSubject) SupportView.this.cOO.get(i)).id)).build());
            }
        });
        this.cOW = findViewById(R.id.chatLayout);
        this.cOX = (ListView) findViewById(R.id.chatListView);
        this.cPa = new u(this.aik, null);
        this.cOX.setAdapter(this.cPa);
        this.cOY = (EditText) findViewById(R.id.chatMessageEdit);
        this.cOY.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                EventManager.Bm().a(Event.Builder(Event.CATEGORY_TEXT_CHANGED, "support-old-dialog_new-message").build());
            }
        });
        this.cOY.setEnabled(false);
        this.cOP = (Button) findViewById(R.id.sendMessage);
        this.cOP.setText(R.string.go_to_chats);
        this.cOP.setOnClickListener(this.cPe);
    }

    final /* synthetic */ void bt(View view) {
        this.aik.onBackPressed();
    }

    public boolean onBackPressed() {
        if (this.cPb != Mode.CHAT && this.cPb != Mode.NEW_MESSAGE) {
            return false;
        }
        setMode(Mode.OVERVIEW);
        return true;
    }

    protected void setMode(Mode mode) {
        this.cPb = mode;
        switch (mode) {
            case OVERVIEW:
                u(null);
                this.cOR.setVisibility(0);
                this.cOT.setVisibility(4);
                this.cOW.setVisibility(4);
                this.cOQ.setVisibility(0);
                this.cOQ.setText(R.string.go_to_chats);
                this.cOQ.setOnClickListener(this.cPe);
                return;
            case NEW_MESSAGE:
                this.cOR.setVisibility(4);
                this.cOT.setVisibility(0);
                this.cOW.setVisibility(4);
                this.cOQ.setVisibility(0);
                this.cOQ.setText(R.string.send);
                this.cOQ.setOnClickListener(this.cPg);
                return;
            case CHAT:
                this.cOR.setVisibility(4);
                this.cOT.setVisibility(4);
                this.cOW.setVisibility(0);
                this.cOQ.setVisibility(4);
                this.cOQ.setOnClickListener(null);
                u(Long.valueOf(this.cPc));
                return;
            default:
                return;
        }
    }

    private void a(String str, final Long l, String str2) {
        if (!str2.isEmpty()) {
            arc();
            HashMap hashMap = new HashMap();
            if (str != null) {
                hashMap.put("subject", str);
            }
            if (l != null) {
                hashMap.put("pid", l);
            }
            hashMap.put("question", str2);
            str = IQApp.Dl().getClusterApi();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("api/ticket/send");
            new a(RequestManager.b(stringBuilder.toString(), hashMap, getContext()), new com.iqoption.mobbtech.connect.a.a() {
                /* renamed from: a */
                public void onSuccess(h hVar) {
                    SupportView.this.ard();
                    if (l == null) {
                        SupportView.this.setMode(Mode.OVERVIEW);
                    } else {
                        SupportView.this.u(l);
                    }
                    SupportView.this.cOY.setText("");
                    SupportView.this.cOU.setText("");
                    SupportView.this.cOX.smoothScrollToPosition(SupportView.this.cOX.getCount() - 1);
                    com.iqoption.app.a.b.b(SupportView.this.getResources().getString(R.string.ticket_created), SupportView.this.getContext());
                }

                public void a(g gVar) {
                    SupportView.this.ard();
                    try {
                        com.iqoption.app.a.b.b(gVar.auS().getString("message"), SupportView.this.aik);
                    } catch (Exception unused) {
                        com.iqoption.app.a.b.aT(SupportView.this.aik);
                    }
                }
            }, "api/ticket/send").auG();
        }
    }

    public void b(long j, int i) {
        this.cPa.b(j, i);
        this.cPa.notifyDataSetChanged();
    }

    public void arc() {
        this.cOP.setEnabled(false);
        this.cOQ.setEnabled(false);
        this.cOS.setVisibility(8);
        this.bly.setVisibility(0);
    }

    public void ard() {
        this.cOP.setEnabled(true);
        this.cOQ.setEnabled(true);
        this.cOS.setVisibility(0);
        this.bly.setVisibility(8);
    }
}
