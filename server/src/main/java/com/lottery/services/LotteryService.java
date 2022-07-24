package com.lottery.services;

import com.lottery.entities.Participant;
import com.lottery.entities.Winner;
import com.lottery.exceptions.NotEnoughParticipantsException;
import com.lottery.repositories.WinnerRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.lottery.repositories.ParticipantRepository;

@Service
public class LotteryService {

  @Value("${participants.min-count}")
  Long participantsMinCount;

  @Value("${random-numbers.prize-min}")
  Long prizeMin;

  @Value("${random-numbers.prize-max}")
  Long prizeMax;

  @Value("${participants.count-error}")
  String countErrorMsg;

  @Autowired
  ParticipantRepository participantRepository;

  @Autowired
  WinnerRepository winnerRepository;

  @Autowired
  RandomNumberService randomNumberService;

  public void createParticipant(Participant participant) {
    participantRepository.insertParticipant(participant.getName(), participant.getAge(), participant.getCity());
  }

  public Optional<List<Participant>> getAllParticipants() {
    return Optional.of(participantRepository.getAllParticipants());
  }

  public Optional<Winner> getWinner() {
    Long participantsCount = participantRepository.getParticipantsCount();
    if (participantsCount < 2) {                                                                                      //проверка на количество участников
      throw new NotEnoughParticipantsException(countErrorMsg + " " + participantsCount);
    }
    Long winnersCount = processTheRandomServicesResponse(
        randomNumberService.getRandomNumber(participantsMinCount, participantsCount));                                //*результат запроса с рандоматора
    Long prizeValue = processTheRandomServicesResponse(randomNumberService.getRandomNumber(prizeMin, prizeMax));      //*необходимо обработать т.к. приходит не чистый Long
    Optional<Participant> winnerOptional = Optional.of(participantRepository.getParticipantById(winnersCount));
    if (winnerOptional.isEmpty()) {
      return Optional.empty();
    }
    Winner winner = new Winner(winnerOptional.get(), prizeValue);
    winnerRepository.insertWinner(winner.getName(), winner.getAge(), winner.getCity(),prizeValue);                    //добавление победителя в таблицу победителей
    participantRepository.clearTheTable();                                                                            //очистка таблицы
    participantRepository.resetTheCounter();                                                                          //*обнуление итератора в таблице, т.к.
    return Optional.of(winner);                                                                                       //*id следующих участников могут быть гораздо больше числа рандоматора
  }

  public Optional<List<Winner>> getAllWinners() {
    return Optional.of(winnerRepository.getAllWinners());
  }

  public Long processTheRandomServicesResponse(String responseString) {
    return Long.valueOf(responseString.replace("\t", ""));
  }
}
