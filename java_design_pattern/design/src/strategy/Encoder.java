package strategy;

public class Encoder {
	EncodingStrategy encodingStrategy;

	public EncodingStrategy getEncodingStrategy() {
		return encodingStrategy;
	}

	public void setEncodingStrategy(EncodingStrategy encodingStrategy) {
		this.encodingStrategy = encodingStrategy;
	}
	
	public String encode(String text) {
		return this.encodingStrategy.encode(text);
	}
	
}
