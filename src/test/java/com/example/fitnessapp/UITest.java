package com.example.fitnessapp;

import com.example.fitnessapp.pages.LoginPage;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FitnessappApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class UITest {

        @Test
        public void SignIn1() throws InterruptedException {
            LoginPage loginPage=new LoginPage();
            loginPage.setMyProject();
            loginPage.enterLogin("user4");
            loginPage.enterPassword("qwerty011");
            loginPage.clickBtn();
            Thread.sleep(10000);
            loginPage.check();
        }



}