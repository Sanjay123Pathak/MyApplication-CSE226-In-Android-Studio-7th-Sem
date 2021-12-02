package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class P17OpenHelperData extends SQLiteOpenHelper {
    private static  final String DATABASE_NAME="MyDataBase";
    private  static  final String   TABLE_NAME="MyDetails";
    private  static  final String NAME="Name";
    private  static  final String UID="_id";
    private static final String MyPASSWORD= "Password";
    private  static  final  int DATABASE_VERSION=1;
    private  Context context;

    //for creating string query table
 private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+
            " ("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME+" VARCHAR(255) ,"+ MyPASSWORD+" VARCHAR(225));";
 // for dropping table query
    private static final String DROP_TABLE ="DROP TABLE IF EXISTS "+TABLE_NAME;
    public P17OpenHelperData( Context context) {
        super(context ,DATABASE_NAME,null,DATABASE_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // for creating table here now
        try {
            db.execSQL(CREATE_TABLE);
        }catch (Exception e){
            //show message if any errors occur
            Toast.makeText(context, "e", Toast.LENGTH_SHORT).show();

        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            //
            db.execSQL(DROP_TABLE);
            onCreate(db);
        }catch (Exception e){
            Toast.makeText(context, "e", Toast.LENGTH_SHORT).show();

        }
    }
// this is for inserting the data in to the spinner list
    public void insertData(String name, String pass)
    {
        SQLiteDatabase dbb = this.getWritableDatabase();// this is for writing mode
        ContentValues contentValues = new ContentValues();// this is for putting the values in the tables row
        contentValues.put(NAME, name);// for putting name
        contentValues.put(MyPASSWORD, pass);// for putting password
        dbb.insert(TABLE_NAME, null , contentValues);// for inserting in to the table  .and 2nd value is null because when we do
                                                                 // not a give values to the fields it adds null values
        dbb.close();// for closing the connection

    }
    public  int deleteData(String nameDelete){
        SQLiteDatabase sqb=this.getWritableDatabase();
        String[] whereName={nameDelete};
        int count=sqb.delete(TABLE_NAME,NAME+"=?",whereName);
//        sqb.close();
        Toast.makeText(context.getApplicationContext(), ""+count, Toast.LENGTH_SHORT).show();
        return count;

    }
    // for updating the details
//     public  int  updateData(String oldName, String newName){
//        SQLiteDatabase sqLiteDatabase =this.getWritableDatabase();
//        ContentValues cv= new ContentValues();
//        cv.put(NAME,newName);
//        String[] whereArgs={oldName};// for selecting the name i.e old name;
////         int count=sqLiteDatabase.update(TABLE_NAME,cv,NAME+"=?",whereArgs);
//         int count =sqLiteDatabase.update(TABLE_NAME,cv,NAME+" = ?",whereArgs );
//         Toast.makeText(context.getApplicationContext(), ""+count, Toast.LENGTH_SHORT).show();
//        return  count;
////         sqLiteDatabase.close();
//     }

    public int updateName(String oldName , String newName)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME,newName);
        String[] whereArgs= {oldName};
        int count =db.update(TABLE_NAME,contentValues, NAME+" = ?",whereArgs );
        return count;
    }



    //this is for returning the data in list form
    public List<String>getData(){
        List<String> list=new ArrayList<>();
        String selectQuery=" SELECT * FROM "+TABLE_NAME;// query for selecting all values
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();// reading the data for database
        Cursor cursor=sqLiteDatabase.rawQuery(selectQuery,null);// retrung all the values in row for or array you can say
        if (cursor.moveToFirst()){
            // till cursor has values or row we are adding it in the list
            do {
                list.add(cursor.getString(1));
            }while (cursor.moveToNext());
        }
        //closing the connections
        cursor.close();
        sqLiteDatabase.close();
// returning the list
        return list;
    }
}
