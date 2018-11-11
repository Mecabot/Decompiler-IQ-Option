package com.neovisionaries.ws.client;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.List;
import java.util.Map.Entry;

/* compiled from: ProxyHandshaker */
class x {
    private final String dZr;
    private final int dZs;
    private final Socket eag;
    private final y eah;

    public x(Socket socket, String str, int i, y yVar) {
        this.eag = socket;
        this.dZr = str;
        this.dZs = i;
        this.eah = yVar;
    }

    public void perform() {
        aQs();
        aQu();
    }

    private void aQs() {
        byte[] kK = p.kK(aQt());
        OutputStream outputStream = this.eag.getOutputStream();
        outputStream.write(kK);
        outputStream.flush();
    }

    private String aQt() {
        String format = String.format("%s:%d", new Object[]{this.dZr, Integer.valueOf(this.dZs)});
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CONNECT ");
        stringBuilder.append(format);
        stringBuilder.append(" HTTP/1.1");
        stringBuilder.append("\r\n");
        stringBuilder.append("Host: ");
        stringBuilder.append(format);
        stringBuilder.append("\r\n");
        m(stringBuilder);
        n(stringBuilder);
        stringBuilder.append("\r\n");
        return stringBuilder.toString();
    }

    private void m(StringBuilder stringBuilder) {
        for (Entry entry : this.eah.getHeaders().entrySet()) {
            String str = (String) entry.getKey();
            for (String str2 : (List) entry.getValue()) {
                String str22;
                if (str22 == null) {
                    str22 = "";
                }
                stringBuilder.append(str);
                stringBuilder.append(": ");
                stringBuilder.append(str22);
                stringBuilder.append("\r\n");
            }
        }
    }

    private void n(StringBuilder stringBuilder) {
        String id = this.eah.getId();
        if (id != null && id.length() != 0) {
            String password = this.eah.getPassword();
            if (password == null) {
                password = "";
            }
            id = String.format("%s:%s", new Object[]{id, password});
            stringBuilder.append("Proxy-Authorization: Basic ");
            stringBuilder.append(b.encode(id));
            stringBuilder.append("\r\n");
        }
    }

    private void aQu() {
        InputStream inputStream = this.eag.getInputStream();
        f(inputStream);
        g(inputStream);
    }

    private void f(InputStream inputStream) {
        String a = p.a(inputStream, "UTF-8");
        if (a == null || a.length() == 0) {
            throw new IOException("The response from the proxy server does not contain a status line.");
        }
        String[] split = a.split(" +", 3);
        StringBuilder stringBuilder;
        if (split.length < 2) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("The status line in the response from the proxy server is badly formatted. The status line is: ");
            stringBuilder.append(a);
            throw new IOException(stringBuilder.toString());
        } else if (!"200".equals(split[1])) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("The status code in the response from the proxy server is not '200 Connection established'. The status line is: ");
            stringBuilder.append(a);
            throw new IOException(stringBuilder.toString());
        }
    }

    private void g(InputStream inputStream) {
        while (true) {
            int i = 0;
            while (true) {
                int read = inputStream.read();
                if (read == -1) {
                    throw new EOFException("The end of the stream from the proxy server was reached unexpectedly.");
                } else if (read == 10) {
                    if (i == 0) {
                        return;
                    }
                } else if (read != 13) {
                    i++;
                } else {
                    read = inputStream.read();
                    if (read == -1) {
                        throw new EOFException("The end of the stream from the proxy server was reached unexpectedly after a carriage return.");
                    } else if (read != 10) {
                        i += 2;
                    } else if (i == 0) {
                        return;
                    }
                }
            }
        }
    }

    String aQv() {
        return this.dZr;
    }
}
