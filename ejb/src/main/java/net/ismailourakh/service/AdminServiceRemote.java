package com.example.service;

import com.example.entity.CD;
import com.example.entity.DVD;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface AdminServiceRemote {

    void addCD(CD cd);

    void addDVD(DVD dvd);

    void deleteCD(Long cdId);

    void deleteDVD(Long dvdId);

    List<CD> findAllCDs();

    List<DVD> findAllDVDs();
}
