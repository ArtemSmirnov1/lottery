package com.lottery.repositories;

import com.lottery.entities.Participant;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {

  @Transactional
  @Modifying
  @Query(value = "insert INTO participants(name, age, city) values(:name, :age, :city)", nativeQuery = true)
  public void insertParticipant(@Param("name") String name, @Param("age") Long age, @Param("city") String city);

  @Query(value = "select * from participants", nativeQuery = true)
  public List<Participant> getAllParticipants();

  @Query(value = "select * from participants where id = :id" ,nativeQuery = true)
  public Participant getParticipantById(@Param("id") Long id);

  @Query(value = "select count(name) from participants", nativeQuery = true)
  public Long getParticipantsCount();

  @Transactional
  @Modifying
  @Query(value = "delete from participants", nativeQuery = true)
  public void clearTheTable();

  @Transactional
  @Modifying
  @Query(value = "alter table participants auto_increment = 1", nativeQuery = true)
  public void resetTheCounter();
}
