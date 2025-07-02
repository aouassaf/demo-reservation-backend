package com.alteca.reservation.dto;

import java.time.LocalDateTime;

public class AvailabilityResponse {
    private final boolean available;
    private final LocalDateTime until;

    public AvailabilityResponse(boolean available, LocalDateTime until) {
        this.available = available;
        this.until = until;
    }

    public boolean isAvailable() {
        return available;
    }

    public LocalDateTime getUntil() {
        return until;
    }
}
