package com.example.exercicio.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

import com.example.exercicio.R;
import com.example.exercicio.vo.Livro;

public class LivroAdapter extends ArrayAdapter<Livro> {
    private int rId;

    public LivroAdapter(@NonNull Context context, int resource, @NonNull List<Livro> objects) {
        super(context, resource, objects);
        rId = resource;
    }

    @Override
    public View getView(int position, View currentView, ViewGroup parent){
        View mView = currentView;

        if(mView == null){
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mView = inflater.inflate(rId,null);
        }

        Livro livro = getItem(position);

        TextView textTitulo = mView.findViewById(R.id.textNomeLivro);
        TextView textAutor = mView.findViewById(R.id.textAutorLivro);
        TextView textGenero = mView.findViewById(R.id.textGeneroLivro);
        TextView textQuantidadePaginas = mView.findViewById(R.id.textQuantidadePaginas);
        TextView textStatus = mView.findViewById(R.id.textStatus);
        TextView textFavorito = mView.findViewById(R.id.textFavorito);

        textTitulo.setText(livro.getTitulo().toUpperCase());
        textTitulo.setText(livro.getAutor().toUpperCase());
        textGenero.setText(livro.getGenero());
        textQuantidadePaginas.setText("Qto pag.: " + String.valueOf(livro.getQuantidadePaginas()));
        textGenero.setText(livro.getStatus());

        if (livro.getFavorito()){
            textFavorito.setText("S");
        }
        else {
            textFavorito.setText("N");
        }

        return mView;
    }
}
