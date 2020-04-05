package pers.tavish.jcip.ch3sharingobjects;

import net.jcip.annotations.Immutable;

import java.math.BigInteger;
import java.util.Arrays;

// 程序清单3-12
@Immutable
public class OneValueCache {
    private final BigInteger lastNumber;
    private final BigInteger[] lastFactors;

    public OneValueCache(BigInteger i, BigInteger[] factors) {
        lastNumber = i;
        lastFactors = Arrays.copyOf(factors, factors.length);
    }

    public BigInteger[] getFactors(BigInteger i) {
        return lastNumber == null || !lastNumber.equals(i) ? null : Arrays.copyOf(lastFactors, lastFactors.length);
    }
}
