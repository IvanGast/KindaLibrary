package com.demantic.exercise.controller;

import com.demantic.exercise.LibraryApplication;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = LibraryApplication.PATH)
public class BookController {

}
