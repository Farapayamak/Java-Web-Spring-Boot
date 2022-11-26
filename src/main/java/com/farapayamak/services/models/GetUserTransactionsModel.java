package com.farapayamak.services.models;

import java.util.Date;

public class GetUserTransactionsModel {
    public String targetUsername;
    // Possible values for creditType are:
    // SendSMS or ReceiveSMS or ChargeAccount or MoneyBack or Gift or AddEmployee or ChargeEmployee or RemoveEmplooyee or Profit or BuyNumber or ChargeCard or SaleCard or BuyModule or SendFax or SendVoiceSMS or CallDivert or CallExtenstion or Voip or Discount or InstallMent or DecreaseCredit or TestCredit or USSD or BuyCreditCharge or RenewPanel or ChargeAccountWithProfit or MoneyBackInLine or Bts or All
    public String creditType;
    public Date dateFrom;
    public Date dateTo;
    public String keyword;
}
