package com.example.imageapptest.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.imageapptest.model.Word;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Word.class}, version = 2)
@TypeConverters({Word.DefinitionConverter.class})
public abstract class WordDatabase extends RoomDatabase {
    public abstract WordDao wordDao();

    private static volatile WordDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static WordDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (WordDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            WordDatabase.class, "word_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
