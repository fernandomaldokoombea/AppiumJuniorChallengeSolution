package PageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.PointOption;
import java.time.Duration;

public class ItemDetailsPageObject {

    AndroidDriver<AndroidElement> myDriver;
    public ItemDetailsPageObject(AndroidDriver<AndroidElement> myDriver) {
        this.myDriver = myDriver;
    }

    public void swipeImagesAndScrollDown(int swipeTimes) throws InterruptedException {
        TouchAction touchAction = new TouchAction(myDriver);
        for (int i = 0; i <= swipeTimes; i++){
            touchAction.longPress(LongPressOptions.longPressOptions().withPosition(PointOption.point(1023,1312)) .withDuration(Duration.ofSeconds(2))).moveTo(PointOption.point(26,1312)).release().perform();
            Thread.sleep(1000);
        }
        for (int i = 0; i <= 1; i++){
            touchAction.longPress(LongPressOptions.longPressOptions().withPosition(PointOption.point(488,1320)) .withDuration(Duration.ofSeconds(2))).moveTo(PointOption.point(501,501)).release().perform();
            Thread.sleep(1000);
        }
    }

    public String getProductName(){
        MobileElement mobileELement =  myDriver.findElementById("com.ebay.mobile:id/textview_item_name");
        return  mobileELement.getText();
    }

    public String getProductPrice(){
        MobileElement mobileELement =  myDriver.findElementById("com.ebay.mobile:id/vi_shared_price");
        return  mobileELement.getText();
    }


}
