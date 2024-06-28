package com.mobilesoftware.zekaoyunu.domain.use_case.get_userdata;

import com.mobilesoftware.zekaoyunu.data.repository.dto.UserData;
import com.mobilesoftware.zekaoyunu.domain.repository.MindGameRepository;
import javax.inject.Inject;

public class GetUserDataUseCase {

    private final MindGameRepository mindGameRepository;

    @Inject
    public GetUserDataUseCase(MindGameRepository mindGameRepository) { this.mindGameRepository = mindGameRepository; }

    public UserData execute() { return mindGameRepository.getUserData(); }

}
