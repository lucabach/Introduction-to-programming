
public class Sms implements Message {
	
	String sms;
	
	public Sms(String text) {
		this.sms = text;
	}
	public String getPayload() {
		return "";
	}

}
