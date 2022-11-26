package com.farapayamak.services.models;

import java.util.Date;

public class AddScheduleModel {
    public String to;
    public String from;
    public String text;
    public Boolean isflash;
    public Date scheduleDateTime;
    // Possible values for period are:
    // Once or Daily or Weekly or Monthly or Yearly or Custom
    public String period;
}
