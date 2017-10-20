package edu.upc.eseiaat.pma.countrylist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Marta on 20/10/17.
 */

public class EditCountry extends AppCompatActivity {

    private TextView edit_country;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_country);

        //(II)
        // cridem l'intent del Titleactivity
        Intent intent = getIntent();
        // Agafem el valor que té title a l'altre activitat
        String title = intent.getStringExtra("country");
        edit_country = (EditText)findViewById(R.id.edit_country);
        // li posem al edit Text d'aquesta acitivat
        edit_country.setText(title);
    }




}
