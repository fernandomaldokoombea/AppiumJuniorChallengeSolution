package PageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.testng.Assert;

import java.util.List;

public class HomePageObjects {

    AndroidDriver<AndroidElement> myDriver;
    public HomePageObjects(AndroidDriver<AndroidElement> myDriver) {
        this.myDriver = myDriver;
    }

    public void closePopUp() {
        MobileElement mobileELement =  myDriver.findElementByAccessibilityId("Close");
        mobileELement.click();
    }

    public void openBurgerMenu() {
        MobileElement mobileELement =  myDriver.findElementByAccessibilityId("Main navigation, open");
        mobileELement.click();
    }
}
