package sg.edu.np.practical2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;


public class DBHandler extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE = "users.db";

    public DBHandler(@Nullable Context context) {
        super(context, DATABASE, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create = "CREATE TABLE user (name TEXT, description TEXT, id INTEGER PRIMARY KEY AUTOINCREMENT, followed INTEGER)";
        db.execSQL(create);

        for(int i=0; i<20; i++)
        {
            ContentValues c = new ContentValues();
            c.put("name", "Name" + new Random().nextInt());
            c.put("description","Description " + new Random().nextInt());
            c.put("followed", new Random().nextInt()%2 == 0);
            db.insert("user", null, c);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS user");
        onCreate(db);
    }
    /**
     * select * from users where name = "xxxx";
     *
     * name = *";select * from xxx;
     * @return
     */
    public ArrayList<User> getUsers()
    {
        ArrayList<User> list = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        //Cursor cursor = db.rawQuery("select * from users where name = \"" + name + "\"", null);
        Cursor cursor = db.rawQuery("SELECT * FROM user", null);

        while(cursor.moveToNext())
        {
            u = new User();
            u.setName(cursor.getString(0));
            u.setDescription(cursor.getString(1));
            u.setId(cursor.getInt(2));
            u.followed = cursor.getInt(3)==0?false:true;

            list.add(u);
        }

        cursor.close();
        db.close();
        return list;
    }

    public void updateUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("followed", user.followed);
        int count = db.update("user", values, "id = ?", new String[]{ "" + user.id });
        db.close();
    }
}
