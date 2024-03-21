package io.nextree.java.travelClub.ui.console;

import io.nextree.java.travelClub.service.ClubService;
import io.nextree.java.travelClub.service.ServiceLogicLifeCycler;
import io.nextree.java.travelClub.service.logic.ClubServiceLogic;

public class ClubSubConsole {
    private ClubService clubService;

    public ClubSubConsole() {
        this.clubService = ServiceLogicLifeCycler.getUniqueInstance().getClubService();
    }
}
