package br.edu.ifro.querointernet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;
import java.util.concurrent.ExecutionException;

import br.edu.ifro.querointernet.DAO.SolicitacaoViabilidadeDAO;
import br.edu.ifro.querointernet.model.Endereco;
import br.edu.ifro.querointernet.model.SolicitacaoViabilidade;
import br.edu.ifro.querointernet.service.HttpService;

public class FormularioEtapa3Activity extends AppCompatActivity {

    private EditText cepField, logradouroField, complementoField, bairroField, cidadeField, ufField, numeroField;
    private Button btnBuscarCep, btnSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_etapa_3);

        this.initializeComponents();




        btnBuscarCep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Endereco retorno = new HttpService(cepField.getText().toString()).execute().get();

                    if(retorno == null){
                        return;
                    }

                    logradouroField.setText(retorno.getLogradouro());
                    complementoField.setText(retorno.getComplemento());
                    bairroField.setText(retorno.getBairro());
                    cidadeField.setText(retorno.getLocalidade());
                    ufField.setText(retorno.getUf());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Toast.makeText(FormularioEtapa3Activity.this, "Não foi possível localizar o endereço", Toast.LENGTH_SHORT).show();
                } catch (ExecutionException e) {
                    Toast.makeText(FormularioEtapa3Activity.this, "Não foi possível localizar o endereço", Toast.LENGTH_SHORT).show();

                    e.printStackTrace();
                }
            }
        }



        );

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FormularioEtapa3Activity.this,FormularioConfirmacaoActivity.class);
                SolicitacaoViabilidade solicitacaoViabilidade = (SolicitacaoViabilidade) getIntent().getSerializableExtra("etapa2");
                Endereco endereco = new Endereco();
                SolicitacaoViabilidadeDAO dao = new SolicitacaoViabilidadeDAO(FormularioEtapa3Activity.this);

                endereco.setCep(cepField.getText().toString().trim());
                endereco.setUf(ufField.getText().toString().trim());
                endereco.setLocalidade(cidadeField.getText().toString().trim());
                endereco.setBairro(bairroField.getText().toString().trim());
                endereco.setLogradouro(logradouroField.getText().toString().trim());
                endereco.setComplemento(complementoField.getText().toString().trim());
                endereco.setNumero(numeroField.getText().toString().trim());

                solicitacaoViabilidade.setEndereco(endereco);

                dao.inserir(solicitacaoViabilidade);

                List<SolicitacaoViabilidade> lista = dao.listar();

                for (SolicitacaoViabilidade obj : lista){
                    Toast.makeText(FormularioEtapa3Activity.this, obj.toString(), Toast.LENGTH_SHORT).show();
                }

                startActivity(intent);

            }
        }

        );

    }

    private void initializeComponents() {
        cepField = findViewById(R.id.activity_formulario_etapa_4_cep);
        logradouroField = findViewById(R.id.activity_formulario_etapa_4_logradouro);
        bairroField = findViewById(R.id.activity_formulario_etapa_4_bairro);
        numeroField = findViewById(R.id.activity_formulario_etapa_4_numero);
        ufField = findViewById(R.id.activity_formulario_etapa_4_uf);
        cidadeField = findViewById(R.id.activity_formulario_etapa_4_cidade);
        complementoField = findViewById(R.id.activity_formulario_etapa_4_complemento);

        btnBuscarCep = findViewById(R.id.activity_formulario_etapa_4_buscarCep);
        btnSalvar = findViewById(R.id.activity_formulario_etapa_4_salvar);
    }
}
