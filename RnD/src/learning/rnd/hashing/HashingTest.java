package learning.rnd.hashing;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
 
public class HashingTest {
 
    /**
     * @param args
     * @throws NoSuchAlgorithmException 
     * @throws UnsupportedEncodingException 
     */
    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String verificationResult = "uxTpIbWJQrl5I/D645rT+3z9jYY=";
        String input = "dF88MvF92Wx42018-04-12 09:47:09.000epkoonabc123";
        
        byte[] encrypted = sha1ByteArray(input);
        String encoded=encodeBase64(encrypted);
        System.out.println("Encrypted byte array : "+encrypted);
        System.out.println("Base64 encoding of encrypted byte array : "+encoded);
        
        System.out.println("Encoded encryption check : "+verificationResult.equals(encoded));
        
        String hexSha1 = sha1(input);
        System.out.println("Hex SHA1 result : "+hexSha1);
        
        byte[] encrypted2 = sha1ByteArray("wtc-sutra");
        String encoded2=encodeBase64(encrypted2);
        System.out.println("Base64 encoding of SHA1 result : "+encoded2);
    }
     
    public static String sha1(String input) throws NoSuchAlgorithmException {
        MessageDigest mDigest = MessageDigest.getInstance("SHA1");
        byte[] result = mDigest.digest(input.getBytes(StandardCharsets.US_ASCII));
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length; i++) {
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }
         
        return sb.toString();
    }
    
    public static byte[] sha1ByteArray(String input) throws NoSuchAlgorithmException {
    	MessageDigest md;
        md = MessageDigest.getInstance("SHA-1");
        byte[] sha1hash = new byte[40];
        md.update(input.getBytes(StandardCharsets.US_ASCII), 0, input.length());
        sha1hash = md.digest();
        
        return sha1hash;
    }
    public static String encodeBase64(byte[] value) {
    	String encodedString = Base64.getEncoder().encodeToString(value);
    	return encodedString;
    }
    
    public static String decodeBase64(String value) {
    	byte[] decodedBytes = Base64.getDecoder().decode(value);
    	String decodedString = new String(decodedBytes);
    	return decodedString;
    }
    
}