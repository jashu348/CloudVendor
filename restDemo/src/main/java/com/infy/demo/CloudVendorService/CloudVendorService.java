package com.infy.demo.CloudVendorService;

import java.util.List;

import com.infy.demo.model.CloudVendor;

public interface CloudVendorService {

	public String createCloudVendor(CloudVendor cloudVendor);
	public String updateCloudVendor(CloudVendor cloudVendo);
	public String deleteCloudVendor(String cloudvendorId);
	public CloudVendor getCloudVendor(String cloudvendorId);
	public List<CloudVendor>getAllCloudVendors();
}
