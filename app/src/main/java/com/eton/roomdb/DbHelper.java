package com.eton.roomdb;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Date;

public class DbHelper extends SQLiteOpenHelper {

    private static final String TRUE_STRING = "1";
    private static final String FALSE_STRING = "0";

    public DbHelper(Context context, String name, int version) {
        super(context, name, null, version);
    }

    public DbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    /**
     * 返回自动增长主键值
     *
     * @param db
     * @param tablename
     * @return
     */
    public static int getAutoincrement(SQLiteDatabase db, String tablename) {
        Cursor cursor = db.rawQuery("select last_insert_rowid() from " + tablename, null);
        int pid = -1;
        if (cursor.moveToFirst()) {
            pid = cursor.getInt(0);
        }
        cursor.close();
        return pid;
    }

    // SQL非查询操作
    public static void execNonQuery(SQLiteDatabase db, String sql, Object[] params) {
        // 全部数据以字符串类型写入数据库
        if (params == null) {
            db.execSQL(sql);
        } else {
            String[] strParams = new String[params.length];
            for (int i = 0; i < params.length; i++) {
                if (params[i] == null) {
                    strParams[i] = null;
                } else if (params[i] instanceof Boolean) {// 转换布尔类型
                    strParams[i] = ((Boolean) params[i]) ? TRUE_STRING : FALSE_STRING;
                } else if (params[i] instanceof Date) {// 转换时间类型
                    strParams[i] = String.valueOf(((Date) params[i]).getTime());
                } else {
                    strParams[i] = params[i].toString();
                }
            }
            db.execSQL(sql, strParams);
        }
    }

    // SQL查询操作
    public static Cursor execQuery(SQLiteDatabase db, String sql, Object[] params) {
        // 全部数据以字符串类型写入数据库
        if (params == null) {
            return db.rawQuery(sql, null);
        } else {
            String[] strParams = new String[params.length];
            for (int i = 0; i < params.length; i++) {
                if (params[i] == null) {
                    strParams[i] = null;
                } else if (params[i] instanceof Boolean) {// 转换布尔类型
                    strParams[i] = ((Boolean) params[i]) ? TRUE_STRING : FALSE_STRING;
                } else if (params[i] instanceof Date) {// 转换时间类型
                    strParams[i] = String.valueOf(((Date) params[i]).getTime());
                } else {
                    strParams[i] = params[i].toString();
                }
            }
            return db.rawQuery(sql, strParams);
        }
    }

    // 获取指定列的String值
    public static String getString(Cursor cursor, String columnName) {
        int p = cursor.getColumnIndex(columnName);
        if (p > -1) {
            return getString(cursor, p);
        }
        return null;
    }

    // 获取指定列的String值
    public static String getString(Cursor cursor, int index) {
        return cursor.getString(index);
    }

    // 获取指定列的Integer值
    public static Integer getInt(Cursor cursor, String columnName) {
        int p = cursor.getColumnIndex(columnName);
        if (p > -1) {
            return getInt(cursor, p);
        }
        return null;
    }

    // 获取指定列的Integer值
    public static Integer getInt(Cursor cursor, int index) {
        return cursor.getInt(index);
    }

    // 获取指定列的Long值
    public static Long getLong(Cursor cursor, String columnName) {
        int p = cursor.getColumnIndex(columnName);
        if (p > -1) {
            return getLong(cursor, p);
        }
        return null;
    }

    // 获取指定列的Long值
    public static Long getLong(Cursor cursor, int index) {
        return cursor.getLong(index);
    }

    // 获取指定列的Short值
    public static Short getShort(Cursor cursor, String columnName) {
        int p = cursor.getColumnIndex(columnName);
        if (p > -1) {
            return getShort(cursor, p);
        }
        return null;
    }

    // 获取指定列的Short值
    public static Short getShort(Cursor cursor, int index) {
        return cursor.getShort(index);
    }

    // 获取指定列的Float值
    public static Float getFloat(Cursor cursor, String columnName) {
        int p = cursor.getColumnIndex(columnName);
        if (p > -1) {
            return getFloat(cursor, p);
        }
        return null;
    }

    // 获取指定列的Float值
    public static Float getFloat(Cursor cursor, int index) {
        return cursor.getFloat(index);
    }

    // 获取指定列的Double值
    public static Double getDouble(Cursor cursor, String columnName) {
        int p = cursor.getColumnIndex(columnName);
        if (p > -1) {
            return getDouble(cursor, p);
        }
        return null;
    }

    // 获取指定列的Double值
    public static Double getDouble(Cursor cursor, int index) {
        return cursor.getDouble(index);
    }

    // 获取指定列的Blob值
    public static byte[] getBlob(Cursor cursor, String columnName) {
        int p = cursor.getColumnIndex(columnName);
        if (p > -1) {
            return getBlob(cursor, p);
        }
        return null;
    }

    // 获取指定列的Blob值
    public static byte[] getBlob(Cursor cursor, int index) {
        return cursor.getBlob(index);
    }

    // 获取指定列的Boolean值
    public static Boolean getBoolean(Cursor cursor, String columnName) {
        int p = cursor.getColumnIndex(columnName);
        if (p > -1) {
            return getBoolean(cursor, p);
        }
        return null;
    }

    // 获取指定列的Boolean值
    public static Boolean getBoolean(Cursor cursor, int index) {
        String value = cursor.getString(index);
        return value != null && ("1".equals(value) || Boolean.valueOf(value));
    }

    // 获取指定列的Date值
    public static Date getDate(Cursor cursor, String columnName) {
        int p = cursor.getColumnIndex(columnName);
        if (p > -1) {
            return getDate(cursor, p);
        }
        return null;
    }

    // 获取指定列的Date值
    public static Date getDate(Cursor cursor, int index) {
        return new Date(cursor.getLong(index));
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // 群组列表
        sqLiteDatabase.execSQL("create table chat_list (uid varchar, chat_id varchar, users varchar, " +
                "avatar varchar, title varchar, update_time timestamp, unreader integer, " +
                "currp integer, is_private varchar, from_id varchar, text varchar, chatp integer," +
                "msg_type integer, event varchar, from_role integer, from_nick_name varchar," +
                "from_avatar varchar, file_id varchar, file_duration integer, is_muted varchar," +
                "at varchar, at_nick_name varchar)");

        // 聊天消息列表
        sqLiteDatabase.execSQL("create table chat_msg_list (uid varchar, chat_id varchar, " +
                "id varchar primary key, time timestamp, from_user varchar, text varchar, chat_p integer, " +
                "msg_type integer, event varchar, from_role integer, from_nick_name varchar," +
                "from_avatar varchar, file_id varchar, image_local_url varchar, voice_local_url varchar," +
                " file_duration integer, is_muted varchar, at varchar, at_nick_name varchar, " +
                "send_state integer, item_type integer, og_object varchar)");

        sqLiteDatabase.execSQL("create table test (id, name)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("drop table if exists chat_list");
        sqLiteDatabase.execSQL("drop table if exists chat_msg_list");
        onCreate(sqLiteDatabase);
    }
}
