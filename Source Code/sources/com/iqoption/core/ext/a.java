package com.iqoption.core.ext;

import android.animation.Animator;
import android.app.DownloadManager;
import android.app.NotificationManager;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.Settings.Global;
import android.support.annotation.AttrRes;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.FontRes;
import android.support.annotation.IntegerRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.InputFilter;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.EditText;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.iqoption.core.data.b.c;
import com.iqoption.core.f;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000Ä\u0003\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\"\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0014\u001a/\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020\u00012\u0006\u0010V\u001a\u00020\u00012\u0017\u0010W\u001a\u0013\u0012\u0004\u0012\u00020Y\u0012\u0004\u0012\u00020Z0X¢\u0006\u0002\b[\u001a\u000e\u0010\\\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020]\u001a$\u0010^\u001a\u00020_2\b\b\u0002\u0010`\u001a\u00020\u00012\b\b\u0002\u0010a\u001a\u00020\u00012\b\b\u0002\u0010b\u001a\u00020\u0001\u001a$\u0010c\u001a\u00020d2\b\b\u0002\u0010`\u001a\u00020\u00012\b\b\u0002\u0010a\u001a\u00020\u00012\b\b\u0002\u0010e\u001a\u00020]\u001a.\u0010f\u001a\u0002Hg\"\n\b\u0000\u0010g\u0018\u0001*\u00020h2\u0006\u0010i\u001a\u00020\f2\n\b\u0002\u0010j\u001a\u0004\u0018\u00010kH\b¢\u0006\u0002\u0010l\u001a.\u0010f\u001a\u0002Hg\"\n\b\u0000\u0010g\u0018\u0001*\u00020h2\u0006\u0010m\u001a\u00020\u000b2\n\b\u0002\u0010j\u001a\u0004\u0018\u00010kH\b¢\u0006\u0002\u0010n\u001a\u000e\u0010o\u001a\u00020p2\u0006\u0010q\u001a\u00020r\u001a\t\u0010s\u001a\u00020pH\b\u001a\t\u0010t\u001a\u00020pH\b\u001a\u0006\u0010u\u001a\u00020p\u001a\t\u0010v\u001a\u00020pH\b\u001a\t\u0010w\u001a\u00020pH\b\u001a\u001f\u0010x\u001a\b\u0012\u0004\u0012\u0002Hg0y\"\u0004\b\u0000\u0010g2\u0006\u0010z\u001a\u0002Hg¢\u0006\u0002\u0010{\u001a\u001f\u0010|\u001a\b\u0012\u0004\u0012\u0002Hg0}\"\u0004\b\u0000\u0010g2\u0006\u0010z\u001a\u0002Hg¢\u0006\u0002\u0010~\u001a\u0015\u0010\u001a\u00020Z*\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001\u001a\u000b\u0010\u0001\u001a\u00020\u0001*\u00020\u0001\u001a\u0016\u0010\u0001\u001a\u00030\u0001*\u00020\u00012\b\b\u0002\u0010#\u001a\u00020 \u001a\u0016\u0010\u0001\u001a\u00030\u0001*\u00020\u00012\b\u0010\u0001\u001a\u00030\u0001\u001a\u000b\u0010\u0001\u001a\u00020Z*\u00020\u0016\u001a\u0018\u0010\u0001\u001a\u00020\u0001*\u00020 2\t\b\u0001\u0010\u0001\u001a\u00020\u0001H\u0007\u001a\u0017\u0010\u0001\u001a\u00030\u0001*\u00020 2\t\b\u0001\u0010\u0001\u001a\u00020\u0001\u001a4\u0010\u0001\u001a\u00020Z*\u0002012\t\b\u0002\u0010\u0001\u001a\u00020p2\u0019\u0010\u0001\u001a\u0014\u0012\u0005\u0012\u00030\u0001\u0012\u0004\u0012\u00020Z0X¢\u0006\u0002\b[H\b\u001a4\u0010\u0001\u001a\u00020Z*\u0002012\t\b\u0002\u0010\u0001\u001a\u00020p2\u0019\u0010\u0001\u001a\u0014\u0012\u0005\u0012\u00030\u0001\u0012\u0004\u0012\u00020Z0X¢\u0006\u0002\b[H\b\u001a\u000f\u0010\u0001\u001a\u00020\u0001*\u00030\u0001H\u0002\u001a\u000f\u0010\u0001\u001a\u00020]*\u00030\u0001H\u0002\u001a\u000f\u0010\u0001\u001a\u00020\u0001*\u00030\u0001H\u0002\u001a\u000e\u0010\u0001\u001a\u00020\u0001*\u00020\u0001H\u0002\u001a\u000e\u0010\u0001\u001a\u00020\u0003*\u00020\u0003H\u0002\u001a\u000f\u0010\u0001\u001a\u00020\u0001*\u00030\u0001H\u0002\u001a\u000f\u0010\u0001\u001a\u00020]*\u00030\u0001H\u0002\u001a\u000f\u0010\u0001\u001a\u00020\u0001*\u00030\u0001H\u0002\u001a\u000e\u0010\u0001\u001a\u00020\u0001*\u00020\u0001H\u0002\u001a\u000e\u0010\u0001\u001a\u00020\u0003*\u00020\u0003H\u0002\u001a\u000f\u0010\u0001\u001a\u00020\u0001*\u00030\u0001H\u0002\u001a\u000f\u0010\u0001\u001a\u00020]*\u00030\u0001H\u0002\u001a\u000e\u0010\u0001\u001a\u00020\u0001*\u00020\u0001H\u0002\u001a\u000e\u0010\u0001\u001a\u00020\u0003*\u00020\u0003H\u0002\u001a\u000f\u0010\u0001\u001a\u00020\u0001*\u00030\u0001H\u0002\u001a\u000f\u0010\u0001\u001a\u00020]*\u00030\u0001H\u0002\u001a\u000e\u0010\u0001\u001a\u00020\u0001*\u00020\u0001H\u0002\u001a\u000e\u0010\u0001\u001a\u00020\u0003*\u00020\u0003H\u0002\u001a\u0015\u0010\u0001\u001a\u00020Z*\u00030\u00012\u0007\u0010\u0001\u001a\u00020p\u001a\f\u0010\u0001\u001a\u00020Z*\u00030\u0001\u001a3\u0010\u0001\u001a\u00020Z*\u00030\u00012\u0010\b\u0004\u0010 \u0001\u001a\t\u0012\u0004\u0012\u00020p0¡\u00012\u0010\b\u0004\u0010¢\u0001\u001a\t\u0012\u0004\u0012\u00020Z0¡\u0001H\b\u001a!\u0010\u0001\u001a\u00020Z*\u00030\u00012\u0010\b\u0004\u0010¢\u0001\u001a\t\u0012\u0004\u0012\u00020Z0¡\u0001H\b\u001a!\u0010£\u0001\u001a\u00020Z*\u00030\u00012\u0010\b\u0004\u0010¢\u0001\u001a\t\u0012\u0004\u0012\u00020p0¡\u0001H\b\u001a!\u0010¤\u0001\u001a\u00020Z*\u00030\u00012\u0010\b\u0004\u0010¢\u0001\u001a\t\u0012\u0004\u0012\u00020Z0¡\u0001H\b\u001a\u0016\u0010¥\u0001\u001a\u00020\u0014*\u00020 2\t\b\u0001\u0010\u0001\u001a\u00020\u0001\u001a+\u0010¦\u0001\u001a\u00020Z*\u00030§\u00012\u001a\u0010\u0001\u001a\u0015\u0012\u0005\u0012\u00030¨\u0001\u0012\u0005\u0012\u00030¨\u00010X¢\u0006\u0002\b[H\b\u001a\f\u0010©\u0001\u001a\u00020Z*\u00030\u0001\u001a\f\u0010ª\u0001\u001a\u00020Z*\u00030\u0001\u001a\u0015\u0010«\u0001\u001a\u00020Z*\u00030\u00012\u0007\u0010\u0001\u001a\u00020p\u001a\u001d\u0010¬\u0001\u001a\u0002Hg\"\t\b\u0000\u0010g*\u00030­\u0001*\u00030\u0001¢\u0006\u0003\u0010®\u0001\u001a\u001d\u0010¯\u0001\u001a\u000201*\u00020\f2\u0010\u0010°\u0001\u001a\u000b\u0012\u0006\b\u0001\u0012\u00020\f0±\u0001\u001a/\u0010²\u0001\u001a\u0004\u0018\u0001Hg\"\b\b\u0000\u0010g*\u00020\f*\u00020\f2\u0010\u0010°\u0001\u001a\u000b\u0012\u0006\b\u0001\u0012\u0002Hg0±\u0001¢\u0006\u0003\u0010³\u0001\u001a\u001d\u0010´\u0001\u001a\u000201*\u00020\f2\u0010\u0010°\u0001\u001a\u000b\u0012\u0006\b\u0001\u0012\u00020\f0±\u0001\u001a-\u0010µ\u0001\u001a\u0002Hg\"\b\b\u0000\u0010g*\u00020\f*\u00020\f2\u0010\u0010°\u0001\u001a\u000b\u0012\u0006\b\u0001\u0012\u0002Hg0±\u0001¢\u0006\u0003\u0010³\u0001\u001a/\u0010¶\u0001\u001a\u0004\u0018\u0001Hg\"\b\b\u0000\u0010g*\u00020\f*\u00020\f2\u0010\u0010°\u0001\u001a\u000b\u0012\u0006\b\u0001\u0012\u0002Hg0±\u0001¢\u0006\u0003\u0010³\u0001\u001a[\u0010·\u0001\u001a\u00020Z\"\u0004\b\u0000\u0010g*\t\u0012\u0004\u0012\u0002Hg0¸\u00012>\u0010\u0001\u001a9\u0012\u0016\u0012\u0014Hg¢\u0006\u000f\bº\u0001\u0012\n\b»\u0001\u0012\u0005\b\b(¼\u0001\u0012\u0016\u0012\u00140\u0001¢\u0006\u000f\bº\u0001\u0012\n\b»\u0001\u0012\u0005\b\b(½\u0001\u0012\u0004\u0012\u00020Z0¹\u0001H\b\u001a%\u0010·\u0001\u001a\u00020Z*\u00030\u00012\u0014\u0010¢\u0001\u001a\u000f\u0012\u0005\u0012\u00030\u0001\u0012\u0004\u0012\u00020Z0XH\b\u001aB\u0010¾\u0001\u001a\u00020Z\"\u0004\b\u0000\u0010g*\t\u0012\u0004\u0012\u0002Hg0¸\u00012%\u0010\u0001\u001a \u0012\u0016\u0012\u0014Hg¢\u0006\u000f\bº\u0001\u0012\n\b»\u0001\u0012\u0005\b\b(¼\u0001\u0012\u0004\u0012\u00020Z0XH\b\u001a:\u0010¿\u0001\u001a\u00020Z*\u0007\u0012\u0002\b\u00030¸\u00012%\u0010\u0001\u001a \u0012\u0016\u0012\u00140\u0001¢\u0006\u000f\bº\u0001\u0012\n\b»\u0001\u0012\u0005\b\b(½\u0001\u0012\u0004\u0012\u00020Z0XH\b\u001a\f\u0010À\u0001\u001a\u00020T*\u00030\u0001\u001a\u0016\u0010Á\u0001\u001a\u00020\u0001*\u00030\u00012\b\u0010Â\u0001\u001a\u00030\u0001\u001a\u0018\u0010Ã\u0001\u001a\u00020\u0001*\u00020h2\t\b\u0001\u0010\u0001\u001a\u00020\u0001H\u0007\u001a\u0019\u0010Ã\u0001\u001a\u00020\u0001*\u00030­\u00012\t\b\u0001\u0010\u0001\u001a\u00020\u0001H\u0007\u001a\u0018\u0010Ã\u0001\u001a\u00020\u0001*\u00020\f2\t\b\u0001\u0010\u0001\u001a\u00020\u0001H\u0007\u001a\u0019\u0010Ã\u0001\u001a\u00020\u0001*\u00030Ä\u00012\t\b\u0001\u0010\u0001\u001a\u00020\u0001H\u0007\u001a\u0019\u0010Ã\u0001\u001a\u00020\u0001*\u00030\u00012\t\b\u0001\u0010\u0001\u001a\u00020\u0001H\u0007\u001a\u0019\u0010Å\u0001\u001a\u00020\u0001*\u00030\u00012\t\b\u0001\u0010\u0001\u001a\u00020\u0001H\u0007\u001a\u0017\u0010Æ\u0001\u001a\u00030\u0001*\u00020h2\t\b\u0001\u0010\u0001\u001a\u00020\u0001\u001a\u0018\u0010Æ\u0001\u001a\u00030\u0001*\u00030­\u00012\t\b\u0001\u0010\u0001\u001a\u00020\u0001\u001a\u0017\u0010Æ\u0001\u001a\u00030\u0001*\u00020\f2\t\b\u0001\u0010\u0001\u001a\u00020\u0001\u001a\u0018\u0010Æ\u0001\u001a\u00030\u0001*\u00030Ä\u00012\t\b\u0001\u0010\u0001\u001a\u00020\u0001\u001a\u0018\u0010Æ\u0001\u001a\u00030\u0001*\u00030\u00012\t\b\u0001\u0010\u0001\u001a\u00020\u0001\u001a\u0018\u0010Ç\u0001\u001a\u0004\u0018\u00010\u0014*\u00020h2\t\b\u0001\u0010\u0001\u001a\u00020\u0001\u001a\u0017\u0010Ç\u0001\u001a\u00020\u0014*\u00030­\u00012\t\b\u0001\u0010\u0001\u001a\u00020\u0001\u001a\u0016\u0010Ç\u0001\u001a\u00020\u0014*\u00020\f2\t\b\u0001\u0010\u0001\u001a\u00020\u0001\u001a\u0017\u0010Ç\u0001\u001a\u00020\u0014*\u00030Ä\u00012\t\b\u0001\u0010\u0001\u001a\u00020\u0001\u001a\u0017\u0010Ç\u0001\u001a\u00020\u0014*\u00030\u00012\t\b\u0001\u0010\u0001\u001a\u00020\u0001\u001a\u001a\u0010È\u0001\u001a\u0005\u0018\u00010\u0001*\u00030\u00012\t\b\u0002\u0010É\u0001\u001a\u00020p\u001a\u0017\u0010Ê\u0001\u001a\u00030Ë\u0001*\u00020h2\t\b\u0001\u0010\u0001\u001a\u00020\u0001\u001a\u0017\u0010Ê\u0001\u001a\u00030Ë\u0001*\u00020 2\t\b\u0001\u0010\u0001\u001a\u00020\u0001\u001a\u0018\u0010Ê\u0001\u001a\u00030Ë\u0001*\u00030­\u00012\t\b\u0001\u0010\u0001\u001a\u00020\u0001\u001a\u0017\u0010Ê\u0001\u001a\u00030Ë\u0001*\u00020\f2\t\b\u0001\u0010\u0001\u001a\u00020\u0001\u001a\u0018\u0010Ê\u0001\u001a\u00030Ë\u0001*\u00030Ä\u00012\t\b\u0001\u0010\u0001\u001a\u00020\u0001\u001a\u0018\u0010Ê\u0001\u001a\u00030Ë\u0001*\u00030\u00012\t\b\u0001\u0010\u0001\u001a\u00020\u0001\u001a\r\u0010Ì\u0001\u001a\u00030Í\u0001*\u00030\u0001\u001a\r\u0010Î\u0001\u001a\u00030Ï\u0001*\u00030\u0001\u001a\r\u0010Ð\u0001\u001a\u00030\u0001*\u00030\u0001\u001a\r\u0010Ñ\u0001\u001a\u00030\u0001*\u00030\u0001\u001a\u0016\u0010Ò\u0001\u001a\u00020\u0001*\u00020h2\t\b\u0001\u0010\u0001\u001a\u00020\u0001\u001a\u0016\u0010Ò\u0001\u001a\u00020\u0001*\u00020 2\t\b\u0001\u0010\u0001\u001a\u00020\u0001\u001a\u0016\u0010Ò\u0001\u001a\u00020\u0001*\u00020\f2\t\b\u0001\u0010\u0001\u001a\u00020\u0001\u001a\u0017\u0010Ò\u0001\u001a\u00020\u0001*\u00030\u00012\t\b\u0001\u0010\u0001\u001a\u00020\u0001\u001a\u001d\u0010Ó\u0001\u001a\u0004\u0018\u00010\u0001*\u00030§\u00012\u0007\u0010½\u0001\u001a\u00020r¢\u0006\u0003\u0010Ô\u0001\u001a\u001d\u0010Õ\u0001\u001a\u0004\u0018\u00010\u0003*\u00030§\u00012\u0007\u0010½\u0001\u001a\u00020r¢\u0006\u0003\u0010Ö\u0001\u001a\u0016\u0010×\u0001\u001a\u00020]*\u00020h2\t\b\u0001\u0010\u0001\u001a\u00020\u0001\u001a\u0016\u0010×\u0001\u001a\u00020]*\u00020 2\t\b\u0001\u0010\u0001\u001a\u00020\u0001\u001a\u0017\u0010×\u0001\u001a\u00020]*\u00030­\u00012\t\b\u0001\u0010\u0001\u001a\u00020\u0001\u001a\u0016\u0010×\u0001\u001a\u00020]*\u00020\f2\t\b\u0001\u0010\u0001\u001a\u00020\u0001\u001a\u0017\u0010×\u0001\u001a\u00020]*\u00030Ä\u00012\t\b\u0001\u0010\u0001\u001a\u00020\u0001\u001a\u0017\u0010×\u0001\u001a\u00020]*\u00030\u00012\t\b\u0001\u0010\u0001\u001a\u00020\u0001\u001a\u0016\u0010Ø\u0001\u001a\u00020\u0001*\u00020h2\t\b\u0001\u0010\u0001\u001a\u00020\u0001\u001a\u0016\u0010Ø\u0001\u001a\u00020\u0001*\u00020 2\t\b\u0001\u0010\u0001\u001a\u00020\u0001\u001a\u0017\u0010Ø\u0001\u001a\u00020\u0001*\u00030­\u00012\t\b\u0001\u0010\u0001\u001a\u00020\u0001\u001a\u0016\u0010Ø\u0001\u001a\u00020\u0001*\u00020\f2\t\b\u0001\u0010\u0001\u001a\u00020\u0001\u001a\u0017\u0010Ø\u0001\u001a\u00020\u0001*\u00030Ä\u00012\t\b\u0001\u0010\u0001\u001a\u00020\u0001\u001a\u0017\u0010Ø\u0001\u001a\u00020\u0001*\u00030\u00012\t\b\u0001\u0010\u0001\u001a\u00020\u0001\u001a\u0015\u0010Ù\u0001\u001a\u00020\u0001*\u00030\u00012\u0007\u0010Ú\u0001\u001a\u00020\u0001\u001a\u0017\u0010Û\u0001\u001a\r Ü\u0001*\u0005\u0018\u00010\u00010\u0001*\u00030\u0001\u001a\f\u0010Ý\u0001\u001a\u00020r*\u00030\u0001\u001a\u000b\u0010Ý\u0001\u001a\u00020r*\u00020\u0016\u001a \u0010Þ\u0001\u001a\r Ü\u0001*\u0005\u0018\u00010Ä\u00010Ä\u0001*\u00030\u00012\u0007\u0010Ú\u0001\u001a\u00020\u0001\u001a\u0015\u0010ß\u0001\u001a\u00020\u0001*\u00030\u00012\u0007\u0010Ú\u0001\u001a\u00020\u0001\u001a\f\u0010à\u0001\u001a\u00020Z*\u00030\u0001\u001a\f\u0010á\u0001\u001a\u00020Z*\u00030\u0001\u001a=\u0010â\u0001\u001a\u0002Hg\"\t\b\u0000\u0010g*\u00030­\u0001*\u00020 2\u0007\u0010ã\u0001\u001a\u00020\u00012\u000b\b\u0002\u0010>\u001a\u0005\u0018\u00010\u00012\t\b\u0002\u0010ä\u0001\u001a\u00020p¢\u0006\u0003\u0010å\u0001\u001a;\u0010â\u0001\u001a\u0002Hg\"\t\b\u0000\u0010g*\u00030­\u0001*\u00020\f2\u0007\u0010ã\u0001\u001a\u00020\u00012\t\u0010>\u001a\u0005\u0018\u00010\u00012\t\b\u0002\u0010ä\u0001\u001a\u00020p¢\u0006\u0003\u0010æ\u0001\u001a;\u0010â\u0001\u001a\u0002Hg\"\t\b\u0000\u0010g*\u00030­\u0001*\u0002072\u0007\u0010ã\u0001\u001a\u00020\u00012\t\u0010>\u001a\u0005\u0018\u00010\u00012\t\b\u0002\u0010ä\u0001\u001a\u00020p¢\u0006\u0003\u0010ç\u0001\u001a<\u0010â\u0001\u001a\u0002Hg\"\t\b\u0000\u0010g*\u00030­\u0001*\u00030\u00012\u0007\u0010ã\u0001\u001a\u00020\u00012\t\u0010>\u001a\u0005\u0018\u00010\u00012\t\b\u0002\u0010ä\u0001\u001a\u00020p¢\u0006\u0003\u0010è\u0001\u001a<\u0010â\u0001\u001a\u0002Hg\"\t\b\u0000\u0010g*\u00030­\u0001*\u00030\u00012\u0007\u0010ã\u0001\u001a\u00020\u00012\t\b\u0002\u0010>\u001a\u00030\u00012\t\b\u0002\u0010ä\u0001\u001a\u00020p¢\u0006\u0003\u0010é\u0001\u001a<\u0010ê\u0001\u001a\u0002Hg\"\t\b\u0000\u0010g*\u00030\u0001*\u00030\u00012\u0007\u0010ã\u0001\u001a\u00020\u00012\t\b\u0002\u0010>\u001a\u00030\u00012\t\b\u0002\u0010ä\u0001\u001a\u00020p¢\u0006\u0003\u0010ë\u0001\u001a\f\u0010ì\u0001\u001a\u00020p*\u00030\u0001\u001a\f\u0010í\u0001\u001a\u00020p*\u00030\u0001\u001a\f\u0010î\u0001\u001a\u00020p*\u00030\u0001\u001a\u0011\u0010ï\u0001\u001a\u00030ð\u0001*\u0007\u0012\u0002\b\u00030¸\u0001\u001a\u001c\u0010ñ\u0001\u001a\u00020Z*\u00030\u00012\u0006\u0010U\u001a\u00020\u00012\u0006\u0010V\u001a\u00020\u0001\u001a\f\u0010ò\u0001\u001a\u00020Z*\u00030\u0001\u001a\f\u0010ó\u0001\u001a\u00020Z*\u00030\u0001\u001a&\u0010ô\u0001\u001a\u00020Z\"\u0004\b\u0000\u0010g*\b\u0012\u0004\u0012\u0002Hg0}2\u0007\u0010õ\u0001\u001a\u0002Hg¢\u0006\u0003\u0010ö\u0001\u001a'\u0010ô\u0001\u001a\u00020Z\"\u0004\b\u0000\u0010g*\t\u0012\u0004\u0012\u0002Hg0÷\u00012\u0007\u0010õ\u0001\u001a\u0002Hg¢\u0006\u0003\u0010ø\u0001\u001a&\u0010ù\u0001\u001a\u00030¨\u0001*\u00030¨\u00012\u0007\u0010½\u0001\u001a\u00020r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001¢\u0006\u0003\u0010ú\u0001\u001a&\u0010û\u0001\u001a\u00030¨\u0001*\u00030¨\u00012\u0007\u0010½\u0001\u001a\u00020r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\u0003\u0010ü\u0001\u001a:\u0010ý\u0001\u001a\u00020Z*\u0005\u0018\u00010þ\u00012\u0007\u0010ÿ\u0001\u001a\u00020 2\b\u0010\u0002\u001a\u00030ð\u00012\u0014\u0010\u0001\u001a\u000f\u0012\u0005\u0012\u00030\u0002\u0012\u0004\u0012\u00020Z0XH\b\u001a7\u0010\u0002\u001a\u000b\u0012\u0004\u0012\u0002Hg\u0018\u00010\u0002\"\u000b\b\u0000\u0010g\u0018\u0001*\u00030\u0002*\u00030\u00022\n\u0010\u0002\u001a\u0005\u0018\u00010\u0002H\b¢\u0006\u0003\u0010\u0002\u001a,\u0010\u0002\u001a\u000b\u0012\u0004\u0012\u0002Hg\u0018\u00010\u0002\"\t\b\u0000\u0010g*\u00030\u0002*\u00030\u00022\n\u0010\u0002\u001a\u0005\u0018\u00010\u0002\u001a,\u0010\u0002\u001a\u000b\u0012\u0004\u0012\u0002Hg\u0018\u00010\u0002\"\t\b\u0000\u0010g*\u00030\u0002*\u00030\u00022\n\u0010\u0002\u001a\u0005\u0018\u00010\u0002\u001a\u000b\u0010\u0002\u001a\u00020\u0001*\u00020\u0001\u001a(\u0010\u0002\u001a\u00020Z*\u00020Y2\u0018\u0010\u0001\u001a\u0013\u0012\u0004\u0012\u00020Y\u0012\u0004\u0012\u00020Z0X¢\u0006\u0002\b[H\b\u001a(\u0010\u0002\u001a\u00020T*\u00020T2\u0007\u0010\u0002\u001a\u00020]2\u0007\u0010\u0002\u001a\u00020]2\t\b\u0002\u0010\u0002\u001a\u00020p\u001a(\u0010\u0002\u001a\u00020T*\u00020T2\u0007\u0010\u0002\u001a\u00020\u00012\u0007\u0010\u0002\u001a\u00020\u00012\t\b\u0002\u0010\u0002\u001a\u00020p\u001a(\u0010\u0002\u001a\u00020T*\u00020T2\u0007\u0010\u0002\u001a\u00020\u00012\u0007\u0010\u0002\u001a\u00020\u00012\t\b\u0002\u0010\u0002\u001a\u00020p\u001a(\u0010\u0002\u001a\u00020T*\u00020T2\u0007\u0010\u0002\u001a\u00020\u00012\u0007\u0010\u0002\u001a\u00020\u00012\t\b\u0002\u0010\u0002\u001a\u00020p\u001a&\u0010\u0002\u001a\u0002Hg\"\t\b\u0000\u0010g*\u00030­\u0001*\u00030\u00022\u0007\u0010ã\u0001\u001a\u00020\u0001¢\u0006\u0003\u0010\u0002\u001a\u0014\u0010\u0002\u001a\u00020Z*\u00020\u00162\u0007\u0010¥\u0001\u001a\u00020\u0014\u001a\u0016\u0010\u0002\u001a\u00020Z*\u00020\u00162\t\b\u0001\u0010¥\u0001\u001a\u00020\u0001\u001a\u0014\u0010\u0002\u001a\u00020Z*\u00020\u00162\u0007\u0010¥\u0001\u001a\u00020\u0014\u001a\u0016\u0010\u0002\u001a\u00020Z*\u00020\u00162\t\b\u0001\u0010¥\u0001\u001a\u00020\u0001\u001a\u0014\u0010\u0002\u001a\u00020Z*\u00020\u00162\u0007\u0010¥\u0001\u001a\u00020\u0014\u001a\u0016\u0010\u0002\u001a\u00020Z*\u00020\u00162\t\b\u0001\u0010¥\u0001\u001a\u00020\u0001\u001a\u0014\u0010\u0002\u001a\u00020Z*\u00020\u00162\u0007\u0010¥\u0001\u001a\u00020\u0014\u001a\u0016\u0010\u0002\u001a\u00020Z*\u00020\u00162\t\b\u0001\u0010¥\u0001\u001a\u00020\u0001\u001a'\u0010\u0002\u001a\u00020Z*\u00030\u00012\u0016\b\u0004\u0010\u0001\u001a\u000f\u0012\u0005\u0012\u00030\u0001\u0012\u0004\u0012\u00020Z0XH\b\u001a(\u0010\u0002\u001a\u00020Z\"\u0004\b\u0000\u0010g*\b\u0012\u0004\u0012\u0002Hg0}2\t\u0010õ\u0001\u001a\u0004\u0018\u0001Hg¢\u0006\u0003\u0010ö\u0001\u001a'\u0010\u0002\u001a\u00020Z\"\u0004\b\u0000\u0010g*\t\u0012\u0004\u0012\u0002Hg0÷\u00012\u0007\u0010õ\u0001\u001a\u0002Hg¢\u0006\u0003\u0010ø\u0001\u001a(\u0010 \u0002\u001a\u00020Z\"\u0004\b\u0000\u0010g*\b\u0012\u0004\u0012\u0002Hg0}2\t\u0010õ\u0001\u001a\u0004\u0018\u0001Hg¢\u0006\u0003\u0010ö\u0001\u001a'\u0010 \u0002\u001a\u00020Z\"\u0004\b\u0000\u0010g*\t\u0012\u0004\u0012\u0002Hg0÷\u00012\u0007\u0010õ\u0001\u001a\u0002Hg¢\u0006\u0003\u0010ø\u0001\u001a\u0015\u0010¡\u0002\u001a\u00020Z*\u00030\u00012\u0007\u0010¢\u0002\u001a\u00020\u0001\u001a\u0015\u0010£\u0002\u001a\u00020Z*\u00030\u00012\u0007\u0010¢\u0002\u001a\u00020\u0001\u001a\u0015\u0010¤\u0002\u001a\u00020Z*\u00030\u00012\u0007\u0010¢\u0002\u001a\u00020\u0001\u001a\u0015\u0010¥\u0002\u001a\u00020Z*\u00030\u00012\u0007\u0010¢\u0002\u001a\u00020\u0001\u001a\u0015\u0010¦\u0002\u001a\u00020Z*\u00030\u00012\u0007\u0010\u0002\u001a\u00020]\u001a(\u0010§\u0002\u001a\u00020Z\"\u0004\b\u0000\u0010g*\b\u0012\u0004\u0012\u0002Hg0}2\t\u0010õ\u0001\u001a\u0004\u0018\u0001Hg¢\u0006\u0003\u0010ö\u0001\u001a\u0015\u0010¨\u0002\u001a\u00020Z*\u00030\u00012\u0007\u0010©\u0002\u001a\u00020\u0001\u001a\u0015\u0010ª\u0002\u001a\u00020Z*\u00030\u00012\u0007\u0010«\u0002\u001a\u00020]\u001a(\u0010¬\u0002\u001a\u00020Z\"\u0004\b\u0000\u0010g*\b\u0012\u0004\u0012\u0002Hg0}2\t\u0010õ\u0001\u001a\u0004\u0018\u0001Hg¢\u0006\u0003\u0010ö\u0001\u001a'\u0010¬\u0002\u001a\u00020Z\"\u0004\b\u0000\u0010g*\t\u0012\u0004\u0012\u0002Hg0÷\u00012\u0007\u0010õ\u0001\u001a\u0002Hg¢\u0006\u0003\u0010ø\u0001\u001a\f\u0010­\u0002\u001a\u00020Z*\u00030\u0001\u001a\u001b\u0010®\u0002\u001a\u00020Z\"\u000b\b\u0000\u0010g\u0018\u0001*\u00030\u0002*\u00020 H\b\u001a6\u0010®\u0002\u001a\u00020Z\"\u000b\b\u0000\u0010g\u0018\u0001*\u00030\u0002*\u00020 2\u0019\u0010¯\u0002\u001a\u0014\u0012\u0005\u0012\u00030°\u0002\u0012\u0004\u0012\u00020Z0X¢\u0006\u0002\b[H\b\u001a\u001b\u0010®\u0002\u001a\u00020Z\"\u000b\b\u0000\u0010g\u0018\u0001*\u00030\u0002*\u00020\fH\b\u001a6\u0010®\u0002\u001a\u00020Z\"\u000b\b\u0000\u0010g\u0018\u0001*\u00030\u0002*\u00020\f2\u0019\u0010¯\u0002\u001a\u0014\u0012\u0005\u0012\u00030°\u0002\u0012\u0004\u0012\u00020Z0X¢\u0006\u0002\b[H\b\u001a5\u0010±\u0002\u001a\u00020Z\"\u000b\b\u0000\u0010g\u0018\u0001*\u00030\u0002*\u00020 2\u0018\u0010²\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020Z0X¢\u0006\u0002\b[H\b\u001a5\u0010±\u0002\u001a\u00020Z\"\u000b\b\u0000\u0010g\u0018\u0001*\u00030\u0002*\u00020\f2\u0018\u0010²\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020Z0X¢\u0006\u0002\b[H\b\u001a\u0017\u0010³\u0002\u001a\u00020\u0014*\u00020\u00142\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001\u001a\u0016\u0010³\u0002\u001a\u00020\u0014*\u00020\u00142\t\b\u0001\u0010\u0001\u001a\u00020\u0001\u001a\u000b\u0010´\u0002\u001a\u00020\u0001*\u00020r\u001a\u0014\u0010µ\u0002\u001a\u00020]*\u00020h2\u0007\u0010¶\u0002\u001a\u00020]\u001a\u0014\u0010µ\u0002\u001a\u00020]*\u00020 2\u0007\u0010¶\u0002\u001a\u00020]\u001a\u0014\u0010µ\u0002\u001a\u00020]*\u00020\f2\u0007\u0010¶\u0002\u001a\u00020]\u001a\u0015\u0010µ\u0002\u001a\u00020]*\u00030\u00012\u0007\u0010¶\u0002\u001a\u00020]\u001a\u0014\u0010·\u0002\u001a\u00020\u0001*\u00020h2\u0007\u0010¶\u0002\u001a\u00020]\u001a\u0014\u0010·\u0002\u001a\u00020\u0001*\u00020 2\u0007\u0010¶\u0002\u001a\u00020]\u001a\u0014\u0010·\u0002\u001a\u00020\u0001*\u00020\f2\u0007\u0010¶\u0002\u001a\u00020]\u001a\u0015\u0010·\u0002\u001a\u00020\u0001*\u00030\u00012\u0007\u0010¶\u0002\u001a\u00020]\u001a*\u0010¸\u0002\u001a\t\u0012\u0004\u0012\u0002Hg0\u0002\"\u0006\b\u0000\u0010g\u0018\u0001*\t\u0012\u0004\u0012\u0002Hg0¸\u0001H\b¢\u0006\u0003\u0010¹\u0002\u001a$\u0010º\u0002\u001a\t\u0012\u0004\u0012\u0002Hg0\u0002\"\u0006\b\u0000\u0010g\u0018\u0001*\t\u0012\u0004\u0012\u0002Hg0¸\u0001H\b\u001a\u000b\u0010»\u0002\u001a\u00020\u0014*\u00020\u0014\u001a8\u0010¼\u0002\u001a\u00020Z\"\t\b\u0000\u0010g*\u00030\u0002*\u00030\u00022\u0010\u0010½\u0002\u001a\u000b\u0012\u0004\u0012\u0002Hg\u0018\u00010\u00022\u0007\u0010¾\u0002\u001a\u00020\u0001¢\u0006\u0003\u0010¿\u0002\u001a2\u0010À\u0002\u001a\u00020Z\"\t\b\u0000\u0010g*\u00030\u0002*\u00030\u00022\u0010\u0010Á\u0002\u001a\u000b\u0012\u0004\u0012\u0002Hg\u0018\u00010\u00022\u0007\u0010¾\u0002\u001a\u00020\u0001\u001a2\u0010Â\u0002\u001a\u00020Z\"\t\b\u0000\u0010g*\u00030\u0002*\u00030\u00022\u0010\u0010Ã\u0002\u001a\u000b\u0012\u0004\u0012\u0002Hg\u0018\u00010\u00022\u0007\u0010¾\u0002\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0015\u0010\n\u001a\u00020\u000b*\u00020\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e\"\u0015\u0010\u000f\u001a\u00020\u0010*\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\",\u0010\u0015\u001a\u0004\u0018\u00010\u0014*\u00020\u00162\b\u0010\u0013\u001a\u0004\u0018\u00010\u00148F@FX\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\",\u0010\u001b\u001a\u0004\u0018\u00010\u0014*\u00020\u00162\b\u0010\u0013\u001a\u0004\u0018\u00010\u00148F@FX\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001a\"\u0015\u0010\u001e\u001a\u00020\u001f*\u00020 8F¢\u0006\u0006\u001a\u0004\b!\u0010\"\"\u0015\u0010#\u001a\u00020 *\u00020\f8F¢\u0006\u0006\u001a\u0004\b$\u0010%\"\u0015\u0010&\u001a\u00020'*\u00020 8F¢\u0006\u0006\u001a\u0004\b(\u0010)\",\u0010*\u001a\u0004\u0018\u00010\u0014*\u00020\u00162\b\u0010\u0013\u001a\u0004\u0018\u00010\u00148F@FX\u000e¢\u0006\f\u001a\u0004\b+\u0010\u0018\"\u0004\b,\u0010\u001a\",\u0010-\u001a\u0004\u0018\u00010\u0014*\u00020\u00162\b\u0010\u0013\u001a\u0004\u0018\u00010\u00148F@FX\u000e¢\u0006\f\u001a\u0004\b.\u0010\u0018\"\u0004\b/\u0010\u001a\"\u0015\u00100\u001a\u000201*\u00020\f8F¢\u0006\u0006\u001a\u0004\b2\u00103\"\u0015\u00104\u001a\u000201*\u00020\f8F¢\u0006\u0006\u001a\u0004\b5\u00103\"\u0015\u00106\u001a\u000207*\u00020 8F¢\u0006\u0006\u001a\u0004\b8\u00109\"\u0015\u0010:\u001a\u00020;*\u00020 8F¢\u0006\u0006\u001a\u0004\b<\u0010=\"\u0015\u0010>\u001a\u00020\f*\u00020\f8F¢\u0006\u0006\u001a\u0004\b?\u0010@\"(\u0010A\u001a\u00020\u0003*\u00020B2\u0006\u0010\u0013\u001a\u00020\u00038F@FX\u000e¢\u0006\f\u001a\u0004\bC\u0010D\"\u0004\bE\u0010F\",\u0010G\u001a\u0004\u0018\u00010\u0014*\u00020\u00162\b\u0010\u0013\u001a\u0004\u0018\u00010\u00148F@FX\u000e¢\u0006\f\u001a\u0004\bH\u0010\u0018\"\u0004\bI\u0010\u001a\",\u0010J\u001a\u0004\u0018\u00010\u0014*\u00020\u00162\b\u0010\u0013\u001a\u0004\u0018\u00010\u00148F@FX\u000e¢\u0006\f\u001a\u0004\bK\u0010\u0018\"\u0004\bL\u0010\u001a\",\u0010M\u001a\u0004\u0018\u00010\u0014*\u00020\u00162\b\u0010\u0013\u001a\u0004\u0018\u00010\u00148F@FX\u000e¢\u0006\f\u001a\u0004\bN\u0010\u0018\"\u0004\bO\u0010\u001a\",\u0010P\u001a\u0004\u0018\u00010\u0014*\u00020\u00162\b\u0010\u0013\u001a\u0004\u0018\u00010\u00148F@FX\u000e¢\u0006\f\u001a\u0004\bQ\u0010\u0018\"\u0004\bR\u0010\u001a¨\u0006Ä\u0002"}, aXE = {"COLOR_ARGB_MASK", "", "COLOR_ARGB_MASK_LONG", "", "matchParent", "matrix", "Landroid/graphics/Matrix;", "typedValue", "Landroid/util/TypedValue;", "wrapContent", "act", "Landroid/support/v4/app/FragmentActivity;", "Landroid/support/v4/app/Fragment;", "getAct", "(Landroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentActivity;", "args", "Landroid/os/Bundle;", "getArgs", "(Landroid/support/v4/app/Fragment;)Landroid/os/Bundle;", "value", "Landroid/graphics/drawable/Drawable;", "bottomDrawable", "Landroid/widget/TextView;", "getBottomDrawable", "(Landroid/widget/TextView;)Landroid/graphics/drawable/Drawable;", "setBottomDrawable", "(Landroid/widget/TextView;Landroid/graphics/drawable/Drawable;)V", "bottomDrawableWithBounds", "getBottomDrawableWithBounds", "setBottomDrawableWithBounds", "connectivityManager", "Landroid/net/ConnectivityManager;", "Landroid/content/Context;", "getConnectivityManager", "(Landroid/content/Context;)Landroid/net/ConnectivityManager;", "ctx", "getCtx", "(Landroid/support/v4/app/Fragment;)Landroid/content/Context;", "downloadManager", "Landroid/app/DownloadManager;", "getDownloadManager", "(Landroid/content/Context;)Landroid/app/DownloadManager;", "endDrawable", "getEndDrawable", "setEndDrawable", "endDrawableWithBounds", "getEndDrawableWithBounds", "setEndDrawableWithBounds", "fmChild", "Landroid/support/v4/app/FragmentManager;", "getFmChild", "(Landroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentManager;", "fmSelf", "getFmSelf", "layoutInflater", "Landroid/view/LayoutInflater;", "getLayoutInflater", "(Landroid/content/Context;)Landroid/view/LayoutInflater;", "notificationManager", "Landroid/app/NotificationManager;", "getNotificationManager", "(Landroid/content/Context;)Landroid/app/NotificationManager;", "parent", "getParent", "(Landroid/support/v4/app/Fragment;)Landroid/support/v4/app/Fragment;", "safeDuration", "Landroid/animation/Animator;", "getSafeDuration", "(Landroid/animation/Animator;)J", "setSafeDuration", "(Landroid/animation/Animator;J)V", "startDrawable", "getStartDrawable", "setStartDrawable", "startDrawableWithBounds", "getStartDrawableWithBounds", "setStartDrawableWithBounds", "topDrawable", "getTopDrawable", "setTopDrawable", "topDrawableWithBounds", "getTopDrawableWithBounds", "setTopDrawableWithBounds", "draw", "Landroid/graphics/Bitmap;", "width", "height", "onDraw", "Lkotlin/Function1;", "Landroid/graphics/Canvas;", "", "Lkotlin/ExtensionFunctionType;", "fastRound", "", "getFrameParams", "Landroid/widget/FrameLayout$LayoutParams;", "w", "h", "gravity", "getLinearParams", "Landroid/widget/LinearLayout$LayoutParams;", "weight", "getViewModel", "T", "Landroid/arch/lifecycle/ViewModel;", "f", "factory", "Landroid/arch/lifecycle/ViewModelProvider$Factory;", "(Landroid/support/v4/app/Fragment;Landroid/arch/lifecycle/ViewModelProvider$Factory;)Landroid/arch/lifecycle/ViewModel;", "a", "(Landroid/support/v4/app/FragmentActivity;Landroid/arch/lifecycle/ViewModelProvider$Factory;)Landroid/arch/lifecycle/ViewModel;", "hasPermission", "", "permission", "", "isLPlus", "isMPlus", "isMainThread", "isNPlus", "isOPlus", "mediatorLiveData", "Landroid/arch/lifecycle/MediatorLiveData;", "def", "(Ljava/lang/Object;)Landroid/arch/lifecycle/MediatorLiveData;", "mutableLiveData", "Landroid/arch/lifecycle/MutableLiveData;", "(Ljava/lang/Object;)Landroid/arch/lifecycle/MutableLiveData;", "addFilter", "Landroid/widget/EditText;", "filter", "Landroid/text/InputFilter;", "argb2rgba", "asUri", "Landroid/net/Uri;", "res", "Landroid/content/res/Resources;", "clearDrawables", "color", "resId", "colorList", "Landroid/content/res/ColorStateList;", "commit", "allowStateLoss", "block", "Landroid/support/v4/app/FragmentTransaction;", "commitNow", "component1", "Landroid/graphics/Rect;", "Landroid/graphics/RectF;", "Landroid/util/DisplayMetrics;", "component2", "component3", "component4", "deepEnabled", "Landroid/view/ViewGroup;", "enabled", "disableChangeAnimations", "Landroid/support/v7/widget/RecyclerView;", "doOnLayout", "Landroid/view/View;", "condition", "Lkotlin/Function0;", "action", "doOnPreDraw", "doOnPreDrawSkip", "drawable", "editApply", "Landroid/content/SharedPreferences;", "Landroid/content/SharedPreferences$Editor;", "enableHardwareLayer", "enableNoneLayer", "fastEnabled", "findBinding", "Landroid/databinding/ViewDataBinding;", "(Landroid/view/View;)Landroid/databinding/ViewDataBinding;", "findChildFragmentManager", "fClass", "Ljava/lang/Class;", "findChildInstance", "(Landroid/support/v4/app/Fragment;Ljava/lang/Class;)Landroid/support/v4/app/Fragment;", "findFragmentManager", "findParentInstance", "findTraversal", "forEach", "Landroid/util/SparseArray;", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "element", "key", "forEachElement", "forEachKey", "getBitmap", "getChildViewType", "view", "getColor", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "getColorAttr", "getColorStateList", "getDrawable", "getFirstChild", "reversed", "getFont", "Landroid/graphics/Typeface;", "getGlobalPoint", "Landroid/graphics/Point;", "getGlobalPointF", "Landroid/graphics/PointF;", "getGlobalRect", "getGlobalRectF", "getInt", "getIntOrNull", "(Landroid/content/SharedPreferences;Ljava/lang/String;)Ljava/lang/Integer;", "getLongOrNull", "(Landroid/content/SharedPreferences;Ljava/lang/String;)Ljava/lang/Long;", "getPixels", "getPixelsInt", "getPosition", "index", "getTopLeftView", "kotlin.jvm.PlatformType", "getTrimmedText", "getViewHolder", "getViewType", "gone", "hide", "inflateBinding", "layoutRes", "attachToRoot", "(Landroid/content/Context;ILandroid/view/ViewGroup;Z)Landroid/databinding/ViewDataBinding;", "(Landroid/support/v4/app/Fragment;ILandroid/view/ViewGroup;Z)Landroid/databinding/ViewDataBinding;", "(Landroid/view/LayoutInflater;ILandroid/view/ViewGroup;Z)Landroid/databinding/ViewDataBinding;", "(Landroid/view/View;ILandroid/view/ViewGroup;Z)Landroid/databinding/ViewDataBinding;", "(Landroid/view/ViewGroup;ILandroid/view/ViewGroup;Z)Landroid/databinding/ViewDataBinding;", "inflateView", "(Landroid/view/ViewGroup;ILandroid/view/ViewGroup;Z)Landroid/view/View;", "isGone", "isNotVisible", "isVisible", "keysArray", "", "measureInBox", "measureInDisplay", "moveCursorToTheEnd", "postValueIfDiffers", "newValue", "(Landroid/arch/lifecycle/MutableLiveData;Ljava/lang/Object;)V", "Lcom/iqoption/core/data/livedata/IQMutableLiveData;", "(Lcom/iqoption/core/data/livedata/IQMutableLiveData;Ljava/lang/Object;)V", "putIntOrClear", "(Landroid/content/SharedPreferences$Editor;Ljava/lang/String;Ljava/lang/Integer;)Landroid/content/SharedPreferences$Editor;", "putLongOrClear", "(Landroid/content/SharedPreferences$Editor;Ljava/lang/String;Ljava/lang/Long;)Landroid/content/SharedPreferences$Editor;", "read", "Landroid/util/AttributeSet;", "context", "styleable", "Landroid/content/res/TypedArray;", "readTypedArray", "", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "classLoader", "Ljava/lang/ClassLoader;", "(Landroid/os/Parcel;Ljava/lang/ClassLoader;)[Landroid/os/Parcelable;", "readTypedList", "", "readTypedSet", "", "rgba2argb", "save", "scale", "sx", "sy", "recycleSource", "newWidth", "newHeight", "scaleAspectRatioMax", "scaleAspectRatioMin", "setContent", "Landroid/app/Activity;", "(Landroid/app/Activity;I)Landroid/databinding/ViewDataBinding;", "setDrawableBottom", "setDrawableLeft", "setDrawableRight", "setDrawableTop", "setOnDelayedClickListener", "setOrPost", "setOrPostIfDiffers", "setPaddingBottom", "p", "setPaddingEnd", "setPaddingStart", "setPaddingTop", "setScale", "setThenClear", "setTopTo", "top", "setTranslation", "translation", "setValueIfDiffers", "show", "startActivity", "intentBuilder", "Landroid/content/Intent;", "startActivityWithExtras", "extrasBuilder", "tint", "toColor", "toPixels", "dp", "toPixelsInt", "valuesArray", "(Landroid/util/SparseArray;)[Ljava/lang/Object;", "valuesList", "wrap", "writeTypedArray", "array", "flags", "(Landroid/os/Parcel;[Landroid/os/Parcelable;I)V", "writeTypedList", "list", "writeTypedSet", "set", "core_release"})
/* compiled from: AndroidExtensions.kt */
public final class a {
    private static final TypedValue aPa = new TypedValue();
    private static final Matrix matrix = new Matrix();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, aXE = {"com/iqoption/core/ext/AndroidExtensionsKt$doOnLayout$2", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "core_release"})
    /* compiled from: AndroidExtensions.kt */
    public static final class a implements OnGlobalLayoutListener {
        final /* synthetic */ View aGz;
        final /* synthetic */ kotlin.jvm.a.a aPb;
        final /* synthetic */ kotlin.jvm.a.a aPc;

        public a(View view, kotlin.jvm.a.a aVar, kotlin.jvm.a.a aVar2) {
            this.aGz = view;
            this.aPb = aVar;
            this.aPc = aVar2;
        }

        public void onGlobalLayout() {
            if (((Boolean) this.aPb.invoke()).booleanValue()) {
                this.aGz.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                this.aPc.invoke();
            }
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, aXE = {"com/iqoption/core/ext/AndroidExtensionsKt$setOnDelayedClickListener$1", "Lcom/iqoption/core/ext/OnDelayClickListener;", "onDelayClick", "", "v", "Landroid/view/View;", "core_release"})
    /* compiled from: AndroidExtensions.kt */
    public static final class b extends g {
        final /* synthetic */ kotlin.jvm.a.b aPd;

        public b(kotlin.jvm.a.b bVar) {
            this.aPd = bVar;
            super(0, 1, null);
        }

        public void q(View view) {
            h.e(view, "v");
            this.aPd.invoke(view);
        }
    }

    public static final int s(float f) {
        return (int) (f + 0.5f);
    }

    @ColorInt
    public static final int i(Context context, @ColorRes int i) {
        h.e(context, "$receiver");
        return ContextCompat.getColor(context, i);
    }

    public static final float j(Context context, @DimenRes int i) {
        h.e(context, "$receiver");
        return context.getResources().getDimension(i);
    }

    public static final int k(Context context, @DimenRes int i) {
        h.e(context, "$receiver");
        return context.getResources().getDimensionPixelSize(i);
    }

    public static final Typeface getFont(Context context, @FontRes int i) {
        h.e(context, "$receiver");
        Typeface font = ResourcesCompat.getFont(context, i);
        if (font == null) {
            h.aXZ();
        }
        return font;
    }

    public static final Drawable l(Context context, @DrawableRes int i) {
        h.e(context, "$receiver");
        Drawable drawable = ContextCompat.getDrawable(context, i);
        if (drawable == null) {
            h.aXZ();
        }
        return drawable;
    }

    public static final float a(Context context, float f) {
        h.e(context, "$receiver");
        Resources resources = context.getResources();
        h.d(resources, "resources");
        return TypedValue.applyDimension(1, f, resources.getDisplayMetrics());
    }

    public static final int b(Context context, float f) {
        h.e(context, "$receiver");
        float a = a(context, f);
        float f2 = (float) null;
        int i = (int) (a >= f2 ? a + 0.5f : a - 0.5f);
        if (i != 0) {
            return i;
        }
        if (f == 0.0f) {
            return 0;
        }
        return f > f2 ? 1 : -1;
    }

    @ColorInt
    public static final int a(Fragment fragment, @ColorRes int i) {
        h.e(fragment, "$receiver");
        return ContextCompat.getColor(m(fragment), i);
    }

    public static final float b(Fragment fragment, @DimenRes int i) {
        h.e(fragment, "$receiver");
        return fragment.getResources().getDimension(i);
    }

    public static final int c(Fragment fragment, @DimenRes int i) {
        h.e(fragment, "$receiver");
        return fragment.getResources().getDimensionPixelSize(i);
    }

    public static final Drawable d(Fragment fragment, @DrawableRes int i) {
        h.e(fragment, "$receiver");
        Drawable drawable = ContextCompat.getDrawable(m(fragment), i);
        if (drawable == null) {
            h.aXZ();
        }
        return drawable;
    }

    public static final int e(Fragment fragment, @IntegerRes int i) {
        h.e(fragment, "$receiver");
        return fragment.getResources().getInteger(i);
    }

    public static final <T extends Fragment> T a(Fragment fragment, Class<? extends T> cls) {
        h.e(fragment, "$receiver");
        h.e(cls, "fClass");
        Fragment fragment2 = fragment;
        do {
            fragment2 = fragment2.getParentFragment();
            if (fragment2 == null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(fragment);
                stringBuilder.append(" does not have parent fragment of class ");
                stringBuilder.append(cls);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        } while (!cls.isAssignableFrom(fragment2.getClass()));
        return fragment2;
    }

    public static final Context m(Fragment fragment) {
        h.e(fragment, "$receiver");
        Context requireContext = fragment.requireContext();
        h.d(requireContext, "requireContext()");
        return requireContext;
    }

    public static final FragmentActivity n(Fragment fragment) {
        h.e(fragment, "$receiver");
        FragmentActivity requireActivity = fragment.requireActivity();
        h.d(requireActivity, "requireActivity()");
        return requireActivity;
    }

    public static final Bundle o(Fragment fragment) {
        h.e(fragment, "$receiver");
        Bundle arguments = fragment.getArguments();
        if (arguments != null) {
            return arguments;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static final FragmentManager p(Fragment fragment) {
        h.e(fragment, "$receiver");
        FragmentManager requireFragmentManager = fragment.requireFragmentManager();
        h.d(requireFragmentManager, "requireFragmentManager()");
        return requireFragmentManager;
    }

    public static final FragmentManager q(Fragment fragment) {
        h.e(fragment, "$receiver");
        FragmentManager childFragmentManager = fragment.getChildFragmentManager();
        h.d(childFragmentManager, "childFragmentManager");
        return childFragmentManager;
    }

    public static final Fragment r(Fragment fragment) {
        h.e(fragment, "$receiver");
        fragment = fragment.getParentFragment();
        if (fragment != null) {
            return fragment;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static final void a(ViewGroup viewGroup, boolean z) {
        h.e(viewGroup, "$receiver");
        viewGroup.setEnabled(z);
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            h.d(childAt, "getChildAt(index)");
            childAt.setEnabled(z);
        }
    }

    @ColorInt
    public static final int b(View view, @ColorRes int i) {
        h.e(view, "$receiver");
        return ContextCompat.getColor(view.getContext(), i);
    }

    @ColorInt
    public static final int c(View view, @AttrRes int i) {
        h.e(view, "$receiver");
        Context context = view.getContext();
        h.d(context, "context");
        context.getTheme().resolveAttribute(i, aPa, true);
        return aPa.data;
    }

    public static final ColorStateList d(View view, @ColorRes int i) {
        h.e(view, "$receiver");
        ColorStateList colorStateList = ContextCompat.getColorStateList(view.getContext(), i);
        if (colorStateList == null) {
            h.aXZ();
        }
        return colorStateList;
    }

    public static final float e(View view, @DimenRes int i) {
        h.e(view, "$receiver");
        return view.getResources().getDimension(i);
    }

    public static final int f(View view, @DimenRes int i) {
        h.e(view, "$receiver");
        return view.getResources().getDimensionPixelSize(i);
    }

    public static final float a(View view, float f) {
        h.e(view, "$receiver");
        Resources resources = view.getResources();
        h.d(resources, "resources");
        return TypedValue.applyDimension(1, f, resources.getDisplayMetrics());
    }

    public static final int b(View view, float f) {
        h.e(view, "$receiver");
        float a = a(view, f);
        float f2 = (float) null;
        int i = (int) (a >= f2 ? a + 0.5f : a - 0.5f);
        if (i != 0) {
            return i;
        }
        if (f == 0.0f) {
            return 0;
        }
        return f > f2 ? 1 : -1;
    }

    public static final Typeface g(View view, @FontRes int i) {
        h.e(view, "$receiver");
        Typeface font = ResourcesCompat.getFont(view.getContext(), i);
        if (font == null) {
            h.aXZ();
        }
        return font;
    }

    public static final Drawable h(View view, @DrawableRes int i) {
        h.e(view, "$receiver");
        Drawable drawable = ContextCompat.getDrawable(view.getContext(), i);
        if (drawable == null) {
            h.aXZ();
        }
        return drawable;
    }

    public static final boolean I(View view) {
        h.e(view, "$receiver");
        return view.getVisibility() == 0;
    }

    public static final Rect J(View view) {
        h.e(view, "$receiver");
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        return new Rect(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
    }

    public static final Point K(View view) {
        h.e(view, "$receiver");
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return new Point(iArr[0], iArr[1]);
    }

    public static final void a(View view, kotlin.jvm.a.a<Boolean> aVar, kotlin.jvm.a.a<l> aVar2) {
        h.e(view, "$receiver");
        h.e(aVar, "condition");
        h.e(aVar2, "action");
        if (((Boolean) aVar.invoke()).booleanValue()) {
            aVar2.invoke();
        } else {
            view.getViewTreeObserver().addOnGlobalLayoutListener(new a(view, aVar, aVar2));
        }
    }

    public static final void a(View view, kotlin.jvm.a.b<? super View, l> bVar) {
        h.e(view, "$receiver");
        h.e(bVar, "block");
        view.setOnClickListener(new b(bVar));
    }

    public static final int a(RecyclerView recyclerView, int i) {
        h.e(recyclerView, "$receiver");
        return recyclerView.getChildAdapterPosition(recyclerView.getChildAt(i));
    }

    public static final void b(RecyclerView recyclerView) {
        h.e(recyclerView, "$receiver");
        ItemAnimator itemAnimator = recyclerView.getItemAnimator();
        if (itemAnimator == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.support.v7.widget.DefaultItemAnimator");
        }
        ((DefaultItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
    }

    @ColorInt
    public static final int b(ViewHolder viewHolder, @ColorRes int i) {
        h.e(viewHolder, "$receiver");
        View view = viewHolder.itemView;
        h.d(view, "itemView");
        return b(view, i);
    }

    public static final float c(ViewHolder viewHolder, @DimenRes int i) {
        h.e(viewHolder, "$receiver");
        View view = viewHolder.itemView;
        h.d(view, "itemView");
        return e(view, i);
    }

    public static final Typeface d(ViewHolder viewHolder, @FontRes int i) {
        h.e(viewHolder, "$receiver");
        View view = viewHolder.itemView;
        h.d(view, "itemView");
        return g(view, i);
    }

    public static final Drawable e(ViewHolder viewHolder, @DrawableRes int i) {
        h.e(viewHolder, "$receiver");
        View view = viewHolder.itemView;
        h.d(view, "itemView");
        return h(view, i);
    }

    @ColorInt
    public static final int a(ViewDataBinding viewDataBinding, @ColorRes int i) {
        h.e(viewDataBinding, "$receiver");
        View root = viewDataBinding.getRoot();
        h.d(root, "root");
        return b(root, i);
    }

    public static final float b(ViewDataBinding viewDataBinding, @DimenRes int i) {
        h.e(viewDataBinding, "$receiver");
        View root = viewDataBinding.getRoot();
        h.d(root, "root");
        return e(root, i);
    }

    public static final int c(ViewDataBinding viewDataBinding, @DimenRes int i) {
        h.e(viewDataBinding, "$receiver");
        View root = viewDataBinding.getRoot();
        h.d(root, "root");
        return f(root, i);
    }

    public static final Typeface d(ViewDataBinding viewDataBinding, @FontRes int i) {
        h.e(viewDataBinding, "$receiver");
        View root = viewDataBinding.getRoot();
        h.d(root, "root");
        return g(root, i);
    }

    public static final Drawable e(ViewDataBinding viewDataBinding, @DrawableRes int i) {
        h.e(viewDataBinding, "$receiver");
        View root = viewDataBinding.getRoot();
        h.d(root, "root");
        return h(root, i);
    }

    public static final void a(TextView textView, @DrawableRes int i) {
        h.e(textView, "$receiver");
        textView.setCompoundDrawablesWithIntrinsicBounds(0, i, 0, 0);
    }

    public static final LayoutParams m(int i, int i2, int i3) {
        return new LayoutParams(i, i2, i3);
    }

    public static final <T extends ViewDataBinding> T a(Fragment fragment, int i, ViewGroup viewGroup, boolean z) {
        h.e(fragment, "$receiver");
        LayoutInflater from = LayoutInflater.from(fragment.getContext());
        h.d(from, "LayoutInflater.from(context)");
        return a(from, i, viewGroup, z);
    }

    public static final <T extends ViewDataBinding> T a(ViewGroup viewGroup, int i, ViewGroup viewGroup2, boolean z) {
        h.e(viewGroup, "$receiver");
        h.e(viewGroup2, "parent");
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        h.d(from, "LayoutInflater.from(context)");
        return a(from, i, viewGroup2, z);
    }

    public static final <T extends ViewDataBinding> T a(LayoutInflater layoutInflater, int i, ViewGroup viewGroup, boolean z) {
        h.e(layoutInflater, "$receiver");
        T inflate = DataBindingUtil.inflate(layoutInflater, i, viewGroup, z);
        h.d(inflate, "DataBindingUtil.inflate(…es, parent, attachToRoot)");
        return inflate;
    }

    public static /* bridge */ /* synthetic */ View b(ViewGroup viewGroup, int i, ViewGroup viewGroup2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            viewGroup2 = viewGroup;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return b(viewGroup, i, viewGroup2, z);
    }

    public static final <T extends View> T b(ViewGroup viewGroup, int i, ViewGroup viewGroup2, boolean z) {
        h.e(viewGroup, "$receiver");
        h.e(viewGroup2, "parent");
        T inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup2, z);
        if (inflate != null) {
            return inflate;
        }
        throw new TypeCastException("null cannot be cast to non-null type T");
    }

    public static final void L(View view) {
        h.e(view, "$receiver");
        view.setVisibility(0);
    }

    public static final void hide(View view) {
        h.e(view, "$receiver");
        view.setVisibility(4);
    }

    public static final void M(View view) {
        h.e(view, "$receiver");
        view.setVisibility(8);
    }

    public static final <T> void a(MutableLiveData<T> mutableLiveData, T t) {
        h.e(mutableLiveData, "$receiver");
        if (C()) {
            mutableLiveData.setValue(t);
        } else {
            mutableLiveData.postValue(t);
        }
    }

    public static final <T> void a(c<T> cVar, T t) {
        h.e(cVar, "$receiver");
        if ((h.E(cVar.getValue(), t) ^ 1) != 0) {
            cVar.setValue(t);
        }
    }

    public static final boolean C() {
        Looper mainLooper = Looper.getMainLooper();
        h.d(mainLooper, "Looper.getMainLooper()");
        return mainLooper.getThread() == Thread.currentThread();
    }

    public static final void c(EditText editText) {
        h.e(editText, "$receiver");
        editText.setSelection(editText.length());
    }

    public static final void c(View view, float f) {
        h.e(view, "$receiver");
        view.setScaleX(f);
        view.setScaleY(f);
    }

    public static final void a(TextView textView, Drawable drawable) {
        h.e(textView, "$receiver");
        Drawable[] compoundDrawablesRelative = textView.getCompoundDrawablesRelative();
        textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, compoundDrawablesRelative[1], compoundDrawablesRelative[2], compoundDrawablesRelative[3]);
    }

    public static final void b(TextView textView, Drawable drawable) {
        h.e(textView, "$receiver");
        Drawable[] compoundDrawablesRelative = textView.getCompoundDrawablesRelative();
        textView.setCompoundDrawablesRelativeWithIntrinsicBounds(compoundDrawablesRelative[0], compoundDrawablesRelative[1], drawable, compoundDrawablesRelative[3]);
    }

    public static final Drawable g(TextView textView) {
        h.e(textView, "$receiver");
        return textView.getCompoundDrawablesRelative()[0];
    }

    public static final void c(TextView textView, Drawable drawable) {
        h.e(textView, "$receiver");
        Drawable[] compoundDrawablesRelative = textView.getCompoundDrawablesRelative();
        textView.setCompoundDrawablesRelative(drawable, compoundDrawablesRelative[1], compoundDrawablesRelative[2], compoundDrawablesRelative[3]);
    }

    public static final Drawable h(TextView textView) {
        h.e(textView, "$receiver");
        return textView.getCompoundDrawablesRelative()[2];
    }

    public static final void d(TextView textView, Drawable drawable) {
        h.e(textView, "$receiver");
        Drawable[] compoundDrawables = textView.getCompoundDrawables();
        textView.setCompoundDrawablesRelative(compoundDrawables[0], compoundDrawables[1], drawable, compoundDrawables[3]);
    }

    public static final void a(EditText editText, InputFilter inputFilter) {
        h.e(editText, "$receiver");
        h.e(inputFilter, "filter");
        Object filters = editText.getFilters();
        h.d(filters, "filters");
        List B = i.B(filters);
        B.add(inputFilter);
        Collection collection = B;
        if (collection == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.util.Collection<T>");
        }
        Object[] toArray = collection.toArray(new InputFilter[0]);
        if (toArray == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        editText.setFilters((InputFilter[]) toArray);
    }

    public static final void a(Animator animator, long j) {
        float f;
        h.e(animator, "$receiver");
        try {
            f = Global.getFloat(f.RQ().getContext().getContentResolver(), "animator_duration_scale", 1.0f);
        } catch (Throwable unused) {
            f = 0.0f;
        }
        if (f != 0.0f) {
            animator.setDuration(j);
        }
    }

    public static final boolean go(String str) {
        h.e(str, "permission");
        return ContextCompat.checkSelfPermission(f.RQ().getContext(), str) == 0;
    }

    public static final <T extends ViewDataBinding> T findBinding(View view) {
        h.e(view, "$receiver");
        T findBinding = DataBindingUtil.findBinding(view);
        if (findBinding == null) {
            h.aXZ();
        }
        return findBinding;
    }

    public static final boolean SQ() {
        return VERSION.SDK_INT >= 26;
    }

    public static final NotificationManager bc(Context context) {
        h.e(context, "$receiver");
        Object systemService = context.getSystemService("notification");
        if (systemService != null) {
            return (NotificationManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.app.NotificationManager");
    }

    public static final DownloadManager bd(Context context) {
        h.e(context, "$receiver");
        Object systemService = context.getSystemService("download");
        if (systemService != null) {
            return (DownloadManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.app.DownloadManager");
    }

    public static final ConnectivityManager be(Context context) {
        h.e(context, "$receiver");
        Object systemService = context.getSystemService("connectivity");
        if (systemService != null) {
            return (ConnectivityManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.net.ConnectivityManager");
    }

    public static final Bitmap a(Bitmap bitmap, float f, float f2, boolean z) {
        h.e(bitmap, "$receiver");
        matrix.reset();
        matrix.preScale(f, f2);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (z) {
            bitmap.recycle();
        }
        h.d(createBitmap, "scaled");
        return createBitmap;
    }

    public static final Bitmap a(Bitmap bitmap, int i, int i2, boolean z) {
        h.e(bitmap, "$receiver");
        float min = Math.min(((float) i) / ((float) bitmap.getWidth()), ((float) i2) / ((float) bitmap.getHeight()));
        return a(bitmap, min, min, z);
    }

    public static final Drawable wrap(Drawable drawable) {
        h.e(drawable, "$receiver");
        drawable = DrawableCompat.wrap(drawable.mutate());
        h.d(drawable, "DrawableCompat.wrap(mutate())");
        return drawable;
    }

    public static final Drawable a(Drawable drawable, @ColorInt int i) {
        h.e(drawable, "$receiver");
        drawable = wrap(drawable);
        DrawableCompat.setTint(drawable, i);
        return drawable;
    }

    public static final Drawable a(Drawable drawable, ColorStateList colorStateList) {
        h.e(drawable, "$receiver");
        drawable = wrap(drawable);
        DrawableCompat.setTintList(drawable, colorStateList);
        return drawable;
    }

    public static final Editor a(Editor editor, String str, Integer num) {
        h.e(editor, "$receiver");
        h.e(str, "key");
        if (num != null) {
            editor.putInt(str, num.intValue());
        } else {
            editor.remove(str);
        }
        return editor;
    }

    public static final Integer b(SharedPreferences sharedPreferences, String str) {
        h.e(sharedPreferences, "$receiver");
        h.e(str, "key");
        return sharedPreferences.contains(str) ? Integer.valueOf(sharedPreferences.getInt(str, -1)) : null;
    }

    public static final Long c(SharedPreferences sharedPreferences, String str) {
        h.e(sharedPreferences, "$receiver");
        h.e(str, "key");
        return sharedPreferences.contains(str) ? Long.valueOf(sharedPreferences.getLong(str, -1)) : null;
    }

    public static final int dG(int i) {
        return c.ad(i, 8);
    }

    public static final int dH(int i) {
        return c.ae(i, 8);
    }

    public static final int gp(String str) {
        h.e(str, "$receiver");
        return (int) Long.parseLong(str);
    }

    public static final int b(Rect rect) {
        h.e(rect, "$receiver");
        return rect.left;
    }

    public static final int c(Rect rect) {
        h.e(rect, "$receiver");
        return rect.right;
    }

    public static final int d(Rect rect) {
        h.e(rect, "$receiver");
        return rect.bottom;
    }

    public static final int a(DisplayMetrics displayMetrics) {
        h.e(displayMetrics, "$receiver");
        return displayMetrics.widthPixels;
    }

    public static final int b(DisplayMetrics displayMetrics) {
        h.e(displayMetrics, "$receiver");
        return displayMetrics.heightPixels;
    }

    public static final void N(View view) {
        h.e(view, "$receiver");
        Resources resources = view.getResources();
        h.d(resources, "resources");
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        a(view, a(displayMetrics), b(displayMetrics));
    }

    public static final void a(View view, int i, int i2) {
        h.e(view, "$receiver");
        view.measure(MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), MeasureSpec.makeMeasureSpec(i2, Integer.MIN_VALUE));
    }

    public static final <T extends Parcelable> Set<T> a(Parcel parcel, ClassLoader classLoader) {
        h.e(parcel, "$receiver");
        int readInt = parcel.readInt();
        if (readInt == -1) {
            return null;
        }
        Set<T> linkedHashSet = new LinkedHashSet();
        for (int i = 0; i < readInt; i++) {
            Parcelable readParcelable = parcel.readParcelable(classLoader);
            if (readParcelable == null) {
                h.aXZ();
            }
            linkedHashSet.add(readParcelable);
        }
        return linkedHashSet;
    }

    public static final <T extends Parcelable> void a(Parcel parcel, Set<? extends T> set, int i) {
        h.e(parcel, "$receiver");
        parcel.writeInt(set != null ? set.size() : -1);
        if (set != null) {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                parcel.writeParcelable((Parcelable) it.next(), i);
            }
        }
    }
}
