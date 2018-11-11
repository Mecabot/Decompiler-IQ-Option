package jumio.nv.core;

import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.SectionIndexer;
import android.widget.TextView;
import com.jumio.commons.utils.ScreenUtil;
import com.jumio.nv.R;
import com.jumio.nv.data.country.Country;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* compiled from: CountryAdapter */
public class r extends BaseAdapter implements ListAdapter, SectionIndexer {
    private SparseArray<String> a;
    private String b = "";
    private List<Country> c;
    private List<Country> d;

    /* compiled from: CountryAdapter */
    public class a {
        public Country a;
        public TextView b;
    }

    public boolean areAllItemsEnabled() {
        return false;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getViewTypeCount() {
        return 2;
    }

    public r(List<Country> list) {
        this.d = list;
        this.c = b("");
        a();
    }

    public int getCount() {
        return this.c.size() + this.a.size();
    }

    public Object getItem(int i) {
        return this.c.get((i - getSectionForPosition(i)) - 1);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.nv_countrylist_row, viewGroup, false);
            aVar = new a();
            aVar.b = (TextView) view.findViewById(R.id.countryNameTextView);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (itemViewType == 0) {
            aVar.b.getLayoutParams().height = (int) ScreenUtil.dipToPx(viewGroup.getContext(), 28.0f);
            aVar.b.setTypeface(Typeface.DEFAULT_BOLD);
            aVar.b.setTextSize(2, 14.0f);
            aVar.b.setText((CharSequence) this.a.valueAt(getSectionForPosition(i)));
            aVar.a = null;
            view.setContentDescription((CharSequence) this.a.valueAt(getSectionForPosition(i)));
        } else {
            Country country = (Country) getItem(i);
            if (TextUtils.isEmpty(country.getName())) {
                view.setContentDescription(country.getIsoCode());
            } else {
                view.setContentDescription(country.getName());
            }
            aVar.b.getLayoutParams().height = (int) ScreenUtil.dipToPx(viewGroup.getContext(), 56.0f);
            aVar.b.setTypeface(Typeface.DEFAULT);
            aVar.b.setTextSize(2, 16.0f);
            aVar.b.setText(country.getName());
            aVar.a = country;
        }
        return view;
    }

    public Object[] getSections() {
        String[] strArr = new String[this.a.size()];
        for (int i = 0; i < this.a.size(); i++) {
            strArr[i] = (String) this.a.valueAt(i);
        }
        return strArr;
    }

    public int getPositionForSection(int i) {
        if (i < 0) {
            i = 0;
        }
        if (i > this.a.size() - 1) {
            i = this.a.size() - 1;
        }
        return this.a.keyAt(i);
    }

    public int getSectionForPosition(int i) {
        int i2 = 0;
        while (i2 < this.a.size()) {
            int keyAt = this.a.keyAt(i2);
            int i3 = i2 + 1;
            int keyAt2 = i3 < this.a.size() ? this.a.keyAt(i3) : getCount();
            if (i >= keyAt && i < keyAt2) {
                return i2;
            }
            i2 = i3;
        }
        return -1;
    }

    public int getItemViewType(int i) {
        return this.a.indexOfKey(i) < 0 ? 1 : 0;
    }

    public boolean isEnabled(int i) {
        return getItemViewType(i) != 0;
    }

    private List<Country> b(String str) {
        if (str != null) {
            Locale locale = Locale.getDefault();
            str = str.toUpperCase(locale);
            List arrayList = new ArrayList();
            for (Country country : this.d) {
                if (country.getName().toUpperCase(locale).indexOf(str) >= 0) {
                    arrayList.add(country);
                }
            }
            this.c = arrayList;
        }
        return this.c;
    }

    private void a() {
        int size = this.c.size();
        this.a = new SparseArray();
        for (int i = 0; i < size; i++) {
            String substring = ((Country) this.c.get(i)).getName().substring(0, 1);
            if (substring.compareToIgnoreCase("Ä") == 0) {
                substring = "A";
            } else if (substring.compareToIgnoreCase("Å") == 0) {
                substring = "A";
            } else if (substring.compareToIgnoreCase("Ü") == 0) {
                substring = "U";
            } else if (substring.compareToIgnoreCase("Ö") == 0) {
                substring = "O";
            }
            if (c(substring) < 0) {
                this.a.append(this.a.size() + i, substring);
            }
        }
        this.a.size();
    }

    private int c(String str) {
        int i = -1;
        for (int i2 = 0; i2 < this.a.size(); i2++) {
            if (((String) this.a.get(this.a.keyAt(i2))).equals(str)) {
                i = i2;
            }
        }
        return i;
    }

    public void a(String str) {
        if (!this.b.equals(str)) {
            this.b = str;
            this.c = b(str);
            a();
            notifyDataSetChanged();
        }
    }
}
