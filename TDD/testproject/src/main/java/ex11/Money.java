package ex11;

public class Money implements Expression{
    protected int amount;
    //引入这个变量的原因就是为了将times方法从子类上移到Money类中，消除重复设计
    //同时又给不同的货币提供身份证明便于比较
    protected String currency;

    public Money(int amount, String currency){
        this.amount = amount;
        this.currency = currency;
    }

    /**
     * 加法
     * @param addend 加数
     * @return
     */
    public Expression plus(Money addend){
        return new Sum(this, addend);
    }

    /**
     * 乘法
     * @param multiplier 乘数
     * @return
     */
    public Money times(int multiplier){
        return new Money(amount*multiplier, currency);
    }

    public String currency(){
        return currency;
    }

    public Money reduce(String to){
        return this;
    }

    //引入工厂方法
    //使得任何代码都不知道是否有一个叫Dollar的子类，消除了test和子类之间的耦合
    public static Money dollar(int amount){
        return new Money(amount, "USD");
    }
    public static Money franc(int amount){
        return new Money(amount, "CHF");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)return true;
        //这个注释掉的原因就是new Money(10, "CHF")和new Franc(10, "CHF")并不想等，而实际上它们是相等的
        //原先加上class的对比，就是为了让不同的货币不能因为价钱相等而相等，它们之间是有汇率的
        //  assertFalse(Money.franc(5).equals(Money.dollar(5)));
        //这里使用currency来表示不同的货币
        //所以应该比较的是货币而不是类
//        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return amount == money.amount && currency().equals(money.currency());
    }

    @Override
    public String toString(){
        return amount + " " + currency;
    }
}
