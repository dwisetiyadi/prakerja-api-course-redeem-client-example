package main

import (
	"context"
	"log"
	"time"

	signature_go "example-hmac-sha1-signkey/signature_go"
)

func main() {
	// if using this value bellow should output: d46b59b221335976b46eafb752035a1172a8beb2 <nil>
	nowunix := int64(1516239022)
	text := "myclient_code"
	key := "my_sign_key"

	nowdatetime := time.Unix(nowunix, 0)

	repo := signature_go.NewPlatformSignature(text, key)
	actual, err := repo.GenerateForRedeemCommit(context.TODO(), nowdatetime, "code")
	log.Println(actual, err)
}
