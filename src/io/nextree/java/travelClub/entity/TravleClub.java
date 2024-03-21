package io.nextree.java.travelClub.entity;

import io.nextree.java.travelClub.util.DateUtil;

import java.util.UUID; // id 초기화패키지

public class TravleClub {
    // Fields
    private static final int MINIMUM_NAME_LENGTH = 3;
    private static final int MINIMUM_INTRO_LENGTH = 5;
    private String id;
    private String clubName;
    private String intro;
    private String message;
    private String foundationDay;

    public TravleClub() {
        this.id = UUID.randomUUID().toString();
    }

    public TravleClub(String clubName, String intro) {
        this();
        setClubName(clubName);
        setIntro(intro);
        this.foundationDay = DateUtil.today();
    }

    // Setter Method
    public void setClubName(String clubName) {
        if(clubName.length() < MINIMUM_NAME_LENGTH) {
            System.out.println("ClubName should be longer than 3");
            return;
        }
        this.clubName = clubName;
    }

    // Getter Method
    public String getClubName() {
        return this.clubName;
    }

    public void setIntro(String intro) {
        if(intro.length() < MINIMUM_INTRO_LENGTH) {
            System.out.println("Intro should be longer than " + MINIMUM_INTRO_LENGTH);
            return;
        }
        this.intro = intro;
    }

    public String getIntro() {
        return this.intro;
    }

    public String getId() {
        return this.id;
    }

    public String getFoundationDay() {
        return this.foundationDay;
    }

    public static TravleClub getSample() {
        String clubName = "Sample Club";
        String intro = "Sample Club Intro~";
        TravleClub sampleClub = new TravleClub(clubName, intro);
        return sampleClub;
    }

    @Override // 상속받은 메서드를 재정의
    public String toString() {
        StringBuilder builder = new StringBuilder(); // 문자열 조합 클래스
        builder.append("TravelClub ID : ").append(id);
        builder.append(", ClubName : ").append(clubName);
        builder.append(", Intro : ").append(intro);
        builder.append(", FoundationDay : ").append(foundationDay);

        return builder.toString();
    }
}
