package com.lottery.repositories;

import com.lottery.entities.Winner;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface WinnerRepository extends JpaRepository<Winner, Long> {

  @Transactional
  @Modifying
  @Query(value = "insert into winners(name, age, city, prize) values(:name, :age, :city, :prize)", nativeQuery = true)
  public void insertWinner(@Param("name") String name, @Param("age") Long age, @Param("city") String city,
      @Param("prize") Long prize);

  @Query(value = "select * from winners", nativeQuery = true)
  public List<Winner> getAllWinners();
}
