package org.auntor.pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class ExaminationGuidelinePage {
    AndroidDriver driver;


    public ExaminationGuidelinePage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@index='2']")
    AndroidElement okButtonElement;


    public void PressOkButton(){
        okButtonElement.click();
    }
}