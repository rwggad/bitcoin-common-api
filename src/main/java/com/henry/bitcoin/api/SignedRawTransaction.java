package com.henry.bitcoin.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/*
 * -signRawTransaction
 * Result:
 * {
 *   "hex" : "value",           (string) The hex-encoded raw transaction with signature(s)
 *   "complete" : true|false,   (boolean) If the transaction has a complete set of signatures
 *   "errors" : [                 (json array of objects) Script verification errors (if there are any)
 *     {
 *       "txid" : "hash",           (string) The hash of the referenced, previous transaction
 *       "vout" : n,                (numeric) The index of the output to spent and used as input
 *       "scriptSig" : "hex",       (string) The hex-encoded signature script
 *       "sequence" : n,            (numeric) Script sequence number
 *       "error" : "text"           (string) Verification or signing error related to the input
 *     }
 *     ,...
 *   ]
 * }
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SignedRawTransaction {

    @JsonProperty("hex")
    private String hex;

    @JsonProperty("complete")
    private Boolean complete;

    @JsonProperty("errors")
    private List<SignedRawTransactionError> errors;

    public String getHex() {
        return hex;
    }

    public void setHex(String hex) {
        this.hex = hex;
    }

    public Boolean isComplete() {
        return complete;
    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
    }

    public List<SignedRawTransactionError> getErrors() {
        return errors;
    }

    public void setErrors(List<SignedRawTransactionError> errors) {
        this.errors = errors;
    }

    @Override
    public String toString() {
        return "SignedRawTransaction{" +
                "hex='" + hex + '\'' +
                ", complete=" + complete +
                ", errors=" + errors +
                '}';
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class SignedRawTransactionError{
        @JsonProperty("txid")
        private String txId;

        @JsonProperty("vout")
        private Integer vout;

        @JsonProperty("scriptSig")
        private String scriptSig;

        @JsonProperty("sequence")
        private Long sequence;

        @JsonProperty("error")
        private String error;

        public String getTxId() {
            return txId;
        }

        public void setTxId(String txId) {
            this.txId = txId;
        }

        public Integer getVout() {
            return vout;
        }

        public void setVout(Integer vout) {
            this.vout = vout;
        }

        public String getScriptSig() {
            return scriptSig;
        }

        public void setScriptSig(String scriptSig) {
            this.scriptSig = scriptSig;
        }

        public Long getSequence() {
            return sequence;
        }

        public void setSequence(Long sequence) {
            this.sequence = sequence;
        }

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }

        @Override
        public String toString() {
            return "SignedRawTransactionError{" +
                    "txId='" + txId + '\'' +
                    ", vout=" + vout +
                    ", scriptSig='" + scriptSig + '\'' +
                    ", sequence=" + sequence +
                    ", error='" + error + '\'' +
                    '}';
        }
    }
}
