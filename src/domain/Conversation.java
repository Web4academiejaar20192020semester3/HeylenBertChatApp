package domain;

import java.util.ArrayList;
import java.util.List;

public class Conversation {
    public Person person1;
    public Person person2;
    public List<String> messages;

    public Conversation(Person person1, Person person2) {
        this.person1 = person1;
        this.person2 = person2;
        messages = new ArrayList<>();
    }
}