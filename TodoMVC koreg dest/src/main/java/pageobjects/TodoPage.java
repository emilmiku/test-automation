package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;


public class TodoPage {
    // https://todomvc.com/examples/emberjs/todomvc/dist/
    WebDriver driver;
    @FindBy(css = "input.new-todo")
    private WebElement todoInput;
    @FindBy(css = "ul.todo-list")
    private WebElement todoList;


    public TodoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openPage() {
        driver.get("https://todomvc.com/examples/emberjs/todomvc/dist/");
    }
    public void add(String... texts) {
        //kad daug stringu ptridet gali but (String...)
        for (String text : texts) {
            todoInput.sendKeys(text + Keys.ENTER);
        }

    }
    public List<String> get() {
        List<WebElement> labels = todoList.findElements(By.cssSelector("label"));
        ArrayList<String> labelTexts = new ArrayList<>();
        for(WebElement label : labels) {
            labelTexts.add(label.getText());
        }
        return labelTexts;
    }
    public List<String> getCompleted() {
        List<WebElement> labels = todoList.findElements(By.cssSelector("li.completed label"));
        ArrayList<String> labelTexts = new ArrayList<>();
        for(WebElement label : labels) {
            labelTexts.add(label.getText());
        }
        return labelTexts;
    }
    public List<String> getActive() {
        List<WebElement> labels = todoList.findElements(By.cssSelector("li:not(.completed) label"));
        ArrayList<String> labelTexts = new ArrayList<>();
        for(WebElement label : labels) {
            labelTexts.add(label.getText());
        }
        return labelTexts;
    }
    public void toggle(String name) {
        todoList.findElement(By.xpath("//label[text()=" + "'" + name + "'" + "]/preceding-sibling::input[@class='toggle']"))
                .click();
    }

}
