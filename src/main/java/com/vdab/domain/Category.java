package com.vdab.domain;


import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class Category extends BaseEntity {

    private String gameName;
    private String editor;
    private int yearEdition;
    private String age;
    private int minPlayers;
    private int maxPlayers;
    private Category category;
    private String playDuration;
    private Difficulty difficulty;
    private double price;
    private String image;
    private String author;


    private String categoryName;

    public Category(int id, String categoryName) {
        super(id);
        this.categoryName = categoryName;
    }
}
