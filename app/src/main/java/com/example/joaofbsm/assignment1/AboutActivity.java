package com.example.joaofbsm.assignment1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.MenuItem;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView appdev = (TextView) findViewById((R.id.text_appDeveloper));
        final SpannableStringBuilder sb1 = new SpannableStringBuilder(getString(R.string.appDeveloper));
        final StyleSpan bss = new StyleSpan(android.graphics.Typeface.BOLD);
        sb1.setSpan(bss, 0, 13, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        appdev.setText(sb1);

        TextView contactEmail = (TextView) findViewById((R.id.text_contactEmail));
        final SpannableStringBuilder sb2 = new SpannableStringBuilder(getString(R.string.contactEmail));
        sb2.setSpan(bss, 0, 14, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        contactEmail.setText(sb2);
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
