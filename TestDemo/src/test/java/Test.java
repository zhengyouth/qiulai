import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","E:\\webDriver\\chromedriverV2.28.exe");
        WebDriver driver =new ChromeDriver();
    }
}
