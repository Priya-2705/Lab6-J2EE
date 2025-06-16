package org.charge.station.ejb.service;

import org.charge.station.ejb.model.ChargingStation;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class ChargingStationService implements ChargingStationServiceRemote {

    @PersistenceContext(unitName = "stationPU")
    private EntityManager em;

    @Override
    public List<ChargingStation> getAllStations() {
        return em.createQuery("SELECT c FROM ChargingStation c", ChargingStation.class).getResultList();
    }

    @Override
    public List<ChargingStation> getAvailableStations() {
        return getAllStations().stream()
                .filter(ChargingStation::isAvailability)
                .collect(Collectors.toList());
    }

    @Override
    public List<ChargingStation> getUnavailableStations() {
        return getAllStations().stream()
                .filter(station -> !station.isAvailability())
                .collect(Collectors.toList());
    }
}