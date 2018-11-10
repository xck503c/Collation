package ex11;

/**
 * 表达式接口，使用接口是因为接口是轻量级的
 */
public interface Expression {
    public Money reduce(String to);
}
