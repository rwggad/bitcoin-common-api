package com.henry.bitcoin.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/*
 * - validateAddress
 * Result:
 * {
 *   "isvalid" : true|false,       (boolean) If the address is valid or not. If not, this is the only property returned.
 *   "address" : "address",        (string) The bitcoin address validated
 *   "scriptPubKey" : "hex",       (string) The hex encoded scriptPubKey generated by the address
 *   "isscript" : true|false,      (boolean) If the key is a script
 *   "iswitness" : true|false,     (boolean) If the address is a witness address
 *   "witness_version" : version   (numeric, optional) The version number of the witness program
 *   "witness_program" : "hex"     (string, optional) The hex value of the witness program
 * }
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ValidatedAddress {

    @JsonProperty("isvalid")
    private Boolean valid;

    @JsonProperty("address")
    private String address;

    @JsonProperty("scriptPubKey")
    private String scriptPubKey;

    @JsonProperty("isscript")
    private Boolean script;

    @JsonProperty("iswitness")
    private Boolean witness;

    @JsonProperty("witness_version")
    private Integer witnessVersion;

    @JsonProperty("witness_program")
    private String witnessProgram;

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getScriptPubKey() {
        return scriptPubKey;
    }

    public void setScriptPubKey(String scriptPubKey) {
        this.scriptPubKey = scriptPubKey;
    }

    public Boolean getScript() {
        return script;
    }

    public void setScript(Boolean script) {
        this.script = script;
    }

    public Boolean getWitness() {
        return witness;
    }

    public void setWitness(Boolean witness) {
        this.witness = witness;
    }

    public Integer getWitnessVersion() {
        return witnessVersion;
    }

    public void setWitnessVersion(Integer witnessVersion) {
        this.witnessVersion = witnessVersion;
    }

    public String getWitnessProgram() {
        return witnessProgram;
    }

    public void setWitnessProgram(String witnessProgram) {
        this.witnessProgram = witnessProgram;
    }

    @Override
    public String toString() {
        return "ValidatedAddress{" +
                "valid=" + valid +
                ", address='" + address + '\'' +
                ", scriptPubKey='" + scriptPubKey + '\'' +
                ", script=" + script +
                ", witness=" + witness +
                ", witnessVersion=" + witnessVersion +
                ", witnessProgram='" + witnessProgram + '\'' +
                '}';
    }
}