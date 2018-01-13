package com.coinomi.wallet;

import android.text.format.DateUtils;

import com.coinomi.core.coins.CoinID;
import com.coinomi.core.coins.CoinType;
import com.coinomi.core.coins.GroestlCoinMain;
import com.coinomi.core.coins.GroestlcoinTest;
import com.coinomi.core.network.CoinAddress;
import com.coinomi.stratumj.ServerAddress;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author John L. Jegutanis
 * @author Andreas Schildbach
 */
public class Constants {

    public static final int SEED_ENTROPY_DEFAULT = 192;
    public static final int SEED_ENTROPY_EXTRA = 256;

    public static final String ARG_SEED = "seed";
    public static final String ARG_PASSWORD = "password";
    public static final String ARG_SEED_PASSWORD = "seed_password";
    public static final String ARG_EMPTY_WALLET = "empty_wallet";
    public static final String ARG_SEND_TO_ADDRESS = "send_to_address";
    public static final String ARG_SEND_TO_COIN_TYPE = "send_to_coin_type";
    public static final String ARG_SEND_TO_ACCOUNT_ID = "send_to_account_id";
    public static final String ARG_SEND_VALUE = "send_value";
    public static final String ARG_TX_MESSAGE = "tx_message";
    public static final String ARG_COIN_ID = "coin_id";
    public static final String ARG_ACCOUNT_ID = "account_id";
    public static final String ARG_MULTIPLE_COIN_IDS = "multiple_coin_ids";
    public static final String ARG_MULTIPLE_CHOICE = "multiple_choice";
    public static final String ARG_TRANSACTION_ID = "transaction_id";
    public static final String ARG_ERROR = "error";
    public static final String ARG_MESSAGE = "message";
    public static final String ARG_ADDRESS = "address";
    public static final String ARG_ADDRESS_STRING = "address_string";
    public static final String ARG_EXCHANGE_ENTRY = "exchange_entry";
    public static final String ARG_TEST_WALLET = "test_wallet";
    public static final String ARG_URI = "test_wallet";

    public static final String WALLET_FILENAME_PROTOBUF = "wallet";
    public static final long WALLET_WRITE_DELAY = 5;
    public static final TimeUnit WALLET_WRITE_DELAY_UNIT = TimeUnit.SECONDS;

    public static final long STOP_SERVICE_AFTER_IDLE_SECS = 30 * 60; // 30 mins

    public static final String HTTP_CACHE_DIR = "http_cache";
    public static final int HTTP_CACHE_SIZE = 256 * 1024; // 256 KiB
    public static final int HTTP_TIMEOUT_MS = 15 * (int) DateUtils.SECOND_IN_MILLIS;

    public static final long RATE_UPDATE_FREQ_MS = 30 * DateUtils.SECOND_IN_MILLIS;

    /** Default currency to use if all default mechanisms fail. */
    public static final String DEFAULT_EXCHANGE_CURRENCY = "USD";

    public static final Charset UTF_8 = Charset.forName("UTF-8");
    public static final Charset US_ASCII = Charset.forName("US-ASCII");

    public static final char CHAR_HAIR_SPACE = '\u200a';
    public static final char CHAR_THIN_SPACE = '\u2009';
    public static final char CHAR_ALMOST_EQUAL_TO = '\u2248';
    public static final char CHAR_CHECKMARK = '\u2713';
    public static final char CURRENCY_PLUS_SIGN = '+';
    public static final char CURRENCY_MINUS_SIGN = '-';

    public static final String MARKET_APP_URL = "market://details?id=%s";
    public static final String BINARY_URL = "https://github.com/HashEngineering/coinomi-android/releases";

    public static final String VERSION_URL = "http://coinomi.com/version";

    // TODO move to resource files
    public static final List<CoinAddress> DEFAULT_COINS_SERVERS = ImmutableList.of(
            new CoinAddress(GroestlCoinMain.get(),  new ServerAddress("electrum2.groestlcoin.org", 50001),
                                                    new ServerAddress("electrum1.groestlcoin.org", 50001),
                                                    new ServerAddress("electrum12.groestlcoin.org", 50001),
                                                    new ServerAddress("electrum15.groestlcoin.org", 50001)),
            new CoinAddress(GroestlcoinTest.get(),  new ServerAddress("electrum21.groestlcoin.org", 51001),
                    new ServerAddress("electrum-test2.groestlcoin.org", 51001),
                    new ServerAddress("electrum-test1.groestlcoin.org", 51001))
    );

    public static final HashMap<CoinType, Integer> COINS_ICONS;
    public static final HashMap<CoinType, String> COINS_BLOCK_EXPLORERS;
    static {
        COINS_ICONS = new HashMap<CoinType, Integer>();

        COINS_ICONS.put(CoinID.GROESTLCOIN_MAIN.getCoinType(), R.drawable.groestlcoin);
        COINS_ICONS.put(CoinID.GROESTLCOIN_TEST.getCoinType(), R.drawable.groestlcoin_test);

        COINS_BLOCK_EXPLORERS = new HashMap<CoinType, String>();

        COINS_BLOCK_EXPLORERS.put(CoinID.GROESTLCOIN_MAIN.getCoinType(), "https://chainz.cryptoid.info/grs/tx.dws?%s");
        COINS_BLOCK_EXPLORERS.put(CoinID.GROESTLCOIN_TEST.getCoinType(), "https://chainz.cryptoid.info/grs-test/tx.dws?%s");
    }

    public static final CoinType DEFAULT_COIN = GroestlCoinMain.get();
    public static final List<CoinType> DEFAULT_COINS = ImmutableList.of((CoinType) GroestlCoinMain.get());
    public static final ArrayList<String> DEFAULT_TEST_COIN_IDS = Lists.newArrayList(
            GroestlcoinTest.get().getId()
    );

    public static final List<CoinType> SUPPORTED_COINS = ImmutableList.of(
            (CoinType)GroestlCoinMain.get(), (CoinType)GroestlcoinTest.get()

    );
}
