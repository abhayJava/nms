package com.gotprint.nms.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public class AuditableEntity
{
   @Column(name="CREATED_AT")
   @Temporal(TemporalType.TIMESTAMP)
   private Date createdAt;

   @Column(name="UPDATED_AT")
   @Temporal(TemporalType.TIMESTAMP)
   private Date updatedAt;

   public Date getCreatedAt()
   {
      return createdAt;
   }

   public void setCreatedAt(Date createdAt)
   {
      this.createdAt = createdAt;
   }

   public Date getUpdatedAt()
   {
      return updatedAt;
   }

   public void setUpdatedAt(Date updatedAt)
   {
      this.updatedAt = updatedAt;
   }
}
