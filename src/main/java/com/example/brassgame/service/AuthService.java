package com.example.brassgame.service;

import com.example.brassgame.model.Player;
import com.example.brassgame.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class AuthService {

    private static final Logger logger = LoggerFactory.getLogger(AuthService.class);

    @Autowired
    private PlayerRepository playerRepository;

    public boolean validateUser(String name, String password) {
        Player player = playerRepository.findByName(name);
        if (player != null) {
            logger.info("-----LOGIN PLAYER-----");
            logger.info("Player found: {}", player.getName());
            logger.info("Comparing passwords: {} and {}", player.getPassword(), password);
            if (player.getPassword().equals(password)) {
                return true;
            }
        }
        logger.warn("Invalid login attempt for username: {}", name);
        return false;
    }
}