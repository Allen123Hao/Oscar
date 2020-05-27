package com.hao.java8.interfacepkg;

/**
 * <code>SendMessage</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-03-06
 * @version: 1.0
 */
public class SendMessage {

    public void print(IMessage message){
        message.print("hello");
    }

    public static void main(String[] args) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.print(new IMessage() {
            @Override
            public void print(String msg) {
                System.out.println(msg);
            }
        });
        sendMessage.print((msg)-> System.out.println(msg));
    }
}
