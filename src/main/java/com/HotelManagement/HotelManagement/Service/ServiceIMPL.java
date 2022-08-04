package com.HotelManagement.HotelManagement.Service;

import com.HotelManagement.HotelManagement.Model.CustomerDetails;
import com.HotelManagement.HotelManagement.Repository.HotelMRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class ServiceIMPL implements com.HotelManagement.HotelManagement.Service.Service {

    @Autowired
    private HotelMRepo hotelrepo;

    public ServiceIMPL(HotelMRepo hotelrepo) {
        this.hotelrepo =hotelrepo;
    }

    @Override
    public CustomerDetails saveDetail(CustomerDetails cd) {
        return hotelrepo.save(cd);
    }

    @Override
    public List<CustomerDetails> getAllDetail() {
        return hotelrepo.findAll();
    }

    @Override
    public CustomerDetails getDetailById(int id) {
        return hotelrepo.findById(id).orElseThrow();
    }

    @Override
    public CustomerDetails updateDetail(CustomerDetails cd, int id) {
        CustomerDetails existingDetail=hotelrepo.findById(id).orElseThrow();
        existingDetail.setName(cd.getName());
        existingDetail.setContactNo(cd.getContactNo());
        existingDetail.setIdType(cd.getIdType());
        existingDetail.setAddress(cd.getAddress());
        existingDetail.setDays(cd.getDays());
        existingDetail.setDate(cd.getDate());
        existingDetail.setAge(cd.getAge());
        hotelrepo.save(existingDetail);
        return existingDetail;
    }

    @Override
    public void deleteDetail(int id) {
        hotelrepo.findById(id).orElseThrow();
        hotelrepo.deleteById(id);

    }
}
