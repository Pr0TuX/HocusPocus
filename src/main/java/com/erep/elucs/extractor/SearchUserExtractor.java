package com.erep.elucs.extractor;

import com.erep.elucs.model.json.search.SearchedUser;

import java.util.List;

/**
 * @author dragos
 */
public interface SearchUserExtractor {
    List<SearchedUser> findUsers(String arg);
}
