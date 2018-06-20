package learning.rnd.soap;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/**
 * Dummy class implementing HostnameVerifier to trust all host names
 */
public class TrustAllHosts implements HostnameVerifier {
    public boolean verify(String hostname, SSLSession session) {
        return true;
    }
}