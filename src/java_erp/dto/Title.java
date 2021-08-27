package java_erp.dto;

public class Title {
	private int tNO;
	private String tName;

	public Title() {
		// TODO Auto-generated constructor stub
	}

	public Title(int tNO) {
		this.tNO = tNO;
	}

	public Title(int tNO, String tName) {
		this.tNO = tNO;
		this.tName = tName;
	}

	public int gettNO() {
		return tNO;
	}

	public void settNO(int tNO) {
		this.tNO = tNO;
	}

	public String gettName() {
		return tName;
	}

	public void settName(String tName) {
		this.tName = tName;
	}

	@Override
	public String toString() {
		return String.format("Title [tNO=%s, tName=%s]", tNO, tName);
	}

}
