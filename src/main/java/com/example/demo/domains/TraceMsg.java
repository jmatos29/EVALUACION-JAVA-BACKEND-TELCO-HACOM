package com.example.demo.domains;

import java.time.Instant;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;

@Getter
public class TraceMsg {

    @Id
    private ObjectId _id;
    private String sessionId;
    private String payload;
    private Instant ts;
    
    public void set_id(ObjectId _id) {
        this._id = _id;
    }
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }
    
    @JsonIgnore
    public void setTs(Instant ts) {
        this.ts = ts;
    }

    
}
