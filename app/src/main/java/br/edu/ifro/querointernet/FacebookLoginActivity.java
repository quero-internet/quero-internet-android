package br.edu.ifro.querointernet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FacebookLoginActivity extends AppCompatActivity {
    private Button facebookButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook_login);

        this.initializeComponents();
    }

    private void initializeComponents() {
        facebookButton = findViewById(R.id.activity_facebook_login_button);

        facebookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FacebookLoginActivity.this, FormularioEtapa1Activity.class));
            }
        });
    }
}
