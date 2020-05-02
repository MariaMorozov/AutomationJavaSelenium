package tests;

import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test(dataProvider = "dataProvider")
    public void openGoogleComTest(String text) throws InterruptedException {
        steps.executeSearchByKeyword(text)
                .verifyThatTopResultContainsCorrectText("selenium")
                .verifyThatTopResultContainsProperAttributeText("LC20lb DKV0Md");


    }


}
