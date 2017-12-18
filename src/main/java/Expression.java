/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */

/**
 *
 * @author benrong.jcy
 * @version $Id: Expression.java, v 0.1 2017年12月17日 下午9:52 benrong.jcy Exp $
 */
public interface Expression {
    Money reduce(Bank bank, String to);

    Expression plus(Expression addend);

    Expression times(int multiplier);
}
