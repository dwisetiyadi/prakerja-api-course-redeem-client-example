const crypto = require('crypto-js');

// if using this value bellow should output d46b59b221335976b46eafb752035a1172a8beb2
const text = 'myclient_code1516239022POST/api/v1/integration/payment/redeem-code/commit{"code":"code"}';
const key = 'my_sign_key';

const output = crypto.HmacSHA1(text, key).toString(crypto.enc.Hex);
console.log(output);