package io.github.duarte50.e_commerce_restful_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Message {
    @Id @GeneratedValue
    private UUID id;
    @Column(nullable = false)
    private String messageSent;
    @Column(nullable = false)
    private Timestamp datetimeSent;

    @ManyToOne @JoinColumn(nullable = false)
    private User sender;
    @ManyToOne @JoinColumn(nullable = false)
    private User receiver;
}
