package org.auntor.pageObjects;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.auntor.utilities.Common;
import org.openqa.selenium.By;

import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class NavigationDrawerPage extends Common {
    AndroidDriver driver;
    ClassRoutinePage classRoutine;
    NoticeBoardPage noticeBoard;
    StudentPortalPage studentPortalPage;
    AdministrationPage administration;
    FacultyMemberPage facultyMember;
    AcademicResultPage academicResult;
    AcademicCalenderPage academicCalender;
    RulesAndRegulationPage rulesAndRegulation;
    HomePage homePage;
    ExaminationGuidelinePage examinationGuideline;
    ProspectiveStudentsPage prospectiveStudents;
    CreditTransferPage creditTransfer;
    SettingsPage settings;

    public NavigationDrawerPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.daffodilvarsity.diu:id/material_drawer_account_header_name")
    AndroidElement navigationDrawerHeaderElement;
   @AndroidFindBy(xpath = "//*[@resource-id='com.daffodilvarsity.diu:id/material_drawer_name' and contains(@text,'Class Routine')]")
    AndroidElement nav_ClassRoutineElement;
    @AndroidFindBy(xpath = "//*[@resource-id='com.daffodilvarsity.diu:id/material_drawer_name' and contains(@text,'Notice Board')]")
    AndroidElement nav_NoticeBoardElement;
    @AndroidFindBy(xpath = "//*[@resource-id='com.daffodilvarsity.diu:id/material_drawer_name' and contains(@text,'Student Portal')]")
    AndroidElement nav_StudentPortalElement;
    @AndroidFindBy(xpath = "//*[@resource-id='com.daffodilvarsity.diu:id/material_drawer_name' and contains(@text,'Administration')]")
    AndroidElement nav_AdministrationElement;
    @AndroidFindBy(xpath = "//*[@resource-id='com.daffodilvarsity.diu:id/material_drawer_name' and contains(@text,'Faculty Members')]")
    AndroidElement nav_FacultyMembersElement;
    @AndroidFindBy(xpath = "//*[@resource-id='com.daffodilvarsity.diu:id/material_drawer_name' and contains(@text,'Academic Result')]")
    AndroidElement nav_AcademicResultElement;
    @AndroidFindBy(xpath = "//*[@resource-id='com.daffodilvarsity.diu:id/material_drawer_name' and contains(@text,'Academic Calendar')]")
    AndroidElement nav_AcademicCalendarElement;
    @AndroidFindBy(xpath = "//*[@resource-id='com.daffodilvarsity.diu:id/material_drawer_name' and contains(@text,'Rules and Regulation')]")
    AndroidElement nav_RulesAndRegulationElement;
    @AndroidFindBy(xpath = "//*[@resource-id='com.daffodilvarsity.diu:id/material_drawer_name' and contains(@text,'Examination Guideline')]")
    AndroidElement nav_ExaminationGuidelineElement;
    @AndroidFindBy(xpath = "//*[@resource-id='com.daffodilvarsity.diu:id/material_drawer_name' and contains(@text,'Prospective Students')]")
    AndroidElement nav_ProspectiveStudentsElement;
    @AndroidFindBy(xpath = "//*[@resource-id='com.daffodilvarsity.diu:id/material_drawer_name' and contains(@text,'Credit Transfer')]")
    AndroidElement nav_CreditTransferElement;
    @AndroidFindBy(xpath = "//*[@resource-id='com.daffodilvarsity.diu:id/material_drawer_name' and contains(@text,'Settings')]")
    AndroidElement nav_SettingsElement;
    public String getNavigationDrawerHeaderText() {
        return navigationDrawerHeaderElement.getText();
    }


    public boolean scrollNavigationDrawer() {
        int count = 0;
        scrollingAndSwapping(driver,.20, .20, .80, .20);
        List<AndroidElement> elements = driver.findElements(By.id("com.daffodilvarsity.diu:id/material_drawer_name"));
        for (int i = 0; i < elements.size() - 1; i++) {
            if (elements.get(i).getText().equals("ADMIN PORTAL")) {
                count++;
            }
        }
        scrollingAndSwapping(driver,.20, .20, .20, .80);
        if (count == 1) {
            return true;
        } else {
            return false;
        }

    }

    public String getClassRoutinePageHeader() {
        classRoutine = new ClassRoutinePage(driver);
       TouchAction action = new TouchAction(driver);
        action.tap(new TapOptions().withElement(new ElementOption().withElement(nav_ClassRoutineElement))).perform();
        closeAppSplashScreen(driver);
        return classRoutine.getHeaderText();
    }

    public void enterClassRoutineFromNavDrawer() {
        classRoutine = new ClassRoutinePage(driver);
        TouchAction action = new TouchAction(driver);
        action.tap(new TapOptions().withElement(new ElementOption().withElement(nav_ClassRoutineElement))).perform();
        closeAppSplashScreen(driver);
    }

    public String getNoticeBoardPageHeader() {
        noticeBoard = new NoticeBoardPage(driver);
        TouchAction action = new TouchAction(driver);
        action.tap(new TapOptions().withElement(new ElementOption().withElement(nav_NoticeBoardElement))).perform();
        return noticeBoard.getHeaderText();
    }

    public String getStudentPortalPageHeader() {
        studentPortalPage = new StudentPortalPage(driver);
        TouchAction  action = new TouchAction(driver);
        action.tap(new TapOptions().withElement(new ElementOption().withElement(nav_StudentPortalElement))).perform();
        return studentPortalPage.portalPageTest();
    }

    public String getAdministrationSearchHintText() {
        administration = new AdministrationPage(driver);
        TouchAction action = new TouchAction(driver);
        action.tap(new TapOptions().withElement(new ElementOption().withElement(nav_AdministrationElement))).perform();
        return administration.getSearchHintTextForAdministration();
    }

    public String getFacultyMemberSearchHintText() {
        facultyMember = new FacultyMemberPage(driver);
        TouchAction action = new TouchAction(driver);
        action.tap(new TapOptions().withElement(new ElementOption().withElement(nav_FacultyMembersElement))).perform();
        return facultyMember.getSearchHintText();
    }

    public String getAcademicResultPageHeaderText() {
        academicResult = new AcademicResultPage(driver);
        TouchAction action = new TouchAction(driver);
        action.tap(new TapOptions().withElement(new ElementOption().withElement(nav_AcademicResultElement))).perform();
        return academicResult.getHeaderText();
    }

    public int getAcademicCalenderYearText() {
        academicCalender = new AcademicCalenderPage(driver);
        TouchAction action = new TouchAction(driver);
        action.tap(new TapOptions().withElement(new ElementOption().withElement(nav_AcademicCalendarElement))).perform();
        return academicCalender.getCurrentYear();
    }

    public boolean rulesAndRegulationPageOkBtnCheck() {
        rulesAndRegulation = new RulesAndRegulationPage(driver);
        homePage = new HomePage(driver);
        TouchAction action = new TouchAction(driver);

        action.tap(new TapOptions().withElement(new ElementOption().withElement(nav_RulesAndRegulationElement))).perform();
        rulesAndRegulation.PressOkButton();
        if(homePage.getPageTitle().equals("diu")){
            return true;
        }else{
            return false;
        }
    }
    public boolean examinationGuidelinePageOkBtnCheck() {
       examinationGuideline = new ExaminationGuidelinePage(driver);
        homePage = new HomePage(driver);
        TouchAction action = new TouchAction(driver);
        action.tap(new TapOptions().withElement(new ElementOption().withElement(nav_ExaminationGuidelineElement))).perform();
        examinationGuideline.PressOkButton();
        if(homePage.getPageTitle().equals("diu")){
            return true;
        }else{
            return false;
        }
    }
    public boolean prospectiveStudentsPageOkBtnCheck() {
        prospectiveStudents = new ProspectiveStudentsPage(driver);
        homePage = new HomePage(driver);
        TouchAction action = new TouchAction(driver);
        action.tap(new TapOptions().withElement(new ElementOption().withElement(nav_ProspectiveStudentsElement))).perform();
        prospectiveStudents.PressOkButton();
        if(homePage.getPageTitle().equals("diu")){
            return true;
        }else{
            return false;
        }
    }

    public boolean creditTransferPageOkBtnCheck() {
        creditTransfer = new CreditTransferPage(driver);
        homePage = new HomePage(driver);
        TouchAction action = new TouchAction(driver);
        action.tap(new TapOptions().withElement(new ElementOption().withElement(nav_CreditTransferElement))).perform();
        creditTransfer.PressOkButton();
        if(homePage.getPageTitle().equals("diu")){
            return true;
        }else{
            return false;
        }
    }

    public String getSettingsPageTitleText() {
        settings = new SettingsPage(driver);
        TouchAction action = new TouchAction(driver);
        scrollingAndSwapping(driver,.20, .20, .80, .10);
        action.tap(new TapOptions().withElement(new ElementOption().withElement(nav_SettingsElement))).perform();
        return settings.getSettingsPageTitle();
    }

}
