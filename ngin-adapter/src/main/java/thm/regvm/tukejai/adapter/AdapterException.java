package thm.regvm.tukejai.adapter;

public class AdapterException extends Exception {

	private String errorMessage;

	public AdapterException() {
		super();
	}

	public AdapterException(String customMessage) {
		this.errorMessage = customMessage;
	}

	public String getMessage() {
		if (errorMessage == null) {
			return super.getMessage();
		}
		return errorMessage;
	}

}
