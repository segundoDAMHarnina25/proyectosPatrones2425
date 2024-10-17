package banco02.problema;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import banco02.problema.account.CreatorCuentaJoven;
import banco02.problema.account.CreatorCuentaOro;
import banco02.problema.account.CuentaJoven;
import banco02.problema.account.CuentaOro;
import banco02.problema.debitcard.CreatorDebitCardJoven;

class TestCuenta {

	@Test
	void test() {
		Socio socio=new Socio(1, new CreatorCuentaOro(),new CreatorDebitCardJoven());
		assertEquals(CuentaOro.class, socio.getCuenta().getClass());
	}

}
