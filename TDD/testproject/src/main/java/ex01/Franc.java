package ex01;

public class Franc extends Money{

    public Franc(int amount, String currency){
        super(amount, currency);
    }

    //通过将返回Franc改为Money，消除了重复设计
    public Money times(int multiplier){
        return new Money(amount * multiplier, currency);
    }
}
