package com.iqoption.fragment.leftmenu.content;

import com.iqoption.x.R;

public enum HistoryMenu implements a {
    Operations {
        public int getNameToDisplay() {
            return R.string.operations1;
        }
    },
    Trading {
        public int getNameToDisplay() {
            return R.string.trading1;
        }
    };
    
    private boolean isEnabled;

    public String analyticsEventName() {
        return "";
    }

    public a getChild(int i) {
        return null;
    }

    public int getChildCount() {
        return 0;
    }

    public int getCollapseIcon() {
        return 0;
    }

    public int getExpandIcon() {
        return 0;
    }

    public int getIcon() {
        return 0;
    }

    public boolean isClickable() {
        return true;
    }

    public boolean isInProgress() {
        return false;
    }

    public boolean isVisible() {
        return true;
    }

    public int layoutResId() {
        return R.layout.left_menu_item_child;
    }

    public int menuPriority() {
        return 2;
    }

    public boolean isEnabled() {
        return this.isEnabled;
    }

    public boolean setEnabled(boolean z) {
        if (this.isEnabled == z) {
            return false;
        }
        this.isEnabled = z;
        return true;
    }

    public int getSize() {
        return isVisible();
    }
}
