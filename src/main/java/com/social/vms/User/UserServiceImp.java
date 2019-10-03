package com.social.vms.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserRepository userRepository;

    public User findById(Integer id) {
        return userRepository.findById(id).get();
    }

}
