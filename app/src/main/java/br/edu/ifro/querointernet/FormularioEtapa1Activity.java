package br.edu.ifro.querointernet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import br.edu.ifro.querointernet.model.SolicitacaoViabilidade;

public class FormularioEtapa1Activity extends AppCompatActivity {

    private Button avancarBtnEtapa1;
    private Spinner spinnerTiposTecnologia;
    private Switch switchPlanoResidencial, switchPlanoEmpresarial, switchPlanoDedicado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_etapa_1);

        this.initializeComponents();
    }

    private void initializeComponents() {
        //Switches
        switchPlanoResidencial = findViewById(R.id.activity_formulario_etapa_1_plano_residencial);
        switchPlanoEmpresarial = findViewById(R.id.activity_formulario_etapa_1_plano_empresarial);
        switchPlanoDedicado = findViewById(R.id.activity_formulario_etapa_1_plano_dedicado);

        //Itens do Spinner
        String[] tiposTecnologia = {"Via rádio", "Fibra óptica", "ADSL", "Internet móvel", "Todas as tecnologias"};
        spinnerTiposTecnologia = findViewById(R.id.activity_formulario_etapa_1_tipos_tecnologia);

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tiposTecnologia);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTiposTecnologia.setAdapter(spinnerArrayAdapter);

        spinnerTiposTecnologia.setSelection(2);

        //Ação da botão avançar
        this.avancarBtnEtapa1 = findViewById(R.id.activity_formulario_etapa_1_avancar);

        this.avancarBtnEtapa1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FormularioEtapa1Activity.this, FormularioEtapa2Activity.class);
                SolicitacaoViabilidade solicitacao = new SolicitacaoViabilidade();
                solicitacao.setTipoTecnologia(spinnerTiposTecnologia.getSelectedItemPosition());
                solicitacao.setPlanoResidencial(switchPlanoResidencial.isChecked());
                solicitacao.setPlanoEmpresarial(switchPlanoEmpresarial.isChecked());
                solicitacao.setPlanoDedicado(switchPlanoDedicado.isChecked());

                intent.putExtra("etapa1", solicitacao);

                startActivity(intent);
            }
        });
    }
}
