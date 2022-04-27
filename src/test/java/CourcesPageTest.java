import Page.MainPage;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.ClickBeforeListener;
import utils.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class CourcesPageTest {

    private EventFiringWebDriver driver;
    private MainPage mainPage;

    @BeforeTest
    public void setUp(ITestContext context) {

        driver = new EventFiringWebDriver(WebDriverFactory.setupDriver(System.getProperty("browser")));
        driver.register(new ClickBeforeListener());
        context.setAttribute("driver", driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        mainPage = new MainPage(driver);
    }

    @AfterTest
    public void teamDown() {
        driver.quit();
    }


    @Test(enabled = false)
    public void ClickCourse(){
        mainPage
                .openOtus()
                .ClickCourse(Integer.parseInt(System.getProperty("nameOpenCourse")));
    }



    @Test
    public void SelectSpecialCourses(){
        mainPage
                .openOtus()
                .CoursesSpecial(System.getProperty("nameSpecialCourse"));
    }

    @Test
    public void SelectBeforePopularCourses(){
        mainPage
                .openOtus()
                .BeforePopularCourse();
    }

    @Test
    public void SelectAfterPopularCourse(){
        mainPage
                .openOtus()
                .PopularCourseAfter();
    }

    @Test
    public void SelectBeforeSpecialCourse(){
        mainPage
                .openOtus()
                .BeforeSpecialCourse();
    }

    @Test
    public void SelectAfterSpecialCourse(){
        mainPage
                .openOtus()
                .AfterSpecialCourse();
    }


    @Test
    public void SelectMorePopularCourse(){

        mainPage
                .openOtus()
                .MorePopularCourse(System.getProperty("namePopularCourse"));
    }


}