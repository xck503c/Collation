package ex11;

public class Sum implements Expression{
    public Money augend; //被加数
    public Money addend; //加数

    public Sum(Money augend, Money addend){
        this.augend = augend;
        this.addend = addend;
    }

    public Money reduce(String to){
        int amount = augend.amount + addend.amount;
        return new Money(amount, to);
    }
}
