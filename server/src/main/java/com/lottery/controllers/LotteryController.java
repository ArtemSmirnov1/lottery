package com.lottery.controllers;

import com.lottery.entities.Participant;
import com.lottery.entities.Winner;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lottery.services.LotteryService;

@RestController
@RequestMapping(value = "/lottery")
public class LotteryController {

  @Value("${participants.add-success}")
  String successMsg;

  @Autowired
  LotteryService lotteryService;

  @PostMapping(value = "/participant")
  public ResponseEntity<String> CreateParticipant(@RequestBody Participant participant) {
    lotteryService.createParticipant(participant);
    return new ResponseEntity<>(successMsg, HttpStatus.OK);
  }

  @GetMapping(value = "/participant")
  public ResponseEntity<List<Participant>> getAllParticipants() {
    return lotteryService.getAllParticipants().map(participants -> new ResponseEntity<>(participants, HttpStatus.OK))
        .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
  }

  @GetMapping(value = "/start")
  public ResponseEntity<Winner> startLottery() {
    return lotteryService.getWinner().map(winner -> new ResponseEntity<>(winner, HttpStatus.OK))
        .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
  }

  @GetMapping(value = "/winners")
  public ResponseEntity<List<Winner>> getAllWinners() {
    return lotteryService.getAllWinners().map(winners -> new ResponseEntity<>(winners, HttpStatus.OK))
        .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
  }
}
