package io.nextree.java.travelClub.service;

import io.nextree.java.travelClub.entity.TravleClub;

public interface ClubService {
    void register(TravleClub travleClub);
    TravleClub[] findAll();
    TravleClub[] findByName(String clubName);
    TravleClub findById(String clubId);

    void modify(TravleClub modifyClub);
    void remove(String clubId);
}
