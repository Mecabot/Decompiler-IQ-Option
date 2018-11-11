package com.jumio.nv.api.helpers;

import com.jumio.sdk.exception.JumioErrorCase;
import com.jumio.sdk.exception.JumioException;

public class UploadException extends JumioException {
    public UploadException(JumioErrorCase jumioErrorCase, int i) {
        super(jumioErrorCase, i);
    }
}
