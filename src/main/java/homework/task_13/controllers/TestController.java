package homework.task_13.controllers;

import homework.task_13.entiti.Note;
import homework.task_13.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@Controller
public class TestController {
    private final NoteService noteService;

    @RequestMapping(value = "/test")
    public ModelAndView test(){

        ModelAndView result = new ModelAndView("test");
        System.out.println("Yes");

        Iterable<Note> notes = noteService.listAll();


        result.addObject("note", notes);

        return result;
    }
}
