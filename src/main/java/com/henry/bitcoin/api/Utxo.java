package com.henry.bitcoin.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

/*
 * -listUnspent
 * Result
 * [                   (array of json object)
 *   {
 *     "txid" : "txid",          (string) the transaction id
 *     "vout" : n,               (numeric) the vout value
 *     "address" : "address",    (string) the bitcoin address
 *     "label" : "label",        (string) The associated label, or "" for the default label
 *     "account" : "account",    (string) DEPRECATED. This field will be removed in V0.18. To see this deprecated field, start bitcoind with -deprecatedrpc=accounts. The associated account, or "" for the default account
 *     "scriptPubKey" : "key",   (string) the script key
 *     "amount" : x.xxx,         (numeric) the transaction output amount in BTC
 *     "confirmations" : n,      (numeric) The number of confirmations
 *     "redeemScript" : n        (string) The redeemScript if scriptPubKey is P2SH
 *     "spendable" : xxx,        (bool) Whether we have the private keys to spend this output
 *     "solvable" : xxx,         (bool) Whether we know how to spend this output, ignoring the lack of keys
 *     "safe" : xxx              (bool) Whether this output is considered safe to spend. Unconfirmed transactions
 *                               from outside keys and unconfirmed replacement transactions are considered unsafe
 *                               and are not eligible for spending by fundrawtransaction and sendtoaddress.
 *   }
 *   ,...
 * ]
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Utxo {

    @JsonProperty("txid")
    private String txId;

    @JsonProperty("vout")
    private int vout;

    @JsonProperty("address")
    private String address;

    /*
    DEPRECATED. This field will be removed in V0.18
    @JsonProperty("account")
    private String account;
    */

    @JsonProperty("label")
    private String label;

    @JsonProperty("scriptPubKey")
    private String scriptPubKey;

    @JsonProperty("amount")
    private BigDecimal amount;

    @JsonProperty("confirmations")
    private int confirmations;

    @JsonProperty("redeemScript")
    private String redeemScript;

    @JsonProperty("spendable")
    private boolean spendable;

    @JsonProperty("solvable")
    private boolean solvable;

    @JsonProperty("safe")
    private boolean safe;

    public String getTxId() {
        return txId;
    }

    public void setTxId(String txId) {
        this.txId = txId;
    }

    public int getVout() {
        return vout;
    }

    public void setVout(int vout) {
        this.vout = vout;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getScriptPubKey() {
        return scriptPubKey;
    }

    public void setScriptPubKey(String scriptPubKey) {
        this.scriptPubKey = scriptPubKey;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public int getConfirmations() {
        return confirmations;
    }

    public void setConfirmations(int confirmations) {
        this.confirmations = confirmations;
    }

    public String getRedeemScript() {
        return redeemScript;
    }

    public void setRedeemScript(String redeemScript) {
        this.redeemScript = redeemScript;
    }

    public boolean isSpendable() {
        return spendable;
    }

    public void setSpendable(boolean spendable) {
        this.spendable = spendable;
    }

    public boolean isSolvable() {
        return solvable;
    }

    public void setSolvable(boolean solvable) {
        this.solvable = solvable;
    }

    public boolean isSafe() {
        return safe;
    }

    public void setSafe(boolean safe) {
        this.safe = safe;
    }

    @Override
    public String toString() {
        return "Utxo{" +
                "txId='" + txId + '\'' +
                ", vout=" + vout +
                ", address='" + address + '\'' +
                ", label='" + label + '\'' +
                ", scriptPubKey='" + scriptPubKey + '\'' +
                ", amount=" + amount +
                ", confirmations=" + confirmations +
                ", redeemScript='" + redeemScript + '\'' +
                ", spendable=" + spendable +
                ", solvable=" + solvable +
                ", safe=" + safe +
                '}';
    }
}
