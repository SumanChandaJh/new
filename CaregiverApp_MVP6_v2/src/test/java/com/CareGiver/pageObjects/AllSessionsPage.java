package com.CareGiver.pageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.CareGiver.Base.Base;
import com.CareGiver.Base.CommonUtil;
import com.CareGiver.Base.TestUtil;
import com.CareGiver.domains.DomainSetup;
import com.CareGiver.domains.Session;

import io.appium.java_client.AppiumDriver;

public class AllSessionsPage extends Base {

	DomainSetup domain;
	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@value=\"CareGiver\"]//preceding::XCUIElementTypeStaticText")
	public WebElement PageTitle_ios;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@value=\"CareGiver\"]//preceding::XCUIElementTypeStaticText")
	public WebElement PageTitle_android;

	@FindBy(xpath = "//XCUIElementTypeButton[@label=\"add\"]")
	public WebElement AddBtn_ios;

	@FindBy(xpath = "//android.widget.Button[@text=\"add\"]")
	public WebElement AddBtn_android;

	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@label,\"Sessions\")]//parent::XCUIElementTypeOther/following::XCUIElementTypeOther")
	public WebElement SessionList_ios;

	@FindBy(xpath = "//android.widget.Button[@text=\"arrow back\"]//parent::android.view.View[1]/parent::android.view.View[1]/following::android.view.View//android.view.View[2]/android.view.View")
	public WebElement SessionList_android;

	@FindBy(xpath = "//android.view.View[contains(@text,\"No\")]")
	public WebElement NoSession_android;

	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@label,\"No\")]")
	public WebElement NoSession_ios;

	@SuppressWarnings("static-access")
	public AllSessionsPage(AppiumDriver<WebElement> appDriver) {
		super.appDriver = appDriver;
		PageFactory.initElements(Base.appDriver, this);
	}
	

	public List<WebElement> getSessionElementList() {
		Base.appDriver.context("NATIVE_APP");
		if (isIOS())
			return SessionList_ios
					.findElements(By.xpath("//XCUIElementTypeButton[contains(@label,\"arrow forward\")]"));
		else
			return SessionList_android
					.findElements(By.xpath("//android.widget.Button[contains(@text,\"arrow forward\")]"));
	}

	public List<Session> parseSessionText() {
		List<Session> sessions = new ArrayList<Session>();

		if (getSessionElementList().size() > 0) {
			List<WebElement> sessionsElements = getSessionElementList();
			// System.err.println(sessionsElements.size());

			for (WebElement session : sessionsElements) {
				Session singleSession = new Session();
				System.out.println(TestUtil.getElementText(session));

				String txt = TestUtil.getElementText(session);
				String totalCharges = parseTotalCharges(txt);

				String pattern = "(^\\d{2}/\\d{2}/\\d{4})\\s+(\\d{1,2}:\\d{2}\\s+(?i)(am|pm))\\s\\D\\s(\\d{1,2}:\\d{2}\\s+(?i)(am|pm))";

				// Create a Pattern object
				Pattern r = Pattern.compile(pattern);

				// create matcher object.
				Matcher m = r.matcher(txt);

				if (m.find()) {
					singleSession.setCheckinDate(m.group(1).trim());
					singleSession.setStartTime(m.group(2).trim());
					singleSession.setEndTime(m.group(4).trim());
					singleSession.setTotalCharges(totalCharges);
				}

				sessions.add(singleSession);
			}

		}
		
		return sessions;
	}

	public boolean verifyCheckInDate(String dateFormat, List<Session> sessions) {
		List<Boolean> status = new ArrayList<Boolean>();

		for (Session session : sessions) {
			if (!CommonUtil.isValidFormat(dateFormat, session.getCheckinDate())) {
				System.err.println("date:" + session.getCheckinDate() + "---problem");
				status.add(false);
			}
		}

		return TestUtil.checkStatusList(status);
	}

	public boolean verifyStartEndTime(String format, List<Session> sessions) {
		List<Boolean> status = new ArrayList<Boolean>();

		for (Session session : sessions) {
			if (!CommonUtil.isValidFormat(format, session.getStartTime())
					|| !CommonUtil.isValidFormat(format, session.getEndTime())) {
				System.err.println("FAIL -- Invalid Format");
				status.add(false);
			}

		}

		return TestUtil.checkStatusList(status);
	}

	public boolean verifyTotalCharges(String dollarSign, List<Session> sessions) {
		List<Boolean> status = new ArrayList<Boolean>();

		for (Session session : sessions) {
			String tCharge = session.getTotalCharges();
			System.err.println(tCharge);
			status.add(tCharge.contains(dollarSign));
		}

		return TestUtil.checkStatusList(status);
	}

	public String parseTotalCharges(String str) {
		return str.split(Pattern.quote("|"))[1].trim().split("arrow")[0].trim();

	}

	public boolean verifyNoSessionsMessage(String msg) {
		WebElement messageObj = null;
		boolean match = false;

		if (isIOS())
			messageObj = NoSession_ios;
		if (messageObj != null) {
			System.err.println("Actual Text:" + TestUtil.getElementText(messageObj));
			if (TestUtil.getElementText(messageObj).equalsIgnoreCase(msg))
				match = true;
			else
				match = false;
		} else if (isAnroid())
			// messageObj = NoSession_android;
			match = TestUtil.objectCheckpointByText(msg, "1");

		System.err.println("verify status:" + match);
		return match;
	}

	public WebElement getAddSessionBtn() {
		WebElement button = null;

		if (isIOS())
			button = AddBtn_ios;
		else
			button = AddBtn_android;

		return button;
	}

}
