OpenSource-POC-Code
===================

I'm trying to help other how to use frameworks and write good quality of code

# Rest-Jersey(JAX-RS) POC and API Reference
Rest-Jersey POC is micro service to manage customer information

# Use Rest Client in any browser (Like Chrome : PostMan, FireFox: Rest Client plugins)
# GET Customer by Id
	http://pocs-ravicloud.rhcloud.com/RestPoc/api/customer/customerId/5

# GET All Customers
	http://pocs-ravicloud.rhcloud.com/RestPoc/api/customer/allcustomers

# POST add new Customer
	http://pocs-ravicloud.rhcloud.com/RestPoc/api/customer
	Request JSON
	{
	           
	"customerId": "55",
	"firstName": "CFN-55",
	"lastName": "CLN-55",
	"address": "5555 N View Dr. Minneapolis, MN", "zipCode": "55555",
	"contactNumber": "952-555-5555" }

# Rest-SpringBoot POC and API Reference
Rest-SpringBoot POC is micro service to manage customer information

DNS your domain name(IP address) and port number
API information available in swagger document  "http://localhost:8080/rest-springboot/swagger-ui.html"
*Note : Change DNS name to server DNS

## Contributors
Ravi Reddy

## License
@CopyRight ( C ) All rights reserved to RaviReddy POC World. It's Illegal to reproduce this code.