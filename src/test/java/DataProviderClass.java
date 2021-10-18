import java.util.Date;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

    @DataProvider(name="RegisterData")
    public Object[][] getRegisterData(){
        // User user1 = new User();
        // user.setName("");

        Date now = new Date();
        return new Object[][]{
            // user1, usuer2
                {
                    'F',
                    "Cinthya",
                    "Paula",
                    10,
                    "April",
                    1998,
                    "a" + now.getTime() + "@gmail.com",
                    "la empresa",
                    true,
                    "laContrasenia"
                },
                {
                    'M',
                    "Camilo",
                    "Thiago",
                    15,
                    "June",
                    1980,
                    "b" + now.getTime() + "@gmail.com",
                    "la empresa2",
                    false,
                    "laContrasenia2"
                }
        };
    }
}


