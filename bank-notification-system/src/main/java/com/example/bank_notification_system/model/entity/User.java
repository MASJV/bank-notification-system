package com.example.bank_notification_system.model.entity;

import lombok.*;

//@Data shall i add data and remove getter,setter,toString?????
//@Builder why not allowed????
@Getter
@Setter
@ToString
public class User {
    private static int users = 0;
    private final Integer userId;
    private String name;
    private  Integer bankBalance;
    private Channel channel; // Enum channel is also fine???

    public User(String name, Channel channel, Integer bankBalance){
        this.userId = ++users;
        this.name = name;
        this.channel = channel;
        this.bankBalance = bankBalance;
    }

    // jo request client bhej raha hai usme name or channel aayega
    // so create request ke liye ek object create karna hai. request ke liye model dto banana padega

}
