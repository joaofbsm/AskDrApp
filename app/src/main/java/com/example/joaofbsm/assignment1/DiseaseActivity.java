package com.example.joaofbsm.assignment1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * * Contains the layout that will receive the information about the disease and show it up, formatted, on the screen
 */
public class DiseaseActivity extends AppCompatActivity {

    // Used on the intent to get the index of the selected item
    public static final String EXTRA_DISEASE_NO = "diseaseNo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disease);

        // Get index of the selected option
        int diseaseNo = (Integer) getIntent().getExtras().get(EXTRA_DISEASE_NO);
        // Get the correspondent disease on the "database"
        Disease disease = Disease.diseases[diseaseNo];

        // Set the title of the screen to the name of the disease
        getSupportActionBar().setTitle(disease.getName());
        // Draw a clickable arrow pointing backwards on the ActionBar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Gets the ids of the TextViews and add the information to the layout
        TextView name = (TextView) findViewById(R.id.disease_name);
        TextView description = (TextView) findViewById(R.id.disease_description);
        TextView symptoms = (TextView) findViewById(R.id.disease_symptoms);
        TextView causes = (TextView) findViewById(R.id.disease_causes);

        name.setText(disease.getName());
        description.setText(disease.getDescription());
        symptoms.setText(disease.getSymptoms());
        causes.setText(disease.getCauses());
    }

    // When the ActionBar arrow is clicked, get back to previous screen
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
