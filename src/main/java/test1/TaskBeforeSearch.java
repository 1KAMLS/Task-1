package test1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TaskBeforeSearch
{
    protected WebDriver chromeDriver;
    private WebElement searchField;


    public TaskBeforeSearch (WebDriver chromeDriver)
    {
        this.chromeDriver = chromeDriver;
        searchField = chromeDriver.findElement(By.className("gLFyf"));//поиск на странице по className элемента и назначение его в searchField
    }

    public  void find (String keysFind)
    {
        searchField.click();//уже найденный объект searchField класса WebElement кликает по полю для его активации
        searchField.sendKeys(keysFind+ Keys.ENTER);//вставка переданного значения
    }
}
