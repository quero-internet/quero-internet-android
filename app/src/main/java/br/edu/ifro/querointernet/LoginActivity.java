package br.edu.ifro.querointernet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.sql.Date;

public class LoginActivity extends AppCompatActivity {

    Button facebookBtn, twitterBtn, googlePlusBtn, loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.initializeComponents();

        this.facebookBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, FacebookLoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initializeComponents() {
        this.facebookBtn = findViewById(R.id.formulario_login_facebook_button);
        this.twitterBtn = findViewById(R.id.formulario_login_twitter_button);
        this.googlePlusBtn = findViewById(R.id.formulario_login_google_plus_button);
        this.loginBtn = findViewById(R.id.formulario_login_login_button);
    }
}
