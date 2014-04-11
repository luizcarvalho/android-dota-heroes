package br.com.redrails.heros;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class MainActivity extends ActionBarActivity {


    private AdapterView listaHerosView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        listaHerosView = (ListView) findViewById(R.id.lista_heros);
        listaHerosView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String mensagem = "Você escolheu " + ((TextView) view).getText() + " como heroi, na posição: " + position;
                Toast.makeText(MainActivity.this, mensagem, Toast.LENGTH_SHORT).show();
            }
        });

        listaHerosView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                String mensagem = "Você escolheu " + parent.getItemAtPosition(position) + " como seu heroi favorito";
                Toast.makeText(MainActivity.this, mensagem, Toast.LENGTH_SHORT).show();
                return true;
            }
        });


    }

    @Override
    protected void onResume() {
        HeroDAO heroDao = new HeroDAO(this);
        List<Hero> listHeros = heroDao.getHeros();
        int layout = android.R.layout.simple_list_item_1;
        ArrayAdapter<Hero> heroAdapter = new ArrayAdapter<Hero>(this,layout,listHeros);
        listaHerosView.setAdapter(heroAdapter);
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_manu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        switch (item.getItemId()){
            case R.id.action_new_hero:
                Intent newHeroIntent = new Intent(this,NewHeroActivity.class);
                startActivity(newHeroIntent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }




}
