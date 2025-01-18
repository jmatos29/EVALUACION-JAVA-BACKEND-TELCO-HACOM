package com.example.demo.controllers;

import java.time.Instant;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controllers.dto.DateRangeRequest;
import com.example.demo.domains.TraceMsg;
import com.example.demo.repositories.TraceMsgRepository;

import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;


@Log4j2
@RestController
@RequestMapping("/trace")
public class TraceController {

    private final TraceMsgRepository traceMsgRepository;
    private final Counter counter;

    public TraceController(TraceMsgRepository traceMsgRepository, MeterRegistry meterRegistry) {
        this.traceMsgRepository = traceMsgRepository;
        this.counter = meterRegistry.counter("hacom.test.developer.insert.rx");
    }
        
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<TraceMsg> insertTrace(@RequestBody TraceMsg traceMsg) {
        log.info("Inserting trace: {}", traceMsg);
        traceMsg.setTs(Instant.now());
        counter.increment();
        return traceMsgRepository.save(traceMsg);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<TraceMsg> getTracesByDateRange(@RequestParam DateRangeRequest dateRangeRequest) {
        log.info("Getting traces by date range: {}", dateRangeRequest);
        return traceMsgRepository.findAllByTsBetween(dateRangeRequest.getFrom(), dateRangeRequest.getTo());
    }

    
}
