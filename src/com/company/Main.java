package com.company;

import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.security.MessageDigest;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws IOException, JSONException, InterruptedException {

        RandomInfo randomInfo = new RandomInfo();
        //randomInfo.setEmail("vacive1870@coalamails.com");
        System.out.println(randomInfo.toString());

        SeleniumBot.doMagic(randomInfo);
        String md5mail = randomInfo.MD5(randomInfo.getEmail());

        System.out.println("Esperando recepción del correo...");
        TimeUnit.SECONDS.sleep(30);

        Response r = TempMail.contactarApi("https://privatix-temp-mail-v1.p.rapidapi.com/request/mail/id/"+ md5mail + "/");
        JSONArray ja = new JSONArray(r.body().string());
        String data = ja.get(2).toString();
        JSONObject jo = new JSONObject(data);

        String text = jo.get("mail_text").toString();


        String[] usernamePart = text.split("Your Username : ");
        String[] passwordPart = text.split("Your Password : ");

        String[] usernameBySpace = usernamePart[1].split("\n", 2);
        String[] passwordBySpace = passwordPart[1].split("\n", 2);

        System.out.println(usernameBySpace[0]);
        System.out.println(passwordBySpace[0]);
    }



}

