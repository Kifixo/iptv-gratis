package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumBot {
    public static void doMagic(RandomInfo info) {
        TempMail tempmail = new TempMail();
       //tempmail.go();

        ChromeDriver driver=new ChromeDriver();
        driver.get("https://myiptv.services/cart.php?a=add&pid=2");
        WebElement firstname = driver.findElement(By.xpath("//input[@name='firstname']"));
        WebElement lastname = driver.findElement(By.xpath("//input[@name='lastname']"));
        WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
        WebElement phonenumber = driver.findElement(By.xpath("//input[@name='phonenumber']"));
        WebElement companyname = driver.findElement(By.xpath("//input[@name='companyname']"));
        WebElement address1 = driver.findElement(By.xpath("//input[@name='address1']"));
        WebElement address2 = driver.findElement(By.xpath("//input[@name='address2']"));
        WebElement city = driver.findElement(By.xpath("//input[@name='city']"));
        WebElement country = driver.findElement(By.xpath("//select[@name='country']"));
        WebElement postcode = driver.findElement(By.id("inputPostcode"));
        WebElement state = driver.findElement(By.id("stateinput"));
        WebElement password = driver.findElement(By.id("inputNewPassword1"));
        WebElement password2 = driver.findElement(By.id("inputNewPassword2"));
        WebElement checkbox = driver.findElement(By.id("iCheck-accepttos"));

        firstname.sendKeys(info.getNombre());
        lastname.sendKeys(info.getApellido());
        email.sendKeys(info.getEmail());
        phonenumber.sendKeys(info.getNumeroTelefono());
        companyname.sendKeys(info.getCompania());
        address1.sendKeys(info.getDireccion1());
        address2.sendKeys(info.getDireccion2());
        city.sendKeys(info.getDireccion2());
        Select select = new Select(country);
        select.selectByVisibleText("Yemen");
        postcode.sendKeys(info.getnPostal());
        password.sendKeys(info.getContrasenya());
        password2.sendKeys(info.getContrasenya());
        state.sendKeys(info.getEstado());
        checkbox.click();

        WebElement button=driver.findElement(By.id("btnCompleteOrder"));
        button.click();

        //driver.close();


    }
}
