package demo.config;

import demo.model.*;
import demo.repository.ProjectRepository;
import demo.repository.Repository;
import demo.repository.TimeLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;

@Component
public class DatabaseInitializer implements CommandLineRunner {
    @Autowired
    Repository r;

    @Autowired
    TimeLogRepository t;

    @Autowired
    ProjectRepository p;

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Eseguo l'inizializzazione del database...");
        Researcher r1 = new Researcher("Dario","Rossi","user","user");
        Manager m1 = new Manager("Franco","Verdi","root","root");
        r.save(r1);
        r.save(m1);
        ArrayList<Researcher> list_r = new ArrayList<>();
        list_r.add(r1);
        /*
        for(Person r1: r.findAll()){
            System.out.println(r1.getFirstName());
        }
        */
        Project p1 = new Project("ProjectZomboide","29/04/2002","29/04/2025",m1,list_r);
        Project p2 = new Project("Startx","29/04/2002","29/04/2025",m1,list_r);
        Project p3 = new Project("Marketprog","29/04/2002","29/04/2025",m1,list_r);
        Project p4 = new Project("FilesMans","29/04/2002","29/04/2025",m1,list_r);
        p.save(p1);
        p.save(p2);
        p.save(p3);
        p.save(p4);
        t.save(new TimeLog(r1, p1, LocalDate.of(2024,12,18), 4));
        t.save(new TimeLog(r1, p3, LocalDate.of(2014,10,1), 7));
    }
}
