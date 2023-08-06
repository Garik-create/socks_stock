package com.skypro.home.service;

import com.skypro.home.model.Sock;
import com.skypro.home.model.User;
import com.skypro.home.record.Role;
import com.skypro.home.record.SockRecord;
import com.skypro.home.repository.SockRepository;
//import com.skypro.home.security.SecurityUser;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.lang.Long.valueOf;

@Service
public class SockService {

    private final SockRepository sockRepository;
    private final SockMapperService mapper;
    private final UserService userService;
//    private final PasswordEncoder encoder;
//    private final SecurityUser userDetails;

    public SockService(SockRepository sockRepository,
                       SockMapperService mapper,
                       UserService userService/*,
                       PasswordEncoder encoder,
                       SecurityUser userDetails*/) {
        this.sockRepository = sockRepository;
        this.mapper = mapper;
        this.userService = userService;
//        this.encoder = encoder;
//        this.userDetails = userDetails;
    }

//    @PostConstruct
//    @Transactional
//    public void init() {
//
//        String userName = "dafault";
//        if (!userService.existsByUsername(userName)) {
//            User user = new User();
//            user.setUserName(userName);
//            user.setPassword(encoder.encode("12345"));
//            user.setRole(Role.STOCKMAN);
//            userService.save(user);
//        }
//    }

    @Transactional
    public ResponseEntity<?> addSocks(SockRecord sockRecord) {

        if (sockRecord.getColor().isBlank()
                || sockRecord.getQuantity() == 0
                || sockRecord.getCottonPart() < 0
                || sockRecord.getCottonPart() > 100) {

            return ResponseEntity.status(400).body("Параметры запроса отсутствуют, или имеют некорректный формат!");
        } else if (!sockRepository.existsByColorAndCottonPart(sockRecord.getColor(),
                sockRecord.getCottonPart())) {

            sockRepository.save(mapper.toSockEntity(sockRecord));
            return ResponseEntity.status(200).body("Удалось добавить приход.");
        } else {
            Sock sock = sockRepository.findSockByColorAndCottonPart(sockRecord.getColor(), sockRecord.getCottonPart());

            long quantity = sock.getQuantity();
            sockRepository.delete(sock);
            quantity += sockRecord.getQuantity();
            sockRecord.setQuantity(quantity);
            sockRepository.save(mapper.toSockEntity(sockRecord));
            return ResponseEntity.status(200).body("Удалось добавить приход.");
        }
    }

    @Transactional
    public ResponseEntity<?> removeSocks(SockRecord sockRecord) {

        if (sockRecord.getColor().isBlank()
                || sockRecord.getQuantity() == 0
                || sockRecord.getCottonPart() < 0
                || sockRecord.getCottonPart() > 100) {

            return ResponseEntity.status(400).body("Параметры запроса отсутствуют, или имеют некорректный формат!");
        } else if (!sockRepository.existsByColorAndCottonPart(sockRecord.getColor(),
                sockRecord.getCottonPart())) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Таких носков на складе нет!");
        } else if (sockRepository.findSockByColorAndCottonPart(sockRecord.getColor(),
                sockRecord.getCottonPart()).getQuantity() < sockRecord.getQuantity()) {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Таких носков на складе не достаточно!");
        } else {

            Sock sock = sockRepository.findSockByColorAndCottonPart(sockRecord.getColor(),
                    sockRecord.getCottonPart());
            long quantity = sock.getQuantity();
            sockRepository.delete(sock);
            quantity -= sockRecord.getQuantity();
            sockRecord.setQuantity(quantity);
            sockRepository.save(mapper.toSockEntity(sockRecord));
            return ResponseEntity.status(200).body("Удалось отгрузить товар.");
        }
    }

    @Transactional(readOnly = true)
    public ResponseEntity<?> getAmount(String color, String operation, int cottonPart) {

        if (color.isBlank()
                || cottonPart < 0
                || cottonPart > 100
                || operation.isBlank()) {

            return ResponseEntity.status(400).body("Параметры запроса отсутствуют, или имеют некорректный формат!");
        } else if (!sockRepository.existsSockByColor(color)) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Таких носков на складе нет!");
        } else if (operation.equals("moreThan")) {

            List<Sock> socks = sockRepository.findSockByColorAndCottonPartGreaterThan(color, cottonPart);
            long count = 0L;
            for (Sock sock : socks) {
                count += sock.getQuantity();
            }
            return ResponseEntity.status(200).body(String.valueOf(count));
        } else if (operation.equals("lessThan")) {

            List<Sock> socks = sockRepository.findSockByColorAndCottonPartLessThan(color, cottonPart);
            long count = 0L;
            for (Sock sock : socks) {
                count += sock.getQuantity();
            }
            return ResponseEntity.status(200).body(String.valueOf(count));
        } else if (operation.equals("equal")) {

            List<Sock> socks = sockRepository.findSockByColorAndCottonPartEquals(color, cottonPart);
            long count = 0L;
            for (Sock sock : socks) {
                count += sock.getQuantity();
            }
            return ResponseEntity.status(200).body(String.valueOf(count));
        } else {

            return ResponseEntity.status(400).body("Параметры запроса отсутствуют, или имеют некорректный формат!");
        }
    }
}
