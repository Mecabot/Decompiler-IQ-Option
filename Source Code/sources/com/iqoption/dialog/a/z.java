package com.iqoption.dialog.a;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.common.collect.ImmutableList;
import com.iqoption.dialog.a.a.d;
import com.iqoption.dto.Point;

/* compiled from: ComponentFactory */
interface z {
    @NonNull
    View a(LayoutInflater layoutInflater, ViewGroup viewGroup);

    void a(@NonNull d dVar, @NonNull ImmutableList<Point> immutableList);

    @NonNull
    Adapter aeF();

    @NonNull
    View b(LayoutInflater layoutInflater, ViewGroup viewGroup);

    @Nullable
    d c(LayoutInflater layoutInflater, ViewGroup viewGroup);
}
