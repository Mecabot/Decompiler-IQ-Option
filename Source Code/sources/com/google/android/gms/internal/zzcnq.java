package com.google.android.gms.internal;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

final class zzcnq extends SSLSocket {
    private final SSLSocket zzjsr;

    zzcnq(zzcnp zzcnp, SSLSocket sSLSocket) {
        this.zzjsr = sSLSocket;
    }

    public final void addHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
        this.zzjsr.addHandshakeCompletedListener(handshakeCompletedListener);
    }

    public final void bind(SocketAddress socketAddress) {
        this.zzjsr.bind(socketAddress);
    }

    public final synchronized void close() {
        this.zzjsr.close();
    }

    public final void connect(SocketAddress socketAddress) {
        this.zzjsr.connect(socketAddress);
    }

    public final void connect(SocketAddress socketAddress, int i) {
        this.zzjsr.connect(socketAddress, i);
    }

    public final boolean equals(Object obj) {
        return this.zzjsr.equals(obj);
    }

    public final SocketChannel getChannel() {
        return this.zzjsr.getChannel();
    }

    public final boolean getEnableSessionCreation() {
        return this.zzjsr.getEnableSessionCreation();
    }

    public final String[] getEnabledCipherSuites() {
        return this.zzjsr.getEnabledCipherSuites();
    }

    public final String[] getEnabledProtocols() {
        return this.zzjsr.getEnabledProtocols();
    }

    public final InetAddress getInetAddress() {
        return this.zzjsr.getInetAddress();
    }

    public final InputStream getInputStream() {
        return this.zzjsr.getInputStream();
    }

    public final boolean getKeepAlive() {
        return this.zzjsr.getKeepAlive();
    }

    public final InetAddress getLocalAddress() {
        return this.zzjsr.getLocalAddress();
    }

    public final int getLocalPort() {
        return this.zzjsr.getLocalPort();
    }

    public final SocketAddress getLocalSocketAddress() {
        return this.zzjsr.getLocalSocketAddress();
    }

    public final boolean getNeedClientAuth() {
        return this.zzjsr.getNeedClientAuth();
    }

    public final boolean getOOBInline() {
        return this.zzjsr.getOOBInline();
    }

    public final OutputStream getOutputStream() {
        return this.zzjsr.getOutputStream();
    }

    public final int getPort() {
        return this.zzjsr.getPort();
    }

    public final synchronized int getReceiveBufferSize() {
        return this.zzjsr.getReceiveBufferSize();
    }

    public final SocketAddress getRemoteSocketAddress() {
        return this.zzjsr.getRemoteSocketAddress();
    }

    public final boolean getReuseAddress() {
        return this.zzjsr.getReuseAddress();
    }

    public final synchronized int getSendBufferSize() {
        return this.zzjsr.getSendBufferSize();
    }

    public final SSLSession getSession() {
        return this.zzjsr.getSession();
    }

    public final int getSoLinger() {
        return this.zzjsr.getSoLinger();
    }

    public final synchronized int getSoTimeout() {
        return this.zzjsr.getSoTimeout();
    }

    public final String[] getSupportedCipherSuites() {
        return this.zzjsr.getSupportedCipherSuites();
    }

    public final String[] getSupportedProtocols() {
        return this.zzjsr.getSupportedProtocols();
    }

    public final boolean getTcpNoDelay() {
        return this.zzjsr.getTcpNoDelay();
    }

    public final int getTrafficClass() {
        return this.zzjsr.getTrafficClass();
    }

    public final boolean getUseClientMode() {
        return this.zzjsr.getUseClientMode();
    }

    public final boolean getWantClientAuth() {
        return this.zzjsr.getWantClientAuth();
    }

    public final boolean isBound() {
        return this.zzjsr.isBound();
    }

    public final boolean isClosed() {
        return this.zzjsr.isClosed();
    }

    public final boolean isConnected() {
        return this.zzjsr.isConnected();
    }

    public final boolean isInputShutdown() {
        return this.zzjsr.isInputShutdown();
    }

    public final boolean isOutputShutdown() {
        return this.zzjsr.isOutputShutdown();
    }

    public final void removeHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
        this.zzjsr.removeHandshakeCompletedListener(handshakeCompletedListener);
    }

    public final void sendUrgentData(int i) {
        this.zzjsr.sendUrgentData(i);
    }

    public final void setEnableSessionCreation(boolean z) {
        this.zzjsr.setEnableSessionCreation(z);
    }

    public final void setEnabledCipherSuites(String[] strArr) {
        this.zzjsr.setEnabledCipherSuites(strArr);
    }

    public final void setEnabledProtocols(String[] strArr) {
        if (strArr != null && Arrays.asList(strArr).contains("SSLv3")) {
            List arrayList = new ArrayList(Arrays.asList(this.zzjsr.getEnabledProtocols()));
            if (arrayList.size() > 1) {
                arrayList.remove("SSLv3");
            }
            strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
        }
        this.zzjsr.setEnabledProtocols(strArr);
    }

    public final void setKeepAlive(boolean z) {
        this.zzjsr.setKeepAlive(z);
    }

    public final void setNeedClientAuth(boolean z) {
        this.zzjsr.setNeedClientAuth(z);
    }

    public final void setOOBInline(boolean z) {
        this.zzjsr.setOOBInline(z);
    }

    public final void setPerformancePreferences(int i, int i2, int i3) {
        this.zzjsr.setPerformancePreferences(i, i2, i3);
    }

    public final synchronized void setReceiveBufferSize(int i) {
        this.zzjsr.setReceiveBufferSize(i);
    }

    public final void setReuseAddress(boolean z) {
        this.zzjsr.setReuseAddress(z);
    }

    public final synchronized void setSendBufferSize(int i) {
        this.zzjsr.setSendBufferSize(i);
    }

    public final void setSoLinger(boolean z, int i) {
        this.zzjsr.setSoLinger(z, i);
    }

    public final synchronized void setSoTimeout(int i) {
        this.zzjsr.setSoTimeout(i);
    }

    public final void setTcpNoDelay(boolean z) {
        this.zzjsr.setTcpNoDelay(z);
    }

    public final void setTrafficClass(int i) {
        this.zzjsr.setTrafficClass(i);
    }

    public final void setUseClientMode(boolean z) {
        this.zzjsr.setUseClientMode(z);
    }

    public final void setWantClientAuth(boolean z) {
        this.zzjsr.setWantClientAuth(z);
    }

    public final void shutdownInput() {
        this.zzjsr.shutdownInput();
    }

    public final void shutdownOutput() {
        this.zzjsr.shutdownOutput();
    }

    public final void startHandshake() {
        this.zzjsr.startHandshake();
    }

    public final String toString() {
        return this.zzjsr.toString();
    }
}
