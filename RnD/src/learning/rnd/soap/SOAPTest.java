package learning.rnd.soap;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

public class SOAPTest {

	public static void main(String [] args) {
		try {
			QName servicename = new QName("http://dfma.etiqa.fl.com", "DfmaAgentImplService");
			QName portName = new QName("http://dfma.etiqa.fl.com", "DfmaAgentImplPort");
			Service service = Service.create(servicename);
			service.addPort(portName, SOAPBinding.SOAP11HTTP_BINDING, "https://t1.financial-link.com.my/DFMAservice/DfmaAgent");
			Dispatch<SOAPMessage> dispatch = service.createDispatch(portName, SOAPMessage.class, Service.Mode.MESSAGE);
			MessageFactory messageFactory = MessageFactory.newInstance(SOAPConstants.SOAP_1_1_PROTOCOL);
			SOAPMessage request = messageFactory.createMessage();
			SOAPPart part = request.getSOAPPart();
			SOAPEnvelope envelope = part.getEnvelope();
			envelope.addNamespaceDeclaration("dfma", "http://dfma.etiqa.fl.com");
			SOAPHeader header = envelope.getHeader();
			SOAPBody body = envelope.getBody();
			
			// Create SSL context and trust all certificates
            SSLContext sslContext = SSLContext.getInstance("SSL");
            TrustManager[] trustAll
                    = new TrustManager[] {new TrustAllCertificates()};
            sslContext.init(null, trustAll, new java.security.SecureRandom());
            // Set trust all certificates context to HttpsURLConnection
            HttpsURLConnection
                    .setDefaultSSLSocketFactory(sslContext.getSocketFactory());
            // Open HTTPS connection
            URL url = new URL(null, "https://t1.financial-link.com.my/DFMAservice/DfmaAgent", new sun.net.www.protocol.https.Handler());
            HttpsURLConnection httpsConnection = (HttpsURLConnection) url.openConnection();
            // Trust all hosts
            httpsConnection.setHostnameVerifier(new TrustAllHosts());
            // Connect
            httpsConnection.connect();
            
            
			SOAPElement operation = body.addChildElement("GetAgentDetail","dfma","http://dfma.etiqa.fl.com");
			SOAPElement operation1 = operation.addChildElement("arg0","dfma","http://dfma.etiqa.fl.com");
			SOAPElement requesttype = operation1.addChildElement("requesttype","dfma","http://dfma.etiqa.fl.com");
			requesttype.addTextNode("L");
			SOAPElement login = operation1.addChildElement("login","dfma","http://dfma.etiqa.fl.com");
			login.addTextNode("epkoon");
			SOAPElement password = operation1.addChildElement("password","dfma","http://dfma.etiqa.fl.com");
			password.addTextNode("abc123");
			SOAPElement oldpassword = operation1.addChildElement("oldpassword","dfma","http://dfma.etiqa.fl.com");
			oldpassword.addTextNode("");
			SOAPElement email = operation1.addChildElement("email","dfma","http://dfma.etiqa.fl.com");
			email.addTextNode("");
			SOAPElement timestamp = operation1.addChildElement("timestamp","dfma","http://dfma.etiqa.fl.com");
			timestamp.addTextNode("2018-04-12 09:47:09.000000");
			SOAPElement securekey = operation1.addChildElement("securekey","dfma","http://dfma.etiqa.fl.com");
			securekey.addTextNode("uxTpIbWJQrl5I/D645rT+3z9jYY=");
			SOAPElement entity = operation1.addChildElement("entity","dfma","http://dfma.etiqa.fl.com");
			entity.addTextNode("I");

			request.saveChanges();
			
			loggingSoapMessage(request);
			
			SOAPMessage response = dispatch.invoke(request);
			
			loggingSoapMessage(response);
			
			SOAPBody responseBody = response.getSOAPBody();
			String value = responseBody.getElementsByTagName("GetAgentResponse").item(0).getTextContent();
			
			System.out.println("Result = "+value);

		} catch (SOAPException e) {	
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void loggingSoapMessage(SOAPMessage soapMessage) {
		String result = null;
		if (soapMessage != null) {
			ByteArrayOutputStream baos = null;
			try {
				baos = new ByteArrayOutputStream();
				soapMessage.writeTo(baos);
				result = baos.toString();
			} catch (Exception e) {
			} finally {
				if (baos != null) {
					try {
						baos.close();
					} catch (IOException ioe) {
					}
				}
			}
		}
		System.out.println("SOAP Message : "+result);
	}
}
