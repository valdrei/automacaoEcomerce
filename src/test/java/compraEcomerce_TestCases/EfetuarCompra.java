package compraEcomerce_TestCases;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.PageObjects;

public class EfetuarCompra {

	// Instanciando o WebDriver
	static WebDriver driver;

	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdrive.chrome.driver", "C:/chromedriver.exe");
		// System.setProperty("webdrive.gecko.driver", "C:/geckodriver.exe");
		driver = new ChromeDriver();
		// driver = new FirefoxDriver();
		
	}

	
	@Test
	public void efetuarCompraComCartaoCredito() {
		driver.manage().window().maximize();
		PageObjects ecomerceObjetos = new PageObjects(driver);

		/* Passo 1 - Abrir o navegador e digitar a URL (http://submarino.com.br) */
		ecomerceObjetos.paginaInicial("http://submarino.com.br");
		
		/*
		 * Passo 2 - Realizar login com email: usuarioautomacao99@gmail.com e senha:
		 * !%2kdmdWzmh!mBa
		 */
		ecomerceObjetos.selecionarLogin();
		ecomerceObjetos.autentica("usuarioautomacao99@gmail.com","!%2kdmdWzmh!mBa");

		/* Passo 3 - Selecionar o campo busca e pesquisar pelo item Iphone X */
		ecomerceObjetos.realizarBusca("Iphone X");
		
		/* Passo 4 - Selecionar um item */
		ecomerceObjetos.selecionarItem();
		
		/* Passo 5 - Preencher dados de entrega do produto */
		ecomerceObjetos.acionarBotaoComprar("13185015","48","abc");
		
		/* Passo 6 - Preencher dados de pagamento */
		ecomerceObjetos.preencherDadosPagamento("1234.5667.8995.5211","Joao S Djavu","1","2","111","10");

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		// driver.close();
		driver.quit();
	}

}
