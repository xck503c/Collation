import ex01.Franc;
import ex01.Money;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestEx01 {

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
     * 用于测试法郎的乘法是否可行
     */
    @Test
    public void testFrancMultiplication(){
        Money five = Money.franc(5);
        assertEquals(Money.franc(10), five.times(2));
        assertEquals(Money.franc(15), five.times(3));
    }

    /**
     * 用于测试法郎对象的相等性equals
     */
    @Test
    public void testEquality(){
        assertTrue(Money.dollar(5).equals(Money.dollar(5)));
        assertFalse(Money.dollar(5).equals(Money.dollar(6)));
        assertTrue(Money.franc(5).equals(Money.franc(5)));
        assertFalse(Money.franc(5).equals(Money.franc(6)));

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
     * 用于测试法郎和Money是否一样
     */
    @Test
    public void testDifferentClassEquality(){
        assertTrue(new Money(10, "CHF").equals(new Franc(10, "CHF")));
    }
}
