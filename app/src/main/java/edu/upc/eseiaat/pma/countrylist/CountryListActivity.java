package edu.upc.eseiaat.pma.countrylist;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class CountryListActivity extends AppCompatActivity {

    private ArrayList<String> country_list;
    private ArrayAdapter<String> adapter;
    private String country;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_list);

        String[] countries = getResources().getStringArray((R.array.countries));
        country_list = new ArrayList<>(Arrays.asList(countries));

        ListView list = (ListView) findViewById(R.id.country_list);

        //Todos los ListView tienen un adaptador --> hace intermediario de la "Escalera Mecanica"
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, country_list);
        // 1. contexto: puntero a l'actividad. 2. Layout de cada pastillita ( cada item de la lista  para que tengan el mismo tamaño. 3. Datos
        list.setAdapter(adapter);
        //Cuando se clica en un Item de la lista
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View item, int pos, long id) {
                Toast.makeText(
                        CountryListActivity.this,
                        String.format("Has escogido '%s'", country_list.get(pos)),
                        Toast.LENGTH_SHORT
                ).show();

                country = country_list.get(pos);
                editCountry(item,country);

            }
        });

        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View item, final int pos, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(CountryListActivity.this);
                builder.setTitle(R.string.confirm);
                String msg = getResources().getString(R.string.confirm_message);

                builder.setMessage(msg + " " + country_list.get(pos) + "?");
                builder.setPositiveButton(R.string.erase, new DialogInterface.OnClickListener() { // Ha dicho que sí
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        country_list.remove(pos);
                        adapter.notifyDataSetChanged(); // notificación que han cambiado los datos.
                    }
                });

                builder.setNegativeButton(android.R.string.cancel, null); // no hay que hacer nada, pues pongo Null
                builder.create().show();

                return true; // no hagas el Click, porque el LongClick ha ocurrido. Para que no se hagan los dos.
            }
        });
    }

    public void editCountry(View view,String country) {

        //  (I)
        Intent intent = new Intent(this, EditCountry.class);
        intent.putExtra("country", country);
        startActivityForResult(intent, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        switch(requestCode){
            //(IV)
            case 0:
                if(resultCode == AppCompatActivity.RESULT_OK){
                    //country_list = data.getStringExtra("country");
                    //title_text.setText(title);
                }
        }


    }


}








