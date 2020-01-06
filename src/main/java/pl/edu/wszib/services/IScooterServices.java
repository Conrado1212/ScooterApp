package pl.edu.wszib.services;

import pl.edu.wszib.model.Scooter;

public interface IScooterServices {
    void addScooter(Scooter scooter);
    Scooter getScooter(int Id);
    void getUpdate(int Id,Scooter scooter);
    void  removeScooterId(int Id);
}
