package com.infy.demo.controller;

import com.infy.demo.CloudVendorService.CloudVendorService;
import com.infy.demo.model.CloudVendor;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cloudvendor")
public class CloudAPIService {
	CloudVendorService cloudVendorService;

	/**
	 * @param cloudVendorService
	 */
	
	public CloudAPIService(CloudVendorService cloudVendorService) {
		
		this.cloudVendorService = cloudVendorService;
	}

	@GetMapping("{vendorId}")
	public CloudVendor getCloudVendorDetails(@PathVariable("vendorId") String vendorId) {
		return cloudVendorService.getCloudVendor(vendorId);
	}

	@GetMapping()
	public List<CloudVendor> getAllCloudVendorDetails() {

		return cloudVendorService.getAllCloudVendors();

	}

	@PostMapping
	public String creatCloudVendorDetails(@RequestBody CloudVendor cloudVendor) {
		cloudVendorService.createCloudVendor(cloudVendor);
		return "Sucessfull";
	}

	@PutMapping
	public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor) {
		cloudVendorService.updateCloudVendor(cloudVendor);
		return "update sucessfully Done";
	}

	@DeleteMapping("{vendorId}")
	public String deleteCloudVendorDetails(@PathVariable("vendorId") String vendorId) {
		cloudVendorService.deleteCloudVendor(vendorId);
		return "Cloud Vendor deteted sucessfully";
	}

}