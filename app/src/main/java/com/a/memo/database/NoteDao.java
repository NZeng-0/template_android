package com.a.memo.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.a.memo.MyApp;
import com.a.memo.bean.NoteData;
import com.a.memo.bean.UserData;

import java.util.ArrayList;
import java.util.List;

/**
 * @author P7000P
 * @version 1.0
 * @description: TODO
 * @date 2023/12/8 14:08
 */
public class NoteDao {
    private DBOpenHelper helper;// 创建 DBOpenHelper 对象
    private SQLiteDatabase db;// 创建 SQLiteDatabase 对象

    public NoteDao(Context context) {
        helper = new DBOpenHelper(context);// 初始化 DBOpenHelper 对象
    }


    /**
     * 增加信息
     * private int _id;
     * private int mid;
     * private String title;
     * private String img;
     * private String type;
     * private String date;
     * private String time;
     * private float money;
     *
     * @param accountInfo
     */
    public void add(NoteData accountInfo) {
        db = helper.getWritableDatabase();// 初始化 SQLiteDatabase 对象
        db.execSQL("insert into note (_id,mid,title,text,time) values (?,?,?,?,?)",
                new Object[]{
                        accountInfo.get_id(),
                        accountInfo.getMid(),
                        accountInfo.getTitle(),
                        accountInfo.getText(),
                        accountInfo.getTime(),
                });// 执行添加便签信息操作
    }

    /**
     * 获取全部信息
     *
     * @return
     */
    public List<NoteData> getAll() {
        List<NoteData> list = new ArrayList<>(); // 创建集合对象
        db = helper.getWritableDatabase(); // 初始化 SQLiteDatabase 对象
        Cursor cursor = db.rawQuery("SELECT * FROM note Where mid = \'" + MyApp.USERNAME + "\'", null); // 查询全部数据

        while (cursor.moveToNext()) { // 遍历查询结果
            // 从游标中读取每行数据的字段值
            int id = cursor.getInt(cursor.getColumnIndex("_id"));
            String mid = cursor.getString(cursor.getColumnIndex("mid"));
            String title = cursor.getString(cursor.getColumnIndex("title"));
            String text = cursor.getString(cursor.getColumnIndex("text"));
            String time = cursor.getString(cursor.getColumnIndex("time"));

            // 创建 UserInfo 对象，并将字段值设置到对象中
            NoteData note = new NoteData(
                    id, mid, title, text, time
            );

            // 将 UserInfo 对象添加到集合中
            list.add(note);
        }

        cursor.close(); // 关闭游标
        return list; // 返回集合
    }

    /**
     * 获取最大编号
     *
     * @return
     */
    public int getMaxId() {
        db = helper.getWritableDatabase();// 初始化 SQLiteDatabase 对象
        Cursor cursor = db.rawQuery("select max(_id) from note", null);// 获取便签信息表中的最大编号
        while (cursor.moveToLast()) {// 访问 Cursor 中的最后一条数据
            return cursor.getInt(0);// 获取访问到的数据，即最大编号
        }
        return 0;// 如果没有数据，则返回 0
    }

    /**
     * 更新信息
     *
     * @param tb_flag
     */
    public void update(NoteData tb_flag) {
        db = helper.getWritableDatabase();// 初始化 SQLiteDatabase 对象
        db.execSQL("update note set mid = ? , title = ?, text = ? , time = ? where _id = ?",
                new Object[]{
                        MyApp.USERNAME,
                        tb_flag.getTitle(),
                        tb_flag.getText(),
                        tb_flag.getTime(),
                        tb_flag.get_id()}
        );// 执行修改便签信息操作
    }

    /**
     * 刪除信息
     *
     * @param ids
     */
    public void detele(Integer... ids) {
        if (ids.length > 0)// 判断是否存在要删除的 id
        {
            StringBuffer sb = new StringBuffer();// 创建 StringBuffer 对象
            for (int i = 0; i < ids.length; i++)// 遍历要删除的 id 集合
            {
                sb.append('?').append(',');// 将删除条件添加到 StringBuffer 对象中
            }
            sb.deleteCharAt(sb.length() - 1);// 去掉最后一个“,“字符
            db = helper.getWritableDatabase();// 创建 SQLiteDatabase 对象
            // 执行删除便签信息操作
            db.execSQL("delete from note where _id in (" + sb + ")",
                    (Object[]) ids);
        }
    }

    /**
     * 查询
     *
     * @param s
     */
    public List<NoteData> search(String s) {
        List<NoteData> list = new ArrayList<>(); // 创建集合对象
        db = helper.getWritableDatabase(); // 初始化 SQLiteDatabase 对象
        Cursor cursor = db.rawQuery(
                "SELECT * FROM note WHERE mid = ? AND title LIKE ?",
                new String[]{MyApp.USERNAME, "%" + s + "%"});
        // 查询全部数据

        while (cursor.moveToNext()) { // 遍历查询结果
            // 从游标中读取每行数据的字段值
            int id = cursor.getInt(cursor.getColumnIndex("_id"));
            String mid = cursor.getString(cursor.getColumnIndex("mid"));
            String title = cursor.getString(cursor.getColumnIndex("title"));
            String text = cursor.getString(cursor.getColumnIndex("text"));
            String time = cursor.getString(cursor.getColumnIndex("time"));

            // 创建 UserInfo 对象，并将字段值设置到对象中
            NoteData note = new NoteData(
                    id, mid, title, text, time
            );

            // 将 UserInfo 对象添加到集合中
            list.add(note);
        }

        cursor.close(); // 关闭游标
        return list; // 返回集合
    }

}
