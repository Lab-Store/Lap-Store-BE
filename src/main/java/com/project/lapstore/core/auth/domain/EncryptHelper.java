package com.project.lapstore.core.auth.domain;

public interface EncryptHelper {
	String encrypt(String plainPassword);

	boolean isMatch(String plainPassword, String hashedPassword);
}
