package com.adkr38.app.services.impl;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.ArrayList;
import java.util.Optional;
import java.util.List;
import com.adkr38.app.services.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.adkr38.app.repositories.UserRepository;
import com.adkr38.app.models.User;
import org.springframework.security.core.userdetails.*;
import com.adkr38.app.models.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UserService implements UserDetailsService,UserServiceInterface{

  @Autowired
  private UserRepository userRepository;

  private static final Logger LOGGER = LoggerFactory.getLogger(CustomAuthorizationFilter.class);

  public UserService(){};

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
    Optional<User> optionalUser= userRepository.findByUsername(username);
    if (optionalUser.isEmpty()){
      LOGGER.error("User not found.");
      throw new UsernameNotFoundException("User not found.");
    }
    LOGGER.info("User found in the database: {}", username);
    User user = optionalUser.get();

    List<SimpleGrantedAuthority> authorities = new ArrayList<>();
    user.getRoles().forEach(role ->{
      authorities.add(new SimpleGrantedAuthority(role.getName()));
    });

    return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);

  }

}
