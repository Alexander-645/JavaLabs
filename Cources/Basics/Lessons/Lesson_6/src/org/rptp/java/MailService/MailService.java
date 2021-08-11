package org.rptp.java.MailService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class MailService <T> implements Consumer<Sendable<T>>{
    private List<T> contentList;
    private Map<String, List<T>> mailBox = new HashMap() {
        @Override
        public List<T> get(Object key) {
            return (List<T>) super.getOrDefault(key, new ArrayList<T>());
        }
    };


    public Map<String, List<T>> getMailBox(){
        return mailBox;
    }

    @Override
    public void accept(Sendable<T> tSendable) {
        String to = tSendable.getTo();
        if(mailBox.containsKey(to)) {
            mailBox.get(to).add(tSendable.getContent());
        }
        else {
            contentList = new ArrayList<>();
            contentList.add(tSendable.getContent());
            mailBox.put(to, contentList);
        }
    }

    @Override
    public Consumer<Sendable<T>> andThen(Consumer<? super Sendable<T>> after) {
        return null;
    }
}
