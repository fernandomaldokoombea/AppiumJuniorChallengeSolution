import Base.Base;
import PageObjects.HomePageObjects;
import PageObjects.ItemDetailsPageObject;
import PageObjects.ItemListPageObjects;
import Utilities.CommonCommands;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class e2eTests extends Base {
    HomePageObjects oHomePageObjects = null;
    ItemDetailsPageObject oItemDetailsPageObjects = null;
    CommonCommands oCommonCommands = null;
    ItemListPageObjects oItemListPageObjects = null;

    AndroidDriver myDriver = null;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        myDriver = baseCapabilities();
        oHomePageObjects = new HomePageObjects(myDriver);
        oItemDetailsPageObjects = new ItemDetailsPageObject(myDriver);
        oCommonCommands = new CommonCommands(myDriver);
        oItemListPageObjects = new ItemListPageObjects(myDriver);
    }

    @Test()
    private void e2eTestOne() throws InterruptedException {
        oHomePageObjects.closePopUp();
        oHomePageObjects.openBurgerMenu();
        Assert.assertTrue(oCommonCommands.obtainElementVisibilityByText("Home"));
        Assert.assertTrue(oCommonCommands.obtainElementVisibilityByText("Notifications"));
        Assert.assertTrue(oCommonCommands.obtainElementVisibilityByText("Messages"));
        Assert.assertTrue(oCommonCommands.obtainElementVisibilityByText("Watchlist"));
        Assert.assertTrue(oCommonCommands.obtainElementVisibilityByText("Saved"));
        Assert.assertTrue(oCommonCommands.obtainElementVisibilityByText("Purchases"));
        oCommonCommands.tapOutsideToClose();
        oCommonCommands.searchForAnItem("Logitech headset");
        oItemListPageObjects.selectItemInPosition(1);
        System.out.println(oItemDetailsPageObjects.getProductName());
        oItemDetailsPageObjects.swipeImagesAndScrollDown(3);
        System.out.println(oItemDetailsPageObjects.getProductPrice());
    }
}
