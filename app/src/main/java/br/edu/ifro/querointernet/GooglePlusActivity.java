package br.edu.ifro.querointernet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GooglePlusActivity extends AppCompatActivity {

    private Button googlePlusButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_plus);
        this.initializeComponents();
    }

    private void initializeComponents() {
        googlePlusButton = findViewById(R.id.activity_google_plus_login_button);

        googlePlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GooglePlusActivity.this, FormularioEtapa1Activity.class));
            }
        });
    }
}
