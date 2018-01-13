package com.coinomi.core.coins;

/**
 * @author John L. Jegutanis
 */
public class GroestlcoinTest extends CoinType {
    private GroestlcoinTest() {
        id = "groestlcoin.test";

        addressHeader = 111;
        p2shHeader = 196;
        acceptableAddressCodes = new int[] { addressHeader, p2shHeader };
        spendableCoinbaseDepth = 100;
        dumpedPrivateKeyHeader = 239;

        name = "Groestlcoin Test";
        symbol = "tGRS";
        uriScheme = "groestlcoin";
        bip44Index = 1;
        unitExponent = 8;
        feePerKb = value(10000);
        minNonDust = value(5460);
        softDustLimit = value(1000000); // 0.01 BTC
        softDustPolicy = SoftDustPolicy.AT_LEAST_BASE_FEE_IF_SOFT_DUST_TXO_PRESENT;
        signedMessageHeader = toBytes("GroestlCoin Signed Message:\n");
        bip32HeaderPub = 0x043587CF; //The 4 byte header that serializes in base58 to "xpub".
        bip32HeaderPriv = 0x04353394; //The 4 byte header that serializes in base58 to "xprv"
    }

    private static GroestlcoinTest instance = new GroestlcoinTest();
    public static synchronized CoinType get() {
        return instance;
    }
}