package com.infy.demo.CloudVendorRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.demo.model.CloudVendor;

public interface CloudVendorRepository extends JpaRepository<CloudVendor, String> {

}
