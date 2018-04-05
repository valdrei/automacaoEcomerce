package compraEcomerce_TestCases;

public class ExecutarTestes {

	public static void main(String[] args) throws Exception {
		EfetuarCompra efetuarCompra = new EfetuarCompra();
		EfetuarCompra2Itens efeturarCompra2 = new EfetuarCompra2Itens();
		RemoverItemCarrinho removerItem = new RemoverItemCarrinho();

		//Test 1
		efetuarCompra.setUpBeforeClass();
		efetuarCompra.efetuarCompraComCartaoCredito();
		efetuarCompra.tearDownAfterClass();
		
		//Test 2
		efeturarCompra2.setUpBeforeClass();
		efeturarCompra2.efetuarCompra2itens();
		efeturarCompra2.tearDownAfterClass();
		
		//Test 3
		removerItem.setUpBeforeClass();
		removerItem.removerItemDoCarrinho();
		removerItem.tearDownAfterClass();
	}

}
