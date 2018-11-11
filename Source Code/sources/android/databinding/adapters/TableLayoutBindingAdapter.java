package android.databinding.adapters;

import android.databinding.BindingAdapter;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.util.SparseBooleanArray;
import android.widget.TableLayout;
import java.util.regex.Pattern;

@RestrictTo({Scope.LIBRARY})
public class TableLayoutBindingAdapter {
    private static final int MAX_COLUMNS = 20;
    private static Pattern sColumnPattern = Pattern.compile("\\s*,\\s*");

    @BindingAdapter({"android:collapseColumns"})
    public static void setCollapseColumns(TableLayout tableLayout, CharSequence charSequence) {
        SparseBooleanArray parseColumns = parseColumns(charSequence);
        for (int i = 0; i < 20; i++) {
            boolean z = parseColumns.get(i, false);
            if (z != tableLayout.isColumnCollapsed(i)) {
                tableLayout.setColumnCollapsed(i, z);
            }
        }
    }

    @BindingAdapter({"android:shrinkColumns"})
    public static void setShrinkColumns(TableLayout tableLayout, CharSequence charSequence) {
        int i = 0;
        if (charSequence == null || charSequence.length() <= 0 || charSequence.charAt(0) != '*') {
            tableLayout.setShrinkAllColumns(false);
            SparseBooleanArray parseColumns = parseColumns(charSequence);
            int size = parseColumns.size();
            while (i < size) {
                int keyAt = parseColumns.keyAt(i);
                boolean valueAt = parseColumns.valueAt(i);
                if (valueAt) {
                    tableLayout.setColumnShrinkable(keyAt, valueAt);
                }
                i++;
            }
            return;
        }
        tableLayout.setShrinkAllColumns(true);
    }

    @BindingAdapter({"android:stretchColumns"})
    public static void setStretchColumns(TableLayout tableLayout, CharSequence charSequence) {
        int i = 0;
        if (charSequence == null || charSequence.length() <= 0 || charSequence.charAt(0) != '*') {
            tableLayout.setStretchAllColumns(false);
            SparseBooleanArray parseColumns = parseColumns(charSequence);
            int size = parseColumns.size();
            while (i < size) {
                int keyAt = parseColumns.keyAt(i);
                boolean valueAt = parseColumns.valueAt(i);
                if (valueAt) {
                    tableLayout.setColumnStretchable(keyAt, valueAt);
                }
                i++;
            }
            return;
        }
        tableLayout.setStretchAllColumns(true);
    }

    private static SparseBooleanArray parseColumns(CharSequence charSequence) {
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        if (charSequence == null) {
            return sparseBooleanArray;
        }
        String[] split = sColumnPattern.split(charSequence);
        int length = split.length;
        int i = 0;
        while (i < length) {
            try {
                int parseInt = Integer.parseInt(split[i]);
                if (parseInt >= 0) {
                    sparseBooleanArray.put(parseInt, true);
                }
            } catch (NumberFormatException unused) {
                i++;
            }
        }
        return sparseBooleanArray;
    }
}
