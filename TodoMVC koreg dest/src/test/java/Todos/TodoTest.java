package Todos;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.TodoPage;

import java.util.List;

public class TodoTest {
    WebDriver driver;
    TodoPage todoPage;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        todoPage = new TodoPage(driver);
        todoPage.openPage();
    }
    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    void todoTest() {

        todoPage.add("a", "b", "c");

        Assertions.assertThat(todoPage.get()).containsExactly( "a", "b", "c");

        todoPage.toggle("b");

        Assertions.assertThat(todoPage.getCompleted()).containsExactly("b");
        Assertions.assertThat(todoPage.getActive()).containsExactly("a", "c");

        /// biski neveikia


    }

}
