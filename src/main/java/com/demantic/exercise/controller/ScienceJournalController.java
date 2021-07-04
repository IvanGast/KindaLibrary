package com.demantic.exercise.controller;

import com.demantic.exercise.dto.SortByQuantityDTO;
import com.demantic.exercise.entity.ScienceJournal;
import com.demantic.exercise.service.ScienceJournalService;
import com.demantic.exercise.util.Consts;
import java.util.List;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = Consts.API_PATH)
public class ScienceJournalController {
  private ScienceJournalService scienceJournalService;

  public ScienceJournalController(ScienceJournalService scienceJournalService) {
    this.scienceJournalService = scienceJournalService;
  }

  @PostMapping("/" + Consts.SCIENCE_PATH + "/add")
  public void addBook(@RequestBody ScienceJournal book) {
    scienceJournalService.addBook(book);
  }

  @PutMapping("/" + Consts.SCIENCE_PATH + "/update")
  public void updateBook(@RequestBody @Valid ScienceJournal book) {
    scienceJournalService.updateBook(book);
  }

  @GetMapping("/" + Consts.SCIENCE_PATH + "/sort")
  public List<SortByQuantityDTO> sortByQuantity() {
    return scienceJournalService.sortByQuantity();
  }
}
