package br.com.redrails.heros;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Criado por luiz em 10/04/14.
 * Todos os direitos reservados para RedRails
 */


public class HeroDAO extends SQLiteOpenHelper {
    private static final String databaseName = "dota.db";
    private static final int version = 1;
    private List<Hero> heros;

    public HeroDAO(Context context) {
        super(context, databaseName, null, version);

    }

    public void salvarHero(Hero hero){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("name",hero.getName());
        valores.put("favorite_skill", hero.getFavoriteSkill());
        valores.put("ultimate_skill", hero.getUltimateSkill());
        valores.put("rating",hero.getRating());

        db.insert("heros",null, valores);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE heros (_id PRIMARY KEY," +
                "name TEXT, favorite_skill TEXT, " +
                "ultimate_skill TEXT, rating REAL);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST heros;");
        this.onCreate(db);
    }

    public List<Hero> getHeros() {
        String[] campos = {"_id", "name","favorite_skill", "ultimate_skill", "rating"};
                            //0   //1   //2 ...
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query("heros", campos, null, null, null, null, null);
        ArrayList<Hero> heros = new ArrayList<Hero>();

        while (cursor.moveToNext()){
            Hero hero = new Hero();
            hero.setId(cursor.getLong(0));
            hero.setName(cursor.getString(1));
            hero.setFavoriteSkill(cursor.getString(2));
            hero.setUltimateSkill(cursor.getString(3));
            hero.setRating(cursor.getDouble(4));
            heros.add(hero);
        }

        return heros;
    }
}
