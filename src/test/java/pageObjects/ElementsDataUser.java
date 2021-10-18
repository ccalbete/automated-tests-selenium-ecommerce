package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ElementsDataUser {
    protected WebDriver driver;

    @FindBy(tagName = "h1")
    protected WebElement titulo;

    @FindBy(id = "gender-male")
    protected WebElement generoMasculino;

    @FindBy(id = "gender-female")
    protected WebElement generoFemenino;

    @FindBy(id = "FirstName")
    protected WebElement primerNombre;

    @FindBy(id = "LastName")
    protected WebElement segundoNombre;

    protected Select diaNacimiento;
    protected Select mesNacimiento;
    protected Select anioNacimiento;

    @FindBy(id = "Email")
    protected WebElement mail;

    @FindBy(id = "Company")
    protected WebElement empresa;

    @FindBy(id = "Newsletter")
    protected WebElement newsLetter;


    public ElementsDataUser(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.diaNacimiento = new Select(driver.findElement(By.name("DateOfBirthDay")));
        this.mesNacimiento = new Select(driver.findElement(By.name("DateOfBirthMonth")));
        this.anioNacimiento = new Select(driver.findElement(By.name("DateOfBirthYear")));
    }


}
