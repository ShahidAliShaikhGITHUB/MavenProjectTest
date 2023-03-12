package Page;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class tagNameExample {

    public static void main(String[] args) {
   	 System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
   	 WebDriver d=new FirefoxDriver();
   	 
d.get("https://demo.guru99.com/test/newtours/");

List<WebElement> links=d.findElements(By.tagName("a"));

System.out.println(links.size());
//Home and Flights

String[] linktext=new String[links.size()];
//linktext[0]="Home";
//linktext[1]="New";


int i=0;
for(WebElement e:links){
linktext[i]=e.getText(); // at 0th index first element text will be stored
i++;
}

/*for(int i=0;i<10;i++) {
    System.out.println();
}
*/
//linktext[0]=Home and linktext[1]=Flights


for(String t: linktext){
    d.findElement(By.linkText(t)).click();
    //System.out.println("First Value");
    String at=d.getTitle();
    if(at.equals("Under Construction: Mercury Tours")){
   	 System.out.println(t+" is not working");
    }else{
   	 System.out.println(t+" is  working");
    }
    d.navigate().back();
    
}
    }

}

