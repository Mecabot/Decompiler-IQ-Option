package jumio.nv.nfc;

import java.io.Serializable;

/* compiled from: ReadState */
public enum p implements Serializable {
    INIT,
    BAC_CHECK,
    READ_LDS,
    PASSIVE_AUTH_DSC_CHECK,
    PASSIVE_AUTH_ROOT_CERT_CHECK,
    PASSIVE_AUTH_HASH_CHECK,
    ACTIVE_AUTH_CHECK,
    ADDITIONAL_DATA,
    FACE_IMAGE
}
