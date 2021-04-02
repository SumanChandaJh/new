package com.CareGiver.domains;

public class Session {

	private String checkinDate = "";
	private String startTime = "";
	private String endTime = "";
	private String totalCharges = "";
	private String hourlyRate = "";
	private boolean isSessionStarted = false;
	
	public boolean isSessionStarted() {
		return isSessionStarted;
	}

	public void setSessionStarted(boolean isSessionStarted) {
		this.isSessionStarted = isSessionStarted;
	}

	public String getCheckinDate() {
		return checkinDate;
	}

	public void setCheckinDate(String checkinDate) {
		this.checkinDate = checkinDate;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getTotalCharges() {
		return totalCharges;
	}

	public void setTotalCharges(String totalCharges) {
		this.totalCharges = totalCharges;
	}

	public String getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(String hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

}
