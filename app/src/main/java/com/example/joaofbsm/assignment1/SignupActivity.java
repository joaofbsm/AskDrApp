package com.example.joaofbsm.assignment1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Gives the user the opportunity to create an account to login on the app
 */
public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // Makes the TextView Clickable
        TextView login = (TextView) findViewById(R.id.link_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    // Adds the given information to the database and thus creates a new registered user
    public void onClickSignup(View view) {
        EditText name = (EditText) findViewById(R.id.input_name);
        EditText email = (EditText) findViewById(R.id.input_email);
        EditText password = (EditText) findViewById(R.id.input_password);

        // Error check for empty name
        if(name.getText().length() < 1) {
            Toast.makeText(getApplicationContext(), "Name can't be empty", Toast.LENGTH_SHORT).show();
            return;
        }

        // Error check for invalid email
        for(Member m : Member.members) {
            if(email.getText().toString().equals(m.getEmail())) {
                Toast.makeText(getApplicationContext(), "Email already registered", Toast.LENGTH_SHORT).show();
                return;
            }
        }

        // Error check for not long enough password
        if(password.getText().length() < 6) {
            Toast.makeText(getApplicationContext(), "Password needs to be longer", Toast.LENGTH_SHORT).show();
            return;
        }

        // Add new member if everything is ok
        Member.members.add(new Member(name.getText().toString(), email.getText().toString(), password.getText().toString()));

        // Calls back the login activity
        finish();
    }
}
