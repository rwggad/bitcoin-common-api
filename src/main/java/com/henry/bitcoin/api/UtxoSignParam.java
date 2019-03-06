package com.henry.bitcoin.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

/*
 * -signRawTransaction
 *2. "prevtxs"       (string, optional) An json array of previous dependent transaction outputs
 *      [               (json array of json objects, or 'null' if none provided)
 *        {
 *          "txid":"id",             (string, required) The transaction id
 *          "vout":n,                  (numeric, required) The output number
 *          "scriptPubKey": "hex",   (string, required) script key
 *          "redeemScript": "hex",   (string, required for P2SH or P2WSH) redeem script
 *          "amount": value            (numeric, required) The amount spent
 *        }
 *        ,...
 *     ]
 */

public class UtxoSignParam {

    @JsonProperty("txid")
    private String txId;

    @JsonProperty("vout")
    private Integer vout;

    @JsonProperty("scriptPubKey")
    private String scriptPubKey;

    @JsonProperty("redeemScript")
    private String redeemScript;

    @JsonProperty("amount")
    private BigDecimal amount;

    @JsonProperty("address")
    private String address;

    public UtxoSignParam(String txId, Integer vout, String scriptPubKey, String redeemScript, BigDecimal amount, String address) {
        this.txId = txId;
        this.vout = vout;
        this.scriptPubKey = scriptPubKey;
        this.redeemScript = redeemScript;
        this.amount = amount;
        this.address = address;
    }

    public String getTxId() {
        return txId;
    }

    public Integer getVout() {
        return vout;
    }

    public String getScriptPubKey() {
        return scriptPubKey;
    }

    public String getRedeemScript() {
        return redeemScript;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "UtxoSignParam{" +
                "txId='" + txId + '\'' +
                ", vout=" + vout +
                ", scriptPubKey='" + scriptPubKey + '\'' +
                ", redeemScript='" + redeemScript + '\'' +
                ", amount=" + amount +
                ", address='" + address + '\'' +
                '}';
    }
}
