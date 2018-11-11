package com.iqoption.core.connect.http.a;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.channels.SocketChannel;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\b\u0018\u0000 \u00192\u00020\u0001:\u0003\u0019\u001a\u001bB\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J*\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\nH\u0016J*\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\nH\u0016J*\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\nH\u0016J\u0013\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0014H\u0016¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0014H\u0016¢\u0006\u0002\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, aXE = {"Lcom/iqoption/core/connect/http/ssl/NoSSLv3SocketFactory;", "Ljavax/net/ssl/SSLSocketFactory;", "()V", "delegate", "(Ljavax/net/ssl/SSLSocketFactory;)V", "createSocket", "Ljava/net/Socket;", "host", "Ljava/net/InetAddress;", "port", "", "address", "localAddress", "localPort", "s", "", "autoClose", "", "localHost", "getDefaultCipherSuites", "", "()[Ljava/lang/String;", "getSupportedCipherSuites", "makeSocketSafe", "socket", "Companion", "DelegateSSLSocket", "NoSSLv3SSLSocket", "core_release"})
/* compiled from: NoSSLv3SocketFactory.kt */
public final class a extends SSLSocketFactory {
    private static final String TAG = "a";
    public static final a aOe = new a();
    private final SSLSocketFactory delegate;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, aXE = {"Lcom/iqoption/core/connect/http/ssl/NoSSLv3SocketFactory$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "core_release"})
    /* compiled from: NoSSLv3SocketFactory.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final String Ll() {
            return a.TAG;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b3\b\u0016\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u0007H\u0016J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\fH\u0016J\u0018\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0013\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0016¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0016¢\u0006\u0002\u0010\u0019J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0015H\u0016J\b\u0010 \u001a\u00020\u001cH\u0016J\b\u0010!\u001a\u00020\u0011H\u0016J\b\u0010\"\u001a\u00020\fH\u0016J\b\u0010#\u001a\u00020\u0015H\u0016J\b\u0010$\u001a\u00020\u0015H\u0016J\b\u0010%\u001a\u00020&H\u0016J\b\u0010'\u001a\u00020\u0011H\u0016J\b\u0010(\u001a\u00020\u0011H\u0016J\b\u0010)\u001a\u00020\fH\u0016J\b\u0010*\u001a\u00020\u0015H\u0016J\b\u0010+\u001a\u00020\u0011H\u0016J\b\u0010,\u001a\u00020-H\u0016J\b\u0010.\u001a\u00020\u0011H\u0016J\b\u0010/\u001a\u00020\u0011H\u0016J\u0013\u00100\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0016¢\u0006\u0002\u0010\u0019J\u0013\u00101\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0016¢\u0006\u0002\u0010\u0019J\b\u00102\u001a\u00020\u0015H\u0016J\b\u00103\u001a\u00020\u0011H\u0016J\b\u00104\u001a\u00020\u0015H\u0016J\b\u00105\u001a\u00020\u0015H\u0016J\b\u00106\u001a\u00020\u0015H\u0016J\b\u00107\u001a\u00020\u0015H\u0016J\b\u00108\u001a\u00020\u0015H\u0016J\b\u00109\u001a\u00020\u0015H\u0016J\b\u0010:\u001a\u00020\u0015H\u0016J\u0010\u0010;\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010<\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\u0011H\u0016J\u0010\u0010>\u001a\u00020\u00072\u0006\u0010?\u001a\u00020\u0015H\u0016J\u001b\u0010@\u001a\u00020\u00072\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0016¢\u0006\u0002\u0010BJ\u001d\u0010C\u001a\u00020\u00072\u000e\u0010D\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0016¢\u0006\u0002\u0010BJ\u0010\u0010E\u001a\u00020\u00072\u0006\u0010F\u001a\u00020\u0015H\u0016J\u0010\u0010G\u001a\u00020\u00072\u0006\u0010H\u001a\u00020\u0015H\u0016J\u0010\u0010I\u001a\u00020\u00072\u0006\u0010J\u001a\u00020\u0015H\u0016J \u0010K\u001a\u00020\u00072\u0006\u0010L\u001a\u00020\u00112\u0006\u0010M\u001a\u00020\u00112\u0006\u0010N\u001a\u00020\u0011H\u0016J\u0010\u0010O\u001a\u00020\u00072\u0006\u0010P\u001a\u00020\u0011H\u0016J\u0010\u0010Q\u001a\u00020\u00072\u0006\u0010R\u001a\u00020\u0015H\u0016J\u0010\u0010S\u001a\u00020\u00072\u0006\u0010P\u001a\u00020\u0011H\u0016J\u0018\u0010T\u001a\u00020\u00072\u0006\u0010U\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010V\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010W\u001a\u00020\u00072\u0006\u0010U\u001a\u00020\u0015H\u0016J\u0010\u0010X\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\u0011H\u0016J\u0010\u0010Y\u001a\u00020\u00072\u0006\u0010Z\u001a\u00020\u0015H\u0016J\u0010\u0010[\u001a\u00020\u00072\u0006\u0010\\\u001a\u00020\u0015H\u0016J\b\u0010]\u001a\u00020\u0007H\u0016J\b\u0010^\u001a\u00020\u0007H\u0016J\b\u0010_\u001a\u00020\u0007H\u0016R\u0014\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006`"}, aXE = {"Lcom/iqoption/core/connect/http/ssl/NoSSLv3SocketFactory$DelegateSSLSocket;", "Ljavax/net/ssl/SSLSocket;", "delegate", "(Ljavax/net/ssl/SSLSocket;)V", "getDelegate", "()Ljavax/net/ssl/SSLSocket;", "addHandshakeCompletedListener", "", "listener", "Ljavax/net/ssl/HandshakeCompletedListener;", "bind", "localAddr", "Ljava/net/SocketAddress;", "close", "connect", "remoteAddr", "timeout", "", "getChannel", "Ljava/nio/channels/SocketChannel;", "getEnableSessionCreation", "", "getEnabledCipherSuites", "", "", "()[Ljava/lang/String;", "getEnabledProtocols", "getInetAddress", "Ljava/net/InetAddress;", "getInputStream", "Ljava/io/InputStream;", "getKeepAlive", "getLocalAddress", "getLocalPort", "getLocalSocketAddress", "getNeedClientAuth", "getOOBInline", "getOutputStream", "Ljava/io/OutputStream;", "getPort", "getReceiveBufferSize", "getRemoteSocketAddress", "getReuseAddress", "getSendBufferSize", "getSession", "Ljavax/net/ssl/SSLSession;", "getSoLinger", "getSoTimeout", "getSupportedCipherSuites", "getSupportedProtocols", "getTcpNoDelay", "getTrafficClass", "getUseClientMode", "getWantClientAuth", "isBound", "isClosed", "isConnected", "isInputShutdown", "isOutputShutdown", "removeHandshakeCompletedListener", "sendUrgentData", "value", "setEnableSessionCreation", "flag", "setEnabledCipherSuites", "suites", "([Ljava/lang/String;)V", "setEnabledProtocols", "protocols", "setKeepAlive", "keepAlive", "setNeedClientAuth", "need", "setOOBInline", "oobinline", "setPerformancePreferences", "connectionTime", "latency", "bandwidth", "setReceiveBufferSize", "size", "setReuseAddress", "reuse", "setSendBufferSize", "setSoLinger", "on", "setSoTimeout", "setTcpNoDelay", "setTrafficClass", "setUseClientMode", "mode", "setWantClientAuth", "want", "shutdownInput", "shutdownOutput", "startHandshake", "core_release"})
    /* compiled from: NoSSLv3SocketFactory.kt */
    public static class b extends SSLSocket {
        private final SSLSocket aOf;

        public b(SSLSocket sSLSocket) {
            h.e(sSLSocket, "delegate");
            this.aOf = sSLSocket;
        }

        protected final SSLSocket Sy() {
            return this.aOf;
        }

        public String[] getSupportedCipherSuites() {
            Object supportedCipherSuites = this.aOf.getSupportedCipherSuites();
            h.d(supportedCipherSuites, "delegate.supportedCipherSuites");
            return supportedCipherSuites;
        }

        public String[] getEnabledCipherSuites() {
            Object enabledCipherSuites = this.aOf.getEnabledCipherSuites();
            h.d(enabledCipherSuites, "delegate.enabledCipherSuites");
            return enabledCipherSuites;
        }

        public void setEnabledCipherSuites(String[] strArr) {
            h.e(strArr, "suites");
            this.aOf.setEnabledCipherSuites(strArr);
        }

        public String[] getSupportedProtocols() {
            Object supportedProtocols = this.aOf.getSupportedProtocols();
            h.d(supportedProtocols, "delegate.supportedProtocols");
            return supportedProtocols;
        }

        public String[] getEnabledProtocols() {
            Object enabledProtocols = this.aOf.getEnabledProtocols();
            h.d(enabledProtocols, "delegate.enabledProtocols");
            return enabledProtocols;
        }

        public void setEnabledProtocols(String[] strArr) {
            this.aOf.setEnabledProtocols(strArr);
        }

        public SSLSession getSession() {
            SSLSession session = this.aOf.getSession();
            h.d(session, "delegate.session");
            return session;
        }

        public void addHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
            h.e(handshakeCompletedListener, "listener");
            this.aOf.addHandshakeCompletedListener(handshakeCompletedListener);
        }

        public void removeHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
            h.e(handshakeCompletedListener, "listener");
            this.aOf.removeHandshakeCompletedListener(handshakeCompletedListener);
        }

        public void startHandshake() {
            this.aOf.startHandshake();
        }

        public void setUseClientMode(boolean z) {
            this.aOf.setUseClientMode(z);
        }

        public boolean getUseClientMode() {
            return this.aOf.getUseClientMode();
        }

        public void setNeedClientAuth(boolean z) {
            this.aOf.setNeedClientAuth(z);
        }

        public void setWantClientAuth(boolean z) {
            this.aOf.setWantClientAuth(z);
        }

        public boolean getNeedClientAuth() {
            return this.aOf.getNeedClientAuth();
        }

        public boolean getWantClientAuth() {
            return this.aOf.getWantClientAuth();
        }

        public void setEnableSessionCreation(boolean z) {
            this.aOf.setEnableSessionCreation(z);
        }

        public boolean getEnableSessionCreation() {
            return this.aOf.getEnableSessionCreation();
        }

        public void bind(SocketAddress socketAddress) {
            h.e(socketAddress, "localAddr");
            this.aOf.bind(socketAddress);
        }

        public synchronized void close() {
            this.aOf.close();
        }

        public void connect(SocketAddress socketAddress) {
            h.e(socketAddress, "remoteAddr");
            this.aOf.connect(socketAddress);
        }

        public void connect(SocketAddress socketAddress, int i) {
            h.e(socketAddress, "remoteAddr");
            this.aOf.connect(socketAddress, i);
        }

        public SocketChannel getChannel() {
            SocketChannel channel = this.aOf.getChannel();
            h.d(channel, "delegate.channel");
            return channel;
        }

        public InetAddress getInetAddress() {
            InetAddress inetAddress = this.aOf.getInetAddress();
            h.d(inetAddress, "delegate.inetAddress");
            return inetAddress;
        }

        public InputStream getInputStream() {
            InputStream inputStream = this.aOf.getInputStream();
            h.d(inputStream, "delegate.inputStream");
            return inputStream;
        }

        public boolean getKeepAlive() {
            return this.aOf.getKeepAlive();
        }

        public InetAddress getLocalAddress() {
            InetAddress localAddress = this.aOf.getLocalAddress();
            h.d(localAddress, "delegate.localAddress");
            return localAddress;
        }

        public int getLocalPort() {
            return this.aOf.getLocalPort();
        }

        public SocketAddress getLocalSocketAddress() {
            SocketAddress localSocketAddress = this.aOf.getLocalSocketAddress();
            h.d(localSocketAddress, "delegate.localSocketAddress");
            return localSocketAddress;
        }

        public boolean getOOBInline() {
            return this.aOf.getOOBInline();
        }

        public OutputStream getOutputStream() {
            OutputStream outputStream = this.aOf.getOutputStream();
            h.d(outputStream, "delegate.outputStream");
            return outputStream;
        }

        public int getPort() {
            return this.aOf.getPort();
        }

        public synchronized int getReceiveBufferSize() {
            return this.aOf.getReceiveBufferSize();
        }

        public SocketAddress getRemoteSocketAddress() {
            SocketAddress remoteSocketAddress = this.aOf.getRemoteSocketAddress();
            h.d(remoteSocketAddress, "delegate.remoteSocketAddress");
            return remoteSocketAddress;
        }

        public boolean getReuseAddress() {
            return this.aOf.getReuseAddress();
        }

        public synchronized int getSendBufferSize() {
            return this.aOf.getSendBufferSize();
        }

        public int getSoLinger() {
            return this.aOf.getSoLinger();
        }

        public synchronized int getSoTimeout() {
            return this.aOf.getSoTimeout();
        }

        public boolean getTcpNoDelay() {
            return this.aOf.getTcpNoDelay();
        }

        public int getTrafficClass() {
            return this.aOf.getTrafficClass();
        }

        public boolean isBound() {
            return this.aOf.isBound();
        }

        public boolean isClosed() {
            return this.aOf.isClosed();
        }

        public boolean isConnected() {
            return this.aOf.isConnected();
        }

        public boolean isInputShutdown() {
            return this.aOf.isInputShutdown();
        }

        public boolean isOutputShutdown() {
            return this.aOf.isOutputShutdown();
        }

        public void sendUrgentData(int i) {
            this.aOf.sendUrgentData(i);
        }

        public void setKeepAlive(boolean z) {
            this.aOf.setKeepAlive(z);
        }

        public void setOOBInline(boolean z) {
            this.aOf.setOOBInline(z);
        }

        public void setPerformancePreferences(int i, int i2, int i3) {
            this.aOf.setPerformancePreferences(i, i2, i3);
        }

        public synchronized void setReceiveBufferSize(int i) {
            this.aOf.setReceiveBufferSize(i);
        }

        public void setReuseAddress(boolean z) {
            this.aOf.setReuseAddress(z);
        }

        public synchronized void setSendBufferSize(int i) {
            this.aOf.setSendBufferSize(i);
        }

        public void setSoLinger(boolean z, int i) {
            this.aOf.setSoLinger(z, i);
        }

        public synchronized void setSoTimeout(int i) {
            this.aOf.setSoTimeout(i);
        }

        public void setTcpNoDelay(boolean z) {
            this.aOf.setTcpNoDelay(z);
        }

        public void setTrafficClass(int i) {
            this.aOf.setTrafficClass(i);
        }

        public void shutdownInput() {
            this.aOf.shutdownInput();
        }

        public void shutdownOutput() {
            this.aOf.shutdownOutput();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001d\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0016¢\u0006\u0002\u0010\n¨\u0006\f"}, aXE = {"Lcom/iqoption/core/connect/http/ssl/NoSSLv3SocketFactory$NoSSLv3SSLSocket;", "Lcom/iqoption/core/connect/http/ssl/NoSSLv3SocketFactory$DelegateSSLSocket;", "delegate", "Ljavax/net/ssl/SSLSocket;", "(Ljavax/net/ssl/SSLSocket;)V", "setEnabledProtocols", "", "protocols", "", "", "([Ljava/lang/String;)V", "Companion", "core_release"})
    /* compiled from: NoSSLv3SocketFactory.kt */
    private static final class c extends b {
        public static final a aOg = new a();

        @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, aXE = {"Lcom/iqoption/core/connect/http/ssl/NoSSLv3SocketFactory$NoSSLv3SSLSocket$Companion;", "", "()V", "SSL_v3", "", "core_release"})
        /* compiled from: NoSSLv3SocketFactory.kt */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(f fVar) {
                this();
            }
        }

        public c(SSLSocket sSLSocket) {
            h.e(sSLSocket, "delegate");
            super(sSLSocket);
        }

        /* JADX WARNING: Missing block: B:2:0x0006, code:
            if (r3 != null) goto L_0x0010;
     */
        public void setEnabledProtocols(java.lang.String[] r3) {
            /*
            r2 = this;
            if (r3 == 0) goto L_0x0009;
        L_0x0002:
            r3 = kotlin.collections.i.B(r3);
            if (r3 == 0) goto L_0x0009;
        L_0x0008:
            goto L_0x0010;
        L_0x0009:
            r3 = new java.util.ArrayList;
            r3.<init>();
            r3 = (java.util.List) r3;
        L_0x0010:
            r0 = r2.Sy();
            r0 = r0.getEnabledProtocols();
            if (r0 == 0) goto L_0x0020;
        L_0x001a:
            r1 = r3;
            r1 = (java.util.Collection) r1;
            kotlin.collections.r.addAll(r1, r0);
        L_0x0020:
            r0 = "SSLv3";
            r0 = r3.contains(r0);
            if (r0 == 0) goto L_0x0038;
        L_0x0028:
            r0 = com.iqoption.core.connect.http.a.a.aOe;
            r0 = r0.Ll();
            r1 = "Removed SSLv3 from enabled protocols";
            com.iqoption.core.i.d(r0, r1);
            r0 = "SSLv3";
            r3.remove(r0);
        L_0x0038:
            r3 = (java.util.Collection) r3;
            if (r3 != 0) goto L_0x0044;
        L_0x003c:
            r3 = new kotlin.TypeCastException;
            r0 = "null cannot be cast to non-null type java.util.Collection<T>";
            r3.<init>(r0);
            throw r3;
        L_0x0044:
            r0 = 0;
            r0 = new java.lang.String[r0];
            r3 = r3.toArray(r0);
            if (r3 != 0) goto L_0x0055;
        L_0x004d:
            r3 = new kotlin.TypeCastException;
            r0 = "null cannot be cast to non-null type kotlin.Array<T>";
            r3.<init>(r0);
            throw r3;
        L_0x0055:
            r3 = (java.lang.String[]) r3;
            super.setEnabledProtocols(r3);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iqoption.core.connect.http.a.a.c.setEnabledProtocols(java.lang.String[]):void");
        }
    }

    public a() {
        SSLSocketFactory defaultSSLSocketFactory = HttpsURLConnection.getDefaultSSLSocketFactory();
        h.d(defaultSSLSocketFactory, "HttpsURLConnection.getDefaultSSLSocketFactory()");
        this.delegate = defaultSSLSocketFactory;
    }

    public a(SSLSocketFactory sSLSocketFactory) {
        h.e(sSLSocketFactory, "delegate");
        this.delegate = sSLSocketFactory;
    }

    public String[] getDefaultCipherSuites() {
        Object defaultCipherSuites = this.delegate.getDefaultCipherSuites();
        h.d(defaultCipherSuites, "delegate.defaultCipherSuites");
        return defaultCipherSuites;
    }

    public String[] getSupportedCipherSuites() {
        Object supportedCipherSuites = this.delegate.getSupportedCipherSuites();
        h.d(supportedCipherSuites, "delegate.supportedCipherSuites");
        return supportedCipherSuites;
    }

    private final Socket a(Socket socket) {
        return socket instanceof SSLSocket ? new c((SSLSocket) socket) : socket;
    }

    public Socket createSocket(Socket socket, String str, int i, boolean z) {
        h.e(socket, "s");
        h.e(str, "host");
        socket = this.delegate.createSocket(socket, str, i, z);
        h.d(socket, "delegate.createSocket(s, host, port, autoClose)");
        return a(socket);
    }

    public Socket createSocket(String str, int i) {
        h.e(str, "host");
        Socket createSocket = this.delegate.createSocket(str, i);
        h.d(createSocket, "delegate.createSocket(host, port)");
        return a(createSocket);
    }

    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) {
        h.e(str, "host");
        h.e(inetAddress, "localHost");
        Socket createSocket = this.delegate.createSocket(str, i, inetAddress, i2);
        h.d(createSocket, "delegate.createSocket(ho…rt, localHost, localPort)");
        return a(createSocket);
    }

    public Socket createSocket(InetAddress inetAddress, int i) {
        h.e(inetAddress, "host");
        Socket createSocket = this.delegate.createSocket(inetAddress, i);
        h.d(createSocket, "delegate.createSocket(host, port)");
        return a(createSocket);
    }

    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) {
        h.e(inetAddress, "address");
        h.e(inetAddress2, "localAddress");
        Socket createSocket = this.delegate.createSocket(inetAddress, i, inetAddress2, i2);
        h.d(createSocket, "delegate.createSocket(ad… localAddress, localPort)");
        return a(createSocket);
    }
}
