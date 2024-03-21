package io.nextree.java.travelClub;

import io.nextree.java.travelClub.entity.TravleClub;
import io.nextree.java.travelClub.ui.menu.ClubMenu;
import io.nextree.java.travelClub.util.DateUtil;

public class StoryAssistant {

    private void startStory() {
        ClubMenu clubMenu = new ClubMenu();
        clubMenu.show();
    }

    public static void main(String[] args) {
        StoryAssistant assistant = new StoryAssistant();
        assistant.startStory();
    }
}
