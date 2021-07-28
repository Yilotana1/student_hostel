package org.example.student_hostel.domain;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "notification")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message="Заголовок має бути заповнений")
    private String title;

    @NotBlank(message="Текст оголошення має бути заповнений")
    private String text;

    @ManyToOne
    @JoinColumn(name = "author")
    private User author;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
