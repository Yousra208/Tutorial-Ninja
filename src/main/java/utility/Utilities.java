package utility;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

public class Utilities {
    public static int generateRandomInteger(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("The minimum value must be less than or equal to the maximum value.");
        }
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public static void main(String[] args) {
        int randomInteger = generateRandomInteger(10, 20);
        System.out.println("The random integer is: " + randomInteger);
    }

    //TODO CAPTURE SCREENSHOT
    public static void captureScreenshot(WebDriver driver, String screenshotName) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        Date currntDate = new Date();
        String screenshot = screenshotName + currntDate.toString().replace(" ", "-").replace(":", "-");
        try {
            FileHandler.copy(takesScreenshot.getScreenshotAs(OutputType.FILE), new File(System.getProperty("user.dir") + "/src/test/resources/screenshots/" + screenshot + ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static float removeFirstLetterAndGetFloat(String str) {
        // Check if the string is empty or null.
        if (str == null || str.isEmpty()) {
            return 0f;
        }

        // Remove the first letter from the string.
        String remainingStr = str.substring(1);
        // Try to convert the remaining string to a float.
        try {
            return Float.parseFloat(remainingStr);
        } catch (NumberFormatException e) {
            // If the conversion fails, return 0f.
            return 0f;
        }
    }

    //read data from json file
    public static String getData(String jsonPath, String field) {
        try{
        //define object of json parser
        JSONParser parser = new JSONParser();
        //define object of file reader
        FileReader reader = new FileReader(jsonPath);
        Object object = parser.parse(reader);
        JSONObject jsonObject = (JSONObject) object;
        return jsonObject.get(field).toString();}
        catch (Exception e){
        e.printStackTrace();
        }
        return "";
    }

    // TODO: Read Data From Excel Sheet
    public static String getExcelData(int RowNum, int ColNum, String SheetName) {
        XSSFWorkbook workBook;
        XSSFSheet sheet;
        String projectPath = System.getProperty("user.dir");
        String cellData = null;
        try {
            workBook = new XSSFWorkbook(projectPath + "/src/test/resources/data/logindata.xlsx");
            sheet = workBook.getSheet(SheetName);
            cellData = sheet.getRow(RowNum).getCell(ColNum).getStringCellValue();

        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            e.printStackTrace();
        }
        return cellData;
    }

}
