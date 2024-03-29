package com.thinkconstructive.restdemo.repository;

import com.thinkconstructive.restdemo.model.CloudVendor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CloudVendorRepositoryTest {

    @Autowired
    private CloudVendorRepository cloudVendorRepository;
    CloudVendor cloudVendor;

    @BeforeEach
    void setUp() {
        cloudVendor =new CloudVendor("1","Amazon","USA Cali","9874561");
        cloudVendorRepository.save(cloudVendor);
    }

    @AfterEach
    void tearDown() {

        cloudVendor =null;
        cloudVendorRepository.deleteAll();
    }


    //Test case For Success scenario
    @Test
    void testFindByVendorName_Found(){
        List<CloudVendor> cloudVendorList = cloudVendorRepository.findByVendorName("Amazon");
        assertThat(cloudVendorList.get(1).getVendorId()).isEqualTo(cloudVendor.getVendorId());
        assertThat(cloudVendorList.get(1).getVendorAddress()).isEqualTo(
                cloudVendor.getVendorAddress());
    }


        //Test case For FAILURE scenario

}
