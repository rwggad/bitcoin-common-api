package com.henry.bitcoin.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/*
 * - getAddressesByLabel
 * Result:
 * { (json object with addresses as keys)
 *   "address": { (json object with information about address)
 *     "purpose": "string" (string)  Purpose of address ("send" for sending address, "receive" for receiving address)
 *   },...
 * }
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressPurpose {

    @JsonProperty("purpose")
    private String purpose;

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    @Override
    public String toString() {
        return "AddressPurpose{" +
                "purpose='" + purpose + '\'' +
                '}';
    }
}
