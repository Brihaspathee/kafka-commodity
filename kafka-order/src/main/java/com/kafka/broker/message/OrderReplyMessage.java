package com.kafka.broker.message;

import lombok.*;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 04, December 2021
 * Time: 11:29 PM
 * Project: commodity
 * Package Name: com.kafka.broker.message
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderReplyMessage {

    private String replyMessage;

    @Override
    public String toString() {
        return "OrderReplyMessage{" +
                "replyMessage='" + replyMessage + '\'' +
                '}';
    }
}
