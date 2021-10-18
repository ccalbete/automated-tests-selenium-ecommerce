package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header {

    private WebDriver driver;

    @FindBy(partialLinkText="Register")
    private WebElement register;

    @FindBy(partialLinkText="My account")
    private WebElement myAccount;

    public Header(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Register entrarAPaginaRegister(){
        register.click();
        return new Register(this.driver);
    }

    public MyAccountCustomerInfo entrarAPaginaMyAccountCustomerInfo(){
        myAccount.click();
        return new MyAccountCustomerInfo(this.driver);
    }

}
