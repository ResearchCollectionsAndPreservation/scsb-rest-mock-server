package com.nypl.mockServer.service;

import com.nypl.mockServer.*;
import com.nypl.mockServer.dao.*;
import com.nypl.mockServer.model.CheckoutData;
import com.nypl.mockServer.JobData;
import com.nypl.mockServer.Notice;
import com.nypl.mockServer.model.HoldData;
import com.nypl.mockServer.model.Item;
import com.nypl.mockServer.model.Patron;
import com.nypl.mockServer.request.*;
import com.nypl.mockServer.response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by giris on 10/3/20.
 */
@Service
@Transactional
public class RequestServiceImpl implements RequestService {

    @Autowired
    PatronRepository patronRepository;
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    CheckoutDataRepository checkoutDataRepository;
    @Autowired
    JobRepository jobRepository;
    @Autowired
    HoldDataRepository holdDataRepository;

    @Override
    public CheckoutResponse checkoutItem(CheckoutRequest checkoutRequest) {
        CheckoutResponse checkoutResponse = new CheckoutResponse();
        CheckoutData checkoutData = new CheckoutData();
        checkoutData.setJobId("13");
        try{
            if(patronRepository.findByPatronIdentifier(checkoutRequest.getPatronBarcode())!= null) {
                if(itemRepository.findByItemIdentifier(checkoutRequest.getItemBarcode())!= null) {
                    checkoutData.setCreatedDate(DateFormat());
                    checkoutData.setItemBarcode(checkoutRequest.getItemBarcode());
                    checkoutData.setPatronBarcode(checkoutRequest.getPatronBarcode());
                    checkoutData.setDesiredDateDue(checkoutRequest.getDesiredDateDue());
                    checkoutData.setProcessed(true);
                    checkoutData.setJobId("1");
                    checkoutDataRepository.save(checkoutData);
                    checkoutData.setSuccess(true);
                }else{
                    checkoutData.setJobId("6");
                }
            }
        }catch (Exception e){
            checkoutData.setJobId("2");
        }
        checkoutResponse.setData(checkoutData);
        return checkoutResponse;
    }

    @Override
    public CheckinResponse checkinItem(CheckinRequest checkinRequest) {
        CheckinResponse checkinResponse = new CheckinResponse();
        CheckinData checkinData = new CheckinData();
        checkinData.setJobId("6");
        try {
            if(itemRepository.findByItemIdentifier(checkinRequest.getItemBarcode())!= null) {

                if (checkoutDataRepository.deleteByItemBarcode(checkinRequest.getItemBarcode())!=0) {
                    checkinData.setCreatedDate(DateFormat());
                    checkinData.setItemBarcode(checkinRequest.getItemBarcode());
                    checkinData.setProcessed(true);
                    checkinData.setSuccess(true);
                    checkinData.setJobId("3");
                }
            }
        }catch (Exception e){
            //e.printStackTrace();
            checkinData.setJobId("4");
        }
        checkinResponse.setData(checkinData);
        return checkinResponse;
    }

    @Override
    public JobResponse getJobs(String jobId) {
        JobResponse jobResponse = new JobResponse();
        JobData jobData = new JobData();
        if(jobId!=null) {
            List<Notice> noticeList = new ArrayList<>();
            Notice notice = new Notice();
            notice.setText(getScreenMessage(jobId));
            noticeList.add(notice);
            jobData.setJobId(jobId);
            jobData.setSuccess(true);
            jobData.setFinished(true);
            jobData.setStarted(true);
            jobData.setNotices(noticeList);
            jobResponse.setData(jobData);
        }
        return jobResponse;
    }

    private String getScreenMessage(String jobId){
        try {
            return jobRepository.findByJobId(jobId).getMessage();
        }catch (Exception e){
            return "Can't Find JobId";
        }
    }

    @Override
    public ItemHoldResponse holdItem(ItemRequestInformation itemRequestInformation) {
        ItemHoldResponse itemHoldResponse = new ItemHoldResponse();

        itemHoldResponse.setAvailable(true);
        itemHoldResponse.setSuccess(true);
        itemHoldResponse.setCreatedDate(DateFormat());
        itemHoldResponse.setScreenMessage("Request Placed");
        itemHoldResponse.setBibId(itemRequestInformation.getBibId());
        itemHoldResponse.setTrackingId(itemRequestInformation.getTrackingId());
        itemHoldResponse.setTitleIdentifier(itemRequestInformation.getTitleIdentifier());
        itemHoldResponse.setPatronIdentifier(itemRequestInformation.getPatronBarcode());
        itemHoldResponse.setItemOwningInstitution(itemRequestInformation.getItemOwningInstitution());
        itemHoldResponse.setItemBarcode(itemRequestInformation.getItemBarcodes().get(0));
        itemHoldResponse.setPickupLocation(itemRequestInformation.getPickupLocation());
        itemHoldResponse.setExpirationDate(itemRequestInformation.getExpirationDate());
        itemHoldResponse.setJobId("14");
        return itemHoldResponse;
    }

    @Override
    public RecallResponse recallItem(RecallRequest recallRequest) {
        RecallResponse recallResponse = new RecallResponse();
        RecallData recallData = new RecallData();
        recallData.setJobId("6");
        try {
            if (itemRepository.findByItemIdentifier(recallRequest.getItemBarcode()) != null) {
                recallData.setCreatedDate(DateFormat());
                recallData.setItemBarcode(recallRequest.getItemBarcode());
                recallData.setOwningInstitutionId(recallRequest.getOwningInstitutionId());
                recallData.setJobId("7");
            }
        }catch (Exception e){
            recallData.setJobId("8");
        }

        recallResponse.setData(recallData);
        return recallResponse;
    }

    @Override
    public RefileResponse refileItem(RefileRequest refileRequest) {

        RefileResponse refileResponse = new RefileResponse();
        RefileData refileData = new RefileData();
        refileData.setJobId("6");
        try {
            if (itemRepository.findByItemIdentifier(refileRequest.getItemBarcode()) != null) {
                refileData.setCreatedDate(DateFormat());
                refileData.setItemBarcode(refileRequest.getItemBarcode());
                refileData.setJobId("9");
            }
        }catch (Exception e){
            refileData.setJobId("10");
        }
        refileResponse.setData(refileData);
        return refileResponse;
    }

    @Override
    public NYPLHoldResponse nyplHoldItem(String trackingId) {
        NYPLHoldResponse nyplHoldResponse = new NYPLHoldResponse();
        NYPLHoldData nyplHoldData = new NYPLHoldData();
        nyplHoldData.setCreatedDate(DateFormat());
        nyplHoldData.setJobId("14");
        nyplHoldResponse.setData(nyplHoldData);
        return nyplHoldResponse;
    }

    @Override
    public NYPLHoldResponse nyplHoldRequest(NYPLHoldRequest nyplHoldRequest) {
       NYPLHoldResponse nyplHoldResponse = new NYPLHoldResponse();
       NYPLHoldData nyplHoldData = new NYPLHoldData();
       nyplHoldData.setCreatedDate(DateFormat());
       nyplHoldData.setNeededBy(nyplHoldRequest.getNeededBy());
       nyplHoldData.setNumberOfCopies(nyplHoldRequest.getNumberOfCopies());
       nyplHoldData.setNyplSource(nyplHoldRequest.getNyplSource());
       nyplHoldData.setPatron(nyplHoldRequest.getPatron());
       nyplHoldData.setPickupLocation(nyplHoldRequest.getPickupLocation());
       nyplHoldData.setRecord(nyplHoldRequest.getRecord());
       nyplHoldData.setRecordType(nyplHoldRequest.getRecordType());
       nyplHoldData.setSuccess(true);
       nyplHoldData.setJobId("16");
       nyplHoldResponse.setData(nyplHoldData);
       return nyplHoldResponse;
    }

    @Override
    public CreateHoldResponse createHoldItem(CreateHoldRequest createHoldRequest) {
        CreateHoldResponse createHoldResponse = new CreateHoldResponse();
        HoldData holdData = new HoldData();
        try {
            holdData.setCreatedDate(DateFormat());
            holdData.setDescription(createHoldRequest.getDescription());
            holdData.setItemBarcode(createHoldRequest.getItemBarcode());
            holdData.setOwningInstitutionId(createHoldRequest.getOwningInstitutionId());
            holdData.setPatronBarcode(createHoldRequest.getPatronBarcode());
            holdData.setTrackingId(createHoldRequest.getTrackingId());
            holdDataRepository.save(holdData);
        }catch(Exception e){
            e.printStackTrace();
        }
        createHoldResponse.setData(holdData);
        return createHoldResponse;
    }

    @Override
    public CancelHoldResponse cancelHold(CancelHoldRequest cancelHoldRequest) {
        CancelHoldResponse cancelHoldResponse = new CancelHoldResponse();
        CancelHoldData cancelHoldData = new CancelHoldData();
        cancelHoldData.setJobId("13");
        try {
            if (patronRepository.findByPatronIdentifier(cancelHoldRequest.getPatronBarcode()) != null) {
                if (itemRepository.findByItemIdentifier(cancelHoldRequest.getItemBarcode()) != null) {
                    if (holdDataRepository.deleteByItemBarcode(cancelHoldRequest.getItemBarcode()) != 0) {
                        cancelHoldData.setItemBarcode(cancelHoldRequest.getItemBarcode());
                        cancelHoldData.setPatronBarcode(cancelHoldRequest.getPatronBarcode());
                        cancelHoldData.setOwningInstitutionId(cancelHoldRequest.getOwningInstitutionId());
                        cancelHoldData.setTrackingId(cancelHoldRequest.getTrackingId());
                        cancelHoldData.setJobId("11");
                    }
                } else {
                    cancelHoldData.setJobId("6");
                }
            }
        }catch (Exception e){
            cancelHoldData.setJobId("12");

        }
        cancelHoldResponse.setData(cancelHoldData);
        return cancelHoldResponse;
    }

    public PatronInformationResponse findPatronByPatronId(String patronIdentifier) {
        PatronInformationResponse patronInformationResponse = new PatronInformationResponse();
        try {
            Patron patron =patronRepository.findByPatronIdentifier(patronIdentifier);
            if (patron!=null){
                patronInformationResponse.setChargedItemsCount(patron.getChargedItemsCount());
                patronInformationResponse.setChargedItemsLimit(patron.getChargedItemsLimit());
                patronInformationResponse.setCurrencyType(patron.getCurrencyType());
                patronInformationResponse.setEmailAddress(patron.getEmailAddress());
                patronInformationResponse.setFeeAmount(patron.getFeeAmount());
                patronInformationResponse.setFeeLimit(patron.getFeeLimit());
                patronInformationResponse.setFineItemsCount(patron.getFineItemsCount());
                patronInformationResponse.setHoldItemsCount(patron.getHoldItemsCount());
                patronInformationResponse.setHoldItemsLimit(patron.getHoldItemsLimit());
                patronInformationResponse.setHomeAddress(patron.getHomeAddress());
                patronInformationResponse.setHomePhoneNumber(patron.getHomePhoneNumber());
                patronInformationResponse.setId(patron.getId());
                patronInformationResponse.setInstitutionId(patron.getInstitutionId());
                patronInformationResponse.setLanguage(patron.getLanguage());
                patronInformationResponse.setOverdueItemsCount(patron.getOverdueItemsCount());
                patronInformationResponse.setOverdueItemsLimit(patron.getOverdueItemsLimit());
                patronInformationResponse.setPatronIdentifier(patron.getPatronIdentifier());
                patronInformationResponse.setPersonName(patron.getPersonName());
                patronInformationResponse.setPrintLine(patron.getPrintLine());
                patronInformationResponse.setRecallItemsCount(patron.getRecallItemsCount());
                patronInformationResponse.setScreenMessage(patron.getScreenMessage());
                patronInformationResponse.setTransactionDate(patron.getTransactionDate());
                patronInformationResponse.setUnavailableHoldsCount(patron.getUnavailableHoldsCount());
                patronInformationResponse.setValidPatron(patron.getValidPatron());
                patronInformationResponse.setValidPatronPassword(patron.getValidPatronPassword());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return patronInformationResponse;
    }
/*    @Override
    public ItemInformationResponse findItemByItemId(String itemIdentifier) {
        ItemInformationResponse itemInformationResponse = new ItemInformationResponse();
        try {
            Item item = itemRepository.findByItemIdentifier(itemIdentifier);
            if(item!=null) {
               itemInformationResponse.setCirculationStatus(item.getCirculationStatus());
               itemInformationResponse.setCurrentLocation(item.getCurrentLocation());
               itemInformationResponse.setDueDate(item.getDueDate());
               itemInformationResponse.setFeeType(item.getFeeType());
               itemInformationResponse.setHoldPickupDate(item.getHoldPickupDate());
               itemInformationResponse.setHoldQueueLength(item.getHoldQueueLength());
               itemInformationResponse.setId(item.getId());
               itemInformationResponse.setItemIdentifier(item.getItemIdentifier());
               itemInformationResponse.setItemProperties(item.getItemProperties());
               itemInformationResponse.setMediaType(item.getMediaType());
               itemInformationResponse.setPermanentLocation(item.getPermanentLocation());
               itemInformationResponse.setPrineLine(item.getPrineLine());
               itemInformationResponse.setRecalDate(item.getRecalDate());
               itemInformationResponse.setScreenMessage(item.getScreenMessage());
               itemInformationResponse.setSecurityMarker(item.getSecurityMarker());
               itemInformationResponse.setTitleIdentifier(item.getTitleIdentifier());
               itemInformationResponse.setTransactionDate(item.getTransactionDate());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return itemInformationResponse;*/

    //}

    @Override
    public ItemResponse findItemByItemId(String itemIdentifier) {
        ItemResponse itemReponse = new ItemResponse();
        ItemData itemData = new ItemData();
        try {
            Item item = itemRepository.findByItemIdentifier(itemIdentifier);
            if(item!=null) {
                List<String>bibIds = new ArrayList<>();
                bibIds.add("test");
                itemData.setBarcode(item.getItemIdentifier());
                itemData.setBibIds(bibIds);
                itemData.setCallNumber(item.getPrineLine());
                itemData.setItemType(item.getFeeType());
                itemData.setNyplSource(item.getItemIdentifier());
                itemData.setUpdatedDate("12/04/2021");
                itemData.setCreatedDate("12/06/2021");
                itemData.setDeletedDate(item.getRecalDate());
                itemData.setDeleted(false);

            }
            itemReponse.setItemData(itemData);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return itemReponse;
    }

    private String DateFormat(){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        String strDate= formatter.format(date);
        return strDate;
    }


}
