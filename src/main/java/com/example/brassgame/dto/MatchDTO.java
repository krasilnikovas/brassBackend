package com.example.brassgame.dto;

import com.example.brassgame.model.Match;

public class MatchDTO {

    private Long id;
    private String createdBy;
    private int currentPlayers;
    private int maxPlayers;
    private int turnDuration;
    private String status;
    private String gameName;

    // Default constructor
    public MatchDTO() {
    }

    // Constructor to initialize from a Match entity
    public MatchDTO(Match match) {
        this.id = match.getId();
        this.createdBy = match.getCreatedBy();
        this.currentPlayers = match.getCurrentPlayers();
        this.maxPlayers = match.getMaxPlayers();
        this.turnDuration = match.getTurnDuration();
        this.status = match.getStatus();
        this.gameName = match.getGame().getName();
    }

    // Getters and setters for each field
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public int getCurrentPlayers() {
        return currentPlayers;
    }

    public void setCurrentPlayers(int currentPlayers) {
        this.currentPlayers = currentPlayers;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public int getTurnDuration() {
        return turnDuration;
    }

    public void setTurnDuration(int turnDuration) {
        this.turnDuration = turnDuration;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }
}
