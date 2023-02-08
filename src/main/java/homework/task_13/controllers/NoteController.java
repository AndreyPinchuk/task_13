package homework.task_13.controllers;

import homework.task_13.entiti.Note;
import homework.task_13.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
@RequestMapping("/note")
@Controller
public class NoteController {
    private final NoteService noteService;

    @GetMapping("/list")
    public ModelAndView getAll(){
        ModelAndView result = new ModelAndView("list");
        result.addObject("note", noteService.listAll());
        return result;

    }

    @PostMapping("/delete")
    public void delete(@RequestParam long id,
                               HttpServletResponse resp){
        try {
            noteService.deleteById(id);
            resp.sendRedirect("/note/list");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @GetMapping("/edit")
    public ModelAndView editNoteById(@RequestParam long id){

        ModelAndView result = new ModelAndView("edit");
        return result.addObject(noteService.getById(id));

    }

    @PostMapping("/edit")
    public void edit(@RequestParam String exampleFormControlTitle,
                       String exampleFormControlContent,
                       long id,
                       HttpServletResponse resp){
        Note note = new Note(exampleFormControlTitle, exampleFormControlContent);
        note.setId(id);
        try {
            noteService.update(note);
            resp.sendRedirect("/note/list");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
