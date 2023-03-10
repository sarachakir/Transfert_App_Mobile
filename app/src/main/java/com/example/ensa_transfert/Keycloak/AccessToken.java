package com.example.ensa_transfert.Keycloak;


import com.google.gson.annotations.SerializedName;

public class AccessToken {

    @SerializedName("access_token")
    private String accessToken;
    @SerializedName("expires_in")
    private Integer expiresIn;
    @SerializedName("refresh_expires_in")
    private Integer refreshExpiresIn;
    @SerializedName("refresh_token")
    private String refreshToken;
    @SerializedName("token_type")
    private String tokenType;
    @SerializedName("id_token")
    private String idToken;
    @SerializedName("not_before_policy")
    private Integer notBeforePolicy;
    @SerializedName("session_state")
    private String sessionState;
    @SerializedName("scope")
    private String scope;

    public AccessToken(String accessToken,Integer expiresIn){
        this.accessToken=accessToken;
        this.expiresIn=expiresIn;
    }

}
