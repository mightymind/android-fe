package ru.azbn.fe;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.HashMap;

public class FE_DB extends SQLiteOpenHelper {

	FE_ForEach FE;
	SQLiteDatabase db;

	HashMap<String, String> tables;

	public FE_DB(FE_ForEach fe, String name, CursorFactory factory, int version) {
		super(fe.appContext, name, factory, version);
		FE = fe;

		try {
			db = this.getWritableDatabase();
		} catch (SQLiteException ex){
			db = this.getReadableDatabase();
		}

		tables = new HashMap<String, String>();
		tables.put("param", "param");
	}

	public long insert(String table, ContentValues cv) {
		return db.insert(tables.get(table), null, cv);
	}

	public Cursor select(String table, String selection, String[] selectionArgs, String orderBy) {
		return db.query(tables.get(table), null, selection, selectionArgs, null, null, orderBy);
	}

	public Integer update(String table, ContentValues cv, String where, String[] where_args) {
		return db.update(tables.get(table), cv, where, where_args);// where = id=?, where_args = String[] { id }
	}

	public int delete(String table, String param) {
		return db.delete(tables.get(table), param, null);
	}

	public Cursor all(String table) {
		return db.query(tables.get(table), null, null, null, null, null, null, null);
	}

	public Cursor sql(String sql, String[] selectionArgs) {
		return db.rawQuery(sql, selectionArgs);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE "+tables.get("param")+" (id INTEGER PRIMARY KEY AUTOINCREMENT, param TEXT, value TEXT);");
		//db.execSQL("create table cars (id integer primary key autoincrement, name text);");
		//db.execSQL("create table fillings (id integer primary key autoincrement, created_at integer, car integer, liter integer, cost real);");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		if(newVersion > oldVersion) {
			db.execSQL("DROP TABLE IF EXISTS "+tables.get("param"));
			onCreate(db);
		}
	}

	public void close() {
		db.close();
	}

}