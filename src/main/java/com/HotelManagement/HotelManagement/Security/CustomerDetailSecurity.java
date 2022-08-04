package com.HotelManagement.HotelManagement.Security;

import com.HotelManagement.HotelManagement.Model.CustomerDetails;
import com.HotelManagement.HotelManagement.Repository.HotelMRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomerDetailSecurity implements UserDetailsService {
    @Autowired
    private HotelMRepo hotelRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CustomerDetails detail= this.hotelRepo.findByEmail(username).orElseThrow();
        return detail;
    }
}
