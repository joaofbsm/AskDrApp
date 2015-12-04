package com.example.joaofbsm.assignment1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class DiseaseActivity extends AppCompatActivity {

    public static final String EXTRA_DISEASE_NO = "diseaseNo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disease);

        int diseaseNo = (Integer) getIntent().getExtras().get(EXTRA_DISEASE_NO);
        Disease disease = Disease.diseases[diseaseNo];

        getSupportActionBar().setTitle(disease.getName());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView name = (TextView) findViewById(R.id.disease_name);
        TextView description = (TextView) findViewById(R.id.disease_description);
        TextView symptoms = (TextView) findViewById(R.id.disease_symptoms);
        TextView causes = (TextView) findViewById(R.id.disease_causes);

        name.setText(disease.getName());
        description.setText(disease.getDescription());
        symptoms.setText(disease.getSymptoms());
        causes.setText(disease.getCauses());
    }

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
