package android.arch.persistence.db.framework;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Configuration;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Factory;

public final class FrameworkSQLiteOpenHelperFactory implements Factory {
    public SupportSQLiteOpenHelper a(Configuration configuration) {
        return new FrameworkSQLiteOpenHelper(configuration.context, configuration.name, configuration.bN);
    }
}
