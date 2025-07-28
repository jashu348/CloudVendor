package com.infy.demo.CloudVendorService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.demo.CloudVendorRepository.CloudVendorRepository;
import com.infy.demo.model.CloudVendor;

@Service
public class CloudVendorServiceImpl implements CloudVendorService {

	CloudVendorRepository cloudVendorRepository;

	@Autowired
	public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {

		this.cloudVendorRepository = cloudVendorRepository;
	}

	@Override
	public String createCloudVendor(CloudVendor cloudVendor) {

		cloudVendorRepository.save(cloudVendor);
		return "sucess";
	}

	@Override
	public String updateCloudVendor(CloudVendor cloudVendor) {
		cloudVendorRepository.save(cloudVendor);
		return "Sucess";
	}

	@Override
	public String deleteCloudVendor(String cloudvendorId) {
		cloudVendorRepository.deleteById(cloudvendorId);
		return "deleted";
	}

	@Override
	public CloudVendor getCloudVendor(String cloudvendorId) {

		return cloudVendorRepository.findById(cloudvendorId).get();
	}

	@Override
	public List<CloudVendor> getAllCloudVendors() {

		return cloudVendorRepository.findAll();
	}

	public CloudVendorServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

}