package ex16;

/**
 * 表达式接口，使用接口是因为接口是轻量级的
 */
public interface Expression {
    public Money reduce(Bank bank, String to);
    public Expression plus(Expression addend);
    public Expression times(int multiplier);
}
