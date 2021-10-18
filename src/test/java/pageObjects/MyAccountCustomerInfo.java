package pageObjects;

import org.openqa.selenium.WebDriver;

public class MyAccountCustomerInfo extends ElementsDataUser{

    public MyAccountCustomerInfo(WebDriver driver){
        super(driver);
    }

    public boolean seMuestraElTitulo(){
        return titulo.isDisplayed();
    }

    public char generoSeleccionado(){
        if(this.generoMasculino.isSelected()){
            return 'M';
        }else{
            return 'F';
        }
    }

    public String primerNombreIngresado(){
        return primerNombre.getAttribute("value");
    }

    public String segundoNombreIngresado(){
        return segundoNombre.getAttribute("value");
    }

    public int diaNacimientoIngresado(){
        return Integer.parseInt(diaNacimiento.getFirstSelectedOption().getText());
    }

    public String mesNacimientoIngresado(){
        return mesNacimiento.getFirstSelectedOption().getAttribute("value");
    }

    public int anioNacimientoIngresado(){
        return Integer.parseInt(anioNacimiento.getFirstSelectedOption().getAttribute("value"));
    }

    public String mailIngresado(){
        return mail.getAttribute("value");
    }

    public String empresaIngresada(){
        return empresa.getAttribute("value");
    }

    public boolean valorNewsLetter(){
        return newsLetter.isSelected();
    }

}
