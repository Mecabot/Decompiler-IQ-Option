package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;

public class InvalidProtocolBufferException extends IOException {
    private n unfinishedMessage = null;

    public InvalidProtocolBufferException(String str) {
        super(str);
    }

    public InvalidProtocolBufferException g(n nVar) {
        this.unfinishedMessage = nVar;
        return this;
    }

    public n buW() {
        return this.unfinishedMessage;
    }

    static InvalidProtocolBufferException buX() {
        return new InvalidProtocolBufferException("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }

    static InvalidProtocolBufferException buY() {
        return new InvalidProtocolBufferException("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static InvalidProtocolBufferException buZ() {
        return new InvalidProtocolBufferException("CodedInputStream encountered a malformed varint.");
    }

    static InvalidProtocolBufferException bva() {
        return new InvalidProtocolBufferException("Protocol message contained an invalid tag (zero).");
    }

    static InvalidProtocolBufferException bvb() {
        return new InvalidProtocolBufferException("Protocol message end-group tag did not match expected tag.");
    }

    static InvalidProtocolBufferException bvc() {
        return new InvalidProtocolBufferException("Protocol message tag had invalid wire type.");
    }

    static InvalidProtocolBufferException bvd() {
        return new InvalidProtocolBufferException("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    static InvalidProtocolBufferException bve() {
        return new InvalidProtocolBufferException("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    static InvalidProtocolBufferException bvf() {
        return new InvalidProtocolBufferException("Protocol message had invalid UTF-8.");
    }
}
