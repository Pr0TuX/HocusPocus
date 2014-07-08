package com.erep.elucs.extractor;

import com.erep.elucs.model.json.profile.UserProfile;

public interface UserProfileExtractor {

    UserProfile getUserProfile(String profileId);
}
