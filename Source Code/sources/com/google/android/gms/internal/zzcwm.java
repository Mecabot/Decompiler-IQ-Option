package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.People.LoadPeopleResult;
import com.google.android.gms.plus.model.people.PersonBuffer;

final class zzcwm implements LoadPeopleResult {
    private /* synthetic */ Status zzetp;

    zzcwm(zzcwl zzcwl, Status status) {
        this.zzetp = status;
    }

    public final String getNextPageToken() {
        return null;
    }

    public final PersonBuffer getPersonBuffer() {
        return null;
    }

    public final Status getStatus() {
        return this.zzetp;
    }

    public final void release() {
    }
}
