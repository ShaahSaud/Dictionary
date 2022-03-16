package com.example.dictionary.models;
import java.util.*;

public class ApiResponse {
    String word="";
    List<phonetics> phonetics = null;
    List<meanings> meanings = null;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public List<com.example.dictionary.models.phonetics> getPhonetics() {
        return phonetics;
    }

    public void setPhonetics(List<com.example.dictionary.models.phonetics> phonetics) {
        this.phonetics = phonetics;
    }

    public List<com.example.dictionary.models.meanings> getMeanings() {
        return meanings;
    }

    public void setMeanings(List<com.example.dictionary.models.meanings> meanings) {
        this.meanings = meanings;
    }
}
