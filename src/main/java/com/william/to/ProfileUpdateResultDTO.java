package com.william.to;

public class ProfileUpdateResultDTO {
	private boolean addressUpdate;
	private boolean profileUpdate;
	
	public boolean isAddressUpdate() {
		return addressUpdate;
	}
	public void setAddressUpdate(boolean addressUpdate) {
		this.addressUpdate = addressUpdate;
	}
	public boolean isProfileUpdate() {
		return profileUpdate;
	}
	public void setProfileUpdate(boolean profileUpdate) {
		this.profileUpdate = profileUpdate;
	}

}
