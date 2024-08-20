package com.example.brassgame.controller;

import com.example.brassgame.model.Player;
import com.example.brassgame.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping
    public List<Player> getPlayers() {
        return playerRepository.findAll();
    }

    @PostMapping
    public Player addPlayer(@RequestBody Player player) {
        return playerRepository.save(player);
    }

    @GetMapping("/{playerId}")
    public ResponseEntity<Player> getPlayerById(@PathVariable Long playerId) {
        return playerRepository.findById(playerId)
                .map(player -> {
                    player.setPassword(null); // Do not expose the password in the response
                    return ResponseEntity.ok(player);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{playerId}")
    public ResponseEntity<Player> updatePlayer(@PathVariable Long playerId, @RequestBody Player updatedPlayer) {
        return playerRepository.findById(playerId)
                .map(player -> {
                    player.setProfilePicture(updatedPlayer.getProfilePicture());
                    playerRepository.save(player);
                    return ResponseEntity.ok(player);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}