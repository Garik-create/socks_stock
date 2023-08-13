package com.skypro.home.repository;

import com.skypro.home.model.Sock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SockRepository extends JpaRepository<Sock,Integer> {


    Sock findSockByColorAndCottonPart(String color, int cottonPart);

    boolean existsByColorAndCottonPart(String color, int cottonPart);

    boolean existsSockByColor(String color);

    List<Sock> findSockByColorAndCottonPartGreaterThan(String color, int cottonPart);
    List<Sock> findSockByColorAndCottonPartLessThan(String color, int cottonPart);
    List<Sock> findSockByColorAndCottonPartEquals(String color, int cottonPart);


}
