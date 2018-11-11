package com.jumio.core.data;

import android.content.Context;
import android.content.res.Resources;
import java.util.HashMap;

public abstract class Strings {
    private static SDKStringFactory factory;
    private static Strings instance;
    protected String mPrefix;
    protected HashMap<String, String> stringProvider = new HashMap();

    public interface SDKStringFactory {
        Strings createInstance();
    }

    public static synchronized void setFactory(SDKStringFactory sDKStringFactory) {
        synchronized (Strings.class) {
            instance = null;
            factory = sDKStringFactory;
        }
    }

    public static synchronized Strings getInstance() {
        Strings strings;
        synchronized (Strings.class) {
            if (factory == null) {
                throw new IllegalStateException("need to call Strings.setFactory()!");
            }
            if (instance == null) {
                instance = factory.createInstance();
            }
            strings = instance;
        }
        return strings;
    }

    public static String getExternalString(Context context, String str) {
        try {
            Resources resources = context.getResources();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(getInstance().mPrefix);
            stringBuilder.append(str);
            int identifier = resources.getIdentifier(stringBuilder.toString(), "string", context.getPackageName());
            if (identifier == 0) {
                return getFallbackString(str);
            }
            return context.getString(identifier);
        } catch (Exception unused) {
            return getFallbackString(str);
        }
    }

    public static String getResourcesString(Context context, int i) {
        return (context == null || i == 0) ? "" : context.getResources().getString(i);
    }

    private HashMap<String, String> getStringProvider() {
        return this.stringProvider;
    }

    private static String getFallbackString(String str) {
        if (getInstance().getStringProvider() == null) {
            return "";
        }
        str = (String) getInstance().getStringProvider().get(str);
        if (str == null) {
            str = "";
        }
        return str;
    }
}
