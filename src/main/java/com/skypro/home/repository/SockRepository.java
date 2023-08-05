package com.skypro.home.repository;

import com.skypro.home.model.Sock;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SockRepository extends JpaRepository<Sock,Integer> {

//    @Query(value = "SELECT SUM(quantity) AS quantity FROM socks WHERE color='red' and cotton_part="+cotton+"",
//    nativeQuery = true)
//    int findAllByColorAndCottonPart(String color, int cottonPart);

    Sock findSockByColorAndCottonPart(String color, int cottonPart);

    boolean existsByColorAndCottonPart(String color, int cottonPart);

    boolean existsSockByColor(String color);

    List<Sock> findSockByColorAndCottonPartGreaterThan(String color, int cottonPart);
    List<Sock> findSockByColorAndCottonPartLessThan(String color, int cottonPart);
    List<Sock> findSockByColorAndCottonPartEquals(String color, int cottonPart);


    boolean existsSockByCottonPart(int cottonPart);


}
