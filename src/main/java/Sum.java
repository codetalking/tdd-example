/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */

/**
 *
 * @author benrong.jcy
 * @version $Id: Sum.java, v 0.1 2017年12月18日 上午12:37 benrong.jcy Exp $
 */
public class Sum implements Expression {
    public Expression augend;
    public Expression addend;

    public Sum(Expression augend, Expression addend) {
        this.augend = augend;
        this.addend = addend;
    }

    public Money reduce(Bank bank, String to) {
        return new Money(augend.reduce(bank, to).amount + addend.reduce(bank, to).amount, to);
    }

    public Expression plus(Expression addend) {
        return new Sum(this, addend);
    }

    public Expression times(int multiplier) {
        return new Sum(augend.times(multiplier), addend.times(multiplier));
    }
}
