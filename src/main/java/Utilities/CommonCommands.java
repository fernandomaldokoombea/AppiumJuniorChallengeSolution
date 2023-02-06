package Utilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.PointOption;

import java.time.Duration;
import java.util.List;

public class CommonCommands {
    AndroidDriver<AndroidElement> myDriver;
    public CommonCommands(AndroidDriver<AndroidElement> myDriver) {
        this.myDriver = myDriver;
    }

    public boolean obtainElementVisibilityByText(String text) {
        String locator = String.format("//android.widget.CheckedTextView[@text='%s']", text);
        MobileElement mobileELement =  myDriver.findElementByXPath(locator);
        return mobileELement.isDisplayed();
    }

    public void searchForAnItem(String searchValue) throws InterruptedException {
        MobileElement mobileELement =  myDriver.findElementById("com.ebay.mobile:id/search_box");
        mobileELement.click();
        mobileELement =  myDriver.findElementById("com.ebay.mobile:id/search_src_text");
        mobileELement.sendKeys(searchValue);
        myDriver.pressKey(new KeyEvent(AndroidKey.ENTER));
        mobileELement =  myDriver.findElementById("com.ebay.mobile:id/text_slot_1");
        mobileELement.click();
    }

    public void tapOutsideToClose(){
        TouchAction touchAction=new TouchAction(myDriver);
        touchAction.tap(PointOption.point(1258, 112)).perform();
    }

    public void scrollDownTimes(int swipeTimes) throws InterruptedException {
        TouchAction touchAction = new TouchAction(myDriver);
        for (int i = 0; i <= 1; i++){
            touchAction.longPress(LongPressOptions.longPressOptions().withPosition(PointOption.point(488,1320)) .withDuration(Duration.ofSeconds(2))).moveTo(PointOption.point(501,501)).release().perform();
            Thread.sleep(1000);
        }
    }
}
