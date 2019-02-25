package br.edu.ifro.querointernet;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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

        this.twitterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, TwitterLoginActivity.class);
                startActivity(intent);
            }
        });

        this.googlePlusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, GooglePlusActivity.class);
                startActivity(intent);
            }
        });

        this.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextInputEditText tLogin = (TextInputEditText) findViewById(R.id.formulario_login_usuario);
                TextInputEditText tSenha = (TextInputEditText) findViewById(R.id.formulario_login_senha);

                String login = tLogin.getText().toString();
                String senha = tSenha.getText().toString();

                if (login.equals("japa")&& senha.equals("123")){
                    alert("Login realizado com sucesso");
                    Intent intent = new Intent(LoginActivity.this, FormularioEtapa1Activity.class);
                    startActivity(intent);


                }else{
                    alert("Login incorreto");

                }
            }
        });
    }


    private void initializeComponents() {
        this.facebookBtn = findViewById(R.id.formulario_login_facebook_button);
        this.twitterBtn = findViewById(R.id.formulario_login_twitter_button);
        this.googlePlusBtn = findViewById(R.id.formulario_login_google_plus_button);
        this.loginBtn = findViewById(R.id.formulario_login_login_button);
    }

    private void alert (String s){
        Toast.makeText(this,s, Toast.LENGTH_LONG).show();
    }
}
