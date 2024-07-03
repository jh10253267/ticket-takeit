package com.tickettakeit.global.security.service;

import com.tickettakeit.domain.member.service.MemberService;
import com.tickettakeit.global.security.entity.CustomUserDetails;
import com.tickettakeit.global.security.entity.UserEntity;
import com.tickettakeit.global.security.entity.UserRoleEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final MemberService memberService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity customUser = memberService.getUser(username);

        if(customUser == null) {
            throw new UsernameNotFoundException("일치하는 유저 정보가 없습니다.");
        }

        CustomUserDetails customUserDetails = new CustomUserDetails();
        customUserDetails.setUsername(customUser.getUsername());
        customUserDetails.setPassword(customUser.getPassword());

        List<UserRoleEntity> customRoles = memberService.getUserRoles(username);
        List<GrantedAuthority> authorities = new ArrayList<>();

        if(customRoles != null) {
            for (UserRoleEntity customRole : customRoles) {
                authorities.add(new SimpleGrantedAuthority(customRole.getRoleName()));
            } //for
        } //if

        customUserDetails.setAuthorities(authorities);
        customUserDetails.setEnabled(true);
        customUserDetails.setAccountNonExpired(true);
        customUserDetails.setAccountNonLocked(true);
        customUserDetails.setCredentialsNonExpired(true);

        return customUserDetails;
    }
}