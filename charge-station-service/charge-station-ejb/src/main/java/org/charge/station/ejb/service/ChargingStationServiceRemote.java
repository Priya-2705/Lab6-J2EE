package org.charge.station.ejb.service;

import org.charge.station.ejb.model.ChargingStation;

import java.util.List;

import jakarta.ejb.Remote;

@Remote
public interface ChargingStationServiceRemote {
    List<ChargingStation> getAllStations();
    List<ChargingStation> getAvailableStations();
    List<ChargingStation> getUnavailableStations();
}