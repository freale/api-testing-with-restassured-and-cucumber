package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import utilities.RestAssuredExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class GetPostSteps {

    private static ResponseOptions<Response> response;

    @Given("^I perform GET operation \"([^\"]*)\"$")
    public void iPerformGETOperation(String url) throws Throwable {
        response = RestAssuredExtension.getOps(url);
    }


    @Then("^I should see the author name as \"([^\"]*)\"$")
    public void iShouldSeeTheAuthorNameAs(String authorName) throws Throwable {
        assertThat(response.getBody().jsonPath().get("name"), is(authorName));
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


    @Given("^I perform GET operation$")
    public void iPerformGETOperation() {
        BDDStyleMethod.performPathParameter("1");
    }

    @Then("^I should see verify GET Parameter$")
    public void iShouldSeeVerifyGETParameter() {
        BDDStyleMethod.performQueryParameter( "doggie","Charlie");
    }

    @Given("^I perform a POST operation for the store$")
    public void iPerformAPOSTOperationForTheStore() {
        BDDStyleMethod.performPOSTWithBodyParameter();
    }
}
