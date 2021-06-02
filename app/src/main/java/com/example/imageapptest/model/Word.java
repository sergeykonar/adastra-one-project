package com.example.imageapptest.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

@Entity
@TypeConverters({Word.DefinitionConverter.class})
public class Word {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @SerializedName("word")
    @Expose
    private String word;
    @SerializedName("definitions")
    @Expose
    private List<Definition> definitions;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public List<Definition> getDefinitions() {
        return definitions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDefinitions(List<Definition> definitions) {
        this.definitions = definitions;
    }

    public static class DefinitionConverter{
        @TypeConverter
        public String fromDefinitions(List<Definition> definitions){
            if(definitions == null){
                return null;
            }
            Gson gson = new Gson();
            Type type = new TypeToken<List<Definition>>() {
            }.getType();
            String json = gson.toJson(definitions, type);
            return json;
        }

        @TypeConverter
        public List<Definition> fromString(String definitions){
            if (definitions == null) {
                return (null);
            }
            Gson gson = new Gson();
            Type type = new TypeToken<List<Definition>>() {
            }.getType();
            List<Definition> productCategoriesList = gson.fromJson(definitions, type);
            return productCategoriesList;
        }
    }
}
