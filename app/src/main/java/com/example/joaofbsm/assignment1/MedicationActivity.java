package com.example.joaofbsm.assignment1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * Contains the layout that will receive the information about the medication and show it up, formatted, on the screen
 */
public class MedicationActivity extends AppCompatActivity {

    // Used on the intent to get the index of the selected item
    public static final String EXTRA_MEDICATION_NO = "medicationNo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medication);

        // Get index of the selected option
        int medicationNo = (Integer) getIntent().getExtras().get(EXTRA_MEDICATION_NO);
        // Get the correspondent medication on the "database"
        Medication med = Medication.medications[medicationNo];

        // Set the title of the screen to the name of the medication
        getSupportActionBar().setTitle(med.getName());
        // Draw a clickable arrow pointing backwards on the ActionBar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Gets the ids of the TextViews and add the information to the layout
        TextView name = (TextView) findViewById(R.id.medication_name);
        TextView info = (TextView) findViewById(R.id.medication_info);
        TextView howToUse = (TextView) findViewById(R.id.medication_howtouse);
        TextView sideEffects = (TextView) findViewById(R.id.medication_sideeffects);

        name.setText(med.getName());
        info.setText(med.getInformation());
        howToUse.setText(med.getHowToUse());
        sideEffects.setText(med.getSideEffects());
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
