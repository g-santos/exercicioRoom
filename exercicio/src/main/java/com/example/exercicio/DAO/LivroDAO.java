package com.example.exercicio.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import com.example.exercicio.vo.Livro;

@Dao
public interface LivroDAO {

    @Insert
    void insert(Livro livro);

    // Caso coloque no lugar do void long, devolve o ultimo ID criado.
    // isso é importante para validação.

    @Query("DELETE FROM livro_table where livro_table.ID == :id")
    void delete(long id);

    // :id, o ":" indica que irá receber uma variavél para realizar a querry.

    @Query("SELECT * from livro_table where favorito = 1")
    List<Livro> loadLivros();
}
