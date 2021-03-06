package com.henry.bitcoin.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.henry.bitcoin.support.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/*
 * - getAddressInfo
 * Result:
 * {
 *   "address" : "address",        (string) The bitcoin address validated
 *   "scriptPubKey" : "hex",       (string) The hex encoded scriptPubKey generated by the address
 *   "ismine" : true|false,        (boolean) If the address is yours or not
 *   "iswatchonly" : true|false,   (boolean) If the address is watchonly
 *   "isscript" : true|false,      (boolean) If the key is a script
 *   "iswitness" : true|false,     (boolean) If the address is a witness address
 *   "witness_version" : version   (numeric, optional) The version number of the witness program
 *   "witness_program" : "hex"     (string, optional) The hex value of the witness program
 *   "script" : "type"             (string, optional) The output script type. Only if "isscript" is true and the redeemscript is known. Possible types: nonstandard, pubkey, pubkeyhash, scripthash, multisig, nulldata, witness_v0_keyhash, witness_v0_scripthash, witness_unknown
 *   "hex" : "hex",                (string, optional) The redeemscript for the p2sh address
 *   "pubkeys"                     (string, optional) Array of pubkeys associated with the known redeemscript (only if "script" is "multisig")
 *     [
 *       "pubkey"
 *       ,...
 *     ]
 *   "sigsrequired" : xxxxx        (numeric, optional) Number of signatures required to spend multisig output (only if "script" is "multisig")
 *   "pubkey" : "publickeyhex",    (string, optional) The hex value of the raw public key, for single-key addresses (possibly embedded in P2SH or P2WSH)
 *   "embedded" : {...},           (object, optional) Information about the address embedded in P2SH or P2WSH, if relevant and known. It includes all getaddressinfo output fields for the embedded address, excluding metadata ("timestamp", "hdkeypath", "hdseedid") and relation to the wallet ("ismine", "iswatchonly", "account").
 *   "iscompressed" : true|false,  (boolean) If the address is compressed
 *   "label" :  "label"         (string) The label associated with the address, "" is the default account
 *   "account" : "account"         (string) DEPRECATED. This field will be removed in V0.18. To see this deprecated field, start bitcoind with -deprecatedrpc=accounts. The account associated with the address, "" is the default account
 *   "timestamp" : timestamp,      (number, optional) The creation time of the key if available in seconds since epoch (Jan 1 1970 GMT)
 *   "hdkeypath" : "keypath"       (string, optional) The HD keypath if the key is HD and available
 *   "hdseedid" : "<hash160>"      (string, optional) The Hash160 of the HD seed
 *   "hdmasterkeyid" : "<hash160>" (string, optional) alias for hdseedid maintained for backwards compatibility. Will be removed in V0.18.
 *   "labels"                      (object) Array of labels associated with the address.
 *     [
 *       { (json object of label data)
 *         "name": "labelname" (string) The label
 *         "purpose": "string" (string) Purpose of address ("send" for sending address, "receive" for receiving address)
 *       },...
 *     ]
 * }
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressInfo {
    @JsonProperty("address")
    private String address;

    @JsonProperty("scriptPubKey")
    private String scriptPubKey;

    @JsonProperty("ismine")
    private Boolean mine;

    @JsonProperty("iswatchonly")
    private Boolean watchOnly;

    @JsonProperty("isscript")
    private Boolean script;

    @JsonProperty("iswitness")
    private Boolean witness;

    @JsonProperty("witness_version")
    private Integer witnessVersion;

    @JsonProperty("witness_program")
    private String witnessProgram;

    @JsonProperty("script")
    private String scriptType;

    @JsonProperty("hex")
    private String hex;

    @JsonProperty("pubkeys")
    private String[] pubkeys;

    @JsonProperty("sigsrequired")
    private Integer sigsRequired;

    @JsonProperty("pubkey")
    private String pubkey;

    @JsonProperty("embedded")
    private Embedded embedded;

    @JsonProperty("iscompressed")
    private Boolean compressed;

    @JsonProperty("label")
    private String label;

    /*
    DEPRECATED. This field will be removed in V0.18.
    @JsonProperty("account")
    private String account;*/

    @JsonDeserialize(using = SecondTimeJsonDeserializer.class)
    @JsonProperty("timestamp")
    private Date timestamp;

    @JsonProperty("hdkeypath")
    private String hdKeyPath;

    @JsonProperty("hdseedid")
    private String hdSeedId;

    @JsonProperty("hdmasterkeyid")
    private String hdMasterKeyId;

    @JsonProperty("labels")
    private List<Label> labels;

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

    public Boolean getMine() {
        return mine;
    }

    public void setMine(Boolean mine) {
        this.mine = mine;
    }

    public Boolean getWatchOnly() {
        return watchOnly;
    }

    public void setWatchOnly(Boolean watchOnly) {
        this.watchOnly = watchOnly;
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

    public String getScriptType() {
        return scriptType;
    }

    public void setScriptType(String scriptType) {
        this.scriptType = scriptType;
    }

    public String getHex() {
        return hex;
    }

    public void setHex(String hex) {
        this.hex = hex;
    }

    public String[] getPubkeys() {
        return pubkeys;
    }

    public void setPubkeys(String[] pubkeys) {
        this.pubkeys = pubkeys;
    }

    public Integer getSigsRequired() {
        return sigsRequired;
    }

    public void setSigsRequired(Integer sigsRequired) {
        this.sigsRequired = sigsRequired;
    }

    public String getPubkey() {
        return pubkey;
    }

    public void setPubkey(String pubkey) {
        this.pubkey = pubkey;
    }

    public Embedded getEmbedded() {
        return embedded;
    }

    public void setEmbedded(Embedded embedded) {
        this.embedded = embedded;
    }

    public Boolean getCompressed() {
        return compressed;
    }

    public void setCompressed(Boolean compressed) {
        this.compressed = compressed;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getHdKeyPath() {
        return hdKeyPath;
    }

    public void setHdKeyPath(String hdKeyPath) {
        this.hdKeyPath = hdKeyPath;
    }

    public String getHdSeedId() {
        return hdSeedId;
    }

    public void setHdSeedId(String hdSeedId) {
        this.hdSeedId = hdSeedId;
    }

    public String getHdMasterKeyId() {
        return hdMasterKeyId;
    }

    public void setHdMasterKeyId(String hdMasterKeyId) {
        this.hdMasterKeyId = hdMasterKeyId;
    }

    public List<Label> getLabels() {
        return labels;
    }

    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }

    @Override
    public String toString() {
        return "AddressInfo{" +
                "address='" + address + '\'' +
                ", scriptPubKey='" + scriptPubKey + '\'' +
                ", mine=" + mine +
                ", watchOnly=" + watchOnly +
                ", script=" + script +
                ", witness=" + witness +
                ", witnessVersion=" + witnessVersion +
                ", witnessProgram='" + witnessProgram + '\'' +
                ", scriptType='" + scriptType + '\'' +
                ", hex='" + hex + '\'' +
                ", pubkeys=" + Arrays.toString(pubkeys) +
                ", sigsRequired=" + sigsRequired +
                ", pubkey='" + pubkey + '\'' +
                ", embedded=" + embedded +
                ", compressed=" + compressed +
                ", label='" + label + '\'' +
                ", timestamp=" + timestamp +
                ", hdKeyPath='" + hdKeyPath + '\'' +
                ", hdSeedId='" + hdSeedId + '\'' +
                ", hdMasterKeyId='" + hdMasterKeyId + '\'' +
                ", labels=" + labels +
                '}';
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Label{
        @JsonProperty("name")
        private String name;

        @JsonProperty("purpose")
        private String purpose;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPurpose() {
            return purpose;
        }

        public void setPurpose(String purpose) {
            this.purpose = purpose;
        }

        @Override
        public String toString() {
            return "Label{" +
                    "name='" + name + '\'' +
                    ", purpose='" + purpose + '\'' +
                    '}';
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Embedded{
        @JsonProperty("isscript")
        private Boolean script;

        @JsonProperty("iswitness")
        private Boolean witness;

        @JsonProperty("witness_version")
        private Integer witnessVersion;

        @JsonProperty("witness_program")
        private String witnessProgram;

        @JsonProperty("pubkey")
        private String pubkey;

        @JsonProperty("address")
        private String address;

        @JsonProperty("scriptPubKey")
        private String scriptPubKey;

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

        public String getPubkey() {
            return pubkey;
        }

        public void setPubkey(String pubkey) {
            this.pubkey = pubkey;
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

        @Override
        public String toString() {
            return "Embedded{" +
                    "script=" + script +
                    ", witness=" + witness +
                    ", witnessVersion=" + witnessVersion +
                    ", witnessProgram='" + witnessProgram + '\'' +
                    ", pubkey='" + pubkey + '\'' +
                    ", address='" + address + '\'' +
                    ", scriptPubKey='" + scriptPubKey + '\'' +
                    '}';
        }
    }
}
