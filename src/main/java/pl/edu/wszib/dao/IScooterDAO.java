package pl.edu.wszib.dao;

import pl.edu.wszib.model.Scooter;

import java.util.List;

public interface IScooterDAO {
    void addScooter(Scooter scooter);
    Scooter getScooter(int Id);
    Scooter getUpdate(int Id, Scooter scooter);
    Scooter removeScooterId(int Id);
    List<Scooter> getAllScooterXiaomi();
    List<Scooter> getAllScooters();
    List<Scooter> getAllScooterFiat();
}
