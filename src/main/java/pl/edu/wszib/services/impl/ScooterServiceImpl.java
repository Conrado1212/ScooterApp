package pl.edu.wszib.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import pl.edu.wszib.dao.IScooterDAO;
import pl.edu.wszib.model.Scooter;
import pl.edu.wszib.services.IScooterServices;

public class ScooterServiceImpl implements IScooterServices {

    @Autowired
    IScooterDAO scooterDAO;

    @Override
   public  void addScooter(Scooter scooter){
       Scooter scooterFromDb = this.scooterDAO.getScooter(scooter.getId());
       if(scooterFromDb == null){
           this.scooterDAO.addScooter(scooter);
       }
   }
   @Override
    public Scooter getScooter(int Id){
       return this.scooterDAO.getScooter(Id);
    }
    @Override
    public void getUpdate(int Id,Scooter scooter){
       Scooter scooterFromDb = this.scooterDAO.getUpdate(Id,scooter);
       if(scooterFromDb == null){
           this.scooterDAO.getUpdate(Id,scooter);
       }
    }
    @Override
    public void  removeScooterId(int Id){
               Scooter scooterFromDb = this.scooterDAO.removeScooterId(Id);
               if(scooterFromDb == null){
                   this.scooterDAO.removeScooterId(Id);
               }
    }

}
