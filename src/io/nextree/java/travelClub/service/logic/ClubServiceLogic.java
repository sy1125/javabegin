package io.nextree.java.travelClub.service.logic;


import io.nextree.java.travelClub.entity.TravleClub;
import io.nextree.java.travelClub.service.ClubService;

import java.util.Arrays;

public class ClubServiceLogic implements ClubService {
    private TravleClub[] clubs;
    private int index;
    public ClubServiceLogic() {
        this.clubs = new TravleClub[10];
        this.index = 0;
    }

    @Override
    public void register(TravleClub travleClub) {
        clubs[index] = travleClub;
        index++;
    }

    @Override
    public TravleClub[] findAll() {
        return Arrays.copyOfRange(clubs, 0, index); // clubs 중 실제 들어있는 데이터만 뽑아냄
    }

    @Override
    public TravleClub[] findByName(String clubName) {
        TravleClub[] createdClubs = Arrays.copyOfRange(clubs, 0, index);
        TravleClub[] foundClubs = new TravleClub[createdClubs.length];
        int subIndex = 0;

        for (TravleClub club : createdClubs) {
            if(club.getClubName().equals(clubName)) {
                foundClubs[subIndex] = club;
                subIndex++;
            }
        }

        return Arrays.copyOfRange(foundClubs, 0, subIndex);
    }

    @Override
    public TravleClub findById(String clubId) {
        TravleClub[] createdClubs = Arrays.copyOfRange(clubs, 0, index);
        TravleClub foundClub = null;
        for(TravleClub club : createdClubs) {
            if(club.getId().equals(clubId)){
                foundClub = club;
                break;
            }
        }
        return foundClub;
    }

    @Override
    public void modify(TravleClub modifyClub) {
        int foundIndex = 0;
        for(int i=0; i<clubs.length; i++){
            if(clubs[i].getId().equals(modifyClub.getId())){
                foundIndex = i;
                break;
            }
        }
        this.clubs[foundIndex] = modifyClub;
    }

    @Override
    public void remove(String clubId) {
        int foundIndex = 0;
        for(int i = 0; i < clubs.length; i++) {
            if(clubs[i].getId().equals(clubId)){
                foundIndex = i;
                break;
            }
        }
        for(int i = foundIndex; i < this.index + 1; i++) {
            clubs[i] = clubs[i+1];
        }
        this.index--;
    }
}
