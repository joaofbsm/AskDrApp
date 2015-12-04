package com.example.joaofbsm.assignment1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Makes the TextView Clickable
        TextView signup = (TextView) findViewById(R.id.link_signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                startActivity(intent);
            }
        });
    }

    // Check if the user information is correct and then redirects him to the database
    public void onClickLogin(View view) {
        EditText emailInput = (EditText) findViewById(R.id.input_email);
        EditText passwordInput = (EditText) findViewById(R.id.input_password);

        String email = emailInput.getText().toString();
        String password = passwordInput.getText().toString();

        for(Member m : Member.members) {
            // Checks if credentials are valid
            if((m.getEmail().equals(email)) && (m.getPassword().equals(password))) {
                Toast.makeText(getApplicationContext(), "Redirecting...",Toast.LENGTH_SHORT).show();

                // Save informations to SharedPreferences for post use
                SharedPreferences preferences = getSharedPreferences(getString(R.string.prefence_file_key), Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();

                editor.putString("user_name", m.getName());
                editor.putString("user_email", email);
                editor.putString("user_password", password);
                editor.commit();

                // Redirects to the main activity thus logging the user in, and finishes the current activity so the user can't get back here
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
                return;
            }
        }

        // If the credentials are not valid, uses Toast widget to show it on the screen
        Toast.makeText(getApplicationContext(), "Wrong Credentials",Toast.LENGTH_SHORT).show();
    }
}
