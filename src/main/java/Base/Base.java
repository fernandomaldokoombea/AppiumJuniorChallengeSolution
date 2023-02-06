package Base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Base {
    public static AndroidDriver<AndroidElement> baseCapabilities() throws MalformedURLException {
        File appDirectory = new File("apk");
        File apkFile = new File(appDirectory, "ebay.apk" );

        DesiredCapabilities desCapabilities = new DesiredCapabilities();
        desCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"DeviceForTestingOne");
        desCapabilities.setCapability(MobileCapabilityType.APP, apkFile.getAbsolutePath());
        desCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        //desCapabilities.setCapability(MobileCapabilityType.FULL_RESET, true);
        //desCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);

        desCapabilities.setCapability("appPackage", "com.ebay.mobile");
        desCapabilities.setCapability("appActivity","com.ebay.mobile.activities.MainActivity");

        //desCapabilities.setCapability("appPackage", "com.amazon.mShop.android.shopping");
        //desCapabilities.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");


        URL rootUrl = new URL("http://127.0.0.1:4723/wd/hub");
        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(rootUrl, desCapabilities);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        return driver;

    }
}
