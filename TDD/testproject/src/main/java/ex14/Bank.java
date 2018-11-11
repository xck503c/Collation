package ex14;

import java.util.HashMap;

public class Bank {

    private HashMap<Pair, Integer> rates = new HashMap<Pair, Integer>(); //存储汇率

    public Money reduce(Expression source, String to){
        return source.reduce(this, to);
    }

    public int rate(String from, String to){
        if(from.equals(to)) return 1;
        Integer rate = rates.get(new Pair(from, to)); //查找汇率
        return rate.intValue();
    }

    //添加汇率
    public void addRate(String from, String to, int rate){
        rates.put(new Pair(from, to), new Integer(rate));
    }

    /**
     * 用作汇率的键值，所以要实现equals和hashCode
     */
    private class Pair{
        private String from;
        private String to;

        public Pair(String from, String to){
            this.from = from;
            this.to = to;
        }

        @Override
        public boolean equals(Object o) {
            Pair pair = (Pair)o;
            return from.equals(pair.from) && to.equals(pair.to);
        }

        @Override
        public int hashCode() {
           return 0;
        }
    }
}
