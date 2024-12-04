package ejercicio01;

import java.util.List;
import java.util.stream.Collectors;

import easy.ClienteResponse;
import easy.Mapper;

public class ClienteToStringArrayAdapter {
	Mapper<Cliente, ClienteResponse> cliente2ClientResponse = new Mapper<Cliente, ClienteResponse>() {

		@Override
		public ClienteResponse map(Cliente t) {
			return new ClienteResponse(t.getNombre(), t.getCuenta().getSaldo());
		}
	};

	public String[] convert(List<Cliente> clientes) {
		return clientes.stream().map(cliente2ClientResponse::map).map(ClienteResponse::toString)
				.collect(Collectors.toList()).toArray(new String[0]);
	}
}
