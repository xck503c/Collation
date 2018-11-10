package ex11;

public class Bank {
    /**
     * 需要将表达式进行汇率转换为同一货币
     * @param source 需要换算的表达式
     * @param to 需要转换的目标货币
     * @return
     */
    public Money reduce(Expression source, String to){
        return source.reduce(to);
    }
}
