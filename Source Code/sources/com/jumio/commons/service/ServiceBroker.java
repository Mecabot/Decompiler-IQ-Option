package com.jumio.commons.service;

import android.content.Context;
import java.util.HashMap;

public abstract class ServiceBroker {
    private boolean mInitialized = false;
    private HashMap<String, Service> serviceDirectory;
    private final Object serviceDirectoryLock = new Object();

    public Service getService(Context context, String str) {
        Service service;
        synchronized (this.serviceDirectoryLock) {
            service = (Service) this.serviceDirectory.get(str);
            if (!(service.hasContext() || context == null)) {
                service.setContext(context);
            }
        }
        return service;
    }

    public void setContext(Context context) {
        if (this.serviceDirectory != null) {
            synchronized (this.serviceDirectoryLock) {
                for (Service context2 : this.serviceDirectory.values()) {
                    context2.setContext(context);
                }
            }
        }
    }

    public synchronized void initialize() {
        if (!this.mInitialized) {
            this.mInitialized = true;
            synchronized (this.serviceDirectoryLock) {
                if (this.serviceDirectory != null) {
                    this.serviceDirectory.clear();
                }
                this.serviceDirectory = new HashMap();
            }
        }
    }

    public synchronized boolean isInitialized() {
        return this.mInitialized;
    }

    public synchronized void addService(String str, Service service) {
        if (!this.mInitialized) {
            initialize();
        }
        synchronized (this.serviceDirectoryLock) {
            this.serviceDirectory.put(str, service);
        }
    }

    public synchronized void destroy() {
        synchronized (this.serviceDirectoryLock) {
            this.mInitialized = false;
            if (this.serviceDirectory != null) {
                this.serviceDirectory.clear();
            }
        }
    }
}
