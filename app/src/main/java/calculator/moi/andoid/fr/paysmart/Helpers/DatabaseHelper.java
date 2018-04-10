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

    // UTILISATEUR Table - column names
    private static final String EMAIL = "Email";
    private static final String NOM ="Nom";
    private static final String PRENOM = "Prenom";
    private static final String NOM_SOCIETE = "Nom_societe";
    private static final String VILLE = "Ville";
    private static final String CATEGORIE = "Categorie";
    private static final String MOT_DE_PASSE = "Mot_de_passe";
    private static final String CODE_PIN = "Code_PIN";
    private static final String RIB = "RIB";
    private static final String TELEPHONE = "Telephone";
    private static final String BUDGET_TOTAL = "Budget_total";

    // CATEGORIE Table - column names
    private static final String NOM_CATEGORIE = "Nom_categorie";

    // ARGENT_DONNE Table - column names
    private static final String EMAIL_RECEVEUR = "Email_receveur";
    private static final String EMAIL_DISTRIBUTEUR = "Email_distributeur";
    private static final String CATEGORIE_AUTORISEE = "Categorie_autorisee";
    private static final String SOMME = "Somme";

    // ARGENT_DEPENSE Table - column names
    private static final String EMAIL_UTILISATEUR = "Email_utilisateur";
    private static final String EMAIL_COMMERCE = "Email_commerce";
    private static final String JOUR = "Jategorie_autorisee";
    private static final String MONTANT = "Montant";

    // Table Create Statements
    // Utilisateur table create statement
    private static final String CREATE_TABLE_UTILISATEUR = "CREATE TABLE "
            + TABLE_UTILISATEUR + " (" + KEY_ID + " INTEGER PRIMARY KEY,"
            + EMAIL + " TEXT," + NOM + " TEXT," + PRENOM + "TEXT,"
            + NOM_SOCIETE + "TEXT," + VILLE + "TEXT," + CATEGORIE + "TEXT,"
            + MOT_DE_PASSE + "TEXT," + CODE_PIN + "INTEGER," + RIB + "INTEGER,"
            + TELEPHONE + "TEXT,"
            + BUDGET_TOTAL + "INTEGER)";

    // Categorie table create statement
    private static final String CREATE_TABLE_CATEGORIE = "CREATE TABLE " + TABLE_CATEGORIE
            + "(" + KEY_ID + " INTEGER PRIMARY KEY," + NOM_CATEGORIE + " TEXT)";

    // Argent_Donne table create statement
    private static final String CREATE_TABLE_ARGENT_DONNE = "CREATE TABLE "
            + TABLE_ARGENT_DONNE + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + EMAIL_RECEVEUR + " TEXT," + EMAIL_DISTRIBUTEUR + " TEXT)";

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