import ex15.Bank;
import ex15.Expression;
import ex15.Money;
import ex15.Sum;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestEx15 {

    /**
     * 用于测试美元的乘法是否可行
     */
    @Test
    public void testMultiplication(){
        Money five = Money.dollar(5);
        assertEquals(Money.dollar(10), five.times(2));
        assertEquals(Money.dollar(15), five.times(3));
    }

    /**
     * 用于测试美元对象的相等性equals
     */
    @Test
    public void testEquality(){
        assertTrue(Money.dollar(5).equals(Money.dollar(5)));
        assertFalse(Money.dollar(5).equals(Money.dollar(6)));

        assertFalse(Money.franc(5).equals(Money.dollar(5)));
    }

    /**
     * 用于测试货币身份的返回
     */
    @Test
    public void testCurrenty(){
        assertEquals("USD", Money.dollar(1).currency());
        assertEquals("CHF", Money.franc(1).currency());
    }

    /**
     * 用于测试同样面值的法郎和Money是否一样
     */
    @Test
    public void testDifferentClassEquality(){
        //因为将Franc子类去除了，所以这个new Franc(10, "CHF")就可以换成下面的
        assertTrue(new Money(10, "CHF").equals(Money.franc(10)));
    }

//    /**
//     * 测试简单加法，5美元+5美元=10美元
//     */
//    @Test
//    public void testSimpleAddition1(){
//        Money sum = Money.dollar(5).plus(Money.dollar(5));
//        assertEquals(sum, Money.dollar(10));
//    }

    /**
     * 测试真正的不同货币求和
     */
    @Test
    public void testSimpleAddition(){
        Money five = Money.dollar(5);
        //需要一个表达式来表示5美元+5美元
        Expression sum = five.plus(five);
        //3.需要一个银行对象
        Bank bank = new Bank();
        //2.将sum的求和表达式转成以美元为单位的计算，而提供汇率的就是银行了
        Money reduced = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(10), reduced); //1.reduced是换算的意思代表换算后的货币
    }

    /**
     * 测试Money.plus返回的Sum的预期情况
     */
    @Test
    public void testPlusRetureSum(){
        Money five = Money.dollar(5);
        Expression result = five.plus(five); //两个Money对象和应该是一个Sum对象
        Sum sum = (Sum)result;
        assertEquals(five, sum.augend); //被加数
        assertEquals(five, sum.addend); //加数
    }

    /**
     * 测试银行根据汇率对表达式的转换
     */
    @Test
    public void testReduceSum(){
        Expression sum = new Sum(Money.dollar(3), Money.dollar(4));
        Bank bank = new Bank();
        Money result = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(7), result);

    }

    @Test
    public void testReduceMoney(){
        Bank bank = new Bank();
        Money result = bank.reduce(Money.dollar(1), "USD");
        assertEquals(Money.dollar(1), result);

    }

    /**
     * 我有两个法郎，但是要得到一个美元
     */
    @Test
    public void testReduceMoneyDifferentCurrency(){
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money result = bank.reduce(Money.franc(2), "USD");
        assertEquals(Money.dollar(1), result);
    }

    /**
     * 可以使用一个包含两种货币的二元数组作为键值吗？可以啊为啥不行
     */
    @Test
    public void testArrayEquals(){
        assertEquals(new Object[]{"abc", "abc"}, new Object[]{"abc", "abc"});
    }

    /**
     * 测试当两个汇率相等的返回情况
     */
    @Test
    public void testIdentityRate(){
        assertEquals(1, new Bank().rate("USD", "USD"));
    }

    /**
     * 测试混合货币的相加
     */
    @Test
    public void testMixedAddition(){
        Money dollar = Money.dollar(5);
        Money franc = Money.franc(10);
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money result = bank.reduce(dollar.plus(franc), "USD");
        assertEquals(result, Money.dollar(10));
    }
}
