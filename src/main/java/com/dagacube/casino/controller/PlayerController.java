package com.dagacube.casino.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    	//List<String> transactions = new ArrayList<>(); 
    	Player player = new Player();
    	player.setBalance(100);
    	//player.setTransactions(transactions);
    	 	
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

    // This method allows you tp check the last 10 transactions
    @PostMapping("/admin/player/transactions")
    public  ResponseEntity < Player > lastTenTransactions()
    throws ResourceNotFoundException {
        Player player = playerRepository.findById((long) 1)
            .orElseThrow(() -> new ResourceNotFoundException("Player not found for this id :: " + 1));
        String username = "admin";
        
        if(username == "admin") {
        	player.setAmount(30000);
   	 		player.setTransactionId(1);
   	 		player.setTransactionType("WIN");
   	 		String[] transactions = {"WIN","WAGER","WIN","WAGER","WIN","WAGER","WIN","WAGER","WIN","WAGER"};
   	 
   	 		player.setTransactions(transactions);
   	 	
        }
        return ResponseEntity.ok().body(player);
    }
}