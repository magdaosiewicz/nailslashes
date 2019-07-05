package com.example.naillashes.controller;

import com.example.naillashes.entity.User;
import com.example.naillashes.payload.UserIdentityAvailability;
import com.example.naillashes.payload.UserProfile;
import com.example.naillashes.payload.UserSummary;
import com.example.naillashes.repository.UserRepository;
import com.example.naillashes.security.CurrentUser;
import com.example.naillashes.security.UserDetailImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/auth/user/me")
//    @PreAuthorize("hasRole('USER')")
    public UserSummary getCurrentUser(@CurrentUser UserDetailImpl currentUser) {
        UserSummary userSummary = new UserSummary(currentUser.getId(), currentUser.getEmail(), currentUser.getName());
        return userSummary;
    }

//    @GetMapping("/user/checkUsernameAvailability")
//    public UserIdentityAvailability checkUsernameAvailability(@RequestParam(value = "username") String username) {
//        Boolean isAvailable = !userRepository.existsByUsername(username);
//        return new UserIdentityAvailability(isAvailable);
//    }

    @GetMapping("/user/checkEmailAvailability")
    public UserIdentityAvailability checkEmailAvailability(@RequestParam(value = "email") String email) {
        Boolean isAvailable = !userRepository.existsByEmail(email);
        return new UserIdentityAvailability(isAvailable);
    }

    @GetMapping("/users/{email}")
    public UserProfile getUserProfile(@PathVariable(value = "email") String email) {
        User user = userRepository.findByEmail(email);
            //    .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));

        //long pollCount = pollRepository.countByCreatedBy(user.getId());
  //      long voteCount = voteRepository.countByUserId(user.getId());

        UserProfile userProfile = new UserProfile(user.getId(), user.getEmail(), user.getName());

        return userProfile;
    }

}
