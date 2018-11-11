package com.appsflyer;

final class r implements a {
    private a rk = this;

    interface a {
        Class<?> aE(String str);
    }

    enum c {
        UNITY("android_unity", "com.unity3d.player.UnityPlayer"),
        REACT_NATIVE("android_reactNative", "com.facebook.react.ReactApplication"),
        CORDOVA("android_cordova", "org.apache.cordova.CordovaActivity"),
        SEGMENT("android_segment", "com.segment.analytics.integrations.Integration"),
        COCOS2DX("android_cocos2dx", "org.cocos2dx.lib.Cocos2dxActivity"),
        DEFAULT("android_native", "android_native");
        
        private String ʼ;
        private String ᐝ;

        private c(String str, String str2) {
            this.ᐝ = str;
            this.ʼ = str2;
        }
    }

    final String fE() {
        for (c cVar : c.values()) {
            if (aD(cVar.ʼ)) {
                return cVar.ᐝ;
            }
        }
        return c.DEFAULT.ᐝ;
    }

    r() {
    }

    final boolean aD(String str) {
        try {
            this.rk.aE(str);
            StringBuilder stringBuilder = new StringBuilder("Class: ");
            stringBuilder.append(str);
            stringBuilder.append(" is found.");
            AFLogger.ak(stringBuilder.toString());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        } catch (Throwable th) {
            AFLogger.a(th.getMessage(), th);
            return false;
        }
    }

    public final Class<?> aE(String str) {
        return Class.forName(str);
    }
}
