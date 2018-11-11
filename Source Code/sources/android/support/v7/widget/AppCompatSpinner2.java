package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import com.iqoption.x.R;

public class AppCompatSpinner2 extends Spinner {
    private static final int[] ATTRS_ANDROID_SPINNERMODE = new int[]{16843505};
    private static final boolean IS_AT_LEAST_JB = (VERSION.SDK_INT >= 16);
    private static final boolean IS_AT_LEAST_M = (VERSION.SDK_INT >= 23);
    private static final int MAX_ITEMS_MEASURED = 15;
    private static final int MODE_DIALOG = 0;
    private static final int MODE_DROPDOWN = 1;
    private static final int MODE_THEME = -1;
    private static final String TAG = "AppCompatSpinner";
    private boolean isOpened;
    private int mDropDownWidth;
    private ForwardingListener mForwardingListener;
    private DropdownPopup mPopup;
    private Context mPopupContext;
    private boolean mPopupSet;
    private SpinnerAdapter mTempAdapter;
    private final Rect mTempRect;
    private int maxHeight;
    private OnSpinnerEventsListener onSpinnerEventsListener;

    private static class DropDownAdapter implements ListAdapter, SpinnerAdapter {
        private SpinnerAdapter mAdapter;
        private ListAdapter mListAdapter;

        public int getItemViewType(int i) {
            return 0;
        }

        public int getViewTypeCount() {
            return 1;
        }

        public DropDownAdapter(@Nullable SpinnerAdapter spinnerAdapter, @Nullable Theme theme) {
            this.mAdapter = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.mListAdapter = (ListAdapter) spinnerAdapter;
            }
            if (theme == null) {
                return;
            }
            if (VERSION.SDK_INT >= 23 && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
                if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                    themedSpinnerAdapter.setDropDownViewTheme(theme);
                }
            } else if (spinnerAdapter instanceof ThemedSpinnerAdapter) {
                ThemedSpinnerAdapter themedSpinnerAdapter2 = (ThemedSpinnerAdapter) spinnerAdapter;
                if (themedSpinnerAdapter2.getDropDownViewTheme() == null) {
                    themedSpinnerAdapter2.setDropDownViewTheme(theme);
                }
            }
        }

        public int getCount() {
            return this.mAdapter == null ? 0 : this.mAdapter.getCount();
        }

        public Object getItem(int i) {
            return this.mAdapter == null ? null : this.mAdapter.getItem(i);
        }

        public long getItemId(int i) {
            return this.mAdapter == null ? -1 : this.mAdapter.getItemId(i);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            return getDropDownView(i, view, viewGroup);
        }

        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            if (this.mAdapter == null) {
                return null;
            }
            return this.mAdapter.getDropDownView(i, view, viewGroup);
        }

        public boolean hasStableIds() {
            return this.mAdapter != null && this.mAdapter.hasStableIds();
        }

        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.mAdapter != null) {
                this.mAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.mAdapter != null) {
                this.mAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }

        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.mListAdapter;
            return listAdapter != null ? listAdapter.areAllItemsEnabled() : true;
        }

        public boolean isEnabled(int i) {
            ListAdapter listAdapter = this.mListAdapter;
            return listAdapter != null ? listAdapter.isEnabled(i) : true;
        }

        public boolean isEmpty() {
            return getCount() == 0;
        }
    }

    public interface OnSpinnerEventsListener {
        void onSpinnerClosed();

        void onSpinnerOpened();
    }

    private class DropdownPopup extends ListPopupWindow {
        private ListAdapter mAdapter;
        private CharSequence mHintText;
        private final Rect mVisibleRect = new Rect();

        public DropdownPopup(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            setAnchorView(AppCompatSpinner2.this);
            setModal(true);
            setPromptPosition(0);
            setOnItemClickListener(new OnItemClickListener(AppCompatSpinner2.this) {
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    AppCompatSpinner2.this.setSelection(i);
                    if (AppCompatSpinner2.this.getOnItemClickListener() != null) {
                        AppCompatSpinner2.this.performItemClick(view, i, DropdownPopup.this.mAdapter.getItemId(i));
                    }
                    DropdownPopup.this.dismiss();
                }
            });
        }

        public void setAdapter(ListAdapter listAdapter) {
            super.setAdapter(listAdapter);
            this.mAdapter = listAdapter;
        }

        public CharSequence getHintText() {
            return this.mHintText;
        }

        public void setPromptText(CharSequence charSequence) {
            this.mHintText = charSequence;
        }

        void computeContentWidth() {
            int i;
            Drawable background = getBackground();
            int i2 = 0;
            if (background != null) {
                background.getPadding(AppCompatSpinner2.this.mTempRect);
                if (ViewUtils.isLayoutRtl(AppCompatSpinner2.this)) {
                    i = AppCompatSpinner2.this.mTempRect.right;
                } else {
                    i = -AppCompatSpinner2.this.mTempRect.left;
                }
                i2 = i;
            } else {
                Rect access$200 = AppCompatSpinner2.this.mTempRect;
                AppCompatSpinner2.this.mTempRect.right = 0;
                access$200.left = 0;
            }
            i = AppCompatSpinner2.this.getPaddingLeft();
            int paddingRight = AppCompatSpinner2.this.getPaddingRight();
            int width = AppCompatSpinner2.this.getWidth();
            if (AppCompatSpinner2.this.mDropDownWidth == -2) {
                int access$400 = AppCompatSpinner2.this.compatMeasureContentWidth((SpinnerAdapter) this.mAdapter, getBackground());
                int i3 = (AppCompatSpinner2.this.getContext().getResources().getDisplayMetrics().widthPixels - AppCompatSpinner2.this.mTempRect.left) - AppCompatSpinner2.this.mTempRect.right;
                if (access$400 > i3) {
                    access$400 = i3;
                }
                setContentWidth(Math.max(access$400, (width - i) - paddingRight));
            } else if (AppCompatSpinner2.this.mDropDownWidth == -1) {
                setContentWidth((width - i) - paddingRight);
            } else {
                setContentWidth(AppCompatSpinner2.this.mDropDownWidth);
            }
            setHorizontalOffset(ViewUtils.isLayoutRtl(AppCompatSpinner2.this) ? i2 + ((width - paddingRight) - getWidth()) : i2 + i);
        }

        public void show() {
            boolean isShowing = isShowing();
            computeContentWidth();
            setInputMethodMode(2);
            super.access$701();
            getListView().setChoiceMode(1);
            setSelection(AppCompatSpinner2.this.getSelectedItemPosition());
            if (!isShowing) {
                ViewTreeObserver viewTreeObserver = AppCompatSpinner2.this.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    final OnGlobalLayoutListener anonymousClass2 = new OnGlobalLayoutListener() {
                        public void onGlobalLayout() {
                            if (DropdownPopup.this.isVisibleToUser(AppCompatSpinner2.this)) {
                                DropdownPopup.this.computeContentWidth();
                                int access$600 = AppCompatSpinner2.this.compatMeasureContentHeight(AppCompatSpinner2.this.getAdapter(), DropdownPopup.this.getBackground());
                                int maxHeight = AppCompatSpinner2.this.getMaxHeight();
                                if (maxHeight > 0 && access$600 > maxHeight) {
                                    DropdownPopup.this.setHeight(maxHeight);
                                }
                                super.access$701();
                                return;
                            }
                            DropdownPopup.this.dismiss();
                        }
                    };
                    viewTreeObserver.addOnGlobalLayoutListener(anonymousClass2);
                    setOnDismissListener(new OnDismissListener() {
                        public void onDismiss() {
                            ViewTreeObserver viewTreeObserver = AppCompatSpinner2.this.getViewTreeObserver();
                            if (viewTreeObserver != null) {
                                viewTreeObserver.removeGlobalOnLayoutListener(anonymousClass2);
                            }
                        }
                    });
                }
            }
        }

        private boolean isVisibleToUser(View view) {
            return ViewCompat.isAttachedToWindow(view) && view.getGlobalVisibleRect(this.mVisibleRect);
        }
    }

    public AppCompatSpinner2(Context context) {
        this(context, null);
    }

    public AppCompatSpinner2(Context context, int i) {
        this(context, null, R.attr.spinnerStyle, i);
    }

    public AppCompatSpinner2(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.spinnerStyle);
    }

    public AppCompatSpinner2(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, -1);
    }

    public AppCompatSpinner2(Context context, AttributeSet attributeSet, int i, int i2) {
        this(context, attributeSet, i, i2, null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0068  */
    /* JADX WARNING: Missing block: B:19:0x004e, code:
            if (r7 != null) goto L_0x0050;
     */
    /* JADX WARNING: Missing block: B:20:0x0050, code:
            r7.recycle();
     */
    /* JADX WARNING: Missing block: B:28:0x0062, code:
            if (r7 != null) goto L_0x0050;
     */
    public AppCompatSpinner2(android.content.Context r7, android.util.AttributeSet r8, int r9, int r10, android.content.res.Resources.Theme r11) {
        /*
        r6 = this;
        r6.<init>(r7, r8, r9);
        r0 = new android.graphics.Rect;
        r0.<init>();
        r6.mTempRect = r0;
        r0 = -1;
        r6.maxHeight = r0;
        r1 = android.support.v7.appcompat.R.styleable.Spinner;
        r2 = 0;
        r1 = android.support.v7.widget.TintTypedArray.obtainStyledAttributes(r7, r8, r1, r9, r2);
        if (r11 == 0) goto L_0x001e;
    L_0x0016:
        r3 = new android.support.v7.view.ContextThemeWrapper;
        r3.<init>(r7, r11);
        r6.mPopupContext = r3;
        goto L_0x002f;
    L_0x001e:
        r11 = 4;
        r11 = r1.getResourceId(r11, r2);
        if (r11 == 0) goto L_0x002d;
    L_0x0025:
        r3 = new android.support.v7.view.ContextThemeWrapper;
        r3.<init>(r7, r11);
        r6.mPopupContext = r3;
        goto L_0x002f;
    L_0x002d:
        r6.mPopupContext = r7;
    L_0x002f:
        r11 = r6.mPopupContext;
        r3 = 0;
        r4 = 1;
        if (r11 == 0) goto L_0x00a1;
    L_0x0035:
        if (r10 != r0) goto L_0x006d;
    L_0x0037:
        r11 = android.os.Build.VERSION.SDK_INT;
        r0 = 11;
        if (r11 < r0) goto L_0x006c;
    L_0x003d:
        r11 = ATTRS_ANDROID_SPINNERMODE;	 Catch:{ Exception -> 0x0059, all -> 0x0056 }
        r7 = r7.obtainStyledAttributes(r8, r11, r9, r2);	 Catch:{ Exception -> 0x0059, all -> 0x0056 }
        r11 = r7.hasValue(r2);	 Catch:{ Exception -> 0x0054 }
        if (r11 == 0) goto L_0x004e;
    L_0x0049:
        r11 = r7.getInt(r2, r2);	 Catch:{ Exception -> 0x0054 }
        r10 = r11;
    L_0x004e:
        if (r7 == 0) goto L_0x006d;
    L_0x0050:
        r7.recycle();
        goto L_0x006d;
    L_0x0054:
        r11 = move-exception;
        goto L_0x005b;
    L_0x0056:
        r8 = move-exception;
        r7 = r3;
        goto L_0x0066;
    L_0x0059:
        r11 = move-exception;
        r7 = r3;
    L_0x005b:
        r0 = "AppCompatSpinner";
        r5 = "Could not read android:spinnerMode";
        android.util.Log.i(r0, r5, r11);	 Catch:{ all -> 0x0065 }
        if (r7 == 0) goto L_0x006d;
    L_0x0064:
        goto L_0x0050;
    L_0x0065:
        r8 = move-exception;
    L_0x0066:
        if (r7 == 0) goto L_0x006b;
    L_0x0068:
        r7.recycle();
    L_0x006b:
        throw r8;
    L_0x006c:
        r10 = 1;
    L_0x006d:
        if (r10 != r4) goto L_0x00a1;
    L_0x006f:
        r7 = new android.support.v7.widget.AppCompatSpinner2$DropdownPopup;
        r10 = r6.mPopupContext;
        r7.<init>(r10, r8, r9);
        r10 = r6.mPopupContext;
        r11 = android.support.v7.appcompat.R.styleable.Spinner;
        r8 = android.support.v7.widget.TintTypedArray.obtainStyledAttributes(r10, r8, r11, r9, r2);
        r9 = 3;
        r10 = -2;
        r9 = r8.getLayoutDimension(r9, r10);
        r6.mDropDownWidth = r9;
        r9 = r8.getDrawable(r4);
        r7.setBackgroundDrawable(r9);
        r9 = 2;
        r9 = r1.getString(r9);
        r7.setPromptText(r9);
        r8.recycle();
        r6.mPopup = r7;
        r8 = new android.support.v7.widget.AppCompatSpinner2$1;
        r8.<init>(r6, r7);
        r6.mForwardingListener = r8;
    L_0x00a1:
        r1.recycle();
        r6.mPopupSet = r4;
        r7 = r6.mTempAdapter;
        if (r7 == 0) goto L_0x00b1;
    L_0x00aa:
        r7 = r6.mTempAdapter;
        r6.setAdapter(r7);
        r6.mTempAdapter = r3;
    L_0x00b1:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.AppCompatSpinner2.<init>(android.content.Context, android.util.AttributeSet, int, int, android.content.res.Resources$Theme):void");
    }

    public void setOnSpinnerEventsListener(OnSpinnerEventsListener onSpinnerEventsListener) {
        this.onSpinnerEventsListener = onSpinnerEventsListener;
    }

    public Context getPopupContext() {
        if (this.mPopup != null) {
            return this.mPopupContext;
        }
        return IS_AT_LEAST_M ? super.getPopupContext() : null;
    }

    public void setPopupBackgroundDrawable(Drawable drawable) {
        if (this.mPopup != null) {
            this.mPopup.setBackgroundDrawable(drawable);
        } else if (IS_AT_LEAST_JB) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @RequiresApi(api = 21)
    public void setPopupBackgroundResource(@DrawableRes int i) {
        setPopupBackgroundDrawable(getPopupContext().getDrawable(i));
    }

    public Drawable getPopupBackground() {
        if (this.mPopup != null) {
            return this.mPopup.getBackground();
        }
        return IS_AT_LEAST_JB ? super.getPopupBackground() : null;
    }

    public void setDropDownVerticalOffset(int i) {
        if (this.mPopup != null) {
            this.mPopup.setVerticalOffset(i);
        } else if (IS_AT_LEAST_JB) {
            super.setDropDownVerticalOffset(i);
        }
    }

    public int getDropDownVerticalOffset() {
        if (this.mPopup != null) {
            return this.mPopup.getVerticalOffset();
        }
        return IS_AT_LEAST_JB ? super.getDropDownVerticalOffset() : 0;
    }

    public void setDropDownHorizontalOffset(int i) {
        if (this.mPopup != null) {
            this.mPopup.setHorizontalOffset(i);
        } else if (IS_AT_LEAST_JB) {
            super.setDropDownHorizontalOffset(i);
        }
    }

    public int getDropDownHorizontalOffset() {
        if (this.mPopup != null) {
            return this.mPopup.getHorizontalOffset();
        }
        return IS_AT_LEAST_JB ? super.getDropDownHorizontalOffset() : 0;
    }

    public void setDropDownWidth(int i) {
        if (this.mPopup != null) {
            this.mDropDownWidth = i;
        } else if (IS_AT_LEAST_JB) {
            super.setDropDownWidth(i);
        }
    }

    public int getDropDownWidth() {
        if (this.mPopup != null) {
            return this.mDropDownWidth;
        }
        return IS_AT_LEAST_JB ? super.getDropDownWidth() : 0;
    }

    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (this.mPopupSet) {
            super.setAdapter(spinnerAdapter);
            if (this.mPopup != null) {
                this.mPopup.setAdapter(new DropDownAdapter(spinnerAdapter, (this.mPopupContext == null ? getContext() : this.mPopupContext).getTheme()));
            }
            return;
        }
        this.mTempAdapter = spinnerAdapter;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mPopup != null && this.mPopup.isShowing()) {
            this.mPopup.dismiss();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mForwardingListener == null || !this.mForwardingListener.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.mPopup != null && MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), compatMeasureContentWidth(getAdapter(), getBackground())), MeasureSpec.getSize(i)), getMeasuredHeight());
        }
    }

    public boolean performClick() {
        this.isOpened = true;
        if (this.onSpinnerEventsListener != null) {
            this.onSpinnerEventsListener.onSpinnerOpened();
        }
        if (this.mPopup == null || this.mPopup.isShowing()) {
            return super.performClick();
        }
        this.mPopup.show();
        return true;
    }

    protected void performClosedEvent() {
        if (this.isOpened && this.onSpinnerEventsListener != null) {
            this.onSpinnerEventsListener.onSpinnerClosed();
        }
        this.isOpened = false;
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (!z) {
            performClosedEvent();
        }
    }

    public void setPrompt(CharSequence charSequence) {
        if (this.mPopup != null) {
            this.mPopup.setPromptText(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    public CharSequence getPrompt() {
        return this.mPopup != null ? this.mPopup.getHintText() : super.getPrompt();
    }

    public void setBackgroundResource(@DrawableRes int i) {
        super.setBackgroundResource(i);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
    }

    private int compatMeasureContentWidth(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        View view = null;
        int i2 = 0;
        for (max = Math.max(0, max - (15 - (min - max))); max < min; max++) {
            int itemViewType = spinnerAdapter.getItemViewType(max);
            if (itemViewType != i) {
                view = null;
                i = itemViewType;
            }
            view = spinnerAdapter.getView(max, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i2 = Math.max(i2, view.getMeasuredWidth());
        }
        if (drawable != null) {
            drawable.getPadding(this.mTempRect);
            i2 += this.mTempRect.left + this.mTempRect.right;
        }
        return i2;
    }

    private int compatMeasureContentHeight(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        View view = null;
        int i2 = 0;
        for (max = Math.max(0, max - (15 - (min - max))); max < min; max++) {
            int itemViewType = spinnerAdapter.getItemViewType(max);
            if (itemViewType != i) {
                view = null;
                i = itemViewType;
            }
            view = spinnerAdapter.getView(max, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i2 += view.getMeasuredHeight();
        }
        if (drawable != null) {
            drawable.getPadding(this.mTempRect);
            i2 += this.mTempRect.top + this.mTempRect.bottom;
        }
        return i2;
    }

    public int getMaxHeight() {
        return this.maxHeight;
    }

    public void setMaxHeight(int i) {
        this.maxHeight = i;
    }
}
