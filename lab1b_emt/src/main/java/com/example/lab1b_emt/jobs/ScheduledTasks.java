package com.example.lab1b_emt.jobs;

import com.example.lab1b_emt.service.AccommodationService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

    private final AccommodationService accommodationService;

    public ScheduledTasks(AccommodationService accommodationService) {
        this.accommodationService = accommodationService;
    }

    @Scheduled(fixedDelay = 5000)
    public void refreshMaterializedView() {
        //this.accommodationService.refreshMaterializedView();
    }
}
