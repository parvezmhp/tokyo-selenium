package playground;

import org.testng.annotations.Test;
import parameters.DataProviderClass;

public class ExecuteTest {
    @Test(dataProvider = "MultipleValues", dataProviderClass = DataProviderClass.class)
    public void run(String name, String state, int zipCode) {
        System.out.println("[Multiple Column Value] Name is: " + name);
        System.out.println("[Multiple Column Value] State is: " + state);
        System.out.println("[Multiple Column Value] Zip Code is: " + zipCode);
    }
}
