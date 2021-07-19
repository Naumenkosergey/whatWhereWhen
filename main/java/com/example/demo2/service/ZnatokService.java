package com.example.demo2.service;

import com.example.demo2.model.Znatok;
import com.example.demo2.repository.ZnatokRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZnatokService {


    final private ZnatokRepository znatokRepository;

    @Autowired
    public ZnatokService(ZnatokRepository znatokRepository) {
        this.znatokRepository = znatokRepository;
    }

    public Znatok findById(Long id) {
        return znatokRepository.findById( id ).orElse( null );
//        return userRepository.getOne( id );
    }

    public List<Znatok> findAll() {
        return znatokRepository.findAll();
    }

    public Znatok saveZnatok(Znatok znatok) {
        return znatokRepository.save( znatok );
    }

    public void deleteById(Long id) {
        znatokRepository.deleteById( id );
    }
}
