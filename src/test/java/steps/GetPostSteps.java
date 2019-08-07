package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class GetPostSteps {

    @Given("^I perform GET operation \"([^\"]*)\"$")
    public void iPerformGETOperation(String arg0) throws Throwable {
    }

    @And("^I perform GET for the post number \"([^\"]*)\"$")
    public void iPerformGETForThePostNumber(String petID) throws Throwable {
        BDDStyleMethod.simpleGETPost(petID);
    }

    @Then("^I should see the author name as \"([^\"]*)\"$")
    public void iShouldSeeTheAuthorNameAs(String arg0) throws Throwable {
    }


    @Given("^I perform GET a operation \"([^\"]*)\"$")
    public void iPerformGETAOperation(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    }


    @And("^I perform GET for status \"([^\"]*)\"$")
    public void iPerformGETForStatus(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    }

    @Then("^I should see the pets names \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iShouldSeeThePetsNamesAnd(String pet1, String pet2) throws Throwable {
        BDDStyleMethod.performContainsCollection(pet1,pet2);
    }


}
