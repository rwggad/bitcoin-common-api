package com.henry.bitcoin.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

/*
 * - fundRawTransaction
 * Result:
 * {
 *   "hex":       "value", (string)  The resulting raw transaction (hex-encoded string)
 *   "fee":       n,         (numeric) Fee in BTC the resulting transaction pays
 *   "changepos": n          (numeric) The position of the added change output, or -1
 * }
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FundedTransaction {

    @JsonProperty("hex")
    private String hex;

    @JsonProperty("fee")
    private BigDecimal fee;

    @JsonProperty("changepos")
    private Integer changePosition;

    public String getHex() {
        return hex;
    }

    public void setHex(String hex) {
        this.hex = hex;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public Integer getChangePosition() {
        return changePosition;
    }

    public void setChangePosition(Integer changePosition) {
        this.changePosition = changePosition;
    }

    @Override
    public String toString() {
        return "FundResult{" +
                "hex='" + hex + '\'' +
                ", fee=" + fee +
                ", changePosition=" + changePosition +
                '}';
    }
}
