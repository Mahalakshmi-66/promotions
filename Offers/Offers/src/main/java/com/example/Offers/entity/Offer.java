package com.example.Offers.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Table(name = "offers")
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String title;

    @NotBlank
    @Column(nullable = false)
    private String category;

    @NotBlank
    @Column(nullable = false, length = 500)
    private String description;

    @NotNull
    @Min(0)
    @Column(name = "cost_points", nullable = false)
    private Integer costPoints;

    @NotNull
    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @NotNull
    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @NotBlank
    @Column(name = "tier_level", nullable = false)
    private String tierLevel;   // example: "All", "Silver", "Gold", "Platinum"

    @Column(name = "image_url")
    private String imageUrl;

    // Constructors
    public Offer() {}

    public Offer(Long id, String title, String category, String description,
                 Integer costPoints, LocalDate startDate, LocalDate endDate,
                 String tierLevel, String imageUrl) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.description = description;
        this.costPoints = costPoints;
        this.startDate = startDate;
        this.endDate = endDate;
        this.tierLevel = tierLevel;
        this.imageUrl = imageUrl;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Integer getCostPoints() { return costPoints; }
    public void setCostPoints(Integer costPoints) { this.costPoints = costPoints; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }

    public String getTierLevel() { return tierLevel; }
    public void setTierLevel(String tierLevel) { this.tierLevel = tierLevel; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
}