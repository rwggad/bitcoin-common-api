package com.henry.bitcoin.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.henry.bitcoin.support.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/*
 * - getTransaction
 * Result:
 * {
 *   "amount" : x.xxx,        (numeric) The transaction amount in BTC
 *   "fee": x.xxx,            (numeric) The amount of the fee in BTC. This is negative and only available for the
 *                               'send' category of transactions.
 *   "confirmations" : n,     (numeric) The number of confirmations
 *   "blockhash" : "hash",  (string) The block hash
 *   "blockindex" : xx,       (numeric) The index of the transaction in the block that includes it
 *   "blocktime" : ttt,       (numeric) The time in seconds since epoch (1 Jan 1970 GMT)
 *   "txid" : "transactionid",   (string) The transaction id.
 *   "time" : ttt,            (numeric) The transaction time in seconds since epoch (1 Jan 1970 GMT)
 *   "timereceived" : ttt,    (numeric) The time received in seconds since epoch (1 Jan 1970 GMT)
 *   "bip125-replaceable": "yes|no|unknown",  (string) Whether this transaction could be replaced due to BIP125 (replace-by-fee);
 *                                                    may be unknown for unconfirmed transactions not in the mempool
 *   "details" : [
 *     {
 *       "account" : "accountname",      (string) DEPRECATED. This field will be removed in a V0.18. To see this deprecated field, start bitcoind with -deprecatedrpc=accounts. The account name involved in the transaction, can be "" for the default account.
 *       "address" : "address",          (string) The bitcoin address involved in the transaction
 *       "category" : "send|receive",    (string) The category, either 'send' or 'receive'
 *       "amount" : x.xxx,                 (numeric) The amount in BTC
 *       "label" : "label",              (string) A comment for the address/transaction, if any
 *       "vout" : n,                       (numeric) the vout value
 *       "fee": x.xxx,                     (numeric) The amount of the fee in BTC. This is negative and only available for the
 *                                            'send' category of transactions.
 *       "abandoned": xxx                  (bool) 'true' if the transaction has been abandoned (inputs are respendable). Only available for the
 *                                            'send' category of transactions.
 *     }
 *     ,...
 *   ],
 *   "hex" : "data"         (string) Raw data for transaction
 * }
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Transaction {

    public static final String CATEGORY_SEND = "send";
    public static final String CATEGORY_RECEIVE = "receive";

    @JsonProperty("amount")
    private BigDecimal amount;

    @JsonProperty("fee")
    private BigDecimal fee;

    @JsonProperty("confirmations")
    private Integer confirmations;

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

    @JsonProperty("bip125-replaceable")
    private String bip125Replaceable;

    @JsonProperty("hex")
    private String hex;

    @JsonProperty("details")
    private List<Detail> details;

    public static String getCategorySend() {
        return CATEGORY_SEND;
    }

    public static String getCategoryReceive() {
        return CATEGORY_RECEIVE;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
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

    public String getBip125Replaceable() {
        return bip125Replaceable;
    }

    public void setBip125Replaceable(String bip125Replaceable) {
        this.bip125Replaceable = bip125Replaceable;
    }

    public String getHex() {
        return hex;
    }

    public void setHex(String hex) {
        this.hex = hex;
    }

    public List<Detail> getDetails() {
        return details;
    }

    public void setDetails(List<Detail> details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "amount=" + amount +
                ", fee=" + fee +
                ", confirmations=" + confirmations +
                ", blockHash='" + blockHash + '\'' +
                ", blockIndex=" + blockIndex +
                ", blockTime=" + blockTime +
                ", txid='" + txid + '\'' +
                ", time=" + time +
                ", timeReceived=" + timeReceived +
                ", bip125Replaceable='" + bip125Replaceable + '\'' +
                ", hex='" + hex + '\'' +
                ", details=" + details +
                '}';
    }
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Detail {

        /*
        DEPRECATED. This field will be removed in a V0.18.
        @JsonProperty("account")
        private String account;
        */

        @JsonProperty("involvesWatchonly")
        private Boolean involvesWatchonly;

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

        @JsonProperty("abandoned")
        private Boolean abandoned;

        public Boolean getInvolvesWatchonly() {
            return involvesWatchonly;
        }

        public void setInvolvesWatchonly(Boolean involvesWatchonly) {
            this.involvesWatchonly = involvesWatchonly;
        }

        public void setVout(Integer vout) {
            this.vout = vout;
        }

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

        public int getVout() {
            return vout;
        }

        public void setVout(int vout) {
            this.vout = vout;
        }

        public BigDecimal getFee() {
            return fee;
        }

        public void setFee(BigDecimal fee) {
            this.fee = fee;
        }

        public Boolean getAbandoned() {
            return abandoned;
        }

        public void setAbandoned(Boolean abandoned) {
            this.abandoned = abandoned;
        }

        @Override
        public String toString() {
            return "Detail{" +
                    "involvesWatchonly=" + involvesWatchonly +
                    ", address='" + address + '\'' +
                    ", category='" + category + '\'' +
                    ", amount=" + amount +
                    ", label='" + label + '\'' +
                    ", vout=" + vout +
                    ", fee=" + fee +
                    ", abandoned=" + abandoned +
                    '}';
        }
    }
}
