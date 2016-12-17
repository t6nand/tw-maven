package main.java.twconstants;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by tapansharma on 17/12/16.
 */
public class LoadTwitterConfig {
    private static final String TWITTER_CONFIG = "twitterconfig.properties";

    private String twitterConsumerKey;
    private String twitterConsumerSecret;
    private String twitterAccessToken;
    private String twitterAccessTokenSecret;

    public LoadTwitterConfig() {
        try {
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            Properties props = new Properties();
            InputStream is = loader.getResourceAsStream(TWITTER_CONFIG);
            props.load(is);
            twitterConsumerKey = props.getProperty("oauth.consumerKey", null);
            twitterConsumerSecret = props.getProperty("oauth.consumerSecret", null);
            twitterAccessToken = props.getProperty("oauth.accessToken", null);
            twitterAccessTokenSecret = props.getProperty("oauth.accessTokenSecret", null);
        } catch(IOException io) {
            io.printStackTrace();
        }
    }

    public String getTwitterConsumerKey() {
        return twitterConsumerKey;
    }

    public String getTwitterConsumerSecret() {
        return twitterConsumerSecret;
    }

    public String getTwitterAccessToken() {
        return twitterAccessToken;
    }

    public String getTwitterAccessTokenSecret() {
        return twitterAccessTokenSecret;
    }
}
