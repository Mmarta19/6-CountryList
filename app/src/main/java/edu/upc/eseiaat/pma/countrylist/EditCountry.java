package edu.upc.eseiaat.pma.countrylist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Marta on 20/10/17.
 */

public class EditCountry extends AppCompatActivity {

    private EditText edit_country;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_country);

        //(II)

        Intent intent = getIntent();
        String country_A = intent.getStringExtra("country");
        edit_country = (EditText)findViewById(R.id.edit_country);
        edit_country.setText(country_A);
    }

    public void saveCountry(View view) {
        // (III)
        String new_country=edit_country.getText().toString();
        Intent data = new Intent();
        data.putExtra("new_country", new_country);
        setResult(RESULT_OK, data);
        finish();
    }



}
