package com.nypl.mockServer.response;

import javax.persistence.Column;
import java.util.Date;
import java.util.List;

public class ItemInformationResponse {


    private int id;

      
    private String circulationStatus;

      
    private String securityMarker;

      
    private String feeType;

      
    private Date transactionDate;

      
    private String holdQueueLength;

      
    private Date dueDate;

      
    private Date recalDate;

      
    private Date holdPickupDate;

      
    private String itemIdentifier;

      
    private String titleIdentifier;

      
    private String mediaType;

      
    private String permanentLocation;

      
    private String currentLocation;

      
    private String itemProperties;

      
    private String screenMessage;

    public String getItemBarcode() {
        return itemBarcode;
    }

    public void setItemBarcode(String itemBarcode) {
        this.itemBarcode = itemBarcode;
    }

    private String itemBarcode;

    private List<String> bibIds;

    private String bibID;

    private String callNumber;

    private String itemType;

    private String nyplsource;

    private String createdDate;



    public List<String> getBibIds() {
        return bibIds;
    }

    public void setBibIds(List<String> bibIds) {
        this.bibIds = bibIds;
    }

    public String getBibID() {
        return bibID;
    }

    public void setBibID(String bibID) {
        this.bibID = bibID;
    }

    public String getCallNumber() {
        return callNumber;
    }

    public void setCallNumber(String callNumber) {
        this.callNumber = callNumber;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getNyplsource() {
        return nyplsource;
    }

    public void setNyplsource(String nyplsource) {
        this.nyplsource = nyplsource;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getDeletedDate() {
        return deletedDate;
    }

    public void setDeletedDate(String deletedDate) {
        this.deletedDate = deletedDate;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    private String updatedDate;

    private String deletedDate;

    private boolean isDeleted;

    private String prineLine;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCirculationStatus() {
        return circulationStatus;
    }

    public void setCirculationStatus(String circulationStatus) {
        this.circulationStatus = circulationStatus;
    }

    public String getSecurityMarker() {
        return securityMarker;
    }

    public void setSecurityMarker(String securityMarker) {
        this.securityMarker = securityMarker;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getHoldQueueLength() {
        return holdQueueLength;
    }

    public void setHoldQueueLength(String holdQueueLength) {
        this.holdQueueLength = holdQueueLength;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getRecalDate() {
        return recalDate;
    }

    public void setRecalDate(Date recalDate) {
        this.recalDate = recalDate;
    }

    public Date getHoldPickupDate() {
        return holdPickupDate;
    }

    public void setHoldPickupDate(Date holdPickupDate) {
        this.holdPickupDate = holdPickupDate;
    }

    public String getItemIdentifier() {
        return itemIdentifier;
    }

    public void setItemIdentifier(String itemIdentifier) {
        this.itemIdentifier = itemIdentifier;
    }

    public String getTitleIdentifier() {
        return titleIdentifier;
    }

    public void setTitleIdentifier(String titleIdentifier) {
        this.titleIdentifier = titleIdentifier;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getPermanentLocation() {
        return permanentLocation;
    }

    public void setPermanentLocation(String permanentLocation) {
        this.permanentLocation = permanentLocation;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public String getItemProperties() {
        return itemProperties;
    }

    public void setItemProperties(String itemProperties) {
        this.itemProperties = itemProperties;
    }

    public String getScreenMessage() {
        return screenMessage;
    }

    public void setScreenMessage(String screenMessage) {
        this.screenMessage = screenMessage;
    }

    public String getPrineLine() {
        return prineLine;
    }

    public void setPrineLine(String prineLine) {
        this.prineLine = prineLine;
    }
}
