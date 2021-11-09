package ru.skillbox.socialnetwork.data.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "notification")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    private NotificationType type;

    @Column(name = "sent_time")
    private LocalDateTime time;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;

    @Column(name = "entity_id")
    private long entityId;

    private String contact;

    public Notification(NotificationType type, LocalDateTime time, Person personNotification, Long entityId, String contact) {
        this.type = type;
        this.time = time;
        this.person = personNotification;
        this.entityId = entityId;
        this.contact = contact;
    }
}
