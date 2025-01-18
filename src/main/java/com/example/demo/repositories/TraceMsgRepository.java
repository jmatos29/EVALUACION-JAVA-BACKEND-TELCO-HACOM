package com.example.demo.repositories;

import java.time.OffsetDateTime;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domains.TraceMsg;

import reactor.core.publisher.Flux;

@Repository
public interface TraceMsgRepository extends ReactiveMongoRepository<TraceMsg, ObjectId> {
    

    Flux<TraceMsg> findAllByTsBetween(OffsetDateTime from, OffsetDateTime to);
}
