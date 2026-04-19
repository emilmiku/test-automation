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
    // https://todomvc.com/examples/emberjs/todomvc/dist/
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
        // add todos: "a", "b", "c"
        todoPage.addTodo("a");
        todoPage.addTodo("b");
        todoPage.addTodo("c");
        // cia galima kad priimtu daug stringu todoPage.addTodo("a", "b", "c");
        // todos should be "a", "b", "c"
        List<String> expected1 = List.of("a", "b", "c");
        List<String> actua'l1 = todoPage.getTodos();
        Assertions.assertThat(actual1).isEqualTo(expected1);
        // toggle b
        todoPage.toggleTodo("b");
        // completed todos should be b
        List<String> expected2 = List.of("b");
        List<String> actual2 = todoPage.getCompletedTodos();
        Assertions.assertThat(actual2).isEqualTo(expected2);
        // active todos should be a, c
        List<String> expected3 = List.of("a", "c");
        List<String> actual3 = todoPage.getActiveTodos();
        Assertions.assertThat(actual3).isEqualTo(expected3);
    }

}
