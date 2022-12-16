package ru.lyuchkov.service;

import ru.lyuchkov.container.EducatorContainer;
import ru.lyuchkov.entity.Educator;
import ru.lyuchkov.entity.Room;
import ru.lyuchkov.infostructure.annotations.InjectByType;
import ru.lyuchkov.infostructure.annotations.Singleton;

import java.util.List;

@Singleton
public class EducatorService {
    @InjectByType
    EducatorContainer educatorContainer;

    public EducatorService() {
    }

    public boolean add(String name){
        if(educatorContainer.containsEducatorWithName(name)||name.isEmpty()) return false;
        Educator e = new Educator(name);
        educatorContainer.add(e);
        return true;
    }

    public Educator findById(int id){
        return educatorContainer.findById(id);
    }
    public List<Educator> findAllWithNames(List<String> names){
        return educatorContainer.findAllWithNames(names);
    }
    public List<Educator> getAll(){
        return educatorContainer.getAll();
    }

    public boolean delete(int id){
        //todo find instance in data class and return if it used
        return false;
    }
}
