package com.iqoption.quiz;

import android.databinding.DataBinderMapper;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import com.iqoption.quiz.ae.e;
import com.iqoption.quiz.b.ab;
import com.iqoption.quiz.b.b;
import com.iqoption.quiz.b.d;
import com.iqoption.quiz.b.f;
import com.iqoption.quiz.b.h;
import com.iqoption.quiz.b.j;
import com.iqoption.quiz.b.l;
import com.iqoption.quiz.b.n;
import com.iqoption.quiz.b.p;
import com.iqoption.quiz.b.r;
import com.iqoption.quiz.b.t;
import com.iqoption.quiz.b.v;
import com.iqoption.quiz.b.x;
import com.iqoption.quiz.b.z;

/* compiled from: DataBinderMapperImpl */
public class c extends DataBinderMapper {
    private static final SparseIntArray pc = new SparseIntArray(14);

    /* compiled from: DataBinderMapperImpl */
    private static class a {
        static final SparseArray<String> pd = new SparseArray(1);

        static {
            pd.put(b.pb, "_all");
        }
    }

    static {
        pc.put(e.quiz_question_language, 1);
        pc.put(e.winners_layout, 2);
        pc.put(e.splash_layout, 3);
        pc.put(e.online_and_life_counter_layout, 4);
        pc.put(e.quiz_rules_layout, 5);
        pc.put(e.error_layout, 6);
        pc.put(e.activity_quiz, 7);
        pc.put(e.winner_item, 8);
        pc.put(e.chat_layout, 9);
        pc.put(e.question_layout, 10);
        pc.put(e.answer_result_layout, 11);
        pc.put(e.email_layout, 12);
        pc.put(e.question_dialog_layout, 13);
        pc.put(e.quiz_chat_item, 14);
    }

    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int i) {
        i = pc.get(i);
        if (i > 0) {
            Object tag = view.getTag();
            if (tag == null) {
                throw new RuntimeException("view must have a tag");
            }
            StringBuilder stringBuilder;
            switch (i) {
                case 1:
                    if ("layout/quiz_question_language_0".equals(tag)) {
                        return new t(dataBindingComponent, view);
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("The tag for quiz_question_language is invalid. Received: ");
                    stringBuilder.append(tag);
                    throw new IllegalArgumentException(stringBuilder.toString());
                case 2:
                    if ("layout/winners_layout_0".equals(tag)) {
                        return new ab(dataBindingComponent, view);
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("The tag for winners_layout is invalid. Received: ");
                    stringBuilder.append(tag);
                    throw new IllegalArgumentException(stringBuilder.toString());
                case 3:
                    if ("layout/splash_layout_0".equals(tag)) {
                        return new x(dataBindingComponent, view);
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("The tag for splash_layout is invalid. Received: ");
                    stringBuilder.append(tag);
                    throw new IllegalArgumentException(stringBuilder.toString());
                case 4:
                    if ("layout/online_and_life_counter_layout_0".equals(tag)) {
                        return new l(dataBindingComponent, view);
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("The tag for online_and_life_counter_layout is invalid. Received: ");
                    stringBuilder.append(tag);
                    throw new IllegalArgumentException(stringBuilder.toString());
                case 5:
                    if ("layout/quiz_rules_layout_0".equals(tag)) {
                        return new v(dataBindingComponent, view);
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("The tag for quiz_rules_layout is invalid. Received: ");
                    stringBuilder.append(tag);
                    throw new IllegalArgumentException(stringBuilder.toString());
                case 6:
                    if ("layout/error_layout_0".equals(tag)) {
                        return new j(dataBindingComponent, view);
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("The tag for error_layout is invalid. Received: ");
                    stringBuilder.append(tag);
                    throw new IllegalArgumentException(stringBuilder.toString());
                case 7:
                    if ("layout/activity_quiz_0".equals(tag)) {
                        return new b(dataBindingComponent, view);
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("The tag for activity_quiz is invalid. Received: ");
                    stringBuilder.append(tag);
                    throw new IllegalArgumentException(stringBuilder.toString());
                case 8:
                    if ("layout/winner_item_0".equals(tag)) {
                        return new z(dataBindingComponent, view);
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("The tag for winner_item is invalid. Received: ");
                    stringBuilder.append(tag);
                    throw new IllegalArgumentException(stringBuilder.toString());
                case 9:
                    if ("layout/chat_layout_0".equals(tag)) {
                        return new f(dataBindingComponent, view);
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("The tag for chat_layout is invalid. Received: ");
                    stringBuilder.append(tag);
                    throw new IllegalArgumentException(stringBuilder.toString());
                case 10:
                    if ("layout/question_layout_0".equals(tag)) {
                        return new p(dataBindingComponent, view);
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("The tag for question_layout is invalid. Received: ");
                    stringBuilder.append(tag);
                    throw new IllegalArgumentException(stringBuilder.toString());
                case 11:
                    if ("layout/answer_result_layout_0".equals(tag)) {
                        return new d(dataBindingComponent, view);
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("The tag for answer_result_layout is invalid. Received: ");
                    stringBuilder.append(tag);
                    throw new IllegalArgumentException(stringBuilder.toString());
                case 12:
                    if ("layout/email_layout_0".equals(tag)) {
                        return new h(dataBindingComponent, view);
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("The tag for email_layout is invalid. Received: ");
                    stringBuilder.append(tag);
                    throw new IllegalArgumentException(stringBuilder.toString());
                case 13:
                    if ("layout/question_dialog_layout_0".equals(tag)) {
                        return new n(dataBindingComponent, view);
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("The tag for question_dialog_layout is invalid. Received: ");
                    stringBuilder.append(tag);
                    throw new IllegalArgumentException(stringBuilder.toString());
                case 14:
                    if ("layout/quiz_chat_item_0".equals(tag)) {
                        return new r(dataBindingComponent, view);
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("The tag for quiz_chat_item is invalid. Received: ");
                    stringBuilder.append(tag);
                    throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        return null;
    }

    /* JADX WARNING: Missing block: B:11:0x0022, code:
            return null;
     */
    public android.databinding.ViewDataBinding getDataBinder(android.databinding.DataBindingComponent r2, android.view.View[] r3, int r4) {
        /*
        r1 = this;
        r2 = 0;
        if (r3 == 0) goto L_0x0022;
    L_0x0003:
        r0 = r3.length;
        if (r0 != 0) goto L_0x0007;
    L_0x0006:
        goto L_0x0022;
    L_0x0007:
        r0 = pc;
        r4 = r0.get(r4);
        if (r4 <= 0) goto L_0x0021;
    L_0x000f:
        r4 = 0;
        r3 = r3[r4];
        r3 = r3.getTag();
        if (r3 != 0) goto L_0x0021;
    L_0x0018:
        r2 = new java.lang.RuntimeException;
        r3 = "view must have a tag";
        r2.<init>(r3);
        throw r2;
    L_0x0021:
        return r2;
    L_0x0022:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.quiz.c.getDataBinder(android.databinding.DataBindingComponent, android.view.View[], int):android.databinding.ViewDataBinding");
    }

    public int getLayoutId(String str) {
        if (str == null) {
            return 0;
        }
        switch (str.hashCode()) {
            case -2038978781:
                if (str.equals("layout/email_layout_0")) {
                    return e.email_layout;
                }
                break;
            case -1923427762:
                if (str.equals("layout/splash_layout_0")) {
                    return e.splash_layout;
                }
                break;
            case -1795611541:
                if (str.equals("layout/winners_layout_0")) {
                    return e.winners_layout;
                }
                break;
            case -1411230371:
                if (str.equals("layout/quiz_question_language_0")) {
                    return e.quiz_question_language;
                }
                break;
            case -1255627537:
                if (str.equals("layout/question_layout_0")) {
                    return e.question_layout;
                }
                break;
            case -1029345754:
                if (str.equals("layout/quiz_chat_item_0")) {
                    return e.quiz_chat_item;
                }
                break;
            case -521074414:
                if (str.equals("layout/online_and_life_counter_layout_0")) {
                    return e.online_and_life_counter_layout;
                }
                break;
            case -464763937:
                if (str.equals("layout/winner_item_0")) {
                    return e.winner_item;
                }
                break;
            case -387474889:
                if (str.equals("layout/error_layout_0")) {
                    return e.error_layout;
                }
                break;
            case 7533373:
                if (str.equals("layout/chat_layout_0")) {
                    return e.chat_layout;
                }
                break;
            case 124432449:
                if (str.equals("layout/answer_result_layout_0")) {
                    return e.answer_result_layout;
                }
                break;
            case 171883102:
                if (str.equals("layout/question_dialog_layout_0")) {
                    return e.question_dialog_layout;
                }
                break;
            case 556751633:
                if (str.equals("layout/activity_quiz_0")) {
                    return e.activity_quiz;
                }
                break;
            case 1931069288:
                if (str.equals("layout/quiz_rules_layout_0")) {
                    return e.quiz_rules_layout;
                }
                break;
        }
        return 0;
    }

    public String convertBrIdToString(int i) {
        return (String) a.pd.get(i);
    }
}
