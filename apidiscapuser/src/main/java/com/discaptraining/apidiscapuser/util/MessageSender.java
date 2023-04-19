package com.discaptraining.apidiscapuser.util;

public interface MessageSender<T> {
    void execute(T message, String idMessage);
}
