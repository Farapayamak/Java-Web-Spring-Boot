package com.farapayamak.services.models;

import java.util.Date;

public class GetUserWalletTransactionModel {
    public Date dateFrom;
    public Date dateTo;
    public Integer count;
    public Integer startIndex;
    // Possible values for PayType are :
    // All or ChargeWallet or BuySms or BuyWidget or BuyResources or BuyTemplate or BuyDomain or BuyCms or BuyPackage or BuyNumber or SendFax or SendVoiceSms or InCommingCall or Divert or Revival or InstallMent or NotifySms or RevivalSubReseller or ActivateSubReseller or ActivatePanel or UpgradePanel or PanelPrice or Cancel or RefundToUser or VoiceMessage or DeleteFromReport or AvaPayamCharge or Discount or BuyWebsite or BuyWebsiteAndDomain or ActivateCRMPanel or RenewNumber
    public String payType;
    // Possible values for payLoc are :
    // Farapayamak or DTS or Rayo or AvaPayam
    public String payLoc;
}
