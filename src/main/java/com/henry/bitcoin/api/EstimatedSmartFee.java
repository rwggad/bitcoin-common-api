package com.henry.bitcoin.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Arrays;

/*
 * - estimateSmartFee
 * Result:
 * {
 *   "feerate" : x.x,     (numeric, optional) estimate fee rate in BTC/kB
 *   "errors": [ str... ] (json array of strings, optional) Errors encountered during processing
 *   "blocks" : n         (numeric) block number where estimate was found
 * }
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EstimatedSmartFee {

    public static final String ESTIMATE_MODE_UNSET = "UNSET";
    public static final String ESTIMATE_MODE_ECONOMICAL = "ECONOMICAL";
    public static final String ESTIMATE_MODE_CONSERVATIVE = "CONSERVATIVE";

    @JsonProperty("feerate")
    private BigDecimal feeRate;

    @JsonProperty("blocks")
    private Integer blocks;

    @JsonProperty("errors")
    private String[] errors;

    public BigDecimal getFeeRate() {
        return feeRate;
    }

    public void setFeeRate(BigDecimal feeRate) {
        this.feeRate = feeRate;
    }

    public Integer getBlocks() {
        return blocks;
    }

    public void setBlocks(Integer blocks) {
        this.blocks = blocks;
    }

    public String[] getErrors() {
        return errors;
    }

    public void setErrors(String[] errors) {
        this.errors = errors;
    }

    @Override
    public String toString() {
        return "EstimatedSmartFee{" +
                "feeRate=" + feeRate +
                ", blocks=" + blocks +
                ", errors=" + Arrays.toString(errors) +
                '}';
    }
}
