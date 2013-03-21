package org.antonyframework.util;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;



/**
 * String encrypt util.
 */
public final class StringEncryptUtil {
	/**
	 * 
	 */
	private static final String ALGORITHM = "DES";

	/**
	 * The Default Key.
	 */
	public static final String DEFAULT_KEY = "asdfsadf@#$%^$%^%^&*&asdf24243423234";

	public static String encrypt(final String originalString) throws Exception {
		byte[] bEn = encrypt(originalString.getBytes(), DEFAULT_KEY.getBytes());
		return CommonUtils.parseHexStringFromBytes(bEn);
	}
	public static String eencrypt(final String originalString){
		try {
			return encrypt(originalString);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return originalString;
		}
	}

	public static String encrypt(final String originalString, final String key) throws Exception {
		byte[] bEn = encrypt(originalString.getBytes(), key.getBytes());
		return CommonUtils.parseHexStringFromBytes(bEn);
	}

	private static byte[] encrypt(byte[] originalByte, byte[] key) throws Exception {
		SecureRandom sr = new SecureRandom();
		DESKeySpec dks = new DESKeySpec(key);
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
		SecretKey keySpec = keyFactory.generateSecret(dks);
		Cipher cipher = Cipher.getInstance(ALGORITHM);
		cipher.init(Cipher.ENCRYPT_MODE, keySpec, sr);
		return cipher.doFinal(originalByte);

	}

	public static String decrypt(final String encryptedString) throws Exception {
		byte[] bEn = CommonUtils.parseBytesByHexString(encryptedString);
		byte[] orginal = decrypt(bEn, DEFAULT_KEY.getBytes());
		return new String(orginal);
	}

	public static String decrypt(final String encryptedString, final String key) throws Exception {
		byte[] bEn = CommonUtils.parseBytesByHexString(encryptedString);
		byte[] orginal = decrypt(bEn, key.getBytes());
		return new String(orginal);
	}

	private static byte[] decrypt(byte[] encryptedByte, byte[] key) throws Exception {
		SecureRandom sr = new SecureRandom();
		DESKeySpec dks = new DESKeySpec(key);
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
		SecretKey keySpec = keyFactory.generateSecret(dks);
		Cipher cipher = Cipher.getInstance(ALGORITHM);
		cipher.init(Cipher.DECRYPT_MODE, keySpec, sr);
		return cipher.doFinal(encryptedByte);
	}
	
	public static void main(String[] args) {
		String username_id = "rid=309 ";
		try {
			String cookieValue = StringEncryptUtil.encrypt(username_id);
			System.out.println(cookieValue);
			String value = StringEncryptUtil.decrypt(cookieValue);
			System.out.println(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
