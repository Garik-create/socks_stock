package com.skypro.home.service;

import com.skypro.home.model.Sock;
import com.skypro.home.record.SockRecord;
import org.springframework.stereotype.Component;

@Component
public class SockMapperService {

    public SockRecord toSockRecord(Sock sock) {

        SockRecord sockRecord = new SockRecord();
        return sockRecord;
    }

    public Sock toSockEntity(SockRecord sockRecord) {

        Sock sock = new Sock();
        sock.setColor(sockRecord.getColor());
        sock.setCottonPart(sockRecord.getCottonPart());
        sock.setQuantity(sockRecord.getQuantity());
        return sock;
    }
}
