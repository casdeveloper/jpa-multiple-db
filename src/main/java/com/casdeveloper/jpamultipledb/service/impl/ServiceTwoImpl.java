package com.casdeveloper.jpamultipledb.service.impl;

import com.casdeveloper.jpamultipledb.model.two.Contract;
import com.casdeveloper.jpamultipledb.model.two.Region;
import com.casdeveloper.jpamultipledb.repository.two.ContractRepository;
import com.casdeveloper.jpamultipledb.repository.two.RegionRepository;
import com.casdeveloper.jpamultipledb.service.ServiceTwo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTwoImpl implements ServiceTwo {

    @Autowired
    RegionRepository regionRepository;

    @Autowired
    ContractRepository contractRepository;

    @Override
    public Boolean addRegion(Region region) {
        try {
            regionRepository.save(region);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean addContract(Contract contract) {
        try {
            contractRepository.save(contract);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public List<Region> getAllRegion() {
        return regionRepository.findAll();
    }

    @Override
    public List<Contract> getAllContract() {
        return contractRepository.findAll();
    }
}
