package com.jumio.core.exceptions;

import com.jumio.core.data.document.DocumentScanMode;

public class MissingPluginException extends RuntimeException {
    public MissingPluginException(DocumentScanMode documentScanMode) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Plugin for ");
        stringBuilder.append(documentScanMode);
        stringBuilder.append(" is not linked! check your build file!");
        super(stringBuilder.toString());
    }
}
