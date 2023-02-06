package PageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import java.util.List;

public class ItemListPageObjects {

    AndroidDriver<AndroidElement> myDriver;
    public ItemListPageObjects(AndroidDriver<AndroidElement> myDriver) {
        this.myDriver = myDriver;
    }

    public void selectItemInPosition(int position) {
        List<AndroidElement> mobileELements = myDriver.findElementsById("com.ebay.mobile:id/cell_collection_item");
        mobileELements.get(position-1).click();
    }

}
