package ru.skillbox.socialnetwork.data.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "post")

public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDateTime time;

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Person author;

    private String title;

    @Column(name = "post_text")
    private String textHtml;

    @Column(name = "is_blocked")
    private boolean isBlocked;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PostLike> likes;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PostComment> comments;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "post2tag",
            joinColumns = {@JoinColumn(name = "post_id")},
            inverseJoinColumns = {@JoinColumn(name = "tag_id")})
    private List<Tag> tags;
}
