package com.HotelManagement.HotelManagement.Service;

import com.HotelManagement.HotelManagement.Model.CustomerDetails;

import java.util.List;

public interface Service {

    CustomerDetails saveDetail(CustomerDetails cd);

    List<CustomerDetails> getAllDetail();
    CustomerDetails getDetailById(int id);
    CustomerDetails updateDetail(CustomerDetails cd,int id);
    void deleteDetail(int id);

}
