package main.java.managers;

import twitter4j.*;

import java.util.ArrayList;

/**
 * Created by tapansharma on 17/12/16.
 */

/**
 * This class is used to get tweets with following constraints:
 * 1. Have been re-tweeted at least once.
 * 2. Contains the hashtag #custserv.
 */
public class TWCustServ {
    final Twitter twitter = new TWAuth().getTwitterInstance();
    private final String HASHTAG_OF_INTEREST = "#custserv";
    private static long tweetID = Long.MAX_VALUE;
    /**
     * This method is used to fetch tweets with hashtag #custserv in them.
     *
     * @return ArrayList of query result tweets.
     */
    public ArrayList searchCustServ() {
        ArrayList tweets = new ArrayList();
        Query query = new Query(HASHTAG_OF_INTEREST).resultType(Query.ResultType.recent);
        // Let query fetch 100 tweets per page.
        query.setCount(100);
        // Set updated Max_Id for subsequent searches on same hashtag.
        if(tweetID != Long.MAX_VALUE) {
            query.setMaxId(tweetID -1);
        }
        try {
            QueryResult result = twitter.search(query);
            tweets = (ArrayList) result.getTweets();
        } catch (TwitterException t) {
            t.printStackTrace();
        }
        return tweets;
    }

    /**
     * This method is used to filter fetched tweets on following criterion:
     * Tweet must have been re-tweeted at least once.
     *
     * @return Filtered ArrayList of tweets.
     */
    public ArrayList filterTweets(ArrayList tweetsToBeFiltered) {
        ArrayList result = new ArrayList();
        try {
            for (int i = 0; i < tweetsToBeFiltered.size(); i++) {
                Status tweetStatus = (Status) tweetsToBeFiltered.get(i);
                if(tweetStatus.getId() < tweetID) {
                    tweetID = tweetStatus.getId();
                }
                /**
                 * Only consider those re-tweets with at least 1 re-tweet.
                 */
                StringBuilder sb = new StringBuilder();
                if (tweetStatus.getRetweetCount() > 0) {
                    sb.append(tweetStatus.getText()).append("\n\n").append("Tweeted By: " + tweetStatus.getUser().
                            getName()).append("\t").append("Re-Tweeted " + tweetStatus.getRetweetCount() + " times");
                    result.add(sb.toString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
