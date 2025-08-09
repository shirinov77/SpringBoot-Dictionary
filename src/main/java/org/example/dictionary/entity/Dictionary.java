package org.example.dictionary.entity;

import java.time.LocalDateTime;

public class Dictionary {
    private Long id;
    private String word;
    private String meaning;
    private LocalDateTime createDate;

    public Dictionary(Long id, String word, String meaning, LocalDateTime createDate) {
        this.id = id;
        this.word = word;
        this.meaning = meaning;
        this.createDate = createDate;
    }
    public Dictionary() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getWord() {
        return word;
    }
    public void setWord(String word) {
        this.word = word;
    }
    public String getMeaning() {
        return meaning;
    }
    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }
    public LocalDateTime getCreateDate() {
        return createDate;
    }
    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }
}
