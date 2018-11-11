package okhttp3.internal.http;

import com.jumio.analytics.MobileEvents;
import com.jumio.commons.remote.exception.UnexpectedResponseException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.HttpRetryException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.CertificatePinner;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http2.ConnectionShutdownException;

public final class RetryAndFollowUpInterceptor implements Interceptor {
    private static final int MAX_FOLLOW_UPS = 20;
    private Object callStackTrace;
    private volatile boolean canceled;
    private final OkHttpClient client;
    private final boolean forWebSocket;
    private volatile StreamAllocation streamAllocation;

    public RetryAndFollowUpInterceptor(OkHttpClient okHttpClient, boolean z) {
        this.client = okHttpClient;
        this.forWebSocket = z;
    }

    public void cancel() {
        this.canceled = true;
        StreamAllocation streamAllocation = this.streamAllocation;
        if (streamAllocation != null) {
            streamAllocation.cancel();
        }
    }

    public boolean isCanceled() {
        return this.canceled;
    }

    public void setCallStackTrace(Object obj) {
        this.callStackTrace = obj;
    }

    public StreamAllocation streamAllocation() {
        return this.streamAllocation;
    }

    public Response intercept(Chain chain) {
        Request request = chain.request();
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        Call call = realInterceptorChain.call();
        EventListener eventListener = realInterceptorChain.eventListener();
        StreamAllocation streamAllocation = new StreamAllocation(this.client.connectionPool(), createAddress(request.url()), call, eventListener, this.callStackTrace);
        this.streamAllocation = streamAllocation;
        Response response = null;
        int i = 0;
        while (!this.canceled) {
            try {
                Response proceed = realInterceptorChain.proceed(request, r9, null, null);
                Response build = response != null ? proceed.newBuilder().priorResponse(response.newBuilder().body(null).build()).build() : proceed;
                Request followUpRequest = followUpRequest(build, r9.route());
                if (followUpRequest == null) {
                    if (!this.forWebSocket) {
                        r9.release();
                    }
                    return build;
                }
                Util.closeQuietly(build.body());
                int i2 = i + 1;
                if (i2 > 20) {
                    r9.release();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Too many follow-up requests: ");
                    stringBuilder.append(i2);
                    throw new ProtocolException(stringBuilder.toString());
                } else if (followUpRequest.body() instanceof UnrepeatableRequestBody) {
                    r9.release();
                    throw new HttpRetryException("Cannot retry streamed HTTP body", build.code());
                } else {
                    if (!sameConnection(build, followUpRequest.url())) {
                        r9.release();
                        streamAllocation = new StreamAllocation(this.client.connectionPool(), createAddress(followUpRequest.url()), call, eventListener, this.callStackTrace);
                        this.streamAllocation = streamAllocation;
                    } else if (r9.codec() != null) {
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("Closing the body of ");
                        stringBuilder2.append(build);
                        stringBuilder2.append(" didn't close its backing stream. Bad interceptor?");
                        throw new IllegalStateException(stringBuilder2.toString());
                    }
                    response = build;
                    request = followUpRequest;
                    i = i2;
                }
            } catch (RouteException e) {
                if (!recover(e.getLastConnectException(), r9, false, request)) {
                    throw e.getLastConnectException();
                }
            } catch (IOException e2) {
                if (!recover(e2, r9, !(e2 instanceof ConnectionShutdownException), request)) {
                    throw e2;
                }
            } catch (Throwable th) {
                r9.streamFailed(null);
                r9.release();
            }
        }
        r9.release();
        throw new IOException("Canceled");
    }

    private Address createAddress(HttpUrl httpUrl) {
        HostnameVerifier hostnameVerifier;
        SSLSocketFactory sSLSocketFactory;
        CertificatePinner certificatePinner;
        if (httpUrl.isHttps()) {
            SSLSocketFactory sslSocketFactory = this.client.sslSocketFactory();
            hostnameVerifier = this.client.hostnameVerifier();
            sSLSocketFactory = sslSocketFactory;
            certificatePinner = this.client.certificatePinner();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = sSLSocketFactory;
            certificatePinner = hostnameVerifier;
        }
        return new Address(httpUrl.host(), httpUrl.port(), this.client.dns(), this.client.socketFactory(), sSLSocketFactory, hostnameVerifier, certificatePinner, this.client.proxyAuthenticator(), this.client.proxy(), this.client.protocols(), this.client.connectionSpecs(), this.client.proxySelector());
    }

    private boolean recover(IOException iOException, StreamAllocation streamAllocation, boolean z, Request request) {
        streamAllocation.streamFailed(iOException);
        if (!this.client.retryOnConnectionFailure()) {
            return false;
        }
        if ((!z || !(request.body() instanceof UnrepeatableRequestBody)) && isRecoverable(iOException, z) && streamAllocation.hasMoreRoutes()) {
            return true;
        }
        return false;
    }

    private boolean isRecoverable(IOException iOException, boolean z) {
        boolean z2 = false;
        if (iOException instanceof ProtocolException) {
            return false;
        }
        if (iOException instanceof InterruptedIOException) {
            if ((iOException instanceof SocketTimeoutException) && !z) {
                z2 = true;
            }
            return z2;
        } else if (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        } else {
            return true;
        }
    }

    private Request followUpRequest(Response response, Route route) {
        if (response == null) {
            throw new IllegalStateException();
        }
        int code = response.code();
        String method = response.request().method();
        RequestBody requestBody = null;
        switch (code) {
            case 300:
            case MobileEvents.EVENTTYPE_USERACTION /*301*/:
            case MobileEvents.EVENTTYPE_SDKLIFECYCLE /*302*/:
            case MobileEvents.EVENTTYPE_ANDROID_LIFECYCLE /*303*/:
                break;
            case 307:
            case 308:
                if (!(method.equals("GET") || method.equals("HEAD"))) {
                    return null;
                }
            case UnexpectedResponseException.STATUS_CODE_UNAUTHORIZED /*401*/:
                return this.client.authenticator().authenticate(route, response);
            case 407:
                Proxy proxy;
                if (route != null) {
                    proxy = route.proxy();
                } else {
                    proxy = this.client.proxy();
                }
                if (proxy.type() == Type.HTTP) {
                    return this.client.proxyAuthenticator().authenticate(route, response);
                }
                throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
            case 408:
                if (!this.client.retryOnConnectionFailure() || (response.request().body() instanceof UnrepeatableRequestBody)) {
                    return null;
                }
                if ((response.priorResponse() == null || response.priorResponse().code() != 408) && retryAfter(response, 0) <= 0) {
                    return response.request();
                }
                return null;
            case 503:
                if ((response.priorResponse() == null || response.priorResponse().code() != 503) && retryAfter(response, ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) == 0) {
                    return response.request();
                }
                return null;
            default:
                return null;
        }
        if (!this.client.followRedirects()) {
            return null;
        }
        String header = response.header("Location");
        if (header == null) {
            return null;
        }
        HttpUrl resolve = response.request().url().resolve(header);
        if (resolve == null) {
            return null;
        }
        if (!resolve.scheme().equals(response.request().url().scheme()) && !this.client.followSslRedirects()) {
            return null;
        }
        Builder newBuilder = response.request().newBuilder();
        if (HttpMethod.permitsRequestBody(method)) {
            boolean redirectsWithBody = HttpMethod.redirectsWithBody(method);
            if (HttpMethod.redirectsToGet(method)) {
                newBuilder.method("GET", null);
            } else {
                if (redirectsWithBody) {
                    requestBody = response.request().body();
                }
                newBuilder.method(method, requestBody);
            }
            if (!redirectsWithBody) {
                newBuilder.removeHeader("Transfer-Encoding");
                newBuilder.removeHeader("Content-Length");
                newBuilder.removeHeader("Content-Type");
            }
        }
        if (!sameConnection(response, resolve)) {
            newBuilder.removeHeader("Authorization");
        }
        return newBuilder.url(resolve).build();
    }

    private int retryAfter(Response response, int i) {
        String header = response.header("Retry-After");
        if (header == null) {
            return i;
        }
        return header.matches("\\d+") ? Integer.valueOf(header).intValue() : ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    }

    private boolean sameConnection(Response response, HttpUrl httpUrl) {
        HttpUrl url = response.request().url();
        return url.host().equals(httpUrl.host()) && url.port() == httpUrl.port() && url.scheme().equals(httpUrl.scheme());
    }
}
