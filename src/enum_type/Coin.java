package enum_type;

/**
 * Created by hp on 2016/6/15 0015.
 */
public enum Coin {
    peney("hello"),nickel("world"),dime("welcome"),quarter("hello world");

    private String value;

    public String getValue() {
        return value;
    }

    Coin(String value) {
        this.value = value;
    }
}
