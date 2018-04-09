package calculator.moi.andoid.fr.paysmart.Helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Database Name
    private static final String DATABASE_NAME = "paysmart.db";

    // Table Names
    private static final String TABLE_UTILISATEUR = "utilisateur";
    private static final String TABLE_CATEGORIE = "categorie";
    private static final String TABLE_ARGENT_DONNE = "argent_donne";
    private static final String TABLE_ARGENT_DEPENSE = "argent_depense";

    // Common column names
    private static final String KEY_ID = "id";

    // NOTES Table - column names
    private static final String KEY_TODO = "todo";
    private static final String KEY_STATUS = "status";

    // TAGS Table - column names
    private static final String KEY_TAG_NAME = "tag_name";

    // NOTE_TAGS Table - column names
    private static final String KEY_TODO_ID = "todo_id";
    private static final String KEY_TAG_ID = "tag_id";

    // Table Create Statements
    // Utilisateur table create statement
    private static final String CREATE_TABLE_UTILISATEUR = "CREATE TABLE "
            + TABLE_UTILISATEUR + " (" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_TODO + " TEXT,"
            + KEY_STATUS + " INTEGER)";

    // Categorie table create statement
    private static final String CREATE_TABLE_CATEGORIE = "CREATE TABLE " + TABLE_CATEGORIE
            + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_TAG_NAME + " TEXT)";

    // Argent_Donne table create statement
    private static final String CREATE_TABLE_ARGENT_DONNE = "CREATE TABLE "
            + TABLE_ARGENT_DONNE + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_TODO_ID + " INTEGER," + KEY_TAG_ID + " INTEGER)";

    //Argent_depense table create statement
    private static final String CREATE_TABLE_ARGENT_DEPENSE = "CREATE TABLE "
            +TABLE_ARGENT_DEPENSE + "(" + KEY_ID + " INTEGER PRIMARY KEY)";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // creating required tables
        db.execSQL(CREATE_TABLE_UTILISATEUR);
        db.execSQL(CREATE_TABLE_CATEGORIE);
        db.execSQL(CREATE_TABLE_ARGENT_DONNE);
        db.execSQL(CREATE_TABLE_ARGENT_DEPENSE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_UTILISATEUR);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CATEGORIE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ARGENT_DONNE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ARGENT_DEPENSE );

        // create new tables
        onCreate(db);
    }
}