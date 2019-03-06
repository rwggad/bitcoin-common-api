package com.henry.bitcoin.api.impl;

import com.fasterxml.jackson.databind.JavaType;
import com.henry.bitcoin.api.*;
import com.henry.bitcoin.support.RpcApiTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BitcoinTemplate extends RpcApiTemplate implements BitcoinApi {

    private static final Logger logger = LoggerFactory.getLogger(BitcoinTemplate.class);

    public BitcoinTemplate(String url, String username, String password) {
        super(url, username, password);
    }

    @Override
    public String getNewAddress() {
        return invoke("getnewaddress", null, String.class);
    }

    @Override
    public Map<String, AddressPurpose> getAddressesByLabel(String label) {
        Object[] params = new Object[1];
        params[0] = label; // required
        return invoke("getaddressesbylabel", params, Map.class);
    }

    @Override
    public MultiSig createMultiSig(Integer requiredCount, String... keys) {
        Map<String, Object> params = new HashMap<>();
        params.put("nrequired", requiredCount); // required
        params.put("keys", keys); // required
        return invokeByMap("createmultisig", params, MultiSig.class);
    }

    @Override
    public ValidatedAddress validateAddress(String address) {
        Object[] params = new Object[1];
        params[0] = address; // required
        return invoke("validateaddress", params, ValidatedAddress.class);
    }

    @Override
    public AddressInfo getAddressInfo(String address) {
        Object[] params = new Object[1];
        params[0] = address; // required
        return invoke("getaddressinfo", params, AddressInfo.class);
    }

    @Override
    public String dumpPrivateKey(String address) {
        Object[] params = new Object[1];
        params[0] = address; // required
        return invoke("dumpprivkey", params, String.class);
    }

    @Override
    public void importAddress(String address, String label, Boolean rescan, Boolean p2sh) {
        Object[] params = new Object[3];
        params[0] = address; //required
        params[1] = ""; // my option
        params[2] = false; // my option
        invoke("importaddress", params);
    }

    @Override
    public BigDecimal getBalance(String account, Integer minConf, Boolean includeWatchOnly) {
        Map<String, Object> params = new HashMap<>();
        params.put("account", "*"); // optional (dummy)
        if(minConf != null){ // optional
            params.put("minconf", minConf);
        }
        if(includeWatchOnly != null){ // optional
            params.put("include_watchonly", includeWatchOnly);
        }
        return invokeByMap("getbalance", params, BigDecimal.class);
    }

    @Override
    public List<SimpleTransaction> listTransactions(String label, Integer skip, Integer count, Boolean includeWatchOnly) {
        Map<String, Object> params = new HashMap<>();
        if(label != null){ // optional
            params.put("label", "*");
        }
        if(skip != null){ // optional
            params.put("skip", skip);
        }
        if(count != null){ // optional
            params.put("count", count);
        }
        if(includeWatchOnly != null){ // optional
            params.put("include_watchonly", includeWatchOnly);
        }
        JavaType type = getObjectMapper().getTypeFactory().constructCollectionType(List.class, SimpleTransaction.class);

        return invokeByMap("listtransactions", params, type);

    }

    @Override
    public String createRawTransaction(List<RawTransactionInputParam> inputs, Map<String, BigDecimal> outputs, Long lockTime, Boolean replaceable) {
        Map<String, Object> params = new HashMap<>();
        params.put("inputs", inputs); // required if inputsIsEmpty -> fundRawTransaction
        params.put("outputs", outputs); // required
        if (lockTime != null) { // optional
            params.put("locktime", lockTime);
        }
        if (replaceable != null) { // optional
            params.put("replaceable", replaceable);
        }
        return invokeByMap("createrawtransaction", params, String.class);
    }

    @Override
    public SignedRawTransaction signRawTransactionWithKey(String transactionHex, List<String> privateKeys, List<UtxoSignParam> utxoSignParams, String sigHashType) {
        Map<String, Object> params = new HashMap<>();
        params.put("hexstring", transactionHex); // required
        params.put("privkeys", privateKeys); // required
        if(utxoSignParams != null || utxoSignParams.size() != 0){ // optional
            params.put("prevtxs", utxoSignParams);
        }
        if (sigHashType != null) { // optional
            params.put("sighashtype", sigHashType);
        }

        return invokeByMap("signrawtransactionwithkey", params, SignedRawTransaction.class);
    }

    @Override
    public String sendRawTransaction(String signedRawTransactionHex, Boolean allHighFees) {
        Map<String, Object> params = new HashMap<>();
        params.put("hexstring", signedRawTransactionHex); // required
        if(allHighFees != null){ // optional
            params.put("allowhighfees", allHighFees);
        }
        return invokeByMap("sendrawtransaction", params, String.class);
    }

    /*
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
     */
    @Override
    public FundedTransaction fundRawTransaction(String rawTransactionHex, Map<String,Object> options, Boolean isWitness) {
        Map<String, Object> params = new HashMap<>();
        params.put("hexstring", rawTransactionHex);
        if(options != null){
            params.put("options", options);
        }
        if(isWitness != null){
            params.put("iswitness", isWitness);
        }
        return invokeByMap("fundrawtransaction", params, FundedTransaction.class);
    }

    @Override
    public RawTransaction getRawTransaction(String transactionId, Boolean verbose, String blockHash) {
        Map<String, Object> params = new HashMap<>();
        params.put("txid", transactionId); // required
        params.put("verbose", true); // my option
        if(blockHash != null){ // optional
            params.put("blockhash", blockHash);
        }
        return invokeByMap("getrawtransaction", params, RawTransaction.class);
    }

    @Override
    public List<Utxo> listUnSpent(Integer minConfirmations, Integer maxConfirmations, String[] addresses, Boolean includeUnsafe, BigDecimal minimumSumAmount) {
        Map<String, Object> params = new HashMap<>();
        if(minConfirmations != null){ // optional
            params.put("minconf", minConfirmations);
        }
        if(maxConfirmations != null){ // optional
            params.put("maxconf", maxConfirmations);
        }
        if(addresses != null){ // optional
            params.put("addresses", addresses);
        }
        if(includeUnsafe != null){ // optional
            params.put("include_unsafe", includeUnsafe);
        }
        if (minimumSumAmount != null) { // optional
            Map<String, BigDecimal> queryOptions = new HashMap<>();
            queryOptions.put("minimumSumAmount", minimumSumAmount);
            params.put("query_options",queryOptions);
        }

        JavaType type = getObjectMapper().getTypeFactory().constructCollectionType(List.class, Utxo.class);

        return invokeByMap("listunspent", params, type);
    }

    @Override
    public Transaction getTransaction(String transactionId, Boolean includeWatchOnly) {
        Map<String, Object> params = new HashMap<>();
        params.put("txid", transactionId); // required
        if(includeWatchOnly != null){ // optional
            params.put("include_watchonly", includeWatchOnly);
        }
        return invokeByMap("gettransaction", params, Transaction.class);
    }

    @Override
    public RawTransaction decodeRawTransaction(String transactionHex, Boolean isWitness) {
        Map<String, Object> params = new HashMap<>();
        params.put("hexstring", transactionHex); // required
        if(isWitness != null){ // optional
            params.put("iswitness", isWitness);
        }
        return invokeByMap("decoderawtransaction", params, RawTransaction.class);
    }

    @Override
    public EstimatedSmartFee estimateSmartFee(Integer confTarget, String estimateMode) {
        Object[] params = new Object[2];
        params[0] = confTarget; // required
        if(estimateMode != null){
            params[1] = estimateMode; // optional
        }
        return invoke("estimatesmartfee", params, EstimatedSmartFee.class);
    }
}
