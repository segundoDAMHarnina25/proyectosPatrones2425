package easy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ClienteTest {

	@Test
	void test() {
		Trifulnio trifulnio = new Trifulnio();
		trifulnio.numeroA = "232";
		trifulnio.numeroB = "12";
		Client client = new Client();
		Mapper<Trifulnio, Gorgete> mapper = new Mapper<Trifulnio, Gorgete>() {

			@Override
			public Gorgete map(Trifulnio t) {
				Gorgete gorgete = new Gorgete();
				gorgete.numeroA = Integer.valueOf(t.numeroA);
				gorgete.numeroB = Integer.valueOf(t.numeroB);
				return gorgete;
			}
		};
		client.treat(mapper.map(trifulnio));
	}

}
