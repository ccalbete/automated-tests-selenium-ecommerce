import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.Header;
import pageObjects.MyAccountCustomerInfo;
import pageObjects.Register;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestRegistrarUsuario {
    private WebDriver driver;
    private Header elementsHeader;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://demo.nopcommerce.com/");
        elementsHeader = new Header(driver);
    }

    // @Test(dataProvider = "RegisterData", dataProviderClass = DataProviderClass.class)
    // public void registrarUsuario(User user) {
    //     paginaRegister.registrarUsuario(user);
    // };
    
    @Test(dataProvider = "RegisterData", dataProviderClass = DataProviderClass.class)
    public void registrarUsuario(char genero, String primerNombre, String segundoNombre, int diaNacimiento,
            String mesNacimiento, int anioNacimiento, String mail, String empresa, boolean newsLetter,
            String contrasenia) {
        Register paginaRegister = elementsHeader.entrarAPaginaRegister();
        assertTrue(paginaRegister.seMuestraElTitulo());
        paginaRegister.registrarUsuario(genero, primerNombre, segundoNombre, diaNacimiento, mesNacimiento,
                anioNacimiento, mail, empresa, newsLetter, contrasenia);
        assertEquals(paginaRegister.textoResultado(), "Your registration completed");
        paginaRegister.clickEnBotonContinuar();
        MyAccountCustomerInfo paginaMyAccountCustomerInfo = elementsHeader.entrarAPaginaMyAccountCustomerInfo();
        assertTrue(paginaMyAccountCustomerInfo.seMuestraElTitulo());
        assertEquals(paginaMyAccountCustomerInfo.generoSeleccionado(), genero);
        assertEquals(paginaMyAccountCustomerInfo.primerNombreIngresado(), primerNombre);
        assertEquals(paginaMyAccountCustomerInfo.segundoNombreIngresado(), segundoNombre);
        assertEquals(paginaMyAccountCustomerInfo.diaNacimientoIngresado(), diaNacimiento);
        assertEquals(paginaMyAccountCustomerInfo.mesNacimientoIngresado(), mesNacimiento);
        assertEquals(paginaMyAccountCustomerInfo.anioNacimientoIngresado(), anioNacimiento);
        assertEquals(paginaMyAccountCustomerInfo.mailIngresado(), mail);
        assertEquals(paginaMyAccountCustomerInfo.empresaIngresada(), empresa);
        assertEquals(paginaMyAccountCustomerInfo.valorNewsLetter(), newsLetter);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
