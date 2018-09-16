package Enum;
/**
 * @author Duygu YILMAZ
 */
public enum Currency_Name {
	DOLLARS("dollars"), EUROS("euros"), TURKISHLIRA("turkish liras");
	private String value;

	Currency_Name(String value){
        this.value = value;
    }

	@Override
	public String toString() {
		return value;
	}
}
