package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: AbstractParser */
public abstract class b<MessageType extends n> implements p<MessageType> {
    private static final f eNt = f.buE();

    private UninitializedMessageException a(MessageType messageType) {
        if (messageType instanceof a) {
            return ((a) messageType).btS();
        }
        return new UninitializedMessageException(messageType);
    }

    private MessageType b(MessageType messageType) {
        if (messageType == null || messageType.isInitialized()) {
            return messageType;
        }
        throw a(messageType).bvw().g(messageType);
    }

    public MessageType a(d dVar, f fVar) {
        n nVar;
        try {
            e btX = dVar.btX();
            nVar = (n) b(btX, fVar);
            btX.lt(0);
            return nVar;
        } catch (InvalidProtocolBufferException e) {
            throw e.g(nVar);
        } catch (InvalidProtocolBufferException e2) {
            throw e2;
        }
    }

    /* renamed from: b */
    public MessageType c(d dVar, f fVar) {
        return b(a(dVar, fVar));
    }

    public MessageType f(InputStream inputStream, f fVar) {
        e m = e.m(inputStream);
        n nVar = (n) b(m, fVar);
        try {
            m.lt(0);
            return nVar;
        } catch (InvalidProtocolBufferException e) {
            throw e.g(nVar);
        }
    }

    /* renamed from: g */
    public MessageType k(InputStream inputStream, f fVar) {
        return b(f(inputStream, fVar));
    }

    /* renamed from: k */
    public MessageType l(InputStream inputStream) {
        return k(inputStream, eNt);
    }

    public MessageType h(InputStream inputStream, f fVar) {
        try {
            int read = inputStream.read();
            if (read == -1) {
                return null;
            }
            return f(new a(inputStream, e.a(read, inputStream)), fVar);
        } catch (IOException e) {
            throw new InvalidProtocolBufferException(e.getMessage());
        }
    }

    /* renamed from: i */
    public MessageType j(InputStream inputStream, f fVar) {
        return b(h(inputStream, fVar));
    }
}
