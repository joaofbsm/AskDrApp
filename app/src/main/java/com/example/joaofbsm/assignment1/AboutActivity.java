package com.example.joaofbsm.assignment1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

/**
 * Called when the About option is chosen in the Toolbar menu
 */
public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        // Draw a clickable arrow pointing backwards on the ActionBar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
