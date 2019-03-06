package com.henry.bitcoin.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/*
 * Result:
 * {
 *   "chain": "xxxx",              (string) current network name as defined in BIP70 (main, test, regtest)
 *   "blocks": xxxxxx,             (numeric) the current number of blocks processed in the server
 *   "headers": xxxxxx,            (numeric) the current number of headers we have validated
 *   "bestblockhash": "...",       (string) the hash of the currently best block
 *   "difficulty": xxxxxx,         (numeric) the current difficulty
 *   "mediantime": xxxxxx,         (numeric) median time for the current best block
 *   "verificationprogress": xxxx, (numeric) estimate of verification progress [0..1]
 *   "initialblockdownload": xxxx, (bool) (debug information) estimate of whether this node is in Initial Block Download mode.
 *   "chainwork": "xxxx"           (string) total amount of work in active chain, in hexadecimal
 *   "size_on_disk": xxxxxx,       (numeric) the estimated size of the block and undo files on disk
 *   "pruned": xx,                 (boolean) if the blocks are subject to pruning
 *   "pruneheight": xxxxxx,        (numeric) lowest-height complete block stored (only present if pruning is enabled)
 *   "automatic_pruning": xx,      (boolean) whether automatic pruning is enabled (only present if pruning is enabled)
 *   "prune_target_size": xxxxxx,  (numeric) the target size used by pruning (only present if automatic pruning is enabled)
 *   "softforks": [                (array) status of softforks in progress
 *      {
 *         "id": "xxxx",           (string) name of softfork
 *         "version": xx,          (numeric) block version
 *         "reject": {             (object) progress toward rejecting pre-softfork blocks
 *            "status": xx,        (boolean) true if threshold reached
 *         },
 *      }, ...
 *   ]
 *   "warnings" : "...",           (string) any network and blockchain warnings.
 * }
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BlockInfo {
    private String chsin;

    private Integer blocks;

    private Integer headers;

    @JsonProperty("bestblockhash")
    private String bestBlockHash;

    private Integer difficulty;

    @JsonProperty("mediantime")
    private Integer medianTime;

    @JsonProperty("verificationprogress")
    private Integer verificationProgress;

    @JsonProperty("initialblockdownload")
    private Boolean initialBlockDownload;

    @JsonProperty("chainwork")
    private String chainWork;

    @JsonProperty("size_on_disk")
    private Integer sizeOnDisk;

    private Boolean pruned;

    @JsonProperty("pruneheight")
    private Integer pruneHeight;

    @JsonProperty("automatic_pruning")
    private Boolean automaticPruning;

    @JsonProperty("prune_target_size")
    private Integer pruneTargetSize;

    @JsonProperty("softForks")
    private List<SoftFork> softforks;

    private String warnings;

    public String getChsin() {
        return chsin;
    }

    public void setChsin(String chsin) {
        this.chsin = chsin;
    }

    public Integer getBlocks() {
        return blocks;
    }

    public void setBlocks(Integer blocks) {
        this.blocks = blocks;
    }

    public Integer getHeaders() {
        return headers;
    }

    public void setHeaders(Integer headers) {
        this.headers = headers;
    }

    public String getBestBlockHash() {
        return bestBlockHash;
    }

    public void setBestBlockHash(String bestBlockHash) {
        this.bestBlockHash = bestBlockHash;
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    public Integer getMedianTime() {
        return medianTime;
    }

    public void setMedianTime(Integer medianTime) {
        this.medianTime = medianTime;
    }

    public Integer getVerificationProgress() {
        return verificationProgress;
    }

    public void setVerificationProgress(Integer verificationProgress) {
        this.verificationProgress = verificationProgress;
    }

    public Boolean getInitialBlockDownload() {
        return initialBlockDownload;
    }

    public void setInitialBlockDownload(Boolean initialBlockDownload) {
        this.initialBlockDownload = initialBlockDownload;
    }

    public String getChainWork() {
        return chainWork;
    }

    public void setChainWork(String chainWork) {
        this.chainWork = chainWork;
    }

    public Integer getSizeOnDisk() {
        return sizeOnDisk;
    }

    public void setSizeOnDisk(Integer sizeOnDisk) {
        this.sizeOnDisk = sizeOnDisk;
    }

    public Boolean getPruned() {
        return pruned;
    }

    public void setPruned(Boolean pruned) {
        this.pruned = pruned;
    }

    public Integer getPruneHeight() {
        return pruneHeight;
    }

    public void setPruneHeight(Integer pruneHeight) {
        this.pruneHeight = pruneHeight;
    }

    public Boolean getAutomaticPruning() {
        return automaticPruning;
    }

    public void setAutomaticPruning(Boolean automaticPruning) {
        this.automaticPruning = automaticPruning;
    }

    public Integer getPruneTargetSize() {
        return pruneTargetSize;
    }

    public void setPruneTargetSize(Integer pruneTargetSize) {
        this.pruneTargetSize = pruneTargetSize;
    }

    public List<SoftFork> getSoftforks() {
        return softforks;
    }

    public void setSoftforks(List<SoftFork> softforks) {
        this.softforks = softforks;
    }

    public String getWarnings() {
        return warnings;
    }

    public void setWarnings(String warnings) {
        this.warnings = warnings;
    }

    public static class SoftFork{
        private String id;
        private Integer version;
        private Reject reject;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Integer getVersion() {
            return version;
        }

        public void setVersion(Integer version) {
            this.version = version;
        }

        public Reject getReject() {
            return reject;
        }

        public void setReject(Reject reject) {
            this.reject = reject;
        }
    }

    public static class Reject{
        private Boolean status;

        public Boolean getStatus() {
            return status;
        }

        public void setStatus(Boolean status) {
            this.status = status;
        }
    }
}
