package com.nypl.mockServer.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


import java.util.List;

/**
 * Created by rajeshbabuk on 7/12/16.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "nyplSource",
        "bibIds",
        "id",
        "nyplType",
        "updatedDate",
        "createdDate",
        "deletedDate",
        "deleted",
        "location",
        "status",
        "barcode",
        "callNumber",
        "itemType",
        "fixedFields",
        "varFields"
})
public class ItemData {
    @JsonProperty("nyplSource")
    private String nyplSource;
    @JsonProperty("bibIds")
    private List<String> bibIds = null;
    @JsonProperty("id")
    private String id;
    @JsonProperty("nyplType")
    private String nyplType;
    @JsonProperty("updatedDate")
    private String updatedDate;
    @JsonProperty("createdDate")
    private String createdDate;
    @JsonProperty("deletedDate")
    private Object deletedDate;
    @JsonProperty("deleted")
    private Object deleted;
    @JsonProperty("location")
    private Object location;
    @JsonProperty("status")
    private Object status;
    @JsonProperty("barcode")
    private Object barcode;
    @JsonProperty("callNumber")
    private Object callNumber;
    @JsonProperty("itemType")
    private Object itemType;

    public String getNyplSource() {
        return nyplSource;
    }

    public void setNyplSource(String nyplSource) {
        this.nyplSource = nyplSource;
    }

    public List<String> getBibIds() {
        return bibIds;
    }

    public void setBibIds(List<String> bibIds) {
        this.bibIds = bibIds;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNyplType() {
        return nyplType;
    }

    public void setNyplType(String nyplType) {
        this.nyplType = nyplType;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public Object getDeletedDate() {
        return deletedDate;
    }

    public void setDeletedDate(Object deletedDate) {
        this.deletedDate = deletedDate;
    }

    public Object getDeleted() {
        return deleted;
    }

    public void setDeleted(Object deleted) {
        this.deleted = deleted;
    }

    public Object getLocation() {
        return location;
    }

    public void setLocation(Object location) {
        this.location = location;
    }

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }

    public Object getBarcode() {
        return barcode;
    }

    public void setBarcode(Object barcode) {
        this.barcode = barcode;
    }

    public Object getCallNumber() {
        return callNumber;
    }

    public void setCallNumber(Object callNumber) {
        this.callNumber = callNumber;
    }

    public Object getItemType() {
        return itemType;
    }

    public void setItemType(Object itemType) {
        this.itemType = itemType;
    }
}
