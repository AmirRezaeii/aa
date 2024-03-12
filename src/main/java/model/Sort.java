package model;

import java.util.Comparator;


public class Sort implements Comparator<User> {
    @Override
    public int compare(User user1, User user2) {
        int highScoreCompare = Integer.compare(user2.getScore() , user1.getScore());
        int timeCompare = Float.compare(user2.getTime(),user1.getTime());
        int usernameCompare = user1.getUsername().compareTo(user2.getUsername());

        if(highScoreCompare != 0) return highScoreCompare;
        else if (timeCompare != 0) return timeCompare;
        else return usernameCompare;
    }
}
