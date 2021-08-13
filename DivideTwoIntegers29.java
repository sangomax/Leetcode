public class DivideTwoIntegers29 {
    public int divide(int dividend, int divisor) {
        int count = 0;
        int res = 0;

        if(dividend == divisor) {
            return 1;
        } else if(dividend > 0 && divisor < 0 && (Integer.valueOf("-" + dividend) == divisor)) {
            return -1;
        } else if(dividend < 0 && divisor > 0 && dividend == Integer.valueOf("-" + divisor)) {
            return -1;
        }
        if (divisor != 0) {
            if (divisor > 0) {
                if (divisor == 1) {
                    return dividend;
                }
                if (dividend > 0) {
                    if (dividend < divisor) {
                        return count;
                    }
                    res = dividend;
                    while (res - divisor >= 0) {
                        count++;
                        if (count == 1) {
                            res = dividend - divisor;
                        } else {
                            res -= divisor;
                        }
                    }
                } else if (dividend < 0) {
                    res = dividend;
                    while (res + divisor <= 0) {
                        count--;
                        if (count == -1) {
                            res = dividend + divisor;
                        } else {
                            res += divisor;
                        }
                        if (count == -1073741823) {
                            System.out.println(count);
                        }
                    }
                }
            } else if (divisor < 0) {
                if (divisor == -1) {
                    try {
                        if (dividend > 0) {
                            res = Integer.valueOf("-" + dividend);
                        } else {
                            res = Integer.valueOf(String.valueOf(dividend).substring(1));
                        }
                        return res;
                    } catch (Exception e) {
                        res = dividend - dividend - dividend - 1;
                        return res;
                    }

                }
                if (dividend > 0) {
                    res = dividend;
                    while (res + divisor >= 0) {
                        count--;
                        if (count == -1) {
                            res = dividend + divisor;
                        } else {
                            res += divisor;
                        }
                    }

                } else if (dividend < 0) {
                    if (dividend > divisor) {
                        return count;
                    }
                    res = dividend;
                    while (res - divisor <= 0) {
                        count++;
                        if (count == 1) {
                            res = dividend - divisor;
                        } else {
                            res -= divisor;
                        }
                    }


                }
            }
        }
            return count;

    }

    public static void main(String[] args) {
        DivideTwoIntegers29 obj = new DivideTwoIntegers29();
        int b = obj.divide(7 ,-3);
        System.out.println(b);

    }
}
