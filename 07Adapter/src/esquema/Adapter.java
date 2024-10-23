package esquema;

public class Adapter implements ClientInterface {

	private Service service;

	public Adapter(Service service) {
		this.service = service;
	}

	@Override
	public SpecialData method(Data data) {
		SpecialData convertToServiceFormat = convertToServiceFormat(data);
		service.serviceMethod(convertToServiceFormat);
		return convertToServiceFormat;
	}

	private SpecialData convertToServiceFormat(Data data) {
		return new SpecialData(Integer.valueOf(data.aString));
	}

}
