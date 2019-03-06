package com.henry.bitcoin.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.henry.bitcoin.support.*;

import java.util.Date;

/*
 * Result (if verbose is not set or set to false):
 * "data"      (string) The serialized, hex-encoded data for 'txid'
 *
 * Result (if verbose is set to true):
 * {
 *   "in_active_chain": b, (bool) Whether specified block is in the active chain or not (only present with explicit "blockhash" argument)
 *   "hex" : "data",       (string) The serialized, hex-encoded data for 'txid'
 *   "txid" : "id",        (string) The transaction id (same as provided)
 *   "hash" : "id",        (string) The transaction hash (differs from txid for witness transactions)
 *   "size" : n,             (numeric) The serialized transaction size
 *   "vsize" : n,            (numeric) The virtual transaction size (differs from size for witness transactions)
 *   "weight" : n,           (numeric) The transaction's weight (between vsize*4-3 and vsize*4)
 *   "version" : n,          (numeric) The version
 *   "locktime" : ttt,       (numeric) The lock time
 *   "vin" : [               (array of json objects)
 *      {
 *        "txid": "id",    (string) The transaction id
 *        "vout": n,         (numeric)
 *        "scriptSig": {     (json object) The script
 *          "asm": "asm",  (string) asm
 *          "hex": "hex"   (string) hex
 *        },
 *        "sequence": n      (numeric) The script sequence number
 *        "txinwitness": ["hex", ...] (array of string) hex-encoded witness data (if any)
 *      }
 *      ,...
 *   ],
 *   "vout" : [              (array of json objects)
 *      {
 *        "value" : x.xxx,            (numeric) The value in BTC
 *        "n" : n,                    (numeric) index
 *        "scriptPubKey" : {          (json object)
 *          "asm" : "asm",          (string) the asm
 *          "hex" : "hex",          (string) the hex
 *          "reqSigs" : n,            (numeric) The required sigs
 *          "type" : "pubkeyhash",  (string) The type, eg 'pubkeyhash'
 *          "addresses" : [           (json array of string)
 *            "address"        (string) bitcoin address
 *            ,...
 *          ]
 *        }
 *      }
 *      ,...
 *   ],
 *   "blockhash" : "hash",   (string) the block hash
 *   "confirmations" : n,      (numeric) The confirmations
 *   "time" : ttt,             (numeric) The transaction time in seconds since epoch (Jan 1 1970 GMT)
 *   "blocktime" : ttt         (numeric) The block time in seconds since epoch (Jan 1 1970 GMT)
 * }
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RawTransaction extends DecodedRawTransaction{

    @JsonProperty("data")
    private String data;

    @JsonProperty("in_active_chain")
    private Boolean inActiveChain;

    @JsonProperty("hex")
    private String hex;

    @JsonProperty("blockhash")
    private String blockHash;

    @JsonProperty("confirmations")
    private Integer confirmations;

    @JsonDeserialize(using = SecondTimeJsonDeserializer.class)
    @JsonProperty("time")
    private Date time;

    @JsonDeserialize(using = SecondTimeJsonDeserializer.class)
    @JsonProperty("blocktime")
    private Date blockTime;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Boolean getInActiveChain() {
        return inActiveChain;
    }

    public void setInActiveChain(Boolean inActiveChain) {
        this.inActiveChain = inActiveChain;
    }

    public String getHex() {
        return hex;
    }

    public void setHex(String hex) {
        this.hex = hex;
    }

    public String getBlockHash() {
        return blockHash;
    }

    public void setBlockHash(String blockHash) {
        this.blockHash = blockHash;
    }

    public Integer getConfirmations() {
        return confirmations;
    }

    public void setConfirmations(Integer confirmations) {
        this.confirmations = confirmations;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getBlockTime() {
        return blockTime;
    }

    public void setBlockTime(Date blockTime) {
        this.blockTime = blockTime;
    }

    @Override
    public String toString() {
        return "RawTransaction{" +
                "data='" + data + '\'' +
                ", inActiveChain=" + inActiveChain +
                ", hex='" + hex + '\'' +
                ", blockHash='" + blockHash + '\'' +
                ", confirmations=" + confirmations +
                ", time=" + time +
                ", blockTime=" + blockTime +
                '}';
    }
}
