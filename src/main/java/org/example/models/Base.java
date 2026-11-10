
package org.example.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;


@Setter
@Getter
@MappedSuperclass
public class Base {
//@GeneratedValue(strategy = GenerationType.IDENTITY)
     @Id
     @GeneratedValue(strategy = GenerationType.UUID)
     private UUID id;
     private LocalDateTime createdAt;
     private LocalDateTime lastUpdatedAt;

     @PrePersist
     protected void onCreate() {
          LocalDateTime now = LocalDateTime.now();
          createdAt = now;
          lastUpdatedAt = now;
     }

     @PreUpdate
     protected void onUpdate() {
          lastUpdatedAt = LocalDateTime.now();
     }
}

