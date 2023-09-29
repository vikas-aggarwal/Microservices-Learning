require('dotenv').config()
const express = require('express');
const { auth } = require('express-openid-connect');

const app = express();

app.use(auth({
    authorizationParams: {
        response_mode: "query",
        response_type: "code",
        scope:"openid"
    }
}));

app.get('/', (req, res) => {
  res.send(`hello ${req.oidc.user.sub} ${req.oidc.accessToken.access_token} ${req.oidc.accessToken.expires_in}`);
});


app.listen(3000);