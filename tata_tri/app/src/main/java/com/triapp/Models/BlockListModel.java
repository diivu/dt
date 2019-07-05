package com.triapp.Models;

/**
 * Created by Developer on 04-08-2017.
 */

public class BlockListModel {


    private Long blockDistrictId;
    private Long blockId;
    private String blockName;

    public Long getBlockId() {
        return blockId;
    }

    public void setBlockId(Long blockId) {
        this.blockId = blockId;
    }

    public Long getBlockDistrictId() {
        return blockDistrictId;
    }

    public void setBlockDistrictId(Long blockDistrictId) {
        this.blockDistrictId = blockDistrictId;
    }

    public String getBlockName() {
        return blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }
}
