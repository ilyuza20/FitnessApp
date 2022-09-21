package com.example.fitnessapp.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage  {

    private   WebDriver driver;

    public LoginPage() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\днс\\Downloads\\chromedriver_win322\\chromedriver.exe");
        this.driver = new ChromeDriver();
    }

    public void setMyProject(){
        this.driver.get("http://localhost:8082/login");
    }
    public void enterLogin(String login){
        this.driver.findElement(By.name("username")).sendKeys(login);
    }
    public void enterPassword(String password){
        this.driver.findElement(By.name("password")).sendKeys(password);
    }
    public void clickBtn(){
        this.driver.findElement(By.id("auth")).click();
    }
    public void check() {
        Assert.assertEquals("http://localhost:8082/home", this.driver.getCurrentUrl());
    }
}
