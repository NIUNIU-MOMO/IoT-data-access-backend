package com.IoT.data.access.backend.common.utils;


import com.IoT.data.access.backend.common.constant.BasicConstant;

import java.math.BigDecimal;

/**
 * Create by NIUNIU
 * create time 2020-6-10 15:00
 */
public class MathUtil {

    /**
     * 求 a 和 b 的商并保留 n 位小数
     */
    public static Double divide(Double a, Double b, int n) {
        if (a == BasicConstant.ZERO || b == BasicConstant.ZERO) {
            return BasicConstant.ZERO_ZERO;
        }
        return Double.parseDouble(BigDecimal.valueOf(a / b).setScale(n, MathUtilConstant.ROUND_HALF_UP).toString());
    }

    /**
     * 保留小数
     */
    public static Double retain(Double a, Integer n) {
        return Double.parseDouble(BigDecimal.valueOf(a).setScale(n, MathUtilConstant.ROUND_HALF_UP).toString());
    }

    public static Double retain(Double a, Integer n, Integer retain) {
        return Double.parseDouble(BigDecimal.valueOf(a).setScale(n, retain).toString());
    }

    public static Integer getRandomNum(Integer scope) {
        double random = Math.random();
        return ((int) (random * BasicConstant.THOUSAND * scope)) % scope;
    }

    public static class MathUtilConstant {

        /**
         * 向上取值，这种模式不会降低计算值的大小。
         */
        public static final Integer ROUND_UP = 0;

        /**
         * 向下取值，这种模式不会增加计算值的大小。
         */
        public static final Integer ROUND_DOWN = 1;

        /**
         * 正数向上取值，负数向下取值，这种模式不会降低计算值
         */
        public static final Integer ROUND_CEILING = 2;

        /**
         * 正数向下取值，负数向上取值，这种模式不会增加计算值
         */
        public static final Integer ROUND_FLOOR = 3;

        /**
         * 四舍五入(0.5向上取值)
         */
        public static final Integer ROUND_HALF_UP = 4;

        /**
         * 四舍五入(0.5向下取值)
         */
        public static final Integer ROUND_HALF_DOWN = 5;

        /**
         * 四舍五入(0.5向偶数取值)
         * 左边的数字是奇数，则表现为ROUND_HALF_UP
         * 左边的数字是偶数，则表现为ROUND_HALF_DOWN
         * 这种模式能最大限度地减少累积误差
         */
        public static final Integer ROUND_HALF_EVEN = 6;

    }

}
