package hello.objectifysession;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import hello.UserInfo;
import org.springframework.session.FindByIndexNameSessionRepository;
import org.springframework.session.MapSession;
import org.springframework.session.Session;
import org.springframework.session.SessionRepository;
import org.springframework.util.Assert;

import java.io.*;
import java.time.Duration;
import java.time.Instant;
import java.util.*;

import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Key;


public class ObjectifyOperationsSessionRespository implements
        SessionRepository<ObjectifyOperationsSessionRespository.ObjectifySession> {
//        FindByIndexNameSessionRepository<ObjectifyOperationsSessionRespository.ObjectifySession> {

//    @Override
//    public Map<String, ObjectifySession> findByIndexNameAndIndexValue(String indexName, String indexValue) {
//        // 使用しないデバッグ用なので、ひとまず実装しない
//        return null;
//    }

    // Map<String, SessionInfo> mapSessionInfo = new HashMap<String, SessionInfo>();

    @Override
    public ObjectifySession createSession() {
        ObjectifySession session = new ObjectifySession();
        System.out.println("session created!!" + session.primaryKey + "/" + session.getId() );
        return session;
    }

    @Override
    public void save(ObjectifySession session) {

        System.out.println("session saved!!" + session.primaryKey+ "/" + session.getId());

        SessionInfo sessionInfo = new SessionInfo();
        sessionInfo.setPrimaryKey(session.primaryKey);
        sessionInfo.setId(session.getId());
        sessionInfo.setCreationTime(session.getCreationTime().toEpochMilli());
        sessionInfo.setLastAccessedTime(session.getLastAccessedTime().toEpochMilli());
        sessionInfo.setMaxInactiveInterval((int) session.getMaxInactiveInterval().getSeconds());

        for (String key : session.getAttributeNames()) {
            sessionInfo.attributes.put(key, serialize(session.getAttribute(key)));
        }

        ObjectifyService.ofy().save().entity(sessionInfo).now();
        // mapSessionInfo.put(session.getId(), sessionInfo);
    }

    @Override
    public ObjectifySession findById(String id) {
        System.out.println("session get!!" + id);

        SessionInfo sessionInfo = null;
        Key<SessionInfo> sessionInfoKey = Key.create(SessionInfo.class, id);
        sessionInfo = ObjectifyService.ofy().load().key(sessionInfoKey).now();
        // sessionInfo = mapSessionInfo.get(id);

        ObjectifySession session = null;
        if (sessionInfo != null) {
            MapSession delegate = new MapSession(id);
            String primaryKey = sessionInfo.getPrimaryKey();
            delegate.setCreationTime(Instant.ofEpochMilli(sessionInfo.getCreationTime()));
            delegate.setLastAccessedTime(Instant.ofEpochMilli(sessionInfo.getLastAccessedTime()));
            delegate.setMaxInactiveInterval(Duration.ofSeconds(sessionInfo.getMaxInactiveInterval()));
            session = new ObjectifySession(primaryKey, delegate);

            for (String key : sessionInfo.attributes.keySet()) {
                session.setAttribute(key, deserialize(sessionInfo.attributes.get(key)));
            }

        }

        return session;
    }

    public String serialize(Object o) {
        String serialized = "";
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream outObject = new ObjectOutputStream(baos);
            outObject.writeObject(o);
            serialized = Base64.getEncoder().encodeToString(baos.toByteArray());
            System.out.println(serialized);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return serialized;
    }
    public Object deserialize(String s) {
        Object o = null;
        try {
            byte [] data = Base64.getDecoder().decode( s );
            ByteArrayInputStream bios = new ByteArrayInputStream(data);
            ObjectInputStream inObject = new ObjectInputStream(bios);
            o = inObject.readObject();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return o;
    }

    @Override
    public void deleteById(String id) {
        System.out.println("session remove!!" + id);
        Key<SessionInfo> sessionInfoKey = Key.create(SessionInfo.class, id);
        ObjectifyService.ofy().delete().key(sessionInfoKey).now();
        // mapSessionInfo.remove(id);
    }

    final class ObjectifySession implements Session {

        private final Session delegate;

        private final String primaryKey;

        public ObjectifySession() {
            this.delegate = new MapSession();
            this.primaryKey = UUID.randomUUID().toString();
        }

        public ObjectifySession(String primaryKey, Session delegate) {
            Assert.notNull(primaryKey, "primaryKey cannot be null");
            Assert.notNull(delegate, "Session cannot be null");
            this.primaryKey = primaryKey;
            this.delegate = delegate;
        }

        @Override
        public String getId() { return this.delegate.getId(); }

        @Override
        public String changeSessionId() { return this.delegate.changeSessionId(); }

        @Override
        public <T> T getAttribute(String attributeName)  {
            return this.delegate.getAttribute(attributeName);
        }

        @Override
        public Set<String> getAttributeNames() { return this.delegate.getAttributeNames(); }

        @Override
        public void setAttribute(String attributeName, Object attributeValue) {
            this.delegate.setAttribute(attributeName, attributeValue);
        }

        @Override
        public void removeAttribute(String attributeName) {
            this.delegate.removeAttribute(attributeName);
        }

        @Override
        public Instant getCreationTime() {
            return this.delegate.getCreationTime();
        }

        @Override
        public void setLastAccessedTime(Instant lastAccessedTime) {
            this.delegate.setLastAccessedTime(lastAccessedTime);
        }

        @Override
        public Instant getLastAccessedTime() {
            return this.delegate.getLastAccessedTime();
        }

        @Override
        public void setMaxInactiveInterval(Duration interval) {
            this.delegate.setMaxInactiveInterval(interval);
        }

        @Override
        public Duration getMaxInactiveInterval() {
            return this.delegate.getMaxInactiveInterval();
        }

        @Override
        public boolean isExpired() { return this.delegate.isExpired(); }
    }
}
