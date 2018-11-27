package testing;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;

public class testPassword {
	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchProviderException {
		String passwordToHash = "password";
		byte[] salt = getSalt();
		String s = new String(salt);
		System.out.println(s);
		byte[] bs = s.getBytes();
		String securePassword = getSecurePassword(passwordToHash, salt);
		System.out.println(securePassword);
		String regeneratedPassowrdToVerify = getSecurePassword(passwordToHash, bs);
		System.out.println(regeneratedPassowrdToVerify);
	}

	private static String getSecurePassword(String passwordToHash, byte[] salt) {
		String generatedPassword = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(salt);
			byte[] bytes = md.digest(passwordToHash.getBytes());
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			generatedPassword = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return generatedPassword;
	}

	// Add salt
	private static byte[] getSalt() throws NoSuchAlgorithmException, NoSuchProviderException {
		SecureRandom sr = SecureRandom.getInstance("SHA1PRNG", "SUN");
		byte[] salt = new byte[16];
		sr.nextBytes(salt);
		return salt;
	}
}