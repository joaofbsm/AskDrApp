package com.example.joaofbsm.assignment1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class MedicationActivity extends AppCompatActivity {

    public static final String EXTRA_MEDICATION_NO = "medicationNo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medication);

        int medicationNo = (Integer) getIntent().getExtras().get(EXTRA_MEDICATION_NO);
        Medication med = Medication.medications[medicationNo];

        getSupportActionBar().setTitle(med.getName());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView name = (TextView) findViewById(R.id.medication_name);
        TextView info = (TextView) findViewById(R.id.medication_info);
        TextView howToUse = (TextView) findViewById(R.id.medication_howtouse);
        TextView sideEffects = (TextView) findViewById(R.id.medication_sideeffects);

        name.setText(med.getName());
        info.setText(med.getInformation());
        howToUse.setText(med.getHowToUse());
        sideEffects.setText(med.getSideEffects());
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
