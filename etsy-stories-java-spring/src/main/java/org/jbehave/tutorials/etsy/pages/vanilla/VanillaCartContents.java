package org.jbehave.tutorials.etsy.pages.vanilla;

import org.jbehave.tutorials.etsy.pages.CartContents;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;

public class VanillaCartContents extends VanillaPage implements CartContents {

    public VanillaCartContents(WebDriverProvider webDriverProvider) {
        super(webDriverProvider);
    }

    public boolean hasItem(String item) {
        get("http://www.etsy.com/cartcheckout.php");
        try {
            findElement(By.id("listing-$item-ship"));
        } catch (RuntimeException ex) {
            return false;
        }
        return true;
    }

    public void removeItem() {
        get("http://www.etsy.com/cartcheckout.php");
        findElement(By.xpath("//a[@rel = 'remove']")).click();
    }

}
