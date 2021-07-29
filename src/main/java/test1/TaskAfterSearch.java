package test1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class TaskAfterSearch extends TaskBeforeSearch
{
    private List<WebElement> results;
    WebDriverWait wait = new WebDriverWait(chromeDriver, 120);//объект класса ожидания и для какого драйвера делается  ожидание


    public TaskAfterSearch(WebDriver chromeDriver)
    {
        super(chromeDriver);
    }

    public List<WebElement> getResults() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("https://ru.wikipedia.org")));//ожидание назначенного элемента

        results=chromeDriver.findElements(By.partialLinkText("https://ru.wikipedia.org"));//поиск вебэлементов создание их списка
        //Вариант с xpath
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='https://ru.wikipedia.org/wiki/%D0%A8%D0%BF%D0%B0%D0%B6%D0%BD%D0%B8%D0%BA']")))
        //results=chromeDriver.findElements(By.xpath("//a[@href='https://ru.wikipedia.org/wiki/%D0%A8%D0%BF%D0%B0%D0%B6%D0%BD%D0%B8%D0%BA']"));

        System.out.println(results.size());
        System.out.println(results);
        return results;
    }
}
