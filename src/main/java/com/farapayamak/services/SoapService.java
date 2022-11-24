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

    private String SEND_Endpoint = "http://api.payamak-panel.com/post/send.asmx/%s?username=%s&password=%s";

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

    public String SendByBaseNumber3(SendByBaseNumber3 model) {
        String operation = new Object() {}.getClass().getEnclosingMethod().getName();
        String url = SetCredentials(SEND_Endpoint, operation) + ObjectToString(model);
        return InspectResponse(this.restTemplate.getForObject(url, String.class), operation, "string");
    }

    


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