package com.verizon.bsa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.verizon.bsa.service.BookService;
import com.verizon.bsa.model.Book;

@Controller
public class BookController {

	@Autowired
	private BookService  bookService;
	
	@GetMapping({"","/","home"})
	public ModelAndView defaultBookController(){
		return new ModelAndView("index","books",bookService.getAllBooks());
	}
	
	@GetMapping("/addBook")
	public ModelAndView addBookAction(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bookFormPage");
		mv.addObject("book",new Book());
		mv.addObject("possibCatgs", new String[]{"Novel","SciFi","Manga","Thriller","Romance"});
		mv.addObject("possibTypes", new String[]{"HardCopy","Digital","CD/DVD"});
		return mv;
	}
	@PostMapping("/saveBook")
	public String saveBookAction(@ModelAttribute Book book){
		if(bookService.getBookById(book.getBcode())==null)
				bookService.addBook(book);
		else
			
				bookService.updateBook(book);
		return "redirect:/home";
	}
	@GetMapping("/editBook")
	public ModelAndView editBookAction(@RequestParam("bcode")int bcode){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bookFormPage");
		mv.addObject("book",bookService.getBookById(bcode));
		mv.addObject("possibCatgs", new String[]{"Novel","SciFi","Manga","Thriller","Romance"});
		mv.addObject("possibTypes", new String[]{"HardCopy","Digital","CD/DVD"});
		return mv;
	}
	@GetMapping("/deleteBook")
	public String deleteBookAction(@RequestParam("bcode")int bcode){
		bookService.deleteBookById(bcode);
		return "redirect:/home";
	}
	
}
