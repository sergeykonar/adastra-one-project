package com.example.imageapptest.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.imageapptest.model.Word;

import java.util.List;

@Dao
public interface WordDao {

    @Insert
    void insert(Word word);

    @Query("SELECT * FROM Word")
    List<Word> getAll();

    @Query("DELETE FROM Word")
    void deleteAll();
}
