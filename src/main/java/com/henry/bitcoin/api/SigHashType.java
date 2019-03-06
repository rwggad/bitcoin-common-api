package com.henry.bitcoin.api;


/*
 * - signRawTransaction
 * 4. "sighashtype"     (string, optional, default=ALL) The signature hash type. Must be one of
 *        "ALL"
 *        "NONE"
 *        "SINGLE"
 *        "ALL|ANYONECANPAY"
 *        "NONE|ANYONECANPAY"
 *        "SINGLE|ANYONECANPAY"
 */
public class SigHashType {

    public static final String ALL = "ALL";
    public static final String NONE = "NONE";
    public static final String SINGLE = "SINGLE";
    public static final String ALL_ANYONECANPAY = "ALL|ANYONECANPAY";
    public static final String NONE_ANYONECANPAY = "NONE|ANYONECANPAY";
    public static final String SINGLE_ANYONECANPAY = "SINGLE|ANYONECANPAY";

}
