package com.coinomi.core.util;


/*
 * Copyright 2014 Andreas Schildbach
 * Copyright 2015 John L. Jegutanis
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import com.coinomi.core.coins.FiatType;
import com.coinomi.core.coins.FiatValue;
import com.coinomi.core.coins.Value;
import com.coinomi.core.coins.ValueType;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkState;
import static com.google.common.math.LongMath.checkedMultiply;
import static com.google.common.math.LongMath.checkedPow;
import static com.google.common.math.LongMath.divide;

import java.math.RoundingMode;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.bitcoinj.core.Monetary;
import org.bitcoinj.utils.MonetaryFormat;

/**
 * <p>
 * Utility for formatting and parsing coin values to and from human readable form.
 * </p>
 *
 * <p>
 * MonetaryFormat instances are immutable. Invoking a configuration method has no effect on the receiving instance; you
 * must store and use the new instance it returns, instead. Instances are thread safe, so they may be stored safely as
 * static constants.
 * </p>
 */
public final class CoreMonetaryFormat  {

//    /**
//     * Parse a human readable coin value to a {@link org.bitcoinj.core.Coin} instance.
//     *
//     * @throws NumberFormatException
//     *             if the string cannot be parsed for some reason
//     */
//    public Coin parse(String str) throws NumberFormatException {
//        return parse(str, Coin.SMALLEST_UNIT_EXPONENT);
//    }

//    /**
//     * Parse a human readable coin value to a {@link org.bitcoinj.core.Coin} instance.
//     *
//     * @throws NumberFormatException
//     *             if the string cannot be parsed for some reason
//     */
//    public Coin parse(String str, int smallestUnitExponent) throws NumberFormatException {
//        return Coin.valueOf(parse(str, smallestUnitExponent));
//    }
    CoreMonetaryFormat(MonetaryFormat format)
    {
        this.format = format;
    }
    public static CoreMonetaryFormat fromBitcoinMonetaryFormat(MonetaryFormat format)
    {
        return new CoreMonetaryFormat(format);
    }

    MonetaryFormat format;
    /**
     * Parse a human readable coin value to a {@link org.bitcoinj.core.Coin} instance.
     *
     * @throws NumberFormatException
     *             if the string cannot be parsed for some reason
     */
    public Value parse(ValueType type, String str) throws NumberFormatException {
        return Value.valueOf(type, parseValue(str, type.getUnitExponent()));
    }

    /**
     * Parse a human readable fiat value to a {@link com.coinomi.core.coins.Value} instance.
     *
     * @throws NumberFormatException
     *             if the string cannot be parsed for some reason
     */
    public Value parseFiat(String currencyCode, String str) throws NumberFormatException {
        return FiatValue.valueOf(currencyCode, parseValue(str, FiatType.SMALLEST_UNIT_EXPONENT));
    }

    private long parseValue(String str, int smallestUnitExponent) {
        checkState(format.DECIMALS_PADDING.length() >= smallestUnitExponent);
        if (str.isEmpty())
            throw new NumberFormatException("empty string");
        char first = str.charAt(0);
        if (first == format.negativeSign || first == format.positiveSign)
            str = str.substring(1);
        String numbers;
        String decimals;
        int decimalMarkIndex = str.indexOf(format.decimalMark);
        if (decimalMarkIndex != -1) {
            numbers = str.substring(0, decimalMarkIndex);
            decimals = (str + format.DECIMALS_PADDING).substring(decimalMarkIndex + 1);
            if (decimals.indexOf(format.decimalMark) != -1)
                throw new NumberFormatException("more than one decimal mark");
        } else {
            numbers = str;
            decimals = format.DECIMALS_PADDING;
        }
        String satoshis = numbers + decimals.substring(0, smallestUnitExponent - format.shift);
        for (char c : satoshis.toCharArray())
            if (!Character.isDigit(c))
                throw new NumberFormatException("illegal character: " + c);
        long value = Long.parseLong(satoshis); // Non-arabic digits allowed here.
        if (first == format.negativeSign)
            value = -value;
        return value;
    }
}
