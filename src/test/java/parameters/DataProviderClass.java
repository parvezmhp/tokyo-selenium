package parameters;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderClass {
    @DataProvider(name = "SingleValue")
    public Object [][] storeSingleValue() {
        return new Object[][]{
                {"Rifat"},
                {"Mohammed"},
                {"Ashraf"}
        };
    }

    @DataProvider(name = "MultipleValues")
        public Object[][] storeMultipleValues() {
        return new Object[][] {
                {"Rifat", "Florida", 45751},
                {"Mohammed", "New York", 45741},
                {"Ashraf", "Texas", 12454}
        };
    }

   @DataProvider(name = "RealAPRRates")
    public Object[][] storeRealAprRates() {
        return new Object[][] {
                {"200000", "15000", "3", "3.130%"}
        };
    }

    @Test(dataProvider = "SingleValue")
        public void readSingleValue(String name) {
        System.out.println("[Single Column Value] Name is: "+ name);
        }

    @Test(dataProvider = "MultipleValues")
    public void readMultipleValues(String name, String state, int zipCode) {
        System.out.println("[Multiple Column Value] Name is: " + name);
        System.out.println("[Multiple Column Value] State is: " + state);
        System.out.println("[Multiple Column Value] Zip Code is: " + zipCode);
        }
    }

