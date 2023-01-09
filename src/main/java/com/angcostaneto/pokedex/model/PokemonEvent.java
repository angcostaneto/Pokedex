package com.angcostaneto.pokedex.model;

public class PokemonEvent {
    private Long eventId;
    private String eventtype;

    public PokemonEvent(Long eventId, String eventtype) {
        this.eventId = eventId;
        this.eventtype = eventtype;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getEventtype() {
        return eventtype;
    }

    public void setEventtype(String eventtype) {
        this.eventtype = eventtype;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PokemonEvent that)) return false;

        if (getEventId() != null ? !getEventId().equals(that.getEventId()) : that.getEventId() != null) return false;
        return getEventtype() != null ? getEventtype().equals(that.getEventtype()) : that.getEventtype() == null;
    }

    @Override
    public int hashCode() {
        int result = getEventId() != null ? getEventId().hashCode() : 0;
        result = 31 * result + (getEventtype() != null ? getEventtype().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PokemonEvent{" +
                "eventId=" + eventId +
                ", eventtype='" + eventtype + '\'' +
                '}';
    }
}
