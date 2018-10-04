package com.example.exercicio.repository;

import android.content.Context;
import android.os.AsyncTask;

import java.util.List;

import com.example.exercicio.DAO.LivroDAO;
import com.example.exercicio.database.LivroRoomDatabase;
import com.example.exercicio.vo.Livro;

public class LivroRepository {
    private LivroDAO mLivroDAO;
    private List<Livro> mLivros;

    public LivroRepository(Context context){
        LivroRoomDatabase db = LivroRoomDatabase.getDatabase(context);
        mLivroDAO = db.livroDAO();
        mLivros = mLivroDAO.loadLivros();
    }

    public List<Livro> getAllLivros(){
        return mLivros;
    }

    public void insert(Livro livro){
        new insertAsyncTask(mLivroDAO).execute(livro);
    }

    private static class insertAsyncTask extends AsyncTask<Livro,Void,Void> {

        private LivroDAO mAsyncTaskDAO;

        insertAsyncTask(LivroDAO dao){
            mAsyncTaskDAO = dao;
        }

        @Override
        protected Void doInBackground(final Livro... params){
            mAsyncTaskDAO.insert(params[0]);
            return null;
        }
    }
}
