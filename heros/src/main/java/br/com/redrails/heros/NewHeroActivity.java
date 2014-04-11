package br.com.redrails.heros;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;


public class NewHeroActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_hero);


        Button saveButton = (Button) findViewById(R.id.hero_save_button);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText heroName = (EditText) findViewById(R.id.hero_name);
                EditText heroFavSkill = (EditText) findViewById(R.id.hero_favorite_skill);
                EditText heroUltimate = (EditText) findViewById(R.id.hero_ultimate_skill);
                RatingBar heroRating = (RatingBar) findViewById(R.id.hero_rating);

                final Hero hero = new Hero();
                hero.setName(heroName.getText().toString());
                hero.setFavoriteSkill(heroFavSkill.getText().toString());
                hero.setUltimateSkill(heroUltimate.getText().toString());
                hero.setRating((double) heroRating.getRating());

                HeroDAO heroDao = new HeroDAO(NewHeroActivity.this);
                heroDao.salvarHero(hero);
                finish();
            }
        });


    }


}
