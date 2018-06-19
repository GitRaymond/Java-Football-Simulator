package game.football.helper;

import java.util.concurrent.TimeUnit;

public class Helper {

    public void sleep(int i) {
        try {
            TimeUnit.SECONDS.sleep(i);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
