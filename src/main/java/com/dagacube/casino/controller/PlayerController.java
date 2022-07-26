package com.dagacube.casino.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dagacube.casino.exception.ResourceNotFoundException;
import com.dagacube.casino.model.Player;
import com.dagacube.casino.repository.PlayerRepository;

@RestController
@RequestMapping("/casino")
public class PlayerController {
    
	@Autowired
    private PlayerRepository playerRepository;
	
	// This method is responsible for getting the balance of a player based on the player id provided.
    @GetMapping("/player/{playerId}/balance")
    public ResponseEntity < Player > getBalance(@PathVariable(value = "playerId") Long playerId)throws ResourceNotFoundException {
    	
    	Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new ResourceNotFoundException("Player not found for this id :: " + playerId));
            return ResponseEntity.ok().body(player);
       
    }

    // The method is responsible for creating a player
    @PostMapping("/players")
    public Player createPlayer(){
    	
    	Player player = new Player();
    	player.setBalance(100);
    	 	
        return playerRepository.save(player);
    }

    // This method updates the balance of a particular id
    @PostMapping("/player/{playerId}/{balance}/update")
    public ResponseEntity < Player > updatePlayer(@PathVariable(value = "playerId")Long playerId, @PathVariable(value = "balance")Long balance) throws ResourceNotFoundException {
          Player player = playerRepository.findById(playerId)
            .orElseThrow(() -> new ResourceNotFoundException("Player not found for this id :: " + playerId));
          
         if(balance >= 0) {
        	 player.setBalance(balance);
        	 player.setAmount(30000);
        	 player.setTransactionId(1);
        	 player.setTransactionType("WIN");
         }
        final Player updatedPlayer = playerRepository.save(player);
        return ResponseEntity.ok(updatedPlayer);
    }

//    @PostMapping("/admin/player/transactions")
//    public List <String> lastTenTransactions(@PathVariable(value = "id") Long playerId)
//    throws ResourceNotFoundException {
//        Player player = playerRepository.findById(playerId)
//            .orElseThrow(() -> new ResourceNotFoundException("Player not found for this id :: " + playerId));
//
//        playerRepository.delete(player);
//        Map < String, Boolean > response = new HashMap < > ();
//        response.put("deleted", Boolean.TRUE);
//        return //response;
//    }
}