package Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@RestController
@RequestMapping("/api/programminglanguages")
public class ProgrammingLanguagesController {
	private ProgrammingLanguageService programmingLanguageService;

	@Autowired
	public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService) {
		this.programmingLanguageService = programmingLanguageService;
	}
	
	@GetMapping("/getall")
	public List<ProgrammingLanguage> getAll(){
		return programmingLanguageService.getAll();
	}
	@GetMapping("/getbyid")
	public ProgrammingLanguage getById() {
		return programmingLanguageService.getById(2);
		
	}
	@GetMapping("/add")
	public  void add() throws Exception {
		ProgrammingLanguage programmingLanguage = new ProgrammingLanguage(4,"C++");
		programmingLanguageService.add(programmingLanguage);
		
	}
	@GetMapping("/delete")
	public void delete() {
		ProgrammingLanguage programmingLanguage = new ProgrammingLanguage(4,"C++");
		programmingLanguageService.delete(programmingLanguage);
		
	}
	@GetMapping("/update")
	public void update() {
		ProgrammingLanguage programmingLanguage = new ProgrammingLanguage(2,"PHP");
		programmingLanguageService.update(programmingLanguage);
		
	}
}
