package ex16;

public class Sum implements Expression {
    public Expression augend; //被加数
    public Expression addend; //加数

    public Sum(Expression augend, Expression addend){
        this.augend = augend;
        this.addend = addend;
    }

    public Money reduce(Bank bank, String to){
        int amount = augend.reduce(bank, to).amount + addend.reduce(bank, to).amount;
        return new Money(amount, to);
    }

    public Expression plus(Expression addend){
        return new Sum(this, addend);
    }

    public Expression times(int multiplier){
        return new Sum(augend.times(multiplier), addend.times(multiplier));
    }
}
