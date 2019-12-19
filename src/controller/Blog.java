package controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Comment;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.*;

@ServerEndpoint(value = "/Blog")
public class Blog {
    private static final Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>());
    private static final List<Comment> comments = new ArrayList<>();

    @OnOpen
    public void onOpen(Session session) throws IOException {
        sessions.add(session);
        ObjectMapper mapper = new ObjectMapper();
        session.getBasicRemote().sendText(mapper.writeValueAsString(comments));
    }

    @OnMessage
    public void onMessage(String comment) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Comment commentObj = mapper.readValue(comment, Comment.class);
        sendcCommentToEveryone(commentObj);
        comments.add(commentObj);
    }

    @OnClose
    public void onClose(Session session) {
        sessions.remove(session);
    }

    private void sendcCommentToEveryone(Comment comment) throws IOException {
        for (Session sessie : sessions) {
            List<Comment> result = new ArrayList<>();
            result.add(comment);
            ObjectMapper mapper = new ObjectMapper();

            sessie.getBasicRemote().sendText(mapper.writeValueAsString(result));
        }
    }
}
