package com.kth.tobawoo.utils;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;
import android.provider.BaseColumns;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.androidquery.util.Common;
import com.google.gson.Gson;
import com.kth.tobawoo.data.Zipcode;
import com.kth.tobawoo.ui.MainActivity;
import com.kth.tobawoo.ui.common.URLManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by tommy on 2016-05-27.
 */
public class DBHelper {
    private static final String DATABASE_NAME = "main.db";

    private static final int DATABASE_VERSION = 14;

    public static SQLiteDatabase mDB;

    private DatabaseHelper mDBHelper;

    private Context mCtx;


    private class DatabaseHelper extends SQLiteOpenHelper {

        public DatabaseHelper(Context context, String name,
                              SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }


        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DataBases._CREATE);

            new MyTask().execute();

        }

        // 버전이 업데이트 되었을 경우 DB를 다시 만들어 준다.
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + DataBases._TABLENAME);
            onCreate(db);
        }

    }

    public DBHelper(Context context) {
        this.mCtx = context;
    }


    /**
     * DB 열기
     * @return
     * @throws SQLException
     */
    public DBHelper open() throws SQLException {

        if(mDB!=null && mDB.isOpen())
            return this;

        mDBHelper = new DatabaseHelper(mCtx, DATABASE_NAME, null, DATABASE_VERSION);
        mDB = mDBHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        if(mDB!=null && mDB.isOpen() )
            mDB.close();
    }

    public void initData(){
        mDB.execSQL("DROP TABLE IF EXISTS " + DataBases._TABLENAME);
        mDB.execSQL(DataBases._CREATE);

    }
    /**
     * 데이터 입력하는 데이터 베이스 함수
     * @param mList
     */
    public void addData(List<Zipcode> mList){

        if(mDB!=null && !mDB.isOpen()){
            open();
        }

        try {

            int i = 1;
            mDB.beginTransaction();
            for (Zipcode data : mList) {
                ContentValues cv = new ContentValues();
                cv.put("sido", data.getSido());
                cv.put("gugun", data.getGugun());
                cv.put("dong", data.getDong());
                cv.put("bunji", data.getBunji());
                cv.put("zipcode", data.getZipcode());

                Logger.log( (i++)  + ": add data -> " + data.toString());

                mDB.insert(DataBases._TABLENAME, null, cv);
            }
            mDB.setTransactionSuccessful();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            mDB.endTransaction();
        }
    }

    public List<String> fetchSido(){
        List<String> sidoList = new ArrayList<String>();

        Cursor cursor = mDB.rawQuery("select distinct(sido) from " + DataBases._TABLENAME , null);
        while (cursor.moveToNext()){
            String sido = cursor.getString(cursor.getColumnIndex("sido"));
            sidoList.add(sido);
        }
        cursor.close();

        return  sidoList;
    }

    public void fetchGuGun(String sido , List<String> gugunList){

        gugunList.clear();

        Cursor cursor = mDB.rawQuery("select distinct(gugun) from " + DataBases._TABLENAME + " where sido = ?" , new String[]{sido});
        while (cursor.moveToNext()){
            String gugun = cursor.getString(cursor.getColumnIndex("gugun"));
            gugunList.add(gugun);
        }
        cursor.close();

    }

    public void fetchDong(String sido , String gugun ,  List<String> dongList){

        dongList.clear();

        Cursor cursor = mDB.rawQuery("select distinct(dong) from " + DataBases._TABLENAME + " where sido = ? and gugun = ?" , new String[]{sido , gugun});
        while (cursor.moveToNext()){
            String dong = cursor.getString(cursor.getColumnIndex("dong"));
            dongList.add(dong);
        }
        cursor.close();

    }


    /**
     * 기본 데이터 베이스 컬럼 정의
     */
    public final class DataBases implements BaseColumns {
        public static final String SIDO = "sido";
        public static final String GUGUN = "gugun";
        public static final String DONG = "dong";
        public static final String BUNJI = "bunji";
        public static final String ZIPCODE = "zipcode";

        public static final String _TABLENAME = "zipcode";
        public static final String _CREATE =
                "create table "+_TABLENAME+"("
                        +_ID+" integer primary key autoincrement, "
                        +SIDO+" text not null , "
                        +GUGUN+" text not null , "
                        +DONG+" text not null , "
                        +BUNJI+" text not null , "
                        +ZIPCODE+" text )";
    }

    class MyTask extends AsyncTask<Void,Void,Void> {
        ProgressDialog pd;
        public MyTask(){
            pd = new ProgressDialog(mCtx);
            pd.setMessage("DB 구성중입니다...");
            pd.setCancelable(false);
            pd.show();
        }

        /**
         * DB 백그라운드 실행
         * @param params
         * @return
         */
        @Override
        protected Void doInBackground(Void... params) {

            List<Zipcode> mList = new ArrayList<Zipcode>();
            InputStreamReader is = null;
            try {
                is = new InputStreamReader(mCtx.getAssets()
                        .open("zipcode.csv")); //Asset에서 menu.csv 를 호출

                BufferedReader reader = new BufferedReader(is);
                reader.readLine();
                String line;
                while ((line = reader.readLine()) != null) {
                    //Asset를 가져와서 토큰을 돌리면서 하나씩 실행
//                    StringTokenizer st = new StringTokenizer(line , "|");
                    String[] items = line.split("\\|");
//                    List<String> tokkens = new ArrayList<String>();
//                    while (st.hasMoreTokens()){
//                        MLogger.log(st.nextToken());
//                        tokkens.add(st.nextToken());
//                    }

                    Zipcode zipcode = new Zipcode();
                    zipcode.setSido(items[1]);
                    zipcode.setGugun(items[2]);
                    zipcode.setDong(items[3]);
                    zipcode.setBunji(items[4]);
                    zipcode.setZipcode(items[5]);

                    Logger.log(zipcode.toString());

                    mList.add(zipcode);
                }

                Logger.log("2300 mList size -> " + mList.size());

                addData(mList);

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            pd.dismiss();
        }
    }
}
