package com.HotelManagement.HotelManagement.Repository;

import com.HotelManagement.HotelManagement.Model.CustomerDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HotelMRepo extends JpaRepository<CustomerDetails,Integer> {
    Optional<CustomerDetails> findByEmail(String email);
}
