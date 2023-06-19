package com.selenium;

import java.lang.reflect.Method;

public class HybridFramework {
    public static KeywordMethods actionKeywords;
    public static String sActions;
    public static Method method[];

    public static void main(String[] args) throws Exception {
        String sPath = "C:\\Users\\saura\\Downloads\\Login Credentials.xlsx";

        ReadExcelKeyword.setExcelFile(sPath, "Sheet2");

        for (int i = 1; i <= 7; i++) {
            sActions = ReadExcelKeyword.getCellData(i, 1);
            execute_Actions();
        }
    }

    private static void execute_Actions() throws Exception {
        actionKeywords = new KeywordMethods();
        method = actionKeywords.getClass().getMethods();

        for (int i = 0; i < method.length; i++) {
            if (method[i].getName().equals(sActions)) {
                method[i].invoke(actionKeywords);
                break;
            }
        }
    }
}
