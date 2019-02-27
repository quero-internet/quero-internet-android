package br.edu.ifro.querointernet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

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
                SolicitacaoViabilidade solicitacao = (SolicitacaoViabilidade) getIntent().getSerializableExtra("etapa1");

                // Dados da etapa
                solicitacao.setDeUmAQuatroMB(switchDeUmAQuatroMB.isChecked());
                solicitacao.setDeCincoADezMB(switchDeCincoADezMB.isChecked());
                solicitacao.setDeDezACinquentaMB(switchDeDezACinquentaMB.isChecked());
                solicitacao.setAcimaDeCinquentaMB(switchAcimaDeCinquentaMB.isChecked());

                //Validação
                if(!(solicitacao.isDeUmAQuatroMB() || solicitacao.isDeCincoADezMB() || solicitacao.isDeDezACinquentaMB() ||  solicitacao.isAcimaDeCinquentaMB())){
                    Toast.makeText(FormularioEtapa2Activity.this, "Selecione ao menos uma quantidade de megas", Toast.LENGTH_SHORT).show();
                    return;
                }

                intent.putExtra("etapa2", solicitacao);
                startActivity(intent);
            }
        });
    }
}
