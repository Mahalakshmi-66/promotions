package com.example.promotionservice.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "promotions")
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is required")
    @Column(nullable = false, length = 200)
    private String title;

    @NotBlank(message = "Category is required")
    @Column(nullable = false, length = 100)
    private String category;

    @NotNull(message = "Cost points is required")
    @Min(value = 0, message = "Cost points must be >= 0")
    @Column(name = "cost_points", nullable = false)
    private Integer costPoints;

    // Getters and setters (or use Lombok @Data/@Getter/@Setter)
    // Constructors
    public Promotion() {}
    public Promotion(Long id, String title, String category, Integer costPoints) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.costPoints = costPoints;
    }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public Integer getCostPoints() { return costPoints; }
    public void setCostPoints(Integer costPoints) { this.costPoints = costPoints; }
}
