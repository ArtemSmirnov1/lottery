package com.lottery.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "winners")
public class Winner extends Person {

  @Column(name = "prize")
  private Long prize;

  public Winner() {
    super();
  }

  public Winner(Participant participant, Long _prize) {
    setName(participant.getName());
    setAge(participant.getAge());
    setCity(participant.getCity());
    this.prize = _prize;
  }

  public Long getPrize() {
    return prize;
  }

  public void setPrize(Long prize) {
    this.prize = prize;
  }
}
