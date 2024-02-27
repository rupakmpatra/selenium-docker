package com.rupak.pages.flightreservation;

import com.rupak.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class FlightsSearchPage extends AbstractPage {
    @FindBy(id = "passengers")
    private WebElement passengerSelect;

    @FindBy(id = "search-flights")
    private WebElement searchFlightsButton;

    public FlightsSearchPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(this.searchFlightsButton));
        return this.searchFlightsButton.isDisplayed();
    }

    public void selectPassengers(String noOfPassengers){
        Select passengers = new Select(this.passengerSelect);
        passengers.selectByValue(noOfPassengers);
    }

    public void searchFlights(){
        //Actions actions = new Actions(driver);
        this.actions.moveToElement(this.searchFlightsButton).click().perform();
        //this.searchFlightsButton.click();
    }
}
