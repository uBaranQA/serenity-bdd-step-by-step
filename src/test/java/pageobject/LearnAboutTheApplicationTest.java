package pageobject;

import net.thucydides.core.annotations.ManagedPages;
import org.junit.Test;
import pageobject.pages.HomePage;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;


public class LearnAboutTheApplicationTest extends BaseTest {

    @ManagedPages
    HomePage homePage;

    @Test
    public void should_be_able_to_identify_the_aplication() {
        assertThat(homePage.getPageTitle(), equalToIgnoringCase("Vanilla ES6 • TodoMVC"));
        assertThat(homePage.getHeading(), equalToIgnoringCase("todos"));
        assertThat(homePage.getFooter(), containsString("Written by "));
    }

    @Test
    public void should_see_how_to_begin() {
        assertThat(homePage.getPlaceholder(), equalToIgnoringCase("What needs to be done?"));
    }
}
