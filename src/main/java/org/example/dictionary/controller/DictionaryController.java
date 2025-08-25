package org.example.dictionary.controller;

import org.example.dictionary.entity.Dictionary;
import org.example.dictionary.service.DictionaryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class DictionaryController {

    private final DictionaryService dictionaryService;

    public DictionaryController(DictionaryService dictionaryService) {
        this.dictionaryService = dictionaryService;
    }

    @GetMapping("/")
    public String homePage(@RequestParam(value = "search", required = false) String search, Model model) {
        if (search != null && !search.isEmpty()) {
            model.addAttribute("dictionaries", dictionaryService.search(search));
            model.addAttribute("search", search);
        } else {
            model.addAttribute("dictionaries", dictionaryService.getAll());
            model.addAttribute("search", "");
        }
        return "home_page";
    }

    @GetMapping("/dictionary/create")
    public String createPage(Model model) {
        model.addAttribute("dictionary", new Dictionary());
        return "dictionary_create";
    }

    @PostMapping("/dictionary/create")
    public String create(@ModelAttribute Dictionary dictionary) {
        dictionaryService.create(dictionary);
        return "redirect:/";
    }

    @GetMapping("/dictionary/edit/{id}")
    public String editPage(@PathVariable Long id, Model model) {
        Dictionary dictionary = dictionaryService.getById(id);
        model.addAttribute("dictionary", dictionary);
        return "dictionary_update";
    }

    @PostMapping("/dictionary/update")
    public String update(@ModelAttribute Dictionary dictionary) {
        dictionaryService.update(dictionary);
        return "redirect:/";
    }

    @GetMapping("/dictionary/delete/{id}")
    public String delete(@PathVariable Long id) {
        dictionaryService.delete(id);
        return "redirect:/";
    }
}
