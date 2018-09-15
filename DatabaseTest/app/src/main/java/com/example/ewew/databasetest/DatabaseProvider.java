package com.example.ewew.databasetest;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class DatabaseProvider extends ContentProvider {

    public static final int BOOK_DIR=0;
    public static final int BOOK_ITEM=1;
    public static final int CATEGORY_DIR=2;
    public static final int CATEGORY_ITEM=3;

    public static final String AUTHORITY="com.example.ewew.databasetest.provider";

    private static UriMatcher uriMatcher;

    private MyDatabaseHelper dbHelper;

    static {
        uriMatcher=new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(AUTHORITY,"book",BOOK_DIR);
        uriMatcher.addURI(AUTHORITY,"book/#",BOOK_ITEM);
        uriMatcher.addURI(AUTHORITY,"category",CATEGORY_DIR);
        uriMatcher.addURI(AUTHORITY,"category/#",CATEGORY_ITEM);
    }

    public DatabaseProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        int deletedRows=0;
        switch (uriMatcher.match(uri)){
            case BOOK_DIR:
                deletedRows=db.delete("Book",selection,selectionArgs);
                break;
            case BOOK_ITEM:
                String bookId=uri.getPathSegments().get(1);
                deletedRows=db.delete("Book","id=?",new String[] {bookId});
                break;
            case CATEGORY_DIR:
                deletedRows=db.delete("Category",selection,selectionArgs);
                break;
            case CATEGORY_ITEM:
                String categoryId=uri.getPathSegments().get(1);
                deletedRows=db.delete("Category","id=?",new String[]
                        {categoryId});
                break;
            default:
                break;
        }
        return deletedRows;
    }

    @Override
    public String getType(Uri uri) {
        switch (uriMatcher.match(uri)){
            case BOOK_DIR:
                return "vnd.android.cursor.dir/vnd.com.example.ewew.databasetest." +
                        "provider.book";
            case BOOK_ITEM:
                return "vnd.android.cursor.item/vnd.com.example.ewew.databasetest." +
                        "provider.book";
            case CATEGORY_DIR:
                return "vnd.android.cursor.dir/vnd.com.example.ewew.databasetest." +
                        "provider.category";
            case CATEGORY_ITEM:
                return "vnd.android.cursor.item/vnd.com.example.ewew.databasetest." +
                        "provider.category";
        }
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        // TODO: Implement this to handle requests to insert a new row.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public boolean onCreate() {
        // TODO: Implement this to initialize your content provider on startup.
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        // TODO: Implement this to handle query requests from clients.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
