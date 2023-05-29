package com.creditboost.creditboostapi.service;

import com.creditboost.creditboostapi.entity.ProfileEntity;
import com.creditboost.creditboostapi.model.Profile;
import com.creditboost.creditboostapi.repository.ProfileRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService{

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public Profile saveProfile(Profile profile) {
        ProfileEntity profileEntity = new ProfileEntity();
        BeanUtils.copyProperties(profile, profileEntity);
        profileRepository.save(profileEntity);
        return profile;
    }

    @Override
    public List<Profile> getAllProfiles() {
        List<ProfileEntity> profileEntities = profileRepository.findAll();
        List<Profile> profiles = new ArrayList<>();

        for (ProfileEntity profileEntity : profileEntities) {
            Profile profile = new Profile();
            BeanUtils.copyProperties(profileEntity, profile);
            profiles.add(profile);
        }
        return profiles;
    }

    @Override
    public Profile getProfileById(Long idProfile) {
        Profile profile = new Profile();
        ProfileEntity profileEntity = profileRepository.findById(idProfile).get();
        BeanUtils.copyProperties(profileEntity, profile);
        return profile;
    }

    @Override
    public Boolean deleteProfile(Long idProfile) {
        ProfileEntity profileEntity = profileRepository.findById(idProfile).get();
        profileRepository.delete(profileEntity);
        return true;
    }

    @Override
    public Profile updateProfile(Long idProfile, Profile profile) {
        ProfileEntity profileEntity = profileRepository.findById(idProfile).get();
        profileEntity.setIdProfile(profile.getIdProfile());
        profileEntity.setFirst_name(profile.getFirst_name());
        profileEntity.setLast_name(profile.getLast_name());
        profileEntity.setDate_of_birth(profile.getDate_of_birth());
        profileEntity.setPhone(profile.getPhone());
        profileEntity.setSsn(profile.getSsn_last_four_digits());
        profileEntity.setSsn_last_four_digits(profile.getSsn_last_four_digits());
        profileEntity.setBank_account(profile.getBank_account());
        profileEntity.setBank_routing(profile.getBank_routing());
        profileEntity.setBank_name(profile.getBank_name());
        profileEntity.setCurr_credit_score(profile.getCurr_credit_score());
        profileEntity.setTotal_num_open_loan(profile.getTotal_num_open_loan());

        profileRepository.save(profileEntity);
        return profile;
    }
}
