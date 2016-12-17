package main.java.managers;

import main.java.twconstants.LoadTwitterConfig;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

/**
 * Created by tapansharma on 17/12/16.
 */

/**
 * This class is used to authenticate twitter session for making Twitter API requests and processing API response.
 */
public class TWAuth {

    /**
     * The Twitter object interacts with the Twitter API.
     */
    Twitter twitter;

    /**
     * The AccessToken object is used to authenticate Twitter object which is twitter
     * API consumer.
     */
    AccessToken accessToken;

    public Twitter getTwitterInstance() {
        LoadTwitterConfig loadTwitterConfig = new LoadTwitterConfig();
        twitter = new TwitterFactory().getInstance();
        System.out.println("Initialising twitter instance....");
        /**
         * Initialize accesstoken object.
         */
        accessToken = new AccessToken(loadTwitterConfig.getTwitterAccessToken(),
                loadTwitterConfig.getTwitterAccessTokenSecret());
        twitter.setOAuthConsumer(loadTwitterConfig.getTwitterConsumerKey(),
                loadTwitterConfig.getTwitterConsumerSecret());
        twitter.setOAuthAccessToken(accessToken);
        System.out.println("Twitter instance initialised !");
        return twitter;
    }
}
