package General;

import java.util.Properties;

import org.apache.log4j.Logger;
import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;

public class SMSManager {

	private static final Logger log = Logger.getLogger(SMSManager.class);
	private static SMSManager smsManager;
	private static Properties properties;
	String ACCOUNT_SID, AUTH_TOKEN;

	public static SMSManager getInstance() {
		if (smsManager == null) {
			smsManager = new SMSManager();
			properties = Settings.getInstance();

		}
		return smsManager;
	}

	public String getOTP() {
		String OTP = "";
		ACCOUNT_SID = properties.getProperty("TWILIO_ACCOUNT_SID");
		AUTH_TOKEN = properties.getProperty("TWILIO_AUTH_TOKEN");

		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		ResourceSet<Message> messages = Message.reader().limit(1).read();

		for (Message record : messages) {
			OTP = record.getBody();
			// System.out.println(record.getSid());
		}

		return OTP;
	}

}
