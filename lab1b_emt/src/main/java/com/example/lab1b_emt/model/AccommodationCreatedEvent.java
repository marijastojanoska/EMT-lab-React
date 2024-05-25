package com.example.lab1b_emt.model;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import java.time.LocalDateTime;

@Getter
public class AccommodationCreatedEvent extends ApplicationEvent {

    private LocalDateTime when;

    public AccommodationCreatedEvent(Accommodation source) {
        super(source);
        this.when = LocalDateTime.now();
    }

    public AccommodationCreatedEvent(Accommodation source, LocalDateTime when) {
        super(source);
        this.when = when;
    }
}

