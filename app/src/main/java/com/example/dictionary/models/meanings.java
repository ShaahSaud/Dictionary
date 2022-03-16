package com.example.dictionary.models;
import java.util.*;

public class meanings {
    String partOfSpeech;
    List<definitions> definitions =null;

    public String getPartOfSpeech() {
        return partOfSpeech;
    }

    public void setPartOfSpeech(String partOfSpeech) {
        this.partOfSpeech = partOfSpeech;
    }

    public List<com.example.dictionary.models.definitions> getDefinitions() {
        return definitions;
    }

    public void setDefinitions(List<com.example.dictionary.models.definitions> definitions) {
        this.definitions = definitions;
    }
}
