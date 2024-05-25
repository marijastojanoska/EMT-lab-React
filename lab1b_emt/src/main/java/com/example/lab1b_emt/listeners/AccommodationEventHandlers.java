package com.example.lab1b_emt.listeners;

import com.example.lab1b_emt.model.AccommodationCreatedEvent;
import com.example.lab1b_emt.service.AccommodationService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AccommodationEventHandlers {

    private final AccommodationService accommodationService;

    public AccommodationEventHandlers(AccommodationService accommodationService) {
        this.accommodationService = accommodationService;
    }

    @EventListener
    public void onAccommodationCreated(AccommodationCreatedEvent event) {
        //this.accommodationService.refreshMaterializedView();
    }
}

