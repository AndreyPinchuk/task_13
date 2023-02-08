package homework.task_13;

import homework.task_13.entiti.Note;
import homework.task_13.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Task13Application {
	@Autowired
	private NoteService noteService;

	public static void main(String[] args) {
		SpringApplication.run(Task13Application.class, args);
	}

	@PostConstruct
	public void init(){

		Note note;

		for (int i = 0; i < 8; i++) {
			note= new Note("My "+i+" title","This content");

			noteService.add(note);
		}
	}
}
