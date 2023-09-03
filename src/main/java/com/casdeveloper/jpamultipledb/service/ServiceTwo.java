package com.casdeveloper.jpamultipledb.service;

import com.casdeveloper.jpamultipledb.model.two.Contract;
import com.casdeveloper.jpamultipledb.model.two.Region;

import java.util.List;

public interface ServiceTwo {

    Boolean addRegion(Region region);
    Boolean addContract(Contract contract);
    List<Region> getAllRegion();
    List<Contract> getAllContract();
}
