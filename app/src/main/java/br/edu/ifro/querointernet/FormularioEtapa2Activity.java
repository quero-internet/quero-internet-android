package br.edu.ifro.querointernet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import br.edu.ifro.querointernet.model.SolicitacaoViabilidade;


public class FormularioEtapa2Activity extends AppCompatActivity {
    private Switch switchDeUmAQuatroMB,switchDeCincoADezMB,switchDeDezACinquentaMB,switchAcimaDeCinquentaMB;
    private Button avancarBtnEtapa3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_etapa_2);

        this.initializeComponents();
    }

    private void initializeComponents() {
        //Definindo switches
        switchDeUmAQuatroMB = findViewById(R.id.activity_formulario_etapa_2_opcao_1);
        switchDeCincoADezMB = findViewById(R.id.activity_formulario_etapa_2_opcao_2);
        switchDeDezACinquentaMB = findViewById(R.id.activity_formulario_etapa_2_opcao_3);
        switchAcimaDeCinquentaMB = findViewById(R.id.activity_formulario_etapa_2_opcao_4);

        avancarBtnEtapa3 = findViewById(R.id.activity_formulario_etapa_2_avancar);

        avancarBtnEtapa3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FormularioEtapa2Activity.this, FormularioEtapa3Activity.class);
                SolicitacaoViabilidade solicitacaoViabilidade = (SolicitacaoViabilidade) getIntent().getSerializableExtra("etapa1");

                solicitacaoViabilidade.setDeUmAQuatroMB(switchDeUmAQuatroMB.isChecked());
                solicitacaoViabilidade.setDeCincoADezMB(switchDeCincoADezMB.isChecked());
                solicitacaoViabilidade.setDeDezACinquentaMB(switchDeDezACinquentaMB.isChecked());
                solicitacaoViabilidade.setAcimaDeCinquentaMB(switchAcimaDeCinquentaMB.isChecked());

                intent.putExtra("etapa2", solicitacaoViabilidade);
                startActivity(intent);
            }
        });
    }
}
