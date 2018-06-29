package com.gotprint.nms.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "user")
public class User extends AuditableEntity
{

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;

   @Column(name = "PASSWORD", nullable = false)
   private String password;

   @Column(name = "EMAIL_ADDRESS", nullable = false, unique = true)
   @Email
   @NotBlank
   private String emailAddress;

   @OneToMany(mappedBy = "user", cascade = { CascadeType.PERSIST, CascadeType.REMOVE }, fetch = FetchType.LAZY)
   private Set<Note> notes;

   public User() {

   }
   public User(String password, String emailAddress, Set<Note> notes)
   {
      super();
      this.password = password;
      this.emailAddress = emailAddress;
      this.notes = notes;
   }

   public String getPassword()
   {
      return password;
   }

   public void setPassword(String password)
   {
      this.password = password;
   }

   public Long getId()
   {
      return id;
   }

   public void setId(Long id)
   {
      this.id = id;
   }

   public String getEmailAddress()
   {
      return emailAddress;
   }

   public void setEmailAddress(String emailAddress)
   {
      this.emailAddress = emailAddress;
   }

   public Set<Note> getNotes()
   {
      return notes;
   }

   public void setNotes(Set<Note> notes)
   {
      this.notes = notes;
   }

   @Override
   public int hashCode()
   {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((emailAddress == null) ? 0 : emailAddress.hashCode());
      result = prime * result + ((id == null) ? 0 : id.hashCode());
      result = prime * result + ((notes == null) ? 0 : notes.hashCode());
      result = prime * result + ((password == null) ? 0 : password.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj)
   {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      User other = (User) obj;
      if (emailAddress == null)
      {
         if (other.emailAddress != null)
            return false;
      }
      else if (!emailAddress.equals(other.emailAddress))
         return false;
      if (id == null)
      {
         if (other.id != null)
            return false;
      }
      else if (!id.equals(other.id))
         return false;
      if (notes == null)
      {
         if (other.notes != null)
            return false;
      }
      else if (!notes.equals(other.notes))
         return false;
      if (password == null)
      {
         if (other.password != null)
            return false;
      }
      else if (!password.equals(other.password))
         return false;
      return true;
   }

}
