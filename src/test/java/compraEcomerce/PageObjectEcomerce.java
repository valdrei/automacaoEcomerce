package compraEcomerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjectEcomerce {

	private WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, 15);
	

	public PageObjectEcomerce(WebDriver driver) {
		this.driver = driver;
	}
	
	public void paginaInicial(String url) {
		driver.get(url);

	}
	
	public void selecionarLogin() {
		driver.findElement(By.id("h_usr-link")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("h_usr-signin")));
		driver.findElement(By.id("h_usr-signin")).click();

	}
		 
	public void autentica(String usuario, String senha) {
		driver.findElement(By.id("email-input")).sendKeys(usuario);
		driver.findElement(By.id("password-input")).sendKeys(senha);
		driver.findElement(By.id("login-button")).click();

	}
	
	public void realizarBusca(String itemBusca) {
		driver.findElement(By.id("h_search-input")).sendKeys(itemBusca);

	}
	
		 

}
