/**
 * This is the main class.
 */

import main.java.managers.TWCustServ;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by tapansharma on 17/12/16.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        /**
         * This object on instantiation authorises to twitter API and fetches tweets which have been re-tweeted at least
         * once and has hashtag #custserv.
         */
        TWCustServ twCustServ = new TWCustServ();

        boolean breakFlag = false;

        do {
            ArrayList tweetsOfInterest = twCustServ.searchCustServ();
            if (tweetsOfInterest != null) {
                tweetsOfInterest = twCustServ.filterTweets(tweetsOfInterest);
                for (int i = 0; i < tweetsOfInterest.size(); i++) {
                    String tweet = (String) tweetsOfInterest.get(i);
                    System.out.println("\n" + tweet);
                    System.out.println("--------------------------------------------------------------------");
                }
            }
            System.out.println("\n\n y/Y: Load More \t Rest: Exit");
            Scanner scanner = new Scanner(System.in);
            char option = scanner.next().charAt(0);
            option = Character.toLowerCase(option);
            switch (option) {
                case 'y': break;
                default: breakFlag = true;
                    System.out.println("Completed.");
            }
        } while(breakFlag != true);
    }
}
