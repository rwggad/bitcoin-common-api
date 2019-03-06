package com.henry.bitcoin.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.henry.bitcoin.support.*;

import java.math.BigDecimal;
import java.util.Date;

/*
 * - listtransactions
 * Result:
 * [
 *   {
 *     "address":"address",    (string) The bitcoin address of the transaction.
 *     "category":"send|receive", (string) The transaction category.
 *     "amount": x.xxx,          (numeric) The amount in BTC. This is negative for the 'send' category, and is positive
 *                                         for the 'receive' category,
 *     "label": "label",       (string) A comment for the address/transaction, if any
 *     "vout": n,                (numeric) the vout value
 *     "fee": x.xxx,             (numeric) The amount of the fee in BTC. This is negative and only available for the
 *                                          'send' category of transactions.
 *     "confirmations": n,       (numeric) The number of confirmations for the transaction. Negative confirmations indicate the
 *                                          transaction conflicts with the block chain
 *     "trusted": xxx,           (bool) Whether we consider the outputs of this unconfirmed transaction safe to spend.
 *     "blockhash": "hashvalue", (string) The block hash containing the transaction.
 *     "blockindex": n,          (numeric) The index of the transaction in the block that includes it.
 *     "blocktime": xxx,         (numeric) The block time in seconds since epoch (1 Jan 1970 GMT).
 *     "txid": "transactionid", (string) The transaction id.
 *     "time": xxx,              (numeric) The transaction time in seconds since epoch (midnight Jan 1 1970 GMT).
 *     "timereceived": xxx,      (numeric) The time received in seconds since epoch (midnight Jan 1 1970 GMT).
 *     "comment": "...",       (string) If a comment is associated with the transaction.
 *     "bip125-replaceable": "yes|no|unknown",  (string) Whether this transaction could be replaced due to BIP125 (replace-by-fee);
 *                                                      may be unknown for unconfirmed transactions not in the mempool
 *     "abandoned": xxx          (bool) 'true' if the transaction has been abandoned (inputs are respendable). Only available for the
 *                                          'send' category of transactions.
 *   }
 * ]
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SimpleTransaction {

    @JsonProperty("address")
    private String address;

    @JsonProperty("category")
    private String category;

    @JsonProperty("amount")
    private BigDecimal amount;

    @JsonProperty("label")
    private String label;

    @JsonProperty("vout")
    private Integer vout;

    @JsonProperty("fee")
    private BigDecimal fee;

    @JsonProperty("confirmations")
    private Integer confirmations;

    @JsonProperty("trusted")
    private Boolean trusted;

    @JsonProperty("blockhash")
    private String blockHash;

    @JsonProperty("blockindex")
    private Integer blockIndex;

    @JsonDeserialize(using = SecondTimeJsonDeserializer.class)
    @JsonProperty("blocktime")
    private Date blockTime;

    @JsonProperty("txid")
    private String txid;

    @JsonDeserialize(using = SecondTimeJsonDeserializer.class)
    @JsonProperty("time")
    private Date time;

    @JsonDeserialize(using = SecondTimeJsonDeserializer.class)
    @JsonProperty("timereceived")
    private Date timeReceived;

    @JsonProperty("comment")
    private String comment;

    @JsonProperty("bip125-replaceable")
    private String bip125Replaceable;

    @JsonProperty("abandoned")
    private Boolean abandoned;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getVout() {
        return vout;
    }

    public void setVout(Integer vout) {
        this.vout = vout;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public Integer getConfirmations() {
        return confirmations;
    }

    public void setConfirmations(Integer confirmations) {
        this.confirmations = confirmations;
    }

    public Boolean getTrusted() {
        return trusted;
    }

    public void setTrusted(Boolean trusted) {
        this.trusted = trusted;
    }

    public String getBlockHash() {
        return blockHash;
    }

    public void setBlockHash(String blockHash) {
        this.blockHash = blockHash;
    }

    public Integer getBlockIndex() {
        return blockIndex;
    }

    public void setBlockIndex(Integer blockIndex) {
        this.blockIndex = blockIndex;
    }

    public Date getBlockTime() {
        return blockTime;
    }

    public void setBlockTime(Date blockTime) {
        this.blockTime = blockTime;
    }

    public String getTxid() {
        return txid;
    }

    public void setTxid(String txid) {
        this.txid = txid;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getTimeReceived() {
        return timeReceived;
    }

    public void setTimeReceived(Date timeReceived) {
        this.timeReceived = timeReceived;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getBip125Replaceable() {
        return bip125Replaceable;
    }

    public void setBip125Replaceable(String bip125Replaceable) {
        this.bip125Replaceable = bip125Replaceable;
    }

    public Boolean getAbandoned() {
        return abandoned;
    }

    public void setAbandoned(Boolean abandoned) {
        this.abandoned = abandoned;
    }

    @Override
    public String toString() {
        return "SimpleTransaction{" +
                "address='" + address + '\'' +
                ", category='" + category + '\'' +
                ", amount=" + amount +
                ", label='" + label + '\'' +
                ", vout=" + vout +
                ", fee=" + fee +
                ", confirmations=" + confirmations +
                ", trusted=" + trusted +
                ", blockHash='" + blockHash + '\'' +
                ", blockIndex=" + blockIndex +
                ", blockTime=" + blockTime +
                ", txid='" + txid + '\'' +
                ", time=" + time +
                ", timeReceived=" + timeReceived +
                ", comment='" + comment + '\'' +
                ", bip125Replaceable='" + bip125Replaceable + '\'' +
                ", abandoned=" + abandoned +
                '}';
    }
}
