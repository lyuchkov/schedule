package ru.lyuchkov.service;

import ru.lyuchkov.container.RoomContainer;
import ru.lyuchkov.entity.Room;
import ru.lyuchkov.infostructure.annotations.InjectByType;
import ru.lyuchkov.infostructure.annotations.Singleton;

import java.util.List;

@Singleton
public class RoomService {
    @InjectByType
    RoomContainer roomContainer;

    public RoomService() {
    }

    public boolean add(String name){
        if(roomContainer.containsRoomWithName(name)||name.isEmpty()) return false;
        Room room = new Room(name);
        roomContainer.add(room);
        return true;
    }

   public Room findById(int id){
        return roomContainer.findById(id);
   }
   public List<Room> getAll(){
        return roomContainer.getAll();
   }

   public boolean delete(int id){
        //todo find instance in data class and return if it used
       return false;
   }
}
