package com.lottery.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "participants")
public class Participant extends Person{
}
