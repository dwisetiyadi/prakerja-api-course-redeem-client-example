import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.Formatter;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class Main {
  private static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";

  private static String toHexString(byte[] bytes) {
    try (Formatter formatter = new Formatter()) {
      for (byte b : bytes) {
        formatter.format("%02x", b);
      }

      return formatter.toString();
    }
  }

  public static String calculateRFC2104HMAC(String data, String key)
      throws SignatureException, NoSuchAlgorithmException, InvalidKeyException {
    SecretKeySpec signingKey = new SecretKeySpec(key.getBytes(), HMAC_SHA1_ALGORITHM);
    Mac mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
    mac.init(signingKey);
    return toHexString(mac.doFinal(data.getBytes()));
  }

  public static void main(String[] args) throws Exception {
    // if using this value bellow should output
    // d46b59b221335976b46eafb752035a1172a8beb2
    String text = "myclient_code1516239022POST/api/v1/integration/payment/redeem-code/commit{\"code\":\"code\"}";
    String key = "my_sign_key";

    String hmac = calculateRFC2104HMAC(text, key);

    System.out.println(hmac);
  }
}