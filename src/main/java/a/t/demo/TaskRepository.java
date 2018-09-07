package a.t.demo;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepository {

    private List<HomeTasker> homeTaskers;

    public TaskRepository(){
        homeTaskers = new ArrayList<>();
        homeTaskers.add(new HomeTasker("Mycie podłóg","Janek",3,"2020-09-31 18:00"));
        homeTaskers.add(new HomeTasker("Malowanie","Zosia",10,"2020-09-31 18:00"));
        homeTaskers.add(new HomeTasker("Wyniesienie śmieci","Zosia",1,"2020-08-31 09:00"));
    }

    public List<HomeTasker> getHomeTaskers() {
        return homeTaskers;
    }

    public void addTask(HomeTasker homeTasker){
        homeTaskers.add(homeTasker);
    }

    public HomeTasker findByTask(String opis){
        for (HomeTasker homeTasker : homeTaskers) {
            if (homeTasker.getOpis().equals(opis)){
                return homeTasker;
            }
        }
        return null;
    }


}
