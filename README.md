# Farapayamak Java for Web (Spring Boot)
Java webservice wrapper for Farapayamak 

## Introduction
Here we've provided a complete 3rd-party library (SDK) for Java Spring Boot developers that covers both **SOAP** and **REST** webservices. Before using, make sure you have provided a [valid account in Farapayamak corporation](https://farapayamak.ir/start/).

### معرفی
فراپیامک مجموعۀ کامل از متدهای اتصال به وب سرویس **REST** و **SOAP** این شرکت را برای توسعه دهندگان Java Spring Boot فراهم نموده. قبل از استفاده از این کتابخانه، نیاز به [خرید پنل فراپیامک](https://farapayamak.ir/start/) دارید
## Installation
You can use this Spring Boot project template with the following configuration as a starter or manually add SOAP or REST services to your project.

- Java 19
- Maven
- Jar as Packaging

Use this command to run the application:

`./mvnw spring-boot:run`

Then it listens on port *8080*.

## Usage
This is the simple usage for both REST and SOAP APIs:
```java

restService.SendSMS('09123456789', '5000xxx', 'test sms', false);

var model = new SendSimpleSMS2Model();
model.from = "5000xxx";
model.text = "Hi there!";
model.to = "09123456789";
model.isflash = false;
soapService.SendSimpleSMS2(model);

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
soapService.GetSmsPrice(model);
soapService.SendByBaseNumber(model);
soapService.SendByBaseNumber2(model);
soapService.SendByBaseNumber3(model);
soapService.SendSimpleSMS(model);
soapService.SendSimpleSMS2(model);
soapService.SendSms(model);
soapService.SendSms2(model);
soapService.SendMultipleSMS(model);
soapService.SendMultipleSMS2(model);
```

### Receive Web Service

```java
soapService.ChangeMessageIsRead(msgIds);
soapService.GetInboxCount();
soapService.GetLatestReceiveMsg(sender, receiver);
soapService.GetMessages(model);
soapService.GetMessagesAfterID(model);
soapService.GetMessagesFilterByDate(model);
soapService.GetMessagesReceptions(msgId, fromRows);
soapService.GetMessagesWithChangeIsRead(model);
soapService.GetOutBoxCount();
soapService.RemoveMessages(location, msgIds);
```

### User Web Service

```java
soapService.AddUser(model);
soapService.AddUserWithLocation(model);
soapService.AddUserWithMobileNumber(model);
soapService.AddUserWithMobileNumber2(model);
soapService.AddUserWithUserNameAndPass(model);
soapService.AuthenticateUser();
soapService.ChangeUserCredit(model);
soapService.DeductUserCredit(amount, description);
soapService.ForgotPassword(model);
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
soapService.GetUserTransactions(model);
soapService.GetUserWallet();
soapService.GetUserWalletTransaction(model);
soapService.GetUsers();
soapService.RemoveUser(targetUsername);
```

### Voice Web Service

```java
soapService.SendBulkSpeechText(model);
soapService.SendBulkVoiceSMS(model);
soapService.UploadVoiceFile(title, base64StringFile);
```

### Contacts Web Service

```java
soapService.AddContact(model);
soapService.AddContactEvents(model);
soapService.AddGroup(model);
soapService.ChangeContact(model);
soapService.ChangeGroup(model);
soapService.CheckMobileExistInContact(mobileNumber);
soapService.GetContactEvents(contactId);
soapService.GetContacts(model);
soapService.GetContactsByID(contactId, status);
soapService.GetGroups();
soapService.MergeGroups(model);
soapService.RemoveContact(mobilenumber);
soapService.RemoveContactByContactID(contactId);
soapService.RemoveGroup(groupId);
```

### Schedule Web Service

```java
soapService.AddNewMultipleSchedule(model);
soapService.AddNewUsance(model);
soapService.AddSchedule(model);
soapService.GetScheduleDetails(scheduleId);
soapService.GetScheduleStatus(scheduleId);
soapService.RemoveSchedule(scheduleId);
```

### Bulk Web Service

```java
soapService.AddNumberBulk(model);
soapService.BulkReception(model);
soapService.BulkReceptionCount(bulkId);
soapService.GetBulkDeliveries(recIds);
soapService.GetBulkDeliveries2(recId);
soapService.GetBulkDetails(bulkdId);
```