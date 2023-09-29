# Microservices-Learning
MonoRepo for Learning Microservices

## Modules
### auth_server
Spring Authorization Server configured for OpenID

### openid_ui
Simple UI application secured by OIDC

Create a .env file
``` ini
ISSUER_BASE_URL=http://localhost:8080/
CLIENT_ID=messaging-client
BASE_URL=http://localhost:3000/
SECRET=secret123456
CLIENT_SECRET=secret123456
```