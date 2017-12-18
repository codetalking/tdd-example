/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author benrong.jcy
 * @version $Id: Bank.java, v 0.1 2017年12月17日 下午9:53 benrong.jcy Exp $
 */
public class Bank {
    private class Pair {
        private String from;
        private String to;

        public Pair(String from, String to) {
            this.from = from;
            this.to = to;
        }

        public boolean equals(Object object) {
            Pair pair = (Pair)object;
            return from.equals(pair.from) & to.equals(pair.to);
        }

        public int hashCode() {
            return 0;
        }
    }

    private Map<Pair, Integer> rates = new HashMap<Pair, Integer>();
    public Money reduce(Expression source, String to) {
        return source.reduce(this, to);
    }

    public void addRate(String from, String to, int rate) {
        rates.put(new Pair(from, to), rate);
    }

    public int rate(String from, String to) {
        if (from.equals(to)) {
            return 1;
        }
        return rates.get(new Pair(from, to));
    }
}