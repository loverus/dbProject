package com.db.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idWord;
    private String wordName;
    private int minAge;

    public Word(String wordName, int minAge) {
        this.wordName = wordName;
        this.minAge = minAge;
    }

    public long getIdWord() {
        return idWord;
    }

    public void setIdWord(long idWord) {
        this.idWord = idWord;
    }

    public String getWordName() {
        return wordName;
    }

    public void setWordName(String wordName) {
        this.wordName = wordName;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }


    @Override
    public String toString() {
        return "Word{" +
                "wordName='" + wordName + '\'' +
                '}';
    }
}
