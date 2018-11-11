package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;

public interface CallableMemberDescriptor extends a, s {

    public enum Kind {
        DECLARATION,
        FAKE_OVERRIDE,
        DELEGATION,
        SYNTHESIZED;

        public boolean isReal() {
            return this != FAKE_OVERRIDE;
        }
    }

    void Q(Collection<? extends CallableMemberDescriptor> collection);

    CallableMemberDescriptor a(k kVar, Modality modality, av avVar, Kind kind, boolean z);

    Collection<? extends CallableMemberDescriptor> bcU();

    CallableMemberDescriptor bcV();

    Kind bcW();
}
