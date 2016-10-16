package com.william.service.authenticate;
//Date Validation is Done
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.log4j.Logger;

import com.william.DAO.AddressHistoryDAO;
import com.william.DAO.ProfileDAO;
import com.william.DAO.WorldCitiesDAO;
import com.william.entity.ProfileEntity;
import com.william.to.AddressDTO;
import com.william.to.AddressHistoryInDTO;
import com.william.to.AddressHistoryOutDTO;
import com.william.to.CoordinateDTO;
import com.william.to.PhotoOutDTO;
import com.william.to.ProfileInDTO;
import com.william.to.ProfileOutDTO;
import com.william.to.ProfileUpdateDTO;
import com.william.to.ProfileUpdateResultDTO;
import com.william.to.ValidationResult;
import com.william.util.FileUtil;
import com.william.util.JedisUtil;
import com.william.util.ParserJsonUtil;
import com.william.vo.CommonInput;
import com.william.vo.ProfileVO;
import com.william.vo.UpdateProfileVO;

public class ProfileService {

	private final Logger logger = Logger.getLogger(this.getClass());
	private SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

	public UpdateProfileVO updateProfile(ProfileUpdateDTO inDTO) {

		String sessionid = "";
		if (!"".equals("" + inDTO.getUserIntID()))
			sessionid = JedisUtil.get(inDTO.getUserIntID());

		ProfileDAO pDAO = ProfileDAO.getInstance();
		UpdateProfileVO cvo = new UpdateProfileVO();
		
		ValidationResult shallWayValidation = inDTO.isValid();
		if(!shallWayValidation.isResultValid()){
			cvo.setStatus("N");
			cvo.setReason(shallWayValidation.getResultString());
			return cvo;
		}
		
		WorldCitiesDAO wcDAO = WorldCitiesDAO.getInstance();
		ProfileUpdateResultDTO resultDTO = new ProfileUpdateResultDTO();
		if (("" + sessionid).equals(inDTO.getSessionID())) {
			try {
				AddressDTO addressDTO = new AddressDTO();
				addressDTO.setCountry(inDTO.getCountry());
				addressDTO.setProvince(inDTO.getProvince());
				addressDTO.setCity(inDTO.getCity());
				CoordinateDTO cord = wcDAO.getCoordinateList(addressDTO);
				inDTO.setLatitude("" + cord.getLatitude());
				inDTO.setLongitude("" + cord.getLongitude());
				ParserJsonUtil geo = new ParserJsonUtil();
				AddressDTO tmp = geo.getAddress(cord.getLatitude(), cord.getLongitude());
				if (tmp != null) {
					inDTO.setGoogleCountry(tmp.getCountry());
					inDTO.setGoogleProvince(tmp.getProvince());
					inDTO.setGoogleCity(tmp.getCity());
				}

				resultDTO = pDAO.updateProfile(inDTO);
				if (resultDTO.isAddressUpdate()) {
					AddressHistoryDAO ahDAO = AddressHistoryDAO.getInstance();
					AddressHistoryInDTO addressTo = new AddressHistoryInDTO();
					addressTo.setUserIntID(inDTO.getUserIntID());
					addressTo.setCity(tmp.getCity());
					addressTo.setProvince(tmp.getProvince());
					addressTo.setCountry(tmp.getCountry());
					addressTo.setPlaceType("R");
					ahDAO.addAddressHistory(addressTo);
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (resultDTO.isProfileUpdate()) {
				cvo.setNickname(inDTO.getNickname());
				cvo.setStatus("Y");
			} else {
				cvo.setStatus("N");
			}
		} else {
			cvo.setStatus("N");
		}
		return cvo;

	}

	public ProfileVO viewProfileByEmail(String email) {
		ProfileDAO pDAO = ProfileDAO.getInstance();
		ProfileEntity profileEntity = pDAO.readProfile(email);
		ProfileVO profileVO = new ProfileVO();
		WorldCitiesDAO wcDAO = WorldCitiesDAO.getInstance();;

		// GISDTO gis = new GISDTO();
		if (profileEntity != null) {
			profileVO.setStatus("Y");
			profileVO.setNickname(profileEntity.getNickname());
			profileVO.setUserid(profileEntity.getUserIntID());
			profileVO.setCountry(profileEntity.getCountry());
			profileVO.setProvince(profileEntity.getProvince());
			if (profileEntity.getDateOfBirth() != null) {
				profileVO.setDateOfBirth(df.format(profileEntity.getDateOfBirth()));
			}
			profileVO.setCity(profileEntity.getCity());
			profileVO.setEmail(profileEntity.getEmail());
			profileVO.setGender(profileEntity.getGender());
			profileVO.setSignature(profileEntity.getSignature());

			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.MONTH, -1);
			if (cal.getTime().after(profileEntity.getLastAddressUpdate())) {
				// if(true){
				String[] countryArray = wcDAO.getCountryList();
				profileVO.setCountryArray(countryArray);
				String[] provinceArray = wcDAO.getProvinceList(profileEntity.getCountry());
				profileVO.setProvinceArray(provinceArray);
				String[] cityArray = wcDAO.getCityList(profileEntity.getCountry(), profileEntity.getProvince());
				profileVO.setCityArray(cityArray);
				profileVO.setAddressFlag(true);
			} else {
				profileVO.setAddressFlag(false);
			}
			
			try{
				if(profileEntity != null && profileEntity.getProfilePhoto() != null)
					profileVO.setProfilePIC(FileUtil.getFileData(profileEntity.getUserIntID()));
			} catch(Exception e){
				logger.error("Profile Image loaded Failed\n",e);
			}

		} else {
			profileVO.setStatus("N");
		}
		return profileVO;
	}

	public ProfileOutDTO viewProfileInput(CommonInput input) {
		ProfileDAO profileDAO = ProfileDAO.getInstance();
		ProfileEntity profile = profileDAO.readProfileByID(input.getUserIntID());
		ProfileOutDTO profileOutDTO = new ProfileOutDTO();
		if (profile != null) {
			profileOutDTO.setNickname(profile.getNickname());
			profileOutDTO.setGender(profile.getGender());
			if (profile.getDateOfBirth() != null)
				profileOutDTO.setDateOfBirth(df.format(profile.getDateOfBirth()));
			profileOutDTO.setCity(profile.getCity());
			profileOutDTO.setProvince(profile.getProvince());
			profileOutDTO.setCountry(profile.getCountry());
			profileOutDTO.setStatus("Y");
			AddressHistoryDAO addressDAO = AddressHistoryDAO.getInstance();
			AddressHistoryOutDTO[] visitArray = addressDAO.readAddressHistory(input.getUserIntID(), "B");
			if (visitArray != null && visitArray.length > 0) {
				StringBuilder sb = new StringBuilder();
				for (AddressHistoryOutDTO dto : visitArray)
					sb.append(dto.toString1() + "\n");
				profileOutDTO.setVisitedCities(sb.toString());
			}
			AddressHistoryOutDTO[] regArray = addressDAO.readAddressHistory(input.getUserIntID(), "R");
			if (regArray != null && regArray.length > 0) {
				StringBuilder sb = new StringBuilder();
				for (AddressHistoryOutDTO dto : regArray)
					sb.append(dto.toString() + "\n");
				profileOutDTO.setVisitedCities(sb.toString());
			}
			profileOutDTO.setProfilePhoto(profile.getProfilePhoto());

			
		} else {
			profileOutDTO.setStatus("N");
		}

		return profileOutDTO;

	}
	
	public PhotoOutDTO getProfilePhoto(CommonInput input){
		byte[] array = null;
		PhotoOutDTO result = new PhotoOutDTO();
		try{
			array = FileUtil.getFileData(input.getUserIntID());
			if(array!=null && array.length>0){
				result.setStatus("Y");
				result.setProfilePIC(array);
			}else{
				result.setStatus("N");
			}
			
		} catch (Exception e){
			logger.error("Excetion happending here",e);
			result.setStatus("N");
		}
		return result;
		
	}
}
