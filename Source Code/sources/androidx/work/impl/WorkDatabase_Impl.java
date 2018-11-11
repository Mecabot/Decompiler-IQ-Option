package androidx.work.impl;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Configuration;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomDatabase.Callback;
import android.arch.persistence.room.RoomOpenHelper;
import android.arch.persistence.room.RoomOpenHelper.Delegate;
import android.arch.persistence.room.util.TableInfo;
import android.arch.persistence.room.util.TableInfo.Column;
import android.arch.persistence.room.util.TableInfo.ForeignKey;
import android.arch.persistence.room.util.TableInfo.Index;
import androidx.work.impl.b.b;
import androidx.work.impl.b.c;
import androidx.work.impl.b.e;
import androidx.work.impl.b.f;
import androidx.work.impl.b.h;
import androidx.work.impl.b.i;
import androidx.work.impl.b.k;
import androidx.work.impl.b.l;
import androidx.work.impl.b.n;
import androidx.work.impl.b.o;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WorkDatabase_Impl extends WorkDatabase {
    private volatile n eA;
    private volatile e eB;
    private volatile h eC;
    private volatile k ey;
    private volatile b ez;

    protected SupportSQLiteOpenHelper b(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.ca.a(Configuration.d(databaseConfiguration.context).l(databaseConfiguration.name).a(new RoomOpenHelper(databaseConfiguration, new Delegate(4) {
            public void m(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `Dependency` (`work_spec_id` TEXT NOT NULL, `prerequisite_id` TEXT NOT NULL, PRIMARY KEY(`work_spec_id`, `prerequisite_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE , FOREIGN KEY(`prerequisite_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                supportSQLiteDatabase.execSQL("CREATE  INDEX `index_Dependency_work_spec_id` ON `Dependency` (`work_spec_id`)");
                supportSQLiteDatabase.execSQL("CREATE  INDEX `index_Dependency_prerequisite_id` ON `Dependency` (`prerequisite_id`)");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `WorkSpec` (`id` TEXT NOT NULL, `state` INTEGER NOT NULL, `worker_class_name` TEXT NOT NULL, `input_merger_class_name` TEXT, `input` BLOB NOT NULL, `output` BLOB NOT NULL, `initial_delay` INTEGER NOT NULL, `interval_duration` INTEGER NOT NULL, `flex_duration` INTEGER NOT NULL, `run_attempt_count` INTEGER NOT NULL, `backoff_policy` INTEGER NOT NULL, `backoff_delay_duration` INTEGER NOT NULL, `period_start_time` INTEGER NOT NULL, `minimum_retention_duration` INTEGER NOT NULL, `schedule_requested_at` INTEGER NOT NULL, `required_network_type` INTEGER, `requires_charging` INTEGER NOT NULL, `requires_device_idle` INTEGER NOT NULL, `requires_battery_not_low` INTEGER NOT NULL, `requires_storage_not_low` INTEGER NOT NULL, `content_uri_triggers` BLOB, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL("CREATE  INDEX `index_WorkSpec_schedule_requested_at` ON `WorkSpec` (`schedule_requested_at`)");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `WorkTag` (`tag` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`tag`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                supportSQLiteDatabase.execSQL("CREATE  INDEX `index_WorkTag_work_spec_id` ON `WorkTag` (`work_spec_id`)");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `WorkName` (`name` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`name`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                supportSQLiteDatabase.execSQL("CREATE  INDEX `index_WorkName_work_spec_id` ON `WorkName` (`work_spec_id`)");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"c45e5fcbdf3824dead9778f19e2fd8af\")");
            }

            public void l(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `Dependency`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `WorkSpec`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `WorkTag`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `SystemIdInfo`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `WorkName`");
            }

            protected void b(SupportSQLiteDatabase supportSQLiteDatabase) {
                if (WorkDatabase_Impl.this.mCallbacks != null) {
                    int size = WorkDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((Callback) WorkDatabase_Impl.this.mCallbacks.get(i)).b(supportSQLiteDatabase);
                    }
                }
            }

            public void c(SupportSQLiteDatabase supportSQLiteDatabase) {
                WorkDatabase_Impl.this.cG = supportSQLiteDatabase;
                supportSQLiteDatabase.execSQL("PRAGMA foreign_keys = ON");
                WorkDatabase_Impl.this.b(supportSQLiteDatabase);
                if (WorkDatabase_Impl.this.mCallbacks != null) {
                    int size = WorkDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((Callback) WorkDatabase_Impl.this.mCallbacks.get(i)).c(supportSQLiteDatabase);
                    }
                }
            }

            protected void n(SupportSQLiteDatabase supportSQLiteDatabase) {
                SupportSQLiteDatabase supportSQLiteDatabase2 = supportSQLiteDatabase;
                Map hashMap = new HashMap(2);
                hashMap.put("work_spec_id", new Column("work_spec_id", "TEXT", true, 1));
                hashMap.put("prerequisite_id", new Column("prerequisite_id", "TEXT", true, 2));
                Set hashSet = new HashSet(2);
                hashSet.add(new ForeignKey("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{"id"})));
                hashSet.add(new ForeignKey("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"prerequisite_id"}), Arrays.asList(new String[]{"id"})));
                Set hashSet2 = new HashSet(2);
                hashSet2.add(new Index("index_Dependency_work_spec_id", false, Arrays.asList(new String[]{"work_spec_id"})));
                hashSet2.add(new Index("index_Dependency_prerequisite_id", false, Arrays.asList(new String[]{"prerequisite_id"})));
                TableInfo tableInfo = new TableInfo("Dependency", hashMap, hashSet, hashSet2);
                TableInfo a = TableInfo.a(supportSQLiteDatabase2, "Dependency");
                StringBuilder stringBuilder;
                if (tableInfo.equals(a)) {
                    hashMap = new HashMap(21);
                    hashMap.put("id", new Column("id", "TEXT", true, 1));
                    hashMap.put("state", new Column("state", "INTEGER", true, 0));
                    hashMap.put("worker_class_name", new Column("worker_class_name", "TEXT", true, 0));
                    hashMap.put("input_merger_class_name", new Column("input_merger_class_name", "TEXT", false, 0));
                    hashMap.put("input", new Column("input", "BLOB", true, 0));
                    hashMap.put("output", new Column("output", "BLOB", true, 0));
                    hashMap.put("initial_delay", new Column("initial_delay", "INTEGER", true, 0));
                    hashMap.put("interval_duration", new Column("interval_duration", "INTEGER", true, 0));
                    hashMap.put("flex_duration", new Column("flex_duration", "INTEGER", true, 0));
                    hashMap.put("run_attempt_count", new Column("run_attempt_count", "INTEGER", true, 0));
                    hashMap.put("backoff_policy", new Column("backoff_policy", "INTEGER", true, 0));
                    hashMap.put("backoff_delay_duration", new Column("backoff_delay_duration", "INTEGER", true, 0));
                    hashMap.put("period_start_time", new Column("period_start_time", "INTEGER", true, 0));
                    hashMap.put("minimum_retention_duration", new Column("minimum_retention_duration", "INTEGER", true, 0));
                    hashMap.put("schedule_requested_at", new Column("schedule_requested_at", "INTEGER", true, 0));
                    hashMap.put("required_network_type", new Column("required_network_type", "INTEGER", false, 0));
                    hashMap.put("requires_charging", new Column("requires_charging", "INTEGER", true, 0));
                    hashMap.put("requires_device_idle", new Column("requires_device_idle", "INTEGER", true, 0));
                    hashMap.put("requires_battery_not_low", new Column("requires_battery_not_low", "INTEGER", true, 0));
                    hashMap.put("requires_storage_not_low", new Column("requires_storage_not_low", "INTEGER", true, 0));
                    hashMap.put("content_uri_triggers", new Column("content_uri_triggers", "BLOB", false, 0));
                    hashSet = new HashSet(0);
                    hashSet2 = new HashSet(1);
                    hashSet2.add(new Index("index_WorkSpec_schedule_requested_at", false, Arrays.asList(new String[]{"schedule_requested_at"})));
                    tableInfo = new TableInfo("WorkSpec", hashMap, hashSet, hashSet2);
                    a = TableInfo.a(supportSQLiteDatabase2, "WorkSpec");
                    if (tableInfo.equals(a)) {
                        hashMap = new HashMap(2);
                        hashMap.put("tag", new Column("tag", "TEXT", true, 1));
                        hashMap.put("work_spec_id", new Column("work_spec_id", "TEXT", true, 2));
                        hashSet = new HashSet(1);
                        hashSet.add(new ForeignKey("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{"id"})));
                        hashSet2 = new HashSet(1);
                        hashSet2.add(new Index("index_WorkTag_work_spec_id", false, Arrays.asList(new String[]{"work_spec_id"})));
                        tableInfo = new TableInfo("WorkTag", hashMap, hashSet, hashSet2);
                        a = TableInfo.a(supportSQLiteDatabase2, "WorkTag");
                        if (tableInfo.equals(a)) {
                            hashMap = new HashMap(2);
                            hashMap.put("work_spec_id", new Column("work_spec_id", "TEXT", true, 1));
                            hashMap.put("system_id", new Column("system_id", "INTEGER", true, 0));
                            hashSet = new HashSet(1);
                            hashSet.add(new ForeignKey("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{"id"})));
                            tableInfo = new TableInfo("SystemIdInfo", hashMap, hashSet, new HashSet(0));
                            a = TableInfo.a(supportSQLiteDatabase2, "SystemIdInfo");
                            if (tableInfo.equals(a)) {
                                hashMap = new HashMap(2);
                                hashMap.put("name", new Column("name", "TEXT", true, 1));
                                hashMap.put("work_spec_id", new Column("work_spec_id", "TEXT", true, 2));
                                Set hashSet3 = new HashSet(1);
                                hashSet3.add(new ForeignKey("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{"id"})));
                                hashSet = new HashSet(1);
                                hashSet.add(new Index("index_WorkName_work_spec_id", false, Arrays.asList(new String[]{"work_spec_id"})));
                                TableInfo tableInfo2 = new TableInfo("WorkName", hashMap, hashSet3, hashSet);
                                TableInfo a2 = TableInfo.a(supportSQLiteDatabase2, "WorkName");
                                if (!tableInfo2.equals(a2)) {
                                    stringBuilder = new StringBuilder();
                                    stringBuilder.append("Migration didn't properly handle WorkName(androidx.work.impl.model.WorkName).\n Expected:\n");
                                    stringBuilder.append(tableInfo2);
                                    stringBuilder.append("\n");
                                    stringBuilder.append(" Found:\n");
                                    stringBuilder.append(a2);
                                    throw new IllegalStateException(stringBuilder.toString());
                                }
                                return;
                            }
                            stringBuilder = new StringBuilder();
                            stringBuilder.append("Migration didn't properly handle SystemIdInfo(androidx.work.impl.model.SystemIdInfo).\n Expected:\n");
                            stringBuilder.append(tableInfo);
                            stringBuilder.append("\n");
                            stringBuilder.append(" Found:\n");
                            stringBuilder.append(a);
                            throw new IllegalStateException(stringBuilder.toString());
                        }
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("Migration didn't properly handle WorkTag(androidx.work.impl.model.WorkTag).\n Expected:\n");
                        stringBuilder.append(tableInfo);
                        stringBuilder.append("\n");
                        stringBuilder.append(" Found:\n");
                        stringBuilder.append(a);
                        throw new IllegalStateException(stringBuilder.toString());
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Migration didn't properly handle WorkSpec(androidx.work.impl.model.WorkSpec).\n Expected:\n");
                    stringBuilder.append(tableInfo);
                    stringBuilder.append("\n");
                    stringBuilder.append(" Found:\n");
                    stringBuilder.append(a);
                    throw new IllegalStateException(stringBuilder.toString());
                }
                stringBuilder = new StringBuilder();
                stringBuilder.append("Migration didn't properly handle Dependency(androidx.work.impl.model.Dependency).\n Expected:\n");
                stringBuilder.append(tableInfo);
                stringBuilder.append("\n");
                stringBuilder.append(" Found:\n");
                stringBuilder.append(a);
                throw new IllegalStateException(stringBuilder.toString());
            }
        }, "c45e5fcbdf3824dead9778f19e2fd8af", "433431a854c108416da77d9b397eaeec")).af());
    }

    protected InvalidationTracker ap() {
        return new InvalidationTracker(this, "Dependency", "WorkSpec", "WorkTag", "SystemIdInfo", "WorkName");
    }

    public k bu() {
        if (this.ey != null) {
            return this.ey;
        }
        k kVar;
        synchronized (this) {
            if (this.ey == null) {
                this.ey = new l(this);
            }
            kVar = this.ey;
        }
        return kVar;
    }

    public b bv() {
        if (this.ez != null) {
            return this.ez;
        }
        b bVar;
        synchronized (this) {
            if (this.ez == null) {
                this.ez = new c(this);
            }
            bVar = this.ez;
        }
        return bVar;
    }

    public n bw() {
        if (this.eA != null) {
            return this.eA;
        }
        n nVar;
        synchronized (this) {
            if (this.eA == null) {
                this.eA = new o(this);
            }
            nVar = this.eA;
        }
        return nVar;
    }

    public e bx() {
        if (this.eB != null) {
            return this.eB;
        }
        e eVar;
        synchronized (this) {
            if (this.eB == null) {
                this.eB = new f(this);
            }
            eVar = this.eB;
        }
        return eVar;
    }

    public h by() {
        if (this.eC != null) {
            return this.eC;
        }
        h hVar;
        synchronized (this) {
            if (this.eC == null) {
                this.eC = new i(this);
            }
            hVar = this.eC;
        }
        return hVar;
    }
}
