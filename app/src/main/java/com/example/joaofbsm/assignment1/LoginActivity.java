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

    SharedPreferences preferences = null;
    SharedPreferences.Editor editor = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView signup = (TextView) findViewById(R.id.link_signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();

        preferences = getSharedPreferences(getString(R.string.prefence_file_key), Context.MODE_PRIVATE);
        editor = preferences.edit();
        if(preferences.getString("email", null) != null && preferences.getString("password", null) != null) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    public void onClickLogin(View view) {
        EditText emailInput = (EditText) findViewById(R.id.input_email);
        EditText passwordInput = (EditText) findViewById(R.id.input_password);

        String email = emailInput.getText().toString();
        String password = passwordInput.getText().toString();

        for(Member m : Member.members) {
            if((m.getEmail().equals(email)) && (m.getPassword().equals(password))) {
                Toast.makeText(getApplicationContext(), "Redirecting...",Toast.LENGTH_SHORT).show();

                preferences = getSharedPreferences(getString(R.string.prefence_file_key), Context.MODE_PRIVATE);
                editor = preferences.edit();
                editor.putString("email", email);
                editor.putString("password", password);
                editor.commit();

                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
                return;
            }
        }

        Toast.makeText(getApplicationContext(), "Wrong Credentials",Toast.LENGTH_SHORT).show();

    }

    /**
     * TODO
     *
     * - Login/Signup Error
     * - Settings menu
     * - First Login
     *
     */

}
