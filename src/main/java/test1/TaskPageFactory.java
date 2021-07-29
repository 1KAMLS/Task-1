package test1;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class TaskPageFactory
{
    private WebDriver chromeDriver;
    private String url="https://www.google.com/";

    public TaskPageFactory(WebDriver chromeDriver)
    {
    this.chromeDriver=chromeDriver;
    chromeDriver.get(url);
    }


    @FindBy(how= How.CLASS_NAME, className="gLFyf")
    WebElement searchField;

    @FindBy(how= How.PARTIAL_LINK_TEXT, using = "https://ru.wikipedia.org")
    //Вариант с xpath
    //@FindBy(how= How.XPATH, using = "//a[@href='https://ru.wikipedia.org/wiki/%D0%A8%D0%BF%D0%B0%D0%B6%D0%BD%D0%B8%D0%BA']")
    List<WebElement> allElements;



    public  void find (String keysFind){
        searchField.click();//аннотированный на поиск объект класса WebElement кликает по найденному через элементу
        searchField.sendKeys(keysFind+ Keys.ENTER);
        //аннотированный на поиск объект класса WebElement вставляет в найденный элемент строку и нажимает ENTER
    }

    public List<WebElement> getAllElements() {
        return allElements;
    }
}
