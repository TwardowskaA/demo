package a.t.demo;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
public class TaskController {

    private TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/")
    public String homepage(Model model) {
        List<HomeTasker> homeTaskers = taskRepository.getHomeTaskers();
        model.addAttribute("homeTaskers", homeTaskers);
        return "homepage";
    }

    @GetMapping("/dodaj")
    public String showAdd(Model model) {
        model.addAttribute("newTask", new HomeTasker());
        return "dodawanie";
    }

    @PostMapping("/dodaj")
    public String addTask(@RequestParam String opis,
                          @RequestParam String osoba,
                          @RequestParam int punkty,
                          @RequestParam Date dateTimeFormat) {

        HomeTasker homeTasker = new HomeTasker(opis, osoba, punkty, dateTimeFormat);
        taskRepository.addTask(homeTasker);

        return "redirect:/";
    }

    @GetMapping("/edytuj")
    public String edit(Model model, @RequestParam String opis) {

        HomeTasker homeTasker = taskRepository.findByTask(opis);
        model.addAttribute("editTask", homeTasker);

        return "edycja";
    }

    @PostMapping("/edytuj")
    public String editTask(HomeTasker homeTasker){
        return "redirect:/";
    }

    @GetMapping("/zadania")
    public String task(Model model, @RequestParam String opis){
        HomeTasker homeTasker = taskRepository.findByTask(opis);
        model.addAttribute("task", homeTasker);
        return "opis";
    }

}
