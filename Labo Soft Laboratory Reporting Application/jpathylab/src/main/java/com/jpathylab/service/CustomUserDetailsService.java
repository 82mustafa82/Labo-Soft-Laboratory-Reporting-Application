package com.jpathylab.service;
import com.jpathylab.model.CustomUserDetails;
import com.jpathylab.model.User;
import com.jpathylab.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repo.findByUserName(username);
        if(user == null){
            throw new UsernameNotFoundException("No user found for the given user name");
        }
        return new CustomUserDetails(user);
    }
}
