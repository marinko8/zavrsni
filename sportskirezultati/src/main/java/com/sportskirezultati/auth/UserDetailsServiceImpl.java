package com.sportskirezultati.auth;

import com.sportskirezultati.domain.user.User;
import com.sportskirezultati.domain.user.UserService;
import com.sportskirezultati.exception.AuthException;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of {@link org.springframework.security.core.userdetails.UserDetailsService}.
 */
@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

  private final UserService userService;

  /**
   * Fetch user from username.
   */
  @Override
  @Transactional
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userService.getByUsername(username);

    if (user == null) {
      throw new AuthException("Korisničko ime nije pronađeno");
    }

    return UserDetailsImpl.build(user);
  }

}
