package com.gotprint.nms.controllers;

import java.text.MessageFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gotprint.nms.exception.NMSSecurityException;
import com.gotprint.nms.exception.NMSValidationException;
import com.gotprint.nms.model.Note;
import com.gotprint.nms.repository.NoteRepository;
import com.gotprint.nms.repository.UserRepository;

@RestController
@RequestMapping(value = "nms")
public class NMSController
{

   @Autowired
   UserRepository userRepository;

   @Autowired
   NoteRepository noteRepository;

   @RequestMapping(value = "/note/get/{id}/{userId}", method = RequestMethod.GET)
   public Note getNoteById(@PathVariable Long id, @PathVariable Long userId) throws NMSSecurityException
   {
      // User id to be fetched from session ideally. Passed in URL just to test the authorisation.
      Note note = noteRepository.findById(id).get();
      if (userId.equals(note.getUser().getId()))
      {
         return noteRepository.findById(id).get();
      }
      else
      {
         throw new NMSSecurityException(MessageFormat.format("User {0} unauthorised to access Note {1}", userId, note.getId()));
      }

   }

   @RequestMapping(value = "/note/save",method = RequestMethod.POST)
   public ResponseEntity<?> saveNote(@RequestBody Note note) throws NMSValidationException
   {
      if (note.getId() != null)
      {
         note.setUpdatedAt(Calendar.getInstance().getTime());
      }
      validateNote(note);
      noteRepository.save(note);
      return ResponseEntity.ok().build();
   }

   private void validateNote(Note note) throws NMSValidationException
   {
      // Would be catered by hibernate validator and the validation exception could be wrapped and throw custome exception.
      //Just to cut short time validating here and throwing the exception
      if (StringUtils.isEmpty(note.getTitle()) || note.getTitle().length() < 50)
      {
         throw new NMSValidationException("Invalid Title length");
      }

      if (note.getContent().length() > 1000)
      {
         throw new NMSValidationException("Invalid Note length");
      }
   }

   @RequestMapping(value = "/note/delete/{id}",method=RequestMethod.GET)
   public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long id)
   {
      noteRepository.deleteById(id);
      return ResponseEntity.ok().build();
   }
}
