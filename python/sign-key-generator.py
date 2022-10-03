from hashlib import sha1
import hmac

# if using this value bellow should output d46b59b221335976b46eafb752035a1172a8beb2
text = 'myclient_code1516239022POST/api/v1/integration/payment/redeem-code/commit{"code":"code"}'
key = 'my_sign_key'

result = hmac.new(key.encode("utf-8"), text.encode("utf-8"), sha1).hexdigest()

print(result)
