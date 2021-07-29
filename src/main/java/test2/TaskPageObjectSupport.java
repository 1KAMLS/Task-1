package test2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class TaskPageObjectSupport extends TaskPageObject
{
    List<String> spanText= new ArrayList<>();
    List<Double> spanDouble=new ArrayList<>();
    List<WebElement>resaulSearch;
    WebElement resaultSearch;
    WebDriverWait wait = new WebDriverWait(chromeDriver, 120);//объект класса ожидания и для какого драйвера делается  ожидание

    public TaskPageObjectSupport(WebDriver chromeDriver)
    {
        super(chromeDriver);
    }

    public void find()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("https://www.open.ru/")));//ожидание переданного элемента

        resaultSearch = chromeDriver.findElement(By.xpath("//a[@href='https://www.open.ru/']"));//поиск этого элемента
        resaultSearch.click();//клик по нему

        resaulSearch=chromeDriver.findElements((By.xpath("//*[@class='main-page-exchange__row main-page-exchange__row--with-border']" +
                "//*[@class='main-page-exchange__rate']")));//создание списка нужных вебэлементов
    }

    public boolean getResults(int a, int b)
    {
        for(WebElement w : resaulSearch)
            spanText.add((w.getText()).replace(",","."));
        //извлечение из списка вебэлеметов текста и передача их в текстовый список с одновременной заменой запятых на точки

        for (String s: spanText)
            spanDouble.add(Double.parseDouble(s));//создание списка числовых значений из текстового списка

        return spanDouble.get(a)<spanDouble.get(b);//передача значений из списка по заданным аргументам
    }
}
