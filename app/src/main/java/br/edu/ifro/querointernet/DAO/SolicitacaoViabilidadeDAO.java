package br.edu.ifro.querointernet.DAO;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifro.querointernet.model.Endereco;
import br.edu.ifro.querointernet.model.SolicitacaoViabilidade;

public class SolicitacaoViabilidadeDAO extends SQLiteOpenHelper {

    private final String TABLE_NAME = "SOLICITACAO_VIABILIDADE";

    public SolicitacaoViabilidadeDAO(Context context) {
        super(context, "Quero internet", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table " +
                TABLE_NAME +
                " (id integer primary key, " +
                " tipoTecnologia integer not null," +
                " planoResidencial integer not null default 0," +
                " planoEmpresarial integer not null default 0," +
                " planoDedicado integer not null default 0," +
                " deUmAQuatroMB integer not null default 0," +
                " deCincoADezMB integer not null default 0," +
                " deDezACinquentaMB integer not null default 0," +
                " acimaDeCinquentaMB integer not null default 0," +
                " cep text," +
                " logradouro text not null," +
                " numero text not null," +
                " complemento text," +
                " bairro text not null," +
                " localidade text not null," +
                " uf text not null)";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void inserir(SolicitacaoViabilidade solicitacaoViabilidade){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = new ContentValues();

        dados.put("tipoTecnologia", solicitacaoViabilidade.getTipoTecnologia());
        dados.put("planoResidencial", solicitacaoViabilidade.isPlanoResidencial() ? 1 : 0);
        dados.put("planoEmpresarial", solicitacaoViabilidade.isPlanoEmpresarial() ? 1 : 0);
        dados.put("planoDedicado", solicitacaoViabilidade.isPlanoDedicado() ? 1 : 0);
        dados.put("deUmAQuatroMB", solicitacaoViabilidade.isDeUmAQuatroMB() ? 1 : 0);
        dados.put("deCincoADezMB", solicitacaoViabilidade.isDeCincoADezMB() ? 1 : 0);
        dados.put("deDezACinquentaMB", solicitacaoViabilidade.isDeDezACinquentaMB() ? 1 : 0);
        dados.put("acimaDeCinquentaMB", solicitacaoViabilidade.isAcimaDeCinquentaMB() ? 1 : 0);
        dados.put("cep", solicitacaoViabilidade.getEndereco().getCep());
        dados.put("logradouro", solicitacaoViabilidade.getEndereco().getLogradouro());
        dados.put("numero", solicitacaoViabilidade.getEndereco().getNumero());
        dados.put("complemento", solicitacaoViabilidade.getEndereco().getComplemento());
        dados.put("bairro", solicitacaoViabilidade.getEndereco().getBairro());
        dados.put("localidade", solicitacaoViabilidade.getEndereco().getLocalidade());
        dados.put("uf", solicitacaoViabilidade.getEndereco().getUf());

        db.insert(TABLE_NAME, null, dados);
    }
    public List<SolicitacaoViabilidade> listar(){

        String sql = "select * from " + TABLE_NAME;
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql, null);

        List<SolicitacaoViabilidade> lista = new ArrayList<SolicitacaoViabilidade>();

        while(c.moveToNext()){
            SolicitacaoViabilidade solicitacaoViabilidade = new SolicitacaoViabilidade();
            Endereco endereco = new Endereco();

            solicitacaoViabilidade.setId(c.getInt(c.getColumnIndex("id")));
            solicitacaoViabilidade.setTipoTecnologia(c.getInt(c.getColumnIndex("tipoTecnologia")));
            solicitacaoViabilidade.setPlanoResidencial(c.getInt(c.getColumnIndex("planoResidencial")) == 1 ? true : false);
            solicitacaoViabilidade.setPlanoEmpresarial(c.getInt(c.getColumnIndex("planoEmpresarial")) == 1 ? true : false);
            solicitacaoViabilidade.setPlanoDedicado(c.getInt(c.getColumnIndex("planoDedicado")) == 1 ? true : false);
            solicitacaoViabilidade.setDeUmAQuatroMB(c.getInt(c.getColumnIndex("deUmAQuatroMB")) == 1 ? true : false);
            solicitacaoViabilidade.setDeCincoADezMB(c.getInt(c.getColumnIndex("deCincoADezMB")) == 1 ? true : false);
            solicitacaoViabilidade.setDeDezACinquentaMB(c.getInt(c.getColumnIndex("deDezACinquentaMB")) == 1 ? true : false);
            solicitacaoViabilidade.setAcimaDeCinquentaMB(c.getInt(c.getColumnIndex("acimaDeCinquentaMB")) == 1 ? true : false);
            //Preenchendo endereços
            endereco.setCep(c.getString(c.getColumnIndex("cep")));
            endereco.setLogradouro(c.getString(c.getColumnIndex("logradouro")));
            endereco.setNumero(c.getString(c.getColumnIndex("numero")));
            endereco.setComplemento(c.getString(c.getColumnIndex("complemento")));
            endereco.setBairro(c.getString(c.getColumnIndex("bairro")));
            endereco.setLocalidade(c.getString(c.getColumnIndex("localidade")));
            endereco.setUf(c.getString(c.getColumnIndex("uf")));

            solicitacaoViabilidade.setEndereco(endereco);
            lista.add(solicitacaoViabilidade);
        }
        return lista;
    }

    public void remover(int id) {
        SQLiteDatabase db = getWritableDatabase();

        db.delete(TABLE_NAME, "id = ?", new String[]{String.valueOf(id)});
    }

    public void alterar(SolicitacaoViabilidade solicitacaoViabilidade) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = new ContentValues();

        dados.put("id", solicitacaoViabilidade.getId());
        dados.put("tipoTecnologia", solicitacaoViabilidade.getTipoTecnologia());
        dados.put("planoResidencial", solicitacaoViabilidade.isPlanoResidencial());
        dados.put("planoEmpresarial", solicitacaoViabilidade.isPlanoEmpresarial());
        dados.put("planoDedicado", solicitacaoViabilidade.isPlanoDedicado());
        dados.put("deUmAQuatroMB", solicitacaoViabilidade.isDeUmAQuatroMB());
        dados.put("deCincoADezMB", solicitacaoViabilidade.isDeCincoADezMB());
        dados.put("deDezACinquentaMB", solicitacaoViabilidade.isDeDezACinquentaMB());
        dados.put("acimaDeCinquentaMB", solicitacaoViabilidade.isAcimaDeCinquentaMB());
        dados.put("cep", solicitacaoViabilidade.getEndereco().getCep());
        dados.put("logradouro", solicitacaoViabilidade.getEndereco().getLogradouro());
        dados.put("numero", solicitacaoViabilidade.getEndereco().getNumero());
        dados.put("complemento", solicitacaoViabilidade.getEndereco().getComplemento());
        dados.put("bairro", solicitacaoViabilidade.getEndereco().getBairro());
        dados.put("localidade", solicitacaoViabilidade.getEndereco().getLocalidade());
        dados.put("uf", solicitacaoViabilidade.getEndereco().getUf());

        db.update(TABLE_NAME, dados, "id = ?", new String[]{String.valueOf(solicitacaoViabilidade.getId())});
    }
}
