package com.farapayamak.services;

import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.farapayamak.services.models.*;

@Service
public class SoapService {

    private final RestTemplate restTemplate;

    private String Username = "username";
    private String Password = "password";

    private final String SEND_Endpoint = "http://api.payamak-panel.com/post/send.asmx/%s?username=%s&password=%s";
    private final String RECEIVE_Endpoint = "http://api.payamak-panel.com/post/receive.asmx/%s?username=%s&password=%s";
    private final String USER_Endpoint = "http://api.payamak-panel.com/post/Users.asmx/%s?username=%s&password=%s";
    private final String VOICE_Endpoint = "http://api.payamak-panel.com/post/Voice.asmx/%s?username=%s&password=%s";
    private final String CONTACT_Endpoint = "http://api.payamak-panel.com/post/contacts.asmx/%s?username=%s&password=%s";

    public SoapService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    private String SetCredentials(String endpoint, String operator) {
        return String.format(endpoint, operator, Username, Password);
    }

    // SEND
    public String GetCredit() {
        String operation = new Object() {}.getClass().getEnclosingMethod().getName();
        String url = SetCredentials(SEND_Endpoint, operation);
        return InspectResponse(this.restTemplate.getForObject(url, String.class), operation, "double");
    }

    public String GetDeliveries(String[] recIds) {
        String operation = new Object() {}.getClass().getEnclosingMethod().getName();
        String url = SetCredentials(SEND_Endpoint, operation) + ArrayToString("recIds", recIds);
        return InspectResponse(this.restTemplate.getForObject(url, String.class), operation, "ArrayOfInt");
    }

    public String GetDeliveries3(String[] recId) {
        String operation = new Object() {}.getClass().getEnclosingMethod().getName();
        String url = SetCredentials(SEND_Endpoint, operation) + ArrayToString("recId", recId);
        return InspectResponse(this.restTemplate.getForObject(url, String.class), operation, "ArrayOfInt");
    }

    public String GetSmsPrice(GetSmsPriceModel model) {
        String operation = new Object() {}.getClass().getEnclosingMethod().getName();
        String url = SetCredentials(SEND_Endpoint, operation) + ObjectToString(model);
        return InspectResponse(this.restTemplate.getForObject(url, String.class), operation, "double");
    }

    public String SendByBaseNumber(SendByBaseNumberModel model) {
        String operation = new Object() {}.getClass().getEnclosingMethod().getName();
        String url = SetCredentials(SEND_Endpoint, operation) + ObjectToString(model);
        return InspectResponse(this.restTemplate.getForObject(url, String.class), operation, "string");
    }

    public String SendByBaseNumber2(SendByBaseNumber2Model model) {
        String operation = new Object() {}.getClass().getEnclosingMethod().getName();
        String url = SetCredentials(SEND_Endpoint, operation) + ObjectToString(model);
        return InspectResponse(this.restTemplate.getForObject(url, String.class), operation, "string");
    }

    public String SendByBaseNumber3(SendByBaseNumber3Model model) {
        String operation = new Object() {}.getClass().getEnclosingMethod().getName();
        String url = SetCredentials(SEND_Endpoint, operation) + ObjectToString(model);
        return InspectResponse(this.restTemplate.getForObject(url, String.class), operation, "string");
    }

    public String SendSimpleSMS(SendSimpleSMSModel model) {
        String operation = new Object() {}.getClass().getEnclosingMethod().getName();
        String url = SetCredentials(SEND_Endpoint, operation) + ObjectToString(model);
        return InspectResponse(this.restTemplate.getForObject(url, String.class), operation, "ArrayOfString");
    }

    public String SendSimpleSMS2(SendSimpleSMS2Model model) {
        String operation = new Object() {}.getClass().getEnclosingMethod().getName();
        String url = SetCredentials(SEND_Endpoint, operation) + ObjectToString(model);
        return InspectResponse(this.restTemplate.getForObject(url, String.class), operation, "string");
    }

    public String SendSms(SendSmsModel model) {
        String operation = new Object() {}.getClass().getEnclosingMethod().getName();
        String url = SetCredentials(SEND_Endpoint, operation) + ObjectToString(model);
        return InspectResponse(this.restTemplate.getForObject(url, String.class), operation, "SendSmsResult");
    }

    public String SendSms2(SendSms2Model model) {
        String operation = new Object() {}.getClass().getEnclosingMethod().getName();
        String url = SetCredentials(SEND_Endpoint, operation) + ObjectToString(model);
        return InspectResponse(this.restTemplate.getForObject(url, String.class), operation, "SendSms2Result");
    }

    public String SendMultipleSMS(SendMultipleSMSModel model) {
        String operation = new Object() {}.getClass().getEnclosingMethod().getName();
        String url = SetCredentials(SEND_Endpoint, operation) + ObjectToString(model);
        return InspectResponse(this.restTemplate.getForObject(url, String.class), operation, "SendMultipleSMSResult");
    }

    public String SendMultipleSMS2(SendMultipleSMS2Model model) {
        String operation = new Object() {}.getClass().getEnclosingMethod().getName();
        String url = SetCredentials(SEND_Endpoint, operation) + ObjectToString(model);
        return InspectResponse(this.restTemplate.getForObject(url, String.class), operation, "SendMultipleSMS2Result");
    }


    // RECEIVE
    public String ChangeMessageIsRead(String msgIds) {
        String operation = new Object() {}.getClass().getEnclosingMethod().getName();
        String url = SetCredentials(RECEIVE_Endpoint, operation) + "&msgIds=" + msgIds;
        return InspectResponse(this.restTemplate.getForObject(url, String.class), operation, "int");
    }

    public String GetInboxCount(Boolean isRead) {
        String operation = new Object() {}.getClass().getEnclosingMethod().getName();
        String url = SetCredentials(RECEIVE_Endpoint, operation) + "&isRead=" + isRead.toString();
        return InspectResponse(this.restTemplate.getForObject(url, String.class), operation, "int");
    }

    public String GetLatestReceiveMsg(String sender, String receiver) {
        String operation = new Object() {}.getClass().getEnclosingMethod().getName();
        String url = SetCredentials(RECEIVE_Endpoint, operation) + "&sender=" + sender + "&receiver=" + receiver;
        return InspectResponse(this.restTemplate.getForObject(url, String.class), operation, "LatestMsgReport");
    }

    public String GetMessages(GetMessagesModel model) {
        String operation = new Object() {}.getClass().getEnclosingMethod().getName();
        String url = SetCredentials(RECEIVE_Endpoint, operation) + ObjectToString(model);
        return InspectResponse(this.restTemplate.getForObject(url, String.class), operation, "ArrayOfMessagesBL");
    }

    public String GetMessagesAfterID(GetMessagesAfterIDModel model) {
        String operation = new Object() {}.getClass().getEnclosingMethod().getName();
        String url = SetCredentials(RECEIVE_Endpoint, operation) + ObjectToString(model);
        return InspectResponse(this.restTemplate.getForObject(url, String.class), operation, "ArrayOfMessagesBL");
    }

    public String GetMessagesFilterByDate(GetMessagesFilterByDateModel model) {
        String operation = new Object() {}.getClass().getEnclosingMethod().getName();
        String url = SetCredentials(RECEIVE_Endpoint, operation) + ObjectToString(model);
        return InspectResponse(this.restTemplate.getForObject(url, String.class), operation, "ArrayOfMessagesBL");
    }

    public String GetMessagesReceptions(Integer msgId, Integer fromRows) {
        String operation = new Object() {}.getClass().getEnclosingMethod().getName();
        String url = SetCredentials(RECEIVE_Endpoint, operation) + "&msgId=" + msgId.toString() + "&fromRows=" + fromRows.toString();
        return InspectResponse(this.restTemplate.getForObject(url, String.class), operation, "ArrayOfMsgReceptions");
    }

    public String GetMessagesWithChangeIsRead(GetMessagesWithChangeIsReadModel model) {
        String operation = new Object() {}.getClass().getEnclosingMethod().getName();
        String url = SetCredentials(RECEIVE_Endpoint, operation) + ObjectToString(model);
        return InspectResponse(this.restTemplate.getForObject(url, String.class), operation, "ArrayOfMessagesBL");
    }

    public String GetOutBoxCount() {
        String operation = new Object() {}.getClass().getEnclosingMethod().getName();
        String url = SetCredentials(RECEIVE_Endpoint, operation);
        return InspectResponse(this.restTemplate.getForObject(url, String.class), operation, "int");
    }

    // location values: Received or Sent or Removed or Deleted
    public String RemoveMessages(String location, String msgIds) {
        String operation = new Object() {}.getClass().getEnclosingMethod().getName();
        String url = SetCredentials(RECEIVE_Endpoint, operation) + "&location=" + location + "&msgIds=" + msgIds;
        return InspectResponse(this.restTemplate.getForObject(url, String.class), operation, "int");
    }


    // USER
    public String AddUser(AddUserModel model) {
        String operation = new Object() {}.getClass().getEnclosingMethod().getName();
        String url = SetCredentials(USER_Endpoint, operation) + ObjectToString(model);
        return InspectResponse(this.restTemplate.getForObject(url, String.class), operation, "int");
    }

    public String AddUserWithLocation(AddUserWithLocationModel model) {
        String operation = new Object() {}.getClass().getEnclosingMethod().getName();
        String url = SetCredentials(USER_Endpoint, operation) + ObjectToString(model);
        return InspectResponse(this.restTemplate.getForObject(url, String.class), operation, "int");
    }

    public String AddUserWithMobileNumber(AddUserWithMobileNumberModel model) {
        String operation = new Object() {}.getClass().getEnclosingMethod().getName();
        String url = SetCredentials(USER_Endpoint, operation) + ObjectToString(model);
        return InspectResponse(this.restTemplate.getForObject(url, String.class), operation, "string");
    }

    public String AddUserWithMobileNumber2(AddUserWithMobileNumber2Model model) {
        String operation = new Object() {}.getClass().getEnclosingMethod().getName();
        String url = SetCredentials(USER_Endpoint, operation) + ObjectToString(model);
        return InspectResponse(this.restTemplate.getForObject(url, String.class), operation, "string");
    }

    public String AddUserWithUserNameAndPass(AddUserWithUserNameAndPassModel model) {
        String operation = new Object() {}.getClass().getEnclosingMethod().getName();
        String url = SetCredentials(USER_Endpoint, operation) + ObjectToString(model);
        return InspectResponse(this.restTemplate.getForObject(url, String.class), operation, "string");
    }

    public String AuthenticateUser() {
        String operation = new Object() {}.getClass().getEnclosingMethod().getName();
        String url = SetCredentials(USER_Endpoint, operation);
        return InspectResponse(this.restTemplate.getForObject(url, String.class), operation, "int");
    }

    public String ChangeUserCredit(ChangeUserCreditModel model) {
        String operation = new Object() {}.getClass().getEnclosingMethod().getName();
        String url = SetCredentials(USER_Endpoint, operation) + ObjectToString(model);
        return InspectResponse(this.restTemplate.getForObject(url, String.class), operation, "int");
    }

    public String DeductUserCredit(Double amount, String description) {
        String operation = new Object() {}.getClass().getEnclosingMethod().getName();
        String url = SetCredentials(USER_Endpoint, operation) + "&amount=" + amount.toString() + "&description=" + description;
        return InspectResponse(this.restTemplate.getForObject(url, String.class), operation, "int");
    }

    public String ForgotPassword(ForgotPasswordModel model) {
        String operation = new Object() {}.getClass().getEnclosingMethod().getName();
        String url = SetCredentials(USER_Endpoint, operation) + ObjectToString(model);
        return InspectResponse(this.restTemplate.getForObject(url, String.class), operation, "int");
    }

    public String GetCities(Integer provinceId) {
        String operation = new Object() {}.getClass().getEnclosingMethod().getName();
        String url = SetCredentials(USER_Endpoint, operation) + "&provinceId=" + provinceId.toString();
        return InspectResponse(this.restTemplate.getForObject(url, String.class), operation, "ArrayOfCity");
    }

    public String GetEnExpireDate() {
        String operation = new Object() {}.getClass().getEnclosingMethod().getName();
        String url = SetCredentials(USER_Endpoint, operation);
        return InspectResponse(this.restTemplate.getForObject(url, String.class), operation, "dateTime");
    }

    public String GetExpireDate() {
        String operation = new Object() {}.getClass().getEnclosingMethod().getName();
        String url = SetCredentials(USER_Endpoint, operation);
        return InspectResponse(this.restTemplate.getForObject(url, String.class), operation, "string");
    }

    public String GetProvinces() {
        String operation = new Object() {}.getClass().getEnclosingMethod().getName();
        String url = SetCredentials(USER_Endpoint, operation);
        return InspectResponse(this.restTemplate.getForObject(url, String.class), operation, "ArrayOfProvince");
    }

    public String GetUserBasePrice(String targetUsername) {
        String operation = new Object() {}.getClass().getEnclosingMethod().getName();
        String url = SetCredentials(USER_Endpoint, operation) + "&targetUsername=" + targetUsername;
        return InspectResponse(this.restTemplate.getForObject(url, String.class), operation, "double");
    }

    public String GetUserCredit(String targetUsername) {
        String operation = new Object() {}.getClass().getEnclosingMethod().getName();
        String url = SetCredentials(USER_Endpoint, operation) + "&targetUsername=" + targetUsername;
        return InspectResponse(this.restTemplate.getForObject(url, String.class), operation, "double");
    }

    public String GetUserCredit2() {
        String operation = new Object() {}.getClass().getEnclosingMethod().getName();
        String url = SetCredentials(USER_Endpoint, operation);
        return InspectResponse(this.restTemplate.getForObject(url, String.class), operation, "double");
    }

    public String GetUserDetails(String targetUsername) {
        String operation = new Object() {}.getClass().getEnclosingMethod().getName();
        String url = SetCredentials(USER_Endpoint, operation) + "&targetUsername=" + targetUsername;
        return InspectResponse(this.restTemplate.getForObject(url, String.class), operation, "UserGridList");
    }

    public String GetUserIsExist(String targetUsername) {
        String operation = new Object() {}.getClass().getEnclosingMethod().getName();
        String url = SetCredentials(USER_Endpoint, operation) + "&targetUsername=" + targetUsername;
        return InspectResponse(this.restTemplate.getForObject(url, String.class), operation, "double");
    }

    public String GetUserNumbers() {
        String operation = new Object() {}.getClass().getEnclosingMethod().getName();
        String url = SetCredentials(USER_Endpoint, operation);
        return InspectResponse(this.restTemplate.getForObject(url, String.class), operation, "ArrayOfString");
    }

    
    public String GetUserTransactions(GetUserTransactionsModel model) {
        String operation = new Object() {}.getClass().getEnclosingMethod().getName();
        String url = SetCredentials(USER_Endpoint, operation) + ObjectToString(model);
        return InspectResponse(this.restTemplate.getForObject(url, String.class), operation, "ArrayOfCredistGridList");
    }

    public String GetUserWallet() {
        String operation = new Object() {}.getClass().getEnclosingMethod().getName();
        String url = SetCredentials(USER_Endpoint, operation);
        return InspectResponse(this.restTemplate.getForObject(url, String.class), operation, "double");
    }

    public String GetUserWalletTransaction(GetUserWalletTransactionModel model) {
        String operation = new Object() {}.getClass().getEnclosingMethod().getName();
        String url = SetCredentials(USER_Endpoint, operation) + ObjectToString(model);
        return InspectResponse(this.restTemplate.getForObject(url, String.class), operation, "ArrayOfWalletGridList");
    }

    public String GetUsers() {
        String operation = new Object() {}.getClass().getEnclosingMethod().getName();
        String url = SetCredentials(USER_Endpoint, operation);
        return InspectResponse(this.restTemplate.getForObject(url, String.class), operation, "ArrayOfUserGridList");
    }

    public String RemoveUser(String targetUsername) {
        String operation = new Object() {}.getClass().getEnclosingMethod().getName();
        String url = SetCredentials(USER_Endpoint, operation) + "&targetUsername=" + targetUsername;
        return InspectResponse(this.restTemplate.getForObject(url, String.class), operation, "int");
    }


    // VOICE
    public String SendBulkSpeechText(SendBulkSpeechTextModel model) {
        String operation = new Object() {}.getClass().getEnclosingMethod().getName();
        String url = SetCredentials(VOICE_Endpoint, operation) + ObjectToString(model);
        return InspectResponse(this.restTemplate.getForObject(url, String.class), operation, "int");
    }

    public String SendBulkVoiceSMS(SendBulkVoiceSMSModel model) {
        String operation = new Object() {}.getClass().getEnclosingMethod().getName();
        String url = SetCredentials(VOICE_Endpoint, operation) + ObjectToString(model);
        return InspectResponse(this.restTemplate.getForObject(url, String.class), operation, "int");
    }

    public String UploadVoiceFile(String title, String base64StringFile) {
        String operation = new Object() {}.getClass().getEnclosingMethod().getName();
        String url = SetCredentials(VOICE_Endpoint, operation) + "&title=" + title + "&base64StringFile=" + base64StringFile;
        return InspectResponse(this.restTemplate.getForObject(url, String.class), operation, "int");
    }



    // CONTACT
    public String AddContact(AddContactModel model) {
        String operation = new Object() {}.getClass().getEnclosingMethod().getName();
        String url = SetCredentials(CONTACT_Endpoint, operation) + ObjectToString(model);
        return InspectResponse(this.restTemplate.getForObject(url, String.class), operation, "int");
    }

    public String AddContactEvents(AddContactEventsModel model) {
        String operation = new Object() {}.getClass().getEnclosingMethod().getName();
        String url = SetCredentials(CONTACT_Endpoint, operation) + ObjectToString(model);
        return InspectResponse(this.restTemplate.getForObject(url, String.class), operation, "int");
    }

    public String AddGroup(AddGroupModel model) {
        String operation = new Object() {}.getClass().getEnclosingMethod().getName();
        String url = SetCredentials(CONTACT_Endpoint, operation) + ObjectToString(model);
        return InspectResponse(this.restTemplate.getForObject(url, String.class), operation, "int");
    }

    public String ChangeContact(ChangeContactModel model) {
        String operation = new Object() {}.getClass().getEnclosingMethod().getName();
        String url = SetCredentials(CONTACT_Endpoint, operation) + ObjectToString(model);
        return InspectResponse(this.restTemplate.getForObject(url, String.class), operation, "int");
    }

    public String ChangeGroup(ChangeGroupModel model) {
        String operation = new Object() {}.getClass().getEnclosingMethod().getName();
        String url = SetCredentials(CONTACT_Endpoint, operation) + ObjectToString(model);
        return InspectResponse(this.restTemplate.getForObject(url, String.class), operation, "int");
    }

    public String CheckMobileExistInContact(String mobileNumber) {
        String operation = new Object() {}.getClass().getEnclosingMethod().getName();
        String url = SetCredentials(CONTACT_Endpoint, operation) + "&mobileNumber=" + mobileNumber;
        return InspectResponse(this.restTemplate.getForObject(url, String.class), operation, "int");
    }

    public String GetContactEvents(Integer contactId) {
        String operation = new Object() {}.getClass().getEnclosingMethod().getName();
        String url = SetCredentials(CONTACT_Endpoint, operation) + "&contactId=" + contactId.toString();
        return InspectResponse(this.restTemplate.getForObject(url, String.class), operation, "ArrayOfContactEventBL");
    }

    public String GetContacts(GetContactsModel model) {
        String operation = new Object() {}.getClass().getEnclosingMethod().getName();
        String url = SetCredentials(CONTACT_Endpoint, operation) + ObjectToString(model);
        return InspectResponse(this.restTemplate.getForObject(url, String.class), operation, "ArrayOfContactsGridList");
    }

    public String GetContactsByID(Integer contactId, Integer status) {
        String operation = new Object() {}.getClass().getEnclosingMethod().getName();
        String url = SetCredentials(CONTACT_Endpoint, operation) + "&contactId=" + contactId.toString() + "&status=" + status.toString();
        return InspectResponse(this.restTemplate.getForObject(url, String.class), operation, "ArrayOfContactsGridList");
    }

    public String GetGroups() {
        String operation = new Object() {}.getClass().getEnclosingMethod().getName();
        String url = SetCredentials(CONTACT_Endpoint, operation);
        return InspectResponse(this.restTemplate.getForObject(url, String.class), operation, "ArrayOfGroupsList");
    }

    public String MergeGroups(MergeGroupsModel model) {
        String operation = new Object() {}.getClass().getEnclosingMethod().getName();
        String url = SetCredentials(CONTACT_Endpoint, operation) + ObjectToString(model);
        return InspectResponse(this.restTemplate.getForObject(url, String.class), operation, "int");
    }

    public String RemoveContact(String mobilenumber) {
        String operation = new Object() {}.getClass().getEnclosingMethod().getName();
        String url = SetCredentials(CONTACT_Endpoint, operation) + "&mobilenumber=" + mobilenumber;
        return InspectResponse(this.restTemplate.getForObject(url, String.class), operation, "int");
    }

    public String RemoveContactByContactID(Integer contactId) {
        String operation = new Object() {}.getClass().getEnclosingMethod().getName();
        String url = SetCredentials(CONTACT_Endpoint, operation) + "&contactId=" + contactId.toString();
        return InspectResponse(this.restTemplate.getForObject(url, String.class), operation, "int");
    }

    public String RemoveGroup(Integer groupId) {
        String operation = new Object() {}.getClass().getEnclosingMethod().getName();
        String url = SetCredentials(CONTACT_Endpoint, operation) + "&groupId=" + groupId.toString();
        return InspectResponse(this.restTemplate.getForObject(url, String.class), operation, "int");
    }


    // 


    


    // Helper methods
    private String ObjectToString(Object obj) {
        return "&" + Arrays.stream(obj.getClass().getFields())
                .filter(Objects::nonNull)
                .map(f -> {
                    try {
                        if(isArray(f.get(obj)))
                            return ArrayToString(f.getName(), (Object[])f.get(obj));
                        return f.getName() + "=" + f.get(obj).toString();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    return null;
                }).collect(Collectors.joining("&"));
    }


    private static boolean isArray(Object obj)
    {
        return obj instanceof int[] || obj instanceof String[] || obj instanceof Long[];
    }


    private String ArrayToString(String name, Object... items) {
        String result = "";
        for (Object i : items) {
            result += "&" + name + "=" + String.valueOf(i);
        }
        return result;
    }


    private String InspectResponse(String response, String operation, String field) {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            // optional, but recommended
            // process XML securely, avoid attacks like XML External Entities (XXE)
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            // parse XML file
            DocumentBuilder db = dbf.newDocumentBuilder();
            InputSource is = new InputSource(new StringReader(response));
            Document doc = db.parse(is);
            // optional, but recommended
            // http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            doc.getDocumentElement().normalize();

            if (doc.getDocumentElement().getNodeName() == field)
                return doc.getDocumentElement().getTextContent();

            NodeList list = doc.getElementsByTagName(operation + "Response");

            for (int temp = 0; temp < list.getLength(); temp++) {

                Node node = list.item(temp);

                if (node.getNodeType() == Node.ELEMENT_NODE) {

                    Element element = (Element) node;

                    if (node.getNodeName() == field)
                        return element.getElementsByTagName(field).item(0).getTextContent();
                }
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

        return response;
    }
}