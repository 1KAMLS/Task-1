package test2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TaskPageObject
{
    protected WebDriver chromeDriver;
    private WebElement searchField;

    public TaskPageObject(WebDriver chromeDriver)
    {
        this.chromeDriver = chromeDriver;
        searchField = chromeDriver.findElement(By.className("gLFyf"));//поиск на странице по className элемента "поле ввода" и назначение его в searchField
    }

    public  void insert ()
    {
        searchField.click();//клик по полю для активации поля, чтобы вводить буквы
        searchField.sendKeys("Открытие" + Keys.ENTER);//виртуальные нажатия клавиш
    }
}
