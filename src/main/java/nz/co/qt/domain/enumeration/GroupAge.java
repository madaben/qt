package nz.co.qt.domain.enumeration;

public enum GroupAge {

	A2_3("2-3"), A3_5("3-5"), A5_7("5-7"), A7_9("7-9"), A9_11("9-11"), A11_13(
			"11-13"), A13_15("13-15");

	private String name;

	private GroupAge(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
