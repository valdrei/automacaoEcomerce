package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjects {

	static WebDriver driver;
	static WebDriverWait wait;

	public PageObjects(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 15);
	}

	// método para abrir a URL desejada.
	public void paginaInicial(String url) {
		driver.get(url);

	}

	// método que seleciona a opção de login.
	public void selecionarLogin() {
		driver.findElement(By.id("h_usr-link")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("h_usr-signin")));
		driver.findElement(By.id("h_usr-signin")).click();

	}

	// método que insere usuário e senha e realiza o login.
	public void autentica(String usuario, String senha) {
		Integer i = 0;
		driver.findElement(By.id("email-input")).clear();
		String usuarioAtual = driver.findElement(By.id("email-input")).getAttribute("value");
		System.out.println(usuarioAtual);
		while (i == 0) {
			driver.findElement(By.id("email-input")).clear();
			driver.findElement(By.id("email-input")).sendKeys(usuario);
			usuarioAtual = driver.findElement(By.id("email-input")).getAttribute("value");
			if (usuarioAtual.equals(usuario)) {
				driver.findElement(By.id("password-input")).sendKeys(senha);
				driver.findElement(By.id("login-button")).click();
				i = 1;
			} else {
				driver.findElement(By.id("email-input")).clear();
				driver.findElement(By.id("email-input")).click();
				driver.findElement(By.id("email-input")).sendKeys(usuario);
				usuarioAtual = driver.findElement(By.id("email-input")).getAttribute("value");
			}

		}

	}

	// método que busca por um item desejado.
	public void realizarBusca(String itemBusca) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("h_search-input")));
		driver.findElement(By.id("h_search-input")).sendKeys(itemBusca);
		driver.findElement(By.id("h_search-btn")).click();

	}

	// método que seleciona um item da lista de itens buscados.
	public void selecionarItem() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("card-product-name")));
		driver.findElement(By.className("card-product-name")).click();
	}

	// método que aciona o botão comprar.
	public void acionarBotaoComprar(String cep, String numero, String pontoRef) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btn-buy")));
		driver.findElement(By.className("btn-buy")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buy-button")));
		driver.findElement(By.id("buy-button")).click();
		/*
		 * if(!driver.findElement(By.id("CONVENTIONAL-menu-item-input")).isDisplayed())
		 * {
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("edit-cep")));
		 * driver.findElement(By.id("edit-cep")).clear();
		 * driver.findElement(By.id("edit-cep")).sendKeys(cep);
		 * driver.findElement(By.id("edit-cep")).sendKeys(Keys.TAB);
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("edit-number")
		 * )); driver.findElement(By.id("edit-number")).click();
		 * driver.findElement(By.id("edit-number")).sendKeys(numero);
		 * driver.findElement(By.id("edit-reference")).sendKeys(pontoRef);
		 * driver.findElement(By.id("edit-cep")).sendKeys(Keys.ENTER); }
		 */

	}

	// método que preenche os dados de pagamento (utilizando cartão de crédito).
	public void preencherDadosPagamento(String numeroCartao, String nomeCartao, String mesCartao, String anoCartao,
			String codCartao, String parcelas) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.tagName("a")).sendKeys(Keys.PAGE_DOWN);
		driver.findElement(By.tagName("a")).sendKeys(Keys.PAGE_DOWN);
		driver.findElement(By.id("creditCard-cardNumber")).clear();
		driver.findElement(By.id("creditCard-cardNumber")).sendKeys(numeroCartao);
		driver.findElement(By.id("creditCard-nameOnCard")).clear();
		driver.findElement(By.id("creditCard-nameOnCard")).sendKeys(nomeCartao);
		driver.findElement(By.id("creditCard-ccMonth")).click();
		Select mes = new Select(driver.findElement(By.id("creditCard-ccMonth")));
		mes.selectByValue(mesCartao);
		driver.findElement(By.id("creditCard-ccYear")).click();
		Select ano = new Select(driver.findElement(By.id("creditCard-ccYear")));
		ano.selectByValue(anoCartao);
		driver.findElement(By.id("creditCard-creditCard-security")).clear();
		driver.findElement(By.id("creditCard-creditCard-security")).sendKeys(codCartao);
		driver.findElement(By.id("creditCard-creditCard-installment")).clear();
		driver.findElement(By.id("creditCard-creditCard-installment")).sendKeys(parcelas);

	}

	// método que seleciona mais de um item para compra.
	public void selecionar2Itens(String qtd) {
		Select qtdItens = new Select(driver.findElement(By.className("form-control select__quantity")));
		qtdItens.selectByValue(qtd);
	}

	// método que remove item selecionado do carrinho.
	public void removerItem() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("button--link")));
		driver.findElement(By.className("button--link")).click();
		
	}

}
