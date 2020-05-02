package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchResultPage extends BasePage {

    @FindBy(xpath = "//div[@class='g']//div[@class='r']//h3[@class='LC20lb DKV0Md']")
    private WebElement resultRow;

    @FindBy(xpath = "//div[@class='g']//div[@class='r']//h3[@class='LC20lb DKV0Md']")
    private List<WebElement> resultRows;

    public SearchResultPage() {
        super();
    }

    public void assertThatTopResultContainsCorrectText(String expected) {
        //  wait.until(ExpectedConditions.visibilityOfAllElements(resultRows));

        wait.until(ExpectedConditions.visibilityOf(resultRows.get(0)));

        assertThat(resultRows.stream().map(e -> e.getText()).collect(Collectors.toList()).toString())
                .as("Wrong text was displayed!").contains(expected);
    }

    public void assertThatTopResultContainsProperAttributeText(String expected) {
        assertThat(resultRow.getAttribute("class")).as("Wrong attribute was displayed!").contains(expected);

    }


}
