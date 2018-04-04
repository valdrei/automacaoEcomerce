package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjects {
	
	static WebDriver driver;
	static WebDriverWait wait;
	
	public PageObjects(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 15);
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("h_search-input")));
		driver.findElement(By.id("h_search-input")).sendKeys(itemBusca);
		driver.findElement(By.id("h_search-btn")).click();

	}
	
	public void selecionarItem() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("card-product-name")));
		driver.findElement(By.className("card-product-name")).click();
	}
	
	public void preencherDadosEntrega(String cep, String numero, String pontoRef) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btn-buy")));
		driver.findElement(By.className("btn-buy")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buy-button")));
		driver.findElement(By.id("buy-button")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("edit-cep")));
		driver.findElement(By.id("edit-cep")).sendKeys(cep);
		driver.findElement(By.className("btn display-xs-block btn-success ng-binding")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("edit-number")));
		driver.findElement(By.id("edit-number")).sendKeys(numero);
		driver.findElement(By.id("edit-reference")).sendKeys(pontoRef);
		driver.findElement(By.className("btn display-xs-block btn-success ng-binding")).click();		
	}
	
	public void preencherDadosPagamento() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("card-product-name")));
		driver.findElement(By.className("card-product-name")).click();
	}

}
