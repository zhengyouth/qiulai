import com.sun.deploy.util.SyncAccess;
import org.apache.commons.io.FileUtils;
import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.html5.LocalStorage;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TestDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();//chromedriver已经配置环境变量了
        driver.get("https://www.zhihu.com/signup?next=%2F");
        driver.manage().deleteAllCookies(); //删除所有的cookies信息
        String currentURl = driver.getCurrentUrl();//获取当前的url
        System.out.println("currentURl :" + currentURl);
        //设置cookies信息并添加到cookie中实现自动登录（应用扫码登录的cookies）
        Cookie cook6 = new Cookie("z_c0","\"2|1:0|10:1549689264|4:z_c0|92:Mi4xc2pmVUF3QUFBQUFBRUtNekNqXzBEaWNBQUFDRUFsVk5zTzZGWEFCNWFmNGRYdDhqcksxRzlULVpQOS1ISkVhQnh3|4921cec661a36f284edef605b4578df58a587ed0010c99ef71f80794ba4e5185\"");
        driver.manage().addCookie(cook6);
        //获取cookie信息的方法
        System.out.println(driver.manage().getCookies().size());
        Set<Cookie> cookies = driver.manage().getCookies();
        Iterator<Cookie> iterator = cookies.iterator();
        int a = 1;
        while (iterator.hasNext()){
            Cookie cookie = iterator.next();
            System.out.println(a);
            System.out.println("cookie.getName():" +cookie.getName());
            System.out.println("cookie.getValue():" +cookie.getValue());
            a++;
        }
        driver.navigate().refresh();
        driver.manage().window().maximize();
        System.out.println(driver.manage().window().getPosition());
        File screen = ((ChromeDriver) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screen,new File("/home/qiulai/Downloads/000.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
