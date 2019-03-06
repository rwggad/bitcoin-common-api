package com.henry.bitcoin.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Arrays;

/*
 * - decodeRawTransaction
 * Result:
 * {
 *   "txid" : "id",        (string) The transaction id
 *   "hash" : "id",        (string) The transaction hash (differs from txid for witness transactions)
 *   "size" : n,             (numeric) The transaction size
 *   "vsize" : n,            (numeric) The virtual transaction size (differs from size for witness transactions)
 *   "weight" : n,           (numeric) The transaction's weight (between vsize*4 - 3 and vsize*4)
 *   "version" : n,          (numeric) The version
 *   "locktime" : ttt,       (numeric) The lock time
 *   "vin" : [               (array of json objects)
 *      {
 *        "txid": "id",    (string) The transaction id
 *        "vout": n,         (numeric) The output number
 *        "scriptSig": {     (json object) The script
 *          "asm": "asm",  (string) asm
 *          "hex": "hex"   (string) hex
 *        },
 *        "txinwitness": ["hex", ...] (array of string) hex-encoded witness data (if any)
 *        "sequence": n     (numeric) The script sequence number
 *      }
 *      ,...
 *   ],
 *   "vout" : [             (array of json objects)
 *      {
 *        "value" : x.xxx,            (numeric) The value in BTC
 *        "n" : n,                    (numeric) index
 *        "scriptPubKey" : {          (json object)
 *          "asm" : "asm",          (string) the asm
 *          "hex" : "hex",          (string) the hex
 *          "reqSigs" : n,            (numeric) The required sigs
 *          "type" : "pubkeyhash",  (string) The type, eg 'pubkeyhash'
 *          "addresses" : [           (json array of string)
 *            "12tvKAXCxZjSmdNbao16dKXC8tRWfcF5oc"   (string) bitcoin address
 *            ,...
 *          ]
 *        }
 *      }
 *      ,...
 *   ],
 * }
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DecodedRawTransaction {

    @JsonProperty("txid")
    private String txid;

    @JsonProperty("hash")
    private String hash;

    @JsonProperty("size")
    private Integer size;

    @JsonProperty("vsize")
    private Integer vSize;

    @JsonProperty("weight")
    private Integer weight;

    @JsonProperty("version")
    private Integer version;

    @JsonProperty("locktime")
    private Integer lockTime;

    @JsonProperty("vin")
    private RawTransactionInput[] inputs;

    @JsonProperty("vout")
    private RawTransactionOutput[] outputs;

    public String getTxid() {
        return txid;
    }

    public void setTxid(String txid) {
        this.txid = txid;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getVsize() {
        return vSize;
    }

    public void setVsize(Integer vSize) {
        this.vSize = vSize;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getLockTime() {
        return lockTime;
    }

    public void setLockTime(Integer lockTime) {
        this.lockTime = lockTime;
    }

    public RawTransactionInput[] getInputs() {
        return inputs;
    }

    public void setInputs(RawTransactionInput[] inputs) {
        this.inputs = inputs;
    }

    public RawTransactionOutput[] getOutputs() {
        return outputs;
    }

    public void setOutputs(RawTransactionOutput[] outputs) {
        this.outputs = outputs;
    }

    @Override
    public String toString() {
        return "DecodedRawTransaction{" +
                "txid='" + txid + '\'' +
                ", hash='" + hash + '\'' +
                ", size=" + size +
                ", vSize=" + vSize +
                ", weight=" + weight +
                ", version=" + version +
                ", locktime=" + lockTime +
                ", inputs=" + Arrays.toString(inputs) +
                ", outputs=" + Arrays.toString(outputs) +
                '}';
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class RawTransactionInput {

        @JsonProperty("txid")
        private String txid;

        @JsonProperty("vout")
        private int vout;

        @JsonProperty("scriptSig")
        private ScriptSig scriptSig;

        @JsonProperty("txinwitness")
        private String[] txinwitness;

        @JsonProperty("sequence")
        private int sequence;


        public String getTxid() {
            return txid;
        }

        public void setTxid(String txid) {
            this.txid = txid;
        }

        public int getVout() {
            return vout;
        }

        public void setVout(int vout) {
            this.vout = vout;
        }

        public ScriptSig getScriptSig() {
            return scriptSig;
        }

        public void setScriptSig(ScriptSig scriptSig) {
            this.scriptSig = scriptSig;
        }

        public String[] getTxinwitness() {
            return txinwitness;
        }

        public void setTxinwitness(String[] txinwitness) {
            this.txinwitness = txinwitness;
        }

        public int getSequence() {
            return sequence;
        }

        public void setSequence(int sequence) {
            this.sequence = sequence;
        }

        @Override
        public String toString() {
            return "RawTransactionInput{" +
                    "txid='" + txid + '\'' +
                    ", vout=" + vout +
                    ", scriptSig=" + scriptSig +
                    ", txinwitness=" + Arrays.toString(txinwitness) +
                    ", sequence=" + sequence +
                    '}';
        }
    }
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class RawTransactionOutput {

        @JsonProperty("value")
        private BigDecimal value;

        @JsonProperty("n")
        private int index;

        @JsonProperty("scriptPubKey")
        private ScriptPubKey scriptPubKey;

        public BigDecimal getValue() {
            return value;
        }

        public void setValue(BigDecimal value) {
            this.value = value;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public ScriptPubKey getScriptPubKey() {
            return scriptPubKey;
        }

        public void setScriptPubKey(ScriptPubKey scriptPubKey) {
            this.scriptPubKey = scriptPubKey;
        }

        @Override
        public String toString() {
            return "RawTransactionOutput{" +
                    "value=" + value +
                    ", index=" + index +
                    ", scriptPubKey=" + scriptPubKey +
                    '}';
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ScriptSig {

        @JsonProperty("asm")
        private String asm;

        @JsonProperty("hex")
        private String hex;

        public String getAsm() {
            return asm;
        }

        public void setAsm(String asm) {
            this.asm = asm;
        }

        public String getHex() {
            return hex;
        }

        public void setHex(String hex) {
            this.hex = hex;
        }

        @Override
        public String toString() {
            return "ScriptSig{" +
                    "asm='" + asm + '\'' +
                    ", hex='" + hex + '\'' +
                    '}';
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ScriptPubKey {

        @JsonProperty("asm")
        private String asm;

        @JsonProperty("hex")
        private String hex;

        @JsonProperty("type")
        private String type;

        @JsonProperty("reqSigs")
        private Integer reqSigs;

        @JsonProperty("addresses")
        private String[] addresses;

        public String getAsm() {
            return asm;
        }

        public void setAsm(String asm) {
            this.asm = asm;
        }

        public String getHex() {
            return hex;
        }

        public void setHex(String hex) {
            this.hex = hex;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Integer getReqSigs() {
            return reqSigs;
        }

        public void setReqSigs(Integer reqSigs) {
            this.reqSigs = reqSigs;
        }

        public String[] getAddresses() {
            return addresses;
        }

        public void setAddresses(String[] addresses) {
            this.addresses = addresses;
        }

        @Override
        public String toString() {
            return "ScriptPubKey{" +
                    "asm='" + asm + '\'' +
                    ", hex='" + hex + '\'' +
                    ", type='" + type + '\'' +
                    ", reqSigs=" + reqSigs +
                    ", addresses=" + Arrays.toString(addresses) +
                    '}';
        }
    }
}
