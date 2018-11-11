package android.arch.persistence.db;

public interface SupportSQLiteStatement extends SupportSQLiteProgram {
    long executeInsert();

    int executeUpdateDelete();
}
