package homework.task_13.service;

import homework.task_13.entiti.Note;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class NoteService {
    private final Map<Long, Note> someBD;

    public List<Note> listAll(){
        return new ArrayList<Note>(someBD.values());
    }

    public Note add(Note note){
        long id =someBD.size()+1L;
        note.setId(id);
        someBD.putIfAbsent(id, note);
        return note;
    }

    public void deleteById(long id){
        if(someBD.containsKey(id)){
            someBD.remove(id);
        } else {
            throw new RuntimeException("Id not found");
        }
    }

    public void update(Note note){
        if(someBD.containsKey(note.getId())){
            someBD.put(note.getId(),note);
        } else {
            throw new RuntimeException("Note not found");
        }
    }

    public Note getById(long id){
        if (someBD.containsKey(id)){
            return someBD.get(id);
        } else {
            throw new RuntimeException("Id not found");
        }
    }
}
