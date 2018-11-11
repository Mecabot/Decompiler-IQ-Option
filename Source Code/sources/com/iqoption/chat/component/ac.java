package com.iqoption.chat.component;

import android.content.Context;
import android.content.res.AssetManager;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.PluralsRes;
import android.support.annotation.StringRes;
import android.support.v7.util.DiffUtil.DiffResult;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.style.TextAppearanceSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.iqoption.chat.fragment.MessageView;
import com.iqoption.core.ui.widget.StarBar;
import com.iqoption.d.ci;
import com.iqoption.d.ck;
import com.iqoption.d.cm;
import com.iqoption.d.co;
import com.iqoption.d.cq;
import com.iqoption.d.dg;
import com.iqoption.d.di;
import com.iqoption.d.dk;
import com.iqoption.d.dm;
import com.iqoption.d.dq;
import com.iqoption.d.ds;
import com.iqoption.d.du;
import com.iqoption.d.dy;
import com.iqoption.d.em;
import com.iqoption.d.eo;
import com.iqoption.d.eq;
import com.iqoption.d.es;
import com.iqoption.d.eu;
import com.iqoption.d.ew;
import com.iqoption.d.ey;
import com.iqoption.d.fa;
import com.iqoption.d.fc;
import com.iqoption.microservice.chat.ChatMessageType;
import com.iqoption.x.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;

@kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000ú\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 °\u00012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u00012\u00020\u0003:\u0006°\u0001±\u0001²\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0018\u0010X\u001a\u00020\f2\u0006\u0010Y\u001a\u00020\n2\u0006\u0010Z\u001a\u00020[H\u0002J(\u0010\\\u001a\u00020\f2\u0006\u0010Y\u001a\u00020\n2\u0006\u0010]\u001a\u00020\u001c2\u0006\u0010^\u001a\u00020_2\u0006\u0010Z\u001a\u00020[H\u0002J\u0018\u0010`\u001a\u00020\f2\u0006\u0010Y\u001a\u00020\n2\u0006\u0010a\u001a\u00020bH\u0002J\u0018\u0010c\u001a\u00020\f2\u0006\u0010d\u001a\u00020\u000b2\u0006\u0010e\u001a\u00020[H\u0002J\u0013\u0010f\u001a\u00020\u001c2\b\b\u0001\u0010g\u001a\u00020\u001cH\u0001J\u0015\u0010h\u001a\u0004\u0018\u00010\u001a2\b\b\u0001\u0010g\u001a\u00020\u001cH\u0001J\b\u0010i\u001a\u00020\u001cH\u0016J\u0010\u0010j\u001a\u00020k2\u0006\u0010l\u001a\u00020\u001cH\u0016J\u0010\u0010m\u001a\u00020\u001c2\u0006\u0010l\u001a\u00020\u001cH\u0016J\u0010\u0010n\u001a\u0004\u0018\u00010\n2\u0006\u0010o\u001a\u00020\u001cJ%\u0010p\u001a\u00020q2\b\b\u0001\u0010g\u001a\u00020\u001c2\u0006\u0010r\u001a\u00020\u001c2\b\b\u0002\u0010s\u001a\u000200H\u0001J<\u0010t\u001a\n u*\u0004\u0018\u00010&0&2\b\b\u0001\u0010g\u001a\u00020\u001c2\u0006\u0010r\u001a\u00020\u001c2\u0012\u0010v\u001a\n\u0012\u0006\b\u0001\u0012\u00020x0w\"\u00020xH\u0001¢\u0006\u0002\u0010yJ\u0013\u0010z\u001a\u00020{2\b\b\u0001\u0010g\u001a\u00020\u001cH\u0001J\u0013\u0010|\u001a\u00020\u001c2\b\b\u0001\u0010g\u001a\u00020\u001cH\u0001J0\u0010}\u001a\u00020&2\b\b\u0001\u0010g\u001a\u00020\u001c2\u0016\u0010v\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010x0w\"\u0004\u0018\u00010xH\u0001¢\u0006\u0002\u0010~J\u0010\u0010\u001a\u0004\u0018\u00010L2\u0006\u0010o\u001a\u00020\u001cJ2\u0010\u0001\u001a\u0003H\u0001\"\f\b\u0000\u0010\u0001\u0018\u0001*\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u001c2\b\u0010\u0001\u001a\u00030\u0001H\b¢\u0006\u0003\u0010\u0001J\u0013\u0010\u0001\u001a\u00020\f2\b\u0010\u0001\u001a\u00030\u0001H\u0016J\u001e\u0010\u0001\u001a\u00020\f2\u000b\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010l\u001a\u00020\u001cH\u0016J#\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010\u00022\b\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u001cH\u0016J%\u0010\u0001\u001a\u00020\f2\u0010\u0010\u0001\u001a\u000b\u0012\u0004\u0012\u000206\u0018\u00010\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001J\u0010\u0010\u0001\u001a\u00020\f2\u0007\u0010\u0001\u001a\u00020&J\u001e\u0010\u0001\u001a\u00020\f*\u00030\u00012\u0006\u0010d\u001a\u00020\u000b2\u0006\u0010Y\u001a\u00020\nH\u0002J\u001e\u0010\u0001\u001a\u00020\f*\u00030\u00012\u0006\u0010d\u001a\u00020\u000b2\u0006\u0010Y\u001a\u00020\nH\u0002J\u001e\u0010\u0001\u001a\u00020\f*\u00030\u00012\u0006\u0010d\u001a\u00020\u000b2\u0006\u0010Y\u001a\u00020\nH\u0002J\u001e\u0010\u0001\u001a\u00020\f*\u00030\u00012\u0006\u0010d\u001a\u00020\u000b2\u0006\u0010Y\u001a\u00020\nH\u0002J\u001e\u0010\u0001\u001a\u00020\f*\u00030\u00012\u0006\u0010d\u001a\u00020\u000b2\u0006\u0010Y\u001a\u00020\nH\u0002J\u001e\u0010\u0001\u001a\u00020\f*\u00030\u00012\u0006\u0010d\u001a\u00020\u000b2\u0006\u0010Y\u001a\u00020\nH\u0002J\u001e\u0010\u0001\u001a\u00020\f*\u00030\u00012\u0006\u0010d\u001a\u00020\u000b2\u0006\u0010Y\u001a\u00020\nH\u0002J\u001e\u0010\u0001\u001a\u00020\f*\u00030\u00012\u0006\u0010d\u001a\u00020\u000b2\u0006\u0010Y\u001a\u00020\nH\u0002J\u001e\u0010\u0001\u001a\u00020\f*\u00030\u00012\u0006\u0010Y\u001a\u00020\n2\u0006\u0010]\u001a\u00020\u001cH\u0002J\u001e\u0010\u0001\u001a\u00020\f*\u00030\u00012\u0006\u0010Y\u001a\u00020\n2\u0006\u0010]\u001a\u00020\u001cH\u0002J\u0017\u0010\u0001\u001a\u00020\f*\u00030 \u00012\u0007\u0010¡\u0001\u001a\u00020LH\u0002J\u0016\u0010\u0001\u001a\u00020\f*\u00030¢\u00012\u0006\u0010Y\u001a\u00020\nH\u0002J\u0016\u0010\u0001\u001a\u00020\f*\u00030£\u00012\u0006\u0010Y\u001a\u00020\nH\u0002J\u0016\u0010\u0001\u001a\u00020\f*\u00030¤\u00012\u0006\u0010Y\u001a\u00020\nH\u0002J\u0016\u0010\u0001\u001a\u00020\f*\u00030¥\u00012\u0006\u0010Y\u001a\u00020\nH\u0002J\u001e\u0010\u0001\u001a\u00020\f*\u00030¦\u00012\u0006\u0010Y\u001a\u00020\n2\u0006\u0010]\u001a\u00020\u001cH\u0002J&\u0010\u0001\u001a\u00020\f*\u00030§\u00012\u0006\u0010Y\u001a\u00020\n2\u0006\u0010d\u001a\u00020\u000b2\u0006\u0010]\u001a\u00020\u001cH\u0002J\u001e\u0010\u0001\u001a\u00020\f*\u00030¨\u00012\u0006\u0010Y\u001a\u00020\n2\u0006\u0010d\u001a\u00020\u000bH\u0002J\u001e\u0010\u0001\u001a\u00020\f*\u00030©\u00012\u0006\u0010Y\u001a\u00020\n2\u0006\u0010]\u001a\u00020\u001cH\u0002J\u000f\u0010ª\u0001\u001a\u0004\u0018\u00010&*\u00020\u000bH\u0002J \u0010«\u0001\u001a\u00020\f*\u00030\u00012\u0007\u0010¬\u0001\u001a\u0002002\u0007\u0010­\u0001\u001a\u000200H\u0002J\u0017\u0010®\u0001\u001a\u00020\f*\u00030\u00012\u0007\u0010¯\u0001\u001a\u000200H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R4\u0010\b\u001a\u001c\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\tj\u0004\u0018\u0001`\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R.\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0013j\u0004\u0018\u0001`\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X.¢\u0006\u0002\n\u0000R\u0012\u0010!\u001a\u00020\"X\u0005¢\u0006\u0006\u001a\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020,X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X.¢\u0006\u0002\n\u0000R\u001a\u0010/\u001a\u000200X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00101\"\u0004\b2\u00103R\u0014\u00104\u001a\b\u0012\u0004\u0012\u00020605X\u0004¢\u0006\u0002\n\u0000R4\u00107\u001a\u001c\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\f\u0018\u00010\tj\u0004\u0018\u0001`8X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u000f\"\u0004\b:\u0010\u0011R.\u0010;\u001a\u0016\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0013j\u0004\u0018\u0001`\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u0016\"\u0004\b=\u0010\u0018R\u000e\u0010>\u001a\u00020 X.¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020@X.¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020CX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010E\u001a\u0004\u0018\u00010FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR.\u0010K\u001a\u0016\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u00020\f\u0018\u00010\u0013j\u0004\u0018\u0001`MX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\u0016\"\u0004\bO\u0010\u0018R\u000e\u0010P\u001a\u00020QX\u0004¢\u0006\u0002\n\u0000R.\u0010R\u001a\u0016\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0013j\u0004\u0018\u0001`SX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010\u0016\"\u0004\bU\u0010\u0018R\u0012\u0010V\u001a\u00060WR\u00020\u0000X\u0004¢\u0006\u0002\n\u0000¨\u0006³\u0001"}, aXE = {"Lcom/iqoption/chat/component/MessagesAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/iqoption/chat/component/ViewHolder;", "Lcom/iqoption/chat/Resourcer;", "resourcer", "(Lcom/iqoption/chat/Resourcer;)V", "assetManager", "Landroid/content/res/AssetManager;", "attachmentClickListener", "Lkotlin/Function2;", "Lcom/iqoption/microservice/chat/ChatMessage;", "Lcom/iqoption/microservice/chat/ChatAttachment;", "", "Lcom/iqoption/chat/component/AttachmentClickListener;", "getAttachmentClickListener", "()Lkotlin/jvm/functions/Function2;", "setAttachmentClickListener", "(Lkotlin/jvm/functions/Function2;)V", "avatarClickListener", "Lkotlin/Function1;", "Lcom/iqoption/chat/component/MessageClickListener;", "getAvatarClickListener", "()Lkotlin/jvm/functions/Function1;", "setAvatarClickListener", "(Lkotlin/jvm/functions/Function1;)V", "avatarPlaceholder", "Landroid/graphics/drawable/Drawable;", "avatarSize", "", "avatarTransformation", "Lcom/iqoption/core/ui/picasso/CircleTransformation;", "boldDateSpan", "Landroid/text/style/TextAppearanceSpan;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "emptyText", "", "getEmptyText", "()Ljava/lang/String;", "setEmptyText", "(Ljava/lang/String;)V", "idSupplier", "Lcom/iqoption/chat/component/MessageIdSupplier;", "inflater", "Landroid/view/LayoutInflater;", "isLoading", "", "()Z", "setLoading", "(Z)V", "items", "", "Lcom/iqoption/chat/component/MessageAdapterItem;", "likeDislikeClickListener", "Lcom/iqoption/chat/component/LikeDislikeClickListener;", "getLikeDislikeClickListener", "setLikeDislikeClickListener", "messageClickListener", "getMessageClickListener", "setMessageClickListener", "normalDateSpan", "picasso", "Lcom/squareup/picasso/Picasso;", "previewHeight", "previewRectTransformation", "Lcom/iqoption/core/ui/picasso/RoundedRectTransformation;", "previewWidth", "ratingChangeListener", "Lcom/iqoption/chat/component/MessagesAdapter$RatingChangeListener;", "getRatingChangeListener", "()Lcom/iqoption/chat/component/MessagesAdapter$RatingChangeListener;", "setRatingChangeListener", "(Lcom/iqoption/chat/component/MessagesAdapter$RatingChangeListener;)V", "suggestionClickListener", "Lcom/iqoption/core/microservices/chat/response/ChatSuggestion;", "Lcom/iqoption/chat/component/SuggestionClickListener;", "getSuggestionClickListener", "setSuggestionClickListener", "timeFormat", "Ljava/text/SimpleDateFormat;", "transferDialogClickListener", "Lcom/iqoption/chat/component/TransferDialogClickListener;", "getTransferDialogClickListener", "setTransferDialogClickListener", "viewTypeSupplier", "Lcom/iqoption/chat/component/MessagesAdapter$ViewTypeSupplier;", "bindAvatar", "msg", "avatar", "Landroid/widget/ImageView;", "bindBubble", "bubble", "author", "Landroid/widget/TextView;", "bindMessage", "message", "Lcom/iqoption/chat/fragment/MessageView;", "bindPreview", "att", "preview", "getColor", "id", "getDrawable", "getItemCount", "getItemId", "", "position", "getItemViewType", "getMsg", "pos", "getPlural", "", "quantity", "formatQuantity", "getPluralFormat", "kotlin.jvm.PlatformType", "formatArgs", "", "", "(II[Ljava/lang/Object;)Ljava/lang/String;", "getPxFloat", "", "getPxInt", "getString", "(I[Ljava/lang/Object;)Ljava/lang/String;", "getSuggest", "inflate", "T", "Landroid/databinding/ViewDataBinding;", "layoutRes", "parent", "Landroid/view/ViewGroup;", "(ILandroid/view/ViewGroup;)Landroid/databinding/ViewDataBinding;", "onAttachedToRecyclerView", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onBindViewHolder", "holder", "onCreateViewHolder", "viewType", "setItems", "list", "", "diffResult", "Landroid/support/v7/util/DiffUtil$DiffResult;", "updateMessage", "messageId", "bind", "Lcom/iqoption/chat/component/FileMessageBodyViewHolder;", "Lcom/iqoption/chat/component/FileMessageFullViewHolder;", "Lcom/iqoption/chat/component/FileMessageHeadViewHolder;", "Lcom/iqoption/chat/component/FileMessageTailViewHolder;", "Lcom/iqoption/chat/component/ImageMessageBodyViewHolder;", "Lcom/iqoption/chat/component/ImageMessageFullViewHolder;", "Lcom/iqoption/chat/component/ImageMessageHeadViewHolder;", "Lcom/iqoption/chat/component/ImageMessageTailViewHolder;", "Lcom/iqoption/chat/component/LikeDislikeViewHolder;", "Lcom/iqoption/chat/component/RateMessageViewHolder;", "Lcom/iqoption/chat/component/SuggestionViewHolder;", "sugg", "Lcom/iqoption/chat/component/TextMessageBodyViewHolder;", "Lcom/iqoption/chat/component/TextMessageFullViewHolder;", "Lcom/iqoption/chat/component/TextMessageHeadViewHolder;", "Lcom/iqoption/chat/component/TextMessageTailViewHolder;", "Lcom/iqoption/chat/component/TransferDialogViewHolder;", "Lcom/iqoption/chat/component/UserFileMessageViewHolder;", "Lcom/iqoption/chat/component/UserImageMessageViewHolder;", "Lcom/iqoption/chat/component/UserTextMessageViewHolder;", "formatFileName", "setActivated", "isLikeActive", "isDislikeActive", "setEnabled", "isEnabled", "Companion", "RatingChangeListener", "ViewTypeSupplier", "IqOption-5.5.1_optionXRelease"})
/* compiled from: MessagesAdapter.kt */
public final class ac extends Adapter<ax<?>> implements com.iqoption.chat.d {
    private static final String TAG = "ac";
    public static final a aDX = new a();
    private String aDC = "";
    private boolean aDD = true;
    private final z aDE = new z();
    private final c aDF = new c();
    private final Drawable aDG;
    private final com.iqoption.core.ui.picasso.a aDH;
    private final int aDI;
    private final com.iqoption.core.ui.picasso.c aDJ;
    private final int aDK;
    private final int aDL;
    private final SimpleDateFormat aDM;
    private LayoutInflater aDN;
    private TextAppearanceSpan aDO;
    private TextAppearanceSpan aDP;
    private kotlin.jvm.a.b<? super com.iqoption.microservice.chat.g, kotlin.l> aDQ;
    private kotlin.jvm.a.b<? super com.iqoption.microservice.chat.g, kotlin.l> aDR;
    private b aDS;
    private kotlin.jvm.a.m<? super com.iqoption.microservice.chat.g, ? super com.iqoption.microservice.chat.a, kotlin.l> aDT;
    private kotlin.jvm.a.m<? super com.iqoption.microservice.chat.g, ? super Boolean, kotlin.l> aDU;
    private kotlin.jvm.a.b<? super com.iqoption.microservice.chat.g, kotlin.l> aDV;
    private kotlin.jvm.a.b<? super com.iqoption.core.microservices.b.a.a, kotlin.l> aDW;
    private final /* synthetic */ com.iqoption.chat.d aDY;
    private AssetManager assetManager;
    private final List<y> nj = new ArrayList();
    private Picasso picasso;

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0016\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\u001d"}, aXE = {"Lcom/iqoption/chat/component/MessagesAdapter$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "VIEW_TYPE_EMPTY", "", "VIEW_TYPE_FILE_MESSAGE_BODY", "VIEW_TYPE_FILE_MESSAGE_FULL", "VIEW_TYPE_FILE_MESSAGE_HEAD", "VIEW_TYPE_FILE_MESSAGE_TAIL", "VIEW_TYPE_IMAGE_MESSAGE_BODY", "VIEW_TYPE_IMAGE_MESSAGE_FULL", "VIEW_TYPE_IMAGE_MESSAGE_HEAD", "VIEW_TYPE_IMAGE_MESSAGE_TAIL", "VIEW_TYPE_LIKE_DISLIKE", "VIEW_TYPE_LOADING", "VIEW_TYPE_LOAD_MORE", "VIEW_TYPE_RATE_MESSAGE", "VIEW_TYPE_SUGGESTION", "VIEW_TYPE_TEXT_MESSAGE_BODY", "VIEW_TYPE_TEXT_MESSAGE_FULL", "VIEW_TYPE_TEXT_MESSAGE_HEAD", "VIEW_TYPE_TEXT_MESSAGE_TAIL", "VIEW_TYPE_TRANSFER_DIALOG", "VIEW_TYPE_USER_FILE_MESSAGE", "VIEW_TYPE_USER_IMAGE_MESSAGE", "VIEW_TYPE_USER_TEXT_MESSAGE", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: MessagesAdapter.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/iqoption/chat/component/MessagesAdapter$onCreateViewHolder$5$2"})
    /* compiled from: MessagesAdapter.kt */
    static final class aa implements OnClickListener {
        final /* synthetic */ ac aDZ;
        final /* synthetic */ o aEr;

        aa(o oVar, ac acVar) {
            this.aEr = oVar;
            this.aDZ = acVar;
        }

        public final void onClick(View view) {
            kotlin.jvm.a.b OT = this.aDZ.OT();
            if (OT != null) {
                kotlin.l lVar = (kotlin.l) OT.invoke(this.aEr.OR());
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/iqoption/chat/component/MessagesAdapter$onCreateViewHolder$6$1"})
    /* compiled from: MessagesAdapter.kt */
    static final class ab implements OnClickListener {
        final /* synthetic */ ac aDZ;
        final /* synthetic */ p aEs;

        ab(p pVar, ac acVar) {
            this.aEs = pVar;
            this.aDZ = acVar;
        }

        public final void onClick(View view) {
            kotlin.jvm.a.m OV = this.aDZ.OV();
            if (OV != null) {
                kotlin.l lVar = (kotlin.l) OV.B(this.aEs.OR(), this.aEs.Oy());
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, aXE = {"Lcom/iqoption/chat/component/MessagesAdapter$RatingChangeListener;", "", "onRatingChanged", "", "rating", "", "message", "Lcom/iqoption/microservice/chat/ChatMessage;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: MessagesAdapter.kt */
    public interface b {
        void a(int i, com.iqoption.microservice.chat.g gVar);
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u0006"}, aXE = {"Lcom/iqoption/chat/component/MessagesAdapter$ViewTypeSupplier;", "", "(Lcom/iqoption/chat/component/MessagesAdapter;)V", "get", "", "position", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: MessagesAdapter.kt */
    private final class c {
        public final int get(int i) {
            y yVar = (y) ac.this.nj.get(i);
            if (yVar instanceof w) {
                return 1;
            }
            if (yVar instanceof e) {
                return 2;
            }
            if (yVar instanceof u) {
                return 3;
            }
            if (yVar instanceof aa) {
                aa aaVar = (aa) yVar;
                if (aaVar.Ox().arl() == ChatMessageType.RATE) {
                    return 18;
                }
                if (aaVar.Ox().arl() == ChatMessageType.CLOSE_DIALOG) {
                    return 22;
                }
                if (aaVar.Ox().arl() == ChatMessageType.TRANSFER) {
                    return 23;
                }
                if (aaVar.Ox().arg()) {
                    return 19;
                }
                switch (aaVar.Oz()) {
                    case 1:
                        return 7;
                    case 2:
                        return 8;
                    case 3:
                        return 9;
                    default:
                        return 6;
                }
            } else if (yVar instanceof a) {
                a aVar = (a) yVar;
                if (aVar.Ox().arg()) {
                    return aVar.Oy().arf() ? 20 : 21;
                } else {
                    if (aVar.Oy().arf()) {
                        switch (aVar.Oz()) {
                            case 1:
                                return 11;
                            case 2:
                                return 12;
                            case 3:
                                return 13;
                            default:
                                return 10;
                        }
                    }
                    switch (aVar.Oz()) {
                        case 1:
                            return 15;
                        case 2:
                            return 16;
                        case 3:
                            return 17;
                        default:
                            return 14;
                    }
                }
            } else if (yVar instanceof am) {
                return 24;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/iqoption/chat/component/MessagesAdapter$onCreateViewHolder$1$1"})
    /* compiled from: MessagesAdapter.kt */
    static final class d implements OnClickListener {
        final /* synthetic */ ac aDZ;
        final /* synthetic */ ap aEa;

        d(ap apVar, ac acVar) {
            this.aEa = apVar;
            this.aDZ = acVar;
        }

        public final void onClick(View view) {
            kotlin.jvm.a.b OS = this.aDZ.OS();
            if (OS != null) {
                kotlin.l lVar = (kotlin.l) OS.invoke(this.aEa.OR());
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/iqoption/chat/component/MessagesAdapter$onCreateViewHolder$7$1"})
    /* compiled from: MessagesAdapter.kt */
    static final class e implements OnClickListener {
        final /* synthetic */ ac aDZ;
        final /* synthetic */ n aEb;

        e(n nVar, ac acVar) {
            this.aEb = nVar;
            this.aDZ = acVar;
        }

        public final void onClick(View view) {
            kotlin.jvm.a.m OV = this.aDZ.OV();
            if (OV != null) {
                kotlin.l lVar = (kotlin.l) OV.B(this.aEb.OR(), this.aEb.Oy());
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/iqoption/chat/component/MessagesAdapter$onCreateViewHolder$8$1"})
    /* compiled from: MessagesAdapter.kt */
    static final class f implements OnClickListener {
        final /* synthetic */ ac aDZ;
        final /* synthetic */ q aEc;

        f(q qVar, ac acVar) {
            this.aEc = qVar;
            this.aDZ = acVar;
        }

        public final void onClick(View view) {
            kotlin.jvm.a.m OV = this.aDZ.OV();
            if (OV != null) {
                kotlin.l lVar = (kotlin.l) OV.B(this.aEc.OR(), this.aEc.Oy());
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/iqoption/chat/component/MessagesAdapter$onCreateViewHolder$8$2"})
    /* compiled from: MessagesAdapter.kt */
    static final class g implements OnClickListener {
        final /* synthetic */ ac aDZ;
        final /* synthetic */ q aEc;

        g(q qVar, ac acVar) {
            this.aEc = qVar;
            this.aDZ = acVar;
        }

        public final void onClick(View view) {
            kotlin.jvm.a.b OT = this.aDZ.OT();
            if (OT != null) {
                kotlin.l lVar = (kotlin.l) OT.invoke(this.aEc.OR());
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/iqoption/chat/component/MessagesAdapter$onCreateViewHolder$9$1"})
    /* compiled from: MessagesAdapter.kt */
    static final class h implements OnClickListener {
        final /* synthetic */ ac aDZ;
        final /* synthetic */ k aEd;

        h(k kVar, ac acVar) {
            this.aEd = kVar;
            this.aDZ = acVar;
        }

        public final void onClick(View view) {
            kotlin.jvm.a.m OV = this.aDZ.OV();
            if (OV != null) {
                kotlin.l lVar = (kotlin.l) OV.B(this.aEd.OR(), this.aEd.Oy());
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/iqoption/chat/component/MessagesAdapter$onCreateViewHolder$9$2"})
    /* compiled from: MessagesAdapter.kt */
    static final class i implements OnClickListener {
        final /* synthetic */ ac aDZ;
        final /* synthetic */ k aEd;

        i(k kVar, ac acVar) {
            this.aEd = kVar;
            this.aDZ = acVar;
        }

        public final void onClick(View view) {
            kotlin.jvm.a.b OT = this.aDZ.OT();
            if (OT != null) {
                kotlin.l lVar = (kotlin.l) OT.invoke(this.aEd.OR());
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/iqoption/chat/component/MessagesAdapter$onCreateViewHolder$10$1"})
    /* compiled from: MessagesAdapter.kt */
    static final class j implements OnClickListener {
        final /* synthetic */ ac aDZ;
        final /* synthetic */ l aEe;

        j(l lVar, ac acVar) {
            this.aEe = lVar;
            this.aDZ = acVar;
        }

        public final void onClick(View view) {
            kotlin.jvm.a.m OV = this.aDZ.OV();
            if (OV != null) {
                kotlin.l lVar = (kotlin.l) OV.B(this.aEe.OR(), this.aEe.Oy());
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/iqoption/chat/component/MessagesAdapter$onCreateViewHolder$11$1"})
    /* compiled from: MessagesAdapter.kt */
    static final class k implements OnClickListener {
        final /* synthetic */ ac aDZ;
        final /* synthetic */ j aEf;

        k(j jVar, ac acVar) {
            this.aEf = jVar;
            this.aDZ = acVar;
        }

        public final void onClick(View view) {
            kotlin.jvm.a.m OV = this.aDZ.OV();
            if (OV != null) {
                kotlin.l lVar = (kotlin.l) OV.B(this.aEf.OR(), this.aEf.Oy());
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/iqoption/chat/component/MessagesAdapter$onCreateViewHolder$12$1"})
    /* compiled from: MessagesAdapter.kt */
    static final class l implements OnClickListener {
        final /* synthetic */ ac aDZ;
        final /* synthetic */ m aEg;

        l(m mVar, ac acVar) {
            this.aEg = mVar;
            this.aDZ = acVar;
        }

        public final void onClick(View view) {
            kotlin.jvm.a.m OV = this.aDZ.OV();
            if (OV != null) {
                kotlin.l lVar = (kotlin.l) OV.B(this.aEg.OR(), this.aEg.Oy());
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/iqoption/chat/component/MessagesAdapter$onCreateViewHolder$12$2"})
    /* compiled from: MessagesAdapter.kt */
    static final class m implements OnClickListener {
        final /* synthetic */ ac aDZ;
        final /* synthetic */ m aEg;

        m(m mVar, ac acVar) {
            this.aEg = mVar;
            this.aDZ = acVar;
        }

        public final void onClick(View view) {
            kotlin.jvm.a.b OT = this.aDZ.OT();
            if (OT != null) {
                kotlin.l lVar = (kotlin.l) OT.invoke(this.aEg.OR());
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/iqoption/chat/component/MessagesAdapter$onCreateViewHolder$1$2"})
    /* compiled from: MessagesAdapter.kt */
    static final class o implements OnClickListener {
        final /* synthetic */ ac aDZ;
        final /* synthetic */ ap aEa;

        o(ap apVar, ac acVar) {
            this.aEa = apVar;
            this.aDZ = acVar;
        }

        public final void onClick(View view) {
            kotlin.jvm.a.b OT = this.aDZ.OT();
            if (OT != null) {
                kotlin.l lVar = (kotlin.l) OT.invoke(this.aEa.OR());
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/iqoption/chat/component/MessagesAdapter$onCreateViewHolder$14$1"})
    /* compiled from: MessagesAdapter.kt */
    static final class p implements OnClickListener {
        final /* synthetic */ ac aDZ;
        final /* synthetic */ av aEi;

        p(av avVar, ac acVar) {
            this.aEi = avVar;
            this.aDZ = acVar;
        }

        public final void onClick(View view) {
            kotlin.jvm.a.b OS = this.aDZ.OS();
            if (OS != null) {
                kotlin.l lVar = (kotlin.l) OS.invoke(this.aEi.OR());
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/iqoption/chat/component/MessagesAdapter$onCreateViewHolder$15$1"})
    /* compiled from: MessagesAdapter.kt */
    static final class q implements OnClickListener {
        final /* synthetic */ ac aDZ;
        final /* synthetic */ au aEj;

        q(au auVar, ac acVar) {
            this.aEj = auVar;
            this.aDZ = acVar;
        }

        public final void onClick(View view) {
            kotlin.jvm.a.m OV = this.aDZ.OV();
            if (OV != null) {
                kotlin.l lVar = (kotlin.l) OV.B(this.aEj.OR(), this.aEj.Oy());
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/iqoption/chat/component/MessagesAdapter$onCreateViewHolder$16$1"})
    /* compiled from: MessagesAdapter.kt */
    static final class r implements OnClickListener {
        final /* synthetic */ ac aDZ;
        final /* synthetic */ at aEk;

        r(at atVar, ac acVar) {
            this.aEk = atVar;
            this.aDZ = acVar;
        }

        public final void onClick(View view) {
            kotlin.jvm.a.m OV = this.aDZ.OV();
            if (OV != null) {
                kotlin.l lVar = (kotlin.l) OV.B(this.aEk.OR(), this.aEk.Oy());
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/iqoption/chat/component/MessagesAdapter$onCreateViewHolder$2$1"})
    /* compiled from: MessagesAdapter.kt */
    static final class v implements OnClickListener {
        final /* synthetic */ ac aDZ;
        final /* synthetic */ aq aEo;

        v(aq aqVar, ac acVar) {
            this.aEo = aqVar;
            this.aDZ = acVar;
        }

        public final void onClick(View view) {
            kotlin.jvm.a.b OS = this.aDZ.OS();
            if (OS != null) {
                kotlin.l lVar = (kotlin.l) OS.invoke(this.aEo.OR());
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/iqoption/chat/component/MessagesAdapter$onCreateViewHolder$3$1"})
    /* compiled from: MessagesAdapter.kt */
    static final class w implements OnClickListener {
        final /* synthetic */ ac aDZ;
        final /* synthetic */ ao aEp;

        w(ao aoVar, ac acVar) {
            this.aEp = aoVar;
            this.aDZ = acVar;
        }

        public final void onClick(View view) {
            kotlin.jvm.a.b OS = this.aDZ.OS();
            if (OS != null) {
                kotlin.l lVar = (kotlin.l) OS.invoke(this.aEp.OR());
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/iqoption/chat/component/MessagesAdapter$onCreateViewHolder$4$1"})
    /* compiled from: MessagesAdapter.kt */
    static final class x implements OnClickListener {
        final /* synthetic */ ac aDZ;
        final /* synthetic */ ar aEq;

        x(ar arVar, ac acVar) {
            this.aEq = arVar;
            this.aDZ = acVar;
        }

        public final void onClick(View view) {
            kotlin.jvm.a.b OS = this.aDZ.OS();
            if (OS != null) {
                kotlin.l lVar = (kotlin.l) OS.invoke(this.aEq.OR());
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/iqoption/chat/component/MessagesAdapter$onCreateViewHolder$4$2"})
    /* compiled from: MessagesAdapter.kt */
    static final class y implements OnClickListener {
        final /* synthetic */ ac aDZ;
        final /* synthetic */ ar aEq;

        y(ar arVar, ac acVar) {
            this.aEq = arVar;
            this.aDZ = acVar;
        }

        public final void onClick(View view) {
            kotlin.jvm.a.b OT = this.aDZ.OT();
            if (OT != null) {
                kotlin.l lVar = (kotlin.l) OT.invoke(this.aEq.OR());
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/iqoption/chat/component/MessagesAdapter$onCreateViewHolder$5$1"})
    /* compiled from: MessagesAdapter.kt */
    static final class z implements OnClickListener {
        final /* synthetic */ ac aDZ;
        final /* synthetic */ o aEr;

        z(o oVar, ac acVar) {
            this.aEr = oVar;
            this.aDZ = acVar;
        }

        public final void onClick(View view) {
            kotlin.jvm.a.m OV = this.aDZ.OV();
            if (OV != null) {
                kotlin.l lVar = (kotlin.l) OV.B(this.aEr.OR(), this.aEr.Oy());
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, aXE = {"<anonymous>", "", "rating", "", "onStarsChanged", "com/iqoption/chat/component/MessagesAdapter$onCreateViewHolder$13$1"})
    /* compiled from: MessagesAdapter.kt */
    static final class n implements com.iqoption.core.ui.widget.StarBar.b {
        final /* synthetic */ ac aDZ;
        final /* synthetic */ ae aEh;

        n(ae aeVar, ac acVar) {
            this.aEh = aeVar;
            this.aDZ = acVar;
        }

        public final void dv(int i) {
            b OU = this.aDZ.OU();
            if (OU != null) {
                OU.a(i, this.aEh.OR());
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, aXE = {"com/iqoption/chat/component/MessagesAdapter$onCreateViewHolder$17$clickListener$1", "Lcom/iqoption/view/viewinterface/OnClickDelayView;", "onDelayClick", "", "view", "Landroid/view/View;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: MessagesAdapter.kt */
    public static final class s extends com.iqoption.view.d.b {
        final /* synthetic */ ac aDZ;
        final /* synthetic */ t aEl;

        s(t tVar, ac acVar) {
            this.aEl = tVar;
            this.aDZ = acVar;
        }

        public void q(View view) {
            kotlin.jvm.internal.h.e(view, Promotion.ACTION_VIEW);
            int id = view.getId();
            kotlin.jvm.a.m OW;
            kotlin.l lVar;
            if (id == R.id.dislike) {
                OW = this.aDZ.OW();
                if (OW != null) {
                    lVar = (kotlin.l) OW.B(this.aEl.OR(), Boolean.valueOf(false));
                }
            } else if (id == R.id.like) {
                OW = this.aDZ.OW();
                if (OW != null) {
                    lVar = (kotlin.l) OW.B(this.aEl.OR(), Boolean.valueOf(true));
                }
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0007"}, aXE = {"com/iqoption/core/ext/AndroidExtensionsKt$setOnDelayedClickListener$1", "Lcom/iqoption/core/ext/OnDelayClickListener;", "onDelayClick", "", "v", "Landroid/view/View;", "core_release", "com/iqoption/chat/component/MessagesAdapter$$special$$inlined$setOnDelayedClickListener$1"})
    /* compiled from: AndroidExtensions.kt */
    public static final class t extends com.iqoption.core.ext.g {
        final /* synthetic */ ac aDZ;
        final /* synthetic */ as aEm;

        public t(as asVar, ac acVar) {
            this.aDZ = acVar;
            this.aEm = asVar;
            super(0, 1, null);
        }

        public void q(View view) {
            kotlin.jvm.internal.h.e(view, "v");
            kotlin.jvm.a.b OX = this.aDZ.OX();
            if (OX != null) {
                kotlin.l lVar = (kotlin.l) OX.invoke(this.aEm.OR());
            }
            TextView textView = ((ew) this.aEm.getBinding()).bnd;
            textView.setEnabled(false);
            textView.animate().alpha(0.5f).setDuration(150).start();
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0007"}, aXE = {"com/iqoption/core/ext/AndroidExtensionsKt$setOnDelayedClickListener$1", "Lcom/iqoption/core/ext/OnDelayClickListener;", "onDelayClick", "", "v", "Landroid/view/View;", "core_release", "com/iqoption/chat/component/MessagesAdapter$$special$$inlined$setOnDelayedClickListener$2"})
    /* compiled from: AndroidExtensions.kt */
    public static final class u extends com.iqoption.core.ext.g {
        final /* synthetic */ ac aDZ;
        final /* synthetic */ an aEn;

        public u(an anVar, ac acVar) {
            this.aDZ = acVar;
            this.aEn = anVar;
            super(0, 1, null);
        }

        public void q(View view) {
            kotlin.jvm.internal.h.e(view, "v");
            kotlin.jvm.a.b OY = this.aDZ.OY();
            if (OY != null) {
                kotlin.l lVar = (kotlin.l) OY.invoke(this.aEn.Ps());
            }
        }
    }

    public String a(@PluralsRes int i, int i2, Object... objArr) {
        kotlin.jvm.internal.h.e(objArr, "formatArgs");
        return this.aDY.a(i, i2, objArr);
    }

    public int dr(@DimenRes int i) {
        return this.aDY.dr(i);
    }

    public float ds(@DimenRes int i) {
        return this.aDY.ds(i);
    }

    public int getColor(@ColorRes int i) {
        return this.aDY.getColor(i);
    }

    public Context getContext() {
        return this.aDY.getContext();
    }

    public Drawable getDrawable(@DrawableRes int i) {
        return this.aDY.getDrawable(i);
    }

    public String getString(@StringRes int i, Object... objArr) {
        kotlin.jvm.internal.h.e(objArr, "formatArgs");
        return this.aDY.getString(i, objArr);
    }

    public ac(com.iqoption.chat.d dVar) {
        kotlin.jvm.internal.h.e(dVar, "resourcer");
        this.aDY = dVar;
        Drawable drawable = getDrawable(R.drawable.chat_message_avatar_placeholder);
        if (drawable == null) {
            kotlin.jvm.internal.h.aXZ();
        }
        this.aDG = drawable;
        this.aDH = new com.iqoption.core.ui.picasso.a();
        this.aDI = dr(R.dimen.dp36);
        this.aDJ = new com.iqoption.core.ui.picasso.c(dr(R.dimen.dp12));
        this.aDK = dr(R.dimen.dp200);
        this.aDL = dr(R.dimen.dp150);
        this.aDM = new SimpleDateFormat("HH:mm", Locale.getDefault());
        setHasStableIds(true);
    }

    public final void fI(String str) {
        kotlin.jvm.internal.h.e(str, "<set-?>");
        this.aDC = str;
    }

    public final void setLoading(boolean z) {
        this.aDD = z;
    }

    public final com.iqoption.microservice.chat.g dt(int i) {
        Object h = u.h(this.nj, i);
        if (!(h instanceof aa)) {
            h = null;
        }
        aa aaVar = (aa) h;
        if (aaVar != null) {
            com.iqoption.microservice.chat.g Ox = aaVar.Ox();
            if (Ox != null) {
                return Ox;
            }
        }
        Object h2 = u.h(this.nj, i);
        if (!(h2 instanceof a)) {
            h2 = null;
        }
        a aVar = (a) h2;
        return aVar != null ? aVar.Ox() : null;
    }

    public final com.iqoption.core.microservices.b.a.a du(int i) {
        Object h = u.h(this.nj, i);
        if (!(h instanceof am)) {
            h = null;
        }
        am amVar = (am) h;
        return amVar != null ? amVar.Pr() : null;
    }

    public final kotlin.jvm.a.b<com.iqoption.microservice.chat.g, kotlin.l> OS() {
        return this.aDQ;
    }

    public final void a(kotlin.jvm.a.b<? super com.iqoption.microservice.chat.g, kotlin.l> bVar) {
        this.aDQ = bVar;
    }

    public final kotlin.jvm.a.b<com.iqoption.microservice.chat.g, kotlin.l> OT() {
        return this.aDR;
    }

    public final void b(kotlin.jvm.a.b<? super com.iqoption.microservice.chat.g, kotlin.l> bVar) {
        this.aDR = bVar;
    }

    public final b OU() {
        return this.aDS;
    }

    public final void a(b bVar) {
        this.aDS = bVar;
    }

    public final kotlin.jvm.a.m<com.iqoption.microservice.chat.g, com.iqoption.microservice.chat.a, kotlin.l> OV() {
        return this.aDT;
    }

    public final void a(kotlin.jvm.a.m<? super com.iqoption.microservice.chat.g, ? super com.iqoption.microservice.chat.a, kotlin.l> mVar) {
        this.aDT = mVar;
    }

    public final kotlin.jvm.a.m<com.iqoption.microservice.chat.g, Boolean, kotlin.l> OW() {
        return this.aDU;
    }

    public final void b(kotlin.jvm.a.m<? super com.iqoption.microservice.chat.g, ? super Boolean, kotlin.l> mVar) {
        this.aDU = mVar;
    }

    public final kotlin.jvm.a.b<com.iqoption.microservice.chat.g, kotlin.l> OX() {
        return this.aDV;
    }

    public final void c(kotlin.jvm.a.b<? super com.iqoption.microservice.chat.g, kotlin.l> bVar) {
        this.aDV = bVar;
    }

    public final kotlin.jvm.a.b<com.iqoption.core.microservices.b.a.a, kotlin.l> OY() {
        return this.aDW;
    }

    public final void d(kotlin.jvm.a.b<? super com.iqoption.core.microservices.b.a.a, kotlin.l> bVar) {
        this.aDW = bVar;
    }

    public int getItemCount() {
        return this.nj.size();
    }

    /* renamed from: l */
    public ax<ViewDataBinding> onCreateViewHolder(ViewGroup viewGroup, int i) {
        kotlin.jvm.internal.h.e(viewGroup, "parent");
        ViewDataBinding inflate;
        TextView textView;
        switch (i) {
            case 1:
                inflate = DataBindingUtil.inflate(b(this), R.layout.chat_loading_item, viewGroup, false);
                kotlin.jvm.internal.h.d(inflate, "DataBindingUtil.inflate(…layoutRes, parent, false)");
                return new x((du) inflate);
            case 2:
                inflate = DataBindingUtil.inflate(b(this), R.layout.chat_empty_item, viewGroup, false);
                kotlin.jvm.internal.h.d(inflate, "DataBindingUtil.inflate(…layoutRes, parent, false)");
                return new f((ci) inflate);
            case 3:
                inflate = DataBindingUtil.inflate(b(this), R.layout.chat_load_more_item, viewGroup, false);
                kotlin.jvm.internal.h.d(inflate, "DataBindingUtil.inflate(…layoutRes, parent, false)");
                return new v((ds) inflate);
            case 6:
                inflate = DataBindingUtil.inflate(b(this), R.layout.chat_text_message_full_item, viewGroup, false);
                kotlin.jvm.internal.h.d(inflate, "DataBindingUtil.inflate(…layoutRes, parent, false)");
                ap apVar = new ap((eq) inflate);
                ((eq) apVar.getBinding()).bms.setOnClickListener(new d(apVar, this));
                ((eq) apVar.getBinding()).bmj.setOnClickListener(new o(apVar, this));
                return apVar;
            case 7:
                inflate = DataBindingUtil.inflate(b(this), R.layout.chat_text_message_head_item, viewGroup, false);
                kotlin.jvm.internal.h.d(inflate, "DataBindingUtil.inflate(…layoutRes, parent, false)");
                aq aqVar = new aq((es) inflate);
                ((es) aqVar.getBinding()).bms.setOnClickListener(new v(aqVar, this));
                return aqVar;
            case 8:
                inflate = DataBindingUtil.inflate(b(this), R.layout.chat_text_message_body_item, viewGroup, false);
                kotlin.jvm.internal.h.d(inflate, "DataBindingUtil.inflate(…layoutRes, parent, false)");
                ao aoVar = new ao((eo) inflate);
                ((eo) aoVar.getBinding()).bmS.setOnClickListener(new w(aoVar, this));
                return aoVar;
            case 9:
                inflate = DataBindingUtil.inflate(b(this), R.layout.chat_text_message_tail_item, viewGroup, false);
                kotlin.jvm.internal.h.d(inflate, "DataBindingUtil.inflate(…layoutRes, parent, false)");
                ar arVar = new ar((eu) inflate);
                ((eu) arVar.getBinding()).bms.setOnClickListener(new x(arVar, this));
                ((eu) arVar.getBinding()).bmj.setOnClickListener(new y(arVar, this));
                return arVar;
            case 10:
                inflate = DataBindingUtil.inflate(b(this), R.layout.chat_image_message_full_item, viewGroup, false);
                kotlin.jvm.internal.h.d(inflate, "DataBindingUtil.inflate(…layoutRes, parent, false)");
                o oVar = new o((di) inflate);
                ((di) oVar.getBinding()).bms.setOnClickListener(new z(oVar, this));
                ((di) oVar.getBinding()).bmj.setOnClickListener(new aa(oVar, this));
                return oVar;
            case 11:
                inflate = DataBindingUtil.inflate(b(this), R.layout.chat_image_message_head_item, viewGroup, false);
                kotlin.jvm.internal.h.d(inflate, "DataBindingUtil.inflate(…layoutRes, parent, false)");
                p pVar = new p((dk) inflate);
                ((dk) pVar.getBinding()).bms.setOnClickListener(new ab(pVar, this));
                return pVar;
            case 12:
                inflate = DataBindingUtil.inflate(b(this), R.layout.chat_image_message_body_item, viewGroup, false);
                kotlin.jvm.internal.h.d(inflate, "DataBindingUtil.inflate(…layoutRes, parent, false)");
                n nVar = new n((dg) inflate);
                ((dg) nVar.getBinding()).blY.setOnClickListener(new e(nVar, this));
                return nVar;
            case 13:
                inflate = DataBindingUtil.inflate(b(this), R.layout.chat_image_message_tail_item, viewGroup, false);
                kotlin.jvm.internal.h.d(inflate, "DataBindingUtil.inflate(…layoutRes, parent, false)");
                q qVar = new q((dm) inflate);
                ((dm) qVar.getBinding()).blY.setOnClickListener(new f(qVar, this));
                ((dm) qVar.getBinding()).bmj.setOnClickListener(new g(qVar, this));
                return qVar;
            case 14:
                inflate = DataBindingUtil.inflate(b(this), R.layout.chat_file_message_full_item, viewGroup, false);
                kotlin.jvm.internal.h.d(inflate, "DataBindingUtil.inflate(…layoutRes, parent, false)");
                k kVar = new k((cm) inflate);
                ((cm) kVar.getBinding()).bms.setOnClickListener(new h(kVar, this));
                ((cm) kVar.getBinding()).bmj.setOnClickListener(new i(kVar, this));
                return kVar;
            case 15:
                inflate = DataBindingUtil.inflate(b(this), R.layout.chat_file_message_head_item, viewGroup, false);
                kotlin.jvm.internal.h.d(inflate, "DataBindingUtil.inflate(…layoutRes, parent, false)");
                l lVar = new l((co) inflate);
                ((co) lVar.getBinding()).bms.setOnClickListener(new j(lVar, this));
                return lVar;
            case 16:
                inflate = DataBindingUtil.inflate(b(this), R.layout.chat_file_message_body_item, viewGroup, false);
                kotlin.jvm.internal.h.d(inflate, "DataBindingUtil.inflate(…layoutRes, parent, false)");
                j jVar = new j((ck) inflate);
                ((ck) jVar.getBinding()).aig.setOnClickListener(new k(jVar, this));
                return jVar;
            case 17:
                inflate = DataBindingUtil.inflate(b(this), R.layout.chat_file_message_tail_item, viewGroup, false);
                kotlin.jvm.internal.h.d(inflate, "DataBindingUtil.inflate(…layoutRes, parent, false)");
                m mVar = new m((cq) inflate);
                ((cq) mVar.getBinding()).aig.setOnClickListener(new l(mVar, this));
                ((cq) mVar.getBinding()).bmj.setOnClickListener(new m(mVar, this));
                return mVar;
            case 18:
                inflate = DataBindingUtil.inflate(b(this), R.layout.chat_rate_message_item, viewGroup, false);
                kotlin.jvm.internal.h.d(inflate, "DataBindingUtil.inflate(…layoutRes, parent, false)");
                ae aeVar = new ae((dy) inflate);
                ((dy) aeVar.getBinding()).bmT.setOnStarsChangedListener(new n(aeVar, this));
                return aeVar;
            case 19:
                inflate = DataBindingUtil.inflate(b(this), R.layout.chat_user_text_message_item, viewGroup, false);
                kotlin.jvm.internal.h.d(inflate, "DataBindingUtil.inflate(…layoutRes, parent, false)");
                av avVar = new av((fc) inflate);
                ((fc) avVar.getBinding()).bmS.setOnClickListener(new p(avVar, this));
                return avVar;
            case 20:
                inflate = DataBindingUtil.inflate(b(this), R.layout.chat_user_image_message_item, viewGroup, false);
                kotlin.jvm.internal.h.d(inflate, "DataBindingUtil.inflate(…layoutRes, parent, false)");
                au auVar = new au((fa) inflate);
                ((fa) auVar.getBinding()).blY.setOnClickListener(new q(auVar, this));
                return auVar;
            case 21:
                inflate = DataBindingUtil.inflate(b(this), R.layout.chat_user_file_message_item, viewGroup, false);
                kotlin.jvm.internal.h.d(inflate, "DataBindingUtil.inflate(…layoutRes, parent, false)");
                at atVar = new at((ey) inflate);
                ((ey) atVar.getBinding()).aig.setOnClickListener(new r(atVar, this));
                return atVar;
            case 22:
                inflate = DataBindingUtil.inflate(b(this), R.layout.chat_like_dislike_message_item, viewGroup, false);
                kotlin.jvm.internal.h.d(inflate, "DataBindingUtil.inflate(…layoutRes, parent, false)");
                t tVar = new t((dq) inflate);
                OnClickListener sVar = new s(tVar, this);
                ((dq) tVar.getBinding()).bmR.setOnClickListener(sVar);
                ((dq) tVar.getBinding()).bmQ.setOnClickListener(sVar);
                return tVar;
            case 23:
                inflate = DataBindingUtil.inflate(b(this), R.layout.chat_transfer_dialog_message_item, viewGroup, false);
                kotlin.jvm.internal.h.d(inflate, "DataBindingUtil.inflate(…layoutRes, parent, false)");
                as asVar = new as((ew) inflate);
                textView = ((ew) asVar.getBinding()).bnd;
                kotlin.jvm.internal.h.d(textView, "binding.button");
                textView.setOnClickListener(new t(asVar, this));
                return asVar;
            case 24:
                inflate = DataBindingUtil.inflate(b(this), R.layout.chat_suggestion_message_item, viewGroup, false);
                kotlin.jvm.internal.h.d(inflate, "DataBindingUtil.inflate(…layoutRes, parent, false)");
                an anVar = new an((em) inflate);
                textView = ((em) anVar.getBinding()).bnc;
                kotlin.jvm.internal.h.d(textView, "binding.suggestion");
                textView.setOnClickListener(new u(anVar, this));
                return anVar;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("unknown viewType ");
                stringBuilder.append(i);
                throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    /* renamed from: a */
    public void onBindViewHolder(ax<?> axVar, int i) {
        kotlin.jvm.internal.h.e(axVar, "holder");
        int itemViewType = axVar.getItemViewType();
        if (itemViewType != 2) {
            Object obj;
            a aVar;
            aa aaVar;
            switch (itemViewType) {
                case 6:
                    ap apVar = (ap) axVar;
                    obj = this.nj.get(i);
                    if (obj == null) {
                        throw new TypeCastException("null cannot be cast to non-null type com.iqoption.chat.component.MessageItem");
                    }
                    a(apVar, ((aa) obj).Ox());
                    return;
                case 7:
                    aq aqVar = (aq) axVar;
                    obj = this.nj.get(i);
                    if (obj == null) {
                        throw new TypeCastException("null cannot be cast to non-null type com.iqoption.chat.component.MessageItem");
                    }
                    a(aqVar, ((aa) obj).Ox());
                    return;
                case 8:
                    ao aoVar = (ao) axVar;
                    obj = this.nj.get(i);
                    if (obj == null) {
                        throw new TypeCastException("null cannot be cast to non-null type com.iqoption.chat.component.MessageItem");
                    }
                    a(aoVar, ((aa) obj).Ox());
                    return;
                case 9:
                    ar arVar = (ar) axVar;
                    obj = this.nj.get(i);
                    if (obj == null) {
                        throw new TypeCastException("null cannot be cast to non-null type com.iqoption.chat.component.MessageItem");
                    }
                    a(arVar, ((aa) obj).Ox());
                    return;
                case 10:
                    obj = this.nj.get(i);
                    if (obj == null) {
                        throw new TypeCastException("null cannot be cast to non-null type com.iqoption.chat.component.AttachmentItem");
                    }
                    aVar = (a) obj;
                    a((o) axVar, aVar.Oy(), aVar.Ox());
                    return;
                case 11:
                    obj = this.nj.get(i);
                    if (obj == null) {
                        throw new TypeCastException("null cannot be cast to non-null type com.iqoption.chat.component.AttachmentItem");
                    }
                    aVar = (a) obj;
                    a((p) axVar, aVar.Oy(), aVar.Ox());
                    return;
                case 12:
                    obj = this.nj.get(i);
                    if (obj == null) {
                        throw new TypeCastException("null cannot be cast to non-null type com.iqoption.chat.component.AttachmentItem");
                    }
                    aVar = (a) obj;
                    a((n) axVar, aVar.Oy(), aVar.Ox());
                    return;
                case 13:
                    obj = this.nj.get(i);
                    if (obj == null) {
                        throw new TypeCastException("null cannot be cast to non-null type com.iqoption.chat.component.AttachmentItem");
                    }
                    aVar = (a) obj;
                    a((q) axVar, aVar.Oy(), aVar.Ox());
                    return;
                case 14:
                    obj = this.nj.get(i);
                    if (obj == null) {
                        throw new TypeCastException("null cannot be cast to non-null type com.iqoption.chat.component.AttachmentItem");
                    }
                    aVar = (a) obj;
                    a((k) axVar, aVar.Oy(), aVar.Ox());
                    return;
                case 15:
                    obj = this.nj.get(i);
                    if (obj == null) {
                        throw new TypeCastException("null cannot be cast to non-null type com.iqoption.chat.component.AttachmentItem");
                    }
                    aVar = (a) obj;
                    a((l) axVar, aVar.Oy(), aVar.Ox());
                    return;
                case 16:
                    obj = this.nj.get(i);
                    if (obj == null) {
                        throw new TypeCastException("null cannot be cast to non-null type com.iqoption.chat.component.AttachmentItem");
                    }
                    aVar = (a) obj;
                    a((j) axVar, aVar.Oy(), aVar.Ox());
                    return;
                case 17:
                    obj = this.nj.get(i);
                    if (obj == null) {
                        throw new TypeCastException("null cannot be cast to non-null type com.iqoption.chat.component.AttachmentItem");
                    }
                    aVar = (a) obj;
                    a((m) axVar, aVar.Oy(), aVar.Ox());
                    return;
                case 18:
                    obj = this.nj.get(i);
                    if (obj == null) {
                        throw new TypeCastException("null cannot be cast to non-null type com.iqoption.chat.component.MessageItem");
                    }
                    aaVar = (aa) obj;
                    a((ae) axVar, aaVar.Ox(), aaVar.Oz());
                    return;
                case 19:
                    obj = this.nj.get(i);
                    if (obj == null) {
                        throw new TypeCastException("null cannot be cast to non-null type com.iqoption.chat.component.MessageItem");
                    }
                    aaVar = (aa) obj;
                    a((av) axVar, aaVar.Ox(), aaVar.Oz());
                    return;
                case 20:
                    obj = this.nj.get(i);
                    if (obj == null) {
                        throw new TypeCastException("null cannot be cast to non-null type com.iqoption.chat.component.AttachmentItem");
                    }
                    aVar = (a) obj;
                    a((au) axVar, aVar.Ox(), aVar.Oy());
                    return;
                case 21:
                    obj = this.nj.get(i);
                    if (obj == null) {
                        throw new TypeCastException("null cannot be cast to non-null type com.iqoption.chat.component.AttachmentItem");
                    }
                    aVar = (a) obj;
                    a((at) axVar, aVar.Ox(), aVar.Oy(), aVar.Oz());
                    return;
                case 22:
                    obj = this.nj.get(i);
                    if (obj == null) {
                        throw new TypeCastException("null cannot be cast to non-null type com.iqoption.chat.component.MessageItem");
                    }
                    aaVar = (aa) obj;
                    a((t) axVar, aaVar.Ox(), aaVar.Oz());
                    return;
                case 23:
                    obj = this.nj.get(i);
                    if (obj == null) {
                        throw new TypeCastException("null cannot be cast to non-null type com.iqoption.chat.component.MessageItem");
                    }
                    aaVar = (aa) obj;
                    a((as) axVar, aaVar.Ox(), aaVar.Oz());
                    return;
                case 24:
                    obj = this.nj.get(i);
                    if (obj == null) {
                        throw new TypeCastException("null cannot be cast to non-null type com.iqoption.chat.component.SuggestionItem");
                    }
                    a((an) axVar, ((am) obj).Pr());
                    return;
                default:
                    return;
            }
        }
        TextView textView = ((ci) ((f) axVar).getBinding()).bmq;
        kotlin.jvm.internal.h.d(textView, "binding.emptyText");
        textView.setText(this.aDC);
    }

    private final void a(ap apVar, com.iqoption.microservice.chat.g gVar) {
        apVar.a(gVar);
        TextView textView = ((eq) apVar.getBinding()).bmr;
        kotlin.jvm.internal.h.d(textView, "binding.author");
        textView.setText(gVar.arn());
        MessageView messageView = ((eq) apVar.getBinding()).bmS;
        kotlin.jvm.internal.h.d(messageView, "binding.message");
        a(gVar, messageView);
        ImageView imageView = ((eq) apVar.getBinding()).bmj;
        kotlin.jvm.internal.h.d(imageView, "binding.avatar");
        a(gVar, imageView);
    }

    private final void a(com.iqoption.microservice.chat.g gVar, MessageView messageView) {
        messageView.setText(gVar.getText());
        messageView.setTime(this.aDM.format(Long.valueOf(gVar.getDate())));
    }

    private final void a(aq aqVar, com.iqoption.microservice.chat.g gVar) {
        aqVar.a(gVar);
        MessageView messageView = ((es) aqVar.getBinding()).bmS;
        kotlin.jvm.internal.h.d(messageView, "binding.message");
        a(gVar, messageView);
        TextView textView = ((es) aqVar.getBinding()).bmr;
        kotlin.jvm.internal.h.d(textView, "binding.author");
        textView.setText(gVar.arn());
    }

    private final void a(ao aoVar, com.iqoption.microservice.chat.g gVar) {
        aoVar.a(gVar);
        MessageView messageView = ((eo) aoVar.getBinding()).bmS;
        kotlin.jvm.internal.h.d(messageView, "binding.message");
        a(gVar, messageView);
    }

    private final void a(ar arVar, com.iqoption.microservice.chat.g gVar) {
        arVar.a(gVar);
        MessageView messageView = ((eu) arVar.getBinding()).bmS;
        kotlin.jvm.internal.h.d(messageView, "binding.message");
        a(gVar, messageView);
        ImageView imageView = ((eu) arVar.getBinding()).bmj;
        kotlin.jvm.internal.h.d(imageView, "binding.avatar");
        a(gVar, imageView);
    }

    private final void a(o oVar, com.iqoption.microservice.chat.a aVar, com.iqoption.microservice.chat.g gVar) {
        oVar.a(aVar);
        oVar.a(gVar);
        TextView textView = ((di) oVar.getBinding()).bmr;
        kotlin.jvm.internal.h.d(textView, "binding.author");
        textView.setText(gVar.arn());
        textView = ((di) oVar.getBinding()).aiq;
        kotlin.jvm.internal.h.d(textView, "binding.time");
        textView.setText(this.aDM.format(Long.valueOf(gVar.getDate())));
        ImageView imageView = ((di) oVar.getBinding()).blY;
        kotlin.jvm.internal.h.d(imageView, "binding.preview");
        a(aVar, imageView);
        ImageView imageView2 = ((di) oVar.getBinding()).bmj;
        kotlin.jvm.internal.h.d(imageView2, "binding.avatar");
        a(gVar, imageView2);
    }

    private final void a(p pVar, com.iqoption.microservice.chat.a aVar, com.iqoption.microservice.chat.g gVar) {
        pVar.a(aVar);
        pVar.a(gVar);
        TextView textView = ((dk) pVar.getBinding()).bmr;
        kotlin.jvm.internal.h.d(textView, "binding.author");
        textView.setText(gVar.arn());
        textView = ((dk) pVar.getBinding()).aiq;
        kotlin.jvm.internal.h.d(textView, "binding.time");
        textView.setText(this.aDM.format(Long.valueOf(gVar.getDate())));
        ImageView imageView = ((dk) pVar.getBinding()).blY;
        kotlin.jvm.internal.h.d(imageView, "binding.preview");
        a(aVar, imageView);
    }

    private final void a(n nVar, com.iqoption.microservice.chat.a aVar, com.iqoption.microservice.chat.g gVar) {
        nVar.a(aVar);
        nVar.a(gVar);
        TextView textView = ((dg) nVar.getBinding()).aiq;
        kotlin.jvm.internal.h.d(textView, "binding.time");
        textView.setText(this.aDM.format(Long.valueOf(gVar.getDate())));
        ImageView imageView = ((dg) nVar.getBinding()).blY;
        kotlin.jvm.internal.h.d(imageView, "binding.preview");
        a(aVar, imageView);
    }

    private final void a(q qVar, com.iqoption.microservice.chat.a aVar, com.iqoption.microservice.chat.g gVar) {
        qVar.a(aVar);
        qVar.a(gVar);
        TextView textView = ((dm) qVar.getBinding()).aiq;
        kotlin.jvm.internal.h.d(textView, "binding.time");
        textView.setText(this.aDM.format(Long.valueOf(gVar.getDate())));
        ImageView imageView = ((dm) qVar.getBinding()).blY;
        kotlin.jvm.internal.h.d(imageView, "binding.preview");
        a(aVar, imageView);
        ImageView imageView2 = ((dm) qVar.getBinding()).bmj;
        kotlin.jvm.internal.h.d(imageView2, "binding.avatar");
        a(gVar, imageView2);
    }

    private final void a(k kVar, com.iqoption.microservice.chat.a aVar, com.iqoption.microservice.chat.g gVar) {
        kVar.a(aVar);
        kVar.a(gVar);
        TextView textView = ((cm) kVar.getBinding()).bmr;
        kotlin.jvm.internal.h.d(textView, "binding.author");
        textView.setText(gVar.arn());
        textView = ((cm) kVar.getBinding()).aig;
        kotlin.jvm.internal.h.d(textView, "binding.name");
        textView.setText(b(aVar));
        TextView textView2 = ((cm) kVar.getBinding()).aiq;
        kotlin.jvm.internal.h.d(textView2, "binding.time");
        textView2.setText(this.aDM.format(Long.valueOf(gVar.getDate())));
        ImageView imageView = ((cm) kVar.getBinding()).bmj;
        kotlin.jvm.internal.h.d(imageView, "binding.avatar");
        a(gVar, imageView);
    }

    private final void a(l lVar, com.iqoption.microservice.chat.a aVar, com.iqoption.microservice.chat.g gVar) {
        lVar.a(aVar);
        lVar.a(gVar);
        TextView textView = ((co) lVar.getBinding()).bmr;
        kotlin.jvm.internal.h.d(textView, "binding.author");
        textView.setText(gVar.arn());
        textView = ((co) lVar.getBinding()).aig;
        kotlin.jvm.internal.h.d(textView, "binding.name");
        textView.setText(b(aVar));
        TextView textView2 = ((co) lVar.getBinding()).aiq;
        kotlin.jvm.internal.h.d(textView2, "binding.time");
        textView2.setText(this.aDM.format(Long.valueOf(gVar.getDate())));
    }

    private final void a(j jVar, com.iqoption.microservice.chat.a aVar, com.iqoption.microservice.chat.g gVar) {
        jVar.a(aVar);
        jVar.a(gVar);
        TextView textView = ((ck) jVar.getBinding()).aig;
        kotlin.jvm.internal.h.d(textView, "binding.name");
        textView.setText(b(aVar));
        TextView textView2 = ((ck) jVar.getBinding()).aiq;
        kotlin.jvm.internal.h.d(textView2, "binding.time");
        textView2.setText(this.aDM.format(Long.valueOf(gVar.getDate())));
    }

    private final void a(m mVar, com.iqoption.microservice.chat.a aVar, com.iqoption.microservice.chat.g gVar) {
        mVar.a(aVar);
        mVar.a(gVar);
        TextView textView = ((cq) mVar.getBinding()).aig;
        kotlin.jvm.internal.h.d(textView, "binding.name");
        textView.setText(b(aVar));
        TextView textView2 = ((cq) mVar.getBinding()).aiq;
        kotlin.jvm.internal.h.d(textView2, "binding.time");
        textView2.setText(this.aDM.format(Long.valueOf(gVar.getDate())));
        ImageView imageView = ((cq) mVar.getBinding()).bmj;
        kotlin.jvm.internal.h.d(imageView, "binding.avatar");
        a(gVar, imageView);
    }

    private final void a(com.iqoption.microservice.chat.g gVar, ImageView imageView) {
        Picasso picasso = this.picasso;
        if (picasso == null) {
            kotlin.jvm.internal.h.lS("picasso");
        }
        picasso.cancelRequest(imageView);
        CharSequence arr = gVar.arr();
        Object obj = (arr == null || arr.length() == 0) ? 1 : null;
        if (obj != null) {
            String aA = com.iqoption.core.util.f.bgP.aA(gVar.arp());
            if (aA == null) {
                imageView.setImageDrawable(this.aDG);
                return;
            }
            picasso = this.picasso;
            if (picasso == null) {
                kotlin.jvm.internal.h.lS("picasso");
            }
            picasso.load(aA).placeholder(this.aDG).resize(this.aDI, this.aDI).into(imageView);
            return;
        }
        picasso = this.picasso;
        if (picasso == null) {
            kotlin.jvm.internal.h.lS("picasso");
        }
        picasso.load(gVar.arr()).placeholder(this.aDG).transform((Transformation) this.aDH).into(imageView);
    }

    private final void a(com.iqoption.microservice.chat.a aVar, ImageView imageView) {
        imageView.setImageDrawable(null);
        Picasso picasso = this.picasso;
        if (picasso == null) {
            kotlin.jvm.internal.h.lS("picasso");
        }
        picasso.cancelRequest(imageView);
        picasso = this.picasso;
        if (picasso == null) {
            kotlin.jvm.internal.h.lS("picasso");
        }
        picasso.load(aVar.getUrl()).resize(this.aDK, this.aDL).centerCrop().transform((Transformation) this.aDJ).into(imageView);
    }

    private final void a(ae aeVar, com.iqoption.microservice.chat.g gVar, int i) {
        aeVar.a(gVar);
        MessageView messageView = ((dy) aeVar.getBinding()).bmS;
        kotlin.jvm.internal.h.d(messageView, "binding.message");
        a(gVar, messageView);
        TextView textView = ((dy) aeVar.getBinding()).bmr;
        kotlin.jvm.internal.h.d(textView, "binding.author");
        ImageView imageView = ((dy) aeVar.getBinding()).bmj;
        kotlin.jvm.internal.h.d(imageView, "binding.avatar");
        a(gVar, i, textView, imageView);
        switch (i) {
            case 2:
            case 3:
                ((dy) aeVar.getBinding()).bms.setBackgroundResource(R.drawable.chat_message_bubble_left_body);
                break;
            default:
                ((dy) aeVar.getBinding()).bms.setBackgroundResource(R.drawable.chat_message_bubble_left_head);
                break;
        }
        com.iqoption.microservice.chat.i arh = gVar.arh();
        boolean arF = arh.arF();
        StarBar starBar = ((dy) aeVar.getBinding()).bmT;
        kotlin.jvm.internal.h.d(starBar, "binding.starBar");
        starBar.setEnabled(arF);
        StarBar starBar2;
        FrameLayout frameLayout;
        if (arF) {
            starBar2 = ((dy) aeVar.getBinding()).bmT;
            kotlin.jvm.internal.h.d(starBar2, "binding.starBar");
            com.iqoption.core.ext.a.L(starBar2);
            frameLayout = ((dy) aeVar.getBinding()).bmV;
            kotlin.jvm.internal.h.d(frameLayout, "binding.thanksLayout");
            com.iqoption.core.ext.a.hide(frameLayout);
        } else {
            starBar2 = ((dy) aeVar.getBinding()).bmT;
            kotlin.jvm.internal.h.d(starBar2, "binding.starBar");
            com.iqoption.core.ext.a.M(starBar2);
            frameLayout = ((dy) aeVar.getBinding()).bmV;
            kotlin.jvm.internal.h.d(frameLayout, "binding.thanksLayout");
            com.iqoption.core.ext.a.L(frameLayout);
            ((dy) aeVar.getBinding()).bmU.setText(getString(R.string.your_rating_is_n1_out_of_5, Integer.valueOf(arh.arD())));
            ((dy) aeVar.getBinding()).bmU.setTime(this.aDM.format(Long.valueOf(arh.arE())));
        }
        StarBar starBar3 = ((dy) aeVar.getBinding()).bmT;
        kotlin.jvm.internal.h.d(starBar3, "binding.starBar");
        starBar3.setStars(arh.arD());
    }

    private final void a(av avVar, com.iqoption.microservice.chat.g gVar, int i) {
        Drawable e;
        avVar.a(gVar);
        MessageView messageView = ((fc) avVar.getBinding()).bmS;
        kotlin.jvm.internal.h.d(messageView, "binding.message");
        a(gVar, messageView);
        MessageView messageView2 = ((fc) avVar.getBinding()).bmS;
        kotlin.jvm.internal.h.d(messageView2, "binding.message");
        switch (i) {
            case 1:
                e = com.iqoption.core.ext.a.e((ViewHolder) avVar, (int) R.drawable.bg_message_bubble_right_head);
                break;
            case 2:
                e = com.iqoption.core.ext.a.e((ViewHolder) avVar, (int) R.drawable.bg_message_bubble_right_body);
                break;
            case 3:
                e = com.iqoption.core.ext.a.e((ViewHolder) avVar, (int) R.drawable.bg_message_bubble_right_tail);
                break;
            default:
                e = com.iqoption.core.ext.a.e((ViewHolder) avVar, (int) R.drawable.bg_message_bubble_right);
                break;
        }
        messageView2.setBackground(e);
    }

    private final void a(au auVar, com.iqoption.microservice.chat.g gVar, com.iqoption.microservice.chat.a aVar) {
        auVar.a(gVar);
        auVar.a(aVar);
        TextView textView = ((fa) auVar.getBinding()).aiq;
        kotlin.jvm.internal.h.d(textView, "binding.time");
        textView.setText(this.aDM.format(Long.valueOf(gVar.getDate())));
        ImageView imageView = ((fa) auVar.getBinding()).blY;
        kotlin.jvm.internal.h.d(imageView, "binding.preview");
        a(aVar, imageView);
    }

    private final void a(at atVar, com.iqoption.microservice.chat.g gVar, com.iqoption.microservice.chat.a aVar, int i) {
        Drawable e;
        atVar.a(gVar);
        atVar.a(aVar);
        TextView textView = ((ey) atVar.getBinding()).aiq;
        kotlin.jvm.internal.h.d(textView, "binding.time");
        textView.setText(this.aDM.format(Long.valueOf(gVar.getDate())));
        TextView textView2 = ((ey) atVar.getBinding()).aig;
        kotlin.jvm.internal.h.d(textView2, "binding.name");
        textView2.setText(b(aVar));
        textView2 = ((ey) atVar.getBinding()).aig;
        kotlin.jvm.internal.h.d(textView2, "binding.name");
        switch (i) {
            case 1:
                e = com.iqoption.core.ext.a.e((ViewHolder) atVar, (int) R.drawable.bg_message_bubble_right_head);
                break;
            case 2:
                e = com.iqoption.core.ext.a.e((ViewHolder) atVar, (int) R.drawable.bg_message_bubble_right_body);
                break;
            case 3:
                e = com.iqoption.core.ext.a.e((ViewHolder) atVar, (int) R.drawable.bg_message_bubble_right_tail);
                break;
            default:
                e = com.iqoption.core.ext.a.e((ViewHolder) atVar, (int) R.drawable.bg_message_bubble_right);
                break;
        }
        textView2.setBackground(e);
    }

    private final String b(com.iqoption.microservice.chat.a aVar) {
        String url = aVar.getUrl();
        if (url == null) {
            return null;
        }
        url = v.c(url, "/", null, 2, null);
        if (url == null) {
            return null;
        }
        List b = v.b((CharSequence) url, new String[]{"."}, false, 0, 6, null);
        if (b.size() > 1) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(x.ac(url, ((String) b.get(b.size() - 1)).length()));
            url = (String) b.get(b.size() - 1);
            if (url == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            url = url.toUpperCase();
            kotlin.jvm.internal.h.d(url, "(this as java.lang.String).toUpperCase()");
            stringBuilder.append(url);
            url = stringBuilder.toString();
        }
        return url;
    }

    private final void a(t tVar, com.iqoption.microservice.chat.g gVar, int i) {
        tVar.a(gVar);
        MessageView messageView = ((dq) tVar.getBinding()).bmS;
        kotlin.jvm.internal.h.d(messageView, "binding.message");
        a(gVar, messageView);
        TextView textView = ((dq) tVar.getBinding()).bmr;
        kotlin.jvm.internal.h.d(textView, "binding.author");
        ImageView imageView = ((dq) tVar.getBinding()).bmj;
        kotlin.jvm.internal.h.d(imageView, "binding.avatar");
        a(gVar, i, textView, imageView);
        switch (i) {
            case 0:
                ((dq) tVar.getBinding()).bms.setBackgroundResource(R.drawable.chat_message_bubble_left_head);
                ((dq) tVar.getBinding()).bmP.setBackgroundResource(R.drawable.chat_message_bubble_left_tail);
                break;
            case 1:
                ((dq) tVar.getBinding()).bms.setBackgroundResource(R.drawable.chat_message_bubble_left_head);
                ((dq) tVar.getBinding()).bmP.setBackgroundResource(R.drawable.chat_message_bubble_left_body);
                break;
            case 2:
                ((dq) tVar.getBinding()).bms.setBackgroundResource(R.drawable.chat_message_bubble_left_body);
                ((dq) tVar.getBinding()).bmP.setBackgroundResource(R.drawable.chat_message_bubble_left_body);
                break;
            case 3:
                ((dq) tVar.getBinding()).bms.setBackgroundResource(R.drawable.chat_message_bubble_left_body);
                ((dq) tVar.getBinding()).bmP.setBackgroundResource(R.drawable.chat_message_bubble_left_tail);
                break;
        }
        Boolean arC = gVar.arj().arC();
        if (arC == null) {
            a(tVar, true);
            a(tVar, false, false);
        } else if (kotlin.jvm.internal.h.E(arC, Boolean.valueOf(true))) {
            a(tVar, false);
            a(tVar, true, false);
        } else if (kotlin.jvm.internal.h.E(arC, Boolean.valueOf(false))) {
            a(tVar, false);
            a(tVar, false, true);
        }
    }

    private final void a(t tVar, boolean z) {
        ImageView imageView = ((dq) tVar.getBinding()).bmR;
        kotlin.jvm.internal.h.d(imageView, "binding.like");
        imageView.setEnabled(z);
        ImageView imageView2 = ((dq) tVar.getBinding()).bmQ;
        kotlin.jvm.internal.h.d(imageView2, "binding.dislike");
        imageView2.setEnabled(z);
    }

    private final void a(t tVar, boolean z, boolean z2) {
        ImageView imageView = ((dq) tVar.getBinding()).bmR;
        kotlin.jvm.internal.h.d(imageView, "binding.like");
        imageView.setActivated(z);
        ImageView imageView2 = ((dq) tVar.getBinding()).bmQ;
        kotlin.jvm.internal.h.d(imageView2, "binding.dislike");
        imageView2.setActivated(z2);
    }

    private final void a(as asVar, com.iqoption.microservice.chat.g gVar, int i) {
        asVar.a(gVar);
        MessageView messageView = ((ew) asVar.getBinding()).bmS;
        kotlin.jvm.internal.h.d(messageView, "binding.message");
        a(gVar, messageView);
        TextView textView = ((ew) asVar.getBinding()).bmr;
        kotlin.jvm.internal.h.d(textView, "binding.author");
        ImageView imageView = ((ew) asVar.getBinding()).bmj;
        kotlin.jvm.internal.h.d(imageView, "binding.avatar");
        a(gVar, i, textView, imageView);
        switch (i) {
            case 2:
                ((ew) asVar.getBinding()).bms.setBackgroundResource(R.drawable.chat_message_bubble_left_body);
                break;
            case 3:
                ((ew) asVar.getBinding()).bms.setBackgroundResource(R.drawable.chat_message_bubble_left_tail);
                break;
            default:
                ((ew) asVar.getBinding()).bms.setBackgroundResource(R.drawable.chat_message_bubble_left_head);
                break;
        }
        TextView textView2 = ((ew) asVar.getBinding()).bnd;
        if (gVar.ark().arG()) {
            textView2.setEnabled(false);
            textView2.setAlpha(0.5f);
            return;
        }
        textView2.setEnabled(true);
        textView2.setAlpha(1.0f);
    }

    private final void a(com.iqoption.microservice.chat.g gVar, int i, TextView textView, ImageView imageView) {
        switch (i) {
            case 0:
                com.iqoption.core.ext.a.L(textView);
                textView.setText(gVar.arn());
                com.iqoption.core.ext.a.L(imageView);
                a(gVar, imageView);
                return;
            case 1:
                com.iqoption.core.ext.a.L(textView);
                textView.setText(gVar.arn());
                com.iqoption.core.ext.a.M(imageView);
                return;
            case 2:
                com.iqoption.core.ext.a.M(textView);
                com.iqoption.core.ext.a.M(imageView);
                return;
            case 3:
                com.iqoption.core.ext.a.M(textView);
                com.iqoption.core.ext.a.L(imageView);
                a(gVar, imageView);
                return;
            default:
                return;
        }
    }

    private final void a(an anVar, com.iqoption.core.microservices.b.a.a aVar) {
        anVar.a(aVar);
        TextView textView = ((em) anVar.getBinding()).bnc;
        kotlin.jvm.internal.h.d(textView, "binding.suggestion");
        textView.setText(anVar.Ps().getName());
    }

    public int getItemViewType(int i) {
        return this.aDF.get(i);
    }

    public long getItemId(int i) {
        return this.aDE.a((y) this.nj.get(i));
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        kotlin.jvm.internal.h.e(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        Context context = recyclerView.getContext();
        Picasso with = Picasso.with(context);
        kotlin.jvm.internal.h.d(with, "Picasso.with(this)");
        this.picasso = with;
        AssetManager assets = context.getAssets();
        kotlin.jvm.internal.h.d(assets, "assets");
        this.assetManager = assets;
        LayoutInflater from = LayoutInflater.from(context);
        kotlin.jvm.internal.h.d(from, "LayoutInflater.from(this)");
        this.aDN = from;
        this.aDO = new TextAppearanceSpan(context, R.style.ChatMessageDateTextAppearance.Bold);
        this.aDP = new TextAppearanceSpan(context, R.style.ChatMessageDateTextAppearance);
    }

    public final void b(List<? extends y> list, DiffResult diffResult) {
        this.nj.clear();
        if (list != null) {
            this.nj.addAll(list);
        }
        if (diffResult != null) {
            diffResult.dispatchUpdatesTo((Adapter) this);
        } else {
            notifyDataSetChanged();
        }
    }

    public final void fJ(String str) {
        kotlin.jvm.internal.h.e(str, "messageId");
        Object obj = null;
        int i = 0;
        for (y yVar : this.nj) {
            Object obj2 = ((yVar instanceof aa) && kotlin.jvm.internal.h.E(((aa) yVar).Ox().getId(), str)) ? 1 : null;
            if (obj2 != null) {
                break;
            }
            i++;
        }
        i = -1;
        Integer valueOf = Integer.valueOf(i);
        if (valueOf.intValue() != -1) {
            obj = 1;
        }
        if (obj == null) {
            valueOf = null;
        }
        if (valueOf != null) {
            notifyItemChanged(valueOf.intValue());
        }
    }
}
