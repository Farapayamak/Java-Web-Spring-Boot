# Farapayamak Java for Web (Spring Boot)
Java webservice wrapper for Farapayamak 


Use this command to run the application:

`./mvnw spring-boot:run`

Then apllication listens on prot *8080*.

## Introduction
Here we've provided a complete 3rd-party library (SDK) for Java Spring Boot developers that covers both **SOAP** and **REST** webservices. Before using, make sure you have provided a [valid account in Farapayamak corporation](https://farapayamak.ir/start/).

### معرفی
فراپیامک مجموعۀ کامل از متدهای اتصال به وب سرویس **REST** و **SOAP** این شرکت را برای توسعه دهندگان Java Spring Boot فراهم نموده. قبل از استفاده از این کتابخانه، نیاز به [خرید پنل فراپیامک](https://farapayamak.ir/start/) دارید
## Installation
You can use this Spring Boot project template with the following configuration as a starter or manually add SOAP or REST services to your project.

- Java 19
- Maven
- Jar as Packaging

## Usage
This is the simple usage for both REST and SOAP APIs:
```java

restService.SendSMS('09123456789', '5000xxx', 'test sms', false);

soapService.SendSimpleSMS2('09123456789', '5000xxx', 'test sms', false);

```
Further demonstrations can be found inside the _Application.java_ file.

## REST or SOAP?
We support a small number of methods in REST against the SOAP web service that supports the entire ones.

## REST Methods
We're currently supporting the following methods in REST web service:

```java
restService.SendSMS(to, from, text, isFlash);
restService.GetDeliveries2(recId);
restService.GetMessages(location, from, index, count);
restService.GetCredit();
restService.GetBasePrice();
restService.GetUserNumbers();
restService.BaseServiceNumber(text, to, bodyId);
```

## SOAP Methods
We support a wide range of methods in SOAP web service. They're scope separated. Let's review all the SOAP web service methods.

### Send Web Service

```java
soapService.GetCredit();
soapService.GetDeliveries(recIds);
soapService.GetDeliveries3(recId);
soapService.GetSmsPrice(irancellCount, mtnCount, from, text);
soapService.SendByBaseNumber(text, to, bodyId);
soapService.SendByBaseNumber2(text, to, bodyId);
soapService.SendByBaseNumber3(text, to);
soapService.SendSimpleSMS(to, from, text, isflash);
soapService.SendSimpleSMS2(to, from, text, isflash);
soapService.SendSms(to, from, text, isflash, udh, recId);
soapService.SendSms2(to, from, text, isflash, udh, recId, status, filterId);
soapService.SendMultipleSMS(to, from, text, isflash, udh, recId);
soapService.SendMultipleSMS2(to, from, text, isflash, udh, recId);
```

### Receive Web Service

```java
soapService.ChangeMessageIsRead(msgIds);
soapService.GetInboxCount();
soapService.GetLatestReceiveMsg(sender, receiver);
soapService.GetMessages(location, from, index, count);
soapService.GetMessagesAfterID(location, from, count, msgId);
soapService.GetMessagesFilterByDate(location, from, index, count, dateFrom, dateTo, isRead);
soapService.GetMessagesReceptions(msgId, fromRows);
soapService.GetMessagesWithChangeIsRead(location, from, index, count, isRead, changeIsRead);
soapService.GetOutBoxCount();
soapService.RemoveMessages(location, msgIds);
```

### User Web Service

```java
soapService.AddUser(productId, descriptions, mobileNumber, emailAddress, nationalCode, 
        name, family, corporation, phone, fax, address, postalCode, certificateNumber);
soapService.AddUserWithLocation(productId, descriptions, mobileNumber, emailAddress, nationalCode, 
    name, family, corporation, phone, fax, address, postalCode, certificateNumber, country, province, city);
soapService.AddUserWithMobileNumber(productId, mobileNumber, firstName, lastName, email);
soapService.AddUserWithMobileNumber2(productId, mobileNumber, firstName, lastName, userName, email);
soapService.AddUserWithUserNameAndPass(productId, descriptions, mobileNumber, emailAddress, nationalCode, 
    name, family, corporation, phone, fax, address, postalCode, certificateNumber, targetUserName, targetUserPassword);
soapService.AuthenticateUser();
soapService.ChangeUserCredit(amount, description, targetUsername, GetTax);
soapService.DeductUserCredit(amount, description);
soapService.ForgotPassword(mobileNumber, emailAddress, targetUsername);
soapService.GetCities(provinceId);
soapService.GetEnExpireDate();
soapService.GetExpireDate();
soapService.GetProvinces();
soapService.GetUserBasePrice(targetUsername);
soapService.GetUserCredit(targetUsername);
soapService.GetUserCredit2();
soapService.GetUserDetails(targetUsername);
soapService.GetUserIsExist(targetUsername);
soapService.GetUserNumbers();
soapService.GetUserTransactions(targetUsername, creditType, dateFrom, dateTo, keyword);
soapService.GetUserWallet();
soapService.GetUserWalletTransaction(dateFrom, dateTo, count, startIndex, payType, payLoc);
soapService.GetUsers();
soapService.RemoveUser(targetUsername);
```

### Voice Web Service

```java
soapService.SendBulkSpeechText(title, body, receivers, DateToSend, repeatCount);
soapService.SendBulkVoiceSMS(title, voiceFileId, receivers, DateToSend, repeatCount);
soapService.UploadVoiceFile(title, base64StringFile);
```

### Contacts Web Service

```java
soapService.AddContact(groupIds, firstname, lastname, nickname, corporation, mobilenumber,
        phone, fax, birthdate, email, gender, province, city, address, postalCode, additionaldate,
        additionaltext, descriptions);
soapService.AddContactEvents(contactId, eventName, eventType, eventDate);
soapService.AddGroup(groupName, Descriptions, showToChilds);
soapService.ChangeContact(contactId, firstname, lastname, nickname, corporation, mobilenumber,
        phone, fax, email, gender, province, city, address, postalCode, contactStatus,
        additionaltext, descriptions);
soapService.ChangeGroup(groupId, groupName, Descriptions, showToChilds, groupStatus);
soapService.CheckMobileExistInContact(mobileNumber);
soapService.GetContactEvents(contactId);
soapService.GetContacts(groupId, keyword, from, count);
soapService.GetContactsByID(contactId, status);
soapService.GetGroups();
soapService.MergeGroups(originGroupId, destinationGroupId, deleteOriginGroup);
soapService.RemoveContact(mobilenumber);
soapService.RemoveContactByContactID(contactId);
soapService.RemoveGroup(groupId);
```

### Schedule Web Service

```java
soapService.AddNewMultipleSchedule(to, from, text, isflash, scheduleDateTime, period);
soapService.AddNewUsance(to, from, text, isflash, scheduleStartDateTime, countrepeat,
        scheduleEndDateTime, periodType);
soapService.AddSchedule(to, from, text, isflash, scheduleDateTime, period);
soapService.GetScheduleDetails(scheduleId);
soapService.GetScheduleStatus(scheduleId);
soapService.RemoveSchedule(scheduleId);
```

### Bulk Web Service

```java
soapService.AddNumberBulk(from, title, messages, receivers, DateToSend);
soapService.BulkReception(bulkId, maximumRows, startRowIndex);
soapService.BulkReceptionCount(bulkId);
soapService.GetBulkDeliveries(recIds);
soapService.GetBulkDeliveries2(recId);
soapService.GetBulkDetails(bulkdId);
```