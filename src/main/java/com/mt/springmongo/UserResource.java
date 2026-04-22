package com.mt.springmongo;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserResource {

    private static final Logger logger = LoggerFactory.getLogger(UserResource.class);

    @Autowired
    private UserService userService;  

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAllUsers() {
        List<User> users = (List<User>) userRepository.findAll();
        logger.info("Total Users: " + users.size());
        return users;
    }

    @GetMapping("/{id}")
    public Optional<User> findById(@PathVariable String id) {
        logger.info("Get User By Id: " + id);
        return userService.getUserById(id);   // ✅ USE SERVICE (IMPORTANT)
    }
}
