package android.arch.persistence.room;

import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;

@RestrictTo({Scope.LIBRARY_GROUP})
public class RoomMasterTable {
    public static String m(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"");
        stringBuilder.append(str);
        stringBuilder.append("\")");
        return stringBuilder.toString();
    }
}
