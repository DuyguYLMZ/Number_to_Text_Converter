package Enum;
/**
 * @author Duygu YILMAZ
 */
public enum Currency_Symbol {
	DOLLARS("$"), EUROS("€"), TURKISHLIRA("₺");
	private String value;

	Currency_Symbol(String value){
        this.value = value;
    }

	@Override
	public String toString() {
		return value;
	}
}
