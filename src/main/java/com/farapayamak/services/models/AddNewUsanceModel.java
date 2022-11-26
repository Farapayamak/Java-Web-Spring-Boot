package com.farapayamak.services.models;

import java.util.Date;

public class AddNewUsanceModel {
    public String to;
    public String from;
    public String text;
    public Boolean isflash;
    public Date scheduleStartDateTime;
    public Integer countrepeat;
    public Date scheduleEndDateTime;
    // Possible values for periodType are:
    // Once or Daily or Weekly or Monthly or Yearly or Custom
    public String periodType;
}
