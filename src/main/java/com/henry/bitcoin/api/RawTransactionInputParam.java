package com.henry.bitcoin.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.util.Assert;

/*
 * - createRawTransaction
 * Arguments:
 * 1. "inputs"                (array, required) A json array of json objects
 *      [
 *        {
 *          "txid":"id",      (string, required) The transaction id
 *          "vout":n,         (numeric, required) The output number
 *          "sequence":n      (numeric, optional) The sequence number
 *        }
 *        ,...
 *      ]
 */
public class RawTransactionInputParam {

    @JsonProperty("txid")
    private String txId;

    @JsonProperty("vout")
    private Integer vout;

    @JsonProperty("sequence")
    private Long sequence;

    public RawTransactionInputParam(String txId, Integer vout) {
        this(txId, vout, null);
    }

    public RawTransactionInputParam(String txId, Integer vout, Long sequence) {
        Assert.hasText(txId, "txId must not be empty and must be a UTXO (Unspent Transaction Output)");
        Assert.isTrue(vout != null && vout >= 0,"vout must have a integer value to identify which UTXO to use, must equals 0 or more");
        if (sequence != null) {
            Assert.isTrue(sequence > 0, "sequence must large than 0");
        }

        this.txId = txId;
        this.vout = vout;
        this.sequence = sequence;
    }

    public String getTxId() {
        return txId;
    }

    public Integer getVout() {
        return vout;
    }

    public Long getSequence() {
        return sequence;
    }

    @Override
    public String toString() {
        return "RawTransactionInputParam{" +
                "txId='" + txId + '\'' +
                ", vout=" + vout +
                ", sequence=" + sequence +
                '}';
    }
}
