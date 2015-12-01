package com.example.joaofbsm.assignment1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    SharedPreferences preferences = null;
    SharedPreferences.Editor editor = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        preferences = getSharedPreferences("user_preferences", MODE_PRIVATE);

        TextView signup = (TextView) findViewById(R.id.link_signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                startActivity(intent);
            }
        });


       // Intent intent = new Intent(this, MainActivity.class);
       // startActivity(intent);
       // finish();
    }

    @Override
    public void onResume() {
        super.onResume();

        if(preferences.getBoolean("firstrun", true)) {
            editor = preferences.edit();
            editor.putBoolean("firstrun", false);
            editor.commit();
        }
    }

    public void onClickLogin(View view) {
        EditText email = (EditText) findViewById(R.id.input_email);
        EditText password = (EditText) findViewById(R.id.input_password);

        for(Member m : Member.members) {
            if((m.getEmail().equals(email.getText().toString())) && (m.getPassword().equals(password.getText().toString()))) {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }

        // TODO - LOGIN ERROR




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
