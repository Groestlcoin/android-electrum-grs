package com.coinomi.core.coins;

import com.coinomi.core.coins.families.GroestlFamily;

import org.bitcoinj.core.Coin;
import org.bitcoinj.core.Transaction;

/**
 * @author John L. Jegutanis
 */
public class GroestlCoinMain extends CoinType {
    private GroestlCoinMain() {
        id = "groestlcoin.main";

        addressHeader = 36;
        p2shHeader = 5;
        acceptableAddressCodes = new int[] { addressHeader, p2shHeader };
        spendableCoinbaseDepth = 120;

        family = GroestlFamily.get();
        name = "Groestlcoin";
        symbol = "GRS";
        uriScheme = "groestlcoin";
        bip44Index = 17;
        unitExponent = 8;
        feePerKb = value(10000);
        minNonDust = value(1000); // 0.00001 GRS mininput
        softDustLimit = value(10000); // 0.00001 GRS
        softDustPolicy = SoftDustPolicy.BASE_FEE_FOR_EACH_SOFT_DUST_TXO;
        signedMessageHeader = toBytes("GroestlCoin Signed Message:\n");
        bip32HeaderPub = 0x0488B21E; //The 4 byte header that serializes in base58 to "xpub".
        bip32HeaderPriv = 0x0488ADE4; //The 4 byte header that serializes in base58 to "xprv"
    }

    private static GroestlCoinMain instance = new GroestlCoinMain();
    public static synchronized GroestlCoinMain get() {
        return instance;
    }
}
