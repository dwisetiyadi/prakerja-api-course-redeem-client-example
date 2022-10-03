require 'base64'
require 'cgi'
require 'openssl'

# if using this value bellow should output d46b59b221335976b46eafb752035a1172a8beb2
text = 'myclient_code1516239022POST/api/v1/integration/payment/redeem-code/commit{"code":"code"}'
key = 'my_sign_key'

hmac = OpenSSL::HMAC.hexdigest(OpenSSL::Digest::Digest.new('sha1'), key.encode("ASCII"), text.encode("ASCII"))

puts hmac