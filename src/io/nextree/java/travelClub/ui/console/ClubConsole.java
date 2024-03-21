package io.nextree.java.travelClub.ui.console;

import io.nextree.java.travelClub.entity.TravleClub;
import io.nextree.java.travelClub.service.ClubService;
import io.nextree.java.travelClub.service.ServiceLogicLifeCycler;
import io.nextree.java.travelClub.service.logic.ClubServiceLogic;
import io.nextree.java.travelClub.util.ConsoleUtil;

public class ClubConsole {

    private ConsoleUtil consoleUtil;
    // 의존성 및 유지보수 향상 목적
    private ClubService clubService;
    public ClubConsole() {
        this.consoleUtil = new ConsoleUtil();
        // 이후 변경될 코드
        this.clubService = ServiceLogicLifeCycler.getUniqueInstance().getClubService();
    };
    public void register() {
        while(true) {
            String clubName = consoleUtil.getValueOf("Club Name(0.Club Menu)");
            if(clubName.equals("0")) {
                return;
            }

            String intro = consoleUtil.getValueOf("Club Intro(0.Club Menu)");
            if(intro.equals("0")) {
                return;
            }
            TravleClub newClub = new TravleClub(clubName, intro);
            clubService.register(newClub);
//            배열에 저장
            System.out.println("Registered club : " + newClub.toString());
        }
    }

    public void findAll() {
        TravleClub[] foundClubs = clubService.findAll();
        if(foundClubs.length == 0) {
            System.out.println("Empty");
            return;
        }
        for(TravleClub club : foundClubs) {
            System.out.println(club.toString());
        }

    }

    public void findById() {
        TravleClub foundClub = null;
        while(true){
            String clubId = consoleUtil.getValueOf("Club id to find(0.Club Menu)");
            if(clubId.equals("0")) {
                break;
            }
            foundClub = clubService.findById(clubId);
            if(foundClub != null) {
                System.out.println(foundClub);
            }else{
                System.out.println("Can not find Club, ID : " + clubId);
            }
        }
    }

    public void findByName() {
        TravleClub[] foundClubs = null;
        while (true) {
            String clubName = consoleUtil.getValueOf("Club name to find(0.Club Menu)");
            if(clubName.equals("0")){
                break;
            }
            foundClubs = clubService.findByName(clubName);
            if(foundClubs != null && foundClubs.length != 0) {
                for (TravleClub club : foundClubs) {
                    System.out.println(club);
                }
            }else {
                System.out.println("Can not find club, Name : " + clubName);
            }
        }
    }

    private TravleClub findOne() {
        TravleClub foundClub = null;

        while(true){
            String clubId = consoleUtil.getValueOf("Club id to find(0.Club Menu)");
            if(clubId.equals("0")) {
                break;
            }

            foundClub = clubService.findById(clubId);

            if(foundClub != null) {
                break;
            }else{
                System.out.println("Can not find Club, ID : " + clubId);
            }
        }
        return foundClub;
    }

    public void modify() {
        TravleClub targetClub = findOne();

        String newName = consoleUtil.getValueOf("New Club name(0.Club Menu, Enter. No Change)");
        if(newName.equals("0")){
            return;
        }
        if(!newName.isEmpty()) {
            targetClub.setClubName(newName);
        }
        String newIntro = consoleUtil.getValueOf("New Club intro(0.Club Menu, Enter. No Change)");
        if(!newIntro.isEmpty()){
            targetClub.setIntro(newIntro);
        }
        clubService.modify(targetClub);
        System.out.println("Modify Club : " + targetClub.toString());
    }

    public void remove() {
        TravleClub targetClub = findOne();
        String confirmStr = consoleUtil.getValueOf("Remove this club?(Y: yes, N:no)");
        if(confirmStr.toLowerCase().equals("y") || confirmStr.toLowerCase().equals("yes")){
            System.out.println("Remove a club : " + targetClub.getClubName());
            clubService.remove(targetClub.getId());
        }else{
            System.out.println("Remove cancelled " + targetClub.getClubName());
        }
    }
}
