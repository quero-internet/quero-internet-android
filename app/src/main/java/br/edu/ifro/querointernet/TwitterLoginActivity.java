package br.edu.ifro.querointernet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TwitterLoginActivity extends AppCompatActivity {

    private Button twitterButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twitter_login);
        this.initializeComponents();
    }

    private void initializeComponents() {
        twitterButton = findViewById(R.id.activity_twitter_login_button);

        twitterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TwitterLoginActivity.this, FormularioEtapa1Activity.class));
            }
        });
    }
}
