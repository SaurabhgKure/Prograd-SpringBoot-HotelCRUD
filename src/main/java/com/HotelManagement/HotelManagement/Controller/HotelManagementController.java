package com.HotelManagement.HotelManagement.Controller;


import com.HotelManagement.HotelManagement.Model.CustomerDetails;
import com.HotelManagement.HotelManagement.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotelManagement")
public class HotelManagementController {

    @Autowired
    private Service service;

    public HotelManagementController(Service service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CustomerDetails> saveDetail(@RequestBody CustomerDetails cd)
    {
        return new ResponseEntity<CustomerDetails>(service.saveDetail(cd), HttpStatus.CREATED);
    }

    @GetMapping
    public List<CustomerDetails> getAllDetail()
    {
        return service.getAllDetail();
    }
    @GetMapping("{id}")
    public ResponseEntity<CustomerDetails> getDetailById(@PathVariable("id")int id)
    {
        return new ResponseEntity<CustomerDetails>(service.getDetailById(id),HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<CustomerDetails> updateDetail(@PathVariable("id")int id,@RequestBody CustomerDetails cd)
    {
        return new ResponseEntity<CustomerDetails>(service.updateDetail(cd,id), HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDetail(@PathVariable("id")int id)
    {
        service.deleteDetail(id);
        return new ResponseEntity<String>("Detail deleted successfully",HttpStatus.OK);
    }
}
