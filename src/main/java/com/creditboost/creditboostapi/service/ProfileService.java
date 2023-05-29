package com.creditboost.creditboostapi.service;

import com.creditboost.creditboostapi.model.Profile;

import java.util.List;

public interface ProfileService {

    Profile saveProfile(Profile profile);

    List<Profile> getAllProfiles();

    Profile getProfileById(Long idProfile);

    Boolean deleteProfile(Long idProfile);

    Profile updateProfile(Long idProfile, Profile profile);
}
