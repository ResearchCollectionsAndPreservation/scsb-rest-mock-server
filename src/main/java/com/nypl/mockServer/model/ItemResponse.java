package com.nypl.mockServer.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.nypl.mockServer.response.ItemData;



import java.util.List;

/**
 * Created by rajeshbabuk on 7/12/16.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "itemData",
        "count",
        "statusCode",
        "debugInfo"
})
public class ItemResponse {

    @JsonProperty("data")
    private ItemData itemData;
    @JsonProperty("count")
    private Integer count;
    @JsonProperty("statusCode")
    private Integer statusCode;
    @JsonProperty("debugInfo")
    private List<DebugInfo> debugInfo = null;

    public ItemData getItemData() {
        return itemData;
    }

    public void setItemData(ItemData itemData) {
        this.itemData = itemData;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public List<DebugInfo> getDebugInfo() {
        return debugInfo;
    }

    public void setDebugInfo(List<DebugInfo> debugInfo) {
        this.debugInfo = debugInfo;
    }
}
