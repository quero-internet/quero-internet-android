package br.edu.ifro.querointernet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FormularioConfirmacaoActivity extends AppCompatActivity {

    private Button btnMinhasSolicitacoes, btnNossosParceiros;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_confirmacao);

        this.initializeComponents();
        this.configurarButtons();

    }

    private void configurarButtons() {
        this.btnMinhasSolicitacoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FormularioConfirmacaoActivity.this, ListaSolicitacoesActivity.class));
            }
        });
        
        this.btnNossosParceiros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FormularioConfirmacaoActivity.this, "Nossos parceiros são demais!!", Toast.LENGTH_LONG).show();
                startActivity(new Intent(FormularioConfirmacaoActivity.this,ParceitosActivity.class));
            }
        });
    }

    private void initializeComponents() {
        this.btnMinhasSolicitacoes = findViewById(R.id.formulario_confirmacao_minhas_solicitacoes);
        this.btnNossosParceiros = findViewById(R.id.formulario_confirmacao_verificar_parceiros);
    }
}
