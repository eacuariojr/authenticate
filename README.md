# authenticate
Authentication security and OAuth2

Currently hardcoded for one specific user
username: tom
password: password

PostRequest endpoint at "/authenticate"
Input: Json with "username", and "password" elements
Output: JWT (if input is valid), 403 error (if invalid)

GetRequest endpoint at "/hello"
Input: "Bearer [valid JWT]"
Output: Hello world webpage (if input valid), 405 error (if JWT is invalid)