package test1;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TaskTest extends BaseTaskTest
{
    @Test
    public void gladiolus()
    {
        chromeDriver.get("https://www.google.com/");
        WebElement searchField = chromeDriver.findElement(By.className("gLFyf"));//поиск поля для ввода по className

        searchField.click();//клик по полю для активации поля, чтобы вводить буквы
        searchField.sendKeys("Гладиолус"+ Keys.ENTER);//виртуальные нажатия клавиш

        List<WebElement> resaultSearch = chromeDriver.findElements(By.partialLinkText("https://ru.wikipedia.org"));
        //создание списка с типом данных WebElement для помещения в него элементов, найденных по фрагменту ссылки

        //Вариант с xpath
        //List<WebElement> resaultSearch = chromeDriver.findElements(By.xpath("//a[@href='https://ru.wikipedia.org/wiki/%D0%A8%D0%BF%D0%B0%D0%B6%D0%BD%D0%B8%D0%BA']"));
//      //создание списка с типом данных WebElement для помещения в него элементов, найденных по xpath

        System.out.println(resaultSearch.size());//вывод размерности списка
        resaultSearch.stream().forEach(x-> System.out.println(x));
        //создание потока для вывода из списка элементов списка указывающих на найденное
    }

    @Feature("Поиск Гладиолуса")
    @DisplayName("Проверка результатов поиска c помощью PO")
    @ParameterizedTest(name="{displayName} {arguments}")
    @CsvSource({"Гладиолус, https://ru.wikipedia.org"})
    public void testPO(String keyWords,String result)
    {
        chromeDriver.get("https://www.google.com/");//браузер получает адрес страницы
        TaskBeforeSearch  taskBeforeSearch = new TaskBeforeSearch (chromeDriver);//создание объекта и передача в его конструктор аргумента-браузера-страницы
        taskBeforeSearch.find(keyWords);//поиск методом find класса TaskBeforeSearch на странице переданного в параметре теста значения "Гладиолус"
        TaskAfterSearch taskAfterSearch = new TaskAfterSearch(chromeDriver);//создание объекта и передача в его конструктор аргумента-браузера-страницы
        Assertions.assertTrue(taskAfterSearch.getResults().stream().anyMatch(x->x.getText().contains(result)),"Википедия не найдена");
        //объект taskAfterSearch с помощью метода getResults() передаёт в поток список объектов класса WebElement найденных по xpath
        //anyMatch вернёт true если хотя бы один объект-текст совпадёт со вторым значением параметризированного теста - result. иначе текст ошибки
    }

    @Feature("Поиск Гладиолуса")
    @Test
    public void testPF()
    {
        TaskPageFactory taskPageFactory = PageFactory.initElements(chromeDriver,TaskPageFactory.class);//инициализация элементов страницы через
        //PageFactory для объекта класса TaskPageFactory
        taskPageFactory.find("Гладиолус");//вызов метода поиска с передачей аргумента для поиска
        System.out.println(taskPageFactory.getAllElements().size());//вызов метода возвращающего список объектов типа WebElement
        //найденный по xpath аннотацией @FindBy
    }
}
