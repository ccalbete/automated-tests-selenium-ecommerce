package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Register extends ElementsDataUser{

    @FindBy(id = "Password")
    protected WebElement contrasenia;

    @FindBy(id = "ConfirmPassword")
    protected WebElement confirmacionContrasenia;

    @FindBy(id = "register-button")
    private WebElement botonRegistrar;

    @FindBy(className = "result")
    private WebElement mensajeResultado;

    @FindBy(xpath = "//input[@value='Continue']")
    private WebElement botonContinuar;

    public Register(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean seMuestraElTitulo(){
        return titulo.isDisplayed();
    }

    //registrar usuario ingresando todos los datos
    public void registrarUsuario(char genero, String primerNombre, String segundoNombre, int diaNacimiento, String mesNacimiento
    , int anioNacimiento, String mail, String empresa, boolean newsLetter, String contrasenia){
        if(Character.toUpperCase(genero) == 'M' ){
            generoMasculino.click();
        }else if (Character.toUpperCase(genero) == 'F' ){
            generoFemenino.click();
        }
        this.primerNombre.sendKeys(primerNombre);
        this.segundoNombre.sendKeys(segundoNombre);
        this.diaNacimiento.selectByValue(Integer.toString(diaNacimiento));
        this.mesNacimiento.selectByVisibleText(mesNacimiento);
        this.anioNacimiento.selectByValue(Integer.toString(anioNacimiento));
        this.mail.sendKeys(mail);
        this.empresa.sendKeys(empresa);
        if(!newsLetter){
            this.newsLetter.click();
        }
        this.contrasenia.sendKeys(contrasenia);
        this.confirmacionContrasenia.sendKeys(contrasenia);
        this.botonRegistrar.submit();
    }

    public String textoResultado(){
        return mensajeResultado.getText();
    }

    public void clickEnBotonContinuar(){
        botonContinuar.click();
    }



}
