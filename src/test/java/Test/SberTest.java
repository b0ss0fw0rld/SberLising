package Test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pro.sberlising.base.TestBase;
import pro.sberlising.pages.GooglePage;
import pro.sberlising.pages.SberLisingPage;

public class SberTest extends TestBase{
    private GooglePage googlePage;
    private SberLisingPage sberLisingPage;

    @BeforeClass
    public void setUp(){
        createBrowser();
        googlePage = new GooglePage(driver);
        sberLisingPage = new SberLisingPage(driver);
    }

    @Test
    public void carSelection(){
        googlePage.openGooglePage();
        googlePage.setTextInGoogleSearch("СберЛизинг");
        googlePage.clickSearch();
        googlePage.openSberLeasingSite();
        sberLisingPage.openAutoInStock();
        sberLisingPage.setCity("Москва");
        sberLisingPage.setBrand("BMW");
        sberLisingPage.setModel("5 серия");
        sberLisingPage.setPriceCar("6000000");
        sberLisingPage.setTypeDrive("полный");
        sberLisingPage.setTransmission("автомат");
        sberLisingPage.setBodyType("седан");
        sberLisingPage.setFuelType("дизель");
        sberLisingPage.setColor("черный");
        sberLisingPage.clickShowAllOffers();
        String carModel = sberLisingPage.getCarModelFromListOffer();
        sberLisingPage.openOffer();
        Assert.assertTrue(sberLisingPage.getCarModelFromOffer().contains(carModel));





    }
}
