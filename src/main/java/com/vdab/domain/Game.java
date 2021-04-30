package com.vdab.domain;


import lombok.Data;

import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder

public class Game extends BaseEntity {

    private String gameName;
    private String editor;
    private int yearEdition;
    private String age;
    private int minPlayers;
    private int maxPlayers;
    private Category category; // many to one
    private String playDuration;
    private Difficulty difficulty; // many to one
    private double price;
    private String image;
    private String author;

}
