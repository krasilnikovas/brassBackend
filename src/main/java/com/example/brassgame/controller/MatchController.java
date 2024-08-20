package com.example.brassgame.controller;

import com.example.brassgame.dto.MatchDTO;
import com.example.brassgame.model.Game;
import com.example.brassgame.model.Match;
import com.example.brassgame.repository.GameRepository;
import com.example.brassgame.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/matches")
public class MatchController {

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private GameRepository gameRepository;

    @PostMapping("/create")
    public ResponseEntity<MatchDTO> createMatch(@RequestBody MatchDTO matchDTO) {
        Game game = gameRepository.findByName(matchDTO.getGameName());
        if (game == null) {
            return ResponseEntity.badRequest().build();
        }

        Match match = new Match();
        match.setCreatedBy(matchDTO.getCreatedBy());
        match.setCurrentPlayers(matchDTO.getCurrentPlayers());
        match.setMaxPlayers(matchDTO.getMaxPlayers());
        match.setTurnDuration(matchDTO.getTurnDuration());
        match.setStatus(matchDTO.getStatus());
        match.setGame(game);

        Match savedMatch = matchRepository.save(match);

        return ResponseEntity.ok(new MatchDTO(savedMatch));
    }

    @GetMapping
    public List<MatchDTO> getMatchesByGameName(@RequestParam(required = false) String game) {
        List<Match> matches;
        if (game != null) {
            matches = matchRepository.findByGameName(game);
        } else {
            matches = matchRepository.findAll();
        }
        return matches.stream().map(MatchDTO::new).collect(Collectors.toList());
    }
}
