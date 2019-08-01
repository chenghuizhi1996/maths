package com.chz.math;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

/**
 * 数学相关工具类
 */
public final class Maths {
    /**
     * 解一元三次方程
     * @param x3 输入参数
     * @param x2 输入参数
     * @param x  输入参数
     * @param d  输入参数   会被取负值
     * @return
     */
    public static double oneVariableCubicEquation(double x3, double x2, double x, double d) {
        x2 /= x3;
        x /= x3;
        d /= x3;
        double disc, q, r, dum1, s, t, term1, r13;
        q = (3.0d * x - (x2 * x2)) / 9.0d;
        r = -(27.0d * d) + x2 * (9.0f * x - 2.0d * (x2 * x2));
        r /= 54.0d;
        disc = q * q * q + r * r;
        term1 = (x2 / 3.0d);
        double x1Re;
        if (disc > 0) { // one root real, two are complex
            s = r + Math.sqrt(disc);
            s = ((s < 0) ? -Math.pow(-s, (1.0 / 3.0)) : Math.pow(s, (1.0 / 3.0)));
            t = r - Math.sqrt(disc);
            t = ((t < 0) ? -Math.pow(-t, (1.0 / 3.0)) : Math.pow(t, (1.0 / 3.0)));
            x1Re = -term1 + s + t;
        } else if (disc == 0) { // All roots real, at least two are equal.
            r13 = ((r < 0) ? -Math.pow(-r, (1.0 / 3.0)) : Math.pow(r, (1.0 / 3.0)));
            x1Re = -term1 + 2.0 * r13;
        } else {
            q = -q;
            dum1 = q * q * q;
            dum1 = Math.acos(r / Math.sqrt(dum1));
            r13 = 2.0 * Math.sqrt(q);
            x1Re = -term1 + r13 * Math.cos(dum1 / 3.0);
        }
        return BigDecimal.valueOf(x1Re).setScale(2, RoundingMode.HALF_DOWN).doubleValue();
    }
    public static Double tonNgativeNumbers(Double number){
        Objects.requireNonNull(number,"number require non null");
        return   Double.parseDouble("-" + Math.abs(number));
    }

//    public static void main(String[] args) {
//        double a = 4.024;
//        double b = -5.149;
//        double c = 2.165;
//
//        double t = oneVariableCubicEquation(a, b, c, tonNgativeNumbers(1.054912281));
//        System.out.println(t + "    " + tonNgativeNumbers(1.054912281));
//    }
}
