package test1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTaskTest
{
    protected WebDriver chromeDriver;

    @BeforeEach
    public void before()
    {
        //System.setProperty("webdriver.chrome.driver",System.getenv("CHROME_DRIVER"));//поиск драйвера боаузера по переменной среды

        WebDriverManager.chromedriver().setup();//Класс WebDriverManager смотрит тип ОС
        // определяет обозначенный браузер (chrome), и setup() производит настройку и запуск драйвера для браузера Хром

        chromeDriver = new ChromeDriver();//создание объекта-браузера
        chromeDriver.manage().window().maximize();//установление максимального окна
        chromeDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);//установка времени ожидания загрузки страницы
        chromeDriver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);//установка времени ожидания загрузки скрипта
        chromeDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//установка времени ожидания загрузки элемента
    }

    @AfterEach
    public void closeBellTest(){
        chromeDriver.quit();
    }
}
