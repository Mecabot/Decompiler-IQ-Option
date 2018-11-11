package android.databinding;

import com.android.a.a.a.b;
import com.iqoption.a;
import com.iqoption.charttools.h;
import com.iqoption.core.d;
import com.iqoption.deposit.e;
import com.iqoption.quiz.c;

public class DataBinderMapperImpl extends MergedDataBinderMapper {
    DataBinderMapperImpl() {
        addMapper(new a());
        addMapper(new b());
        addMapper(new com.iqoption.videoeducation.b());
        addMapper(new c());
        addMapper(new d());
        addMapper(new h());
        addMapper(new e());
        addMapper(new com.iqoption.dialogs.b());
        addMapper(new com.iqoption.asset.b());
        addMapper(new com.iqoption.billing.b());
    }
}
