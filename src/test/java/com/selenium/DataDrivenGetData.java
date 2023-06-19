package com.selenium;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenGetData {
    @Test(dataProvider = "getData")
    public void setData(String username, String password) {
        System.out.println("your username: " + username);
        System.out.println("your password: " + password);
    }

    @DataProvider
    public Object[][] getData() {
        Object[][] data = new Object[3][2];
        data[0][0] = "user1";
        data[0][1] = "abcde";
        data[1][0] = "user2";
        data[1][1] = "xyz";
        data[2][0] = "user3";
        data[2][1] = "12345";
        return data;
    }
}
