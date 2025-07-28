# CloudVendor
OPS 
✅ What is a CloudVendor REST API?
A CloudVendor REST API allows users to interact with cloud services programmatically over HTTP using REST principles. These APIs are used to:

Provision resources (e.g., VMs, storage, networks)

Monitor usage and health

Automate tasks like scaling or security enforcement

| HTTP Method | Operation          | Description                           | Example                    |
| ----------- | ------------------ | ------------------------------------- | -------------------------- |
| `GET`       | **Read**           | Retrieve information about a resource | Get list of VMs            |
| `POST`      | **Create**         | Create a new resource                 | Launch a new VM            |
| `PUT`       | **Update**         | Update an existing resource           | Change VM configuration    |
| `DELETE`    | **Delete**         | Remove a resource                     | Terminate a storage bucket |
| `PATCH`     | **Partial Update** | Apply partial updates to a resource   | Update tags of an instance |


📦 Example: CloudVendor REST API for Virtual Machines
GET /api/v1/vms
Fetches all virtual machines

POST /api/v1/vms
Creates a new virtual machine
Request body:
{
  "name": "my-vm",
  "region": "us-east-1",
  "image": "ubuntu-20.04",
  "instanceType": "t2.micro"
}



PUT /api/v1/vms/123
Updates full configuration of a VM with ID 123

PATCH /api/v1/vms/123
Partially updates VM configuration (e.g., memory)

DELETE /api/v1/vms/123
Deletes VM with ID 123

🔐 Authentication & Security
Most CloudVendor APIs require:

API Key or OAuth 2.0 tokens

HTTPS communication

Role-based access control (RBAC)


📘 Documentation Examples
AWS: AWS REST API Reference

Azure: Azure REST API Reference

GCP: Google Cloud REST APIs

Great! Since you’re working with AWS and have a sample VM configuration in JSON, let’s go over how AWS REST API operations would work for managing EC2 instances using this configuration.

🟢 1. Create (Launch) EC2 Instance
Operation: POST /run-instances
API: https://ec2.amazonaws.com/?Action=RunInstances

Sample JSON (your input):

json
Copy
Edit
{
  "ImageId": "ami-xxxxxxxx",
  "InstanceType": "t2.micro",
  "MinCount": 1,
  "MaxCount": 1,
  "Placement": {
    "AvailabilityZone": "us-east-1a"
  },
  "TagSpecifications": [
    {
      "ResourceType": "instance",
      "Tags": [
        {
          "Key": "Name",
          "Value": "my-vm"
        }
      ]
    }
  ]
}
Note: "ImageId" refers to the AMI ID, which corresponds to ubuntu-20.04 in your case. You need to map it to the correct AMI ID in your region.

🟡 2. Read (Describe) Instances
Operation: GET /describe-instances
API Call:

ruby
Copy
Edit
https://ec2.amazonaws.com/?Action=DescribeInstances&InstanceId=i-0abcd1234example
🔵 3. Update (Change Instance Type)
Operation: POST /modify-instance-attribute
API Call:

ruby
Copy
Edit
https://ec2.amazonaws.com/?Action=ModifyInstanceAttribute
&InstanceId=i-0abcd1234example
&InstanceType.Value=t2.small
⚠️ The instance must be stopped before changing its type.

🔴 4. Delete (Terminate Instance)
Operation: POST /terminate-instances
API Call:

ruby
Copy
Edit
https://ec2.amazonaws.com/?Action=TerminateInstances&InstanceId=i-0abcd1234example
🔐 Authentication
All AWS API requests must be signed with Signature Version 4 using your Access Key ID and Secret Access Key.

🧰 Tools to Use
AWS CLI: aws ec2 run-instances --cli-input-json file://config.json

Postman (with Signature 4 auth plugin)

SDKs: boto3 (Python), AWS SDK for JavaScript/Java/Go/etc.





