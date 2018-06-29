package com.gotprint.nms.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "NOTE")
public class Note extends AuditableEntity
{
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;

   @Column(name = "TITLE")
   @NotBlank
   @Size(max=50)
   private String title;

   @Column(name = "CONTENT")
   @Size(max=1000)
   private String content;

   @ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.PERSIST)
   @JoinColumn(name = "USER_ID")
   private User user;

   public Note() {
   }

   public Note(String title, String content, User user)
   {
      super();
      this.title = title;
      this.content = content;
      this.user = user;
   }

   public Long getId()
   {
      return id;
   }

   public void setId(Long id)
   {
      this.id = id;
   }

   public String getTitle()
   {
      return title;
   }

   public void setTitle(String title)
   {
      this.title = title;
   }

   public String getContent()
   {
      return content;
   }

   public void setContent(String content)
   {
      this.content = content;
   }

   public User getUser()
   {
      return user;
   }

   public void setUser(User user)
   {
      this.user = user;
   }

   @Override
   public int hashCode()
   {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((content == null) ? 0 : content.hashCode());
      result = prime * result + ((id == null) ? 0 : id.hashCode());
      result = prime * result + ((title == null) ? 0 : title.hashCode());
      result = prime * result + ((user == null) ? 0 : user.hashCode());
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
      Note other = (Note) obj;
      if (content == null)
      {
         if (other.content != null)
            return false;
      }
      else if (!content.equals(other.content))
         return false;
      if (id == null)
      {
         if (other.id != null)
            return false;
      }
      else if (!id.equals(other.id))
         return false;
      if (title == null)
      {
         if (other.title != null)
            return false;
      }
      else if (!title.equals(other.title))
         return false;
      if (user == null)
      {
         if (other.user != null)
            return false;
      }
      else if (!user.equals(other.user))
         return false;
      return true;
   }

}
