package com.spring.codeblog.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Table(name="TB_POST")
@Data
public class CreatePost {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    private String author;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
    private LocalDate date;

    @NotBlank
    @Lob
    private String text;
	
//	@NotBlank para garantir que não terá valor em branco
//	@Lob informa que receberá textos no campo
}
