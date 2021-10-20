package org.auntor.pageObjects;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.Calendar;
import java.util.Date;

public class AddToRoutinePage {
    AndroidDriver driver;

    public AddToRoutinePage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @AndroidFindBy(id = "com.daffodilvarsity.diu:id/submitRoutine")
    AndroidElement submitRoutineElement;
    @AndroidFindBy(id = "com.daffodilvarsity.diu:id/roomNumber")
    AndroidElement roomNumberElement;

    public void AddAClassToday(String roomNumber) {
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int dayNumberOfWeek = c.get(Calendar.DAY_OF_WEEK); //// 0-sat,1-sun,2-mon,3,4,5,6
        driver.findElementByXPath("//android.widget.ImageView[@index='" + dayNumberOfWeek + "']").click();
        roomNumberElement.sendKeys(roomNumber);
        submitRoutineElement.click();
    }
    public boolean isTodayClassVisible(String course) {
        int count=0;
        int totalElements =  driver.findElementsByClassName("android.widget.TextView").size();
        for(int i=0;i<totalElements-1;i++){
            AndroidElement element = (AndroidElement) driver.findElementsByClassName("android.widget.TextView").get(i);
            if(element.getText().equals(course)){
               count++;
                break;
            }
        }
        if(count==1){
            return true;
        }else {
            return false;
        }
    }


    public void AddAClassTomorrow(String roomNumber) {
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int dayNumberOfWeek = c.get(Calendar.DAY_OF_WEEK);
        if(dayNumberOfWeek==6){
            dayNumberOfWeek=-1;
        }
        driver.findElementByXPath("//android.widget.ImageView[@index='" + (dayNumberOfWeek+1) + "']").click();
        roomNumberElement.sendKeys(roomNumber);
        submitRoutineElement.click();
    }

}
