package com.selenium;

public class KeywordDrivenDemo {
    public static void main(String[] args) throws Exception {

        String sPath = "C:\\Users\\saura\\Downloads\\Login Credentials.xlsx";

        ReadExcelKeyword.setExcelFile(sPath, "Sheet2");

        for (int i = 1; i <= 7; i++) {
            String sActions = ReadExcelKeyword.getCellData(i, 1);
            if (sActions.equals("openBrowser")) {
                KeywordMethods.openBrowser();
            } else if (sActions.equals("navigate")) {
                KeywordMethods.navigate();
            } else if (sActions.equals("input_Username")) {
                KeywordMethods.input_Username();
            } else if (sActions.equals("input_password")) {
                KeywordMethods.input_password();
            } else if (sActions.equals("click_Login")) {
                KeywordMethods.click_Login();
            } else if (sActions.equals("verify_login")) {
                KeywordMethods.verify_login();
            } else if (sActions.equals("closeBrowser")) {
                KeywordMethods.closeBrowser();
            }
        }
    }
}
