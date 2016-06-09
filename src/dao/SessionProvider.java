package dao;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class SessionProvider
{
    private static List<String> sids;
    static{
        sids = new ArrayList<>();
    }
    public static synchronized String nextSessionId() {
        String sid;
        do
        {
            sid = new BigInteger(130, new SecureRandom()).toString(32).substring(0, 10);
        }
            while (sids.contains(sid));
        sids.add(sid);
        return sid;
    }
    public static synchronized boolean checkSid(String sid){
        return sids.contains(sid);
    }
}
