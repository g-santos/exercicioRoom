package com.example.exercicio.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.exercicio.R;
import com.example.exercicio.repository.LivroRepository;
import com.example.exercicio.vo.Livro;

public class NovoLivroActivity extends Activity {

    private EditText editTitulo;
    private EditText editAutor;
    private Spinner spinnerGenero;
    private EditText editQuantidadePaginas;
    private Spinner spinnerStatus;
    private CheckBox checkBoxFavorito;
    private LivroRepository repository;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_livro);

        editTitulo = findViewById(R.id.editTitulo);
        editAutor = findViewById(R.id.editAutor);
        spinnerGenero = findViewById(R.id.spinnerGenero);
        editQuantidadePaginas = findViewById(R.id.editQuantidadePaginas);
        spinnerStatus = findViewById(R.id.spinnerStatus);
        checkBoxFavorito = findViewById(R.id.checkBoxFavorito);
        repository = new LivroRepository(getApplicationContext());
    }

    public void salvarLivro(View view){
        Livro livro = new Livro();
        livro.setTitulo(editTitulo.getText().toString());
        livro.setAutor(editAutor.getText().toString());
        livro.setGenero(spinnerGenero.getSelectedItem().toString());
        livro.setQuantidadePaginas(Integer.parseInt(editQuantidadePaginas.getText().toString()));
        livro.setStatus(spinnerStatus.getSelectedItem().toString());

        if (checkBoxFavorito.isChecked()){
            livro.setFavorito(true);
        }
        else {
            livro.setFavorito(false);
        }

        repository.insert(livro);
        callMainActivity();
    }

    private void callMainActivity() {
        Intent mainActivity = new Intent(NovoLivroActivity.this,MainActivity.class);
        startActivity(mainActivity);
        finish();
    }
}
