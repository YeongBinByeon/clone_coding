package strategy;

import java.util.Base64;

public class Base64Strategy implements EncodingStrategy{

	@Override
	public String encode(String text) {
		// TODO Auto-generated method stub
		return Base64.getEncoder().encodeToString(text.getBytes());
	}

}
