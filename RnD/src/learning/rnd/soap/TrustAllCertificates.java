package learning.rnd.soap;

import java.security.cert.X509Certificate;

import javax.net.ssl.X509TrustManager;

/**
 * Dummy class implementing X509TrustManager to trust all certificates
 */
public class TrustAllCertificates implements X509TrustManager {
    public void checkClientTrusted(X509Certificate[] certs, String authType) {
    }
 
    public void checkServerTrusted(X509Certificate[] certs, String authType) {
    }
 
    public X509Certificate[] getAcceptedIssuers() {
        return null;
    }
}