package com.iqoption.fragment.leftmenu.content;

import com.iqoption.x.R;

public enum MainMenu implements a {
    Profile {
        public int getNameToDisplay() {
            return 0;
        }

        public int layoutResId() {
            return R.layout.left_menu_item_profile;
        }

        public int menuPriority() {
            return 0;
        }
    },
    NotificationVerification {
        public int getIcon() {
            return R.drawable.ic_wtf_24dp;
        }

        public int getNameToDisplay() {
            return R.string.verification;
        }

        public int layoutResId() {
            return R.layout.left_menu_item_notification;
        }
    },
    Debug {
        public int getIcon() {
            return R.drawable.ic_developer_mode;
        }

        public int getNameToDisplay() {
            return R.string.debug_menu;
        }
    },
    Deposit {
        public int getIcon() {
            return R.drawable.ic_plus;
        }

        public int getNameToDisplay() {
            return R.string.deposit;
        }
    },
    WithdrawFunds {
        public int getIcon() {
            return R.drawable.ic_withdraw;
        }

        public int getNameToDisplay() {
            return R.string.withdrawals;
        }
    },
    History {
        final HistoryMenu[] childs;

        public int getCollapseIcon() {
            return R.drawable.clock_rotate_anti_anim;
        }

        public int getExpandIcon() {
            return R.drawable.clock_rotate_anim;
        }

        public int getNameToDisplay() {
            return R.string.history1;
        }

        public int layoutResId() {
            return R.layout.left_menu_item_drop_down;
        }

        public int getChildCount() {
            return MainMenu.count(this.childs);
        }

        public int getSize() {
            return isVisible() + MainMenu.sum(this.childs);
        }

        public a getChild(int i) {
            return MainMenu.findChild(i, this.childs);
        }
    },
    Settings {
        SettingsMenu[] childs;

        public int getCollapseIcon() {
            return R.drawable.settings_rotate_anti_anim;
        }

        public int getExpandIcon() {
            return R.drawable.settings_rotate_anim;
        }

        public int getNameToDisplay() {
            return R.string.settings;
        }

        public int layoutResId() {
            return R.layout.left_menu_item_drop_down;
        }

        public int getChildCount() {
            return MainMenu.sum(this.childs);
        }

        public int getSize() {
            return isVisible() + MainMenu.sum(this.childs);
        }

        public a getChild(int i) {
            return MainMenu.findChild(i, this.childs);
        }
    },
    VipManager {
        VipMangerMenu[] child;

        public String analyticsEventName() {
            return "menu_vip-manager";
        }

        public int getCollapseIcon() {
            return R.drawable.ic_vip_account;
        }

        public int getExpandIcon() {
            return R.drawable.ic_vip_account;
        }

        public int getNameToDisplay() {
            return R.string.my_vip_manager;
        }

        public int layoutResId() {
            return R.layout.left_menu_item_drop_down;
        }

        public int getChildCount() {
            return MainMenu.sum(this.child);
        }

        public int getSize() {
            return isVisible() + MainMenu.sum(this.child);
        }

        public a getChild(int i) {
            return MainMenu.findChild(i, this.child);
        }
    },
    Support {
        public int getIcon() {
            return R.drawable.ic_support;
        }

        public int getNameToDisplay() {
            return R.string.support;
        }

        public int layoutResId() {
            return R.layout.left_menu_item_counter;
        }
    },
    CallBack {
        public int getIcon() {
            return R.drawable.ic_call_back;
        }

        public int getNameToDisplay() {
            return R.string.call_back1;
        }
    },
    RateUs {
        public int getIcon() {
            return R.drawable.ic_star_24;
        }

        public int getNameToDisplay() {
            return R.string.rate_us;
        }
    },
    Quiz {
        public int getIcon() {
            return R.drawable.ic_quiz_left_menu;
        }

        public int getNameToDisplay() {
            return R.string.iq_quiz;
        }
    },
    LogOut {
        public int getIcon() {
            return R.drawable.ic_exit;
        }

        public int getNameToDisplay() {
            return R.string.logout;
        }
    },
    TermsAndConditions {
        public int getNameToDisplay() {
            return R.string.terms_and_conditions;
        }

        public int layoutResId() {
            return R.layout.left_menu_item_terms_and_conditions;
        }
    };
    
    private boolean isEnabled;
    private boolean isInProgress;
    private boolean isVisible;

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

    public boolean isEnabled() {
        return true;
    }

    public int layoutResId() {
        return R.layout.left_menu_item;
    }

    public int menuPriority() {
        return 2;
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    public boolean isInProgress() {
        return this.isInProgress;
    }

    public boolean isClickable() {
        return this.isInProgress ^ 1;
    }

    public int getSize() {
        return this.isVisible;
    }

    public boolean setEnabled(boolean z) {
        if (this.isEnabled == z) {
            return false;
        }
        this.isEnabled = z;
        return true;
    }

    public boolean setVisible(boolean z) {
        if (this.isVisible == z) {
            return false;
        }
        this.isVisible = z;
        return true;
    }

    public boolean setIsInProgress(boolean z) {
        if (this.isInProgress == z) {
            return false;
        }
        this.isInProgress = z;
        return true;
    }

    private static int count(a[] aVarArr) {
        int i = 0;
        for (a isVisible : aVarArr) {
            if (isVisible.isVisible()) {
                i++;
            }
        }
        return i;
    }

    private static int sum(a[] aVarArr) {
        int i = 0;
        for (a size : aVarArr) {
            i += size.getSize();
        }
        return i;
    }

    private static a findChild(int i, a[] aVarArr) {
        int i2 = 0;
        for (a aVar : aVarArr) {
            if (aVar.isVisible()) {
                if (i2 == i) {
                    return aVar;
                }
                i2++;
            }
        }
        return null;
    }
}
