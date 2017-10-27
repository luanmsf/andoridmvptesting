package luan.com.androidmvp.custom;

import static junit.framework.Assert.fail;

/**
 * Created by ntluan on 10/19/17.
 */

public class ConsiderCondition {
    public void waitFor(int timeOut) {
        try {
            Thread.sleep(timeOut);
        } catch (InterruptedException e) {
            fail();
            e.printStackTrace();
        }
    }


    public void waitForCondition(Condition condition, int timeOut) {
        int timeWait = 0;
        while (timeWait < timeOut) {
            if (condition.isSatisfied()) {
                return;
            }
        }

        timeWait = +200;
        waitFor(200);

    }
}
