package tickets;

import homework.tvnetpo.pages.BaseFunctions;
import org.openqa.selenium.By;

public class HomePage {

    private final By DEPARTURE_ID = By.id("afrom");
    private final By DESTINATION_ID = By.id("bfrom");
    private final By GO_BUTTON = By.xpath(".//span[@class = 'gogogo']");
    private BaseFunctions baseFunctions;


    public HomePage(BaseFunctions baseFunctions) {
        this.baseFunctions = baseFunctions;
    }

    public void selectAirports(String departure, String arrival) {
        baseFunctions.select(DEPARTURE_ID, departure);
        baseFunctions.select(DESTINATION_ID, arrival);
    }

    public void pressGoButton() {
        baseFunctions.click(GO_BUTTON);
    }
}
