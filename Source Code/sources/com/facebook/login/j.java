package com.facebook.login;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.FacebookActivity;
import com.facebook.FacebookAuthorizationException;
import com.facebook.FacebookException;
import com.facebook.e;
import com.facebook.g;
import com.facebook.h;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.internal.n;
import com.facebook.internal.x;
import com.facebook.login.LoginClient.Result;
import com.facebook.login.LoginClient.c;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* compiled from: LoginManager */
public class j {
    private static final Set<String> GC = nD();
    private static volatile j GJ;
    private LoginBehavior Gj = LoginBehavior.NATIVE_WITH_FALLBACK;
    private DefaultAudience Gk = DefaultAudience.FRIENDS;
    private String Go = "rerequest";
    private final SharedPreferences wv;

    /* compiled from: LoginManager */
    private static class b {
        private static i GX;

        private static synchronized i am(Context context) {
            synchronized (b.class) {
                if (context == null) {
                    context = h.getApplicationContext();
                }
                if (context == null) {
                    return null;
                }
                if (GX == null) {
                    GX = new i(context, h.it());
                }
                i iVar = GX;
                return iVar;
            }
        }
    }

    /* compiled from: LoginManager */
    private static class a implements n {
        private final n GV;

        a(n nVar) {
            x.a((Object) nVar, "fragment");
            this.GV = nVar;
        }

        public void startActivityForResult(Intent intent, int i) {
            this.GV.startActivityForResult(intent, i);
        }

        public Activity nE() {
            return this.GV.getActivity();
        }
    }

    j() {
        x.mC();
        this.wv = h.getApplicationContext().getSharedPreferences("com.facebook.loginManager", 0);
    }

    public static j nB() {
        if (GJ == null) {
            synchronized (j.class) {
                if (GJ == null) {
                    GJ = new j();
                }
            }
        }
        return GJ;
    }

    public void a(e eVar, final g<l> gVar) {
        if (eVar instanceof CallbackManagerImpl) {
            ((CallbackManagerImpl) eVar).b(RequestCodeOffset.Login.toRequestCode(), new com.facebook.internal.CallbackManagerImpl.a() {
                public boolean b(int i, Intent intent) {
                    return j.this.a(i, intent, gVar);
                }
            });
            return;
        }
        throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
    }

    boolean b(int i, Intent intent) {
        return a(i, intent, null);
    }

    boolean a(int i, Intent intent, g<l> gVar) {
        Map map;
        Code code;
        boolean z;
        com.facebook.a aVar;
        c cVar;
        int i2 = i;
        Intent intent2 = intent;
        Code code2 = Code.ERROR;
        Exception exception = null;
        boolean z2 = false;
        if (intent2 != null) {
            com.facebook.a aVar2;
            Map map2;
            c cVar2;
            Result result = (Result) intent2.getParcelableExtra("com.facebook.LoginFragment:Result");
            if (result != null) {
                c cVar3 = result.Gt;
                Code code3 = result.Gq;
                if (i2 == -1) {
                    if (result.Gq == Code.SUCCESS) {
                        aVar2 = result.Gr;
                    } else {
                        exception = new FacebookAuthorizationException(result.errorMessage);
                        aVar2 = null;
                    }
                } else if (i2 == 0) {
                    aVar2 = null;
                    z2 = true;
                } else {
                    aVar2 = null;
                }
                map2 = result.Gh;
                Code code4 = code3;
                cVar2 = cVar3;
                code2 = code4;
            } else {
                aVar2 = null;
                map2 = aVar2;
                cVar2 = map2;
            }
            map = map2;
            code = code2;
            z = z2;
            c cVar4 = cVar2;
            aVar = aVar2;
            cVar = cVar4;
        } else if (i2 == 0) {
            code = Code.CANCEL;
            cVar = null;
            aVar = cVar;
            map = aVar;
            z = true;
        } else {
            code = code2;
            cVar = null;
            aVar = cVar;
            map = aVar;
            z = false;
        }
        if (exception == null && aVar == null && !z) {
            exception = new FacebookException("Unexpected call to LoginManager.onActivityResult");
        }
        a(null, code, map, exception, true, cVar);
        a(aVar, cVar, exception, z, gVar);
        return true;
    }

    public void nC() {
        com.facebook.a.a(null);
        com.facebook.n.a(null);
        Q(false);
    }

    public void a(Fragment fragment, Collection<String> collection) {
        a(new n(fragment), (Collection) collection);
    }

    private void a(n nVar, Collection<String> collection) {
        d(collection);
        a(new a(nVar), e(collection));
    }

    private void d(Collection<String> collection) {
        if (collection != null) {
            for (String bW : collection) {
                if (bW(bW)) {
                    throw new FacebookException(String.format("Cannot pass a publish or manage permission (%s) to a request for read authorization", new Object[]{(String) r5.next()}));
                }
            }
        }
    }

    static boolean bW(String str) {
        return str != null && (str.startsWith("publish") || str.startsWith("manage") || GC.contains(str));
    }

    private static Set<String> nD() {
        return Collections.unmodifiableSet(new LoginManager$2());
    }

    protected c e(Collection<String> collection) {
        c cVar = new c(this.Gj, Collections.unmodifiableSet(collection != null ? new HashSet(collection) : new HashSet()), this.Gk, this.Go, h.it(), UUID.randomUUID().toString());
        cVar.P(com.facebook.a.il());
        return cVar;
    }

    private void a(n nVar, c cVar) {
        a(nVar.nE(), cVar);
        CallbackManagerImpl.a(RequestCodeOffset.Login.toRequestCode(), new com.facebook.internal.CallbackManagerImpl.a() {
            public boolean b(int i, Intent intent) {
                return j.this.b(i, intent);
            }
        });
        if (!b(nVar, cVar)) {
            Exception facebookException = new FacebookException("Log in attempt failed: FacebookActivity could not be started. Please make sure you added FacebookActivity to the AndroidManifest.");
            a(nVar.nE(), Code.ERROR, null, facebookException, false, cVar);
            throw facebookException;
        }
    }

    private void a(Context context, c cVar) {
        i an = b.am(context);
        if (an != null && cVar != null) {
            an.g(cVar);
        }
    }

    private void a(Context context, Code code, Map<String, String> map, Exception exception, boolean z, c cVar) {
        i an = b.am(context);
        if (an != null) {
            if (cVar == null) {
                an.I("fb_mobile_login_complete", "Unexpected call to logCompleteLogin with null pendingAuthorizationRequest.");
            } else {
                Map hashMap = new HashMap();
                hashMap.put("try_login_activity", z ? "1" : "0");
                an.a(cVar.nt(), hashMap, code, map, exception);
            }
        }
    }

    private boolean b(n nVar, c cVar) {
        Intent h = h(cVar);
        if (!k(h)) {
            return false;
        }
        try {
            nVar.startActivityForResult(h, LoginClient.nd());
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }

    private boolean k(Intent intent) {
        if (h.getApplicationContext().getPackageManager().resolveActivity(intent, 0) != null) {
            return true;
        }
        return false;
    }

    protected Intent h(c cVar) {
        Intent intent = new Intent();
        intent.setClass(h.getApplicationContext(), FacebookActivity.class);
        intent.setAction(cVar.nr().toString());
        Bundle bundle = new Bundle();
        bundle.putParcelable("request", cVar);
        intent.putExtra("com.facebook.LoginFragment:Request", bundle);
        return intent;
    }

    static l b(c cVar, com.facebook.a aVar) {
        Collection ip = cVar.ip();
        Object hashSet = new HashSet(aVar.ip());
        if (cVar.nu()) {
            hashSet.retainAll(ip);
        }
        Set hashSet2 = new HashSet(ip);
        hashSet2.removeAll(hashSet);
        return new l(aVar, hashSet, hashSet2);
    }

    private void a(com.facebook.a aVar, c cVar, FacebookException facebookException, boolean z, g<l> gVar) {
        if (aVar != null) {
            com.facebook.a.a(aVar);
            com.facebook.n.jN();
        }
        if (gVar != null) {
            l b = aVar != null ? b(cVar, aVar) : null;
            if (z || (b != null && b.nG().size() == 0)) {
                gVar.onCancel();
            } else if (facebookException != null) {
                gVar.b(facebookException);
            } else if (aVar != null) {
                Q(true);
                gVar.onSuccess(b);
            }
        }
    }

    private void Q(boolean z) {
        Editor edit = this.wv.edit();
        edit.putBoolean("express_login_allowed", z);
        edit.apply();
    }
}
