package learning.rnd.swtc;

import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

public class GeneratePdsDocCpf {

	public static void main(String[] args) {
		try {
			String lang = "lan_en";
			QName qname1 = new QName("http://wtc.wcservices.dsp.etiqa.com/", "WTCDocGenWebServiceImplService");
			QName portname1 = new QName("http://wtc.wcservices.dsp.etiqa.com/", "WTCDocGenWebServiceImplPort");
			Service service1 = Service.create(qname1);
			service1.addPort(portname1, SOAPBinding.SOAP11HTTP_BINDING,
					"http://172.29.124.1:7011/CPF-DSP_SWTC_Doc/WTCDocGenWebServiceImplService");
			Dispatch<SOAPMessage> dispatch1 = service1.createDispatch(portname1, SOAPMessage.class,
					Service.Mode.MESSAGE);
			MessageFactory mf1 = MessageFactory.newInstance(SOAPConstants.SOAP_1_1_PROTOCOL);
			SOAPMessage req1 = mf1.createMessage();
			SOAPPart part1 = req1.getSOAPPart();
			SOAPEnvelope env1 = part1.getEnvelope();
			SOAPHeader header1 = env1.getHeader();
			SOAPBody body1 = env1.getBody();
			SOAPElement operation1 = body1.addChildElement("getStatusOfPdsBeforePayment", "wtc",
					"http://wtc.wcservices.dsp.etiqa.com/");
			SOAPElement element_occupation_Industry1 = operation1.addChildElement("todayDate");
			element_occupation_Industry1.addTextNode("todate");
			SOAPElement element_langValue = operation1.addChildElement("langValue");
			element_langValue.addTextNode(lang);
			
			req1.saveChanges();
			SOAPMessage resp1 = dispatch1.invoke(req1);
			SOAPBody responsebody1 = resp1.getSOAPBody();
			String value = responsebody1.getElementsByTagName("return").item(0).getTextContent();
			System.out.println(responsebody1.getElementsByTagName("return").item(0).getTextContent()+"updated");
			
			System.out.println(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
