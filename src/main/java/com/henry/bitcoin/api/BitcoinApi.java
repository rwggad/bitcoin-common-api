package com.henry.bitcoin.api;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface BitcoinApi {

    String getNewAddress();

    /*
     * @param label (string, required) The label.
     */
    Map<String, AddressPurpose> getAddressesByLabel(String label);

    /*
     * @param requiredCount (numeric, required) The number of required signatures out of the n keys.
     * @param keys (string, required) A json array of hex-encoded public keys
     */
    MultiSig createMultiSig(Integer requiredCount, String... keys);

    /*
     * @param address (string, required) The bitcoin address to validate
     */
    ValidatedAddress validateAddress(String address);

    /*
     * @param address (string, required) The bitcoin address to get the information of.
     */
    AddressInfo getAddressInfo(String address);

    /*
     * @param address (string, required) The bitcoin address for the private key
     */
    String dumpPrivateKey(String address);

    /*
     * @param address (string, required) The Bitcoin address (or hex-encoded script)
     * @param label (string, optional, default="") An optional label
     * @param rescan (boolean, optional, default=true) Rescan the wallet for transactions
     * @param p2sh (boolean, optional, default=false) Add the P2SH version of the script as well
     */
    void importAddress(String address, String label, Boolean rescan, Boolean p2sh);

    /*
     * @param account (string, optional) Remains for backward compatibility. Must be excluded or set to "*".
     * @param minConf (numeric, optional, default=0) Only include transactions confirmed at least this many times.
     * @param includeWatchOnly (bool, optional, default=false) Also include balance in watch-only addresses (see 'importaddress')
     */
    BigDecimal getBalance(String account, Integer minConf, Boolean includeWatchOnly);

    /*
     * @param label  (string, optional) If set, should be a valid label name to return only incoming transactions
     *               with the specified label, or "*" to disable filtering and return all transactions.
     * @param skip (numeric, optional, default=10) The number of transactions to return
     * @param count (numeric, optional, default=0) The number of transactions to skip
     * @param includeWatchOnly (bool, optional, default=false) Include transactions to watch-only addresses (see 'importaddress')
     */
    List<SimpleTransaction> listTransactions(String label, Integer skip, Integer count, Boolean includeWatchOnly);

    /*
     * @param inputs (array, required) A json array of json objects
     * @param outputs (array, required) a json array with outputs (key-value pairs)
     * @param lockTime (numeric, optional, default=0) Raw locktime. Non-0 value also locktime-activates inputs
     * @param replaceable (boolean, optional, default=false) Marks this transaction as BIP125 replaceable.
     */
    String createRawTransaction(List<RawTransactionInputParam> inputs, Map<String, BigDecimal> outputs, Long lockTime, Boolean replaceable);

    /*
     * @param transactionHex (string, required) The transaction hex string
     * @param privateKeys (string, optional) A json array of base58-encoded private keys for signing
     * @param utxoSignParams (string, optional) An json array of previous dependent transaction outputs
     * @param sigHashType (string, optional, default=ALL) The signature hash type. Must be one of
     *        "ALL"
     *        "NONE"
     *        "SINGLE"
     *        "ALL|ANYONECANPAY"
     *        "NONE|ANYONECANPAY"
     *        "SINGLE|ANYONECANPAY"
     */
    SignedRawTransaction signRawTransactionWithKey(String transactionHex, List<String> privateKeys, List<UtxoSignParam> utxoSignParams, String sigHashType);

    /*
     * @param signedRawTransactionHex (string, required) The hex string of the raw transaction)
     * @param allHighFees (boolean, optional, default=false) Allow high fees
     */
    String sendRawTransaction(String signedRawTransactionHex, Boolean allHighFees);

    /*
     * @param rawTransactionHex  (string, required) The hex string of the raw transaction
     * @param options (object, optional)
     *    {
     *      "changeAddress"          (string, optional, default pool address) The bitcoin address to receive the change
     *      "changePosition"         (numeric, optional, default random) The index of the change output
     *      "change_type"            (string, optional) The output type to use. Only valid if changeAddress is not specified. Options are "legacy", "p2sh-segwit", and "bech32". Default is set by -changetype.
     *      "includeWatching"        (boolean, optional, default false) Also select inputs which are watch only
     *      "lockUnspents"           (boolean, optional, default false) Lock selected unspent outputs
     *      "feeRate"                (numeric, optional, default not set: makes wallet determine the fee) Set a specific fee rate in BTC/kB
     *      "subtractFeeFromOutputs" (array, optional) A json array of integers.
     *                               The fee will be equally deducted from the amount of each specified output.
     *                               The outputs are specified by their zero-based index, before any change output is added.
     *                               Those recipients will receive less bitcoins than you enter in their corresponding amount field.
     *                               If no outputs are specified here, the sender pays the fee.
     *                                   [vout_index,...]
     *      "replaceable"            (boolean, optional) Marks this transaction as BIP125 replaceable.
     *                               Allows this transaction to be replaced by a transaction with higher fees
     *      "conf_target"            (numeric, optional) Confirmation target (in blocks)
     *      "estimate_mode"          (string, optional, default=UNSET) The fee estimate mode, must be one of:
     *          "UNSET"
     *          "ECONOMICAL"
     *          "CONSERVATIVE"
     *    }
     * @param isWitness (boolean, optional) Whether the transaction hex is a serialized witness transaction
     *                               If iswitness is not present, heuristic tests will be used in decoding
     */
    FundedTransaction fundRawTransaction(String rawTransactionHex, Map<String, Object> options, Boolean isWitness);

    /*
     * @param transactionId (string, required) The transaction id
     * @param verbose (bool, optional, default=false) If false, return a string, otherwise return a json object
     * @param blockHash (string, optional) The block in which to look for the transaction
     */
    RawTransaction getRawTransaction(String transactionId, Boolean verbose, String blockHash);

    /*
     * @param minConfirmations (numeric, optional, default=1) The minimum confirmations to filter
     * @param maxConfirmations (numeric, optional, default=9999999) The maximum confirmations to filter
     * @param addresses (string) A json array of bitcoin addresses to filter
     * @param includeUnsafe (bool, optional, default=true) Include outputs that are not safe to spend
     *                   See description of "safe" attribute below.
     * @param minimumSumAmount (json, optional) JSON with query options
     */
    List<Utxo> listUnSpent(Integer minConfirmations, Integer maxConfirmations, String[] addresses, Boolean includeUnsafe, BigDecimal minimumSumAmount);

    /*
     * @param transactionId (string, required) The transaction id
     * @param includeWatchOnly      (bool, optional, default=false) Whether to include watch-only addresses in balance calculation and details[]
     */
    Transaction getTransaction(String transactionId, Boolean includeWatchOnly);

    /*
     * @param transactionHex (string, required) The transaction hex string
     * @param isWitness (boolean, optional) Whether the transaction hex is a serialized witness transaction
     *                          If iswitness is not present, heuristic tests will be used in decoding
     */
    RawTransaction decodeRawTransaction(String transactionHex, Boolean isWitness);

    /*
     * @param confTarget (numeric) Confirmation target in blocks (1 - 1008)
     * @param estimateMode  (string, optional, default=CONSERVATIVE) The fee estimate mode.
     *                    Whether to return a more conservative estimate which also satisfies
     *                    a longer history. A conservative estimate potentially returns a
     *                    higher feerate and is more likely to be sufficient for the desired
     *                    target, but is not as responsive to short term drops in the
     *                    prevailing fee market.  Must be one of:
     *        "UNSET" (defaults to CONSERVATIVE)
     *        "ECONOMICAL"
     *        "CONSERVATIVE"
     */
    EstimatedSmartFee estimateSmartFee(Integer confTarget, String estimateMode);
}
