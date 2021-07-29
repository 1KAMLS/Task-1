package test2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TaskTest extends BaseTaskTest
{
    @Test
    public void otkrytie()//простой тест по Банку Открытие
    {
        chromeDriver.get("https://www.google.com/");
        WebElement searchField = chromeDriver.findElement(By.className("gLFyf"));

        searchField.click();//клик по полю для активации поля, чтобы вводить буквы
        searchField.sendKeys("Открытие"+ Keys.ENTER);//виртуальные нажатия клавиш

        WebElement resaultSearch = chromeDriver.findElement(By.xpath("//a[@href='https://www.open.ru/']"));

        resaultSearch.click();
        List<String> spanText= new ArrayList<>();
        List<Double> spanDoudle=new ArrayList<>();
        List<WebElement>resaulSearch=chromeDriver.findElements((By.xpath("//*[@class='main-page-exchange__row main-page-exchange__row--with-border']//*[@class='main-page-exchange__rate']")));

        for(WebElement w : resaulSearch)
            spanText.add((w.getText()).replace(",","."));

        for (String s: spanText)
            spanDoudle.add(Double.parseDouble(s));

        Assertions.assertTrue(spanDoudle.get(0)<spanDoudle.get(1));
        Assertions.assertTrue(spanDoudle.get(2)<spanDoudle.get(3));
    }
    @Test
    public void testPO()
    {
        chromeDriver.get("https://www.google.com/");//браузер получает адрес страницы

        TaskPageObject taskPageObject=new TaskPageObject(chromeDriver);//создание объекта с передачей туда браузера
        taskPageObject.insert();//вставка в поле ввода слова "Открытие" и переход

        TaskPageObjectSupport taskPageObjectSupport=new TaskPageObjectSupport(chromeDriver);//создание объекта с передачей туда браузера
        taskPageObjectSupport.find();//поиск нужных элементов и копирование их в список
        assertTrue(taskPageObjectSupport.getResults(0,1));//проверка неравенства покупки и продажи долларов
        assertTrue(taskPageObjectSupport.getResults(2,3));//проверка неравенства покупки и продажи евро
    }
}
