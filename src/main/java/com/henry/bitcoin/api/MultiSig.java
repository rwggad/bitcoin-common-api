package com.henry.bitcoin.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/*
 * - createMultiSig
 * Result:
 * {
 *   "address":"multisigaddress",  (string) The value of the new multisig address.
 *   "redeemScript":"script"       (string) The string value of the hex-encoded redemption script.
 * }
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MultiSig {

    @JsonProperty("address")
    private String address;

    @JsonProperty("redeemScript")
    private String redeemScript;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRedeemScript() {
        return redeemScript;
    }

    public void setRedeemScript(String redeemScript) {
        this.redeemScript = redeemScript;
    }
}
